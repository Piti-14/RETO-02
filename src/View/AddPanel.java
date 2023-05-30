package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AddPanel extends JPanel {

     JLabel companyLbl, employeeLbl, addressLbl, nifLbl, cifLbl, ssnLbl, bankNumberLbl, categoryLbl, contributionGroupLbl,
            settlementPeriodLbl, nDaysLbl, totalsLbl, earningsLbl, amountLbl, salaryPercepcionsLbl, baseSalaryLbl,
            salarySupplementsLbl, overtimeHoursLbl, complementaryHoursLbl, extraBonusesLbl, inKindSalaryLbl,
            nonSalaryPercepcionsLbl, compensationsOrAllowancesLbl, ssBenefitsCompensationsLbl, compensationsLbl,
            otherPerceptionsLbl, totalEarnedLbl, deductionsLbl, employeeContributionsLbl, typeLbl, holdbacksLbl,
            unemploymentLbl, proTrainingLbl, overtimeHours, mandatoryOHLbl, intergenerationalEMLbl, totalContributionsLbl,
            incomeTaxLbl, advancesLbl, valueProductsLbl, otherDeductionsLbl, totalDeductedLbl, totalNetReceivedLbl,
            companySignatureLbl, receivedLbl, determinationSSLbl, conceptsLbl, baseContributionLbl,
            monthlyRemunerationLbl, extraPaymentsLbl, total1Lbl, companyAportationLbl, baseLbl, baseHoldbacksLbl,
            otherConceptssLbl, jointLbl, fogasaLbl, contributionOHLbl, contributionMandatoryOHLbl, interEMLbl, baseSubjectLbl,
            totalLbl, dateLbl;

    JTextField companyTxt, employeeTxt, addressTxt, nifTxt, cifTxt, ssnTxt, bankNumberTxt, categoryTxt, contributionGroupTxt,
            settlementPeriodTxt, nDaysTxt, salarySupplementsTxt, salarySupplements1Txt, salarySupplements2Txt,
            compensationsOrAllowancesTxt, ssBenefitsCompensationsTxt, compensationsTxt,
            otherPerceptionsTxt, totalEarnedTxt, deductionsTxt, employeeContributionsTxt, holdbacksTxt,
            unemploymentTxt, proTrainingTxt, normalOHTxt, mandatoryOHTxt, intergenerationalEMTxt, totalContributionsTxt,
            incomeTaxTxt, advancesTxt, valueProductsTxt, otherDeductionsTxt, totalDeductedTxt, totalNetReceivedTxt,
            companySignatureTxt, receivedTxt, determinationSSTxt, conceptsTxt, baseContributionTxt,
            monthlyRemunerationTxt, extraPaymentsTxt, total1Txt, companyAportationTxt, baseTxt, baseHoldbacksTxt,
            otherConceptssTxt, jointTxt, fogasaTxt, contributionOHTxt, contributionMandatoryOHTxt, interEMLblTxt, baseSubjectTxt,
            totalTxt, amount1Txt, amount2Txt, amount3Txt, amount4Txt, amount5Txt, amount6Txt, amount7Txt, amount8Txt, amount9Txt,
            amount10Txt, amount11Txt, amount12Txt, amount13Txt, amount14Txt, amount15Txt, amount16Txt, amount17Txt, amount18Txt,
            amount19Txt, amount20Txt, amount21Txt, typeTxt, type1Txt, type2Txt, type3Txt, type4Txt, type5Txt, dateTxt;

    public AddPanel() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel topInfo = createPanelWithBorder();
        JPanel dateInfo = createPanelWithBorder();
        JPanel test1 = createPanelWithBorder();
        JPanel test2 = createPanelWithBorder();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 0, 10);

        //INFORMACIÓN EMPRESA Y EMPLEADO

        companyLbl = new JLabel("Company:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        topInfo.add(companyLbl, constraints);

        companyTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        topInfo.add(companyTxt, constraints);

        addressLbl = new JLabel("Address:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        topInfo.add(addressLbl, constraints);

        addressTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        topInfo.add(addressTxt, constraints);

        cifLbl = new JLabel("CIF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        topInfo.add(cifLbl, constraints);

        cifTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        topInfo.add(cifTxt, constraints);

        bankNumberLbl = new JLabel("Bank Account Number:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        topInfo.add(bankNumberLbl, constraints);

        bankNumberTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        topInfo.add(bankNumberTxt, constraints);

        employeeLbl = new JLabel("Employee:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        topInfo.add(employeeLbl, constraints);

        employeeTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 0;
        topInfo.add(employeeTxt, constraints);

        nifLbl = new JLabel("NIF:");
        constraints.gridx = 2;
        constraints.gridy = 1;
        topInfo.add(nifLbl, constraints);

        nifTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 1;
        topInfo.add(nifTxt, constraints);

        ssnLbl = new JLabel("Social Security Number:");
        constraints.gridx = 2;
        constraints.gridy = 2;
        topInfo.add(ssnLbl, constraints);

        ssnTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 2;
        topInfo.add(ssnTxt, constraints);

        categoryLbl = new JLabel("Professional Group:");
        constraints.gridx = 2;
        constraints.gridy = 3;
        topInfo.add(categoryLbl, constraints);

        categoryTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 3;
        topInfo.add(categoryTxt, constraints);

        contributionGroupLbl = new JLabel("Contribution Group:");
        constraints.gridx = 2;
        constraints.gridy = 4;
        topInfo.add(contributionGroupLbl, constraints);

        contributionGroupTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 4;
        topInfo.add(contributionGroupTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(topInfo, constraints);

        //INFORMACIÓN DE LA FECHA

        settlementPeriodLbl = new JLabel("Settlement Period:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        dateInfo.add(settlementPeriodLbl, constraints);

        settlementPeriodTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        dateInfo.add(settlementPeriodTxt, constraints);

        nDaysLbl = new JLabel("Number of Days:");
        constraints.gridx = 2;
        constraints.gridy = 0;
        dateInfo.add(nDaysLbl, constraints);

        nDaysTxt = new JTextField(5);
        constraints.gridx = 3;
        constraints.gridy = 0;
        dateInfo.add(nDaysTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(dateInfo, constraints);

        //INFORMACIÓN DEVENGOS

        earningsLbl = new JLabel("I. EARNINGS");
        constraints.gridx = 0;
        constraints.gridy = 0;
        test1.add(earningsLbl, constraints);

        amountLbl = new JLabel("AMOUNT");
        constraints.gridx = 3;
        constraints.gridy = 0;
        test1.add(amountLbl, constraints);

        totalsLbl = new JLabel("TOTALS");
        constraints.gridx = 4;
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

        amount1Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 2;
        test1.add(amount1Txt, constraints);

        salarySupplementsLbl = new JLabel("Salary supplements:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        test1.add(salarySupplementsLbl, constraints);

        salarySupplementsTxt = new JTextField(30);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        test1.add(salarySupplementsTxt, constraints);

        amount2Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 4;
        test1.add(amount2Txt, constraints);

        salarySupplements1Txt = new JTextField(30);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        test1.add(salarySupplements1Txt, constraints);

        amount3Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 5;
        test1.add(amount3Txt, constraints);

        salarySupplements2Txt = new JTextField(30);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 3;
        test1.add(salarySupplements2Txt, constraints);

        amount4Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 6;
        test1.add(amount4Txt, constraints);

        overtimeHoursLbl = new JLabel("Overtime Hours:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        test1.add(overtimeHoursLbl, constraints);

        amount5Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 7;
        test1.add(amount5Txt, constraints);

        complementaryHoursLbl = new JLabel("Complementary Hours:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        test1.add(complementaryHoursLbl, constraints);

        amount6Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 8;
        test1.add(amount6Txt, constraints);

        extraBonusesLbl = new JLabel("Extra bonuses:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        test1.add(extraBonusesLbl, constraints);

        amount7Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 9;
        test1.add(amount7Txt, constraints);

        inKindSalaryLbl = new JLabel("In-kind salary:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        test1.add(inKindSalaryLbl, constraints);

        amount8Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 10;
        test1.add(amount8Txt, constraints);

        nonSalaryPercepcionsLbl = new JLabel("2. Non-salary perceptions:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        test1.add(nonSalaryPercepcionsLbl, constraints);

        compensationsOrAllowancesLbl = new JLabel("Compensations or allowances:");
        constraints.gridx = 0;
        constraints.gridy = 12;
        test1.add(compensationsOrAllowancesLbl, constraints);

        compensationsOrAllowancesTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 13;
        constraints.gridwidth = 3;
        test1.add(compensationsOrAllowancesTxt, constraints);

        amount9Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 13;
        test1.add(amount9Txt, constraints);

        ssBenefitsCompensationsLbl = new JLabel("Social security benefits and compensations:");
        constraints.gridx = 0;
        constraints.gridy = 14;
        test1.add(ssBenefitsCompensationsLbl, constraints);

        ssBenefitsCompensationsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 15;
        constraints.gridwidth = 3;
        test1.add(ssBenefitsCompensationsTxt, constraints);

        amount10Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 15;
        test1.add(amount10Txt, constraints);

        compensationsLbl = new JLabel("Compensations for transfers, suspensions or layoffs:");
        constraints.gridx = 0;
        constraints.gridy = 16;
        test1.add(ssBenefitsCompensationsLbl, constraints);

        compensationsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 17;
        constraints.gridwidth = 3;
        test1.add(compensationsTxt, constraints);

        amount11Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 17;
        test1.add(amount11Txt, constraints);

        otherPerceptionsLbl = new JLabel("Other non-salary perceptions:");
        constraints.gridx = 0;
        constraints.gridy = 18;
        test1.add(otherPerceptionsLbl, constraints);

        otherPerceptionsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 19;
        constraints.gridwidth = 3;
        test1.add(otherPerceptionsTxt, constraints);

        amount12Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 19;
        test1.add(amount12Txt, constraints);

        totalEarnedLbl = new JLabel("A. TOTAL EARNED:");
        constraints.gridx = 1;
        constraints.gridy = 20;
        test1.add(totalEarnedLbl, constraints);

        totalEarnedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 20;
        test1.add(totalEarnedTxt, constraints);

        deductionsLbl = new JLabel("II. DEDUCTIONS:");
        constraints.gridx = 0;
        constraints.gridy = 21;
        test1.add(deductionsLbl, constraints);

        employeeContributionsLbl = new JLabel("1. Employee's contribution to S.S. and joint collection concepts:");
        constraints.gridx = 0;
        constraints.gridy = 22;
        constraints.gridwidth = 3;
        test1.add(employeeContributionsLbl, constraints);

        typeLbl = new JLabel("TYPE %");
        constraints.gridx = 2;
        constraints.gridy = 23;
        test1.add(typeLbl, constraints);

        holdbacksLbl = new JLabel("Holdbacks:");
        constraints.gridx = 0;
        constraints.gridy = 24;
        constraints.gridwidth = 2;
        test1.add(holdbacksLbl, constraints);

        typeTxt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 24;
        test1.add(typeTxt, constraints);

        amount13Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 24;
        test1.add(amount13Txt, constraints);

        unemploymentLbl = new JLabel("Unemployment:");
        constraints.gridx = 0;
        constraints.gridy = 25;
        constraints.gridwidth = 2;
        test1.add(unemploymentLbl, constraints);

        type1Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 25;
        test1.add(type1Txt, constraints);

        amount14Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 25;
        test1.add(amount14Txt, constraints);

        proTrainingLbl = new JLabel("Professional training:");
        constraints.gridx = 0;
        constraints.gridy = 26;
        constraints.gridwidth = 2;
        test1.add(proTrainingLbl, constraints);

        type2Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 26;
        test1.add(type2Txt, constraints);

        amount15Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 26;
        test1.add(amount15Txt, constraints);

        overtimeHours = new JLabel("Normal overtime hours:");
        constraints.gridx = 0;
        constraints.gridy = 27;
        constraints.gridwidth = 2;
        test1.add(overtimeHours, constraints);

        type3Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 27;
        test1.add(type3Txt, constraints);

        amount16Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 27;
        test1.add(amount16Txt, constraints);

        totalContributionsLbl = new JLabel("TOTAL CONTRIBUTIONS:");
        constraints.gridx = 0;
        constraints.gridy = 28;
        test1.add(overtimeHours, constraints);

        amount17Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 28;
        test1.add(amount17Txt, constraints);

        incomeTaxLbl = new JLabel("IRPF:");
        constraints.gridx = 0;
        constraints.gridy = 29;
        test1.add(incomeTaxLbl, constraints);

        amount18Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 29;
        test1.add(amount18Txt, constraints);

        advancesLbl = new JLabel("Advances:");
        constraints.gridx = 0;
        constraints.gridy = 30;
        test1.add(advancesLbl, constraints);

        amount19Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 30;
        test1.add(amount19Txt, constraints);

        valueProductsLbl = new JLabel("Value of goods received in kind:");
        constraints.gridx = 0;
        constraints.gridy = 31;
        test1.add(valueProductsLbl, constraints);

        amount20Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 31;
        test1.add(amount20Txt, constraints);

        otherDeductionsLbl = new JLabel("Value of goods received in kind:");
        constraints.gridx = 0;
        constraints.gridy = 32;
        test1.add(otherDeductionsTxt, constraints);

        amount21Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 32;
        test1.add(amount21Txt, constraints);

        totalDeductedLbl = new JLabel("B. TOTAL DEDUCTED:");
        constraints.gridx = 1;
        constraints.gridy = 33;
        test1.add(totalDeductedLbl, constraints);

        totalDeductedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 33;
        test1.add(totalDeductedTxt, constraints);

        totalNetReceivedLbl = new JLabel("TOTAL NET RECEIVED (A-B):");
        constraints.gridx = 1;
        constraints.gridy = 34;
        test1.add(totalNetReceivedLbl, constraints);

        dateLbl = new JLabel("Date:");
        constraints.gridx = 2;
        constraints.gridy = 34;
        test1.add(dateLbl, constraints);

        dateTxt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 34;
        test1.add(dateTxt, constraints);

        totalNetReceivedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 34;
        test1.add(totalNetReceivedTxt, constraints);

        companySignatureLbl = new JLabel("Signature and company seal:");
        constraints.gridx = 1;
        constraints.gridy = 35;
        test1.add(companySignatureLbl, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(test1, constraints);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createPanelWithBorder() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border outerBorder = BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black);

        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        panel.setBorder(border);

        return panel;
    }
}
