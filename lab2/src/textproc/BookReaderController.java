package textproc;

import java.awt.*;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
        pane.setLayout(new BorderLayout());

        SortedListModel<Map.Entry<String, Integer>> wordlist = new SortedListModel<Map.Entry<String, Integer>>(counter.getWordList());
        JList<Map.Entry<String, Integer>> jlist = new JList<Map.Entry<String, Integer>>(wordlist);
        JScrollPane scrollpane = new JScrollPane(jlist);
        scrollpane.setBackground(Color.LIGHT_GRAY);
        scrollpane.setPreferredSize(new Dimension(width, height-30));
        scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(30, 0));
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.add(scrollpane, BorderLayout.CENTER);

        JPanel menurow = new JPanel();
        JButton alphabetic = makeButton("Alphabetic");
        JButton frequency = makeButton("Frequency");
        frequency.addActionListener(e -> wordlist.sort( (Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) -> w2.getValue()-w1.getValue()));
        menurow.add(alphabetic);
        menurow.add(frequency);
        
        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(300,35));
        menurow.add(textfield);
        JButton searchbtn = makeButton("Search");
        menurow.add(searchbtn);
        alphabetic.addActionListener(e -> wordlist.sort( (Map.Entry<String, Integer> w1, Map.Entry<String, Integer> w2) -> w1.getKey().compareTo((w2).getKey())));
        searchbtn.addActionListener(e -> {
            for (int i = 0; i<wordlist.getSize(); i++) {
                if (wordlist.getElementAt(i).getKey().equals(textfield.getText())) {
                    jlist.ensureIndexIsVisible(i);
                    jlist.setSelectedIndex(i);
                    System.out.print("|"+wordlist.getElementAt(i).getKey() + "|"+textfield.getText()+ "|"+i+"|");
                    return;
                }
            }
        });

        pane.add(menurow, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private JButton makeButton(String title){
        JButton button = new JButton();
        button.setText(title);
        button.setPreferredSize(new Dimension(175,35));
        return button;
    }
}