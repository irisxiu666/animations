import org.junit.Test;


import cs5004.animator.model.ShapeImpl;
import cs5004.animator.model.Shape;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test ShapeImpl class works properly.
 */

public class ShapeImplTest {
  @Test
  public void testGetters() {
    Shape shape = new ShapeImpl("rect", "r1", 10, 100,
            200, 50, 100, 200, 155, 2);
    assertEquals("rect", shape.getType());
    assertEquals("r1", shape.getName());
    assertEquals(10, shape.appear());
    assertEquals(30, shape.disappear());
    assertEquals(100, shape.getX());
    assertEquals(200, shape.getY());
    assertEquals(50, shape.getWidth());
    assertEquals(100, shape.getHeight());
    assertEquals(200, shape.getR());
    assertEquals(155, shape.getG());
    assertEquals(2, shape.getB());

  }

  @Test
  public void testConstructor() {
    Shape shape = new ShapeImpl("rect", "r1");
    assertEquals("rect", shape.getType());
    assertEquals("r1", shape.getName());
    assertEquals(-1, shape.appear());

    shape = new ShapeImpl("rect", "r1", 10, 100,
            200, 50, 100, 200, 155, 2);
    assertEquals("rect", shape.getType());
    assertEquals("r1", shape.getName());
    assertEquals(10, shape.appear());
    assertEquals(20, shape.disappear());
    assertEquals(100, shape.getX());
    assertEquals(200, shape.getY());
    assertEquals(50, shape.getWidth());
    assertEquals(100, shape.getHeight());
    assertEquals(200, shape.getR());
    assertEquals(155, shape.getG());
    assertEquals(2, shape.getB());

  }

  @Test
  public void testSetters() {
    Shape shape = new ShapeImpl("rect", "r1", 10, 100,
            200, 50, 100, 200, 155, 2);
    assertEquals("rect", shape.getType());
    assertEquals("r1", shape.getName());
    assertEquals(10, shape.appear());

    assertEquals(100, shape.getX());
    assertEquals(200, shape.getY());
    assertEquals(50, shape.getWidth());
    assertEquals(100, shape.getHeight());
    assertEquals(200, shape.getR());
    assertEquals(155, shape.getG());
    assertEquals(2, shape.getB());

    shape.setType("oval");
    assertEquals("oval", shape.getType());
    shape.setStartTime(50);
    assertEquals(50, shape.appear());

    shape.setEndTime(100);
    assertEquals(100, shape.disappear());
  }
}