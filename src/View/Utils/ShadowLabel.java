package View.Utils;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta con sombra.
 */
public class ShadowLabel extends JLabel {
    private Color shadowColor;
    private Dimension shadowOffset;

    /**
     * Crea una nueva etiqueta con sombra con el texto especificado.
     *
     * @param text el texto de la etiqueta
     */
    public ShadowLabel(String text) {
        super(text);
        this.shadowColor = Color.WHITE;
        this.shadowOffset = new Dimension(2, 2);
    }

    /**
     * Establece el color de la sombra.
     *
     * @param color el color de la sombra
     */
    public void setShadowColor(Color color) {
        this.shadowColor = color;
    }

    /**
     * Establece el desplazamiento de la sombra.
     *
     * @param offset el desplazamiento de la sombra
     */
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