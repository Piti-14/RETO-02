package Controller;

import Database.Querys;
import Languages.Configuration;
import Languages.Language;
import View.GeneralPickPanel;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanelController implements ActionListener {

    //Querys querys = new Querys();

    Configuration configuration = new Configuration();
    Language language = new Language(Integer.parseInt(configuration.getLanguage()));

    String name;

    public MainPanelController(String name) {
        this.name = name;
    }

    public MainPanelController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (name.equals("addButton")) {
            createButton();
        }

        if (name.equals("modifyButton")){
            modifyButton();
        }

        if (name.equals("consultButton")) {
            consultButton();
        }

        if (name.equals("deleteButton")) {
            deleteButton();
        }
    }

    public void createButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(true);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.selectButton.setVisible(false);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();
    }

    public void modifyButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(true);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.selectButton.setVisible(false);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();
    }

    public void consultButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(true);
        GeneralPickPanel.jComboBox.setVisible(true);
        GeneralPickPanel.selectButton.setVisible(false);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();
    }

    public void deleteButton() {
        MainFrame.cardLayout.show(MainFrame.cards,"playerPick");
        GeneralPickPanel.deleteButton.setVisible(false);
        GeneralPickPanel.modifyButton.setVisible(false);
        GeneralPickPanel.chooseButton.setVisible(false);
        GeneralPickPanel.jComboBox.setVisible(false);
        GeneralPickPanel.consultButton.setVisible(false);
        GeneralPickPanel.selectButton.setVisible(true);
        GeneralPickPanel.alternateEmployeeButton.setVisible(false);
        GeneralPickPanel.alternateDepartmentButton.setVisible(true);
        GeneralPickPanel.titleLabel.setText(language.getProperty("chooseEmp"));
        GeneralPickPanel.listModel.removeAllElements();
        GeneralPickPanel.insertDataEmployees();

    }


}
