package View;

import Database.Querys;
import Sources.Sources;
import View.Utils.JLabelWallpaper;
import View.Utils.JPanelBlue;
import View.Utils.OffButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

import static View.MainFrame.cardLayout;

public class MainPanel extends JPanel {

    RoundedButton addButton, modifyButton, consultButton, deleteButton;
    ShadowLabel titleLabel;

    public MainPanel() {
        this.setLayout(null);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screenSize = screen.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        ImageIcon corporativeImage = new ImageIcon(Sources.class.getResource("fondo-login.jpg"));
        JLabel labelImage = new JLabel(corporativeImage);
        labelImage.setBounds(0,0,screenWidth,screenHeight);

        Color color2 = new Color(185, 189, 209);

        Color color1 = new Color(41, 170, 225);

        titleLabel = new ShadowLabel("BIENVENIDO USER");
        titleLabel.setBounds(0, ((screenHeight / 8)), screenWidth, 100);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(color1);
        titleLabel.setShadowColor(Color.WHITE);
        titleLabel.setShadowOffset(new Dimension(2, -2));

        addButton = new RoundedButton("CREAR NÓMINAS");
        addButton.setBounds((screenWidth/6), ((screenHeight/4)+50), 400, 100);
        addButton.addActionListener(e -> {
            MainFrame.cardLayout.show(MainFrame.cards,"addPanel");
        });
        customizeButton(addButton, color1, color2);
        addButton.addActionListener(e -> {

            cardLayout.show(MainFrame.cards, "addPanel");
        });

        modifyButton = new RoundedButton("MODIFICAR NÓMINAS");
        modifyButton.setBounds(((screenWidth/2)+50), ((screenHeight/4)+50), 400, 100);
        modifyButton.addActionListener(e -> {
            MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
            GeneralEmployeePickPanel.deleteButton.setVisible(false);
            GeneralEmployeePickPanel.modifyButton.setVisible(true);
            GeneralEmployeePickPanel.chooseButton.setVisible(false);
            GeneralEmployeePickPanel.jComboBox.setVisible(false);
            GeneralEmployeePickPanel.alternateDepartmentButton.setVisible(true);

            try {
                for (String element: Querys.listEmployees()) {
                    GeneralEmployeePickPanel.listModel.addElement(element);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        });
        customizeButton(modifyButton, color2, color1);

        consultButton = new RoundedButton("CONSULTAR NÓMINAS");
        consultButton.setBounds(screenWidth/6, ((screenHeight/2)+20), 400, 100);
        consultButton.addActionListener(e -> {
            MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
            GeneralEmployeePickPanel.deleteButton.setVisible(false);
            GeneralEmployeePickPanel.modifyButton.setVisible(false);
            GeneralEmployeePickPanel.chooseButton.setVisible(true);
            GeneralEmployeePickPanel.jComboBox.setVisible(true);
        });
        customizeButton(consultButton, color1, color2);

        deleteButton = new RoundedButton("ELIMINAR NÓMINAS");
        deleteButton.setBounds(((screenWidth/2)+50), ((screenHeight/2)+20), 400, 100);
        deleteButton.addActionListener(e -> {
            MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
            GeneralEmployeePickPanel.deleteButton.setVisible(false);
            GeneralEmployeePickPanel.modifyButton.setVisible(false);
            GeneralEmployeePickPanel.chooseButton.setVisible(true);
            GeneralEmployeePickPanel.jComboBox.setVisible(true);
        });
        customizeButton(deleteButton, color2, color1);

        this.add(titleLabel);
        this.add(addButton);
        this.add(modifyButton);
        this.add(consultButton);
        this.add(deleteButton);

        MainFrame.menuBar.setVisible(true);

        this.add(new OffButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());


    }

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

    static class RoundedButton extends JButton {
        private Color startColor;
        private Color endColor;

        public RoundedButton(String text) {
            super(text);
            setBorderPainted(false);
            setContentAreaFilled(false);
        }

        public void setGradient(Color startColor, Color endColor) {
            this.startColor = startColor;
            this.endColor = endColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
            g2d.setPaint(gradient);

            Shape shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            g2d.fill(shape);

            g2d.setColor(getForeground());
            g2d.setFont(getFont());

            FontMetrics fm = g2d.getFontMetrics();
            Rectangle textBounds = fm.getStringBounds(getText(), g2d).getBounds();
            int x = (getWidth() - textBounds.width) / 2;
            int y = (getHeight() - textBounds.height) / 2 + fm.getAscent();
            g2d.drawString(getText(), x, y);

            g2d.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            // No se pinta el borde para lograr la apariencia de bordes circulares
        }
    }

    static class ShadowLabel extends JLabel {
        private Color shadowColor;
        private Dimension shadowOffset;

        public ShadowLabel(String text) {
            super(text);
            this.shadowColor = Color.WHITE;
            this.shadowOffset = new Dimension(2, 2);
        }

        public void setShadowColor(Color color) {
            this.shadowColor = color;
        }

        public void setShadowOffset(Dimension offset) {
            this.shadowOffset = offset;
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            FontMetrics fm = g2d.getFontMetrics();
            Rectangle textBounds = fm.getStringBounds(getText(), g2d).getBounds();
            int x = (getWidth() - textBounds.width) / 2;
            int y = (getHeight() - textBounds.height) / 2 + fm.getAscent();

            g2d.setColor(shadowColor);
            g2d.drawString(getText(), x + shadowOffset.width, y + shadowOffset.height);

            g2d.setColor(getForeground());
            g2d.drawString(getText(), x, y);

            g2d.dispose();
        }
    }
}