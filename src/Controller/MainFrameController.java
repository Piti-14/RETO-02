package Controller;

import Languages.Configuration;
import Languages.Language;
import View.MainFrame;
import org.w3c.dom.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static java.lang.System.exit;


public class MainFrameController implements ActionListener {

    String name;

    MainPanelController mainPanelController = new MainPanelController();

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    public MainFrameController(String name) throws URISyntaxException, IOException {
        this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (name.equals("itemNew")) {
            mainPanelController.createButton();
        }

        if (name.equals("itemModify")) {
            mainPanelController.modifyButton();
        }

        if (name.equals("itemConsult")) {
            mainPanelController.consultButton();
        }

        if (name.equals("itemDelete")) {
            mainPanelController.deleteButton();
        }

        if (name.equals("itemEs")) {
            configuration.setLanguage("0");
            try {
                rebootPop();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("itemEn")) {
            configuration.setLanguage("1");
            try {
                rebootPop();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void rebootPop() throws SQLException {
        if (JOptionPane.showConfirmDialog(null, language.getProperty("rebootMsg"), language.getProperty("confirmation"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }

}
