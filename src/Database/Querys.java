package Database;

import Model.BasicClasses.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Querys {

    //private ConnectionDB connect;

    public Querys() {

    }

    public ArrayList<Employee> getEmployees() throws SQLException{
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select * from trabajador");

        ArrayList<Employee> employees = new ArrayList<>();
        while(result.next()) {

        }
    }
    public double baseSalary(Employee e) throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select getSalarioBase('" + e.getGroup().getGroupCode() + "')");

        double salary = 0.0;
        if (result.next()) {
            salary = result.getDouble(1);
        }

        ConnectionDB.exit(ConnectionDB.Connect());
        return salary;
    }


    public static ArrayList<String> getEmployees() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select nom , apellido1 , apellido2 from trabajador");

        ArrayList<String> employees = new ArrayList<>();

        while (result.next()){
            employees.add(result.getString(1) +", "+ result.getString(2) +", "+ result.getString(3));
        }

        ConnectionDB.exit(ConnectionDB.Connect());

        return employees;
    }

    public static ArrayList<String> getDepartments() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select cod_dep , nom  from departamento");

        ArrayList<String> departments = new ArrayList<>();

        while (result.next()){
            departments.add(result.getString(1) +", "+ result.getString(2));
        }

        ConnectionDB.exit(ConnectionDB.Connect());

        return departments;
    }

    public void NetPay() throws SQLException{}
}
