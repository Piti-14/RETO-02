package Database;

import java.sql.*;
import java.util.ArrayList;

public class Insert {
    private static Connection connect = ConnectionDB.Connect();

    public static void insertPayrrol(String nif, int ano_n, String mes_n, Double total_dev, Double total_net, Double ap_empresa) throws SQLException {
        String sql = "INSERT INTO nominas(nif,ano_n,mes_n,total_dev,total_net,ap_empresa) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nif);
            pstmt.setInt(2, ano_n);
            pstmt.setString(3, mes_n);
            pstmt.setDouble(4,total_dev);
            pstmt.setDouble(5,total_net);
            pstmt.setDouble(6,ap_empresa);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        connect = ConnectionDB.Connect();
    }

    public static void insertNomPercep(int id_nom, Double amountSp,Double ohSp, Double amountCompAllow, String nif) throws SQLException {
        String sql = "INSERT INTO nom_percep(id_nom,cod_p,cant) VALUES(?,?,?)";

        ArrayList<String> perInd = Querys.getPerInd(nif);

        ArrayList<String> perGr = Querys.getPerGroup(nif);

        //ANTIGUEDAD

        try  (Connection conn = connect;
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

    public static void insertHoldbacks(int id_nom, Double irpfPer,Double amountIRPF ,Double atEpPer, Double amountATEP) throws SQLException {
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

    public static void insertCotEmployee(int id_nom, Double contingenciesPer, Double contingenciesAmount, Double unEmploymentPer, Double unEmploymentAmount, Double fpPer, Double fpAmount, Double ohPer, Double ohAmount) throws SQLException {
        String sql = "INSERT INTO nom_cot_trabajador(id_nom,cod_c,quant,quant_e) VALUES(?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nom);
            pstmt.setString(2, "COM");
            pstmt.setDouble(3, contingenciesPer);
            pstmt.setDouble(4,contingenciesAmount);
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
            pstmt2.setDouble(4,unEmploymentAmount);
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
            pstmt3.setDouble(4,fpAmount);
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

        try (Connection conn = connect;
             PreparedStatement pstmt4 = conn.prepareStatement(sql)) {
            pstmt4.setInt(1, id_nom);
            pstmt4.setString(2, "HER" );
            pstmt4.setDouble(3, ohPer);
            pstmt4.setDouble(4,ohAmount);
            pstmt4.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();
    }

    public static void insertCotCompany(int id_nom, Double unemploymentCompPer, Double unemploymentCompAmount, Double fpCompPer, Double fpCompAmount, Double fogasaPer, Double fogasaAmount, Double ohCompPer, Double ohCompAmount) throws SQLException {
        String sql = "INSERT INTO nom_cot_empresa(id_nom,cod_c,quant,quant_e) VALUES(?,?,?,?)";

        try (Connection conn = connect;
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_nom);
            pstmt.setString(2,  Querys.getCodCE(unemploymentCompPer));
            pstmt.setDouble(3, unemploymentCompPer);
            pstmt.setDouble(4,unemploymentCompAmount);
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
            pstmt2.setDouble(4,fpCompAmount);
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
            pstmt3.setDouble(4,fogasaAmount);
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
            pstmt4.setDouble(4,ohCompAmount);
            pstmt4.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        connect = ConnectionDB.Connect();

    }
}
