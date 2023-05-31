package View;

import View.Utils.JLabelWallpaper;
import View.Utils.JPanelBlue;
import View.Utils.OffButton;
import View.Utils.PreviousButton;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AddPanel extends JPanel {

     JLabel companyLbl, employeeLbl, addressLbl, nifLbl, cifLbl, ssnLbl, bankNumberLbl, categoryLbl, contributionGroupLbl,
            settlementPeriodLbl, nDaysLbl, totalsLbl, earningsLbl, amountLbl, salaryPercepcionsLbl, baseSalaryLbl,
            salarySupplementsLbl, overtimeHoursLbl, complementaryHoursLbl, extraBonusesLbl, inKindSalaryLbl,
            nonSalaryPercepcionsLbl, compensationsOrAllowancesLbl, ssBenefitsCompensationsLbl, compensationsLbl,
            otherPerceptionsLbl, totalEarnedLbl, deductionsLbl, employeeContributionsLbl, typeLbl, type2Lbl, holdbacksLbl,
            unemploymentLbl, proTrainingLbl,   totalContributionsLbl, incomeTaxLbl, advancesLbl, valueProductsLbl,
             otherDeductionsLbl, totalDeductedLbl, totalNetReceivedLbl, companySignatureLbl, receivedLbl, determinationSSLbl,
             determinationSS2Lbl, baseContributionLbl, monthlyRemunerationLbl, extraPaymentsLbl, companyContributionLbl,
             baseLbl, professionalHoldbacksLbl, fogasaLbl, overtimeContributionLbl, totalLbl, dateLbl, conceptLbl, atEPLbl,
             unemployment2Lbl, fpLbl, total2Lbl;

    JTextField companyTxt, employeeTxt, addressTxt, nifTxt, cifTxt, ssnTxt, bankNumberTxt, categoryTxt, contributionGroupTxt,
            settlementPeriodTxt, nDaysTxt, salarySupplementsTxt, salarySupplements1Txt, salarySupplements2Txt,
            compensationsOrAllowancesTxt, ssBenefitsCompensationsTxt, compensationsTxt, otherPerceptionsTxt,
            totalEarnedTxt, totalDeductedTxt, totalNetReceivedTxt, monthlyRemunerationTxt, extraPaymentsTxt,
            totalTxt, amount1Txt, amount2Txt, amount3Txt, amount4Txt, amount5Txt, amount6Txt, amount7Txt, amount8Txt,
            amount9Txt, amount10Txt, amount11Txt, amount12Txt, amount13Txt, amount14Txt, amount15Txt, amount16Txt, amount17Txt,
            amount18Txt, amount19Txt, amount20Txt, amount21Txt, typeTxt, type1Txt, type2Txt, type3Txt, type4Txt, type5Txt,
            type6Txt, type7Txt, type8Txt, type9Txt, dateTxt, base1Txt, base2Txt, base3Txt, base4Txt, compTax1Txt, compTax2Txt,
            compTax3Txt, compTax4Txt, compTax5Txt, compTax6Txt;

    public AddPanel() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel topInfo = createPanelWithBorder(10,10,10,10,false);
        JPanel dateInfo = createPanelWithBorder(10,10,10,10,false);
        JPanel midInfo = createPanelWithBorder(10,40,10,10,false);
        JPanel botInfo = createPanelWithBorder(10,10,10,10,true);

        topInfo.setPreferredSize(new Dimension(800, 150));
        dateInfo.setPreferredSize(new Dimension(800, 50));
        midInfo.setPreferredSize(new Dimension(800, 800));
        botInfo.setPreferredSize(new Dimension(800, 300));

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

        bankNumberLbl = new JLabel("Bank Account:");
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

        ssnLbl = new JLabel("Social Security Nº:");
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
        midInfo.add(earningsLbl, constraints);

        amountLbl = new JLabel("AMOUNT");
        constraints.gridx = 3;
        constraints.gridy = 0;
        midInfo.add(amountLbl, constraints);

        totalsLbl = new JLabel("TOTALS");
        constraints.gridx = 4;
        constraints.gridy = 0;
        midInfo.add(totalsLbl, constraints);

        salaryPercepcionsLbl = new JLabel("1. Salary percepcions");
        constraints.gridx = 0;
        constraints.gridy = 1;
        midInfo.add(salaryPercepcionsLbl, constraints);

        baseSalaryLbl = new JLabel("Base salary:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        midInfo.add(baseSalaryLbl, constraints);

        amount1Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 2;
        midInfo.add(amount1Txt, constraints);

        salarySupplementsLbl = new JLabel("Salary supplements:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        midInfo.add(salarySupplementsLbl, constraints);

        salarySupplementsTxt = new JTextField(30);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 3;
        midInfo.add(salarySupplementsTxt, constraints);

        amount2Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 4;
        midInfo.add(amount2Txt, constraints);

        salarySupplements1Txt = new JTextField(30);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        midInfo.add(salarySupplements1Txt, constraints);

        amount3Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 5;
        midInfo.add(amount3Txt, constraints);

        salarySupplements2Txt = new JTextField(30);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 3;
        midInfo.add(salarySupplements2Txt, constraints);

        amount4Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 6;
        midInfo.add(amount4Txt, constraints);

        overtimeHoursLbl = new JLabel("Overtime Hours:");
        constraints.gridx = 0;
        constraints.gridy = 7;
        midInfo.add(overtimeHoursLbl, constraints);

        amount5Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 7;
        midInfo.add(amount5Txt, constraints);

        complementaryHoursLbl = new JLabel("Complementary Hours:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        midInfo.add(complementaryHoursLbl, constraints);

        amount6Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 8;
        midInfo.add(amount6Txt, constraints);

        extraBonusesLbl = new JLabel("Extra bonuses:");
        constraints.gridx = 0;
        constraints.gridy = 9;
        midInfo.add(extraBonusesLbl, constraints);

        amount7Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 9;
        midInfo.add(amount7Txt, constraints);

        inKindSalaryLbl = new JLabel("In-kind salary:");
        constraints.gridx = 0;
        constraints.gridy = 10;
        midInfo.add(inKindSalaryLbl, constraints);

        amount8Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 10;
        midInfo.add(amount8Txt, constraints);

        nonSalaryPercepcionsLbl = new JLabel("2. Non-salary perceptions:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        midInfo.add(nonSalaryPercepcionsLbl, constraints);

        compensationsOrAllowancesLbl = new JLabel("Compensations or allowances:");
        constraints.gridx = 0;
        constraints.gridy = 12;
        midInfo.add(compensationsOrAllowancesLbl, constraints);

        compensationsOrAllowancesTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 13;
        constraints.gridwidth = 3;
        midInfo.add(compensationsOrAllowancesTxt, constraints);

        amount9Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 13;
        midInfo.add(amount9Txt, constraints);

        ssBenefitsCompensationsLbl = new JLabel("Social security benefits and compensations:");
        constraints.gridx = 0;
        constraints.gridy = 14;
        midInfo.add(ssBenefitsCompensationsLbl, constraints);

        ssBenefitsCompensationsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 15;
        constraints.gridwidth = 3;
        midInfo.add(ssBenefitsCompensationsTxt, constraints);

        amount10Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 15;
        midInfo.add(amount10Txt, constraints);

        compensationsLbl = new JLabel("Compensations for transfers, suspensions or layoffs:");
        constraints.gridx = 0;
        constraints.gridy = 16;
        midInfo.add(compensationsLbl, constraints);

        compensationsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 17;
        constraints.gridwidth = 3;
        midInfo.add(compensationsTxt, constraints);

        amount11Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 17;
        midInfo.add(amount11Txt, constraints);

        otherPerceptionsLbl = new JLabel("Other non-salary perceptions:");
        constraints.gridx = 0;
        constraints.gridy = 18;
        midInfo.add(otherPerceptionsLbl, constraints);

        otherPerceptionsTxt = new JTextField(40);
        constraints.gridx = 0;
        constraints.gridy = 19;
        constraints.gridwidth = 3;
        midInfo.add(otherPerceptionsTxt, constraints);

        amount12Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 19;
        midInfo.add(amount12Txt, constraints);

        totalEarnedLbl = new JLabel("A. TOTAL EARNED:");
        constraints.gridx = 1;
        constraints.gridy = 20;
        midInfo.add(totalEarnedLbl, constraints);

        totalEarnedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 20;
        midInfo.add(totalEarnedTxt, constraints);

        deductionsLbl = new JLabel("II. DEDUCTIONS:");
        constraints.gridx = 0;
        constraints.gridy = 21;
        midInfo.add(deductionsLbl, constraints);

        employeeContributionsLbl = new JLabel("1. Employee's contribution to S.S. and joint collection concepts:");
        constraints.gridx = 0;
        constraints.gridy = 22;
        constraints.gridwidth = 3;
        midInfo.add(employeeContributionsLbl, constraints);

        typeLbl = new JLabel("TYPE %");
        constraints.gridx = 2;
        constraints.gridy = 23;
        midInfo.add(typeLbl, constraints);

        holdbacksLbl = new JLabel("Holdbacks:");
        constraints.gridx = 0;
        constraints.gridy = 24;
        constraints.gridwidth = 2;
        midInfo.add(holdbacksLbl, constraints);

        typeTxt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 24;
        midInfo.add(typeTxt, constraints);

        amount13Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 24;
        midInfo.add(amount13Txt, constraints);

        unemploymentLbl = new JLabel("Unemployment:");
        constraints.gridx = 0;
        constraints.gridy = 25;
        constraints.gridwidth = 2;
        midInfo.add(unemploymentLbl, constraints);

        type1Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 25;
        midInfo.add(type1Txt, constraints);

        amount14Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 25;
        midInfo.add(amount14Txt, constraints);

        proTrainingLbl = new JLabel("Professional training:");
        constraints.gridx = 0;
        constraints.gridy = 26;
        constraints.gridwidth = 2;
        midInfo.add(proTrainingLbl, constraints);

        type2Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 26;
        midInfo.add(type2Txt, constraints);

        amount15Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 26;
        midInfo.add(amount15Txt, constraints);

        overtimeHoursLbl = new JLabel("Normal overtime hours:");
        constraints.gridx = 0;
        constraints.gridy = 27;
        constraints.gridwidth = 2;
        midInfo.add(overtimeHoursLbl, constraints);

        type3Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 27;
        midInfo.add(type3Txt, constraints);

        amount16Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 27;
        midInfo.add(amount16Txt, constraints);

        totalContributionsLbl = new JLabel("TOTAL CONTRIBUTIONS:");
        constraints.gridx = 0;
        constraints.gridy = 28;
        midInfo.add(totalContributionsLbl, constraints);

        amount17Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 28;
        midInfo.add(amount17Txt, constraints);

        incomeTaxLbl = new JLabel("IRPF:");
        constraints.gridx = 0;
        constraints.gridy = 29;
        midInfo.add(incomeTaxLbl, constraints);

        amount18Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 29;
        midInfo.add(amount18Txt, constraints);

        advancesLbl = new JLabel("Advances:");
        constraints.gridx = 0;
        constraints.gridy = 30;
        midInfo.add(advancesLbl, constraints);

        amount19Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 30;
        midInfo.add(amount19Txt, constraints);

        valueProductsLbl = new JLabel("Value of goods received in kind:");
        constraints.gridx = 0;
        constraints.gridy = 31;
        midInfo.add(valueProductsLbl, constraints);

        amount20Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 31;
        midInfo.add(amount20Txt, constraints);

        otherDeductionsLbl = new JLabel("Other deductions:");
        constraints.gridx = 0;
        constraints.gridy = 32;
        midInfo.add(otherDeductionsLbl, constraints);

        amount21Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 32;
        midInfo.add(amount21Txt, constraints);

        totalDeductedLbl = new JLabel("B. TOTAL DEDUCTED:");
        constraints.gridx = 1;
        constraints.gridy = 33;
        midInfo.add(totalDeductedLbl, constraints);

        totalDeductedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 33;
        midInfo.add(totalDeductedTxt, constraints);

        totalNetReceivedLbl = new JLabel("TOTAL NET RECEIVED (A-B):");
        constraints.gridx = 1;
        constraints.gridy = 34;
        midInfo.add(totalNetReceivedLbl, constraints);

        dateTxt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 34;
        midInfo.add(dateTxt, constraints);

        totalNetReceivedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 34;
        midInfo.add(totalNetReceivedTxt, constraints);

        companySignatureLbl = new JLabel("Signature and company seal");
        constraints.gridx = 1;
        constraints.gridy = 35;
        midInfo.add(companySignatureLbl, constraints);

        dateLbl = new JLabel("Date");
        constraints.gridx = 3;
        constraints.gridy = 35;
        midInfo.add(dateLbl, constraints);

        receivedLbl = new JLabel("Received");
        constraints.gridx = 4;
        constraints.gridy = 35;
        midInfo.add(receivedLbl, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(midInfo, constraints);

        //CONTINGENCIAS EMPRESA

        determinationSSLbl = new JLabel("Determination of S.S. y contribution bases and concepts of joint and joint collection");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        botInfo.add(determinationSSLbl, constraints);

        determinationSS2Lbl = new JLabel("and of the base subject to personal income tax withholding and company contribution");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        botInfo.add(determinationSS2Lbl, constraints);

        conceptLbl = new JLabel("CONCEPT");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(conceptLbl, constraints);

        baseLbl = new JLabel("BASE");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(baseLbl, constraints);

        type2Lbl = new JLabel("TYPE %");
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(type2Lbl, constraints);

        companyContributionLbl = new JLabel("COMPANY CONTRIBUTION");
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(companyContributionLbl, constraints);

        baseContributionLbl = new JLabel("1. Common holdbacks");
        constraints.gridx = 0;
        constraints.gridy = 3;
        botInfo.add(baseContributionLbl, constraints);

        monthlyRemunerationLbl = new JLabel("Monthly remuneration:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        botInfo.add(monthlyRemunerationLbl, constraints);

        monthlyRemunerationTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        botInfo.add(monthlyRemunerationTxt, constraints);

        extraPaymentsLbl = new JLabel("Extra payments:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        botInfo.add(extraPaymentsLbl, constraints);

        extraPaymentsTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        botInfo.add(extraPaymentsTxt, constraints);

        totalLbl = new JLabel("TOTAL:");
        constraints.gridx = 1;
        constraints.gridy = 6;
        botInfo.add(totalLbl, constraints);

        base1Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 6;
        botInfo.add(base1Txt, constraints);

        type4Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 6;
        botInfo.add(type4Txt, constraints);

        compTax1Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 6;
        botInfo.add(compTax1Txt, constraints);

        professionalHoldbacksLbl = new JLabel("2. Professional holdbacks");
        constraints.gridx = 0;
        constraints.gridy = 7;
        botInfo.add(professionalHoldbacksLbl, constraints);

        atEPLbl = new JLabel("AT y EP:");
        constraints.gridx = 1;
        constraints.gridy = 7;
        botInfo.add(atEPLbl, constraints);

        type5Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 7;
        botInfo.add(type5Txt, constraints);

        compTax2Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 7;
        botInfo.add(compTax2Txt, constraints);

        unemployment2Lbl = new JLabel("Unemployment:");
        constraints.gridx = 1;
        constraints.gridy = 8;
        botInfo.add(unemployment2Lbl, constraints);

        type6Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 8;
        botInfo.add(type6Txt, constraints);

        compTax3Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 8;
        botInfo.add(compTax3Txt, constraints);

        fpLbl = new JLabel("FP:");
        constraints.gridx = 1;
        constraints.gridy = 9;
        botInfo.add(fpLbl, constraints);

        base2Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 9;
        botInfo.add(base2Txt, constraints);

        type7Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 9;
        botInfo.add(type7Txt, constraints);

        compTax4Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 9;
        botInfo.add(compTax4Txt, constraints);

        fogasaLbl = new JLabel("FOGASA:");
        constraints.gridx = 1;
        constraints.gridy = 10;
        botInfo.add(fogasaLbl, constraints);

        type8Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 10;
        botInfo.add(type8Txt, constraints);

        compTax5Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 10;
        botInfo.add(compTax5Txt, constraints);

        overtimeContributionLbl = new JLabel("3. Overtime contribution:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        botInfo.add(overtimeContributionLbl, constraints);

        type9Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 11;
        botInfo.add(type9Txt, constraints);

        base3Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 11;
        botInfo.add(base3Txt, constraints);

        compTax6Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 11;
        botInfo.add(compTax6Txt, constraints);

        incomeTaxLbl = new JLabel("4. Income tax withholding base:");
        constraints.gridx = 0;
        constraints.gridy = 12;
        botInfo.add(incomeTaxLbl, constraints);

        base4Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 12;
        botInfo.add(base4Txt, constraints);

        total2Lbl = new JLabel("TOTAL:");
        constraints.gridx = 3;
        constraints.gridy = 12;
        botInfo.add(total2Lbl, constraints);

        totalTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 12;
        botInfo.add(totalTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(botInfo, constraints);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setPreferredSize(new Dimension(800, 600));



        add(scrollPane, BorderLayout.CENTER);
        add(new OffButton(), BorderLayout.EAST);
        add(new PreviousButton(), BorderLayout.WEST);

        //add(new JPanelBlue());
        //add(new JLabelWallpaper());
    }

    private JPanel createPanelWithBorder(int topMargin, int bottomMargin, int leftMargin, int rightMargin, boolean includeBottomBorder) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        Border innerBorder = BorderFactory.createEmptyBorder(topMargin, leftMargin, bottomMargin, rightMargin);
        Border outerBorder;

        if (includeBottomBorder) {
            outerBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);
        } else {
            outerBorder = BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black);
        }

        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
        panel.setBorder(border);

        return panel;
    }
}