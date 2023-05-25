package View;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    JButton addButton, modifyButton, consultButton, deleteButton;
    public MainPanel() {
        this.setLayout(null);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;






        addButton = new JButton("Crear Nóminas");
        addButton.setBounds(screenWidth/4, screenHeight/4, 400, 200);

        modifyButton = new JButton("Modificar Nóminas");
        modifyButton.setBounds(screenWidth/2, screenHeight/4, 400, 200);

        consultButton = new JButton("Consultar Nóminas");
        consultButton.setBounds(screenWidth/4, screenHeight/2, 400, 200);

        deleteButton = new JButton("Eliminar Nóminas");
        deleteButton.setBounds(screenWidth/2, screenHeight/2, 400, 200);

        add(addButton);
        add(modifyButton);
        add(consultButton);
        add(deleteButton);

    }
}
