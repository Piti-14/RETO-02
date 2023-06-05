package Controller;

import Languages.Configuration;
import Languages.Language;
import View.MainFrame;
import View.Utils.OffButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

/**
 * Controlador para las utilidades del sistema.
 * Maneja los eventos de las utilidades y realiza las acciones correspondientes.
 */
public class UtilsController implements ActionListener {

    String name;

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    /**
     * Crea un controlador de utilidades con un nombre especificado.
     *
     * @param name el nombre del botón de utilidad
     * @throws URISyntaxException si ocurre un error en la sintaxis del URI
     * @throws IOException        si ocurre un error de entrada/salida
     */
    public UtilsController(String name) throws URISyntaxException, IOException {
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

        if (name.equals("OffButton")) {
            offButton();
        }

        if (name.equals("PreviousButton")) {
            previousButton();
        }

        if (name.equals("SaveButton")) {
            saveButton();
        }

    }

    /**
     * Realiza las acciones correspondientes al pulsar el botón de apagado.
     * Muestra un cuadro de diálogo de confirmación y cierra la aplicación si se confirma.
     */
    private void offButton() {
        if (JOptionPane.showConfirmDialog(null, language.getProperty("shutdownMsg"), language.getProperty("confirmation"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }

    /**
     * Realiza las acciones correspondientes al pulsar el botón de anterior.
     * Muestra el panel principal en el marco principal.
     */
    private void previousButton() {
        MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
    }

    /**
     * Realiza las acciones correspondientes al pulsar el botón de guardar.
     */
    private void saveButton() {

    }
}
