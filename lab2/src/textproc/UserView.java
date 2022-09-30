package textproc;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class UserView {
    String title;
    String[] message;
    int amount;
    public UserView(String title, String[] message) {
        this.title = title;
        this.message = message;
        SwingUtilities.invokeLater(() -> createWindow());
    }
    private void createWindow() {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.setBackground(Color.BLACK);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(new Color(173, 202, 184));
        panel1.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(20, 20, 20, 5)));
        panel1.add(new JLabel("Time :"));
        pane.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.setBackground(new Color(173, 202, 184));
        panel2.setBorder(new CompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(20, 5, 20, 20)));
        for (String mess: message) {
        panel2.add(new JLabel(mess));
        }
        pane.add(panel2);

        frame.pack();
        frame.setVisible(true);
        }
}
