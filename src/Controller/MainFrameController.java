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

/**
 * Controlador para la ventana principal del programa.
 * Maneja los eventos de la ventana principal y realiza acciones correspondientes.
 */
public class MainFrameController implements ActionListener {

    String name;

    MainPanelController mainPanelController = new MainPanelController();

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    /**
     * Crea una instancia del controlador de la ventana principal.
     *
     * @param name el nombre del controlador
     * @throws URISyntaxException si se produce un error de sintaxis URI
     * @throws IOException        si se produce un error de entrada/salida
     */
    public MainFrameController(String name) throws URISyntaxException, IOException {
        this.name = name;
    }

    /**
     * Se activa cuando se produce un evento.
     * Realiza las acciones correspondientes según el evento ocurrido.
     *
     * @param e el evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (name.equals("itemNew")) {
            mainPanelController.createButton();
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

    /**
     * Reinicia la aplicación después de cambiar el idioma.
     *
     * @throws SQLException si se produce un error de SQL
     */
    private void rebootPop() throws SQLException {
        if (JOptionPane.showConfirmDialog(null, language.getProperty("rebootMsg"), language.getProperty("confirmation"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }

}
