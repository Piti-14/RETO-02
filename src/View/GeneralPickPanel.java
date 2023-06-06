package View;

import Controller.GeneralPickPanelController;
import Languages.Configuration;
import Languages.Language;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import Model.DataAccess.PayrollData;
import View.Utils.ShadowLabel;
import View.Utils.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class GeneralPickPanel extends JPanel {

    public static ShadowLabel titleLabel;
    //public static Querys querys = new Querys();
    public static JList jListPick;
    public static DefaultListModel<String> listModel = new DefaultListModel<>();
    public static JButton selectConsultButton;
    public static JButton chooseButton;
    public static JButton deleteButton;
    public static JButton consultButton;
    public static JButton selectButton;
    public static JButton alternateDepartmentButton;
    public static JButton alternateEmployeeButton;

    public GeneralPickPanel() throws SQLException, URISyntaxException, IOException {
        this.setLayout(null);

        Color color = Color.decode("#26aae1");

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        Configuration configuration = new Configuration();
        Language language = new Language(Integer.parseInt(configuration.getLanguage()));

        titleLabel = new ShadowLabel(language.getProperty("chooseEmp"));
        titleLabel.setBounds(-75, ((screenHeight / 6)), screenWidth, 100);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(color);
        titleLabel.setShadowColor(Color.WHITE);
        titleLabel.setShadowOffset(new Dimension(2, -2));

        jListPick = new JList<>(listModel);
        jListPick.setBounds(screenWidth*(30)/100,screenHeight*(29)/100,screenWidth*(32)/100,screenHeight*(34)/100);
        jListPick.setBorder(new LineBorder(Color.WHITE, 2));
        jListPick.setBackground(color);

        chooseButton = new JButton(language.getProperty("chooseBtn"));
        chooseButton.setBounds(screenWidth*(72)/100,screenHeight*(48)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        chooseButton.setBorder(new LineBorder(Color.WHITE, 2));
        chooseButton.setBackground(color);
        chooseButton.setFocusPainted(false);
        chooseButton.setVisible(false);
        chooseButton.addActionListener(new GeneralPickPanelController("chooseButton"));

        selectButton = new JButton(language.getProperty("selectBtn"));
        selectButton.setBounds(screenWidth*(72)/100,screenHeight*(47)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        selectButton.setBorder(new LineBorder(Color.WHITE, 2));
        selectButton.setBackground(color);
        selectButton.setFocusPainted(false);
        selectButton.setVisible(true);
        selectButton.addActionListener(new GeneralPickPanelController("selectButton"));

        selectConsultButton = new JButton(language.getProperty("selectConsultBtn"));
        selectConsultButton.setBounds(screenWidth*(72)/100,screenHeight*(47)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        selectConsultButton.setBorder(new LineBorder(Color.WHITE, 2));
        selectConsultButton.setBackground(color);
        selectConsultButton.setFocusPainted(false);
        selectConsultButton.setVisible(true);
        selectConsultButton.addActionListener(new GeneralPickPanelController("selectConsultButton"));

        deleteButton = new JButton(language.getProperty("deleteBtn"));
        deleteButton.setBounds(screenWidth*(72)/100,screenHeight*(44)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        deleteButton.setBorder(new LineBorder(Color.WHITE, 2));
        deleteButton.setBackground(color);
        deleteButton.setFocusPainted(false);
        deleteButton.setVisible(false);
        deleteButton.addActionListener(new GeneralPickPanelController("deleteButton"));

        consultButton = new JButton(language.getProperty("consultBtn"));
        consultButton.setBounds(screenWidth*(72)/100,screenHeight*(47)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        consultButton.setBorder(new LineBorder(Color.WHITE, 2));
        consultButton.setBackground(color);
        consultButton.setFocusPainted(false);
        consultButton.setVisible(true);
        consultButton.addActionListener(new GeneralPickPanelController("consultButton"));

        alternateDepartmentButton = new JButton(language.getProperty("chooseDepBtn"));
        alternateDepartmentButton.setBounds(screenWidth*(72)/100,screenHeight*(39)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        alternateDepartmentButton.setBorder(new LineBorder(Color.WHITE, 2));
        alternateDepartmentButton.setBackground(color);
        alternateDepartmentButton.setFocusPainted(false);
        alternateDepartmentButton.setVisible(true);
        alternateDepartmentButton.addActionListener(new GeneralPickPanelController("alternateDepartmentButton"));

        alternateEmployeeButton = new JButton(language.getProperty("chooseEmpBtn"));
        alternateEmployeeButton.setBounds(screenWidth*(72)/100,screenHeight*(39)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        alternateEmployeeButton.setBorder(new LineBorder(Color.WHITE, 2));
        alternateEmployeeButton.setBackground(color);
        alternateEmployeeButton.setFocusPainted(false);
        alternateEmployeeButton.setVisible(false);
        alternateEmployeeButton.addActionListener(new GeneralPickPanelController("alternateEmployeeButton"));

        insertDataEmployees();

        this.add(titleLabel);
        this.add(selectConsultButton);
        this.add(chooseButton);
        this.add(jListPick);
        this.add(deleteButton);
        this.add(alternateEmployeeButton);
        this.add(alternateDepartmentButton);
        this.add(consultButton);
        this.add(selectButton);

        this.add(new OffButton());
        this.add(new PreviousButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());
    }
    public static void deleteElement() {
        listModel.removeElement(jListPick.getSelectedValue());
    }

    public static void insertDataEmployees() {
        for (Employee employee: PayrollData.employees) {
            listModel.addElement(employee.getName() + " " + employee.getFirstLastname() + " " + employee.getSecondLastname() + ", " + employee.getNIF());
        }
    }

    public static void insertDataDepartments() {
        listModel.removeAllElements();
        for (Department dept: PayrollData.departments) {
            listModel.addElement(dept.getCodeDept() + " : " + dept.getName());
        }
    }


}
