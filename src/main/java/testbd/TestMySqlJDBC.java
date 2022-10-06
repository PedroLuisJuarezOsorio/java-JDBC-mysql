
package testbd;
import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMySqlJDBC {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        //Libreria de JDBC + conector de MySql Workbench8
        
//cadena de conexion + version para cada base de datos (este caso MySql)
String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //clase mysql para conexion via JDBC
            Class.forName("com.mysql.cj.jdbc.Driver"); //esta linea se utiliza para conexiones de aplicaciones web
            try {
                Connection conexion = DriverManager.getConnection(url,"sa","1234");
                Statement instruccion = conexion.createStatement(); //objeto tipo statement, permitira ejecutar sentencias en nuestra base de datos
                String sql= "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
                ResultSet resultado = instruccion.executeQuery(sql); //tipo de interface para ejecutar una sentencia.
                while(resultado.next()){ //iterando los datos
                    System.out.print("id_persona: "+ resultado.getInt("id_persona"));
                    System.out.print(" nombre: "+ resultado.getString("nombre"));
                    System.out.print(" apellido: "+ resultado.getString("apellido"));
                    System.out.print(" telefono: "+ resultado.getString("telefono"));
                    System.out.print(" email: "+ resultado.getString("email"));
                    System.out.println("");
                }
                resultado.close();
                instruccion.close();
                conexion.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

        
        
    }
}
