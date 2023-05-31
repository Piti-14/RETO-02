package Model.DataAccess;

import Database.Querys;
import Model.BasicClasses.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class EmployeeData {

    ArrayList<Employee> employees;
    ArrayList<Double> taxes;
    Querys query = new Querys();

    public EmployeeData() throws SQLException {
        this.employees = query.getEmployees();
        this.taxes = query.getEmployeeTaxes();
    }

    public double totalEarned (String name, String lastName, String secondLastName, int hours) throws SQLException {
        double total = 0.0;

        for (Employee current : employees) {
            if (Objects.equals(current.getName(), name) &&
                    Objects.equals(current.getFirstLastname(), lastName) &&
                    Objects.equals(current.getSecondLastname(), secondLastName)) {

                total = query.getCommonContingencies(current) + hours;
            }
        }
        return total;
    }

    public double totalDeductions () {
        double deductions = 0.0;



        return deductions;
    }

}
