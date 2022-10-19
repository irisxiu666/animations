package cs5004.animator.controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import cs5004.animator.model.Document;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.EditableView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;

/**
 * This class represents AnimationController, which implements Controller
 * interface, and it will call specific views according to user input.
 */
public class AnimationController extends MouseAdapter implements Controller {

  private View view;
  private Document doc;

  /**
   * Construct a AnimationController object.
   *
   * @param in       the input command line of users.
   * @param viewName which view the user chooses, including text,visual,svg and playback.
   * @param out      the output file in SVGView.
   * @param speed    the speed that the user chooses to play the animations.
   * @throws FileNotFoundException thrown when error happens during reading information from input.
   */
  public AnimationController(String in, String viewName, String out, int speed)
          throws FileNotFoundException, IllegalArgumentException {
    Readable file = new FileReader(in);
    AnimationBuilder<Document> builder = new AnimationBuilderImpl();
    AnimationReader.parseFile(file, builder);
    doc = builder.build();

    switch (viewName) {
      case "text":
        view = new TextualView();
        break;
      case "svg":
        view = new SVGView(out);
        break;
      case "visual":
        view = new VisualView();
        break;
      case "playback":
        view = new EditableView(speed);
        EditableView editable_view = (EditableView) view;
        editable_view.addMouseListener(this);
        break;
      default:
        throw new IllegalArgumentException("No such view");
    }
  }

  /**
   * Call the show function of views.
   *
   * @throws IOException thrown when errors happen show animation by SVG view.
   */
  @Override
  public void playAnimation() throws IOException {
    view.show(doc);
  }

  /**
   * Get the View of this controller.
   *
   * @return the View of this controller.
   */
  public View getView() {
    return this.view;
  }

  /**
   * Achieve the function that the user can control the animation by mouse.
   *
   * @param e the mouse clicked event.
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    EditableView editable_view = (EditableView) view;
    if (editable_view.isPaused()) {
      editable_view.resume();
    } else {
      editable_view.pause();
    }
  }
}
