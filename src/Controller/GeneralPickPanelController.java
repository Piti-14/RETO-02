package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralPickPanelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        System.out.println(button);
    }
}
