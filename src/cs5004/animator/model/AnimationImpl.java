package cs5004.animator.model;

/**
 * This class represents AnimationImpl, which implements Animation interface
 * to store the start state and the end state of any shapes.
 */
public class AnimationImpl implements Animation {

  protected String shapeName;
  protected int startTime;
  protected int endTime;
  protected int startX;
  protected int startY;
  protected int startScaleX;
  protected int startScaleY;
  protected int startColorR;
  protected int startColorG;
  protected int startColorB;
  protected int endX;
  protected int endY;
  protected int endScaleX;
  protected int endScaleY;
  protected int endColorR;
  protected int endColorG;
  protected int endColorB;

  protected String type;

  /**
   * Constructs a AnimationImp objects with all its fields.
   *
   * @param name the name of the shapes playing animation.
   * @param t1   the start time of the animation.
   * @param x1   the start x position of the animation.
   * @param y1   the start y position of the animation.
   * @param w1   the start length in x scale of the shape in the animation.
   * @param h1   the start length in y scale of the shape in the animation.
   * @param r1   the start r color value of the shape in the animation.
   * @param g1   the start g color value of the shape in the animation.
   * @param b1   the start b color value of the shape in the animation.
   * @param t2   the end time of the animation.
   * @param x2   the end x position of the animation.
   * @param y2   the end y position of the animation.
   * @param w2   the end length in x scale of the shape in the animation.
   * @param h2   the end length in y scale of the shape in the animation.
   * @param r2   the end r color value of the shape in the animation.
   * @param g2   the end g color value of the shape in the animation.
   * @param b2   the end b color value of the shape in the animation.
   */
  public AnimationImpl(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                       int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.shapeName = name;
    this.startTime = t1;
    this.startX = x1;
    this.startY = y1;
    this.startScaleX = w1;
    this.startScaleY = h1;
    this.startColorR = r1;
    this.startColorG = g1;
    this.startColorB = b1;
    this.endTime = t2;
    this.endX = x2;
    this.endY = y2;
    this.endScaleX = w2;
    this.endScaleY = h2;
    this.endColorR = r2;
    this.endColorG = g2;
    this.endColorB = b2;

    if (x1 != x2 || y1 != y2) {
      this.type = "move";
    } else if (w1 != w2 || h1 != h2) {
      this.type = "scale";
    } else if (r1 != r2 || g1 != g2 || b1 != b2) {
      this.type = "color";
    } else {
      this.type = "create";
    }
  }


  /**
   * Get the type of the animation.
   *
   * @return the type of the animation.
   */
  @Override
  public String getType() {
    return type;
  }

  /**
   * Set the type of the animation shape.
   *
   * @param type the type of the shape that to be set.
   */
  @Override
  public void setType(String type) {
    this.type = type;
  }


  /**
   * Get the appearance time of the animation.
   *
   * @return the appearance time of the animation.
   */
  @Override
  public int appear() {
    return this.startTime;
  }

  /**
   * Get the disappearance time of the animation.
   *
   * @return the disappearance time of the animation.
   */
  @Override
  public int disappear() {
    return this.endTime;
  }

  /**
   * Get the name of the animation shape.
   *
   * @return the name of the animation shape.
   */
  @Override
  public String getName() {
    return this.shapeName;
  }

  /**
   * Get the start X position of the shape.
   *
   * @return the start X position of the shape.
   */
  @Override
  public int getStartX() {
    return this.startX;
  }

  /**
   * Get the end X position of the shape.
   *
   * @return the end X position of the shape.
   */
  @Override
  public int getEndX() {
    return this.endX;
  }

  /**
   * Get the start Y position of the shape.
   *
   * @return the start Y position of the shape.
   */
  @Override
  public int getStartY() {
    return this.startY;
  }

  /**
   * Get the end Y position of the shape.
   *
   * @return the end Y position of the shape.
   */
  @Override
  public int getEndY() {
    return this.endY;
  }

  /**
   * Get the start length of the shape in x-axis.
   *
   * @return the start length of the shape in x-axs.
   */
  @Override
  public int getStartScaleX() {
    return this.startScaleX;
  }

  /**
   * Get the end length of the shape in x-axis.
   *
   * @return the end length of the shape in x-axs.
   */
  @Override
  public int getEndScaleX() {
    return this.endScaleX;
  }

  /**
   * Get the start length of the shape in y-axis.
   *
   * @return the start length of the shape in y-axis.
   */
  @Override
  public int getStartScaleY() {
    return this.startScaleY;
  }

  /**
   * Get the end length of the shape in y-axis.
   *
   * @return the end length of the shape in y-axs.
   */
  @Override
  public int getEndScaleY() {
    return this.endScaleY;
  }

  /**
   * Get the r color value of the shape in the beginning.
   *
   * @return the r color value of the shape in the beginning.
   */
  @Override
  public int getStartColorR() {
    return this.startColorR;
  }

  /**
   * Get the r color value of the shape in the end.
   *
   * @return the r color value of the shape in the end.
   */
  @Override
  public int getEndColorR() {
    return this.endColorR;
  }

  /**
   * Get the g color value of the shape in the beginning.
   *
   * @return the g color value of the shape in the beginning.
   */
  @Override
  public int getStartColorG() {
    return this.startColorG;
  }

  /**
   * Get the g color value of the shape in the end.
   *
   * @return the g color value of the shape in the end.
   */
  @Override
  public int getEndColorG() {
    return this.endColorG;
  }

  /**
   * Get the b color value of the shape in the beginning.
   *
   * @return the b color value of the shape in the beginning.
   */
  @Override
  public int getStartColorB() {
    return this.startColorB;
  }

  /**
   * Get the b color value of the shape in the end.
   *
   * @return the b color value of the shape in the end.
   */
  @Override
  public int getEndColorB() {
    return this.endColorB;
  }

  @Override
  public String toString() {
    return String.format("The type of this animation is %s, this animation "
            + "belongs to shape %s", this.type, this.shapeName);
  }

}
