package Database;

import java.sql.*;

public class ConnectionDB {

    private static final String driver = "org.postgresql.Driver";
    private static final String bbdd = "jdbc:postgresql://reto2-equipo1-db.cdf8njq9vyzm.us-east-1.rds.amazonaws.com:5432/TeawNominas";
    private static final String usuario = "admin123";
    private static final String clave = "admin123";

    /* Creamos el método para conectarnos a la base de datos.
       Este método devolverá un objeto de tipo Connection. */

    public static Connection Connect(){

        Connection con = null;

        try {
            Class.forName(driver);

            //Creamos una conexión a la Base de Datos
            con = DriverManager.getConnection(bbdd, usuario, clave);
            //con = DriverManager.getConnection("jdbc:postgresql://reto2-equipo1-db.cdf8njq9vyzm.us-east-1.rds.amazonaws.com:5432/TeawNominas?user=admin123&password=admin123");
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos.\n" + e.getMessage().toString());
        }
        return con;
    }

    public static void exit(Connection con){
        try{
             con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage().toString());
        }
    }
}