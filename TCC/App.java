import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class App extends JFrame {
    private JSlider numLinesSlider = new JSlider(3, 100, 10);
    private JSlider scaleXSlider = new JSlider(1, 100, 50);
    private JSlider scaleYSlider = new JSlider(1, 100, 50);
    private JSlider rotationSlider = new JSlider(0, 360, 0);
    private JSlider translateXSlider = new JSlider(-100, 100, 0);
    private JSlider translateYSlider = new JSlider(-100, 100, 0);
    private JSlider shearYSlider = new JSlider(-100, 100, 0);
    private JSlider shearXSlider = new JSlider(-100, 100, 0);
    private CirclePanel circlePanel = new CirclePanel();

    public App() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Number of lines:"));
        panel.add(numLinesSlider);
        panel.add(new JLabel("Scale X:"));
        panel.add(scaleXSlider);
        panel.add(new JLabel("Scale Y:"));
        panel.add(scaleYSlider);
        panel.add(new JLabel("Rotation:"));
        panel.add(rotationSlider);
        panel.add(new JLabel("Translate X:"));
        panel.add(translateXSlider);
        panel.add(new JLabel("Translate Y:"));
        panel.add(translateYSlider);
        panel.add(new JLabel("Shear Y:"));
        panel.add(shearYSlider);
        panel.add(new JLabel("Shear X:"));
        panel.add(shearXSlider);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(panel);
        rightPanel.add(Box.createVerticalGlue());

        numLinesSlider.setMajorTickSpacing(10);
        numLinesSlider.setPaintTicks(true);
        numLinesSlider.setPaintLabels(true);

        scaleXSlider.setMajorTickSpacing(10);
        scaleXSlider.setPaintTicks(true);
        scaleXSlider.setPaintLabels(true);

        scaleYSlider.setMajorTickSpacing(10);
        scaleYSlider.setPaintTicks(true);
        scaleYSlider.setPaintLabels(true);

        rotationSlider.setMajorTickSpacing(45);
        rotationSlider.setPaintTicks(true);
        rotationSlider.setPaintLabels(true);

        translateXSlider.setMajorTickSpacing(50);
        translateXSlider.setPaintTicks(true);
        translateXSlider.setPaintLabels(true);

        translateYSlider.setMajorTickSpacing(50);
        translateYSlider.setPaintTicks(true);
        translateYSlider.setPaintLabels(true);

        shearYSlider.setMajorTickSpacing(50);
        shearYSlider.setPaintTicks(true);
        shearYSlider.setPaintLabels(true);

        shearXSlider.setMajorTickSpacing(50);
        shearXSlider.setPaintTicks(true);
        shearXSlider.setPaintLabels(true);

        add(circlePanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        numLinesSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setNumLines(numLinesSlider.getValue());
            }
        });

        scaleXSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setScaleX(scaleXSlider.getValue() / 50.0);
            }
        });

        scaleYSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setScaleY(scaleYSlider.getValue() / 50.0);
            }
        });

        rotationSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setRotation(rotationSlider.getValue());
            }
        });

        translateXSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setTranslateX(translateXSlider.getValue());
            }
        });

        translateYSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setTranslateY(translateYSlider.getValue());
            }
        });

        shearYSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setShearY(shearYSlider.getValue() / 100.0);
            }
        });

        shearXSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                circlePanel.setShearX(shearXSlider.getValue() / 100.0);
            }
        });
    }

    class CirclePanel extends JPanel {
        private int numLines = numLinesSlider.getValue();
        private double scaleX = scaleXSlider.getValue() / 50.0;
        private double scaleY = scaleYSlider.getValue() / 50.0;
        private double rotation = Math.toRadians(rotationSlider.getValue());
        private int translateX = translateXSlider.getValue();
        private int translateY = translateYSlider.getValue();
        private double shearY = shearYSlider.getValue() / 100.0;
        private double shearX = shearXSlider.getValue() / 100.0;

        public void setNumLines(int numLines) {
            this.numLines = numLines;
            repaint();
        }

        public void setScaleX(double scaleX) {
            this.scaleX = scaleX;
            repaint();
        }

        public void setScaleY(double scaleY) {
            this.scaleY = scaleY;
            repaint();
        }

        public void setRotation(double rotation) {
            this.rotation = Math.toRadians(rotation);
            repaint();
        }

        public void setTranslateX(int translateX) {
            this.translateX = translateX;
            repaint();
        }

        public void setTranslateY(int translateY) {
            this.translateY = translateY;
            repaint();
        }

        public void setShearY(double shearY) {
            this.shearY = shearY;
            repaint();
        }

        public void setShearX(double shearX) {
            this.shearX = shearX;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int xCenter = getWidth() / 2 + translateX;
            int yCenter = getHeight() / 2 + translateY;
            int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

            for (int i = 0; i < numLines; i++) {
                double angle1 = i * 2 * Math.PI / numLines + rotation;
                double angle2 = (i + 1) * 2 * Math.PI / numLines + rotation;

                int x1 = (int)(xCenter + radius * Math.cos(angle1) * scaleX + radius * shearX * Math.sin(angle1));
                int y1 = (int)(yCenter - radius * Math.sin(angle1) * scaleY + radius * shearY * Math.cos(angle1));
                int x2 = (int)(xCenter + radius * Math.cos(angle2) * scaleX + radius * shearX * Math.sin(angle2));
                int y2 = (int)(yCenter - radius * Math.sin(angle2) * scaleY + radius * shearY * Math.cos(angle2));

                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    public static void main(String[] args) {
        App frame = new App();
        frame.setTitle("CircleWithLines");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
