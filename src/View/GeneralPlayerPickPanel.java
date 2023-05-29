package View;

import View.Utils.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GeneralPlayerPickPanel extends JPanel {

    MainPanel.ShadowLabel titleLabel;

    public static JList jListPick;
    public static JComboBox<String> jComboBox;
    public static JButton chooseButton;
    public static JButton modifyButton;
    public static JButton deleteButton;

    public GeneralPlayerPickPanel() {
        this.setLayout(null);

        Color color = Color.decode("#26aae1");

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        titleLabel = new MainPanel.ShadowLabel("CHOOSE EMPLOYEE");
        titleLabel.setBounds(-75, ((screenHeight / 6)), screenWidth, 100);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(color);
        titleLabel.setShadowColor(Color.WHITE);
        titleLabel.setShadowOffset(new Dimension(2, -2));

        jListPick = new JList<>();
        jListPick.setBounds(screenWidth*(30)/100,screenHeight*(29)/100,screenWidth*(32)/100,screenHeight*(34)/100);
        jListPick.setBorder(new LineBorder(Color.WHITE, 2));
        jListPick.setBackground(color);

        jComboBox = new JComboBox<>(new String[]{"History", "Recent"});
        jComboBox.setBounds(screenWidth*(72)/100,screenHeight*(40)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        jComboBox.setBorder(new LineBorder(Color.WHITE, 2));
        jComboBox.setBackground(color);
        jComboBox.setVisible(false);

        chooseButton = new JButton("Choose");
        chooseButton.setBounds(screenWidth*(72)/100,screenHeight*(48)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        chooseButton.setBorder(new LineBorder(Color.WHITE, 2));
        chooseButton.setBackground(color);
        chooseButton.setFocusPainted(false);
        chooseButton.setVisible(false);

        modifyButton = new JButton("Modify");
        modifyButton.setBounds(screenWidth*(72)/100,screenHeight*(43)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        modifyButton.setBorder(new LineBorder(Color.WHITE, 2));
        modifyButton.setBackground(color);
        modifyButton.setFocusPainted(false);
        modifyButton.setVisible(true);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(screenWidth*(72)/100,screenHeight*(43)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        deleteButton.setBorder(new LineBorder(Color.WHITE, 2));
        deleteButton.setBackground(color);
        deleteButton.setFocusPainted(false);
        deleteButton.setVisible(false);

        this.add(titleLabel);
        this.add(chooseButton);
        this.add(jComboBox);
        this.add(jListPick);
        this.add(modifyButton);
        this.add(deleteButton);

        this.add(new OffButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());
    }

    public void setjListPick(JList jListPick) {
        this.jListPick = jListPick;
    }
}
