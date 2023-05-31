package View.Utils;

import Controller.UtilsController;
import Sources.Sources;

import javax.swing.*;
import java.awt.*;

public class SaveButton extends JButton {
    public SaveButton() {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("save.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(screenWidth*(93)/100,screenHeight*(87)/100,75,75);
        this.addActionListener(new UtilsController(this.getClass().getSimpleName()));
    }
}
