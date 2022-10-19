package cs5004.animator.view;

import cs5004.animator.model.Animation;
import cs5004.animator.model.Document;
import cs5004.animator.model.Shape;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * This class represents SVGView, which implements View interface, and can show animations in SVG
 * format.
 */
public class SVGView implements View {

  private final HashMap<String, String> typeToX;
  private final HashMap<String, String> typeToY;
  private final HashMap<String, String> typeToWidth;
  private final HashMap<String, String> typeToHeight;
  private final HashMap<String, String> typeToTag;
  private final String outputFileName;
  private String svgContent = "";

  /**
   * Construct a SVGView object with a string.
   *
   * @param outputFileName the name of output file the user given.
   */
  public SVGView(String outputFileName) {
    typeToX = new HashMap<>();
    typeToX.put("rectangle", "x");
    typeToX.put("ellipse", "cx");

    typeToY = new HashMap<>();
    typeToY.put("rectangle", "y");
    typeToY.put("ellipse", "cy");

    typeToWidth = new HashMap<>();
    typeToWidth.put("rectangle", "width");
    typeToWidth.put("ellipse", "rx");

    typeToHeight = new HashMap<>();
    typeToHeight.put("rectangle", "height");
    typeToHeight.put("ellipse", "ry");

    typeToTag = new HashMap<>();
    typeToTag.put("rectangle", "rect");
    typeToTag.put("ellipse", "ellipse");

    this.outputFileName = outputFileName;
  }

  /**
   * Create and write specific svg files.
   *
   * @param output the contents of the output files.
   * @throws IOException thrown when errors happen during create and write files.
   */
  public void createAndWriteFile(String output) throws IOException {
    // Create file
    try {
      File myObj = new File(output);
      FileWriter writer = new FileWriter(output);
      writer.write(svgContent);
      writer.close();
    } catch (IOException e) {
      throw new IOException("create and write file failed");
    }

  }

  /**
   * A helper function to help generate the contents of output svg files.
   *
   * @param tag the tag of the contents in the svg files.
   * @param content the concrete contents in the svg files.
   * @return a string to represent the part contents of the svg files.
   */
  private String outputLine(String tag, String content) {
    return "<" + tag + content + ">\n";
  }

  /**
   * A helper function to help generate the contents of output svg files.
   *
   * @param name the name of the shape.
   * @param value the value of each svg property.
   * @return a string to represent the part contents of the svg file.
   */
  private String svgProperty(String name, String value) {
    return " " + name + "=" + "\"" + value + "\"";
  }

  /**
   * A helper function to help generate the contents of output svg files.
   *
   * @param begin the beginning time of the animation.
   * @param end the beginning time of the animation.
   * @param attributeName the attributeName of the svg files.
   * @param from start status of the animation.
   * @param to end status of the animation.
   * @return a string to represent the part contents of the svg file.
   */
  private String addAnimation(int begin, int end, String attributeName, String from, String to) {
    String output = "";
    output += svgProperty("attributeType", "xml");
    output += svgProperty("begin", String.format("%dms", begin * 100));
    output += svgProperty("dur", String.format("%dms", (end - begin) * 100));
    output += svgProperty("attributeName", attributeName);
    output += svgProperty("from", from);
    output += svgProperty("to", to);
    output += svgProperty("fill", "freeze");
    return "<" + "animate" + output + "/>\n";
  }

  /**
   * A helper function to help generate the contents of output svg files.
   *
   * @param doc the model of this project.
   * @param shape the shape of this project.
   * @return part of contents of the svg files.
   */
  private String generateShapeContent(Document doc, Shape shape) {
    String name = shape.getName();
    String type = shape.getType();
    List<Animation> animations = doc.getNameToAnimations().get(name);
    String output = "";
    output += svgProperty("id", shape.getName());

    output += svgProperty(typeToX.get(type), String.valueOf(shape.getX()));
    output += svgProperty(typeToY.get(type), String.valueOf(shape.getY()));
    output += svgProperty(typeToWidth.get(type), String.valueOf(shape.getWidth()));
    output += svgProperty(typeToHeight.get(type), String.valueOf(shape.getHeight()));
    output += svgProperty("fill", String.format("rgb(%d,%d,%d)",
        shape.getR(), shape.getG(), shape.getB()));
    output += svgProperty("visibility", "visible");
    output = outputLine(typeToTag.get(type), output);

    for (Animation animation : animations) {
      if (animation.getStartX() != animation.getEndX()) {
        output += addAnimation(animation.appear(), animation.disappear(), typeToX.get(type),
            String.valueOf(animation.getStartX()), String.valueOf(animation.getEndX()));
      }
      if (animation.getStartY() != animation.getEndY()) {
        output += addAnimation(animation.appear(), animation.disappear(), typeToY.get(type),
            String.valueOf(animation.getStartY()), String.valueOf(animation.getEndY()));
      }
      if (animation.getStartScaleX() != animation.getEndScaleX()) {
        output += addAnimation(animation.appear(), animation.disappear(), typeToWidth.get(type),
            String.valueOf(animation.getStartScaleX()),
            String.valueOf(animation.getEndScaleX()));
      }
      if (animation.getStartScaleY() != animation.getEndScaleY()) {
        output += addAnimation(animation.appear(), animation.disappear(), typeToHeight.get(type),
            String.valueOf(animation.getStartScaleY()),
            String.valueOf(animation.getEndScaleY()));
      }
      if (animation.getStartColorR() != animation.getEndColorR()
          || animation.getStartColorG() != animation.getEndColorG()
          || animation.getStartColorB() != animation.getEndColorB()) {
        output += addAnimation(animation.appear(), animation.disappear(), "fill",
            String.format("rgb(%d,%d,%d)",
                animation.getStartColorR(),
                animation.getStartColorG(),
                animation.getStartColorB()),
            String.format("rgb(%d,%d,%d)",
                animation.getEndColorR(),
                animation.getEndColorG(),
                animation.getEndColorB()));
      }
    }
    output += "</" + typeToTag.get(shape.getType()) + ">\n";
    return output;
  }

  /**
   * A helper function to help generate the contents of output svg files.
   *
   * @param doc the model of this project.
   * @return a string to represent the part contents of the svg files.
   */
  private String generateSvgContent(Document doc) {
    // <svg>
    String svg = "";
    svg += svgProperty("width", String.valueOf(doc.getWidth() * 5));
    svg += svgProperty("height", String.valueOf(doc.getHeight() * 5));
    svg += svgProperty("version", "1.1");
    svg += svgProperty("xmlns", "http://www.w3.org/2000/svg");
    return outputLine("svg", svg);
  }

  /**
   * Show the animation in SVG format.
   *
   * @param doc stores the information of animations.
   * @throws IOException thrown when error happens during create and write svg files.
   */
  @Override
  public void show(Document doc) throws IOException {
    svgContent += generateSvgContent(doc);
    for (Shape shape : doc.getShapes()) {
      svgContent += generateShapeContent(doc, shape);
    }
    svgContent += "</svg>\n";
    try {
      createAndWriteFile(this.outputFileName + ".svg");
    } catch (IOException e) {
      throw new IOException("create and write svg file failed");
    }
  }
}
