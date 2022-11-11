package textproc;

import java.awt.*;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;

public class BookReaderController {
        public static boolean falling = true;
        public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 1000, 500));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(width, height));
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        SortedListModel<Map.Entry<String, Integer>> wordlist = new SortedListModel<>(counter.getWordList());
        JList<Map.Entry<String, Integer>> jlist = new JList<Map.Entry<String, Integer>>(wordlist);
        JScrollPane scrollpane = new JScrollPane(jlist);
        scrollpane.setBackground(Color.WHITE);
        scrollpane.setPreferredSize(new Dimension(width, height-30));
        scrollpane.getVerticalScrollBar().setPreferredSize(new Dimension(30, 0));
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setBorder(BorderFactory.createCompoundBorder(scrollpane.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        pane.add(scrollpane, BorderLayout.CENTER);

        JPanel menurow = new JPanel();
        menurow.setLayout(new GridLayout(0,5));
        JButton risingSorting = makeButton("Toggle: Sort by Falling", menurow);
        JRadioButton alphabetic = makeRadioButton("Alphabetic", false, menurow);
        JRadioButton frequency = makeRadioButton("Frequency", false, menurow);
        JTextField textfield = new JTextField();
        textfield.setPreferredSize(new Dimension(175,35));
        textfield.setBorder(BorderFactory.createCompoundBorder(textfield.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        menurow.add(textfield);
        JButton searchbtn = makeButton("Search", menurow);

        risingSorting.addActionListener(e -> {
            falling = !falling; 
            if (falling) {
                risingSorting.setText("Toggle: Sort by Falling:");
            } else {
                risingSorting.setText("Toggle: Sort by  Rising:");
            }
        });
        alphabetic.addActionListener(e -> {
            if (falling) {
                wordlist.sort((w1, w2) -> w2.getKey().compareTo((w1).getKey()));
            } else {
                wordlist.sort((w1, w2) -> w1.getKey().compareTo((w2).getKey()));
            }
            frequency.setSelected(false);
        });
        frequency.addActionListener(e -> {
            if (falling) {
                wordlist.sort((w1, w2) -> w2.getValue()-w1.getValue());
            } else {
                wordlist.sort((w1, w2) -> w1.getValue()-w2.getValue());
            }
            alphabetic.setSelected(false);
        });
        searchbtn.addActionListener(e -> {
            String filteredInput;
            try {
                filteredInput = textfield.getText().toLowerCase().strip();
            } catch (NullPointerException exception) {
                JOptionPane.showMessageDialog(null, exception, "Warning", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i<wordlist.getSize(); i++) {
                textfield.setText(filteredInput);
                if (wordlist.getElementAt(i).getKey().equals(filteredInput)) {
                    jlist.ensureIndexIsVisible(i);
                    jlist.setSelectedIndex(i);
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Can't find the word: " + textfield.getText(), "Warning", JOptionPane.ERROR_MESSAGE);
        });

        JRootPane jf = frame.getRootPane();
        jf.setDefaultButton(searchbtn); //Enter pressses the search button
        pane.add(menurow, BorderLayout.SOUTH); // Add menurow att the bottom

        frame.pack(); //create window
        frame.setVisible(true);
    }

    private JButton makeButton(String title,JPanel jp){
        JButton button = new JButton(title);
        button.setPreferredSize(new Dimension(175,35));
        jp.add(button);
        return button;
    }

    private JRadioButton makeRadioButton(String title, boolean selected, JPanel jp){
        JRadioButton button = new JRadioButton(title,selected);
        button.setPreferredSize(new Dimension(175,35));
        button.setBorder(BorderFactory.createCompoundBorder(button.getBorder(), BorderFactory.createEmptyBorder(0, 50, 0, 0)));
        jp.add(button);
        return button;
    }
}