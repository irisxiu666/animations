import org.junit.Test;

import cs5004.animator.model.Animation;
import cs5004.animator.model.AnimationImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test AnimationImpl works properly.
 */

public class AnimationImplTest {

  /**
   * Test getters work correctly.
   */
  @Test
  public void testGetters() {

    Animation animation = new AnimationImpl("rect", 1, 200, 200,
            50, 100, 255, 0, 0, 10, 200, 200,
            50, 100, 255, 0, 0);

    assertEquals("rect", animation.getName());
    assertEquals(1, animation.appear());
    assertEquals(200, animation.getStartX());
    assertEquals(200, animation.getStartY());
    assertEquals(50, animation.getStartScaleX());
    assertEquals(100, animation.getStartScaleY());
    assertEquals(255, animation.getStartColorR());
    assertEquals(0, animation.getStartColorG());
    assertEquals(0, animation.getStartColorB());

    assertEquals(10, animation.disappear());
    assertEquals(200, animation.getEndX());
    assertEquals(200, animation.getEndY());
    assertEquals(50, animation.getEndScaleX());
    assertEquals(100, animation.getEndScaleY());
    assertEquals(255, animation.getEndColorR());
    assertEquals(0, animation.getEndColorG());
    assertEquals(0, animation.getEndColorB());
    assertEquals(animation.getType(), "create");

    animation = new AnimationImpl("oval", 1, 200, 200,
            50, 100, 255, 0, 0, 10, 100, 300,
            50, 100, 255, 0, 0);

    assertEquals("oval", animation.getName());
    assertEquals(1, animation.appear());
    assertEquals(200, animation.getStartX());
    assertEquals(200, animation.getStartY());
    assertEquals(50, animation.getStartScaleX());
    assertEquals(100, animation.getStartScaleY());
    assertEquals(255, animation.getStartColorR());
    assertEquals(0, animation.getStartColorG());
    assertEquals(0, animation.getStartColorB());

    assertEquals(10, animation.disappear());
    assertEquals(100, animation.getEndX());
    assertEquals(300, animation.getEndY());
    assertEquals(50, animation.getEndScaleX());
    assertEquals(100, animation.getEndScaleY());
    assertEquals(255, animation.getEndColorR());
    assertEquals(0, animation.getEndColorG());
    assertEquals(0, animation.getEndColorB());
    assertEquals(animation.getType(), "move");

    animation = new AnimationImpl("rect", 1, 200, 200,
            50, 100, 255, 0, 0, 10, 200, 200,
            50, 100, 255, 255, 0);

    assertEquals("rect", animation.getName());
    assertEquals(1, animation.appear());
    assertEquals(200, animation.getStartX());
    assertEquals(200, animation.getStartY());
    assertEquals(50, animation.getStartScaleX());
    assertEquals(100, animation.getStartScaleY());
    assertEquals(255, animation.getStartColorR());
    assertEquals(0, animation.getStartColorG());
    assertEquals(0, animation.getStartColorB());

    assertEquals(10, animation.disappear());
    assertEquals(200, animation.getEndX());
    assertEquals(200, animation.getEndY());
    assertEquals(50, animation.getEndScaleX());
    assertEquals(100, animation.getEndScaleY());
    assertEquals(255, animation.getEndColorR());
    assertEquals(255, animation.getEndColorG());
    assertEquals(0, animation.getEndColorB());
    assertEquals(animation.getType(), "color");

    animation = new AnimationImpl("oval", 1, 200, 200,
            50, 100, 255, 0, 0, 10, 200, 200,
            50, 100, 255, 0, 0);

    assertEquals("oval", animation.getName());
    assertEquals(1, animation.appear());
    assertEquals(200, animation.getStartX());
    assertEquals(200, animation.getStartY());
    assertEquals(25, animation.getStartScaleX());
    assertEquals(50, animation.getStartScaleY());
    assertEquals(255, animation.getStartColorR());
    assertEquals(0, animation.getStartColorG());
    assertEquals(0, animation.getStartColorB());

    assertEquals(10, animation.disappear());
    assertEquals(200, animation.getEndX());
    assertEquals(200, animation.getEndY());
    assertEquals(50, animation.getEndScaleX());
    assertEquals(100, animation.getEndScaleY());
    assertEquals(255, animation.getEndColorR());
    assertEquals(0, animation.getEndColorG());
    assertEquals(0, animation.getEndColorB());
    assertEquals(animation.getType(), "scale");
  }

  /**
   * Test setType work correctly.
   */
  @Test
  public void testSetType() {
    Animation animation = new AnimationImpl("rect", 1, 200, 200,
            50, 100, 255, 0, 0, 10, 200, 200,
            50, 100, 255, 0, 0);
    assertEquals("create", animation.getType());

    animation.setType("move");
    assertEquals("move", animation.getType());

    animation.setType("color");
    assertEquals("color", animation.getType());
    animation.setType("scale");
    assertEquals("scale", animation.getType());

  }
}
