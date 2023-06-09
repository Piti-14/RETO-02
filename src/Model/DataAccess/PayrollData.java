package Model.DataAccess;

import Database.Querys;
import Model.BasicClasses.Company;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import View.PayrollPanel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase encargada de generar los datos necesarios para mostrar una nómina en la interfaz gráfica.
 */
public class PayrollData {
    public static final int COMPANY = 4;
    public static final int EMPLOYEE = 5;
    public static final int DATE = 3;
    public static final int CALCULATIONS = 25;
    public static final int DEDUCTIONS = 12;
    public static final int EMPLOYEE_TAXES = 5;
    public static final int COMPANY_TAXES = 6;
    public static final int PERCEPTIONS = 19;
    public static EmployeeData calculatedData;
    public static Company comp;
    public static ArrayList<Employee> employees;
    public static ArrayList<Department> departments;
    public static ArrayList<Double> employeeTaxes;
    public static ArrayList<Double> companyTaxes;
    public static double IRPF, ATEP;
    static Querys qs = new Querys();

    /**
     * Inicializa los datos necesarios para generar la nómina.
     * @throws SQLException si ocurre un error al obtener los datos de la base de datos.
     */
    public static void initialiseData() throws SQLException {
        employees = qs.getEmployees();
        comp = qs.getCompanyData();
        employeeTaxes = qs.getEmployeeTaxes();
        companyTaxes = qs.getCompanyTaxes();
        departments = qs.getDepartments();
    }

    /**
     * Genera la nómina para el empleado con el NIF especificado.
     * @param nif NIF del empleado.
     * @throws SQLException si ocurre un error al obtener los datos de la base de datos.
     */
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

    /**
     * Rellena los datos de la empresa en la interfaz gráfica.
     * @throws SQLException si ocurre un error al obtener los datos de la base de datos.
     */
    public static void fillCompanyData() throws SQLException {

        for (int i = 0; i < COMPANY; i++) {
            switch (i) {
                case 0 -> PayrollPanel.companyTextFields.get(i).setText(comp.getName());
                case 1 -> PayrollPanel.companyTextFields.get(i).setText(comp.getAddress());
                case 2 -> PayrollPanel.companyTextFields.get(i).setText(comp.getCif());
                case 3 -> PayrollPanel.companyTextFields.get(i).setText("" + comp.getCcc() + "");
            }
            PayrollPanel.companyTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Rellena los datos del empleado en la interfaz gráfica.
     * @param e objeto Employee con los datos del empleado.
     * @throws SQLException si ocurre un error al obtener los datos de la base de datos.
     */
    public static void fillEmployeeData(Employee e) throws SQLException {
        for (int i = 0; i < EMPLOYEE; i++) {
            switch (i) {
                case 0 -> PayrollPanel.employeeTextFields.get(i).setText(e.getName() + " " + e.getFirstLastname() + " " + e.getSecondLastname());
                case 1 -> PayrollPanel.employeeTextFields.get(i).setText(e.getNIF());
                case 2 -> PayrollPanel.employeeTextFields.get(i).setText("" + e.getSS_number() + "");
                case 3 -> PayrollPanel.employeeTextFields.get(i).setText(e.getDept());
                case 4 -> PayrollPanel.employeeTextFields.get(i).setText(e.getGroup().getGroupCode());
            }
            PayrollPanel.employeeTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Rellena los datos de fecha en la interfaz gráfica.
     */
    public static void fillDateData() {
        LocalDate today = LocalDate.now();

        for (int i = 0; i < DATE; i++) {
            switch (i) {
                case 0 -> PayrollPanel.dateTextFields.get(i).setText(today.getMonth().name() + " of " + today.getYear());
                case 1 -> PayrollPanel.dateTextFields.get(i).setText("30");
                case 2 -> PayrollPanel.dateTextFields.get(i).setText(today.toString());
            }
            PayrollPanel.dateTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Rellena los datos de percepciones en la interfaz gráfica.
     * @param e objeto Employee con los datos del empleado.
     */
    public static void fillPerceptions(Employee e) {
        for (int i = 0; i < PERCEPTIONS; i++) {
            switch (i) {
                case 0 -> PayrollPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(0).getDescription());
                case 3 -> PayrollPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(2).getDescription());
                case 6 -> PayrollPanel.perceptionsTextFields.get(i).setText("");
                case 7 -> PayrollPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(3).getQuant() + "");
                case 8 -> PayrollPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(0).getQuant() + "");
                case 11 -> PayrollPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(1).getQuant() + "");
                case 13 -> PayrollPanel.perceptionsTextFields.get(i).setText(roundNumber(EmployeeData.extraPays) + "");
                case 15 -> PayrollPanel.perceptionsTextFields.get(i).setText(e.getBonus().get(2).getQuant() + "");
            }
            PayrollPanel.perceptionsTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Rellena los datos de impuestos del empleado en la interfaz gráfica.
     * @param e objeto Employee con los datos del empleado.
     */
    public static void fillEmployeeTaxes(Employee e) {
        int permanent = 0;
        if (!e.getPermanentJob()) {
            permanent = 1;
        }
        for (int i = 0; i < EMPLOYEE_TAXES; i++) {
            switch (i) {
                case 0 -> PayrollPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(6) + "");
                case 1 -> PayrollPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(permanent) + "");
                case 2 -> PayrollPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(3) + "");
                case 3 -> PayrollPanel.employeeTypesTextFields.get(i).setText(employeeTaxes.get(5) + "");
                case 4 -> PayrollPanel.employeeTypesTextFields.get(i).setText(IRPF + "");
            }
            PayrollPanel.employeeTypesTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Rellena los datos de impuestos de la empresa en la interfaz gráfica.
     * @param e objeto Employee con los datos del empleado.
     */
    public static void fillCompanyTaxes(Employee e) {
        int permanent = 0;
        if (!e.getPermanentJob()) {
            permanent = 1;
        }
        for (int i = 0; i < COMPANY_TAXES; i++) {
            switch (i) {
                case 0 -> PayrollPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(7) + "");
                case 1 -> PayrollPanel.companyTypesTextFields.get(i).setText(ATEP + "");
                case 2 -> PayrollPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(permanent) + "");
                case 3, 4 -> PayrollPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(i) + "");
                case 5 -> PayrollPanel.companyTypesTextFields.get(i).setText(companyTaxes.get(6) + "");
            }
            PayrollPanel.companyTypesTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Rellena los cálculos en la interfaz gráfica.
     * @param e objeto Employee con los datos del empleado.
     */
    public static void fillCalculations(Employee e) {
        for (int i = 0; i < CALCULATIONS; i++) {
            switch (i) {
                case 0, 15, 17 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalEarned) + "");
                case 1 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.firstDeduction) + "");
                case 2 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.secondDeduction) + "");
                case 3 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.thirdDeduction) + "");
                case 4 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.fourthDeduction) + "");
                case 5 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalEmployeeTaxes) + "");
                case 6 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.irpfDeduction) + "");
                case 10 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalDeducted) + "");
                case 11 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalNetPay) + "");
                case 12 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(EmployeeData.monthlyRemuneration) + "");
                case 13 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(EmployeeData.extraPays) + "");
                case 14 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(EmployeeData.commonContingences) + "");
                case 16 -> PayrollPanel.calculationsTextFields.get(i).setText(e.getBonus().get(1).getQuant() + "");
                case 18 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.firstCompanyDeduction) + "");
                case 19 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.atepDeduction) + "");
                case 20 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.secondCompanyDeduction) + "");
                case 21 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.thirdCompanyDeduction) + "");
                case 22 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.fourthCompanyDeduction) + "");
                case 23 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.fifthCompanyDeduction) + "");
                case 24 -> PayrollPanel.calculationsTextFields.get(i).setText(roundNumber(calculatedData.totalCompanyTaxes) + "");
            }
            PayrollPanel.calculationsTextFields.get(i).setEditable(false);
        }
    }

    /**
     * Redondea un número decimal a dos decimales.
     * @param n número decimal a redondear.
     * @return número redondeado a dos decimales.
     */
    public static double roundNumber(double n) {
        double rounded = Math.floor(n * 100) / 100;
        rounded = Math.ceil(rounded * 100) / 100;

        return rounded;
    }
}