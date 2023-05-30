import Database.ConnectionDB;
import Database.Querys;
import Model.BasicClasses.Employee;
import Model.BasicClasses.ProfessionalGroup;
import View.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //MainFrame mainFrame = new MainFrame();
        //mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ProfessionalGroup gr = new ProfessionalGroup("B");
        Employee e = new Employee("12345678-A", "Nina", "Williams", "Smith",
                "nwilliams",222333, 3, true, "A", gr);


        Querys qs = new Querys();

        System.out.println(e.getGroup().getGroupCode());
        System.out.println(qs.baseSalary(e));

    }
}