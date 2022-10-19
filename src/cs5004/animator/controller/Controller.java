package cs5004.animator.controller;

import java.io.IOException;

/**
 * This interface represents Controller, which is the controller of
 * the whole project.
 */
public interface Controller {

  /**
   * Call the show function of views according to user input.
   */
  void playAnimation() throws IOException;

}
