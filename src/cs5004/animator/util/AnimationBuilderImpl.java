package cs5004.animator.util;

import java.util.HashMap;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Doc;
import cs5004.animator.model.Document;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeImpl;

/**
 * This class represents AnimationBuilderImpl, which implements
 * AnimationBuilder class.
 */
public class AnimationBuilderImpl implements AnimationBuilder<Document> {
  private Document doc;
  private HashMap<String, Shape> shape_map;

  /**
   * Construct a AnimationBuilderImpl object.
   */
  public AnimationBuilderImpl() {
    this.shape_map = new HashMap<>();
    this.doc = new Doc();
  }

  /**
   * Get the doc in this AnimationBuilderImpl object.
   *
   * @return the doc in this AnimationBuilderImpl object.
   */
  @Override
  public Document build() {
    return this.doc;
  }

  /**
   * Specify the bounding box to be used for the animation.
   *
   * @param x      The leftmost x value.
   * @param y      The topmost y value.
   * @param width  The width of the bounding box.
   * @param height The height of the bounding box.
   * @return This {@link AnimationBuilder}.
   */
  @Override
  public AnimationBuilder<Document> setBounds(int x, int y, int width, int height) {
    this.doc.setBounds(x, y, width, height);
    return this;
  }

  /**
   * Adds a new shape to the growing document.
   *
   * @param name The unique name of the shape to be added.
   *             No shape with this name should already exist.
   * @param type The type of shape (e.g. "ellipse", "rectangle") to be added.
   *             The set of supported shapes is unspecified, but should
   *             include "ellipse" and "rectangle" as a minimum.
   * @return This {@link AnimationBuilder}.
   */
  @Override
  public AnimationBuilder<Document> declareShape(String name, String type) {
    if (shape_map.containsKey(name)) {
      throw new IllegalArgumentException("shape already exists.");
    } else {
      Shape shape = new ShapeImpl(type, name);
      shape_map.put(name, shape);
      this.doc.addShape(shape);
    }
    return this;
  }

  /**
   * Adds a transformation to the growing document.
   *
   * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   * @return This {@link AnimationBuilder}
   */
  @Override
  public AnimationBuilder<Document> addMotion(String name, int t1, int x1,
                                              int y1, int w1, int h1, int r1,
                                              int g1, int b1, int t2, int x2,
                                              int y2, int w2, int h2, int r2, int g2, int b2) {
    if (!shape_map.containsKey(name)) {
      // report error
      throw new IllegalArgumentException("No shape: " + name + " exists.");
    } else {
      // update shape
      Shape shape = shape_map.get(name);
      if (shape.appear() == -1) {
        shape.update(shape.getType(), name, t1, x1, y1, w1, h1, r1, g1, b1);
      }

      if (t1 < shape.appear()) {
        shape.setStartTime(t1);
      }
      if (t2 > shape_map.get(name).disappear()) {
        shape.setEndTime(t2);
      }

      // different cases for animations
      Animation animation = new AnimationImpl(name, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x2, y2, w2, h2, r2, g2, b2);
      this.doc.addAnimation(animation);
    }
    return this;
  }
}
