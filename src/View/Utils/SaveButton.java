package View.Utils;

import Controller.UtilsController;
import Sources.Sources;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase que representa un botón de "Guardar".
 */
public class SaveButton extends JButton {

    /**
     * Crea una nueva instancia del botón de "Guardar".
     *
     * @throws URISyntaxException Si se produce un error al obtener la URI de recursos.
     * @throws IOException        Si se produce un error al leer los recursos.
     */
    public SaveButton() throws URISyntaxException, IOException {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("save.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(screenWidth * 93 / 100, screenHeight * 87 / 100, 75, 75);
        this.addActionListener(new UtilsController(this.getClass().getSimpleName()));
    }
}