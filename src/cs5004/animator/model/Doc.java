package cs5004.animator.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a growing Doc, that stores information
 * of animations, which implements Document interface.
 */
public class Doc implements Document {
  private List<Shape> shapes;
  private List<Animation> animations;
  private HashMap<String, Shape> nameToShape;
  private HashMap<String, List<Animation>> nameToAnimations;
  private int x;
  private int y;
  private int width;
  private int height;

  /**
   * Construct a Doc object.
   */
  public Doc() {
    shapes = new LinkedList<>();
    animations = new LinkedList<>();
    nameToShape = new HashMap<>();
    nameToAnimations = new HashMap<>();
  }

  /**
   * Get the hashmap which maps the name of shapes to specific shapes.
   *
   * @return the hashmap which map the name of shapes specific to shape.
   */
  public HashMap<String, Shape> getNameToShape() {
    return this.nameToShape;
  }

  /**
   * Get the hashmap which maps the name of shapes to specific animations.
   *
   * @return the hashmap which map the name of shapes specific to animations.
   */
  public HashMap<String, List<Animation>> getNameToAnimations() {
    return nameToAnimations;
  }

  /**
   * Get the x position of the left down corner of the doc.
   *
   * @return the x position of the left down corner of the doc.
   */
  public int getX() {
    return x;
  }


  /**
   * Get the y position of the left down corner of the doc.
   *
   * @return the y position of the left down corner of the doc.
   */
  public int getY() {
    return y;
  }

  /**
   * Get the width of the doc.
   *
   * @return the width of the doc.
   */
  public int getWidth() {
    return width;
  }


  /**
   * Get the height of the doc.
   *
   * @return the height of the doc.
   */
  public int getHeight() {
    return height;
  }


  /**
   * Add shapes to the list of shapes, and also add the name-shape to the hashmap.
   *
   * @param shape shape that to be added to the list of shapes and the hashmap.
   */
  @Override
  public void addShape(Shape shape) {
    shapes.add(shape);
    nameToShape.put(shape.getName(), shape);
  }

  /**
   * Add the animation to the list of animations, and also add the name-animation
   * to the hashmap.
   *
   * @param animation the animation to be added to the list of animations and the hashmap.
   */
  @Override
  public void addAnimation(Animation animation) {
    animations.add(animation);
    List<Animation> list;
    if (!nameToAnimations.containsKey(animation.getName())) {
      list = new LinkedList<>();
      list.add(animation);
      nameToAnimations.put(animation.getName(), list);
    } else {
      nameToAnimations.get(animation.getName()).add(animation);
    }
  }

  /**
   * Specify the bounding box to be used for the animation.
   *
   * @param x      the left down x position of the box for the animation.
   * @param y      the left down y position of the box for the animation.
   * @param width  the max width of the box for the animation.
   * @param height the max height of the box for the animation.
   */
  @Override
  public void setBounds(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Get the list of shapes.
   *
   * @return the list of shapes.
   */
  @Override
  public List<Shape> getShapes() {
    return this.shapes;
  }

  /**
   * Get the list of animations.
   *
   * @return the list of animations.
   */
  @Override
  public List<Animation> getAnimations() {
    return this.animations;
  }

  /**
   * Decide whether shapes are out of bound of the animation box,
   * true if they are, false otherwise.
   *
   * @param shapeX      the left down x position of the shape.
   * @param shapeY      the left down y position of the shape.
   * @param shapeWidth  the width of the shape.
   * @param shapeHeight the height of the shape.
   * @return true if the shape is out of bound when play animations.
   */
  @Override
  public boolean isShapeOutOfBound(int shapeX, int shapeY, int shapeWidth, int shapeHeight) {

    return !(shapeX >= x && shapeY >= y && shapeWidth - Math.abs(shapeX) <= width - Math.abs(x)
            && shapeHeight - Math.abs(shapeY) <= height - Math.abs(y));
  }

}
