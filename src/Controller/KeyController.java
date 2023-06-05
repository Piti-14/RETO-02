package Controller;

import View.Login.LoginPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Controlador para el manejo de eventos de teclado.
 * Captura los eventos de teclado y realiza acciones específicas.
 */
public class KeyController extends KeyAdapter {

    /**
     * Se activa cuando se presiona y suelta una tecla.
     * Verifica si la tecla presionada es Enter y llama al método de verificación del controlador de inicio de sesión.
     *
     * @param e el evento de teclado
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            LoginPanelController.verificar(LoginPanel.passwordField);
        }
    }
}
