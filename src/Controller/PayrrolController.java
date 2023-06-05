package Controller;

import Database.Insert;
import Database.Querys;
import View.PayrrolPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PayrrolController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        // Nominas Table

        String nif = PayrrolPanel.nifTxt.getText();

        String[] date = PayrrolPanel.settlementPeriodTxt.getText().split(" ");
        int year = Integer.parseInt(date[2]);
        String month = date[0];

        Double totalEarned = Double.valueOf(PayrrolPanel.totalEarnedTxt.getText());;

        Double totalNet = Double.valueOf(PayrrolPanel.totalNetReceivedTxt.getText());

        Double companyAp =  Double.valueOf(PayrrolPanel.totalTxt.getText());

        // Nom_percep table

            // Salary

            Double amountSp = Double.valueOf(PayrrolPanel.amount2Txt.getText());
            Double ohSp = Double.valueOf(PayrrolPanel.amount5Txt.getText());

            // Non-Salary

            Double amountCompAllow = Double.valueOf(PayrrolPanel.amount9Txt.getText());


        // Nom_reten table

        Double irpfPer = Double.valueOf(PayrrolPanel.irpfTxt.getText());
        Double amountIRPF = Double.valueOf(PayrrolPanel.amount18Txt.getText());

        Double atEpPer = Double.valueOf(PayrrolPanel.type5Txt.getText());
        Double amountATEP = Double.valueOf(PayrrolPanel.compTax2Txt.getText());



        // Nom_cot_trabajador table

        Double contingenciesPer = Double.valueOf(PayrrolPanel.typeTxt.getText());
        Double contingenciesAmount = Double.valueOf(PayrrolPanel.amount13Txt.getText());

        Double unEmploymentPer = Double.valueOf(PayrrolPanel.type1Txt.getText());
        Double unEmploymentAmount = Double.valueOf(PayrrolPanel.amount14Txt.getText());

        Double fpPer = Double.valueOf(PayrrolPanel.type2Txt.getText());
        Double fpAmount = Double.valueOf(PayrrolPanel.amount15Txt.getText());

        Double ohPer = Double.valueOf(PayrrolPanel.type3Txt.getText());
        Double ohAmount = Double.valueOf(PayrrolPanel.amount16Txt.getText());


        // Nom_cot_empresa

        Double unemploymentCompPer = Double.valueOf(PayrrolPanel.type6Txt.getText());
        Double unemploymentCompAmount = Double.valueOf(PayrrolPanel.compTax3Txt.getText());

        Double fpCompPer = Double.valueOf(PayrrolPanel.type7Txt.getText());
        Double fpCompAmount = Double.valueOf(PayrrolPanel.compTax4Txt.getText());


        Double fogasaPer = Double.valueOf(PayrrolPanel.type8Txt.getText());
        Double fogasaAmount = Double.valueOf(PayrrolPanel.compTax5Txt.getText());


        Double ohCompPer = Double.valueOf(PayrrolPanel.type9Txt.getText());
        Double ohCompAmount = Double.valueOf(PayrrolPanel.compTax6Txt.getText());


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
