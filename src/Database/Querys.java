package Database;

import Model.BasicClasses.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Querys {

    //private ConnectionDB connect;

    public Querys() {

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

    /*
    public String[] baseSalary(Employee e) throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select ");

        double salary = 0.0;
        if (result.next()) {
            salary = result.getDouble(1);
        }

        ConnectionDB.exit(ConnectionDB.Connect());
        return salary;
    }

     */

    public void NetPay() throws SQLException{}
}
