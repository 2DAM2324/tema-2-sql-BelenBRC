//Belén Robustillo Carmona

package Controlador;

import Modelo.Categoria;
import Modelo.FotoPerfil;
import Modelo.Ruta;
import Modelo.Usuario;
import Modelo.Valoracion;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author belen
 */
public class ControladorTest {
    
    public ControladorTest() {
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
     * Test of setListaCategoriasSistema method, of class Controlador.
     */
    @Test
    public void testSetListaCategoriasSistema() {
        System.out.println("setListaCategoriasSistema");
        ArrayList<Categoria> listaCategoriasSistema = null;
        Controlador instance = new Controlador();
        instance.setListaCategoriasSistema(listaCategoriasSistema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
