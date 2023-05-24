package Controller;

import View.LoginPanel;
import View.MainFrame;

import javax.swing.*;

public class LoginPanelController {

    public static void verificar(JPasswordField passwordField) {

        String text = passwordField.getText();

        if (text.equals("hola01")) {
            MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
            MainFrame.menuBar.setVisible(true);
        } else {
            LoginPanel.cajaContrasena.setText("");
            JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
