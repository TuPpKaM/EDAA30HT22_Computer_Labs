package textproc;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;

public class BookReaderController {
        public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 1000, 500));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(width, height));
        Container pane = frame.getContentPane();
        pane.setBackground(Color.LIGHT_GRAY);
        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        frame.pack();
        frame.setVisible(true);
    }
}