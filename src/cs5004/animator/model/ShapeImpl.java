package cs5004.animator.model;

/**
 * This class represents ShapeImpl, which implements
 * shape interface, and store static state information of the shape.
 */
public class ShapeImpl implements Shape {

  protected String name;
  protected int startTime;
  protected int endTime;
  protected int x;
  protected int y;
  protected int scaleX;
  protected int scaleY;

  protected int r;
  protected int g;
  protected int b;

  protected String type;

  /**
   * Construct a ShapeImpl object with name and type fields.(It will be used when
   * first create the shape.)
   *
   * @param type the type of the shape.
   * @param name the name of the shape.
   */
  public ShapeImpl(String type, String name) {
    this.type = type;
    this.name = name;
    this.startTime = -1;
  }

  /**
   * Update the information of the shape after motions are added.
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
  public void update(String type, String name, int t1, int x,
                     int y, int width, int height, int r, int g, int b) {
    this.type = type;
    this.name = name;
    this.startTime = t1;
    this.x = x;
    this.y = y;
    this.scaleX = width;
    this.scaleY = height;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Construct a ShapeImpl object with all fields.
   *
   * @param type   the type of the ShapeImpl.
   * @param name   the name of the ShapeImpl.
   * @param t1     the appearance time of the ShapeImpl.
   * @param x      the x position of the ShapeImpl.
   * @param y      the y position of the ShapeImpl.
   * @param width  the length in x scale of the ShapeImpl.
   * @param height the length in y scale of the ShapeImpl.
   * @param r      the r color value of the shape.
   * @param g      the g color value of the shape.
   * @param b      the b color value of the shape.
   */
  public ShapeImpl(String type, String name, int t1, int x, int y,
                   int width, int height, int r, int g, int b) {
    update(type, name, t1, x, y, width, height, r, g, b);
  }

  /**
   * Get the type of the shape.
   *
   * @return the type of the shape.
   */
  @Override
  public String getType() {
    return type;
  }

  /**
   * Set the type of the shape.
   *
   * @param type the type of the shape to be set.
   */
  @Override
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Set the start time of the shape.
   *
   * @param startTime the start time of the shape to be set.
   */
  @Override
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  /**
   * Get the length in the x scale of the shape.
   *
   * @return the length in the x scale of the shape.
   */
  @Override
  public int getWidth() {
    return this.scaleX;
  }

  /**
   * Get the x position of the shape.
   *
   * @return the x position of the shape.
   */
  @Override
  public int getX() {
    return x;
  }

  /**
   * Get the y position of the shape.
   *
   * @return the y position of the shape.
   */
  @Override
  public int getY() {
    return y;
  }

  /**
   * Get the r color value of the shape.
   *
   * @return the r color value of the shape.
   */
  @Override
  public int getR() {
    return r;
  }

  /**
   * Get the g color value of the shape.
   *
   * @return the g color value of the shape.
   */
  @Override
  public int getG() {
    return g;
  }

  /**
   * Get the b color value of the shape.
   *
   * @return the b color value of the shape.
   */
  @Override
  public int getB() {
    return b;
  }

  /**
   * Get the length in the y scale of the shape.
   *
   * @return the length in the y scale of the shape.
   */
  @Override
  public int getHeight() {
    return this.scaleY;
  }

  /**
   * Set the end time of the shape.
   *
   * @param endTime the end time of the shape to be set.
   */
  @Override
  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  /**
   * Get the name the shape.
   *
   * @return the name of the shape.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Get the first appear time of the shape.
   *
   * @return the first appear time of the shape.
   */
  @Override
  public int appear() {
    return this.startTime;
  }

  /**
   * Get the disappearance time of the shape.
   *
   * @return the disappearance time of the shape.
   */
  @Override
  public int disappear() {
    return this.endTime;
  }

  @Override
  public String toString() {
    return String.format("The type of the shape is %s, the name of the shape is %s",
            this.type, this.name);
  }

}
