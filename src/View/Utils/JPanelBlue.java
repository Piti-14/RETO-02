package View.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un panel de fondo azul.
 */
public class JPanelBlue extends JPanel {

    /**
     * Crea una nueva instancia del panel de fondo azul.
     */
    public JPanelBlue() {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setBackground(Color.decode("#26aae1"));
        this.setBounds(screenWidth * 92 / 100, 0, 100, screenHeight);
    }
}