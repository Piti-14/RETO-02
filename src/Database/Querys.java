package Database;

import Model.BasicClasses.Company;
import Model.BasicClasses.Department;
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
        ConnectionDB.exit(ConnectionDB.Connect());

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
        ConnectionDB.exit(ConnectionDB.Connect());

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
        ConnectionDB.exit(ConnectionDB.Connect());

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

    public ArrayList<Department> getDepartments() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select cod_dep , nom  from departamento");

        ArrayList<Department> departments = new ArrayList<>();

        while (result.next()){
            departments.add(new Department(result.getString(1) , result.getString(2)));
        }

        ConnectionDB.exit(ConnectionDB.Connect());

        return departments;
    }

    public Company getCompanyData() throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select *  from empresa");

        Company comp = null;
        while (result.next()) {

            comp = new Company(result.getString(1),
                               result.getString(2),
                               result.getString(3),
                               result.getInt(4));

        }
        ConnectionDB.exit(ConnectionDB.Connect());

        return comp;
    }

    public void NetPay() throws SQLException{}

    public int getIRPF(String nif) throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select getRetencionIRPF('" + nif + "')");

        int irpf = 0;
        while (result.next()){
            irpf = result.getInt(1);
        }
        ConnectionDB.exit(ConnectionDB.Connect());

        return irpf;
    }

    public int getATEP(String nif) throws SQLException {
        Statement query = ConnectionDB.Connect().createStatement();
        ResultSet result = query.executeQuery("select getRetencionATEP('" + nif + "')");

        int atep = 0;
        while (result.next()){
            atep = result.getInt(1);
        }
        ConnectionDB.exit(ConnectionDB.Connect());

        return atep;
    }
}
