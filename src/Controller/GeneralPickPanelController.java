package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import Database.Delete;
import Database.Querys;
import Languages.Configuration;
import Languages.Language;
import Model.BasicClasses.Department;
import Model.BasicClasses.Employee;
import Model.DataAccess.PayrollData;
import View.GeneralPickPanel;
import View.MainFrame;
import View.PayrrolPanel;

import static View.GeneralPickPanel.*;

/**
 * El controlador para el panel de selección general.
 * Gestiona las interacciones del usuario con el panel de selección general y realiza las acciones correspondientes.
 */
public class GeneralPickPanelController implements ActionListener {

    String name;

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    /**
     * Crea una instancia del controlador para el panel de selección general.
     *
     * @param name el nombre de la acción que se realizará
     * @throws SQLException     si ocurre un error de SQL
     * @throws URISyntaxException si ocurre un error de sintaxis de URI
     * @throws IOException      si ocurre un error de entrada/salida
     */
    public GeneralPickPanelController(String name) throws SQLException, URISyntaxException, IOException {
        this.name = name;
    }

    /**
     * Realiza la acción correspondiente al evento del botón.
     *
     * @param e el evento de acción
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (name.equals("chooseButton")) {
            try {
                chooseButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("consultButton")) {
            consultButton();
        }

        if (name.equals("modifyButton")) {
            modifyButton();
        }

        if (name.equals("deleteButton")) {
            try {
                deleteButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("selectButton")) {
            try {
                selectButton();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (name.equals("alternateDepartmentButton")) {
            chooseDepartmentButton();
        }

        if (name.equals("alternateEmployeeButton")) {
            chooseEmployeeButton();
        }
    }

    /**
     * Realiza las acciones correspondientes al evento del botón de selección.
     *
     * @throws SQLException si ocurre un error de SQL
     */
    private void selectButton() throws SQLException {
        selectButton.setVisible(false);
        deleteButton.setVisible(true);
        if (alternateEmployeeButton.isVisible()) {
            alternateEmployeeButton.setVisible(false);
        }
        if (alternateDepartmentButton.isVisible()) {
            alternateDepartmentButton.setVisible(false);
        }

        String element = (String) jListPick.getSelectedValue();

        listModel.removeAllElements();

        String[] elements = element.split(" ");

        if (elements.length < 3) {
            for (String nif : Querys.getNifsDepartment(elements[0])) {
                listModel.addAll(Querys.getPayrrolsDepartment(nif));
            }
        } else {
            listModel.addAll(Querys.getPayrrolsEmployee(elements[3]));
        }

        titleLabel.setText(language.getProperty("choosePay"));
    }

    /**
     * Realiza las acciones correspondientes al evento del botón de selección.
     *
     * @throws SQLException si ocurre un error de SQL
     */
    private void chooseButton() throws SQLException {

        String[] value = jListPick.getSelectedValue().toString().split(" ");
        String nif = value[value.length - 1];

        PayrollData.generatePayroll(nif);

        MainFrame.cardLayout.show(MainFrame.cards, "payrrolPanel");
    }

    /**
     * Muestra el panel de consultas.
     */
    private void consultButton() {
        MainFrame.cardLayout.show(MainFrame.cards, "consultPanel");

    }

    /**
     * Muestra el panel de modificación.
     */
    private void modifyButton() {
        MainFrame.cardLayout.show(MainFrame.cards, "modifyPanel");
    }

    /**
     * Realiza las acciones correspondientes al evento del botón de eliminación.
     *
     * @throws SQLException si ocurre un error de SQL
     */
    private void deleteButton() throws SQLException {

        String element = (String) jListPick.getSelectedValue();

        String[] el = element.split(" ");

        GeneralPickPanel.deleteElement();

        Delete.deletePayrrol(Integer.parseInt(el[0].replace(",", "")));
    }

    /**
     * Muestra el panel de selección de departamento.
     */
    private void chooseDepartmentButton() {
        alternateEmployeeButton.setVisible(true);
        alternateDepartmentButton.setVisible(false);

        listModel.removeAllElements();
        for (Department department : PayrollData.departments) {
            listModel.addElement(department.getCodeDept() + " " + department.getName());
        }

        titleLabel.setText(language.getProperty("chooseDep"));
    }

    /**
     * Muestra el panel de selección de empleado.
     */
    private void chooseEmployeeButton() {
        alternateEmployeeButton.setVisible(false);
        alternateDepartmentButton.setVisible(true);

        listModel.removeAllElements();
        for (Employee employee : PayrollData.employees) {
            listModel.addElement(employee.getName() + " " + employee.getFirstLastname() + " " + employee.getSecondLastname());
        }

        titleLabel.setText(language.getProperty("chooseEmp"));
    }
}
