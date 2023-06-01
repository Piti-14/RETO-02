package Controller;

import Languages.Configuration;
import Languages.Language;
import View.Login.LoginPanel;
import View.MainFrame;

import javax.swing.*;

public class LoginPanelController {

    public static Configuration configuration = new Configuration();
    public static Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    public static void verificar(JPasswordField passwordField) {

        String text = passwordField.getText();

        if (text.equals("hola01")) {
            MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
            MainFrame.menuBar.setVisible(true);
        } else {
            LoginPanel.passwordField.setText("");
            JOptionPane.showMessageDialog(null, language.getProperty("wrongMsg"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
