//ESTA CLASE LA UTILIZAREMOS UNICAMENTE PARA LAS CONEXIONES Y CIERRES (SERA REUTILIZABLE)
package datos;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
//SE ESTABLECERAN LAS VARIABLES PARA CONECTARNOS A LA BD
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "1234";
    
    
//METODO PAR OBTENER LA CONEXION A LA BASE DE DATOS
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

//METODO PARA HACER CIERRES DE LAS CONEXIONES CONSULTADAS
    public static void close(ResultSet RS) throws SQLException{
        RS.close();
    } 
    public static void close(Statement STMT) throws SQLException{
        STMT.close();
    }
    public static void close(PreparedStatement PSTMT) throws SQLException{
        PSTMT.close();
    }
    public static void close(Connection CONN) throws SQLException{
        CONN.close();
    }
    
}
