package Controller;

import Database.Insert;
import Database.Querys;
import View.PayrollPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Controlador para el panel de nómina.
 * Maneja los eventos del panel de nómina y realiza las acciones correspondientes.
 */
public class PayrollController implements ActionListener {

    /**
     * Se activa cuando se produce un evento.
     * Realiza las acciones correspondientes según el evento ocurrido.
     *
     * @param e el evento ocurrido
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Nominas Table

        String nif = PayrollPanel.nifTxt.getText();

        String[] date = PayrollPanel.settlementPeriodTxt.getText().split(" ");
        int year = Integer.parseInt(date[2]);
        String month = date[0];

        Double totalEarned = Double.valueOf(PayrollPanel.totalEarnedTxt.getText());

        Double totalNet = Double.valueOf(PayrollPanel.totalNetReceivedTxt.getText());

        Double companyAp =  Double.valueOf(PayrollPanel.totalTxt.getText());

        // Nom_percep table

        // Salary

        Double amountSp = Double.valueOf(PayrollPanel.amount2Txt.getText());
        Double ohSp = Double.valueOf(PayrollPanel.amount5Txt.getText());

        // Non-Salary

        Double amountCompAllow = Double.valueOf(PayrollPanel.amount9Txt.getText());


        // Nom_reten table

        Double irpfPer = Double.valueOf(PayrollPanel.irpfTxt.getText());
        Double amountIRPF = Double.valueOf(PayrollPanel.amount18Txt.getText());

        Double atEpPer = Double.valueOf(PayrollPanel.type5Txt.getText());
        Double amountATEP = Double.valueOf(PayrollPanel.compTax2Txt.getText());

        // Nom_cot_trabajador table

        Double contingenciesPer = Double.valueOf(PayrollPanel.typeTxt.getText());
        Double contingenciesAmount = Double.valueOf(PayrollPanel.amount13Txt.getText());

        Double unEmploymentPer = Double.valueOf(PayrollPanel.type1Txt.getText());
        Double unEmploymentAmount = Double.valueOf(PayrollPanel.amount14Txt.getText());

        Double fpPer = Double.valueOf(PayrollPanel.type2Txt.getText());
        Double fpAmount = Double.valueOf(PayrollPanel.amount15Txt.getText());

        Double ohPer = Double.valueOf(PayrollPanel.type3Txt.getText());
        Double ohAmount = Double.valueOf(PayrollPanel.amount16Txt.getText());

        // Nom_cot_empresa

        Double unemploymentCompPer = Double.valueOf(PayrollPanel.type6Txt.getText());
        Double unemploymentCompAmount = Double.valueOf(PayrollPanel.compTax3Txt.getText());

        Double fpCompPer = Double.valueOf(PayrollPanel.type7Txt.getText());
        Double fpCompAmount = Double.valueOf(PayrollPanel.compTax4Txt.getText());

        Double fogasaPer = Double.valueOf(PayrollPanel.type8Txt.getText());
        Double fogasaAmount = Double.valueOf(PayrollPanel.compTax5Txt.getText());

        Double ohCompPer = Double.valueOf(PayrollPanel.type9Txt.getText());
        Double ohCompAmount = Double.valueOf(PayrollPanel.compTax6Txt.getText());

        Double retentionPer = Double.valueOf(PayrollPanel.type4Txt.getText());
        Double retentionAmount = Double.valueOf(PayrollPanel.compTax3Txt.getText());

        try {
            Insert.insertPayroll(nif, year, month, totalEarned, totalNet, companyAp);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertNomPercep(Querys.getID(), amountSp, ohSp, amountCompAllow, nif);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertHoldbacks(Querys.getID(), irpfPer, amountIRPF, atEpPer, amountATEP);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertCotEmployee(Querys.getID(), contingenciesPer, contingenciesAmount, unEmploymentPer, unEmploymentAmount, fpPer, fpAmount, ohPer, ohAmount);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        try {
            Insert.insertCotCompany(Querys.getID(), unemploymentCompPer, unemploymentCompAmount, fpCompPer, fpCompAmount, fogasaPer, fogasaAmount, ohCompPer, ohCompAmount,retentionPer,retentionAmount);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
