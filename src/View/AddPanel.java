package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddPanel extends JPanel {

     JLabel companyLbl, employeeLbl, addressLbl, nifLbl, cifLbl, ssnLbl, bankNumberLbl, categoryLbl, contributionGroupLbl,
            settlementPeriodLbl, nDaysLbl, totalsLbl, earningsLbl, amountLbl, salaryPercepcionsLbl, baseSalaryLbl,
            salarySupplementsLbl, overtimeHoursLbl, complementaryHoursLbl, extraBonusesLbl, inKindSalaryLbl,
            nonSalaryPercepcionsLbl, compensationsOrAllowancesLbl, ssBenefitsCompensationsLbl, compensationsLbl,
            otherPerceptionsLbl, totalEarnedLbl, deductionsLbl, employeeContributionsLbl, typeLbl, holdbacksLbl,
            unemploymentLbl, proTrainingLbl, normalOHLbl, mandatoryOHLbl, intergenerationalEMLbl, totalContributionsLbl,
            incomeTaxLbl, advancesLbl, valueProductsLbl, otherDeductionsLbl, totalDeductedLbl, totalNetReceivedLbl,
            companySignatureLbl, receivedLbl, determinationSSLbl, conceptsLbl, baseContributionLbl,
            monthlyRemunerationLbl, extraPaymentsLbl, total1Lbl, companyAportationLbl, baseLbl, baseHoldbacksLbl,
            otherConceptssLbl, jointLbl, fogasaLbl, contributionOHLbl, contributionMandatoryOHLbl, interEMLbl, baseSubjectLbl,
            totalLbl, invisLbl;

    JTextField companyTxt, employeeTxt, addressTxt, nifTxt, cifTxt, ssnTxt, bankNumberTxt, categoryTxt, contributionGroupTxt,
            settlementPeriodTxt, nDaysTxt, baseSalaryTxt,salarySupplementsTxt, salarySupplements1Txt, salarySupplements2Txt,
            overtimeHoursTxt, complementaryHoursTxt, extraBonusesTxt, inKindSalaryTxt,
            nonSalaryPercepcionsTxt, compensationsOrAllowancesTxt, ssBenefitsCompensationsTxt, compensationsTxt,
            otherPerceptionsTxt, totalEarnedTxt, deductionsTxt, employeeContributionsTxt, typeTxt, holdbacksTxt,
            unemploymentTxt, proTrainingTxt, normalOHTxt, mandatoryOHTxt, intergenerationalEMTxt, totalContributionsTxt,
            incomeTaxTxt, advancesTxt, valueProductsTxt, otherDeductionsTxt, totalDeductedTxt, totalNetReceivedTxt,
            companySignatureTxt, receivedTxt, determinationSSTxt, conceptsTxt, baseContributionTxt,
            monthlyRemunerationTxt, extraPaymentsTxt, total1Txt, companyAportationTxt, baseTxt, baseHoldbacksTxt,
            otherConceptssTxt, jointTxt, fogasaTxt, contributionOHTxt, contributionMandatoryOHTxt, interEMLblTxt, baseSubjectTxt,
            totalTxt, amount1Txt, amount2Txt, amount3Txt, amount4Txt, amount5Txt, amount6Txt, amount7Txt, amount8Txt, amount9Txt,
            amount10Txt, amount11Txt, invisTxt;

    public AddPanel() {
        setLayout(new GridBagLayout());

        JPanel companyInfo = createPanelWithBorder();
        JPanel employeeInfo = createPanelWithBorder();
        JPanel test1 = createPanelWithBorder();
        JPanel test2 = createPanelWithBorder();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 0, 10);

        companyLbl = new JLabel("Company:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        companyInfo.add(companyLbl, constraints);


        companyTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        companyInfo.add(companyTxt, constraints);

        addressLbl = new JLabel("Address:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        companyInfo.add(addressLbl, constraints);

        addressTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        companyInfo.add(addressTxt, constraints);

        cifLbl = new JLabel("CIF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        companyInfo.add(cifLbl, constraints);

        cifTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        companyInfo.add(cifTxt, constraints);

        bankNumberLbl = new JLabel("Bank Account Number:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        companyInfo.add(bankNumberLbl, constraints);

        bankNumberTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 3;
        companyInfo.add(bankNumberTxt, constraints);

        invisLbl = new JLabel("      ");
        constraints.gridx = 0;
        constraints.gridy = 4;
        companyInfo.add(invisLbl, constraints);

        invisTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        companyInfo.add(invisTxt, constraints);

        employeeLbl = new JLabel("Employee:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        employeeInfo.add(employeeLbl, constraints);

        employeeTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        employeeInfo.add(employeeTxt, constraints);

        nifLbl = new JLabel("NIF:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        employeeInfo.add(nifLbl, constraints);

        nifTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        employeeInfo.add(nifTxt, constraints);

        ssnLbl = new JLabel("Social Security Number:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        employeeInfo.add(ssnLbl, constraints);

        ssnTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        employeeInfo.add(ssnTxt, constraints);

        categoryLbl = new JLabel("Category:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        employeeInfo.add(categoryLbl, constraints);

        categoryTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 3;
        employeeInfo.add(categoryTxt, constraints);

        contributionGroupLbl = new JLabel("Contribution Group:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        employeeInfo.add(contributionGroupLbl, constraints);

        contributionGroupTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        employeeInfo.add(contributionGroupTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(companyInfo, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        add(employeeInfo, constraints);

        constraints.insets = new Insets(20, 0, 10, 10);

        settlementPeriodLbl = new JLabel("Settlement Period:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(settlementPeriodLbl, constraints);

        settlementPeriodTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(settlementPeriodTxt, constraints);

        nDaysLbl = new JLabel("Number of Days:");
        constraints.gridx = 2;
        constraints.gridy = 2;
        add(nDaysLbl, constraints);

        nDaysTxt = new JTextField(5);
        constraints.gridx = 3;
        constraints.gridy = 2;
        add(nDaysTxt, constraints);

        constraints.insets = new Insets(0, 0, 0, 10);

        earningsLbl = new JLabel("I. EARNINGS");
        constraints.gridx = 0;
        constraints.gridy = 0;
        test1.add(earningsLbl, constraints);

        amountLbl = new JLabel("AMOUNT");
        constraints.gridx = 2;
        constraints.gridy = 0;
        test1.add(amountLbl, constraints);

        totalsLbl = new JLabel("TOTALS");
        constraints.gridx = 3;
        constraints.gridy = 0;
        test1.add(totalsLbl, constraints);

        salaryPercepcionsLbl = new JLabel("1. Salary percepcions");
        constraints.gridx = 0;
        constraints.gridy = 1;
        test1.add(salaryPercepcionsLbl, constraints);

        baseSalaryLbl = new JLabel("Base salary:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        test1.add(baseSalaryLbl, constraints);

        baseSalaryTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        test1.add(baseSalaryTxt, constraints);

        amount1Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 2;
        test1.add(amount1Txt, constraints);

        salarySupplementsLbl = new JLabel("Salary supplements:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        test1.add(salarySupplementsLbl, constraints);

        salarySupplementsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        test1.add(salarySupplementsTxt, constraints);

        salarySupplements1Txt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        test1.add(salarySupplementsTxt, constraints);

        salarySupplements2Txt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        test1.add(salarySupplementsTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(test1, constraints);
    }

    private JPanel createPanelWithBorder() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(1, Color.black, Color.black),
                new EmptyBorder(10, 10, 10, 10)));

        return panel;
    }
}
