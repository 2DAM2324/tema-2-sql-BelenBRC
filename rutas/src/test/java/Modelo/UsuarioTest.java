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
public class UsuarioTest {
    Usuario instance;
    Controlador controlador;
    
    public UsuarioTest() {
        //Cargar datos de prueba de la base de datos
        controlador = Controlador.newInstance();
        controlador.deserializarCategoria();
        controlador.deserializarUsuario();
        controlador.deserializarRuta();
        controlador.deserializarValoracion();
        controlador.deserializarFotoPerfil();

        instance = new Usuario("Usuario", "Prueba", "TestUser", "fepnf@`koadnf.com", "1234", "07257650T");
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
     * Test of asignarID method, of class Usuario.
     */
    @Test
    public void testAsignarID() {
        System.out.println("asignarID");
        Usuario prueba = new Usuario("Usuario", "Prueba", "TestUser", "fepnf@`koadnf.com", "1234", "07257650T");
        //Asignar ID se hace en el constructor
        String expResult = "U07257650T";
        String result = prueba.getIDUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of asignarID method, of class Usuario.
     */
    @Test
    public void testAsignarIDNombreEmpiezaConEspacio() {
        System.out.println("asignarID");
        Usuario prueba = new Usuario(" Espaciado", "Prueba", "TestUser", "fepnf@`koadnf.com", "1234", "07257650T");
        //Asignar ID se hace en el constructor
        String expResult = "07257650T";
        String result = prueba.getIDUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = instance.getNombreUsuario() + " " + instance.getApellido1() + " " + instance.getApellido2();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
