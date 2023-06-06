package View.Utils;

import Controller.UtilsController;
import Sources.Sources;
import View.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase que representa un botón de "Anterior".
 */
public class PreviousButton extends JButton {

    /**
     * Crea una nueva instancia del botón de "Anterior".
     *
     * @throws URISyntaxException Si se produce un error al obtener la URI de recursos.
     * @throws IOException        Si se produce un error al leer los recursos.
     */
    public PreviousButton() throws URISyntaxException, IOException {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("previous.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(0, screenHeight * 85 / 100, 75, 75);
        this.addActionListener(new UtilsController(this.getClass().getSimpleName()));
    }
}