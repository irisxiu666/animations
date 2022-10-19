import static org.junit.Assert.assertTrue;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.model.Document;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.EditableView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.View;
import cs5004.animator.view.VisualView;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.Test;

/**
 * This class is to test whether controller works properly.
 */
public class ControllerTest {

  /**
   * Test whether controller can cast view interface to specific view class.
   *
   * @throws FileNotFoundException thrown when reading files unsuccessfully.
   */
  @Test
  public void testValidCastView() throws FileNotFoundException {
    String in = "smalldemo.txt";
    String viewName = "visual";
    String out = "fileName";
    int speed = 10;
    AnimationController controller = new AnimationController(in,
        viewName, out, speed);
    Readable file = new FileReader(in);
    AnimationBuilder<Document> builder = new AnimationBuilderImpl();
    AnimationReader.parseFile(file, builder);
    builder.build();

    View view = controller.getView();
    assertTrue(view instanceof VisualView);

    viewName = "playback";
    controller = new AnimationController(in, viewName, out, speed);
    view = controller.getView();
    assertTrue(view instanceof EditableView);

    viewName = "svg";
    controller = new AnimationController(in, viewName, out, speed);
    view = controller.getView();
    assertTrue(view instanceof SVGView);

    viewName = "text";
    controller = new AnimationController(in, viewName, out, speed);
    view = controller.getView();
    assertTrue(view instanceof TextualView);
  }

  /**
   * To test whether exception can be thrown when users' commands are invalid.
   *
   * @throws FileNotFoundException thrown when reading files unsuccessfully.
   */
  @Test
  public void testInvalidCastView() throws FileNotFoundException {
    String in = "smalldemo.txt";
    String viewName = "abc";
    String out = "fileName";
    int speed = 10;
    Readable file = new FileReader(in);
    AnimationBuilder<Document> builder = new AnimationBuilderImpl();
    AnimationReader.parseFile(file, builder);
    builder.build();
    boolean thrown = false;
    try {
      AnimationController controller = new AnimationController(in, viewName, out, speed);
      View view = controller.getView();
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
}
