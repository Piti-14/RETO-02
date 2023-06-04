package View;

import Controller.AddPanelController;
import Languages.Configuration;
import Languages.Language;
import View.Utils.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class AddPanel extends JPanel {

     public static JLabel companyLbl, employeeLbl, addressLbl, nifLbl, cifLbl, ssnLbl, bankNumberLbl, categoryLbl, contributionGroupLbl,
            settlementPeriodLbl, nDaysLbl, totalsLbl, earningsLbl, amountLbl, salaryPercepcionsLbl, baseSalaryLbl,
            salarySupplementsLbl, overtimeHoursLbl, complementaryHoursLbl, extraBonusesLbl, inKindSalaryLbl,
            nonSalaryPercepcionsLbl, compensationsOrAllowancesLbl, ssBenefitsCompensationsLbl, compensationsLbl,
            otherPerceptionsLbl, totalEarnedLbl, deductionsLbl, employeeContributionsLbl, typeLbl, type2Lbl, holdbacksLbl,
            unemploymentLbl, proTrainingLbl,   totalContributionsLbl, incomeTaxLbl, advancesLbl, valueProductsLbl,
             otherDeductionsLbl, totalDeductedLbl, totalNetReceivedLbl, companySignatureLbl, receivedLbl, determinationSSLbl,
             determinationSS2Lbl, commonHoldbacksLbl, monthlyRemunerationLbl, extraPaymentsLbl, companyContributionLbl,
             baseLbl, professionalHoldbacksLbl, fogasaLbl, overtimeContributionLbl, totalLbl, dateLbl, conceptLbl, atEPLbl,
             unemployment2Lbl, fpLbl, total2Lbl;

    public static JTextField companyTxt, employeeTxt, addressTxt, nifTxt, cifTxt, ssnTxt, bankNumberTxt, categoryTxt, contributionGroupTxt,
            settlementPeriodTxt, nDaysTxt, salarySupplementsTxt, salarySupplements1Txt, salarySupplements2Txt,
            compensationsOrAllowancesTxt, ssBenefitsCompensationsTxt, compensationsTxt, otherPerceptionsTxt,
            totalEarnedTxt, totalDeductedTxt, totalNetReceivedTxt, monthlyRemunerationTxt, extraPaymentsTxt,
            totalTxt, amount1Txt, amount2Txt, amount3Txt, amount4Txt, amount5Txt, amount6Txt, amount7Txt, amount8Txt,
            amount9Txt, amount10Txt, amount11Txt, amount12Txt, amount13Txt, amount14Txt, amount15Txt, amount16Txt, amount17Txt,
            amount18Txt, amount19Txt, amount20Txt, amount21Txt, typeTxt, type1Txt, type2Txt, type3Txt, type4Txt, type5Txt,
            type6Txt, type7Txt, type8Txt, type9Txt, dateTxt, base1Txt, base2Txt, base3Txt, base4Txt, compTax1Txt, compTax2Txt,
            compTax3Txt, compTax4Txt, compTax5Txt, compTax6Txt, irpfTxt;

    public static ArrayList<JTextField> companyTextFields = new ArrayList<>();
    public static ArrayList<JTextField> employeeTextFields = new ArrayList<>();
    public static ArrayList<JTextField> employeeTypesTextFields = new ArrayList<>();
    public static ArrayList<JTextField> calculationsTextFields = new ArrayList<>();
    public static ArrayList<JTextField> companyTypesTextFields = new ArrayList<>();
    public static ArrayList<JTextField> dateTextFields = new ArrayList<>();
    public static ArrayList<JTextField> perceptionsTextFields = new ArrayList<>();

    public AddPanel() throws URISyntaxException, IOException {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel topInfo = createPanelWithBorder(10,10,10,10,false);
        JPanel dateInfo = createPanelWithBorder(10,10,10,10,false);
        JPanel midInfo = createPanelWithBorder(10,40,10,10,false);
        JPanel botInfo = createPanelWithBorder(10,10,10,10,false);
        JPanel exitSave = createPanelWithBorder(10,10,10,10,true);

        topInfo.setPreferredSize(new Dimension(800, 150));
        dateInfo.setPreferredSize(new Dimension(800, 50));
        midInfo.setPreferredSize(new Dimension(800, 800));
        botInfo.setPreferredSize(new Dimension(800, 300));
        exitSave.setPreferredSize(new Dimension(800, 100));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 0, 0, 10);

        //INFORMACIÓN EMPRESA Y EMPLEADO

        Configuration configuration = new Configuration();
        Language language = new Language(Integer.parseInt(configuration.getLanguage()));

        companyLbl = new JLabel(language.getProperty("companyLbl"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        topInfo.add(companyLbl, constraints);

        companyTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        topInfo.add(companyTxt, constraints);

        addressLbl = new JLabel(language.getProperty("addressLbl"));
        constraints.gridx = 0;
        constraints.gridy = 1;
        topInfo.add(addressLbl, constraints);

        addressTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        topInfo.add(addressTxt, constraints);

        cifLbl = new JLabel(language.getProperty("cifLbl"));
        constraints.gridx = 0;
        constraints.gridy = 2;
        topInfo.add(cifLbl, constraints);

        cifTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        topInfo.add(cifTxt, constraints);

        bankNumberLbl = new JLabel(language.getProperty("bankNumberLbl"));
        constraints.gridx = 0;
        constraints.gridy = 3;
        topInfo.add(bankNumberLbl, constraints);

        bankNumberTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        topInfo.add(bankNumberTxt, constraints);

        employeeLbl = new JLabel(language.getProperty("employeeLbl"));
        constraints.gridx = 2;
        constraints.gridy = 0;
        topInfo.add(employeeLbl, constraints);

        employeeTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 0;
        topInfo.add(employeeTxt, constraints);

        nifLbl = new JLabel(language.getProperty("nifLbl"));
        constraints.gridx = 2;
        constraints.gridy = 1;
        topInfo.add(nifLbl, constraints);

        nifTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 1;
        topInfo.add(nifTxt, constraints);

        ssnLbl = new JLabel(language.getProperty("ssnLbl"));
        constraints.gridx = 2;
        constraints.gridy = 2;
        topInfo.add(ssnLbl, constraints);

        ssnTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 2;
        topInfo.add(ssnTxt, constraints);

        categoryLbl = new JLabel(language.getProperty("categoryLbl"));
        constraints.gridx = 2;
        constraints.gridy = 3;
        topInfo.add(categoryLbl, constraints);

        categoryTxt = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 3;
        topInfo.add(categoryTxt, constraints);

        contributionGroupLbl = new JLabel(language.getProperty("contributionGroupLbl"));
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

        settlementPeriodLbl = new JLabel(language.getProperty("settlementPeriodLbl"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        dateInfo.add(settlementPeriodLbl, constraints);

        settlementPeriodTxt = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        dateInfo.add(settlementPeriodTxt, constraints);

        nDaysLbl = new JLabel(language.getProperty("nDaysLbl"));
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

        earningsLbl = new JLabel(language.getProperty("earningsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        midInfo.add(earningsLbl, constraints);

        amountLbl = new JLabel(language.getProperty("amountLbl"));
        constraints.gridx = 3;
        constraints.gridy = 0;
        midInfo.add(amountLbl, constraints);

        totalsLbl = new JLabel(language.getProperty("totalsLbl"));
        constraints.gridx = 4;
        constraints.gridy = 0;
        midInfo.add(totalsLbl, constraints);

        salaryPercepcionsLbl = new JLabel(language.getProperty("salaryPercepcionsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 1;
        midInfo.add(salaryPercepcionsLbl, constraints);

        baseSalaryLbl = new JLabel(language.getProperty("baseSalaryLbl"));
        constraints.gridx = 0;
        constraints.gridy = 2;
        midInfo.add(baseSalaryLbl, constraints);

        amount1Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 2;
        midInfo.add(amount1Txt, constraints);

        salarySupplementsLbl = new JLabel(language.getProperty("salarySupplementsLbl"));
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

        overtimeHoursLbl = new JLabel(language.getProperty("overtimeHoursLbl"));
        constraints.gridx = 0;
        constraints.gridy = 7;
        midInfo.add(overtimeHoursLbl, constraints);

        amount5Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 7;
        midInfo.add(amount5Txt, constraints);

        complementaryHoursLbl = new JLabel(language.getProperty("complementaryHoursLbl"));
        constraints.gridx = 0;
        constraints.gridy = 8;
        midInfo.add(complementaryHoursLbl, constraints);

        amount6Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 8;
        midInfo.add(amount6Txt, constraints);

        extraBonusesLbl = new JLabel(language.getProperty("extraBonusesLbl"));
        constraints.gridx = 0;
        constraints.gridy = 9;
        midInfo.add(extraBonusesLbl, constraints);

        amount7Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 9;
        midInfo.add(amount7Txt, constraints);

        inKindSalaryLbl = new JLabel(language.getProperty("inKindSalaryLbl"));
        constraints.gridx = 0;
        constraints.gridy = 10;
        midInfo.add(inKindSalaryLbl, constraints);

        amount8Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 10;
        midInfo.add(amount8Txt, constraints);

        nonSalaryPercepcionsLbl = new JLabel(language.getProperty("nonSalaryPercepcionsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 11;
        midInfo.add(nonSalaryPercepcionsLbl, constraints);

        compensationsOrAllowancesLbl = new JLabel(language.getProperty("compensationsOrAllowancesLbl"));
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

        ssBenefitsCompensationsLbl = new JLabel(language.getProperty("ssBenefitsCompensationsLbl"));
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

        compensationsLbl = new JLabel(language.getProperty("compensationsLbl"));
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

        otherPerceptionsLbl = new JLabel(language.getProperty("otherPerceptionsLbl"));
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

        totalEarnedLbl = new JLabel(language.getProperty("totalEarnedLbl"));
        constraints.gridx = 1;
        constraints.gridy = 20;
        midInfo.add(totalEarnedLbl, constraints);

        totalEarnedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 20;
        midInfo.add(totalEarnedTxt, constraints);

        deductionsLbl = new JLabel(language.getProperty("deductionsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 21;
        midInfo.add(deductionsLbl, constraints);

        employeeContributionsLbl = new JLabel(language.getProperty("employeeContributionsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 22;
        constraints.gridwidth = 3;
        midInfo.add(employeeContributionsLbl, constraints);

        typeLbl = new JLabel(language.getProperty("typeLbl"));
        constraints.gridx = 2;
        constraints.gridy = 23;
        midInfo.add(typeLbl, constraints);

        holdbacksLbl = new JLabel(language.getProperty("holdbacksLbl"));
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

        unemploymentLbl = new JLabel(language.getProperty("unemploymentLbl"));
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

        proTrainingLbl = new JLabel(language.getProperty("proTrainingLbl"));
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

        overtimeHoursLbl = new JLabel(language.getProperty("overtimeHoursLbl"));
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

        totalContributionsLbl = new JLabel(language.getProperty("totalContributionsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 28;
        midInfo.add(totalContributionsLbl, constraints);

        amount17Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 28;
        midInfo.add(amount17Txt, constraints);

        incomeTaxLbl = new JLabel(language.getProperty("incomeTaxLbl"));
        constraints.gridx = 0;
        constraints.gridy = 29;
        midInfo.add(incomeTaxLbl, constraints);

        irpfTxt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 29;
        midInfo.add(irpfTxt, constraints);

        amount18Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 29;
        midInfo.add(amount18Txt, constraints);

        advancesLbl = new JLabel(language.getProperty("advancesLbl"));
        constraints.gridx = 0;
        constraints.gridy = 30;
        midInfo.add(advancesLbl, constraints);

        amount19Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 30;
        midInfo.add(amount19Txt, constraints);

        valueProductsLbl = new JLabel(language.getProperty("valueProductsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 31;
        midInfo.add(valueProductsLbl, constraints);

        amount20Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 31;
        midInfo.add(amount20Txt, constraints);

        otherDeductionsLbl = new JLabel(language.getProperty("otherDeductionsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 32;
        midInfo.add(otherDeductionsLbl, constraints);

        amount21Txt = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 32;
        midInfo.add(amount21Txt, constraints);

        totalDeductedLbl = new JLabel(language.getProperty("totalDeductedLbl"));
        constraints.gridx = 1;
        constraints.gridy = 33;
        midInfo.add(totalDeductedLbl, constraints);

        totalDeductedTxt = new JTextField(10);
        constraints.gridx = 4;
        constraints.gridy = 33;
        midInfo.add(totalDeductedTxt, constraints);

        totalNetReceivedLbl = new JLabel(language.getProperty("totalNetReceivedLbl"));
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

        companySignatureLbl = new JLabel(language.getProperty("companySignatureLbl"));
        constraints.gridx = 1;
        constraints.gridy = 35;
        midInfo.add(companySignatureLbl, constraints);

        dateLbl = new JLabel(language.getProperty("dateLbl"));
        constraints.gridx = 3;
        constraints.gridy = 35;
        midInfo.add(dateLbl, constraints);

        receivedLbl = new JLabel(language.getProperty("receivedLbl"));
        constraints.gridx = 4;
        constraints.gridy = 35;
        midInfo.add(receivedLbl, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(midInfo, constraints);

        //CONTINGENCIAS EMPRESA

        determinationSSLbl = new JLabel(language.getProperty("determinationSSLbl"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        botInfo.add(determinationSSLbl, constraints);

        determinationSS2Lbl = new JLabel(language.getProperty("determinationSS2Lbl"));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        botInfo.add(determinationSS2Lbl, constraints);

        conceptLbl = new JLabel(language.getProperty("conceptLbl"));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(conceptLbl, constraints);

        baseLbl = new JLabel(language.getProperty("baseLbl"));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(baseLbl, constraints);

        type2Lbl = new JLabel(language.getProperty("type2Lbl"));
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(type2Lbl, constraints);

        companyContributionLbl = new JLabel(language.getProperty("companyContributionLbl"));
        constraints.gridx = 4;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        botInfo.add(companyContributionLbl, constraints);

        commonHoldbacksLbl = new JLabel(language.getProperty("commonHoldbacksLbl"));
        constraints.gridx = 0;
        constraints.gridy = 3;
        botInfo.add(commonHoldbacksLbl, constraints);

        monthlyRemunerationLbl = new JLabel(language.getProperty("monthlyRemunerationLbl"));
        constraints.gridx = 0;
        constraints.gridy = 4;
        botInfo.add(monthlyRemunerationLbl, constraints);

        monthlyRemunerationTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        botInfo.add(monthlyRemunerationTxt, constraints);

        extraPaymentsLbl = new JLabel(language.getProperty("extraPaymentsLbl"));
        constraints.gridx = 0;
        constraints.gridy = 5;
        botInfo.add(extraPaymentsLbl, constraints);

        extraPaymentsTxt = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        botInfo.add(extraPaymentsTxt, constraints);

        totalLbl = new JLabel(language.getProperty("totalLbl"));
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

        professionalHoldbacksLbl = new JLabel(language.getProperty("professionalHoldbacksLbl"));
        constraints.gridx = 0;
        constraints.gridy = 7;
        botInfo.add(professionalHoldbacksLbl, constraints);

        atEPLbl = new JLabel(language.getProperty("atEPLbl"));
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

        unemployment2Lbl = new JLabel(language.getProperty("unemployment2Lbl"));
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

        fpLbl = new JLabel(language.getProperty("fpLbl"));
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

        fogasaLbl = new JLabel(language.getProperty("fogasaLbl"));
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

        overtimeContributionLbl = new JLabel(language.getProperty("overtimeContributionLbl"));
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

        incomeTaxLbl = new JLabel(language.getProperty("incomeTaxLbl"));
        constraints.gridx = 0;
        constraints.gridy = 12;
        botInfo.add(incomeTaxLbl, constraints);

        base4Txt = new JTextField(10);
        constraints.gridx = 2;
        constraints.gridy = 12;
        botInfo.add(base4Txt, constraints);

        total2Lbl = new JLabel(language.getProperty("total2Lbl"));
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

        PreviousButton previousButton = new PreviousButton();
        previousButton.setPreferredSize(new Dimension(75, 75));
        constraints.gridx = 0;
        constraints.gridy = 0;
        exitSave.add(previousButton, constraints);

        SaveButton saveButton = new SaveButton();
        saveButton.addActionListener(new AddPanelController());
        saveButton.setPreferredSize(new Dimension(75, 75));
        constraints.gridx = 4;
        constraints.gridy = 0;
        exitSave.add(saveButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        mainPanel.add(exitSave, constraints);

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

        perceptionsTextFields.add(salarySupplementsTxt); //0
        perceptionsTextFields.add(salarySupplements1Txt);
        perceptionsTextFields.add(salarySupplements2Txt);
        perceptionsTextFields.add(compensationsOrAllowancesTxt);//3
        perceptionsTextFields.add(ssBenefitsCompensationsTxt);
        perceptionsTextFields.add(compensationsTxt);
        perceptionsTextFields.add(otherPerceptionsTxt);
        perceptionsTextFields.add(amount1Txt);//7
        perceptionsTextFields.add(amount2Txt);//8
        perceptionsTextFields.add(amount3Txt);
        perceptionsTextFields.add(amount4Txt);
        perceptionsTextFields.add(amount5Txt);//11
        perceptionsTextFields.add(amount6Txt);//12
        perceptionsTextFields.add(amount7Txt);
        perceptionsTextFields.add(amount8Txt);
        perceptionsTextFields.add(amount9Txt);//15
        perceptionsTextFields.add(amount10Txt);
        perceptionsTextFields.add(amount11Txt);
        perceptionsTextFields.add(amount12Txt);

        calculationsTextFields.add(totalEarnedTxt);
        calculationsTextFields.add(amount13Txt);
        calculationsTextFields.add(amount14Txt);
        calculationsTextFields.add(amount15Txt);
        calculationsTextFields.add(amount16Txt);
        calculationsTextFields.add(amount17Txt);
        calculationsTextFields.add(amount18Txt);
        calculationsTextFields.add(amount19Txt); //disable
        calculationsTextFields.add(amount20Txt); //disable
        calculationsTextFields.add(amount21Txt); //disable
        calculationsTextFields.add(totalDeductedTxt);
        calculationsTextFields.add(totalNetReceivedTxt);
        calculationsTextFields.add(monthlyRemunerationTxt);
        calculationsTextFields.add(extraPaymentsTxt);
        calculationsTextFields.add(totalTxt);
        calculationsTextFields.add(base1Txt);
        calculationsTextFields.add(base2Txt);
        calculationsTextFields.add(base3Txt);
        calculationsTextFields.add(base4Txt);
        calculationsTextFields.add(compTax1Txt);
        calculationsTextFields.add(compTax2Txt);
        calculationsTextFields.add(compTax3Txt);
        calculationsTextFields.add(compTax4Txt);
        calculationsTextFields.add(compTax5Txt);
        calculationsTextFields.add(compTax6Txt);

        employeeTypesTextFields.add(typeTxt);
        employeeTypesTextFields.add(type1Txt);
        employeeTypesTextFields.add(type2Txt);
        employeeTypesTextFields.add(type3Txt);
        employeeTypesTextFields.add(irpfTxt);

        companyTypesTextFields.add(type4Txt);
        companyTypesTextFields.add(type5Txt);
        companyTypesTextFields.add(type6Txt);
        companyTypesTextFields.add(type7Txt);
        companyTypesTextFields.add(type8Txt);
        companyTypesTextFields.add(type9Txt);
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