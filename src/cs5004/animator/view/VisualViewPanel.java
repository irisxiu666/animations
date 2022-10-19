package cs5004.animator.view;


import cs5004.animator.model.Animation;
import cs5004.animator.model.Document;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeImpl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 * This class represents VisualViewPanel, extending from JPanel class,which is to create panels for
 * visual view.
 */
public class VisualViewPanel extends JPanel {

  private int index;
  private int endTime;
  private final Document doc;
  private ArrayList<LinkedList<Shape>> docObjectList;

  /**
   * Construct a VisualView object.
   *
   * @param doc document that stores the information of animations that can be displayed by visual
   *            view.
   */
  public VisualViewPanel(Document doc) {
    super(true);
    this.setBackground(Color.WHITE);
    this.setMinimumSize(new Dimension(doc.getWidth(), doc.getHeight()));
    this.setLocation(doc.getX(), doc.getY());
    this.doc = doc;
    for (Shape shape : this.doc.getShapes()) {
      if (shape.disappear() > endTime) {
        endTime = shape.disappear();
      }
    }
    initDocObjectList();
  }

  /**
   * Return true if the animation ends, that is when current time is larger than end time, false
   * otherwise.
   *
   * @return true if the animation ends.
   */
  public boolean isEnd() {
    return this.index >= endTime;
  }

  /**
   * Set current time/index (smaller than end time),so that we can get any states.
   *
   * @param x the time or index to be set.
   */
  public void setIndex(int x) {
    if (x <= endTime) {
      this.index = x;
    }
  }

  /**
   * Increase the index/time to make animation forward.
   */
  public void increaseIndex() {
    if (!isEnd()) {
      this.index += 1;
    }
  }

  /**
   * A helper function to help initialize the list of doc objects.
   */
  private void initDocObjectList() {
    docObjectList = new ArrayList<>(endTime + 1);
    for (int i = 0; i <= endTime; i++) {
      docObjectList.add(new LinkedList<>());
    }
    for (Animation animation : doc.getAnimations()) {
      int t1 = animation.appear();
      int t2 = animation.disappear();
      Shape originalShape = doc.getNameToShape().get(animation.getName());
      for (int i = t1; i <= t2; i++) {
        Shape shape = new ShapeImpl(originalShape.getType(), originalShape.getName(), i,
            getState(animation.getStartX(), animation.getEndX(), i, t1, t2),
            getState(animation.getStartY(), animation.getEndY(), i, t1, t2),
            getState(animation.getStartScaleX(), animation.getEndScaleX(), i, t1, t2),
            getState(animation.getStartScaleY(), animation.getEndScaleY(), i, t1, t2),
            getState(animation.getStartColorR(), animation.getEndColorR(), i, t1, t2),
            getState(animation.getStartColorG(), animation.getEndColorG(), i, t1, t2),
            getState(animation.getStartColorB(), animation.getEndColorB(), i, t1, t2));
        docObjectList.get(i).add(shape);
      }
    }
  }

  /**
   * A helper function to get the state of animations in linear.
   *
   * @param start start state of the animation.
   * @param end   end state of the animation.
   * @param t     any time between start time and end time.
   * @param t1    the start time of current animation.
   * @param t2    the start time of current animation.
   * @return the state of animations in linear.
   */
  private int getState(int start, int end, int t, int t1, int t2) {
    if (t1 == t2) {
      return start;
    }
    return (int) (start * ((float) (t2 - t) / (float) (t2 - t1))
        + end * ((float) (t - t1) / (float) (t2 - t1)));
  }

  /**
   * A helper function to help paint shapes.
   *
   * @param g2d   represents 2D shapes.
   * @param shape any shapes to be painted.
   */
  private void paintShape(Graphics2D g2d, Shape shape) {
    if (shape.getType().equals("rectangle")) {
      g2d.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
      g2d.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    } else if (shape.getType().equals("ellipse")) {
      g2d.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
      g2d.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }
  }

  /**
   * For every state,painting shapes continuously.
   *
   * @param g represents Graphics shapes.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Shape shape : docObjectList.get(this.index)) {
      paintShape(g2d, shape);
    }
  }
}
