
/* PATRON DE DISEÑO DAO : Data Access Object

CONTENDRA LAS OPERACIONES A REALIZAR DE LA CLASE PERSONA (FUNCIONALIDAD)
*/
package datos;
import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
  
//METODO PARA SELECCIONAR
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona ";
    
    public List<Persona> seleccionar(){
        Connection CONN = null;
        PreparedStatement PSTMT = null;
        ResultSet RS = null;
        Persona persona =null; 
        List<Persona> personas = new ArrayList<>();
        //CONECTANDONOS A LA BD
        try {
            //CONN=Conexion.getConnection();
            CONN=getConnection();
            PSTMT = CONN.prepareStatement(SQL_SELECT);
            RS = PSTMT.executeQuery();
            
            while(RS.next()){
                int idpersona = RS.getInt("id_persona");
                String nombre = RS.getString("nombre");
                String apellido = RS.getString("apellido");
                String email = RS.getString("email");
                String telefono = RS.getString("telefono");
                persona = new Persona(idpersona, nombre, apellido, email, telefono);                        
                personas.add(persona);                
            }            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            try {
                //se realizan los cierres en forma al reves
                Conexion.close(RS);
                Conexion.close(PSTMT);
                Conexion.close(CONN);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
                }
        return personas;
    }
    
//METODO INSERTAR
private static final String SQL_INSERT ="INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?,?,?,?) ";    
    
    public int insertar(Persona persona){
        Connection CONN = null;
        PreparedStatement PSTMT = null;
        int registros =0;
        try {
            CONN = Conexion.getConnection();
            PSTMT = CONN.prepareStatement(SQL_INSERT);
            PSTMT.setString(1, persona.getNombre());
            PSTMT.setString(2, persona.getApellido());
            PSTMT.setString(3, persona.getEmail());
            PSTMT.setString(4, persona.getTelefono());
            registros = PSTMT.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            try {
                Conexion.close(PSTMT);
                Conexion.close(CONN);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }                
                }
        return registros;
    }   
    
    
//METODO ACTUALIZAR
    private static final String SQL_UPDATE = "UPDATE persona set nombre=?, apellido=?, email=?, telefono=? where id_persona=? ";
    
    public int modificar(Persona persona){
        Connection CONN = null;
        PreparedStatement PSTMT = null;
        int registros =0;
        try {
            CONN = Conexion.getConnection();
            PSTMT = CONN.prepareStatement(SQL_UPDATE);
            PSTMT.setString(1, persona.getNombre());
            PSTMT.setString(2, persona.getApellido());
            PSTMT.setString(3, persona.getEmail());
            PSTMT.setString(4, persona.getTelefono());
            PSTMT.setInt(5, persona.getIdpersona());
            registros = PSTMT.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            try {
                Conexion.close(PSTMT);
                Conexion.close(CONN);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }                
                }
        return registros;
    }
    
    
//METODO ELIMINAR
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=? ";
    
    public int eliminar(Persona persona){
        Connection CONN = null;
        PreparedStatement PSTMT = null;
        int registros =0;
        try {
            CONN = Conexion.getConnection();
            PSTMT = CONN.prepareStatement(SQL_DELETE);
            PSTMT.setInt(1, persona.getIdpersona());
            registros = PSTMT.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
            try {
                Conexion.close(PSTMT);
                Conexion.close(CONN);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }                
                }
        return registros;
    }

    
 
}
