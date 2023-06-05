package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que contiene métodos para eliminar registros en la base de datos.
 */
public class Delete {

    private static Connection connect = ConnectionDB.Connect();

    /**
     * Elimina una nómina de la base de datos.
     *
     * @param number el número de identificación de la nómina a eliminar
     * @throws SQLException si ocurre algún error de SQL durante la eliminación
     */
    public static void deletePayrrol(int number) throws SQLException {
        Statement query = connect.createStatement();
        query.executeUpdate("DELETE FROM nominas WHERE id_nom = '" + number + "'");
    }
}
