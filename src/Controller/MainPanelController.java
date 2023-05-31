package Controller;

import Database.Querys;
import Model.BasicClasses.Employee;
import View.GeneralPickPanel;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainPanelController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        String button = e.getActionCommand();
        System.out.println(button);

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
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
    }

    private void modifyButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(true);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);

        try {
            GeneralPickPanel.listModel.removeAllElements();
            for (Employee element: Querys.getEmployees()) {
                GeneralPickPanel.listModel.addElement(element.getName());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void consultButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(true);
        GeneralPickPanel.jComboBox.setVisible(true);
    }

    private void deleteButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(true);
        GeneralPickPanel.jComboBox.setVisible(true);
    }


}
