package cs5004.animator.view;

import java.util.List;

import cs5004.animator.model.Document;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Animation;

/**
 * This class represents TextualView that implements the
 * View interface, which will show animation by texts.
 */
public class TextualView implements View {
  private String output = "";

  /**
   * Show the animation by texts.
   *
   * @param document the information of animations stored.
   */
  @Override
  public void show(Document document) {

    List<Shape> shapes = document.getShapes();
    List<Animation> animations = document.getAnimations();


    for (Shape shape : shapes) {
      // print Create
      this.output += String.format("Create %s %s with corner at (%d,%d), "
                      + "width %d and height %d\n", shape.getType(), shape.getName(), shape.getX(),
              shape.getY(), shape.getWidth(), shape.getHeight());
    }

    this.output += "\n";
    for (Shape shape : shapes) {
      // print appears/disappears
      this.output += shape.getName() + String.format(" appears at time "
              + "t=%d and disappears at time t=%d", shape.appear(), shape.disappear());

      this.output += "\n";

    }

    this.output += "\n";
    for (Animation animation : animations) {

      int originalX = animation.getStartX();
      int originalY = animation.getStartY();
      int originalScaleX = animation.getStartScaleX();
      int originalScaleY = animation.getStartScaleY();
      int originalColorR = animation.getStartColorR();
      int originalColorG = animation.getStartColorG();
      int originalColorB = animation.getStartColorB();

      switch (animation.getType()) {
        case "move":
          this.output += String.format("%s moves from (%d,%d) to (%d,%d) from time "
                          + "t=%d to t=%d\n", animation.getName(),
                  originalX, originalY, animation.getEndX(),
                  animation.getEndY(), animation.appear(), animation.disappear());
          break;
        case "scale":
          if (originalScaleX != animation.getEndScaleX()) {
            this.output += String.format("%s changes width from %d to %d from time "
                            + "t=%d to t=%d\n", animation.getName(),
                    originalScaleX, animation.getEndX(), animation.appear(), animation.disappear());
          } else if (originalScaleY != animation.getEndScaleY()) {
            this.output += String.format("%s changes height from %d to %d from time "
                            + "t=%d to t=%d\n", animation.getName(),
                    originalScaleY, animation.getEndScaleY(), animation.appear(),
                animation.disappear());
          }
          break;
        case "color":
          this.output += String.format("%s changes from (%d,%d,%d) to (%d,%d,%d) from time "
                          + "t=%d to t=%d\n", animation.getName(),
                  originalColorR, originalColorG, originalColorB,
                  animation.getEndColorR(), animation.getEndColorG(), animation.getEndColorB(),
                  animation.appear(), animation.disappear());
          break;
        default:
          break;
      }
    }
    System.out.println(this.output);
  }

  /**
   * A string to represent this object.
   *
   * @return the string to represent this object.
   */
  @Override
  public String toString() {
    return this.output;
  }
}
