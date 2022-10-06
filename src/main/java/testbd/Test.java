package testbd;
import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class Test {
    public static void main(String[] args) {
    
    PersonaDAO personadao = new PersonaDAO();       
        
//INSERTANDO UN OBJETO TIPO PERSONA
//    Persona personaNueva = new Persona("LUIS","GUSTAVO","correo6@correo.com","789654120");
//    personadao.insertar(personaNueva);
    
//MODIFICANDO REGISTRO
//        Persona personaModificar = new Persona(6, "Norma", "Batres", "correo6@correo.com", "48481353");
//        personadao.modificar(personaModificar);

//ELIMINAR REGISTRO
        Persona personaEliminar = new Persona(6);
        personadao.eliminar(personaEliminar);
        
//CONSULTANDO DE LA BD
        List<Persona> personas = personadao.seleccionar();
        personas.forEach(persona -> {
            System.out.println("Persona= "+persona);
        });
        
        /*
        for (Persona persona: personas) {
            System.out.println("persona= "+persona);
        }        
        */
        
    
        
    }
}
