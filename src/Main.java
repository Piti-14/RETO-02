import Model.DataAccess.PayrollData;
import View.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, URISyntaxException, IOException {

        PayrollData.initialiseData();

        //System.out.println(PayrollData.employees);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ProfessionalGroup gr = new ProfessionalGroup("Marketing", "B");
        //Employee e = new Employee("12345678-A", "Nina", "Williams", "Smith",
        //        "nwilliams",222333, "02-12-2021", true, "A", gr);

        //Querys qs = new Querys();

        //System.out.println(e.getGroup().getGroupCode());
        //System.out.println(qs.getCommonContingencies(e));

        /*ArrayList<Employee> employees = qs.getEmployees();
        for(int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }

        ArrayList<Double> taxes = qs.getEmployeeTaxes();
        for(int i = 0; i < taxes.size(); i++) {
            System.out.println(taxes.get(i).toString());
        }

        ArrayList<Double> companyTaxes = qs.getCompanyTaxes();
        for(int i = 0; i < companyTaxes.size(); i++) {
            System.out.println(companyTaxes.get(i).toString());
        }
        */

        //System.out.println(qs.getCompanyData());
    }
}