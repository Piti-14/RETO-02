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

    @Override
    public void actionPerformed(ActionEvent e) {

        String button = e.getActionCommand();
        //System.out.println(button);

        if (button.equals("Choose Employee") || button.equals("Elegir Empleado")) {
            chooseEmployeeButton();
        }

        if (button.equals("Choose Department") || button.equals("Elegir Departamento")) {
            chooseDepartmentButton();
        }

        if (button.equals("Choose") || button.equals("Elegir")) {
            chooseButton();
        }
    }

    private void chooseButton() {

        String[] value = jListPick.getSelectedValue().toString().split(" ");
        String nif = value[value.length - 1];



        MainFrame.cardLayout.show(MainFrame.cards,"addPanel");

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
