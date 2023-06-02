package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Database.Querys;
import Languages.Configuration;
import Languages.Language;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import Model.DataAccess.PayrollData;
import View.GeneralPickPanel;
import View.MainFrame;

import static View.GeneralPickPanel.*;


public class GeneralPickPanelController implements ActionListener {

    //Querys querys = new Querys();
    String name;

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    public GeneralPickPanelController(String name) throws SQLException {
        this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (name.equals("chooseButton")) {
            try {
                chooseButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
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

        if (name.equals("selectButton")) {
            selectButton();
        }

        if (name.equals("alternateDepartmentButton")) {
            chooseDepartmentButton();
        }

        if (name.equals("alternateEmployeeButton")) {
            chooseEmployeeButton();
        }
    }

    private void selectButton() {
        selectButton.setVisible(false);
        deleteButton.setVisible(true);
        if (alternateEmployeeButton.isVisible()) {
            alternateEmployeeButton.setVisible(false);
        }
        if (alternateDepartmentButton.isVisible()) {
            alternateDepartmentButton.setVisible(false);
        }
        titleLabel.setText(language.getProperty("choosePay"));
    }
    private void chooseButton() throws SQLException {

        String[] value = jListPick.getSelectedValue().toString().split(" ");
        String nif = value[value.length - 1];

        PayrollData.generatePayroll(nif);

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

        GeneralPickPanel.deleteElement();

    }

    private void chooseDepartmentButton() {
        alternateEmployeeButton.setVisible(true);
        alternateDepartmentButton.setVisible(false);

        listModel.removeAllElements();
        for (Department department: PayrollData.departments) {
            listModel.addElement(department.getCodeDept() + " " + department.getName());
        }

        titleLabel.setText(language.getProperty("chooseDep"));
    }

    private void chooseEmployeeButton() {
        alternateEmployeeButton.setVisible(false);
        alternateDepartmentButton.setVisible(true);

        listModel.removeAllElements();
        for (Employee employee: PayrollData.employees) {
            listModel.addElement(employee.getName() + " " + employee.getFirstLastname() + " " + employee.getSecondLastname());
        }

        titleLabel.setText(language.getProperty("chooseEmp"));
    }
}
