package View.Utils;

import Controller.UtilsController;
import Sources.Sources;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.System.exit;

public class OffButton extends JButton {
    public OffButton () throws URISyntaxException, IOException {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("apagar.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(screenWidth*(93)/100,screenHeight*(87)/100,50,50);
        this.addActionListener(new UtilsController(this.getClass().getSimpleName()));
    }
}
