package Controller;

import View.AddPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        // Nominas Table

        String nif = AddPanel.nifTxt.getText();

        String[] date = AddPanel.settlementPeriodTxt.getText().split(" ");
        int year = Integer.parseInt(date[2]);
        String month = date[0];

        Double totalEarned = Double.valueOf(AddPanel.totalEarnedTxt.getText());;

        Double totalNet = Double.valueOf(AddPanel.totalNetReceivedTxt.getText());

        Double companyAp =  Double.valueOf(AddPanel.totalTxt.getText());

        // Non_percep table

            // Salary

            String salarySp = AddPanel.salarySupplementsTxt.getText();
            Double amountSp = Double.valueOf(AddPanel.amount2Txt.getText());

            // Non-Salary

            String compAllow = AddPanel.compensationsOrAllowancesTxt.getText();
            Double amountCompAllow = Double.valueOf(AddPanel.amount9Txt.getText());


        // Nom_reten table

        Double irpfPer = Double.valueOf(AddPanel.irpfTxt.getText());
        Double irpfAmount = Double.valueOf(AddPanel.amount18Txt.getText());

        Double apEp = Double.valueOf(AddPanel.type5Txt.getText());

        // Nom_cot_trabajador table

        Double holdbackPer = Double.valueOf(AddPanel.typeTxt.getText());
        Double holdbackAmount = Double.valueOf(AddPanel.amount13Txt.getText());

        Double unEmploymentPer = Double.valueOf(AddPanel.type1Txt.getText());
        Double unEmploymentAmount = Double.valueOf(AddPanel.amount14Txt.getText());

        Double fpPer = Double.valueOf(AddPanel.type2Txt.getText());
        Double fpAmount = Double.valueOf(AddPanel.amount15Txt.getText());

        Double ohPer = Double.valueOf(AddPanel.type3Txt.getText());
        Double ohAmount = Double.valueOf(AddPanel.amount16Txt.getText());


        // Nom_cot_empresa

        Double unemployment = Double.valueOf(AddPanel.type6Txt.getText());

        Double fp = Double.valueOf(AddPanel.type7Txt.getText());

        Double fogasa = Double.valueOf(AddPanel.type8Txt.getText());

        Double oH = Double.valueOf(AddPanel.type9Txt.getText());

        // VA A TRABAJADOR

        Double apepPer = Double.valueOf(AddPanel.type5Txt.getText());












    }


}
