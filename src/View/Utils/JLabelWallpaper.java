package View.Utils;

import Sources.Sources;

import javax.swing.*;
import java.awt.*;

public class JLabelWallpaper extends JLabel {
    public JLabelWallpaper(){

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        ImageIcon corporativeImage = new ImageIcon(Sources.class.getResource("fondo-login.jpg"));
        this.setIcon(corporativeImage);
        this.setBounds(0,0,screenWidth,screenHeight);
    }
}
