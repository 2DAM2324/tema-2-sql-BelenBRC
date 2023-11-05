//Belén Robustillo Carmona

package Modelo;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author belen
 */
public class CategoriaTest {
    
    public CategoriaTest() {
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
     * Test of setIDCategoria method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetIDCategoria() {
        System.out.println("setIDCategoria");
        String id = "";
        Categoria instance = null;
        instance.setIDCategoria(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreCategoria method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetNombreCategoria() {
        System.out.println("setNombreCategoria");
        String nombre = "";
        Categoria instance = null;
        instance.setNombreCategoria(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaRutas method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetListaRutas() {
        System.out.println("setListaRutas");
        ArrayList<Ruta> lista = null;
        Categoria instance = null;
        instance.setListaRutas(lista);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutaEnLista method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = null;
        Categoria instance = null;
        instance.setRutaEnLista(ruta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIDCategoria method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testGetIDCategoria() {
        System.out.println("getIDCategoria");
        Categoria instance = null;
        String expResult = "";
        String result = instance.getIDCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreCategoria method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testGetNombreCategoria() {
        System.out.println("getNombreCategoria");
        Categoria instance = null;
        String expResult = "";
        String result = instance.getNombreCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaRutas method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testGetListaRutas() {
        System.out.println("getListaRutas");
        Categoria instance = null;
        ArrayList<Ruta> expResult = null;
        ArrayList<Ruta> result = instance.getListaRutas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutaEnLista method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testGetRutaEnLista() {
        System.out.println("getRutaEnLista");
        Integer posicion = null;
        Categoria instance = null;
        Ruta expResult = null;
        Ruta result = instance.getRutaEnLista(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        System.out.println("toString");
        Categoria instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
