package Database;

import Model.BasicClasses.*;
import Model.DataAccess.EmployeeData;
import Model.DataAccess.PayrollData;
import View.PayrollPanel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Querys {

    private static Connection connect = ConnectionDB.Connect();

    public ArrayList<Employee> getEmployees() throws SQLException {
        Statement query = connect.createStatement();
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

            getSalaryPerceptions(e);
            getNonSalaryPerceptions(e);
        }

        return employees;
    }

    public ArrayList<Double> getEmployeeTaxes() throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cant from contingencias_t");

        ArrayList<Double> taxes = new ArrayList<>();
        double tax;

        while(result.next()) {
            tax = (result.getDouble(1)); // dividir por 10 y multiplicar para calcular
            taxes.add(tax);
        }

        return taxes;
    }

    public ArrayList<Double> getCompanyTaxes() throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cant from contingencias_e");

        ArrayList<Double> taxes = new ArrayList<>();
        double tax;

        while(result.next()) {
            tax = (result.getDouble(1)); // dividir por 10 y multiplicar para calcular
            taxes.add(tax);
        }

        return taxes;
    }

    public ArrayList<Department> getDepartments() throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_dep , nom  from departamento");

        ArrayList<Department> departments = new ArrayList<>();

        while (result.next()){
            departments.add(new Department(result.getString(1) , result.getString(2)));
        }


        return departments;
    }

    public Company getCompanyData() throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select *  from empresa");

        Company comp = null;
        while (result.next()) {

            comp = new Company(result.getString(1),
                               result.getString(2),
                               result.getString(3),
                               result.getInt(4));

        }

        return comp;
    }

    public void getSalaryPerceptions(Employee e) throws SQLException {
        Statement query2 = connect.createStatement();
        ResultSet result2 = query2.executeQuery("select cod_p, desc_p, cant " +
                " from percepciones p inner join percepciones_ind pi2 using(cod_p) " +
                " where pi2.nif = '" + e.getNIF() + "'");

        ArrayList<Bonuses> bonuses = new ArrayList<>();
        while (result2.next()) {
            String cod_p = result2.getString(1);
            String description = result2.getString(2);
            double quant = result2.getDouble(3);

            Bonuses b = new Bonuses(cod_p, description, quant);
            bonuses.add(b);
        }

        e.addBonuses(bonuses);
    }

    public void getNonSalaryPerceptions(Employee e) throws SQLException{
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_p, desc_p, cant " +
                "from trabajador t inner join percepciones_grupo pg  using(cod_gr) " +
                "inner join percepciones p using(cod_p) " +
                "where t.cod_gr = '" + e.getGroup().getGroupCode() +"'");

        ArrayList<Bonuses> bonuses = new ArrayList<>();
        while (result.next()) {
            String code = result.getString(1);
            String descr = result.getString(2);
            double quant = result.getDouble(3);

            Bonuses bonus = new Bonuses(code, descr, quant);
            bonuses.add(bonus);
        }

        e.addBonuses(bonuses);
    }

    public int getIRPF(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select getRetencionIRPF('" + nif + "')");

        int irpf = 0;
        while (result.next()){
            irpf = result.getInt(1);
        }

        return irpf;
    }

    public int getATEP(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select getRetencionATEP('" + nif + "')");

        int atep = 0;
        while (result.next()){
            atep = result.getInt(1);
        }

        return atep;
    }

    public static int getID() throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select id_nom from nominas order by id_nom desc limit 1");

        int id = 0;

        while (result.next()){
            id = result.getInt(1);
        }

        return id;
    }

    public static ArrayList<String> getPerInd(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_p from percepciones_ind where nif='" + nif + "'");

        ArrayList<String> per = new ArrayList<>();

        while (result.next()){
            per.add(result.getString(1));
        }

        return per;
    }

    public static ArrayList<String> getPerGroup(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_p from percepciones_grupo where cod_gr='" + Querys.getCodGr(nif) + "'");

        ArrayList<String> per = new ArrayList<>();

        while (result.next()){
            per.add(result.getString(1));
        }

        return per;
    }

    public static String getCodGr(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_gr from trabajador where nif='" + nif + "'");

        String cod = "";

        while (result.next()){
            cod = result.getString(1);
        }

        return cod;
    }

    public static String getCodCT(Double cant) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_c from contingencias_t where cant=" + cant + " ");

        String cod = "";

        while (result.next()){
            cod = result.getString(1);
        }


        return cod;
    }

    public static String getCodCE(Double cant) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select cod_c from contingencias_e where cant=" + cant + " ");

        String cod = "";

        while (result.next()){
            cod = result.getString(1);
        }

        return cod;
    }

    public static ArrayList<String> getPayrollsEmployee(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select id_nom,nif,ano_n, mes_n from nominas where nif='" +nif+ "'");

        ArrayList<String> payrolls = new ArrayList<>();

        while (result.next()){
            payrolls.add(result.getString(1) + " " + result.getString(2) + " " + result.getDouble(3) + " " + result.getString(4));
        }

        return payrolls;
    }

    public static ArrayList<String> getPayrollsDepartment(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select id_nom,nif,ano_n from nominas where nif='" +nif+ "'");

        ArrayList<String> payrolls = new ArrayList<>();

        while (result.next()){
            payrolls.add(result.getString(1) + ", " + result.getString(2) + ", " +((int) result.getDouble(3)));
        }

        return payrolls;
    }

    public static ArrayList<String> getNifsDepartment(String department) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select nif from trabajador where cod_dep='"+department+"'");

        ArrayList<String> nifs = new ArrayList<>();

        while (result.next()){
            nifs.add(result.getString(1));
        }

        return nifs;
    }

    public static void setPayrollDataOnPayroll(int payroll) throws SQLException {

        Statement query = connect.createStatement();

        ResultSet result = query.executeQuery("select * from nominas where id_nom='"+payroll+"'");

        Employee employee = new Employee();
        for (Employee emp: PayrollData.employees) {
            if (emp.getNIF().equals(result.getString(2))) {
                employee = emp;
            }
        }

        ResultSet salary = query.executeQuery("select getSalarioBase('"+employee.getGroup().getGroupCode()+"')");

        ResultSet result2 = query.executeQuery("select * from nom_percep where id_nom='"+payroll+"'");
        ArrayList<String> data2 = new ArrayList<>();
        while (result2.next()) {
            data2.add(result2.getString(2));
            data2.add(String.valueOf(result2.getDouble(3)));
        }

        ResultSet result3 = query.executeQuery("select * from nom_reten where id_nom='"+payroll+"'");
        ArrayList<String> data3 = new ArrayList<>();
        while (result3.next()) {
            data3.add(result3.getString(2));
            data3.add(String.valueOf(result3.getInt(3)));
            data3.add(String.valueOf(result3.getDouble(4)));
        }

        ResultSet result4 = query.executeQuery("select * from nom_cot_trabajdor where id_nom='"+payroll+"'");
        ArrayList<String> data4 = new ArrayList<>();
        while (result4.next()) {
            data4.add(result3.getString(2));
            data4.add(String.valueOf(result3.getDouble(3)));
            data4.add(String.valueOf(result3.getDouble(4)));
        }

        ResultSet result5 = query.executeQuery("select * from nom_cot_empresa where id_nom='"+payroll+"'");
        ArrayList<String> data5 = new ArrayList<>();
        while (result5.next()) {
            data5.add(result3.getString(2));
            data5.add(String.valueOf(result3.getDouble(3)));
            data5.add(String.valueOf(result3.getDouble(4)));
        }



        PayrollPanel.employeeTxt.setText(employee.getName() + " " + employee.getFirstLastname() + " " +employee.getSecondLastname());
        PayrollPanel.nifTxt.setText(result.getString(2));
        PayrollPanel.ssnTxt.setText(result.getString(employee.getSS_number()));
        PayrollPanel.categoryTxt.setText("Administración");
        PayrollPanel.contributionGroupTxt.setText(employee.getGroup().getGroupCode());

        PayrollPanel.settlementPeriodTxt.setText(result.getString(4) + "OF" + result.getDouble(3));
        PayrollPanel.nDaysTxt.setText("30");

        PayrollPanel.salarySupplementsTxt.setText((data2.get(1)));
        PayrollPanel.amount2Txt.setText(data2.get(2));

        PayrollPanel.compensationsOrAllowancesTxt.setText(data2.get(5));
        PayrollPanel.amount1Txt.setText(String.valueOf(salary.getDouble(1))); // salario base

        PayrollPanel.amount5Txt.setText(data2.get(4)); // he

        PayrollPanel.amount7Txt.setText(String.valueOf(EmployeeData.extraPays)); // pagas e

        PayrollPanel.amount9Txt.setText(data2.get(6)); // indemnizacions o suplidos

        PayrollPanel.totalEarnedTxt.setText(String.valueOf(result.getDouble(5)));
        PayrollPanel.amount13Txt.setText(String.valueOf(data4.get(3)));
        PayrollPanel.amount14Txt.setText(String.valueOf(data4.get(6)));
        PayrollPanel.amount15Txt.setText(String.valueOf(data4.get(9)));
        PayrollPanel.amount16Txt.setText(String.valueOf(data4.get(12)));
        PayrollPanel.amount17Txt.setText(String.valueOf(Double.valueOf(data4.get(3)+data4.get(6)+data4.get(9)+data4.get(12))));
        PayrollPanel.amount18Txt.setText(data3.get(3));
        PayrollPanel.totalDeductedTxt.setText(String.valueOf(Double.valueOf(data4.get(3)+data4.get(6)+data4.get(9)+data4.get(12)+data3.get(3))));
        PayrollPanel.totalNetReceivedTxt.setText(String.valueOf(result.getDouble(6)));

        PayrollPanel.typeTxt.setText(data4.get(2));
        PayrollPanel.type1Txt.setText(data4.get(5));
        PayrollPanel.type2Txt.setText(data4.get(8));
        PayrollPanel.type3Txt.setText(data4.get(12));
        PayrollPanel.irpfTxt.setText(data3.get(2));

        PayrollPanel.monthlyRemunerationTxt.setText(String.valueOf(result.getDouble(5)-EmployeeData.extraPays));
        PayrollPanel.extraPaymentsTxt.setText(String.valueOf(EmployeeData.extraPays));
        PayrollPanel.base1Txt.setText(String.valueOf(result.getDouble(5)-Double.parseDouble(data2.get(4))));
        PayrollPanel.base2Txt.setText(String.valueOf(result.getDouble(5)));
        PayrollPanel.base3Txt.setText(data2.get(4));
        PayrollPanel.base4Txt.setText(String.valueOf(result.getDouble(5)));

        PayrollPanel.type4Txt.setText(data5.get(14));
        PayrollPanel.compTax1Txt.setText(data5.get(15));
        PayrollPanel.type5Txt.setText(data3.get(5));
        PayrollPanel.compTax2Txt.setText(data3.get(6));
        PayrollPanel.type6Txt.setText(data5.get(2));
        PayrollPanel.compTax3Txt.setText(data5.get(3));
        PayrollPanel.type7Txt.setText(data5.get(5));
        PayrollPanel.compTax4Txt.setText(data5.get(6));
        PayrollPanel.type8Txt.setText(data5.get(8));
        PayrollPanel.compTax5Txt.setText(data5.get(9));
        PayrollPanel.type9Txt.setText(data5.get(11));
        PayrollPanel.compTax6Txt.setText(data5.get(12));
        PayrollPanel.totalTxt.setText(String.valueOf(Double.valueOf(data5.get(12)+data5.get(9)+data5.get(6)+data5.get(3)+data3.get(6)+data5.get(15))));




    }


    public static String getEmployyeDataOfPayroll(String nif) throws SQLException {
        Statement query = connect.createStatement();
        ResultSet result = query.executeQuery("select nom,apellido1,apellido2,cod_gr,n_ss from trabajador where nif='"+nif+"'");

        String data = "";

        while (result.next()){
            data = (result.getString(1) + " " + result.getString(2)  + " " + result.getString(3) + " " + result.getString(4) + " " + result.getString(5));
        }

        return data;
    }


}
