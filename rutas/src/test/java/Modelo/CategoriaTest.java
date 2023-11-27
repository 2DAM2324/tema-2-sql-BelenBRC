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
public class CategoriaTest {

    Categoria instance;
    Controlador controlador;
    
    public CategoriaTest() {
        //Cargar datos de prueba de la base de datos
        controlador = Controlador.newInstance();
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
     * Test of toString method, of class Categoria.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        instance = controlador.getListaCategoriasSistema().get(0);
        String expResult = instance.getNombreCategoria();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    /**
     * Test of setRutaEnLista method, of class Categoria.
     */
    @Test
    public void testSetRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = controlador.getListaRutasSistema().get(0);
        Categoria categoria = new Categoria("Nueva");
        categoria.setRutaEnLista(ruta);
        assertEquals(ruta, categoria.getRutaEnLista(0));
    }

    /**
     * Test of setRutaEnLista method, of class Categoria.
     */
    @Test
    public void testSetRutaExistenteEnLista() {
        System.out.println("setRutaExistenteEnLista");
        Ruta ruta = controlador.getListaRutasSistema().get(0);
        Categoria categoria = new Categoria("Nueva");
        categoria.setRutaEnLista(ruta);
        categoria.setRutaEnLista(ruta);
        assertEquals(1, categoria.getListaRutas().size());
    }
}