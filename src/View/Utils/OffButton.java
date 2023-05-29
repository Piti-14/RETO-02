package View.Utils;

import Sources.Sources;

import javax.swing.*;

import java.awt.*;

import static java.lang.System.exit;

public class OffButton extends JButton {
    public OffButton () {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        this.setIcon(new ImageIcon(Sources.class.getResource("apagar.png")));
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setBounds(screenWidth*(93)/100,screenHeight*(87)/100,50,50);
        this.addActionListener((e) -> {
            if (JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres apagar el aplicación?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                exit(0);
            }
        });
    }
}
