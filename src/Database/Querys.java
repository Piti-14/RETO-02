package Database;

import Model.BasicClasses.Employee;
import Model.BasicClasses.ProfessionalGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Querys {

    //private ConnectionDB connect;

    public Querys() { }

    public ArrayList<Employee> getEmployees() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select * from trabajador");

        ArrayList<Employee> employees = new ArrayList<>();

        String NIF, name, firstLastName, secondLastName, account, seniority, dept;
        int ss_number;
        boolean permanentJob;
        ProfessionalGroup group;

        while(result.next()) {
            NIF = result.getString("nif");
            name = result.getString("nom");
            firstLastName = result.getString("apellido1");
            secondLastName = result.getString("apellido2");
            account = result.getString("cuenta");
            ss_number = result.getInt("n_ss");
            seniority = result.getString("antig");
            permanentJob = result.getBoolean("indef");
            dept = result.getString("cod_dep");

            String gr = result.getString("cod_gr");
            if (gr == "A" || gr == "C") {
                group = new ProfessionalGroup("I.T." , gr);
            } else if (gr == "B") {
                group = new ProfessionalGroup("Marketing" , gr);
            } else {
                group = new ProfessionalGroup("Administration" , gr);
            }

            Employee e = new Employee(NIF, name, firstLastName, secondLastName, account, ss_number, seniority, permanentJob, dept, group);
            employees.add(e);
        }
        return employees;
    }

    public ArrayList<Double> getEmployeeTaxes() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select cant from contingencias_t");

        ArrayList<Double> taxes = new ArrayList<>();
        double tax;

        while(result.next()) {
            tax = (result.getDouble(1)) / 10;
            taxes.add(tax);
        }
        return taxes;
    }

    public ArrayList<Double> getCompanyTaxes() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select cant from contingencias_e");

        ArrayList<Double> taxes = new ArrayList<>();
        double tax;

        while(result.next()) {
            tax = (result.getDouble(1)) / 10;
            taxes.add(tax);
        }
        return taxes;
    }

    public double getCommonContingencies(Employee e) throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select getSalarioBase('" + e.getGroup().getGroupCode() + "')");

        double salary = 0.0;
        if (result.next()) {
            salary = result.getDouble(1);
        }

        ConnectionDB.exit(ConnectionDB.Connect());
        return salary;
    }


    public static ArrayList<String> listEmployees() throws SQLException {
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
