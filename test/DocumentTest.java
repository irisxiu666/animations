import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;
import cs5004.animator.model.Doc;
import cs5004.animator.model.Shape;
import cs5004.animator.model.Document;
import cs5004.animator.model.ShapeImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class is to test Document works properly.
 */

public class DocumentTest {
  private Document doc;

  /**
   * Construct a doc object for test.
   *
   * @throws FileNotFoundException thrown when reading files has errors.
   */
  public DocumentTest() throws FileNotFoundException {
    Readable file = new FileReader("smalldemo.txt");
    AnimationBuilder<Document> builder = new AnimationBuilderImpl();
    AnimationReader.parseFile(file, builder);
    this.doc = builder.build();
  }

  /**
   * Test isShapeOutOfBound method works properly.
   */
  @Test
  public void testOutOfBound() {
    Document doc = new Doc();
    doc.setBounds(-200, -200, 1200, 1200);

    Shape shape = new ShapeImpl("rect", "r1", 10, 100,
            200, 50, 100, 200, 155, 2);

    assertFalse(doc.isShapeOutOfBound(shape.getX(), shape.getY(),
            shape.getWidth(), shape.getHeight()));

    shape = new ShapeImpl("rect", "r1", 10, -1000,
            200, 50, 100, 200, 155, 2);
    assertTrue(doc.isShapeOutOfBound(shape.getX(), shape.getY(),
            shape.getWidth(), shape.getHeight()));

    shape = new ShapeImpl("rect", "r1", 10, 100,
            200, 50, 2000, 200, 155, 2);
    assertTrue(doc.isShapeOutOfBound(shape.getX(), shape.getY(),
            shape.getWidth(), shape.getHeight()));
  }

  /**
   * Test getX,getY,getWidth,getHeight methods work properly.
   */
  @Test
  public void testGetBounds() {
    Document doc = new Doc();
    doc.setBounds(-200, -200, 1200, 1200);

    assertEquals(-200, doc.getX());
    assertEquals(-200, doc.getY());
    assertEquals(1200, doc.getWidth());
    assertEquals(1200, doc.getHeight());
  }

  /**
   * Test getShapes works properly.
   */
  @Test
  public void testGetShapes() {
    List<Shape> shapes = doc.getShapes();
    String actual = "";
    for (Shape shape : shapes) {
      actual += shape.toString() + "\n";
    }

    String expected = "The type of the shape is rectangle, the name of the shape is R\n"
        + "The type of the shape is ellipse, the name of the shape is C\n";
    assertEquals(expected, actual);
  }

  /**
   * Test getNameToShape works properly.
   */
  @Test
  public void testGetNameToShape() {
    HashMap<String, Shape> nameToShape = doc.getNameToShape();

    for (String key : nameToShape.keySet()) {
      if (key.equals("R")) {
        String expected = "The type of the shape is rectangle, the name of the shape is R";
        assertEquals(expected, nameToShape.get(key).toString());
      } else if (key.equals("C")) {
        String expected = "The type of the shape is ellipse, the name of the shape is C";
        assertEquals(expected, nameToShape.get(key).toString());
      }
    }
  }

  /**
   * Test getNameToAnimations works properly.
   */
  @Test
  public void testGetNameToAnimations() {
    HashMap<String, List<Animation>> nameToAnimation = doc.getNameToAnimations();
    for (String key : nameToAnimation.keySet()) {
      if (key.equals("R")) {
        String expected = "[The type of this animation is create, this animation belongs to "
            + "shape R, " + "The type of this animation is move, this animation belongs to "
            + "shape R, " + "The type of this animation is create, this animation belongs "
            + "to shape R, " + "The type of this animation is scale, this animation belongs "
            + "to shape R, " + "The type of this animation is move, this animation belongs "
            + "to shape R]";
        assertEquals(expected, nameToAnimation.get(key).toString());
      } else if (key.equals("C")) {
        String expected = "[The type of this animation is create, this animation "
                + "belongs to shape C, The type of this animation is move, "
                + "this animation belongs to shape C, "
                + "The type of this animation is move, this animation belongs to shape C, "
                + "The type of this animation is color, this animation belongs to shape C, "
                + "The type of this animation is create, this animation belongs to shape C]";
        assertEquals(expected, nameToAnimation.get(key).toString());
      }
    }
  }

  /**
   * Test addShape works properly.
   */
  @Test
  public void testAddShape() {
    doc.addShape(new ShapeImpl("triangle", "T"));
    String actual = "";
    for (Shape shape : doc.getShapes()) {
      actual += shape.toString() + "\n";
    }

    String expected = "The type of the shape is rectangle, the name of the shape is R\n"
            + "The type of the shape is ellipse, the name of the shape is C\n"
            + "The type of the shape is triangle, the name of the shape is T\n";
    assertEquals(expected, actual);

  }

  /**
   * Test getAnimations work properly.
   */
  @Test
  public void testGetAnimations() {
    List<Animation> animations = doc.getAnimations();
    String actual = "";
    for (Animation animation : animations) {
      actual += animation.toString() + "\n";
    }
    String expected = "The type of this animation is create, this animation belongs to shape R\n"
            + "The type of this animation is move, this animation belongs to shape R\n"
            + "The type of this animation is create, this animation belongs to shape R\n"
            + "The type of this animation is scale, this animation belongs to shape R\n"
            + "The type of this animation is move, this animation belongs to shape R\n"
            + "The type of this animation is create, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is color, this animation belongs to shape C\n"
            + "The type of this animation is create, this animation belongs to shape C\n";
    assertEquals(expected, actual);
  }

  /**
   * Test addAnimation works properly.
   */
  @Test
  public void testAddAnimation() {
    doc.addAnimation(new AnimationImpl("C", 100, 150, 160,
            30, 60, 20, 30, 40, 120, 45, 70,
            30, 60, 20, 30, 40));
    List<Animation> animations = doc.getAnimations();
    String actual = "";
    for (Animation animation : animations) {
      actual += animation.toString() + "\n";
    }
    String expected = "The type of this animation is create, this animation belongs to shape R\n"
            + "The type of this animation is move, this animation belongs to shape R\n"
            + "The type of this animation is create, this animation belongs to shape R\n"
            + "The type of this animation is scale, this animation belongs to shape R\n"
            + "The type of this animation is move, this animation belongs to shape R\n"
            + "The type of this animation is create, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is color, this animation belongs to shape C\n"
            + "The type of this animation is create, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n";
    assertEquals(expected, actual);

    doc.addAnimation(new AnimationImpl("T", 30, 150, 160,
            30, 60, 20, 30, 40, 60, 150, 160,
            30, 60, 20, 30, 40));

    animations = doc.getAnimations();
    actual = "";
    for (Animation animation : animations) {
      actual += animation.toString() + "\n";
    }
    expected = "The type of this animation is create, this animation belongs to shape R\n"
            + "The type of this animation is move, this animation belongs to shape R\n"
            + "The type of this animation is create, this animation belongs to shape R\n"
            + "The type of this animation is scale, this animation belongs to shape R\n"
            + "The type of this animation is move, this animation belongs to shape R\n"
            + "The type of this animation is create, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is color, this animation belongs to shape C\n"
            + "The type of this animation is create, this animation belongs to shape C\n"
            + "The type of this animation is move, this animation belongs to shape C\n"
            + "The type of this animation is create, this animation belongs to shape T\n";
    assertEquals(expected, actual);
  }
}
