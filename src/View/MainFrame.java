package View;

import Controller.MainFrameController;
import Languages.Configuration;
import Languages.Language;
import Sources.Sources;
import View.Login.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    public static CardLayout cardLayout;
    public static JPanel cards;
    public static JMenuBar menuBar;

    public MainFrame() throws SQLException, URISyntaxException, IOException {
        this.setVisible(true);

        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;
        this.setSize(screenWidth, screenHeight);
        this.setLayout(new BorderLayout());

        Configuration configuration = new Configuration();
        Language language = new Language(Integer.parseInt(configuration.getLanguage()));

        JMenu menuArchive = new JMenu(language.getProperty("file"));
        JMenuItem itemExport = new JMenuItem(language.getProperty("export"));
        itemExport.addActionListener(new MainFrameController("itemExport"));

        JMenu menuPayroll = new JMenu(language.getProperty("payroll"));
        JMenuItem itemNew = new JMenuItem(language.getProperty("create"));
        itemNew.addActionListener(new MainFrameController("itemNew"));

        JMenuItem itemConsult = new JMenuItem(language.getProperty("consult"));
        itemConsult.addActionListener(new MainFrameController("itemConsult"));

        JMenuItem itemDelete = new JMenuItem(language.getProperty("delete"));
        itemDelete.addActionListener(new MainFrameController("itemDelete"));

        JMenu menuPreferences = new JMenu(language.getProperty("preferences"));
        JMenu menuLanguage = new JMenu(language.getProperty("language"));
        JMenuItem itemEs = new JMenuItem(language.getProperty("spanish"));
        itemEs.addActionListener(new MainFrameController("itemEs"));
        JMenuItem itemEn = new JMenuItem(language.getProperty("english"));
        itemEn.addActionListener(new MainFrameController("itemEn"));

        JMenu menuHelp = new JMenu(language.getProperty("help"));
        JMenuItem itemManual = new JMenuItem(language.getProperty("manual"));
        itemManual.addActionListener(new MainFrameController("itemManual"));

        menuArchive.add(itemExport);
        menuPayroll.add(itemNew);
        menuPayroll.add(itemConsult);
        menuPayroll.add(itemDelete);
        menuPreferences.add(menuLanguage);
        menuLanguage.add(itemEs);
        menuLanguage.add(itemEn);
        menuHelp.add(itemManual);

        menuBar = new JMenuBar();
        menuBar.add(menuArchive);
        menuBar.add(menuPayroll);
        menuBar.add(menuPreferences);
        menuBar.add(menuHelp);

        LoginPanel loginPanel = new LoginPanel();
        MainPanel mainPanel = new MainPanel();
        PayrollPanel payrrolPanel = new PayrollPanel();
        GeneralPickPanel generalPickPanel = new GeneralPickPanel();

        menuBar.setVisible(false);
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(loginPanel, "loginPanel");
        cards.add(mainPanel, "mainPanel");
        cards.add(payrrolPanel, "payrrolPanel");
        cards.add(generalPickPanel, "playerPick");

        this.setIconImage(new ImageIcon(Sources.class.getResource("logoteaw.png")).getImage());
        this.add(menuBar, BorderLayout.NORTH);
        this.add(cards);
    }

}