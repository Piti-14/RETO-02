package Database;

import Model.BasicClasses.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Querys {

    private ConnectionDB connect;

    public Querys(ConnectionDB connect) {
        this.connect = connect;
    }

    public ResultSet GrossPay(Employee e) throws SQLException {
        Statement query = connect.Connect().createStatement();
        ResultSet result = query.executeQuery("select getSalarioBase('" + e.getGroup().getGroupCode() + "')");
        //
        connect.exit();
        return result;
    }

    public void NetPay() throws SQLException{}
}
