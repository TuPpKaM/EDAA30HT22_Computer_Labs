package textproc;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
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
        pane.setBackground(Color.DARK_GRAY);
        // pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
        SortedListModel<Map.Entry<String, Integer>> wordlist = new SortedListModel<Map.Entry<String, Integer>>(counter.getWordList());
        JList<Map.Entry<String, Integer>> jlist = new JList<Map.Entry<String, Integer>>(wordlist);
        JScrollPane scrollpane = new JScrollPane(jlist);
        scrollpane.setBackground(Color.LIGHT_GRAY);
        pane.add(scrollpane);

        frame.pack();
        frame.setVisible(true);
    }
}