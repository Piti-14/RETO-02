package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Database.Querys;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import View.GeneralPickPanel;
import View.MainFrame;

import static View.GeneralPickPanel.*;


public class GeneralPickPanelController implements ActionListener {

    Querys querys = new Querys();
    String name;

    public GeneralPickPanelController(String name) throws SQLException {
        this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (name.equals("chooseButton")) {
            chooseButton();
        }

        if (name.equals("consultButton")) {
            consultButton();
        }

        if (name.equals("modifyButton")) {
            modifyButton();
        }

        if (name.equals("deleteButton")) {
            deleteButton();
        }

        if (name.equals("alternateDepartmentButton")) {
            chooseDepartmentButton();
        }

        if (name.equals("alternateEmployeeButton")) {
            chooseEmployeeButton();
        }

    }

    private void chooseButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"addPanel");
    }

    private void consultButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"consultPanel");
    }

    private void modifyButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"modifyPanel");
    }

    private void deleteButton() {
        String name = titleLabel.getText();

        if (name.equals("CHOOSE EMPLOYEE") || name.equals("SELECCIONA EMPLEADO")) {
            GeneralPickPanel.deleteElement();
        }

        if (name.equals("CHOOSE DEPARTMENT") || name.equals("SELECCIONA DEPARTAMENTO")) {
            listModel.removeAllElements();
            GeneralPickPanel.insertDataDepartments();
        }

    }

    private void chooseDepartmentButton() {
        alternateEmployeeButton.setVisible(true);
        alternateDepartmentButton.setVisible(false);

        try {
            listModel.removeAllElements();
            for (Department department: querys.getDepartments()) {
                listModel.addElement(department.getCodeDept() +", "+ department.getName());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        titleLabel.setText("Choose Department");
    }

    private void chooseEmployeeButton() {
        alternateEmployeeButton.setVisible(false);
        alternateDepartmentButton.setVisible(true);

        try {
            listModel.removeAllElements();
            for (Employee employee: querys.getEmployees()) {
                listModel.addElement(employee.getName() + ", " + employee.getFirstLastname() + ", " + employee.getSecondLastname());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        titleLabel.setText("Choose Employee");
    }




}
