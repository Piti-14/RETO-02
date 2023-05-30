package View;

import Database.Querys;
import Model.BasicClasses.Employee;
import View.Utils.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;

public class GeneralEmployeePickPanel extends JPanel {

    MainPanel.ShadowLabel titleLabel;

    public static JList jListPick;
    public static JComboBox<String> jComboBox;
    public static DefaultListModel<String> listModel = new DefaultListModel<>();
    public static JButton chooseButton;
    public static JButton modifyButton;
    public static JButton deleteButton;
    public static JButton alternateDepartmentButton;
    public static JButton alternateEmployeeButton;

    public GeneralEmployeePickPanel() throws SQLException {
        this.setLayout(null);

        Color color = Color.decode("#26aae1");

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;

        titleLabel = new MainPanel.ShadowLabel("CHOOSE EMPLOYEE");
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

        jComboBox = new JComboBox<>(new String[]{"History", "Recent"});
        jComboBox.setBounds(screenWidth*(42)/100,screenHeight*(68)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        jComboBox.setBorder(new LineBorder(Color.WHITE, 2));
        jComboBox.setBackground(color);
        jComboBox.setVisible(false);

        chooseButton = new JButton("Choose");
        chooseButton.setBounds(screenWidth*(72)/100,screenHeight*(48)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        chooseButton.setBorder(new LineBorder(Color.WHITE, 2));
        chooseButton.setBackground(color);
        chooseButton.setFocusPainted(false);
        chooseButton.setVisible(false);
        chooseButton.addActionListener(e -> {

            String horasExtrasStr = JOptionPane.showInputDialog(null, "Ingrese las horas extras del trabajador:");

            int horasExtras = Integer.parseInt(horasExtrasStr);

            MainFrame.cardLayout.show(MainFrame.cards,"addPanel");

        });

        modifyButton = new JButton("Modify");
        modifyButton.setBounds(screenWidth*(72)/100,screenHeight*(47)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        modifyButton.setBorder(new LineBorder(Color.WHITE, 2));
        modifyButton.setBackground(color);
        modifyButton.setFocusPainted(false);
        modifyButton.setVisible(true);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(screenWidth*(72)/100,screenHeight*(47)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        deleteButton.setBorder(new LineBorder(Color.WHITE, 2));
        deleteButton.setBackground(color);
        deleteButton.setFocusPainted(false);
        deleteButton.setVisible(false);

        alternateDepartmentButton = new JButton("Choose Department");
        alternateDepartmentButton.setBounds(screenWidth*(72)/100,screenHeight*(39)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        alternateDepartmentButton.setBorder(new LineBorder(Color.WHITE, 2));
        alternateDepartmentButton.setBackground(color);
        alternateDepartmentButton.setFocusPainted(false);
        alternateDepartmentButton.setVisible(true);
        alternateDepartmentButton.addActionListener(e -> {
            alternateEmployeeButton.setVisible(true);
            alternateDepartmentButton.setVisible(false);

            try {
                GeneralEmployeePickPanel.listModel.removeAllElements();
                for (String element: Querys.getDepartments()) {
                    GeneralEmployeePickPanel.listModel.addElement(element);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            titleLabel.setText("Choose Department");
        });

        alternateEmployeeButton = new JButton("Choose Employee");
        alternateEmployeeButton.setBounds(screenWidth*(72)/100,screenHeight*(39)/100,screenWidth*(10)/100,screenHeight*(5)/100);
        alternateEmployeeButton.setBorder(new LineBorder(Color.WHITE, 2));
        alternateEmployeeButton.setBackground(color);
        alternateEmployeeButton.setFocusPainted(false);
        alternateEmployeeButton.setVisible(false);
        alternateEmployeeButton.addActionListener(e -> {
            alternateEmployeeButton.setVisible(false);
            alternateDepartmentButton.setVisible(true);

            try {
                GeneralEmployeePickPanel.listModel.removeAllElements();
                for (String element: Querys.listEmployees()) {

                    GeneralEmployeePickPanel.listModel.addElement(element);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            titleLabel.setText("Choose Employee");
        });

        try {
            for (Employee element: Querys.getEmployees()) {
                GeneralEmployeePickPanel.listModel.addElement(element.getName());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        this.add(titleLabel);
        this.add(chooseButton);
        this.add(jComboBox);
        this.add(jListPick);
        this.add(modifyButton);
        this.add(deleteButton);
        this.add(alternateEmployeeButton);
        this.add(alternateDepartmentButton);

        this.add(new OffButton());
        this.add(new PreviousButton());
        this.add(new JPanelBlue());
        this.add(new JLabelWallpaper());
    }


}
