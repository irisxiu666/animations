package cs5004.animator.model;

import java.util.HashMap;
import java.util.List;

/**
 * This interface is to store information of animations read from files.
 */
public interface Document {

  /**
   * Add shapes to the list of shapes, and also add the name-shape to the hashmap.
   *
   * @param shape shape that to be added to the list of shapes and the hashmap.
   */
  void addShape(Shape shape);

  /**
   * Add the animation to the list of animations, and also add the name-animation
   * to the hashmap.
   *
   * @param animation the animation to be added to the list of animations and the hashmap.
   */
  void addAnimation(Animation animation);

  /**
   * Specify the bounding box to be used for the animation.
   *
   * @param x      the left down x position of the box for the animation.
   * @param y      the left down y position of the box for the animation.
   * @param width  the max width of the box for the animation.
   * @param height the max height of the box for the animation.
   */
  void setBounds(int x, int y, int width, int height);

  /**
   * Get the list of shapes.
   *
   * @return the list of shapes.
   */
  List<Shape> getShapes();

  /**
   * Get the list of animations.
   *
   * @return the list of animations.
   */
  List<Animation> getAnimations();

  /**
   * Get the hashmap which maps the name of shapes to specific shapes.
   *
   * @return the hashmap which map the name of shapes specific to shape.
   */
  HashMap<String, Shape> getNameToShape();

  /**
   * Get the hashmap which maps the name of shapes to specific animations.
   *
   * @return the hashmap which map the name of shapes specific to animations.
   */
  HashMap<String, List<Animation>> getNameToAnimations();

  /**
   * Get the x position of the left down corner of the doc.
   *
   * @return the x position of the left down corner of the doc.
   */
  int getX();

  /**
   * Get the y position of the left down corner of the doc.
   *
   * @return the y position of the left down corner of the doc.
   */
  int getY();



  /**
   * Get the width of the doc.
   *
   * @return the width of the doc.
   */
  int getWidth();

  /**
   * Get the height of the doc.
   *
   * @return the height of the doc.
   */
  int getHeight();

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
  boolean isShapeOutOfBound(int shapeX, int shapeY, int shapeWidth, int shapeHeight);

}
