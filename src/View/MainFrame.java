package View;

import Controller.MainFrameController;
import Controller.MainPanelController;
import Languages.Configuration;
import Languages.Language;
import Sources.Sources;
import View.Login.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    public static CardLayout cardLayout;
    public static JPanel cards;
    public static JMenuBar menuBar;
    public static JFrame frame;

    public MainFrame() throws SQLException {
        this.setVisible(true);
        frame = this;
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

        JMenuItem itemModify = new JMenuItem(language.getProperty("modify"));
        itemModify.addActionListener(new MainFrameController("itemModify"));

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
        menuPayroll.add(itemModify);
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
        AddPanel addPanel = new AddPanel();
        DeletePanel deletePanel = new DeletePanel();
        GeneralPickPanel generalPickPanel = new GeneralPickPanel();
        ConsultPanel consultPanel = new ConsultPanel();
        ModifyPanel modifyPanel = new ModifyPanel();

        menuBar.setVisible(false);
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(loginPanel, "loginPanel");
        cards.add(mainPanel,"mainPanel");
        cards.add(addPanel,"addPanel");
        cards.add(deletePanel, "deletePanel");
        cards.add(generalPickPanel,"playerPick");
        cards.add(consultPanel,"consultPanel");
        cards.add(modifyPanel, "modifyPanel");

        this.setIconImage(new ImageIcon(Sources.class.getResource("logoteaw.png")).getImage());
        this.add(menuBar, BorderLayout.NORTH);
        this.add(cards);
    }

}