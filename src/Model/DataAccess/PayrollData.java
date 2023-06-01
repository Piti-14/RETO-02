package Model.DataAccess;

import Database.Querys;
import Model.BasicClasses.Company;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import View.AddPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PayrollData {
    public static final int COMPANY = 4;
    public static final int EMPLOYEE = 5;
    public static final int DATE = 3;
    public static final int EARNINGS = 20;
    public static final int DEDUCTIONS = 12;
    public static final int DEDUCTION_TYPES = 4;
    public static final int PERCEPTIONS = 7;
    static Querys qs = new Querys();
    public static EmployeeData data;
    public static Company comp;
    public static ArrayList<Employee> employees;
    public static ArrayList<Department> departments;
    public static ArrayList<Double> employeeTaxes;
    public static ArrayList<Double> companyTaxes;
    public static int IRPF, ATEP;

    public static void initialiseData() throws SQLException {
        employees = qs.getEmployees();
        comp = qs.getCompanyData();
        employeeTaxes = qs.getEmployeeTaxes();
        companyTaxes = qs.getCompanyTaxes();
        departments = qs.getDepartments();
    }

    public static void generatePayroll(String nif) throws SQLException {
        fillCompanyData();
        fillEmployeeData(nif);
        fillDateData();
        fillPerceptions(nif);
    }
    public static void fillCompanyData() throws SQLException {

        for (int i = 0; i < COMPANY; i++) {
            switch (i){
                case 0: AddPanel.companyTextFields.get(i).setText(comp.getName());
                    AddPanel.companyTextFields.get(i).setEditable(false);
                    break;
                case 1: AddPanel.companyTextFields.get(i).setText(comp.getAddress());
                    AddPanel.companyTextFields.get(i).setEditable(false);
                    break;
                case 2: AddPanel.companyTextFields.get(i).setText(comp.getCif());
                    AddPanel.companyTextFields.get(i).setEditable(false);
                    break;
                case 3: AddPanel.companyTextFields.get(i).setText("" + comp.getCcc() + "");
                    AddPanel.companyTextFields.get(i).setEditable(false);
                    break;
            }
        }
    }

    public static void fillEmployeeData(String nif) throws SQLException {

        Employee current = new Employee();
        for (Employee e : employees) {
            if (e.getNIF().equals(nif)) {
                current = e;
            }
        }
        for (int i = 0; i < EMPLOYEE; i++) {
            switch (i) {
                case 0: AddPanel.employeeTextFields.get(i).setText(current.getName() + " " + current.getFirstLastname() + " " + current.getSecondLastname());
                    AddPanel.employeeTextFields.get(i).setEditable(false);
                    break;
                case 1: AddPanel.employeeTextFields.get(i).setText(current.getNIF());
                    AddPanel.employeeTextFields.get(i).setEditable(false);
                    break;
                case 2: AddPanel.employeeTextFields.get(i).setText("" + current.getSS_number() + "");
                    AddPanel.employeeTextFields.get(i).setEditable(false);
                    break;
                case 3: AddPanel.employeeTextFields.get(i).setText(current.getDept());
                    AddPanel.employeeTextFields.get(i).setEditable(false);
                    break;
                case 4: AddPanel.employeeTextFields.get(i).setText(current.getGroup().getGroupCode());
                    AddPanel.employeeTextFields.get(i).setEditable(false);
                    break;
            }
        }
    }

    public static void fillDateData() {
        LocalDate today = LocalDate.now();

        for (int i = 0; i < DATE; i++) {
            switch (i) {
                case 0: AddPanel.dateTextFields.get(i).setText(today.getMonth().name() + " of " + today.getYear());
                    AddPanel.dateTextFields.get(i).setEditable(false);
                    break;
                case 1: AddPanel.dateTextFields.get(i).setText("30");
                    AddPanel.dateTextFields.get(i).setEditable(false);
                    break;
                case 2: AddPanel.dateTextFields.get(i).setText(today.toString());
                    AddPanel.dateTextFields.get(i).setEditable(false);
                    break;
            }
        }
    }

    public static void fillPerceptions(String nif) {
        Employee current = new Employee();
        for (Employee e : employees) {
            if (e.getNIF().equals(nif)) {
                current = e;
            }
        }
        for (int i = 0; i < PERCEPTIONS; i++) {
            switch (i) {
                case 0: AddPanel.perceptionsTextFields.get(i).setText("" + current.getBonus().get(0).getDescription());
                    AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
                case 1: AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
                case 2: AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
                case 3: //AddPanel.perceptionsTextFields.get(i).setText();
                    AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
                case 4: AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
                case 5: AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
                case 6: AddPanel.perceptionsTextFields.get(i).setEditable(false);
                    break;
            }
        }
    }
}