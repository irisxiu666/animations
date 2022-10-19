package cs5004.animator;


import cs5004.animator.controller.AnimationController;
import java.io.IOException;

/**
 * Main class for the whole project.
 */
public final class EasyAnimator {

  /**
   * Main function of the whole project.
   *
   * @param args inputs from users.
   * @throws IllegalArgumentException thrown when get invalid inputs from users.
   * @throws IOException              thrown when create and write svg files failed.
   */
  public static void main(String[] args) throws IllegalArgumentException, IOException {
    String in = "";
    String view = "";
    String out = "";
    int speed = 1;
    for (int i = 0; i < args.length; i++) {
      if (args[i].startsWith("-in")) {
        in = args[i + 1];
      } else if (args[i].startsWith("-view")) {
        view = args[i + 1];
      } else if (args[i].startsWith("-out")) {
        out = args[i + 1];
      } else if (args[i].startsWith("-speed")) {
        speed = Integer.parseInt(args[i + 1]);
      }
    }
    if (in.equals("") || view.equals("")) {
      throw new IllegalArgumentException("in and view are mandatory");
    }

    AnimationController controller = new AnimationController(in, view, out, speed);
    controller.playAnimation();
  }

}
