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
    public static final int CALCULATIONS = 25;
    public static final int DEDUCTIONS = 12;
    public static final int EMPLOYEE_TAXES = 5;
    public static final int COMPANY_TAXES = 6;
    public static final int PERCEPTIONS = 19;
    static Querys qs = new Querys();
    public static EmployeeData calculedData;
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
        Employee current = new Employee();
        for (Employee e : employees) {
            if (e.getNIF().equals(nif)) {
                current = e;
            }
        }
        IRPF = qs.getIRPF(current.getNIF());
        ATEP = qs.getATEP(current.getNIF());
        calculedData = new EmployeeData(current);

        fillCompanyData();
        fillEmployeeData(current);
        fillDateData();
        fillPerceptions(current);
        fillEmployeeTaxes(current);
        fillCompanyTaxes(current);
        fillCalculations(current);
    }

    public static void fillCompanyData() throws SQLException {

        for (int i = 0; i < COMPANY; i++) {
            switch (i) {
                case 0 -> AddPanel.companyTextFields.get(i).setText(comp.getName());
                case 1 -> AddPanel.companyTextFields.get(i).setText(comp.getAddress());
                case 2 -> AddPanel.companyTextFields.get(i).setText(comp.getCif());
                case 3 -> AddPanel.companyTextFields.get(i).setText("" + comp.getCcc() + "");
            }
            AddPanel.companyTextFields.get(i).setEditable(false);
        }
    }

    public static void fillEmployeeData(Employee e) throws SQLException {
        for (int i = 0; i < EMPLOYEE; i++) {
            switch (i) {
                case 0 ->
                        AddPanel.employeeTextFields.get(i).setText(e.getName() + " " + e.getFirstLastname() + " " + e.getSecondLastname());
                case 1 -> AddPanel.employeeTextFields.get(i).setText(e.getNIF());
                case 2 -> AddPanel.employeeTextFields.get(i).setText("" + e.getSS_number() + "");
                case 3 -> AddPanel.employeeTextFields.get(i).setText(e.getDept());
                case 4 -> AddPanel.employeeTextFields.get(i).setText(e.getGroup().getGroupCode());
            }
            AddPanel.employeeTextFields.get(i).setEditable(false);
        }
    }

    public static void fillDateData() {
        LocalDate today = LocalDate.now();

        for (int i = 0; i < DATE; i++) {
            switch (i) {
                case 0 -> AddPanel.dateTextFields.get(i).setText(today.getMonth().name() + " of " + today.getYear());
                case 1 -> AddPanel.dateTextFields.get(i).setText("30");
                case 2 -> AddPanel.dateTextFields.get(i).setText(today.toString());
            }
            AddPanel.dateTextFields.get(i).setEditable(false);
        }
    }

    public static void fillPerceptions(Employee e) {
        for (int i = 0; i < PERCEPTIONS; i++) {
            switch (i) {
                case 0 -> AddPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(0).getDescription());
                case 3 -> AddPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(2).getDescription());
                case 6 -> AddPanel.perceptionsTextFields.get(i).setText("");
                case 7 -> AddPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(3).getQuant() + "");
                case 8 -> AddPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(0).getQuant() + "");
                case 11 -> AddPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(1).getQuant() + "");
                case 15 -> AddPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(2).getQuant() + "");
            }
            AddPanel.perceptionsTextFields.get(i).setEditable(false);
        }
    }

    public static void fillEmployeeTaxes(Employee e) {
        int permanent = 0;
        if (!e.getPermanentJob()) {
            permanent = 1;
        }
        for (int i = 0; i < EMPLOYEE_TAXES; i++) {
            switch (i) {
                case 0 -> AddPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(6) + "");
                case 1 -> AddPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(permanent) + "");
                case 2 -> AddPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(3) + "");
                case 3 -> AddPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(5) + "");
                case 4 -> AddPanel.employeeTypesTextFields.get(i).setText(IRPF + "");
            }
            AddPanel.employeeTypesTextFields.get(i).setEditable(false);
        }
    }

    public static void fillCompanyTaxes(Employee e) {
        int permanent = 0;
        if (!e.getPermanentJob()) {
            permanent = 1;
        }
        for (int i = 0; i < COMPANY_TAXES; i++) {
            switch (i) {
                case 0 -> AddPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(7) + "");
                case 1 -> AddPanel.companyTypesTextFields.get(i).setText(ATEP + "");
                case 2 -> AddPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(permanent) + "");
                case 3, 4 -> AddPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(i) + "");
                case 5 -> AddPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(6) + "");
            }
            AddPanel.companyTypesTextFields.get(i).setEditable(false);
        }
    }

    public static void fillCalculations(Employee e) {
        for (int i = 0; i < CALCULATIONS; i++) {
            switch (i) {
                case 0: AddPanel.calculationsTextFields.get(i).setText(calculedData.totalEarned + "");
            }
            AddPanel.calculationsTextFields.get(i).setEditable(false);
        }
    }
}