package Database;

import java.sql.*;

public class ConnectionDB {

    /* Declaramos 4 variables con el driver, la bbdd, usuario y contraseña*/
    private static final String driver="org.postgresql.Driver";
    private static final String bbdd="jdbc:postgresql://reto2-equipo1-db.cdf8njq9vyzm.us-east-1.rds.amazonaws.com:5432/TeawNominas";
    private static final String usuario ="admin123";
    private static final String clave="admin123";

    /* Creamos el método para conectarnos a la base de datos..
    /* Creamos el método para conectarnos a la
       Este método devolverá un objeto de tipo Connection. */

    public static Connection Connect(){

        /*Declaramos una variable para almacenar la cadena de conexión.  Primero la iniciamos en null.*/
        Connection conex = null;

        try {
            Class.forName(driver);

            //Creamos una conexión a la Base de Datos
            conex =  DriverManager.getConnection(bbdd, usuario, clave);

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos.\n" + e.getMessage().toString());
        }
        // Devolvemos la conexión.
        return conex;
    }

    public static void cerrarConexion(Connection conex){
        try{
            // Cerramos la conexión
            conex.close();
        }catch(SQLException e){
            /* Controlamos excepción en caso de que se pueda producira la hora de cerrar la conexión*/
            System.out.println(e.getMessage().toString());
        }
    }
    public static void main(String[] args) {
        /*Declaramos una variable para almacenar la conexión que nos va a devolver el método Conexion(). Primero la iniciamos en null.*/
        Connection conex=null;
        /*Almacenamos lo que nos devuelve el método Conexion() en la variable conex*/
        conex = Connect();
        // Si la variable objeto conex es diferente de nulo
        if(conex != null){
            // Informamos que la conexión es correcta
            System.out.println("Conectado correctamente");
            //consultarPersonas();
            cerrarConexion(conex);
        }else{ // Sino informamos que no nos podemos conectar.
            System.out.println("No has podido conectarte");
        }
    }
}