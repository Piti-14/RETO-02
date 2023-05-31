package Controller;

import View.MainFrame;
import View.Utils.OffButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class UtilsController implements ActionListener {

    String name;

    public UtilsController(String name){
        this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (name.equals("OffButton")) {
            offButton();
        }

        if (name.equals("PreviousButton")) {
            previousButton();
        }

        if (name.equals("SaveButton")) {

        }

    }

    private void offButton() {
        if (JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres apagar el aplicación?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }

    private void previousButton() {
        MainFrame.cardLayout.show(MainFrame.cards, "mainPanel");
    }
}


