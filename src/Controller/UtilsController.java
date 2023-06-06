package Controller;

import Languages.Configuration;
import Languages.Language;
import View.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class UtilsController implements ActionListener {

    String name;

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    public UtilsController(String name) throws URISyntaxException, IOException {
        this.name = name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (name.equals("OffButton")) {
            offButton();
        }

        if (name.equals("PreviousButton")) {
            previousButton();
        }

        if (name.equals("NextButton")) {
            nextButton();
        }

    }

    private void offButton() {
        if (JOptionPane.showConfirmDialog(null, language.getProperty("shutdownMsg"), language.getProperty("confirmation"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }

    private void previousButton() {
        MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
    }

    private void nextButton() {
        System.out.println(":)");
    }


}


