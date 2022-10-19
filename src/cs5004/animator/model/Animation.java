package cs5004.animator.model;

/**
 * This class represents Animation interface,which will store start state
 * and end start of shapes in an animation.
 */
public interface Animation {

  /**
   * Get the start time of the animation.
   *
   * @return the start time of the animation.
   */
  int appear();

  /**
   * Get the end time of the animation.
   *
   * @return the end time of the animation.
   */
  int disappear();

  /**
   * Get the name of shapes in the animation.
   *
   * @return the name of shapes in the animation.
   */
  String getName();

  /**
   * Get the start x position of the animation.
   *
   * @return the start x position of the animation.
   */
  int getStartX();

  /**
   * Get the end x position of the animation.
   *
   * @return the end x position of the animation.
   */
  int getEndX();

  /**
   * Get the start y position of the animation.
   *
   * @return the start y position of the animation.
   */
  int getStartY();

  /**
   * Get the end y position of the animation.
   *
   * @return the end y position of the animation.
   */
  int getEndY();

  /**
   * Get the start length in x scale of the animation.
   *
   * @return Get the start length in x scale of the animation.
   */
  int getStartScaleX();

  /**
   * Get the end length in x scale of the animation.
   *
   * @return Get the end length in x scale of the animation.
   */
  int getEndScaleX();

  /**
   * Get the start length in y scale of the animation.
   *
   * @return Get the start length in y scale of the animation.
   */
  int getStartScaleY();

  /**
   * Get the end length in y scale of the animation.
   *
   * @return Get the end length in y scale of the animation.
   */
  int getEndScaleY();

  /**
   * Get the start r color value of the animation.
   *
   * @return the start r color value of the animation.
   */
  int getStartColorR();

  /**
   * Get the end r color value of the animation.
   *
   * @return the end r color value of the animation.
   */
  int getEndColorR();

  /**
   * Get the start g color value of the animation.
   *
   * @return the start g color value of the animation.
   */
  int getStartColorG();

  /**
   * Get the end g color value of the animation.
   *
   * @return the end g color value of the animation.
   */
  int getEndColorG();

  /**
   * Get the start b color value of the animation.
   *
   * @return the start b color value of the animation.
   */
  int getStartColorB();

  /**
   * Get the end b color value of the animation.
   *
   * @return the end b color value of the animation.
   */
  int getEndColorB();

  /**
   * Get the type of the animation.
   *
   * @return the type of the animation.
   */
  String getType();

  /**
   * Set the type of the animation.
   */
  void setType(String type);

  /**
   * Represent this animation by a string.
   *
   * @return a string to represents this animation.
   */
  String toString();
}
