package Model.DataAccess;

import Model.BasicClasses.Bonuses;
import Model.BasicClasses.Employee;

/**
 * Clase que representa los datos de un empleado y calcula los cálculos relacionados con la nómina.
 */
public class EmployeeData {

    private final Employee employee;
    int permanent = 0;
    public static double commonContingences, extraPays, monthlyRemuneration;
    public double firstDeduction, secondDeduction, thirdDeduction, fourthDeduction, irpfDeduction;
    public double firstCompanyDeduction, secondCompanyDeduction, thirdCompanyDeduction, fourthCompanyDeduction, fifthCompanyDeduction, atepDeduction;
    public double totalEarned, totalEmployeeTaxes, totalDeducted,
            totalNetPay, totalCompanyTaxes;

    /**
     * Crea una nueva instancia de EmployeeData para el empleado dado.
     *
     * @param e El empleado.
     */
    public EmployeeData(Employee e) {
        this.employee = e;

        if (!employee.getPermanentJob()) {
            permanent = 1;
        }

        getExtraPays();
        getTotalEarned();
        getCommonCont();
        getTotalDeducted();
        getCompanyDeductions();
    }

    /**
     * Calcula los pagos extra del empleado.
     */
    public void getExtraPays() {
        extraPays = (employee.getBonus().get(3).getQuant() * 2) / 12;
    }

    /**
     * Calcula el total ganado por el empleado.
     */
    public void getTotalEarned() {
        for (Bonuses b : employee.getBonus()) {
            totalEarned += b.getQuant();
        }
        totalEarned += extraPays;
    }

    /**
     * Calcula las contingencias comunes del empleado.
     */
    public void getCommonCont() {
        commonContingences = totalEarned - employee.getBonus().get(1).getQuant();
    }

    /**
     * Calcula las deducciones totales del empleado.
     */
    public void getTotalDeducted() {
        firstDeduction = commonContingences * (PayrollData.employeeTaxes.get(6) / 100);
        secondDeduction = totalEarned * (PayrollData.employeeTaxes.get(permanent) / 100);
        thirdDeduction = totalEarned * (PayrollData.employeeTaxes.get(3) / 100);
        fourthDeduction = employee.getBonus().get(1).getQuant() * (PayrollData.employeeTaxes.get(5) / 100);
        irpfDeduction = totalEarned * (PayrollData.IRPF / 100);

        monthlyRemuneration = totalEarned - extraPays;

        totalEmployeeTaxes = firstDeduction + secondDeduction + thirdDeduction + fourthDeduction;
        totalDeducted = totalEmployeeTaxes + irpfDeduction;
        totalNetPay = totalEarned - totalDeducted;
    }

    /**
     * Calcula las deducciones totales de la empresa.
     */
    public void getCompanyDeductions() {
        firstCompanyDeduction = commonContingences * (PayrollData.companyTaxes.get(7) / 100);
        secondCompanyDeduction = totalEarned * (PayrollData.companyTaxes.get(permanent) / 100);
        thirdCompanyDeduction = totalEarned * (PayrollData.companyTaxes.get(3) / 100);
        fourthCompanyDeduction = totalEarned * (PayrollData.companyTaxes.get(4) / 100);
        fifthCompanyDeduction = employee.getBonus().get(1).getQuant() * (PayrollData.companyTaxes.get(6) / 100);
        atepDeduction = totalEarned * (PayrollData.ATEP / 100);

        totalCompanyTaxes = firstCompanyDeduction + secondCompanyDeduction + thirdCompanyDeduction + fourthCompanyDeduction +
                fifthCompanyDeduction + atepDeduction;
    }

}