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
public class RutaTest {
    
    public RutaTest() {
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
     * Test of setDescripcion method, of class Ruta.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Ruta instance = null;
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDificultad method, of class Ruta.
     */
    @Test
    public void testSetDificultad() {
        System.out.println("setDificultad");
        String dificultad = "";
        Ruta instance = null;
        instance.setDificultad(dificultad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreadorRuta method, of class Ruta.
     */
    @Test
    public void testSetCreadorRuta() {
        System.out.println("setCreadorRuta");
        Usuario creadorRuta = null;
        Ruta instance = null;
        instance.setCreadorRuta(creadorRuta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     */
    @Test
    public void testSetListaValoraciones() {
        System.out.println("setListaValoraciones");
        ArrayList<Valoracion> listaValoraciones = null;
        Ruta instance = null;
        instance.setListaValoraciones(listaValoraciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValoracionEnLista method, of class Ruta.
     */
    @Test
    public void testSetValoracionEnLista() {
        System.out.println("setValoracionEnLista");
        Valoracion valoracion = null;
        Ruta instance = null;
        instance.setValoracionEnLista(valoracion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaCategorias method, of class Ruta.
     */
    @Test
    public void testSetListaCategorias() {
        System.out.println("setListaCategorias");
        ArrayList<Categoria> listaCategorias = null;
        Ruta instance = null;
        instance.setListaCategorias(listaCategorias);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoriaEnLista method, of class Ruta.
     */
    @Test
    public void testSetCategoriaEnLista() {
        System.out.println("setCategoriaEnLista");
        Categoria categoria = null;
        Ruta instance = null;
        instance.setCategoriaEnLista(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdRuta method, of class Ruta.
     */
    @Test
    public void testGetIdRuta() {
        System.out.println("getIdRuta");
        Ruta instance = null;
        Integer expResult = null;
        Integer result = instance.getIdRuta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreRuta method, of class Ruta.
     */
    @Test
    public void testGetNombreRuta() {
        System.out.println("getNombreRuta");
        Ruta instance = null;
        String expResult = "";
        String result = instance.getNombreRuta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Ruta.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Ruta instance = null;
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDistanciaKm method, of class Ruta.
     */
    @Test
    public void testGetDistanciaKm() {
        System.out.println("getDistanciaKm");
        Ruta instance = null;
        double expResult = 0.0;
        double result = instance.getDistanciaKm();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDificultad method, of class Ruta.
     */
    @Test
    public void testGetDificultad() {
        System.out.println("getDificultad");
        Ruta instance = null;
        String expResult = "";
        String result = instance.getDificultad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTiempoHoras method, of class Ruta.
     */
    @Test
    public void testGetTiempoHoras() {
        System.out.println("getTiempoHoras");
        Ruta instance = null;
        double expResult = 0.0;
        double result = instance.getTiempoHoras();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntuacionMedia method, of class Ruta.
     */
    @Test
    public void testGetPuntuacionMedia() {
        System.out.println("getPuntuacionMedia");
        Ruta instance = null;
        double expResult = 0.0;
        double result = instance.getPuntuacionMedia();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreadorRuta method, of class Ruta.
     */
    @Test
    public void testGetCreadorRuta() {
        System.out.println("getCreadorRuta");
        Ruta instance = null;
        Usuario expResult = null;
        Usuario result = instance.getCreadorRuta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaValoraciones method, of class Ruta.
     */
    @Test
    public void testGetListaValoraciones() {
        System.out.println("getListaValoraciones");
        Ruta instance = null;
        ArrayList<Valoracion> expResult = null;
        ArrayList<Valoracion> result = instance.getListaValoraciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValoracionEnListaPorPosicion method, of class Ruta.
     */
    @Test
    public void testGetValoracionEnListaPorPosicion() {
        System.out.println("getValoracionEnListaPorPosicion");
        Integer posicion = null;
        Ruta instance = null;
        Valoracion expResult = null;
        Valoracion result = instance.getValoracionEnListaPorPosicion(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCategorias method, of class Ruta.
     */
    @Test
    public void testGetListaCategorias() {
        System.out.println("getListaCategorias");
        Ruta instance = null;
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.getListaCategorias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoriaEnListaPorPosicion method, of class Ruta.
     */
    @Test
    public void testGetCategoriaEnListaPorPosicion() {
        System.out.println("getCategoriaEnListaPorPosicion");
        Integer posicion = null;
        Ruta instance = null;
        Categoria expResult = null;
        Categoria result = instance.getCategoriaEnListaPorPosicion(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularPuntuacionMedia method, of class Ruta.
     */
    @Test
    public void testCalcularPuntuacionMedia() {
        System.out.println("calcularPuntuacionMedia");
        Ruta instance = null;
        instance.calcularPuntuacionMedia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ruta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ruta instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
