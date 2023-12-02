package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Modelo.Conector;
import Modelo.Ruta;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author belen
 */
public class ControladorTest {

    static public Controlador controlador;
    private static String url = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\tests.db";
    private static String backup = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\DatabaseFile.sql";
    
    public ControladorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
            
        try{
            controlador = Controlador.newInstance(url);
        }
        catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
    }
    
    @AfterAll
    public static void tearDownClass() {
        try{
            controlador.getConector().desconectar();
        }
        catch(Exception e){
            System.out.println("Error al desconectar con la base de datos");
        }
    }
    
    @BeforeEach
    public void setUp() {
        //Restaurar la base de datos al estado inicial con backup
        try{
            controlador.getConector().conectar();
            controlador.getConector().recuperarBackup(backup);
            controlador.getConector().bajarBaseDatos();
            controlador.cargarDatosSistema();
        }
        catch(IOException ioe){
            System.out.println("Error al leer el fichero de backup");
            ioe.printStackTrace();
        }
        catch(SQLException sqle){
            System.out.println("Error al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Error inesperado al restaurar la base de datos");
            e.printStackTrace();
        }
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of getIdUsuarioSistema method, of class Controlador.
     * Usuario no existe
     */
    @Test
    public void testGetIdUsuarioSistemaUsuarioNoExiste() {
        System.out.println("getIdUsuarioSistema");
        String dniUsuario = "88888888Y";
        Integer expResult = 0;
        Integer result = controlador.getIdUsuarioSistema(dniUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdUsuarioSistema method, of class Controlador.
     * Usuario existe
     */
    @Test
    public void testGetIdUsuarioSistemaUsuarioExiste() {
        System.out.println("getIdUsuarioSistema");
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer expResult = controlador.getListaUsuariosSistema().get(0).getIDUsuario();
        Integer result = controlador.getIdUsuarioSistema(dniUsuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIDrutaSistema method, of class Controlador.
     * Ruta no existe
     */
    @Test
    public void testGetIDrutaSistemaRutaNoExiste() {
        System.out.println("getIdRutaSistema");
        String nombreRuta = "Ruta no existe";
        Integer idCreador = 0;
        Integer expResult = 0;
        Integer result = controlador.getIDrutaSistema(nombreRuta, idCreador);
        assertEquals(expResult, result);
    }

    /**
     * Test of getIDrutaSistema method, of class Controlador.
     * Ruta existe
     */
    @Test
    public void testGetIDrutaSistemaRutaExiste() {
        System.out.println("getIdRutaSistema");
        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        Integer idCreador = controlador.getListaRutasSistema().get(0).getCreadorRuta().getIDUsuario();
        Integer expResult = controlador.getListaRutasSistema().get(0).getIdRuta();
        Integer result = controlador.getIDrutaSistema(nombreRuta, idCreador);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRutaSistema method, of class Controlador.
     * Ruta no existe
     */
    @Test
    public void testGetRutaSistemaRutaNoExiste() {
        System.out.println("getRutaSistema");
        String nombreRuta = "Ruta no existe";
        String dniCreador = "88888888Y";

        Ruta resultado = controlador.getRutaSistema(nombreRuta, dniCreador);
   
        assertNull(resultado);
    }

    /**
     * Test of getRutaSistema method, of class Controlador.
     * Ruta existe
     */
    @Test
    public void testGetRutaSistemaRutaExiste() {
        System.out.println("getRutaSistema");
        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaRutasSistema().get(0).getCreadorRuta().getDNI();

        Ruta resultado = controlador.getRutaSistema(nombreRuta, dniCreador);
   
        assertNotNull(resultado);
    }

    /**
     * Test of getRutaSistema method, of class Controlador.
     * Ruta existe, resultado correcto
     */
    @Test
    public void testGetRutaSistemaRutaExisteResultadoCorrecto() {
        System.out.println("getRutaSistema");
        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaRutasSistema().get(0).getCreadorRuta().getDNI();

        Ruta resultado = controlador.getRutaSistema(nombreRuta, dniCreador);
   
        assertEquals(controlador.getListaRutasSistema().get(0), resultado);
    }

    //***********************************************************************************************//

    /**
     * Test of newInstance method, of class Controlador.
     * instancia no null
     * @throws java.lang.Exception
     */
    @Test
    public void testNewInstanceInstanciaNoNull() throws Exception {
        System.out.println("newInstance");
        Controlador result = Controlador.newInstance();
        assertNotNull(result);
    }

    /**
     * Test of newInstance method, of class Controlador.
     * Comprobar que la instancia es única
     * @throws java.lang.Exception
     */
    @Test
    public void testNewInstanceInstanciaUnica() throws Exception {
        System.out.println("newInstance");
        Controlador result1 = Controlador.newInstance();
        Controlador result2 = Controlador.newInstance();
        assertEquals(result1, result2);
    }

    /**
     * Test of newInstance method, of class Controlador.
     * Comprobar que no se lanzan excepciones
     */
    @Test
    public void testNewInstanceNoLanzaExcepciones() {
        System.out.println("newInstance");
        try{
            Controlador result = Controlador.newInstance();
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of newInstance method, of class Controlador.
     * instancia no null
     * @throws java.lang.Exception
     */
    @Test
    public void testNewInstanceUrlInstanciaNoNull() throws Exception {
        System.out.println("newInstance");
        Controlador result = Controlador.newInstance(url);
        assertNotNull(result);
    }

    /**
     * Test of newInstance method, of class Controlador.
     * Comprobar que la instancia es única
     * @throws java.lang.Exception
     */
    @Test
    public void testNewInstanceUrlInstanciaUnica() throws Exception {
        System.out.println("newInstance");
        Controlador result1 = Controlador.newInstance(url);
        Controlador result2 = Controlador.newInstance(url);
        assertEquals(result1, result2);
    }

    /**
     * Test of newInstance method, of class Controlador.
     * Comprobar que no se lanzan excepciones
     */
    @Test
    public void testNewInstanceUrlNoLanzaExcepciones() {
        System.out.println("newInstance");
        try{
            controlador = Controlador.newInstance(url);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    //***********************************************************************************************//
}
