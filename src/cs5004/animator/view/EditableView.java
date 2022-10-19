package cs5004.animator.view;


import java.awt.Dimension;
import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JScrollBar;


import cs5004.animator.model.Document;

import static java.awt.Scrollbar.HORIZONTAL;

/**
 * This class represents EditableView, which implements View interface,
 * and support more functionalities than visual view.
 */
public class EditableView extends JFrame implements View, ActionListener {
  boolean enableLooping = false;
  boolean isPaused = false;
  int speed;

  private VisualViewPanel panel;
  private Timer timer;
  private JLabel speedLabel;
  private JScrollBar scrollBar;

  /**
   * Construct a EditableView object with an animation speed.
   *
   * @param speed the animation speed given by the user.
   */
  public EditableView(int speed) {
    super("EditableView");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    this.setJMenuBar(menuBar);

    JMenuItem exit = new JMenuItem("Exit");
    exit.setName("Quit");
    menuBar.add(exit);
    exit.addActionListener(this);

    JMenuItem restart = new JMenuItem("Restart");
    restart.setName("Restart");
    menuBar.add(restart);
    restart.addActionListener(this);

    JMenuItem pause = new JMenuItem("Pause");
    pause.setName("Pause");
    menuBar.add(pause);
    pause.addActionListener(this);

    JMenuItem resume = new JMenuItem("Resume");
    resume.setName("Resume");
    menuBar.add(resume);
    resume.addActionListener(this);

    JMenuItem loop = new JMenuItem("Loop");
    loop.setName("Loop");
    menuBar.add(loop);
    loop.addActionListener(this);

    this.scrollBar = new JScrollBar(HORIZONTAL, speed, 0, 1, 1000);
    scrollBar.setPreferredSize(new Dimension(300, 10));
    this.scrollBar.setName("Scrollbar");

    this.scrollBar.addAdjustmentListener(e -> {
      setSpeed(e.getValue());
      timer.setDelay(1000 / e.getValue());
    });

    this.speed = speed;
    this.speedLabel = new JLabel(String.valueOf(this.speed));

    initTimer();
  }

  /**
   * A helper function that enable the user to change the speed of
   * animations by scroll bar.
   *
   * @param speed the speed that the user can set.
   */
  private void setSpeed(int speed) {
    this.speed = speed;
    this.speedLabel.setText(String.valueOf(this.speed));
  }

  /**
   * A helper function to init timer.
   */
  private void initTimer() {
    this.timer = new Timer(1000 / this.speed, e -> {
      panel.increaseIndex();
      if (panel.isEnd()) {
        if (enableLooping) {
          panel.setIndex(0);
        } else {
          return;
        }
      }
      repaint();
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
    switch (c.getName()) {
      case "Quit":
        System.exit(0);
        break;
      case "Restart":
        restart();
        break;
      case "Pause":
        pause();
        break;
      case "Resume":
        resume();
        break;
      case "Loop":
        loop();
        break;
      default:
        break;
    }
  }

  /**
   * Resume the animation from the state that is paused.
   */
  public void resume() {
    this.start();
  }

  /**
   * Start the animations.
   */
  public void start() {
    this.isPaused = false;
    timer.start();
  }

  /**
   * Pause the animations.
   */
  public void pause() {
    this.isPaused = true;
    timer.stop();
  }

  /**
   * Restart the animations from zero.
   */
  public void restart() {
    panel.setIndex(0);
    start();
  }

  /**
   * Repeat the animation continuously if the user click loop button.
   */
  public void loop() {
    this.enableLooping = !this.enableLooping;
  }

  /**
   * Check whether the animation is paused, true if it is.
   *
   * @return true if the animation is paused.
   */
  public boolean isPaused() {
    return this.isPaused;
  }

  /**
   * Show the animation in the visual panel.
   *
   * @param doc document that stores the information of animations.
   */
  @Override
  public void show(Document doc) {
    this.setMinimumSize(new Dimension(doc.getWidth(), doc.getHeight()));
    this.setLocation(doc.getX(), doc.getY());
    this.panel = new VisualViewPanel(doc);
    JLabel text = new JLabel("Speed:");
    this.panel.add(text);
    this.panel.add(speedLabel);
    this.panel.add(scrollBar);
    this.add(panel);
    this.setVisible(true);
    this.start();
  }
}
