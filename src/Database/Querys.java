package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Querys {

    private ConnectionDB con;

    public Querys(ConnectionDB con) {
        this.con = con;
    }

    public ResultSet GrossPay() throws SQLException {
        Statement query = con.Connect().createStatement();
        ResultSet result = query.executeQuery("");
        con.Connect().close();

        return result;
    }

    public void NetPay() throws SQLException{}
}
