//Belén Robustillo Carmona

package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author belen
 */
public class ValoracionTest {
    Valoracion instance;
    Controlador controlador;
    
    public ValoracionTest() {
        //Cargar datos de prueba de la base de datos
        controlador = Controlador.newInstance();
        controlador.deserializarCategoria();
        controlador.deserializarUsuario();
        controlador.deserializarRuta();
        controlador.deserializarValoracion();
        controlador.deserializarFotoPerfil();

        Usuario usuario = new Usuario("Usuario", "Prueba", "Foto perfil", "fepnf@`koadnf.com", "1234", "07257650T");
        Ruta ruta = new Ruta("Ruta Prueba", "Descripcion Prueba", 1, "Media", 1, usuario);
        instance = new Valoracion(ruta, usuario, 5, "Comentario");
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Valoracion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Puntuación: " + instance.getPuntuacion().toString() + "\nComentario: " + instance.getComentario();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of asignarID method, of class Valoracion.
     */
    @Test
    public void testAsignarID() {
        System.out.println("asignarID");
        //Asignar ID se hace en el constructor
        String expResult = instance.getRuta().getIdRuta() + instance.getUsuario().getIDUsuario();
        String result = instance.getIDValoracion();
        assertEquals(expResult, result);
    }

}
