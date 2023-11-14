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
public class RutaTest {
    
    Ruta instance;
    Controlador controlador;
    Usuario usuario;
    
    public RutaTest() {
        //Cargar datos de prueba de la base de datos
        controlador = Controlador.newInstance();
        controlador.deserializarCategoria();
        controlador.deserializarUsuario();
        controlador.deserializarRuta();
        controlador.deserializarValoracion();
        controlador.deserializarFotoPerfil();
        
        usuario = new Usuario("Usuario", "Prueba", "Foto perfil", "fepnf@`koadnf.com", "1234", "07257650T");
        instance = new Ruta("Ruta Prueba", "Descripcion Prueba", 1, "Media", 1, usuario);
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
     * Test of calcularPuntuacionMedia method, of class Ruta.
     */
    @Test
    public void testCalcularPuntuacionMedia() {
        System.out.println("calcularPuntuacionMedia");
        Valoracion valoracion = new Valoracion(instance, usuario, 5, "Comentario");
        Usuario usuario2 = new Usuario("Usuario2", "Prueba2", " ", "fepnf@`koadnf.com2", "12342", "07257651L");
        Valoracion valoracion2 = new Valoracion(instance, usuario2, 3, "Comentario2");

        instance.getListaValoraciones().add(valoracion);
        instance.getListaValoraciones().add(valoracion2);

        instance.calcularPuntuacionMedia();
        double expResult = 4.0;
        double result = instance.getPuntuacionMedia();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcularPuntuacionMedia method, of class Ruta.
     */
    @Test
    public void testCalcularPuntuacionMediaSinValoraciones(){
        System.out.println("calcularPuntuacionMediaSinValoraciones");
        Ruta ruta1 = new Ruta("Ruta Prueba", "Descripcion Prueba", 1, "Media", 1, usuario);
        ruta1.calcularPuntuacionMedia();
        double expResult = 0.0;
        double result = instance.getPuntuacionMedia();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Ruta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = instance.getNombreRuta() + " - By: " + instance.getCreadorRuta().getDNI();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of asignarID method, of class Ruta.
     */
    @Test
    public void testAsignarID() {
        System.out.println("asignarID");
        Ruta prueba = new Ruta("Ruta", "Descripcion Prueba", 1, "Media", 1, usuario);
        //Asignar ID se hace dentro del constructor
        String expResult = prueba.getNombreRuta().replaceAll(" ", "") + prueba.getCreadorRuta().getIDUsuario();
        String result = prueba.getIdRuta();
        assertEquals(expResult, result);
    }

    /**
     * Test of asignarID method, of class Ruta.
     */
    @Test
    public void testAsignarIDNombreConEspacios() {
        System.out.println("asignarIDNombreConEspacios");
        Ruta prueba = new Ruta("Ruta Prueba", "Descripcion Prueba", 1, "Media", 1, usuario);
        //Asignar ID se hace dentro del constructor
        String expResult = prueba.getNombreRuta().replaceAll(" ", "") + prueba.getCreadorRuta().getIDUsuario();
        String result = prueba.getIdRuta();
        assertEquals(expResult, result);
    }

    /**
     * Test of asignarID method, of class Ruta.
     */
    @Test
    public void testAsignarIDNombreVacio() {
        System.out.println("asignarIDNombreConEspacios");
        Ruta prueba = new Ruta("    ", "Descripcion Prueba", 1, "Media", 1, usuario);
        //Asignar ID se hace dentro del constructor
        String expResult = prueba.getCreadorRuta().getIDUsuario();
        String result = prueba.getIdRuta();
        assertEquals(expResult, result);
    }
}
