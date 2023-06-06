package View;

import Controller.MainPanelController;
import Languages.Configuration;
import Languages.Language;
import Sources.Sources;
import View.Utils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Clase que representa el panel principal de la interfaz de usuario.
 */
public class MainPanel extends JPanel {

    /**
     * Etiqueta sombreada para el título del panel.
     */
    public static ShadowLabel titleLabel;

    /**
     * Crea un nuevo panel principal.
     *
     * @throws URISyntaxException si ocurre un error de sintaxis de URI
     * @throws IOException       si ocurre un error de entrada/salida
     */
    public MainPanel() throws URISyntaxException, IOException {
        this.setLayout(null);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screenSize = screen.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        ImageIcon corporativeImage = new ImageIcon(Sources.class.getResource("fondo-login.jpg"));
        JLabel labelImage = new JLabel(corporativeImage);
        labelImage.setBounds(0, 0, screenWidth, screenHeight);

        Color color1 = new Color(41, 170, 225);
        Color color2 = new Color(185, 189, 209);

        Configuration configuration = new Configuration();
        Language language = new Language(Integer.parseInt(configuration.getLanguage()));

        titleLabel = new ShadowLabel(language.getProperty("welcome"));
        titleLabel.setBounds(0, (screenHeight / 8), screenWidth, 100);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(color1);
        titleLabel.setShadowColor(Color.WHITE);
        titleLabel.setShadowOffset(new Dimension(2, -2));

        View.Utils.RoundedButton addButton = new View.Utils.RoundedButton(language.getProperty("createPay"));
        addButton.setBounds((screenWidth / 2) - 200, (screenHeight / 4) + 50, 400, 100);
        addButton.addActionListener(new MainPanelController("addButton"));
        customizeButton(addButton, color2, color1);

        View.Utils.RoundedButton consultButton = new View.Utils.RoundedButton(language.getProperty("consultPay"));
        consultButton.setBounds((screenWidth / 2) - 200, (screenHeight / 4) + 400, 400, 100);
        consultButton.addActionListener(new MainPanelController("consultButton"));
        customizeButton(consultButton, color2, color1);

        View.Utils.RoundedButton deleteButton = new View.Utils.RoundedButton(language.getProperty("deletePay"));
        deleteButton.setBounds((screenWidth / 2) - 200, (screenHeight / 2) - 50, 400, 100);
        deleteButton.addActionListener(new MainPanelController("deleteButton"));
        customizeButton(deleteButton, color2, color1);

        this.add(titleLabel);
        this.add(addButton);
        this.add(consultButton);
        this.add(deleteButton);

        MainFrame.menuBar.setVisible(true);

        this.add(new OffButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());
    }

    /**
     * Personaliza el estilo de un botón redondeado.
     *
     * @param button     el botón redondeado a personalizar
     * @param startColor el color de inicio del gradiente
     * @param endColor   el color de fin del gradiente
     */
    private void customizeButton(RoundedButton button, Color startColor, Color endColor) {
        button.setGradient(startColor, endColor);
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));

        // Agregar el MouseListener para detectar eventos del ratón
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Agrandar el botón cuando el ratón entra en él
                button.setBounds(button.getX() - 10, button.getY() - 10, button.getWidth() + 20, button.getHeight() + 20);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Restaurar el tamaño original del botón cuando el ratón sale de él
                button.setBounds(button.getX() + 10, button.getY() + 10, button.getWidth() - 20, button.getHeight() - 20);
            }
        });
    }
}