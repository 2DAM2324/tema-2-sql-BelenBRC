package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
            Controlador.newInstance();
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

    /**
     * Test of comprobarFormatoDNICorrecto method, of class Controlador.
     * DNI correcto
     */
    @Test
    public void testComprobarFormatoDNICorrecto() {
        System.out.println("comprobarFormatoDNICorrecto");

        String dni = "12345678Z";
        boolean expResult = true;
        boolean result = controlador.comprobarFormatoDNICorrecto(dni);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoDNICorrecto method, of class Controlador.
     * DNI vacío
     */
    @Test
    public void testComprobarFormatoDNIVacio() {
        System.out.println("comprobarFormatoDNIVacio");

        String dni = "";
        boolean expResult = false;
        boolean result = controlador.comprobarFormatoDNICorrecto(dni);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoDNICorrecto method, of class Controlador.
     * DNI sin letra
     */
    @Test
    public void testComprobarFormatoDNISinLetra() {
        System.out.println("comprobarFormatoDNISinLetra");

        String dni = "12345678";
        boolean expResult = false;
        boolean result = controlador.comprobarFormatoDNICorrecto(dni);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoDNICorrecto method, of class Controlador.
     * DNI con menos de 8 números
     */
    @Test
    public void testComprobarFormatoDNIIncompleto() {
        System.out.println("comprobarFormatoDNIIncompleto");

        String dni = "1234567Z";
        boolean expResult = false;
        boolean result = controlador.comprobarFormatoDNICorrecto(dni);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoDNICorrecto method, of class Controlador.
     * DNI correcto con letra en minúscula
     */
    @Test
    public void testComprobarFormatoDNILetraMinuscula() {
        System.out.println("comprobarFormatoDNILetraMinuscula");

        String dni = "12345678z";
        boolean expResult = true;
        boolean result = controlador.comprobarFormatoDNICorrecto(dni);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo correcto
     */
    @Test
    public void testComprobarFormatoCorreoCorrecto() {
        System.out.println("comprobarFormatoCorreoCorrecto");

        String correo = "uncorreo@unadireccion.es";
        boolean expResult = true;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo con mayúsculas
     */
    @Test
    public void testComprobarFormatoCorreoMayusculas() {
        System.out.println("comprobarFormatoCorreoMayusculas");

        String correo = "UnCorreo@UnaDireccion.es";

        boolean expResult = true;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo sin @
     */
    @Test
    public void testComprobarFormatoCorreoSinArroba() {
        System.out.println("comprobarFormatoCorreoSinArroba");

        String correo = "uncorreo.unadireccion.es";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo sin dominio
     */
    @Test
    public void testComprobarFormatoCorreoSinDominio() {
        System.out.println("comprobarFormatoCorreoSinDominio");

        String correo = "uncorreo@unadireccion";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo sin nombre
     */
    @Test
    public void testComprobarFormatoCorreoSinNombre() {
        System.out.println("comprobarFormatoCorreoSinNombre");

        String correo = "@unadireccion.es";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo sin extensión
     */
    @Test
    public void testComprobarFormatoCorreoSinExtension() {
        System.out.println("comprobarFormatoCorreoSinExtension");

        String correo = "uncorreo@.es";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo terminado en punto
     */
    @Test
    public void testComprobarFormatoCorreoTerminadoEnPunto() {
        System.out.println("comprobarFormatoCorreoTerminadoEnPunto");

        String correo = "uncorreo@unadireccion.";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo con número en dominio
     */
    @Test
    public void testComprobarFormatoCorreoConNumeroEnDominio() {
        System.out.println("comprobarFormatoCorreoConNumeroEnDominio");

        String correo = "uncorreo@unadireccion.1";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo con acentos
     */
    @Test
    public void testComprobarFormatoCorreoConAcentos() {
        System.out.println("comprobarFormatoCorreoConAcentos");

        String correo = "tú@unadirección.es";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobarFormatoCorreoCorrecto method, of class Controlador.
     * Correo con caracteres especiales
     */
    @Test
    public void testComprobarFormatoCorreoConCaracteresEspeciales() {
        System.out.println("comprobarFormatoCorreoConCaracteresEspeciales");

        String correo = "sHüMôr€n1t0h!#@€r+sHüL*h|.JeH";

        boolean expResult = false;
        boolean result = controlador.comprobarFormatoCorreoCorrecto(correo);
        assertEquals(expResult, result);
    }
}
