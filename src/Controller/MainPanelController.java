package Controller;

import Database.Querys;
import Languages.Configuration;
import Languages.Language;
import View.GeneralPickPanel;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

/**
 * Controlador para el panel principal del programa.
 * Maneja los eventos del panel principal y realiza acciones correspondientes.
 */
public class MainPanelController implements ActionListener {

    //Querys querys = new Querys();

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    String name;

    /**
     * Crea una instancia del controlador del panel principal con el nombre especificado.
     *
     * @param name el nombre del controlador
     * @throws URISyntaxException si se produce un error de sintaxis URI
     */
    public MainPanelController(String name) throws URISyntaxException {
        this.name = name;
    }

    /**
     * Crea una instancia del controlador del panel principal.
     *
     * @throws URISyntaxException si se produce un error de sintaxis URI
     */
    public MainPanelController() throws URISyntaxException {

    }

    /**
     * Se activa cuando se produce un evento.
     * Realiza las acciones correspondientes según el evento ocurrido.
     *
     * @param e el evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (name.equals("addButton")) {
            createButton();
        }

        if (name.equals("consultButton")) {
            consultButton();
        }

        if (name.equals("deleteButton")) {
            deleteButton();
        }
    }

    /**
     * Acción realizada al presionar el botón de crear.
     * Muestra la vista de selección general con opciones para elegir un departamento.
     */
    public void createButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(true);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.selectButton.setVisible(false);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.selectConsultButton.setVisible(false);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();
    }

    /**
     * Acción realizada al presionar el botón de consultar.
     * Muestra la vista de selección general con opciones para elegir un empleado y un período de tiempo.
     */
    public void consultButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.selectButton.setVisible(false);
        GeneralPickPanel.selectConsultButton.setVisible(true);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();
    }

    /**
     * Acción realizada al presionar el botón de eliminar.
     * Muestra la vista de selección general con opciones para elegir un empleado.
     */
    public void deleteButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.selectConsultButton.setVisible(false);
        GeneralPickPanel.selectButton.setVisible(true);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();
    }
}
