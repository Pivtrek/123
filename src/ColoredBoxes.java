import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Komentarz//

public class ColoredBoxes {
    public ColoredBoxes() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public static class TestPane extends JPanel {
        protected static final int ROWS = 10;
        protected static final int COLS = 20;
        protected static final int BOX_SIZE = 30;

        private List<Color> colors;

        public TestPane() {
            int length = ROWS * COLS;
            colors = new ArrayList<>(length);
            for (int index = 0; index < length; index++) {
                int c1 = (int) (Math.random() * 255);
                int c2 = (int) (Math.random() * 255);
                int c3 = (int) (Math.random() * 255);
                colors.add(new Color(c1, c2, c3));
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(COLS * BOX_SIZE, ROWS * BOX_SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int xOffset = (getWidth() - (COLS * BOX_SIZE)) / 2;
            int yOffset = (getHeight() - (ROWS * BOX_SIZE)) / 2;

            System.out.println("...");
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    int index = (row * COLS) + col;
                    g2d.setColor(colors.get(index));
                    g2d.fillRect(xOffset + (col * BOX_SIZE),
                            yOffset + (row * BOX_SIZE),
                            BOX_SIZE, BOX_SIZE);
                }
            }
            g2d.dispose();
        }

    }
    public static class Print {
        public Print(){
            System.out.println("Witam!");
        }
    }
}