package Model.DataAccess;

import Database.Querys;
import Model.BasicClasses.Company;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import View.AddPanel;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

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
    public static EmployeeData calculatedData;
    public static Company comp;
    public static ArrayList<Employee> employees;
    public static ArrayList<Department> departments;
    public static ArrayList<Double> employeeTaxes;
    public static ArrayList<Double> companyTaxes;
    public static double IRPF, ATEP;

    public static DecimalFormat df = new DecimalFormat("#0,00");

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
        calculatedData = new EmployeeData(current);

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
                case 0, 15, 17 -> AddPanel.calculationsTextFields.get(i).setText(calculatedData.totalEarned + "");
                case 1 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.firstDeduction) + "");
                case 2 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.secondDeduction) + "");
                case 3 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.thirdDeduction) + "");
                case 4, 22 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.fourthDeduction) + "");
                case 5 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalEmployeeTaxes) + "");
                case 6 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.irpfDeduction) + "");
                case 10 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalDeducted) + "");
                case 11 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalNetPay) + "");
                case 12 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.monthlyRemuneration) + "");
                case 13 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.extraPays) + "");
                case 14 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.commonContingences) + "");
                case 16 -> AddPanel.calculationsTextFields.get(i).setText(e.getBonus().get(1).getQuant() + "");
                case 18 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.firstCompanyDeduction) + "");
                case 19 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.atepDeduction) + "");
                case 20 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.secondCompanyDeduction) + "");
                case 21 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.thirdCompanyDeduction) + "");
                case 23 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.fifthCompanyDeduction) + "");
                case 24 -> AddPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalCompanyTaxes) + "");
            }
            AddPanel.calculationsTextFields.get(i).setEditable(false);
        }
    }

    public static double roundNumber(double n) {
        double rounded = Math.floor(n * 100) / 100;
        rounded = Math.ceil(rounded * 100) / 100;

        return rounded;
    }
}