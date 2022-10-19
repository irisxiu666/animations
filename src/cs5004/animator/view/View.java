package cs5004.animator.view;

import cs5004.animator.model.Document;

import java.io.IOException;

/**
 * This interface represents View part of the animation.
 * And only have a function that is to show the animation.
 */
public interface View {

  /**
   * Show the final animation.
   * @param doc the model of this project.
   * @throws IOException thrown when errors happen during create and write files.
   */
  void show(Document doc) throws IOException;
}

