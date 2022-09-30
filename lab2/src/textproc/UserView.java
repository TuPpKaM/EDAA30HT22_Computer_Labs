package textproc;

import java.awt.*;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class UserView {
    String title;
    TreeMap<String,String[]> displayU;
    int amount;
    public UserView(String title, TreeMap<String,String[]> displayU) {
        this.title = title;
        this.displayU = displayU;
        SwingUtilities.invokeLater(() -> createWindow());
    }
    private void createWindow() {
        //frame setup
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.setBackground(Color.BLACK);

        for (String title: displayU.keySet()) { // for each unique test present results
            // title box
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout());
            panel1.setBackground(new Color(173, 202, 184));
            panel1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(20, 20, 20, 5)));
            panel1.add(new JLabel(title));
            pane.add(panel1);

            // result box
            JPanel panel2 = new JPanel();
            panel2.setLayout(new FlowLayout());
            panel2.setBackground(new Color(173, 202, 184));
            panel2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(16, 5, 16, 20)));
            
            // loop string[] and print each result for it self
            for (String mess: displayU.get(title)) {
            JLabel row = new JLabel(mess);
            row.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
            panel2.add(row);
            }
            pane.add(panel2);
        }

        // present
        frame.pack();
        frame.setVisible(true);
        }
}
