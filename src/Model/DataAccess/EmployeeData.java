package Model.DataAccess;

import Database.Querys;
import Model.BasicClasses.Bonuses;
import Model.BasicClasses.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeData {

    private final Employee employee;
    public double commonContingences, extraPays;
    public double totalEarned, totalEmployeeTaxes, totalDeducted,
               totalNetPay, totalCompanyTaxes;

    public EmployeeData(Employee e) {
        this.employee = e;

        getTotalEarned();
        getCommonCont();
        getExtraPays();
        getTotalDeducted();
    }

    public double getTotalEarned () {
        for (Bonuses b : employee.getBonus()) {
            totalEarned += b.getQuant();
        }
        return totalEarned;
    }

    public double getCommonCont () {
        return commonContingences = totalEarned - employee.getBonus().get(1).getQuant();
    }

    public double getExtraPays() {
        return (employee.getBonus().get(3).getQuant() * 2) / 12;
    }

    public void getTotalDeducted () {
        int permanent = 0;
        if (!employee.getPermanentJob()) {
            permanent = 1;
        }
        for (int i = 0; i < 7; i++) {
            System.out.println("holi");
        }
    }

}
