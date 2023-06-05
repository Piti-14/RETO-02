package Database;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene métodos para insertar registros en la base de datos.
 */
public class Insert {
    private static Connection connect = ConnectionDB.Connect();

    /**
     * Inserta una nómina en la base de datos.
     *
     * @param nif         el NIF del empleado
     * @param ano_n       el año de la nómina
     * @param mes_n       el mes de la nómina
     * @param total_dev   el total devengado
     * @param total_net   el total neto
     * @param ap_empresa  la aportación de la empresa
     * @throws SQLException si ocurre algún error de SQL durante la inserción
     */
    public static void insertPayrrol(String nif, int ano_n, String mes_n, Double total_dev, Double total_net, Double ap_empresa) throws SQLException {
        String sql = "INSERT INTO nominas(nif,ano_n,mes_n,total_dev,total_net,ap_empresa) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nif);
            pstmt.setInt(2, ano_n);
            pstmt.setString(3, mes_n);
            pstmt.setDouble(4, total_dev);
            pstmt.setDouble(5, total_net);
            pstmt.setDouble(6, ap_empresa);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        connect = ConnectionDB.Connect();
    }

    /**
     * Inserta los detalles de percepciones en la nómina.
     *
     * @param id_nom            el ID de la nómina
     * @param amountSp          el importe de la antigüedad
     * @param ohSp              el importe de horas extras
     * @param amountCompAllow   el importe de las compensaciones no salariales
     * @param nif               el NIF del empleado
     * @throws SQLException si ocurre algún error de SQL durante la inserción
     */
    public static void insertNomPercep(int id_nom, Double amountSp, Double ohSp, Double amountCompAllow, String nif) throws SQLException {
        String sql = "INSERT INTO nom_percep(id_nom,cod_p,cant) VALUES(?,?,?)";

        ArrayList<String> perInd = Querys.getPerInd(nif);
        ArrayList<String> perGr = Querys.getPerGroup(nif);

        //ANTIGUEDAD
        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nom);
            pstmt.setString(2, perInd.get(0));
            pstmt.setDouble(3, amountSp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        //HE
        try (Connection conn = connect;
             PreparedStatement pstmt2 = conn.prepareStatement(sql)) {
            pstmt2.setInt(1, id_nom);
            pstmt2.setString(2, perInd.get(1));
            pstmt2.setDouble(3, ohSp);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        // No salariales
        try (Connection conn = connect;
             PreparedStatement pstmt3 = conn.prepareStatement(sql)) {
            pstmt3.setInt(1, id_nom);
            pstmt3.setString(2, perGr.get(0));
            pstmt3.setDouble(3, amountCompAllow);
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();
    }

    /**
     * Inserta los detalles de retenciones en la nómina.
     *
     * @param id_nom         el ID de la nómina
     * @param irpfPer        el porcentaje de IRPF
     * @param amountIRPF     el importe de IRPF
     * @param atEpPer        el porcentaje de Accidentes de Trabajo y Enfermedades Profesionales
     * @param amountATEP     el importe de Accidentes de Trabajo y Enfermedades Profesionales
     * @throws SQLException si ocurre algún error de SQL durante la inserción
     */
    public static void insertHoldbacks(int id_nom, Double irpfPer, Double amountIRPF, Double atEpPer, Double amountATEP) throws SQLException {
        String sql = "INSERT INTO nom_reten(id_nom,cod_r,cant,cant_e) VALUES(?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nom);
            pstmt.setString(2, "IRPF");
            pstmt.setDouble(3, irpfPer);
            pstmt.setDouble(4, amountIRPF);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt2 = conn.prepareStatement(sql)) {
            pstmt2.setInt(1, id_nom);
            pstmt2.setString(2, "El tipo de Accidentes de Trabajo y Enfermedades Profesionales (AT y EP)");
            pstmt2.setDouble(3, atEpPer);
            pstmt2.setDouble(4, amountATEP);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();
    }

    /**
     * Inserta los detalles de cotización del trabajador en la nómina.
     *
     * @param id_nom              el ID de la nómina
     * @param contingenciesPer    el porcentaje de contingencias comunes del trabajador
     * @param contingenciesAmount el importe de contingencias comunes del trabajador
     * @param unEmploymentPer     el porcentaje de desempleo del trabajador
     * @param unEmploymentAmount  el importe de desempleo del trabajador
     * @param fpPer               el porcentaje de formación profesional del trabajador
     * @param fpAmount            el importe de formación profesional del trabajador
     * @param ohPer               el porcentaje de horas extras del trabajador
     * @param ohAmount            el importe de horas extras del trabajador
     * @throws SQLException si ocurre algún error de SQL durante la inserción
     */
    public static void insertCotEmployee(int id_nom, Double contingenciesPer, Double contingenciesAmount, Double unEmploymentPer, Double unEmploymentAmount, Double fpPer, Double fpAmount, Double ohPer, Double ohAmount) throws SQLException {
        String sql = "INSERT INTO nom_cot_trabajador(id_nom,cod_c,quant,quant_e) VALUES(?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nom);
            pstmt.setString(2, "COM");
            pstmt.setDouble(3, contingenciesPer);
            pstmt.setDouble(4, contingenciesAmount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt2 = conn.prepareStatement(sql)) {
            pstmt2.setInt(1, id_nom);
            pstmt2.setString(2, Querys.getCodCT(unEmploymentPer));
            pstmt2.setDouble(3, unEmploymentPer);
            pstmt2.setDouble(4, unEmploymentAmount);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt3 = conn.prepareStatement(sql)) {
            pstmt3.setInt(1, id_nom);
            pstmt3.setString(2, "FOP");
            pstmt3.setDouble(3, fpPer);
            pstmt3.setDouble(4, fpAmount);
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt4 = conn.prepareStatement(sql)) {
            pstmt4.setInt(1, id_nom);
            pstmt4.setString(2, "HER");
            pstmt4.setDouble(3, ohPer);
            pstmt4.setDouble(4, ohAmount);
            pstmt4.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();
    }

    /**
     * Inserta los detalles de cotización de la empresa en la nómina.
     *
     * @param id_nom                 el ID de la nómina
     * @param unemploymentCompPer    el porcentaje de desempleo de la empresa
     * @param unemploymentCompAmount el importe de desempleo de la empresa
     * @param fpCompPer              el porcentaje de formación profesional de la empresa
     * @param fpCompAmount           el importe de formación profesional de la empresa
     * @param fogasaPer              el porcentaje de FOGASA de la empresa
     * @param fogasaAmount           el importe de FOGASA de la empresa
     * @param ohCompPer              el porcentaje de horas extras de la empresa
     * @param ohCompAmount           el importe de horas extras de la empresa
     * @throws SQLException si ocurre algún error de SQL durante la inserción
     */
    public static void insertCotCompany(int id_nom, Double unemploymentCompPer, Double unemploymentCompAmount, Double fpCompPer, Double fpCompAmount, Double fogasaPer, Double fogasaAmount, Double ohCompPer, Double ohCompAmount,Double retentionPer,Double retentionAmount) throws SQLException {
        String sql = "INSERT INTO nom_cot_empresa(id_nom,cod_c,quant,quant_e) VALUES(?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nom);
            pstmt.setString(2, Querys.getCodCE(unemploymentCompPer));
            pstmt.setDouble(3, unemploymentCompPer);
            pstmt.setDouble(4, unemploymentCompAmount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt2 = conn.prepareStatement(sql)) {
            pstmt2.setInt(1, id_nom);
            pstmt2.setString(2, "FOP");
            pstmt2.setDouble(3, fpCompPer);
            pstmt2.setDouble(4, fpCompAmount);
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt3 = conn.prepareStatement(sql)) {
            pstmt3.setInt(1, id_nom);
            pstmt3.setString(2, "FOG");
            pstmt3.setDouble(3, fogasaPer);
            pstmt3.setDouble(4, fogasaAmount);
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt4 = conn.prepareStatement(sql)) {
            pstmt4.setInt(1, id_nom);
            pstmt4.setString(2, "HER");
            pstmt4.setDouble(3, ohCompPer);
            pstmt4.setDouble(4, ohCompAmount);
            pstmt4.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt4 = conn.prepareStatement(sql)) {
            pstmt4.setInt(1, id_nom);
            pstmt4.setString(2, "COM");
            pstmt4.setDouble(3, retentionPer);
            pstmt4.setDouble(4, retentionAmount);
            pstmt4.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();
    }
}
