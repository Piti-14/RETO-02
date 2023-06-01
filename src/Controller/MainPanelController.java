package Controller;

import Database.Querys;
import View.GeneralPickPanel;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanelController implements ActionListener {

    Querys querys = new Querys();

    @Override
    public void actionPerformed(ActionEvent e) {

        String button = e.getActionCommand();

        if (button.equals("CREAR NÓMINAS") || button.equals("CREATE PAYRROLS")) {
            createButton();
        }

        if (button.equals("MODIFICAR NÓMINAS") || button.equals("MODIFY PAYRROLS")){
            modifyButton();
        }

        if (button.equals("CONSULTAR NÓMINAS") || button.equals("CONSULT PAYRROLS")) {
            consultButton();
        }

        if (button.equals("ELIMINAR NÓMINAS") || button.equals("DELETE PAYRROLS")) {
            deleteButton();
        }
    }

    private void createButton() {
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(true);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
    }

    private void modifyButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(true);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
    }

    private void consultButton() {
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(true);
        GeneralPickPanel.jComboBox.setVisible(true);
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
    }

    private void deleteButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(true);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
    }


}
