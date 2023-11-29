package Modelo;

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
     * Set a null ID
     */
    @Test
    public void testSetNullIDCategoria() {
        System.out.println("setIDCategoria");
        Integer id = null;
        Categoria instance = new Categoria("Prueba");
        instance.setIDCategoria(id);
        assertEquals(null, instance.getIDCategoria());
    }

    /**
     * Test of setIDCategoria method, of class Categoria.
     * Set a valid ID
     */
    @Test
    public void testSetValidIDCategoria() {
        System.out.println("setIDCategoria");
        Integer id = 1;
        Categoria instance = new Categoria("Prueba");
        instance.setIDCategoria(id);
        assertEquals(id, instance.getIDCategoria());
    }

    /**
     * Test of setNombreCategoria method, of class Categoria.
     * Set a valid name
     */
    @Test
    public void testSetValidNombreCategoria() {
        System.out.println("setNombreCategoria");
        String nombre = "";
        Categoria instance = new Categoria("Prueba");
        instance.setNombreCategoria(nombre);
        assertEquals(nombre, instance.getNombreCategoria());
    }

    /**
     * Test of setNombreCategoria method, of class Categoria.
     * Set a null name
     */
    @Test
    public void testSetNullNombreCategoria() {
        System.out.println("setNombreCategoria");
        String nombre = null;
        Categoria instance = new Categoria("Prueba");
        instance.setNombreCategoria(nombre);
        assertEquals(null, instance.getNombreCategoria());
    }

    /**
     * Test of setListaRutas method, of class Categoria.
     * Set a null list
     */
    @Test
    public void testSetListaRutas() {
        System.out.println("setListaRutas");
        ArrayList<Ruta> lista = null;
        Categoria instance = new Categoria("Prueba");
        instance.setListaRutas(lista);
        assertEquals(null, instance.getListaRutas());
    }

    /**
     * Test of setListaRutas method, of class Categoria.
     * Set a valid list
     */
    @Test
    public void testSetValidListaRutas() {
        System.out.println("setListaRutas");
        ArrayList<Ruta> lista = new ArrayList<>();
        Categoria instance = new Categoria("Prueba");
        instance.setListaRutas(lista);
        assertEquals(lista, instance.getListaRutas());
    }

    /**
     * Test of setRutaEnLista method, of class Categoria.
     * Set a null route
     */
    @Test
    public void testSetRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = null;
        Categoria instance = new Categoria("Prueba");
        instance.setRutaEnLista(ruta);
        assertEquals(null, instance.getListaRutas().get(0));
    }

    /**
     * Test of setRutaEnLista method, of class Categoria.
     * Set a valid route
     */
    @Test
    public void testSetValidRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = new Ruta("Prueba", "Prueba",1.0,"BAJA", 1.0, new Usuario("Hola", "Hola", "Hola", "asjd@sljk.es", "1234", "147852369Y" ));
        Categoria instance = new Categoria("Prueba");
        instance.setRutaEnLista(ruta);
        assertEquals(ruta, instance.getListaRutas().get(0));
    }

    /**
     * Test of setRutaEnLista method, of class Categoria.
     * Set an existing route in the list
     */
    @Test
    public void testSetExistingRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = new Ruta(1, "Prueba", "Prueba",1.0,"BAJA", 1.0, 0.0, new Usuario("Hola", "Hola", "Hola", "asjd@sljk.es", "1234", "147852369Y" ));
        Categoria instance = new Categoria("Prueba");
        instance.setRutaEnLista(ruta);
        instance.setRutaEnLista(ruta);
        assertTrue(instance.getListaRutas().size() == 1);
    }

    /**
     * Test of getIDCategoria method, of class Categoria.
     * Get a null ID
     */
    @Test
    public void testGetIDCategoria() {
        System.out.println("getIDCategoria");
        Categoria instance = new Categoria("Prueba");
        Integer expResult = null;
        Integer result = instance.getIDCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIDCategoria method, of class Categoria.
     * Get a valid ID
     */
    @Test
    public void testGetValidIDCategoria() {
        System.out.println("getIDCategoria");
        Categoria instance = new Categoria("Prueba");
        Integer expResult = 1;
        instance.setIDCategoria(expResult);
        Integer result = instance.getIDCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreCategoria method, of class Categoria.
     */
    @Test
    public void testGetNombreCategoria() {
        System.out.println("getNombreCategoria");
        Categoria instance = new Categoria("Prueba");
        String expResult = "Prueba";
        String result = instance.getNombreCategoria();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRutas method, of class Categoria.
     * Get an empty list
     */
    @Test
    public void testGetListaRutas() {
        System.out.println("getListaRutas");
        Categoria instance = new Categoria("Prueba");
        ArrayList<Ruta> expResult = new ArrayList<>();
        ArrayList<Ruta> result = instance.getListaRutas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaRutas method, of class Categoria.
     * Get a valid list
     */
    @Test
    public void testGetValidListaRutas() {
        System.out.println("getListaRutas");
        Categoria instance = new Categoria("Prueba");
        Ruta ruta = new Ruta("Prueba", "Prueba",1.0,"BAJA", 1.0, new Usuario("Hola", "Hola", "Hola", "asjd@sljk.es", "1234", "147852369Y" ));
        instance.setRutaEnLista(ruta);
        ArrayList<Ruta> expResult = new ArrayList<>();
        expResult.add(ruta);
        ArrayList<Ruta> result = instance.getListaRutas();
        assertEquals(expResult, result);
    }    
}
