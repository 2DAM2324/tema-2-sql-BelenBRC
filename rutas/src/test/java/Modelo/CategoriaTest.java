//Belén Robustillo Carmona

package Modelo;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import Controlador.Controlador;

import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author belen
 */
public class CategoriaTest {

    Categoria instance;
    Controlador controlador;
    
    public CategoriaTest() {
        //Cargar datos de prueba de la base de datos
        Controlador controlador = new Controlador();
        controlador.deserializarCategoria();
        controlador.deserializarUsuario();
        controlador.deserializarRuta();
        controlador.deserializarValoracion();
        controlador.deserializarFotoPerfil();

        instance = new Categoria("nombre");
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
        String id = "NuevoID";
        instance.setIDCategoria(id);
        assertEquals(id, instance.getIDCategoria());
    }

    /**
     * Test of setNombreCategoria method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetNombreCategoria() {
        System.out.println("setNombreCategoria");
        String nombre = "NuevoNombre";
        instance.setNombreCategoria(nombre);
        assertEquals(nombre, instance.getNombreCategoria());
    }

    /**
     * Test of setListaRutas method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetListaRutas() {
        System.out.println("setListaRutas");
        instance.setListaRutas(controlador.getListaRutasSistema());
        assertEquals(controlador.getListaRutasSistema(), instance.getListaRutas());
    }

    /**
     * Test of setRutaEnLista method, of class Categoria.
     */
    @org.junit.jupiter.api.Test
    public void testSetRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = controlador.getListaRutasSistema().get(3) ;
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
