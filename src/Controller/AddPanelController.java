package Controller;

import Database.Insert;
import Database.Querys;
import View.AddPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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





        // Nom_percep table

            // Salary

            Double amountSp = Double.valueOf(AddPanel.amount2Txt.getText());
            Double ohSp = Double.valueOf(AddPanel.amount5Txt.getText());

            // Non-Salary

            Double amountCompAllow = Double.valueOf(AddPanel.amount9Txt.getText());


        // Nom_reten table

        Double irpfPer = Double.valueOf(AddPanel.irpfTxt.getText());
        Double amountIRPF = Double.valueOf(AddPanel.amount18Txt.getText());

        Double atEpPer = Double.valueOf(AddPanel.type5Txt.getText());
        Double amountATEP = Double.valueOf(AddPanel.compTax2Txt.getText());



        // Nom_cot_trabajador table

        Double contingenciesPer = Double.valueOf(AddPanel.typeTxt.getText());
        Double contingenciesAmount = Double.valueOf(AddPanel.amount13Txt.getText());

        Double unEmploymentPer = Double.valueOf(AddPanel.type1Txt.getText());
        Double unEmploymentAmount = Double.valueOf(AddPanel.amount14Txt.getText());

        Double fpPer = Double.valueOf(AddPanel.type2Txt.getText());
        Double fpAmount = Double.valueOf(AddPanel.amount15Txt.getText());

        Double ohPer = Double.valueOf(AddPanel.type3Txt.getText());
        Double ohAmount = Double.valueOf(AddPanel.amount16Txt.getText());


        // Nom_cot_empresa

        Double unemploymentCompPer = Double.valueOf(AddPanel.type6Txt.getText());
        Double unemploymentCompAmount = Double.valueOf(AddPanel.compTax3Txt.getText());

        Double fpCompPer = Double.valueOf(AddPanel.type7Txt.getText());
        Double fpCompAmount = Double.valueOf(AddPanel.compTax4Txt.getText());


        Double fogasaPer = Double.valueOf(AddPanel.type8Txt.getText());
        Double fogasaAmount = Double.valueOf(AddPanel.compTax5Txt.getText());


        Double ohCompPer = Double.valueOf(AddPanel.type9Txt.getText());
        Double ohCompAmount = Double.valueOf(AddPanel.compTax6Txt.getText());








        try {
            Insert.insertPayrrol(nif, year, month, totalEarned, totalNet, companyAp);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        try {
            Insert.insertNomPercep(Querys.getID(),amountSp,ohSp,amountCompAllow,nif);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertHoldbacks(Querys.getID(),irpfPer,amountIRPF,atEpPer,amountATEP );
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertCotEmployee(Querys.getID(),contingenciesPer,contingenciesAmount,unEmploymentPer,unEmploymentAmount, fpPer, fpAmount, ohPer, ohAmount);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertCotCompany(Querys.getID(),unemploymentCompPer,unemploymentCompAmount,fpCompPer,fpCompAmount, fogasaPer, fogasaAmount, ohCompPer, ohCompAmount);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }





}
