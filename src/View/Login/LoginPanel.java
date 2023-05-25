package View.Login;

import Controller.ControllerTeclas;
import Controller.LoginPanelController;
import Sources.Sources;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class LoginPanel extends JPanel {

    public static JPasswordField passwordField;
    public static JTextField userField;


    public static JButton botonOK;

    public LoginPanel() {
        this.setLayout(null);
        this.setVisible(true);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;


        ImageIcon corporativeImage = new ImageIcon(Sources.class.getResource("fondo-login.jpg"));
        JLabel labelImage = new JLabel(corporativeImage);
        labelImage.setBounds(0,0,screenWidth,screenHeight);

        ImageIcon blue = new ImageIcon(Sources.class.getResource("azul.png"));
        JLabel labelBlue = new JLabel(blue);
        labelBlue.setBounds(screenWidth-150,screenHeight-950,100,900);

        System.out.println(Sources.class.getResource("logoteaw.png"));

        ImageIcon teaw = new ImageIcon(Sources.class.getResource("logoteaw.png"));
        JLabel teawLabel = new JLabel(teaw);
        teawLabel.setBounds(screenWidth*(40)/100,screenHeight*(29)/100,252,300);

        JPanel panelImage = new JPanel();
        panelImage.setBounds(screenWidth*(68)/100, screenHeight*(20)/100, 250, 400);
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
        titleLabel.setBounds(screenWidth*(9)/100,screenHeight*(29)/100,452,300);

        Border bordePersonalizado = BorderFactory.createLineBorder(new Color(51, 153, 255), 2);

        userField = new JTextField(60);
        userField.setBounds(screenWidth*(69)/100, screenHeight*(58)/100, 200, 30);
        userField.addKeyListener(new ControllerTeclas());
        userField.setBackground(Color.decode("#26aae1"));
        userField.setBorder(bordePersonalizado);

        passwordField = new JPasswordField(40);
        passwordField.setBounds(screenWidth*(69)/100, screenHeight*(63)/100, 200, 30);
        passwordField.addKeyListener(new ControllerTeclas());
        passwordField.setBackground(Color.decode("#26aae1"));
        passwordField.setBorder(bordePersonalizado);

        JPanel prueba = new JPanel();

        userField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(prueba, "Mensaje de alerta para JTextField");
            }
        });

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(prueba, "Mensaje de alerta para JPasswordField");
            }
        });

        prueba.add(userField);
        prueba.add(passwordField);


        JPanel panelBotonOK = new JPanel();
        panelBotonOK.setBounds(590, 420, 200, 35);
        botonOK = new JButton("OK");
        botonOK.setFont(new Font("Arial",Font.BOLD,16));
        botonOK.setContentAreaFilled(false);
        botonOK.setBorder(null);
        botonOK.addActionListener((e) -> {
            LoginPanelController.verificar(passwordField);
        });
        panelBotonOK.add(botonOK);

        /*
        // Panel para los boton Apagar
        JPanel panelBotonApagar = new JPanel();
        panelBotonApagar.setBounds(1020, 680, 200, 100); // Establece las coordenadas y el tamaño del panel de botones
        JButton botonApagar = new JButton(new ImageIcon("src/Recursos/apagar.png"));
        botonApagar.setContentAreaFilled(false);
        botonApagar.setBorder(null);
        botonApagar.addActionListener((e) -> {
            exit(0);
        });
        panelBotonApagar.add(botonApagar);

         */

        this.add(prueba);
        this.add(titleLabel);
        this.add(teawLabel);
        this.add(userField);
        this.add(passwordField);
        this.add(labelBlue);
        this.add(panelImage);
        this.add(labelImage);
    }

}
