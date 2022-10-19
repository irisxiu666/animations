import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import cs5004.animator.model.Document;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.TextualView;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test TextualView works properly.
 */


public class TextualViewTest {

  /**
   * Test show and toString method works properly.
   *
   * @throws FileNotFoundException thrown when errors happen while reading files.
   */
  @Test
  public void testShow() throws FileNotFoundException {
    Document doc;
    Readable file = new FileReader("smalldemo.txt");
    AnimationBuilder<Document> builder = new AnimationBuilderImpl();
    AnimationReader.parseFile(file, builder);
    doc = builder.build();

    TextualView tv = new TextualView();
    tv.show(doc);
    String expected = "Create rectangle R with corner at (200,200), width 50 and height 100\n"
            + "Create ellipse C with corner at (440,70), width 120 and height 60\n\n"
            + "R appears at time t=1 and disappears at time t=100\n"
            + "C appears at time t=6 and disappears at time t=100\n\n"
            + "R moves from (200,200) to (300,300) from time t=10 to t=50\n"
            + "R changes width from 50 to 300 from time t=51 to t=70\n"
            + "R moves from (300,300) to (200,200) from time t=70 to t=100\n"
            + "C moves from (440,70) to (440,250) from time t=20 to t=50\n"
            + "C moves from (440,250) to (440,370) from time t=50 to t=70\n"
            + "C changes from (0,170,85) to (0,255,0) from time t=70 to t=80\n";
    assertEquals(expected, tv.toString());
  }
}
