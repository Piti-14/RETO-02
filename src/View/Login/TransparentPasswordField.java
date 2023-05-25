package View.Login;

import javax.swing.*;
import java.awt.*;

public class TransparentPasswordField extends JPasswordField {
    public TransparentPasswordField() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.0f)); // Establece la transparencia del componente
        super.paintComponent(g2d);
        g2d.dispose();
    }
}

