//ESTA CLASE REPRESENTARA UN REGITRO DE LA TABLA PERSONA (BD)
//SE UTILIZARA PARA RECUPERAR INFORMACION, INSERTAR, MODIFICAR Y ELIMINAR REGISTROS DE LA TABLA
package domain;


public class Persona {
    private int idpersona;
    private String nombre, apellido, email, telefono;

    public Persona() {
    }
//CONSTRUCTOR PARA ELIMINAR UN REGISTRO DE LA BD
    public Persona(int idpersona) {
        this.idpersona = idpersona;
    }
//CONSTRUCTOR PARA INSERTAR UN RESGISTRO DE BD
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
//CONSTRUCTOR QUE PODRIA UTILIZARCE PARA MODIFICAR UN REGISTRO DE BD.
    public Persona(int idpersona, String nombre, String apellido, String email, String telefono) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
//TAMBIEN SI SE QUIERE MODIFICAR ALGUN ATRIBUTO NECESITAMOS GET Y SET

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
//METODO TO STRING PARA MANDAR A IMPRIMIR EL ESTADO

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
    
}
