package cs5004.animator.view;

import cs5004.animator.model.Document;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Component;

import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JMenuBar;

/**
 * This class represents VisualView, which implements View,ActionListener
 * interface and extends from JFrame class, that can show the animation by visual
 * format.
 */
public class VisualView extends JFrame implements View, ActionListener {

  private VisualViewPanel panel;
  private Timer timer;

  /**
   * Construct a VisualView object.
   */
  public VisualView() {
    super("VisualAnimation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    JMenuItem exit = new JMenuItem("Exit");
    exit.setName("Quit");
    menuBar.add(exit);
    exit.addActionListener(this);

    int speed = 10;
    timer = new Timer(speed, e -> {
      panel.increaseIndex();
      if (!panel.isEnd()) {
        repaint();
      }
    });
  }

  /**
   * Call specific functions according to the user's input.
   *
   * @param e action event that the user chooses.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("Quit")) {
      System.exit(0);
    }
  }

  /**
   * Show the animation by visual format.
   *
   * @param doc model that stores information of animations.
   */
  @Override
  public void show(Document doc) {
    this.panel = new VisualViewPanel(doc);
    this.setSize(doc.getWidth(), doc.getHeight());
    this.setLocation(doc.getX(), doc.getY());
    this.add(this.panel);
    this.setVisible(true);
    timer.start();
  }
}

