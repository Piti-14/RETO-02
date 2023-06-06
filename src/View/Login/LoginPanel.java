package View.Login;

import Controller.KeyController;
import Sources.Sources;
import View.MainFrame;
import View.Utils.JLabelWallpaper;
import View.Utils.JPanelBlue;
import View.Utils.OffButton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase que representa el panel de inicio de sesión.
 */
public class LoginPanel extends JPanel {

    public static JPasswordField passwordField;
    public static JTextField userField;

    /**
     * Crea un nuevo panel de inicio de sesión.
     *
     * @throws URISyntaxException si se produce un error de sintaxis en la URI
     * @throws IOException        si se produce un error de entrada/salida
     */
    public LoginPanel() throws URISyntaxException, IOException {
        this.setLayout(null);
        MainFrame.menuBar.setVisible(false);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        ImageIcon teaw = new ImageIcon(Sources.class.getResource("logoteaw.png"));
        JLabel teawLabel = new JLabel(teaw);
        teawLabel.setBounds(screenWidth * (40) / 100, screenHeight * (29) / 100, 252, 300);

        JPanel panelImage = new JPanel();
        panelImage.setBounds(screenWidth * (68) / 100, screenHeight * (20) / 100, 250, 400);
        panelImage.setOpaque(false);
        ImageIcon imageLogin = new ImageIcon(Sources.class.getResource("login.png"));
        JLabel labelImageLogin = new JLabel(imageLogin);
        labelImageLogin.setOpaque(true);
        labelImageLogin.setBackground(new Color(0, 0, 0, 0));
        labelImageLogin.setBounds(0, 0, 200, 200);
        panelImage.add(labelImageLogin);

        JLabel titleLabel = new JLabel("Teaw");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 136));
        titleLabel.setForeground(new Color(41, 170, 225));
        titleLabel.setBounds(screenWidth * (9) / 100, screenHeight * (29) / 100, 452, 300);

        Border personalizeBorder = BorderFactory.createLineBorder(new Color(51, 153, 255), 2);

        userField = new JTextField(60);
        userField.setBounds(screenWidth * (69) / 100, screenHeight * (58) / 100, 200, 30);
        userField.addKeyListener(new KeyController());
        userField.setBackground(Color.decode("#26aae1"));
        userField.setBorder(personalizeBorder);

        passwordField = new JPasswordField(40);
        passwordField.setBounds(screenWidth * (69) / 100, screenHeight * (63) / 100, 200, 30);
        passwordField.addKeyListener(new KeyController());
        passwordField.setBackground(Color.decode("#26aae1"));
        passwordField.setBorder(personalizeBorder);

        this.add(userField);
        this.add(passwordField);

        this.add(panelImage);
        this.add(titleLabel);
        this.add(teawLabel);

        this.add(new OffButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());
    }
}