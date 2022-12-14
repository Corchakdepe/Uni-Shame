package View;

import javax.swing.JOptionPane;

public class DialogWindow {
    public void Menssage (String type_of_message, String text) {
        switch(type_of_message) {
            case "info":
                JOptionPane.showMessageDialog(null, text, null, JOptionPane.INFORMATION_MESSAGE);
                break;
            case "error":
                JOptionPane.showMessageDialog(null, text , null, JOptionPane.ERROR_MESSAGE);
                break;
        } 
    }
}
