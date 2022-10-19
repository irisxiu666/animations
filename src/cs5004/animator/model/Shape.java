package cs5004.animator.model;

/**
 * This interface represents Shape, which will store
 * the static state information of a shape.
 */
public interface Shape {

  /**
   * Get the x position of the shape.
   *
   * @return the x position of the shape.
   */
  int getX();

  /**
   * Get the y position of the shape.
   *
   * @return the y position of the shape.
   */
  int getY();

  /**
   * Get the r color value of the shape.
   *
   * @return the r color value of the shape.
   */
  int getR();

  /**
   * Get the g color value of the shape.
   *
   * @return the g color value of the shape.
   */
  int getG();

  /**
   * Get the b color value of the shape.
   *
   * @return the b color value of the shape.
   */
  int getB();


  /**
   * Get the length in the x scale of the shape.
   *
   * @return the length in the x scale of the shape.
   */
  int getWidth();

  /**
   * Get the length in the y scale of the shape.
   *
   * @return the length in the y scale of the shape.
   */
  int getHeight();

  /**
   * Get the name the shape.
   *
   * @return the name of the shape.
   */
  String getName();

  /**
   * Set the start time of the shape.
   *
   * @param startTime the start time of the shape to be set.
   */
  void setStartTime(int startTime);

  /**
   * Set the end time of the shape.
   *
   * @param endTime the end time of the shape to be set.
   */
  void setEndTime(int endTime);

  /**
   * Get the first appear time of the shape.
   *
   * @return the first appear time of the shape.
   */
  int appear();

  /**
   * Get the disappearance time of the shape.
   *
   * @return the disappearance time of the shape.
   */
  int disappear();

  /**
   * Set the type of the shape.
   *
   * @param type the type of the shape to be set.
   */
  void setType(String type);

  /**
   * Get the type of the shape.
   *
   * @return the type of the shape.
   */
  String getType();

  /**
   * Update the state information of the shape.
   *
   * @param type   new type of the shape to be updated.
   * @param name   new name of the shape to be updated.
   * @param t1     new appearance time of the shape to be updated.
   * @param x      new x position of the shape to be updated.
   * @param y      new y position of the shape to be updated.
   * @param width  new length in x scale of the shape to be updated.
   * @param height new length in y scale of the shape to be updated.
   * @param r      new r color value of the shape to be updated.
   * @param g      new g color value of the shape to be updated.
   * @param b      new b color value of the shape to be updated.
   */
  void update(String type, String name, int t1, int x, int y,
              int width, int height, int r, int g, int b);

  /**
   * Represent this shape by a string.
   * @return a string to represents this shape.
   */
  String toString();
}
