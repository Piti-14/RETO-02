package Model.DataAccess;

import Database.Querys;
import Model.BasicClasses.Company;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import View.AddPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class PayrollData {
    public static final int COMPANY = 4;
    public static final int EMPLOYEE = 5;
    public static final int DATE = 2;
    public static final int EARNINGS = 20;
    public static final int DEDUCTIONS = 12;
    public static final int DEDUCTION_TYPES = 4;
    public static final int COMPAN = 4;
    static Querys qs = new Querys();
    static EmployeeData data;
    static Company comp;
    static ArrayList<Employee> employees;
    static ArrayList<Department> departments;
    static ArrayList<Double> employeeTaxes;
    static ArrayList<Double> companyTaxes;
    static int IRPF, ATEP;

    public static void initialiseData() throws SQLException {
        employees = qs.getEmployees();
        comp = qs.getCompanyData();
        employeeTaxes = qs.getEmployeeTaxes();
        companyTaxes = qs.getCompanyTaxes();
        departments = qs.getDepartments();
    }
    public static void fillCompanyData() throws SQLException {

        comp = qs.getCompanyData();

        for (int i = 0; i < COMPANY; i++) {
            if (AddPanel.companyTextFields.get(i).getName().equals("companyTxt")) {

            } else if (AddPanel.companyTextFields.get(i).getName().equals("companyTxt")) {

            } else if (AddPanel.companyTextFields.get(i).getName().equals("companyTxt")) {

            } else if (AddPanel.companyTextFields.get(i).getName().equals("companyTxt")) {

            }
        }
    }
}