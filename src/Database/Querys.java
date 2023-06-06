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

        ResultSet nifSet = query.executeQuery("select nif from nominas where id_nom='"+payroll+"'");
        nifSet.next();

        String nif = nifSet.getString(1);

        connect.createStatement();

        Employee employee = new Employee();
        for (Employee emp: PayrollData.employees) {
            if (emp.getNIF().equals(nif)) {
                employee = emp;
            }
        }

        ResultSet result2 = query.executeQuery("select * from nom_percep where id_nom='"+payroll+"'");
        ArrayList<String> data2 = new ArrayList<>();
        while (result2.next()) {
            data2.add(result2.getString(2));
            data2.add(String.valueOf(result2.getDouble(3)));
        }

        connect.createStatement();

        ResultSet salary = query.executeQuery("select getSalarioBase('"+employee.getGroup().getGroupCode()+"')");
        salary.next();

        PayrollPanel.amount1Txt.setText(String.valueOf(salary.getDouble(1))); // salario base
        double baseSalary = salary.getDouble(1);

        connect.createStatement();

        ResultSet result = query.executeQuery("select * from nominas where id_nom='"+payroll+"'");
        result.next();

        PayrollPanel.base4Txt.setText(String.valueOf(result.getDouble(5)));
        PayrollPanel.base2Txt.setText(String.valueOf(result.getDouble(5)));
        PayrollPanel.base1Txt.setText(String.valueOf(PayrollData.roundNumber(result.getDouble(5)-Double.parseDouble(data2.get(3)))));
        PayrollPanel.monthlyRemunerationTxt.setText((String.valueOf(PayrollData.roundNumber(result.getDouble(5)-(baseSalary*2/12)))));
        PayrollPanel.totalNetReceivedTxt.setText(String.valueOf(result.getDouble(6)));
        PayrollPanel.settlementPeriodTxt.setText(result.getString(4) + " OF " + result.getDouble(3));
        PayrollPanel.nifTxt.setText(result.getString(2));
        PayrollPanel.totalEarnedTxt.setText(String.valueOf(result.getDouble(5)));

        PayrollPanel.ssnTxt.setText(String.valueOf(employee.getSS_number()));

        connect.createStatement();


        ResultSet result3 = query.executeQuery("select * from nom_reten where id_nom='"+payroll+"'");
        ArrayList<String> data3 = new ArrayList<>();
        while (result3.next()) {
            data3.add(result3.getString(2));
            data3.add(String.valueOf(result3.getInt(3)));
            data3.add(String.valueOf(result3.getDouble(4)));
        }

        connect.createStatement();

        ResultSet result4 = query.executeQuery("select * from nom_cot_trabajador where id_nom='"+payroll+"'");
        ArrayList<String> data4 = new ArrayList<>();
        while (result4.next()) {
            data4.add(result4.getString(2));
            data4.add(String.valueOf(result4.getDouble(3)));
            data4.add(String.valueOf(result4.getDouble(4)));
        }

        connect.createStatement();

        ResultSet result5 = query.executeQuery("select * from nom_cot_empresa where id_nom='"+payroll+"'");
        ArrayList<String> data5 = new ArrayList<>();
        while (result5.next()) {
            data5.add(result5.getString(2));
            data5.add(String.valueOf(result5.getDouble(3)));
            data5.add(String.valueOf(result5.getDouble(4)));
        }

        connect.createStatement();

        PayrollPanel.employeeTxt.setText(employee.getName() + " " + employee.getFirstLastname() + " " +employee.getSecondLastname());
        //PayrollPanel.nifTxt.setText(result.getString(2));
        //PayrollPanel.ssnTxt.setText(result.getString(employee.getSS_number()));
        PayrollPanel.categoryTxt.setText("Administración");
        PayrollPanel.contributionGroupTxt.setText(employee.getGroup().getGroupCode());

        //PayrollPanel.settlementPeriodTxt.setText(result.getString(4) + "OF" + result.getDouble(3));
        PayrollPanel.nDaysTxt.setText("30");

        PayrollPanel.salarySupplementsTxt.setText((data2.get(0)));
        PayrollPanel.amount2Txt.setText(data2.get(1));

        PayrollPanel.compensationsOrAllowancesTxt.setText(data2.get(4));

        PayrollPanel.amount5Txt.setText(String.valueOf(Double.parseDouble(data2.get(3)))); // he

        PayrollPanel.amount7Txt.setText(String.valueOf(PayrollData.roundNumber(baseSalary*2/12))); // pagas e

        PayrollPanel.amount9Txt.setText(data2.get(5)); // indemnizacions o suplidos

        PayrollPanel.amount13Txt.setText(String.valueOf(data4.get(2)));
        PayrollPanel.amount14Txt.setText(String.valueOf(data4.get(5)));
        PayrollPanel.amount15Txt.setText(String.valueOf(data4.get(8)));
        PayrollPanel.amount16Txt.setText(String.valueOf(data4.get(11)));
        PayrollPanel.amount17Txt.setText(String.valueOf(PayrollData.roundNumber(Double.valueOf(data4.get(2))+Double.valueOf(data4.get(5))+Double.valueOf(data4.get(8))+Double.valueOf(data4.get(11)))));
        PayrollPanel.amount18Txt.setText(data3.get(2));
        PayrollPanel.totalDeductedTxt.setText(String.valueOf(PayrollData.roundNumber(Double.valueOf(PayrollPanel.amount17Txt.getText()) + Double.valueOf(PayrollPanel.amount18Txt.getText()))));

        PayrollPanel.typeTxt.setText(data4.get(1));
        PayrollPanel.type1Txt.setText(data4.get(4));
        PayrollPanel.type2Txt.setText(data4.get(7));
        PayrollPanel.type3Txt.setText(data4.get(10));
        PayrollPanel.irpfTxt.setText(data3.get(1));

        //PayrollPanel.monthlyRemunerationTxt.setText(String.valueOf(result.getDouble(5)-EmployeeData.extraPays));
        PayrollPanel.extraPaymentsTxt.setText(String.valueOf(PayrollData.roundNumber(baseSalary*2/12)));
        //PayrollPanel.base1Txt.setText(String.valueOf(result.getDouble(5)-Double.parseDouble(data2.get(4))));
        //PayrollPanel.base2Txt.setText(String.valueOf(result.getDouble(5)));
        PayrollPanel.base3Txt.setText(data2.get(3));
        //PayrollPanel.base4Txt.setText(String.valueOf(result.getDouble(5)));

        PayrollPanel.type4Txt.setText(data5.get(13));
        String comp1 = String.valueOf(PayrollData.roundNumber(Double.valueOf(data5.get(13))/100 * Double.valueOf(PayrollPanel.base1Txt.getText())));
        PayrollPanel.compTax1Txt.setText(comp1);
        PayrollPanel.type5Txt.setText(data3.get(4));
        PayrollPanel.compTax2Txt.setText(data3.get(5));
        PayrollPanel.type6Txt.setText(data5.get(1));
        PayrollPanel.compTax3Txt.setText(data5.get(14));
        PayrollPanel.type7Txt.setText(data5.get(4));
        PayrollPanel.compTax4Txt.setText(data5.get(5));
        PayrollPanel.type8Txt.setText(data5.get(7));
        PayrollPanel.compTax5Txt.setText(data5.get(8));
        PayrollPanel.type9Txt.setText(data5.get(10));
        PayrollPanel.compTax6Txt.setText(data5.get(11));
        PayrollPanel.totalTxt.setText(String.valueOf(PayrollData.roundNumber(Double.valueOf(data5.get(11))+Double.valueOf(data5.get(8))+Double.valueOf(data3.get(5))+Double.valueOf(comp1)+Double.valueOf(data5.get(5))+Double.valueOf(data5.get(14))))); // hechi




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
