package View.Utils;

import Sources.Sources;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;

public class PreviousButton extends JButton {
    public PreviousButton() {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("previous.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(0,screenHeight*(85)/100,75,75);
        this.addActionListener((e) -> {
            MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
        });
    }
}
