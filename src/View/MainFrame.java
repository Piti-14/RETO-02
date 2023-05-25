package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static CardLayout cardLayout;
    public static JPanel cards;
    public static JMenuBar menuBar;

    public MainFrame() {
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension screensize = screen.getScreenSize();
        int screenHeight = screensize.height;
        int screenWidth = screensize.width;
        this.setSize(screenWidth, screenHeight);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        menuBar = new JMenuBar();
        menuBar.setVisible(false);

        JMenu menuArchive = new JMenu("Archivo");
        JMenuItem itemExport = new JMenuItem("Exportar");
        JMenu menuPayroll = new JMenu("Nóminas");
        JMenuItem itemNew = new JMenuItem("Crear Nóminas");
        JMenuItem itemModify = new JMenuItem("Modificar Nóminas");
        JMenuItem itemConsult = new JMenuItem("Consultar Nóminas");
        JMenuItem itemDelete = new JMenuItem("Eliminar Nóminas");
        JMenu menuPreferences = new JMenu("Preferencias");
        JMenu menuLanguage = new JMenu("Idioma");
        JMenuItem itemEs = new JMenuItem("Español");
        JMenuItem itemEn = new JMenuItem("Inglés");
        JMenu menuHelp = new JMenu("Ayuda");
        JMenuItem itemManual = new JMenuItem("Manual de Usuario");

        menuArchive.add(itemExport);
        menuPayroll.add(itemNew);
        menuPayroll.add(itemModify);
        menuPayroll.add(itemConsult);
        menuPayroll.add(itemDelete);
        menuPreferences.add(menuLanguage);
        menuLanguage.add(itemEs);
        menuLanguage.add(itemEn);
        menuHelp.add(itemManual);

        menuBar.add(menuArchive);
        menuBar.add(menuPayroll);
        menuBar.add(menuPreferences);
        menuBar.add(menuHelp);

        this.add(menuBar, BorderLayout.NORTH);

        // Gestion de Paneles

        LoginPanel loginPanel = new LoginPanel();
        MainPanel mainPanel = new MainPanel();
        AddPanel addPanel = new AddPanel();

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(loginPanel, "loginPanel");
        cards.add(mainPanel,"mainPanel");
        cards.add(addPanel,"addPanel");

        this.add(cards);
        this.setVisible(true);
    }
}