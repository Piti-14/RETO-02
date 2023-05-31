package View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class AddPanel extends JPanel {

     static JLabel companyLbl, employeeLbl, addressLbl, nifLbl, cifLbl, ssnLbl, bankNumberLbl, categoryLbl, contributionGroupLbl,
            settlementPeriodLbl, nDaysLbl, totalsLbl, earningsLbl, amountLbl, salaryPercepcionsLbl, baseSalaryLbl,
            salarySupplementsLbl, overtimeHoursLbl, complementaryHoursLbl, extraBonusesLbl, inKindSalaryLbl,
            nonSalaryPercepcionsLbl, compensationsOrAllowancesLbl, ssBenefitsCompensationsLbl, compensationsLbl,
            otherPerceptionsLbl, totalEarnedLbl, deductionsLbl, employeeContributionsLbl, typeLbl, type2Lbl, holdbacksLbl,
            unemploymentLbl, proTrainingLbl,   totalContributionsLbl, incomeTaxLbl, advancesLbl, valueProductsLbl,
             otherDeductionsLbl, totalDeductedLbl, totalNetReceivedLbl, companySignatureLbl, receivedLbl, determinationSSLbl,
             determinationSS2Lbl, baseContributionLbl, monthlyRemunerationLbl, extraPaymentsLbl, companyContributionLbl,
             baseLbl, professionalHoldbacksLbl, fogasaLbl, overtimeContributionLbl, totalLbl, dateLbl, conceptLbl, atEPLbl,
             unemployment2Lbl, fpLbl, total2Lbl;

    static JTextField companyTxt, employeeTxt, addressTxt, nifTxt, cifTxt, ssnTxt, bankNumberTxt, categoryTxt, contributionGroupTxt,
            settlementPeriodTxt, nDaysTxt, salarySupplementsTxt, salarySupplements1Txt, salarySupplements2Txt,
            compensationsOrAllowancesTxt, ssBenefitsCompensationsTxt, compensationsTxt, otherPerceptionsTxt,
            totalEarnedTxt, totalDeductedTxt, totalNetReceivedTxt, monthlyRemunerationTxt, extraPaymentsTxt,
            totalTxt, amount1Txt, amount2Txt, amount3Txt, amount4Txt, amount5Txt, amount6Txt, amount7Txt, amount8Txt,
            amount9Txt, amount10Txt, amount11Txt, amount12Txt, amount13Txt, amount14Txt, amount15Txt, amount16Txt, amount17Txt,
            amount18Txt, amount19Txt, amount20Txt, amount21Txt, typeTxt, type1Txt, type2Txt, type3Txt, type4Txt, type5Txt,
            type6Txt, type7Txt, type8Txt, type9Txt, dateTxt, base1Txt, base2Txt, base3Txt, base4Txt, compTax1Txt, compTax2Txt,
            compTax3Txt, compTax4Txt, compTax5Txt, compTax6Txt;

    public static ArrayList<JTextField> companyTextFields = new ArrayList<>();
    public static ArrayList<JTextField> employeeTextFields = new ArrayList<>();
    public static ArrayList<JTextField> employeeTypesTextFields = new ArrayList<>();

    public static ArrayList<JTextField> earningsTextFields = new ArrayList<>();
    public static ArrayList<JTextField> companyDeductionsTextFields = new ArrayList<>();
    public static ArrayList<JTextField> companyTypesTextFields = new ArrayList<>();
    public static ArrayList<JTextField> dateTextFields = new ArrayList<>();
    public static ArrayList<JTextField> perceptionsTextFields = new ArrayList<>();

    public AddPanel() {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel topInfo = createPanelWithBorder();
        JPanel dateInfo = createPanelWithBorder();
        JPanel test1 = createPanelWithBorder3();
        JPanel test2 = createPanelWithBorder2();

        topInfo.setPreferredSize(new Dimension(800, 150));
        dateInfo.setPreferredSize(new Dimension(800, 50));
        test1.setPreferredSize(new Dimension(800, 800));
        test2.setPreferredSize(new Dimension(800, 300));

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
        test1.add(compensationsLbl, constraints);

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

        overtimeHoursLbl = new JLabel("Normal overtime hours:");
        constraints.gridx = 0;
        constraints.gridy = 27;
        constraints.gridwidth = 2;
        test1.add(overtimeHoursLbl, constraints);

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
        test1.add(totalContributionsLbl, constraints);

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

        otherDeductionsLbl = new JLabel("Other deductions:");
        constraints.gridx = 0;
        constraints.gridy = 32;
        test1.add(otherDeductionsLbl, constraints);

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

        dateTxt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 34;
        test1.add(dateTxt, constraints);

        totalNetReceivedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 34;
        test1.add(totalNetReceivedTxt, constraints);

        companySignatureLbl = new JLabel("Signature and company seal");
        constraints.gridx = 1;
        constraints.gridy = 35;
        test1.add(companySignatureLbl, constraints);

        dateLbl = new JLabel("Date");
        constraints.gridx = 3;
        constraints.gridy = 35;
        test1.add(dateLbl, constraints);

        receivedLbl = new JLabel("Received");
        constraints.gridx = 4;
        constraints.gridy = 35;
        test1.add(receivedLbl, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(test1, constraints);

        //CONTINGENCIAS EMPRESA

        determinationSSLbl = new JLabel("Determination of S.S. y contribution bases and concepts of joint and joint collection");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        test2.add(determinationSSLbl, constraints);

        determinationSS2Lbl = new JLabel("and of the base subject to personal income tax withholding and company contribution");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        test2.add(determinationSS2Lbl, constraints);

        conceptLbl = new JLabel("CONCEPT");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        test2.add(conceptLbl, constraints);

        baseLbl = new JLabel("BASE");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        test2.add(baseLbl, constraints);

        type2Lbl = new JLabel("TYPE %");
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        test2.add(type2Lbl, constraints);

        companyContributionLbl = new JLabel("COMPANY CONTRIBUTION");
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        test2.add(companyContributionLbl, constraints);

        baseContributionLbl = new JLabel("1. Common holdbacks");
        constraints.gridx = 0;
        constraints.gridy = 3;
        test2.add(baseContributionLbl, constraints);

        monthlyRemunerationLbl = new JLabel("Monthly remuneration:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        test2.add(monthlyRemunerationLbl, constraints);

        monthlyRemunerationTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        test2.add(monthlyRemunerationTxt, constraints);

        extraPaymentsLbl = new JLabel("Extra payments:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        test2.add(extraPaymentsLbl, constraints);

        extraPaymentsTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        test2.add(extraPaymentsTxt, constraints);

        totalLbl = new JLabel("TOTAL:");
        constraints.gridx = 1;
        constraints.gridy = 6;
        test2.add(totalLbl, constraints);

        base1Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 6;
        test2.add(base1Txt, constraints);

        type4Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 6;
        test2.add(type4Txt, constraints);

        compTax1Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 6;
        test2.add(compTax1Txt, constraints);

        professionalHoldbacksLbl = new JLabel("2. Professional holdbacks");
        constraints.gridx = 0;
        constraints.gridy = 7;
        test2.add(professionalHoldbacksLbl, constraints);

        atEPLbl = new JLabel("AT y EP:");
        constraints.gridx = 1;
        constraints.gridy = 7;
        test2.add(atEPLbl, constraints);

        type5Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 7;
        test2.add(type5Txt, constraints);

        compTax2Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 7;
        test2.add(compTax2Txt, constraints);

        unemployment2Lbl = new JLabel("Unemployment:");
        constraints.gridx = 1;
        constraints.gridy = 8;
        test2.add(unemployment2Lbl, constraints);

        type6Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 8;
        test2.add(type6Txt, constraints);

        compTax3Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 8;
        test2.add(compTax3Txt, constraints);

        fpLbl = new JLabel("FP:");
        constraints.gridx = 1;
        constraints.gridy = 9;
        test2.add(fpLbl, constraints);

        base2Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 9;
        test2.add(base2Txt, constraints);

        type7Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 9;
        test2.add(type7Txt, constraints);

        compTax4Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 9;
        test2.add(compTax4Txt, constraints);

        fogasaLbl = new JLabel("FOGASA:");
        constraints.gridx = 1;
        constraints.gridy = 10;
        test2.add(fogasaLbl, constraints);

        type8Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 10;
        test2.add(type8Txt, constraints);

        compTax5Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 10;
        test2.add(compTax5Txt, constraints);

        overtimeContributionLbl = new JLabel("3. Overtime contribution:");
        constraints.gridx = 0;
        constraints.gridy = 11;
        test2.add(overtimeContributionLbl, constraints);

        type9Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 11;
        test2.add(type9Txt, constraints);

        base3Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 11;
        test2.add(base3Txt, constraints);

        compTax6Txt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 11;
        test2.add(compTax6Txt, constraints);

        incomeTaxLbl = new JLabel("4. Income tax withholding base:");
        constraints.gridx = 0;
        constraints.gridy = 12;
        test2.add(incomeTaxLbl, constraints);

        base4Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 12;
        test2.add(base4Txt, constraints);

        total2Lbl = new JLabel("TOTAL:");
        constraints.gridx = 3;
        constraints.gridy = 12;
        test2.add(total2Lbl, constraints);

        totalTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 12;
        test2.add(totalTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(test2, constraints);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        add(scrollPane, BorderLayout.CENTER);

        companyTextFields.add(companyTxt);
        companyTextFields.add(addressTxt);
        companyTextFields.add(cifTxt);
        companyTextFields.add(bankNumberTxt);

        employeeTextFields.add(employeeTxt);
        employeeTextFields.add(nifTxt);
        employeeTextFields.add(ssnTxt);
        employeeTextFields.add(categoryTxt);
        employeeTextFields.add(contributionGroupTxt);

        dateTextFields.add(settlementPeriodTxt);
        dateTextFields.add(nDaysTxt);
        dateTextFields.add(dateTxt);

        perceptionsTextFields.add(salarySupplementsTxt);
        perceptionsTextFields.add(salarySupplements1Txt);
        perceptionsTextFields.add(salarySupplements2Txt);
        perceptionsTextFields.add(compensationsOrAllowancesTxt);
        perceptionsTextFields.add(ssBenefitsCompensationsTxt);
        perceptionsTextFields.add(compensationsTxt);
        perceptionsTextFields.add(otherPerceptionsTxt);

        earningsTextFields.add(totalEarnedTxt);
        earningsTextFields.add(totalDeductedTxt);
        earningsTextFields.add(totalNetReceivedTxt);
        earningsTextFields.add(monthlyRemunerationTxt);
        earningsTextFields.add(extraPaymentsTxt);
        earningsTextFields.add(totalTxt);
        earningsTextFields.add(amount1Txt);
        earningsTextFields.add(amount2Txt);
        earningsTextFields.add(amount3Txt);
        earningsTextFields.add(amount4Txt);
        earningsTextFields.add(amount5Txt);
        earningsTextFields.add(amount6Txt);
        earningsTextFields.add(amount7Txt);
        earningsTextFields.add(amount8Txt);
        earningsTextFields.add(amount9Txt);
        earningsTextFields.add(amount10Txt);
        earningsTextFields.add(amount11Txt);
        earningsTextFields.add(amount12Txt);
        earningsTextFields.add(amount13Txt);
        earningsTextFields.add(amount14Txt);
        earningsTextFields.add(amount15Txt);
        earningsTextFields.add(amount16Txt);
        earningsTextFields.add(amount17Txt);
        earningsTextFields.add(amount18Txt);
        earningsTextFields.add(amount19Txt);
        earningsTextFields.add(amount20Txt);
        earningsTextFields.add(amount21Txt);

        employeeTypesTextFields.add(typeTxt);
        employeeTypesTextFields.add(type1Txt);
        employeeTypesTextFields.add(type2Txt);
        employeeTypesTextFields.add(type3Txt);

        companyTypesTextFields.add(type4Txt);
        companyTypesTextFields.add(type5Txt);
        companyTypesTextFields.add(type6Txt);
        companyTypesTextFields.add(type7Txt);
        companyTypesTextFields.add(type8Txt);
        companyTypesTextFields.add(type9Txt);

        companyDeductionsTextFields.add(base1Txt);
        companyDeductionsTextFields.add(base2Txt);
        companyDeductionsTextFields.add(base3Txt);
        companyDeductionsTextFields.add(base4Txt);
        companyDeductionsTextFields.add(compTax1Txt);
        companyDeductionsTextFields.add(compTax2Txt);
        companyDeductionsTextFields.add(compTax3Txt);
        companyDeductionsTextFields.add(compTax4Txt);
        companyDeductionsTextFields.add(compTax5Txt);
        companyDeductionsTextFields.add(compTax6Txt);
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

    private JPanel createPanelWithBorder2() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border outerBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black);

        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        panel.setBorder(border);

        return panel;
    }

    private JPanel createPanelWithBorder3() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 50, 10);
        Border outerBorder = BorderFactory.createMatteBorder(2, 2, 0, 2, Color.black);

        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        panel.setBorder(border);

        return panel;
    }
}