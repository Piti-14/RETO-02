package View;

import Sources.Sources;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import View.Utils.*;

public class DeletePanel extends JPanel {
    public DeletePanel() throws URISyntaxException, IOException {
        this.setLayout(null);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screenSize = screen.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        ImageIcon corporativeImage = new ImageIcon(Sources.class.getResource("fondo-login.jpg"));
        JLabel labelImage = new JLabel(corporativeImage);
        labelImage.setBounds(0,0,screenWidth,screenHeight);

        String[] elementos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5"};

        JList<String> jListPayrools = new JList<>(elementos);
        jListPayrools.setBorder(new LineBorder(Color.BLACK, 2));
        jListPayrools.setBounds(100,100,100,100);



        this.add(jListPayrools);

        this.add(new OffButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());

    }
}
