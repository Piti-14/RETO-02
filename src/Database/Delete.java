package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    private static Connection connect = ConnectionDB.Connect();

    public static void deletePayrrol(int number) throws SQLException {
        Statement query = connect.createStatement();
        query.executeUpdate("DELETE FROM nominas WHERE id_nom = '" + number + "'");
    }
}
