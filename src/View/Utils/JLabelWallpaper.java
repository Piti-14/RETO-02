package View.Utils;

import Sources.Sources;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta con fondo de pantalla.
 */
public class JLabelWallpaper extends JLabel {

    /**
     * Crea una nueva instancia de la etiqueta con fondo de pantalla.
     */
    public JLabelWallpaper() {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        ImageIcon corporativeImage = new ImageIcon(Sources.class.getResource("fondo-login.jpg"));
        this.setIcon(corporativeImage);
        this.setBounds(0, 0, screenWidth, screenHeight);
    }
}