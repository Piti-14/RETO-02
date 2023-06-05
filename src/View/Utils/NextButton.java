package View.Utils;

import Controller.UtilsController;
import Sources.Sources;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class NextButton extends JButton {
    public NextButton() throws URISyntaxException, IOException {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("next.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(0,screenHeight*(85)/100,75,75);
        this.addActionListener(new UtilsController(this.getClass().getSimpleName()));
    }
}
