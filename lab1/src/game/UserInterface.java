package game;

import javax.swing.JOptionPane;

public class UserInterface {

    public static void printMessage(String msg, String title) {
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int askForInt(String msg, String title) {
        String input = JOptionPane.showInputDialog(null,msg,title,JOptionPane.QUESTION_MESSAGE);
        int amount = -2;
        if (input == null) {
            return amount;
        } else {
            try {
                amount = Integer.parseInt(input);
            } catch (Exception e) {
                return -1;
            }
        }
        return amount;
    }
}
