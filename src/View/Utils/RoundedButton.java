package View.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * Clase que representa un botón redondeado.
 */
public class RoundedButton extends JButton {

    private Color startColor;
    private Color endColor;

    /**
     * Crea un nuevo botón redondeado con el texto especificado.
     *
     * @param text el texto del botón
     */
    public RoundedButton(String text) {
        super(text);
        setBorderPainted(false);
        setContentAreaFilled(false);
    }

    /**
     * Establece el gradiente de color del botón.
     *
     * @param startColor el color de inicio del gradiente
     * @param endColor   el color de fin del gradiente
     */
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

