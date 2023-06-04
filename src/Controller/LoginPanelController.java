package Controller;

import Languages.Configuration;
import Languages.Language;
import View.Login.LoginPanel;
import View.MainFrame;
import View.MainPanel;

import javax.swing.*;
import java.net.URISyntaxException;

public class LoginPanelController {

    public static Configuration configuration;

    static {
        try {
            configuration = new Configuration();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static Language language;

    static {
        try {
            language = new Language(Integer.parseInt(configuration.getLanguage()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void verificar(JPasswordField passwordField) {

        String password = passwordField.getText();

        String name = LoginPanel.userField.getText().toUpperCase();

        if (password.equals("hola01")) {
            MainPanel.titleLabel.setText(MainPanel.titleLabel.getText() + " " + name);
            MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
            MainFrame.menuBar.setVisible(true);
        } else {
            LoginPanel.passwordField.setText("");
            JOptionPane.showMessageDialog(null, language.getProperty("wrongMsg"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
