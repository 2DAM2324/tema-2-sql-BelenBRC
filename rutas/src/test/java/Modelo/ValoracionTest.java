package Modelo;

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
public class ValoracionTest {

    Valoracion instance;
    Usuario usuario;
    Ruta ruta;
    
    public ValoracionTest() {
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
        usuario = new Usuario("UsuarioPrueba", "Prueba", "Prueba", "tu@tu.es", "1234", "12345678Z");
        ruta = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);
        instance = new Valoracion(ruta, usuario, 5, "Comentario de prueba");

        String expResult = "Puntuación: 5\nComentario: Comentario de prueba";
        String result = instance.toString();

        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Valoracion.
     * Comentario vacío
     */
    @Test
    public void testToString2() {
        System.out.println("toString");
        usuario = new Usuario("UsuarioPrueba", "Prueba", "Prueba", "tu@tu.es", "1234", "12345678Z");
        ruta = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);
        instance = new Valoracion(ruta, usuario, 5, "");

        String expResult = "Puntuación: 5\nComentario: ";
        String result = instance.toString();

        assertEquals(expResult, result);
    }
}
