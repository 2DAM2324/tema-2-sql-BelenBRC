package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Modelo.Ruta;
import Modelo.Usuario;

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
            controlador.getConector().recuperarBackup(backup);
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

    //***********************************************************************************************//
    //******************************************CATEGORIA********************************************//

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoria no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirCategoriaCategoriaNoExiste() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = "Categoria que no existe";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoria no existe en el sistema, se añade correctamente
     */
    @Test
    public void testAniadirCategoriaCategoriaNoExisteSeAniadeCorrectamente() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = "Categoria que no existe";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }  
        
        assertEquals(nombreCategoria, controlador.getListaCategoriasSistema().get(controlador.getListaCategoriasSistema().size()-1).getNombreCategoria());
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoria existe en el sistema, lanza excepción SQLException
     */
    @Test
    public void testAniadirCategoriaCategoriaExisteSQLException() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = controlador.getListaCategoriasSistema().get(0).getNombreCategoria();
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoria existe en el sistema, pero con letras mayúsculas y minúsculas
     */
    @Test
    public void testAniadirCategoriaCategoriaExisteMayusculasMinusculas() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = controlador.getListaCategoriasSistema().get(0).getNombreCategoria().toUpperCase();
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoría sin letras
     */
    @Test
    public void testAniadirCategoriaCategoriaSinLetras() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = "1234567890";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoría vacía
     */
    @Test
    public void testAniadirCategoriaCategoriaVacia() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = "";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoría con una letra
     */
    @Test
    public void testAniadirCategoriaCategoriaUnaLetra() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = "a";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepción SQLException");
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoría existente con espacios al principio y al final
     */
    @Test
    public void testAniadirCategoriaCategoriaExistenteConEspacios() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = " " + controlador.getListaCategoriasSistema().get(0).getNombreCategoria() + " ";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     * Categoría nueva con espacio al principio y al final se añade sin espacios
     */
    @Test
    public void testAniadirCategoriaCategoriaNuevaConEspacios() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = " Categoria que no existe ";
        
        try{
            controlador.aniadirCategoria(nombreCategoria);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }  
        
        assertEquals(nombreCategoria.trim(), controlador.getListaCategoriasSistema().get(controlador.getListaCategoriasSistema().size()-1).getNombreCategoria());
    }

    /**
     * Test of borrarCategoria method, of class Controlador.
     * Categoria no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarCategoriaCategoriaNoExisteSQLException() {
        System.out.println("borrarCategoria");
        Integer idNoExiste = 17895;
        
        try{
            controlador.borrarCategoria(idNoExiste);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }  
    }

    /**
     * Test of borrarCategoria method, of class Controlador.
     * Categoria no existe en el sistema, el array de categorías no se modifica
     */
    @Test
    public void testBorrarCategoriaCategoriaNoExisteArrayNoModificado() {
        System.out.println("borrarCategoria");
        Integer idNoExiste = 17895;

        Integer tamanoInicial = controlador.getListaCategoriasSistema().size();
        
        try{
            controlador.borrarCategoria(idNoExiste);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }  
        
        assertEquals(tamanoInicial, controlador.getListaCategoriasSistema().size());
    }

    /**
     * Test of borrarCategoria method, of class Controlador.
     * Categoria existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarCategoriaCategoriaExisteSQLException() {
        System.out.println("borrarCategoria");
        Integer idCategoria = controlador.getListaCategoriasSistema().get(0).getIDCategoria();
        
        try{
            controlador.borrarCategoria(idCategoria);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of borrarCategoria method, of class Controlador.
     * Categoria existe en el sistema, se borra correctamente
     */
    @Test
    public void testBorrarCategoriaCategoriaExisteSeBorraCorrectamente() {
        System.out.println("borrarCategoria");
        Integer idCategoria = controlador.getListaCategoriasSistema().get(0).getIDCategoria();
        
        try{
            controlador.borrarCategoria(idCategoria);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }
        
        boolean encontrado = false;
        for(int i = 0; i < controlador.getListaCategoriasSistema().size() && !encontrado; i++){
            if(controlador.getListaCategoriasSistema().get(i).getIDCategoria().equals(idCategoria)){
                encontrado = true;
            }
        }

        assertFalse(encontrado);
    }

    /**
     * Test of borrarCategoria method, of class Controlador.
     * Categoria existe en el sistema, el array de categorías se reduce en 1
     */
    @Test
    public void testBorrarCategoriaCategoriaExisteArrayTam() {
        System.out.println("borrarCategoria");
        Integer idCategoria = controlador.getListaCategoriasSistema().get(0).getIDCategoria();
        
        Integer tamanoInicial = controlador.getListaCategoriasSistema().size();
        
        try{
            controlador.borrarCategoria(idCategoria);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }
        
        assertEquals(tamanoInicial-1, controlador.getListaCategoriasSistema().size());
    }

    //***********************************************************************************************//
    //*****************************************USUARIO***********************************************//

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirUsuarioNoExistenteSinExcepciones(){
        System.out.println("aniadirUsuario");

        String dni = "88888888Y";
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, se añade correctamente
     */
    @Test
    public void testAniadirUsuarioNoExistenteSeAniadeCorrectamente(){
        System.out.println("aniadirUsuario");

        String dni = "88888888Y";
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(dni, controlador.getListaUsuariosSistema().get(controlador.getListaUsuariosSistema().size()-1).getDNI());
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, el array de usuarios se incrementa en 1
     */
    @Test
    public void testAniadirUsuarioNoExistenteArrayTam(){
        System.out.println("aniadirUsuario");

        String dni = "88888888Y";
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        Integer tamanoInicial = controlador.getListaUsuariosSistema().size();

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial+1, controlador.getListaUsuariosSistema().size());
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario existe en el sistema, lanza excepción SQLException
     */
    @Test
    public void testAniadirUsuarioExistenteSQLException(){
        System.out.println("aniadirUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario existe en el sistema, el array de usuarios no se modifica
     */
    @Test
    public void testAniadirUsuarioExistenteArrayNoModificado(){
        System.out.println("aniadirUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        Integer tamanoInicial = controlador.getListaUsuariosSistema().size();

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(tamanoInicial, controlador.getListaUsuariosSistema().size());
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, dni existe
     */
    @Test
    public void testAniadirUsuarioNoExistenteDNIExiste(){
        System.out.println("aniadirUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, dni existe, el array de usuarios no se modifica
     */
    @Test
    public void testAniadirUsuarioNoExistenteDNIExisteArrayNoModificado(){
        System.out.println("aniadirUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        Integer tamanoInicial = controlador.getListaUsuariosSistema().size();

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(tamanoInicial, controlador.getListaUsuariosSistema().size());
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, contraseña vacía
     */
    @Test
    public void testAniadirUsuarioNoExistenteContraseniaVacia(){
        System.out.println("aniadirUsuario");

        String dni = "88888888Y";
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, contraseña con menos de 4 caracteres
     */
    @Test
    public void testAniadirUsuarioNoExistenteContraseniaCorta(){
        System.out.println("aniadirUsuario");

        String dni = "88888888Y";
        String nombre = "Nombre";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "123";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            e.printStackTrace();
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     * Usuario no existe en el sistema, nombre y apellidos transformados con primera letra mayúscula y el resto minúsculas y sin espacios al principio y al final
     */
    @Test
    public void testAniadirUsuarioNoExistenteNombreApellidosMayusculasMinusculas(){
        System.out.println("aniadirUsuario");

        String dni = "88888888Y";
        String nombre = "     nOmBre     ";
        String apellido1 = "       aPeLlIdO1    ";
        String apellido2 = "        aPeLlIdO2     ";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.aniadirUsuario(dni, nombre, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals("Nombre", controlador.getListaUsuariosSistema().get(controlador.getListaUsuariosSistema().size()-1).getNombreUsuario());
        assertEquals("Apellido1", controlador.getListaUsuariosSistema().get(controlador.getListaUsuariosSistema().size()-1).getApellido1());
        assertEquals("Apellido2", controlador.getListaUsuariosSistema().get(controlador.getListaUsuariosSistema().size()-1).getApellido2());
    }

    /**
     * Test of modificarUsuario method, of class Controlador.
     * Usuario no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testModificarUsuarioNoExistenteSinExcepciones(){
        System.out.println("modificarUsuario");

        String dni = "88888888Y";
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.modificarUsuario(dni, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of modificarUsuario method, of class Controlador.
     * Usuario existe en el sistema, se modifica correctamente
     */
    @Test
    public void testModificarUsuarioExistenteSeModificaCorrectamente(){
        System.out.println("modificarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.modificarUsuario(dni, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(apellido1, controlador.getListaUsuariosSistema().get(0).getApellido1());
        assertEquals(apellido2, controlador.getListaUsuariosSistema().get(0).getApellido2());
        assertEquals(correo, controlador.getListaUsuariosSistema().get(0).getCorreoElectronico());
        assertEquals(contrasenia, controlador.getListaUsuariosSistema().get(0).getContrasenia());
    }

    /**
     * Test of modificarUsuario method, of class Controlador.
     * Usuario existe en el sistema, usuario es distinto al anterior
     */
    @Test
    public void testModificarUsuarioExistenteUsuarioDistinto(){
        System.out.println("modificarUsuario");

        Usuario usuario = controlador.getListaUsuariosSistema().get(0);

        String dni = usuario.getDNI();
        String apellido1 = "Apellido1";
        String apellido2 = "Apellido2";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.modificarUsuario(dni, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertNotEquals(usuario, controlador.getListaUsuariosSistema().get(0));
    }

    /**
     * Test of modificarUsuario method, of class Controlador.
     * Usuario existe en el sistema, modificado a Apellido2 vacío
     */
    @Test
    public void testModificarUsuarioExistenteApellido2Vacio(){
        System.out.println("modificarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();
        String apellido1 = "Apellido1";
        String apellido2 = "";
        String correo = "uncorreo@valido.es";
        String contrasenia = "Contrasenia1234";

        try{
            controlador.modificarUsuario(dni, apellido1, apellido2, correo, contrasenia);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(apellido1, controlador.getListaUsuariosSistema().get(0).getApellido1());
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarUsuarioNoExistenteSinExcepciones(){
        System.out.println("borrarUsuario");

        String dni = "88888888Y";

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario no existe en el sistema, el array de usuarios no se modifica
     */
    @Test
    public void testBorrarUsuarioNoExistenteArrayNoModificado(){
        System.out.println("borrarUsuario");

        String dni = "88888888Y";

        Integer tamanoInicial = controlador.getListaUsuariosSistema().size();

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial, controlador.getListaUsuariosSistema().size());
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario existe en el sistema, se borra correctamente
     */
    @Test
    public void testBorrarUsuarioExistenteSeBorraCorrectamente(){
        System.out.println("borrarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        boolean encontrado = false;
        for(int i = 0; i < controlador.getListaUsuariosSistema().size() && !encontrado; i++){
            if(controlador.getListaUsuariosSistema().get(i).getDNI().equals(dni)){
                encontrado = true;
            }
        }

        assertFalse(encontrado);
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario existe en el sistema, el array de usuarios se reduce en 1
     */
    @Test
    public void testBorrarUsuarioExistenteArrayTam(){
        System.out.println("borrarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaUsuariosSistema().size();

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaUsuariosSistema().size());
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario existe, el array de rutas se reduce en al menos 1
     */
    @Test
    public void testBorrarUsuarioExistenteArrayRutasTam(){
        System.out.println("borrarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaRutasSistema().size();

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertTrue(tamanoInicial > controlador.getListaRutasSistema().size());
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario existe, hay una foto menos en el sistema
     */
    @Test
    public void testBorrarUsuarioExistenteArrayFotosTam(){
        System.out.println("borrarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     * Usuario existe, hay menos valoraciones en el sistema
     */
    @Test
    public void testBorrarUsuarioExistenteArrayValoracionesTam(){
        System.out.println("borrarUsuario");

        String dni = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaValoracionesSistema().size();

        try{
            controlador.borrarUsuario(dni);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertTrue(tamanoInicial > controlador.getListaValoracionesSistema().size());
    }
}
