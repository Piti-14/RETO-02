package Controller;

import View.Login.LoginPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerTeclas extends KeyAdapter {
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()==KeyEvent.VK_ENTER){
            LoginPanel.botonOK.doClick();
        }
    }
}
