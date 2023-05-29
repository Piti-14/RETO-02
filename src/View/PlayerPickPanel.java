package View;

import View.Utils.JLabelWallpaper;
import View.Utils.JPanelBlue;
import View.Utils.OffButton;
import View.Utils.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class PlayerPickPanel extends JPanel {
    public PlayerPickPanel() {
        this.setLayout(null);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        JList jListPick = new JList<>();
        jListPick.setBounds(screenWidth*(30)/100,screenHeight*(28)/100,screenWidth*(32)/100,screenHeight*(34)/100);

        JCheckBox jCheckBox = new JCheckBox("Opcion 1");
        jCheckBox.setSelected(true);

        boolean selected = jCheckBox.isSelected();
        System.out.println("Estado actual: " + selected);

        JButton chooseButton = new JButton("Choose");
        chooseButton.setBounds(screenWidth*(72)/100,screenHeight*(48)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        chooseButton.setBackground(Color.decode("#26aae1"));

        this.add(chooseButton);
        this.add(jListPick);

        this.add(new OffButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());
    }
}
