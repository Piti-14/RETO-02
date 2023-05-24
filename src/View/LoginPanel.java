package View;

import Controller.ControllerTeclas;
import Controller.LoginPanelController;

import javax.swing.*;
import java.awt.*;

import static java.lang.System.exit;

public class LoginPanel extends JPanel {

    public static JPasswordField cajaContrasena;

    public static JButton botonOK;

    public LoginPanel() {
        this.setLayout(null);
        this.setVisible(true);

        ImageIcon corporativeImage = new ImageIcon("src/Sources/login.jpeg");
        JLabel labelImage = new JLabel(corporativeImage);
        labelImage.setBounds(1,1,1920,1080);

        JPanel panelImagen = new JPanel();
        panelImagen.setBounds(827, 210, 200, 210); // Establece las coordenadas y el tamaño del panel de la imagen
        panelImagen.setOpaque(false);
        ImageIcon imagen = new ImageIcon("src/Sources/inicio.png");
        JLabel etiquetaImagen = new JLabel(imagen);
        etiquetaImagen.setOpaque(true); // Establece el atributo opaco en verdadero
        etiquetaImagen.setBackground(new Color(0, 0, 0, 0)); // Establece el color de fondo como transparente
        etiquetaImagen.setBounds(0, 0, 200, 200); // Establece las coordenadas y el tamaño de la imagen dentro del panel
        panelImagen.add(etiquetaImagen);


        // Panel para la caja de texto
        JPanel panelTexto = new JPanel();
        panelTexto.setBounds(817, 420, 200, 30); // Establece las coordenadas y el tamaño del panel de texto
        cajaContrasena = new JPasswordField(16); // Puedes ajustar el tamaño de la caja de texto aquí

        cajaContrasena.addKeyListener(new ControllerTeclas());
        panelTexto.add(cajaContrasena);


        // Panel para los boton OK
        JPanel panelBotonOK = new JPanel();
        panelBotonOK.setBounds(590, 420, 200, 35); // Establece las coordenadas y el tamaño del panel de botones
        botonOK = new JButton("OK");
        botonOK.setFont(new Font("Arial",Font.BOLD,16));
        botonOK.setContentAreaFilled(false);
        botonOK.setBorder(null);
        botonOK.addActionListener((e) -> {
            LoginPanelController.verificar(cajaContrasena);
        });
        panelBotonOK.add(botonOK);

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

        // Agregar los paneles al panel de bienvenida
        add(panelImagen);
        add(panelTexto);
        add(panelBotonOK);
        add(panelBotonApagar);
        //add(panelAlternoModo);

        this.add(labelImage);
    }

}
