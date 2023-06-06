package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import Database.Delete;
import Database.Querys;
import Languages.Configuration;
import Languages.Language;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import Model.DataAccess.PayrollData;
import View.GeneralPickPanel;
import View.MainFrame;
import View.PayrollPanel;

import static View.GeneralPickPanel.*;


public class GeneralPickPanelController implements ActionListener {

    String name;

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));
    //ArrayList<int> payrolls = new ArrayList<int>();

    public GeneralPickPanelController(String name) throws SQLException, URISyntaxException, IOException {
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
            try {
                consultButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("deleteButton")) {
            try {
                deleteButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("selectButton")) {
            try {
                selectButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("alternateDepartmentButton")) {
            chooseDepartmentButton();
        }

        if (name.equals("alternateEmployeeButton")) {
            chooseEmployeeButton();
        }
        if (name.equals("selectConsultButton")) {
            try {
                selectConsultButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void selectConsultButton() throws SQLException {
        selectConsultButton.setVisible(false);
        consultButton.setVisible(true);
        deleteButton.setVisible(false);
        selectConsultButton.setVisible(false);

        if (alternateEmployeeButton.isVisible()) {
            alternateEmployeeButton.setVisible(false);
        }
        if (alternateDepartmentButton.isVisible()) {
            alternateDepartmentButton.setVisible(false);
        }

        String element = (String) jListPick.getSelectedValue();

        listModel.removeAllElements();

        String [] elements = element.split(" ");

        if (elements.length<3) {

            for (String nif: Querys.getNifsDepartment(elements[0])) {
                listModel.addAll(Querys.getPayrollsDepartment(nif));
            }

        } else {

            listModel.addAll(Querys.getPayrollsEmployee(elements[3]));

        }

        titleLabel.setText(language.getProperty("choosePay"));
    }

    private void selectButton() throws SQLException {
        selectButton.setVisible(false);
        deleteButton.setVisible(true);
        consultButton.setVisible(false);
        selectConsultButton.setVisible(false);

        if (alternateEmployeeButton.isVisible()) {
            alternateEmployeeButton.setVisible(false);
        }
        if (alternateDepartmentButton.isVisible()) {
            alternateDepartmentButton.setVisible(false);
        }

        String element = (String) jListPick.getSelectedValue();

        listModel.removeAllElements();

        String [] elements = element.split(" ");

        if (elements.length<3) {

            for (String nif: Querys.getNifsDepartment(elements[0])) {
                listModel.addAll(Querys.getPayrollsDepartment(nif));
            }

        } else {

            listModel.addAll(Querys.getPayrollsEmployee(elements[3]));

        }

        titleLabel.setText(language.getProperty("choosePay"));
    }
    private void chooseButton() throws SQLException {

        String[] value = jListPick.getSelectedValue().toString().split(" ");
        String nif = value[value.length - 1];

        PayrollData.generatePayroll(nif);
        PayrollPanel.nextButton.setVisible(false);
        PayrollPanel.saveButton.setVisible(true);
        MainFrame.cardLayout.show(MainFrame.cards,"payrrolPanel");
    }

    private void consultButton() throws SQLException {

        PayrollPanel.saveButton.setVisible(false);
        PayrollPanel.nextButton.setVisible(true);

        String[] data = String.valueOf(jListPick.getSelectedValue()).split(" ");

        PayrollData.fillCompanyData();

        Querys.setPayrollDataOnPayroll(Integer.parseInt(data[0]));

        MainFrame.cardLayout.show(MainFrame.cards,"payrrolPanel");
    }


    private void deleteButton() throws SQLException {

        String element = (String) jListPick.getSelectedValue() ;

        String []el = element.split(" ");

        GeneralPickPanel.deleteElement();

        Delete.deletePayroll(Integer.parseInt(el[0].replace(",", "")));
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

    public void fillData(int payroll) throws SQLException {

        PayrollData.fillCompanyData();

    }
}
