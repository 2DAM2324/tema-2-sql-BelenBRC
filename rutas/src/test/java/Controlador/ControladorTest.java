package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Modelo.FotoPerfil;
import Modelo.Ruta;
import Modelo.Usuario;
import Modelo.Valoracion;

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

    //***********************************************************************************************//
    //*******************************************RUTA************************************************//

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirRutaNoExistenteSinExcepciones(){
        System.out.println("aniadirRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta no existe en el sistema, se añade correctmente
     */
    @Test
    public void testAniadirRutaNoExistenteSeAniadeCorrectamente(){
        System.out.println("aniadirRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(nombreRuta, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getNombreRuta());
        assertEquals(descripcion, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getDescripcion());
        assertEquals(distancia, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getDistanciaKm());
        assertEquals(tiempo, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getTiempoHoras());
        assertEquals(dificultad, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getDificultad());
        assertEquals(dniCreador, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getCreadorRuta().getDNI());
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta no existe en el sistema, hay una ruta más en el sistema
     */
    @Test
    public void testAniadirRutaNoExistenteArrayTam(){
        System.out.println("aniadirRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaRutasSistema().size();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial+1, controlador.getListaRutasSistema().size());
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta existe en el sistema, lanza excepción SQLException
     */
    @Test
    public void testAniadirRutaExistenteSQLException(){
        System.out.println("aniadirRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
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
     * Test of aniadirRuta method, of class Controlador.
     * Ruta existe en el sistema, el array de rutas no se modifica
     */
    @Test
    public void testAniadirRutaExistenteArrayNoModificado(){
        System.out.println("aniadirRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaRutasSistema().size();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(tamanoInicial, controlador.getListaRutasSistema().size());
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta no existe, distancia =0 lanza SQLException
     */
    @Test
    public void testAniadirRutaNoExistenteDistancia0SQLException(){
        System.out.println("aniadirRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta";
        Double distancia = 0.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
            System.out.println(sqle.getMessage());
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta no existe, tiempo =0 lanza SQLException
     */
    @Test
    public void testAniadirRutaNoExistenteTiempo0SQLException(){
        System.out.println("aniadirRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 0.0;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
            System.out.println(sqle.getMessage());
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta no existe, puntuación media obtenida = 0
     */
    @Test
    public void testAniadirRutaNoExistentePuntuacionMedia0(){
        System.out.println("aniadirRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();
        Double puntuacionMedia = 0.0;

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(puntuacionMedia, controlador.getListaRutasSistema().get(controlador.getListaRutasSistema().size()-1).getPuntuacionMedia());
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     * Ruta existe en el sistema, nombreRuta con espacios al principio y al final
     */
    @Test
    public void testAniadirRutaExistenteNombreRutaConEspacios(){
        System.out.println("aniadirRuta");

        String nombreRuta = " " + controlador.getListaRutasSistema().get(0).getNombreRuta() + " ";
        String descripcion = "Descripción de la ruta";
        Double distancia = 10.0;
        Double tiempo = 2.5;
        String dificultad = "BAJA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.aniadirRuta(nombreRuta, descripcion, distancia, tiempo, dificultad, dniCreador);
            fail("Debería lanzar excepciones");
        }
        catch(SQLException sqle){
            //Excepción esperada
            System.out.println(sqle.getMessage());
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarRutaNoExistenteSinExcepciones(){
        System.out.println("borrarRuta");

        String nombreRuta = "Ruta que no existe";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta no existe en el sistema, el array de rutas no se modifica
     */
    @Test
    public void testBorrarRutaNoExistenteArrayNoModificado(){
        System.out.println("borrarRuta");

        String nombreRuta = "Ruta que no existe";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaRutasSistema().size();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial, controlador.getListaRutasSistema().size());
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarRutaExistenteSinExcepciones(){
        System.out.println("borrarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta existe en el sistema, se borra correctamente
     */
    @Test
    public void testBorrarRutaExistenteSeBorraCorrectamente(){
        System.out.println("borrarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        boolean encontrado = false;
        for(int i = 0; i < controlador.getListaRutasSistema().size() && !encontrado; i++){
            if(controlador.getListaRutasSistema().get(i).getNombreRuta().equals(nombreRuta)){
                encontrado = true;
            }
        }

        assertFalse(encontrado);
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta existe en el sistema, el array de rutas se reduce en 1
     */
    @Test
    public void testBorrarRutaExistenteArrayTam(){
        System.out.println("borrarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaRutasSistema().size();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaRutasSistema().size());
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta existe en el sistema, el array de rutas de su creador se reduce en 1
     */
    @Test
    public void testBorrarRutaExistenteArrayRutasCreadorTam(){
        System.out.println("borrarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaUsuariosSistema().get(0).getListaRutas().size();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaUsuariosSistema().get(0).getListaRutas().size());
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     * Ruta existe en el sistema, el array de valoraciones se reduce en al menos 1
     */
    @Test
    public void testBorrarRutaExistenteArrayValoracionesTam(){
        System.out.println("borrarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaValoracionesSistema().size();

        try{
            controlador.borrarRuta(nombreRuta, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertTrue(tamanoInicial > controlador.getListaValoracionesSistema().size());
    }

    /**
     * Test of modificarRuta method, of class Controlador.
     * Ruta no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testModificarRutaNoExistenteSinExcepciones(){
        System.out.println("modificarRuta");

        String nombreRuta = "Ruta que no existe";
        String descripcion = "Descripción de la ruta modificada";
        String dificultad = "MEDIA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.modificarRuta(nombreRuta, descripcion, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of modificarRuta method, of class Controlador.
     * Ruta existe en el sistema, se modifica correctamente
     */
    @Test
    public void testModificarRutaExistenteSeModificaCorrectamente(){
        System.out.println("modificarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String descripcion = "Descripción de la ruta modificada";
        String dificultad = "MEDIA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.modificarRuta(nombreRuta, descripcion, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(descripcion, controlador.getListaRutasSistema().get(0).getDescripcion());
        assertEquals(dificultad, controlador.getListaRutasSistema().get(0).getDificultad());
    }

    /**
     * Test of modificarRuta method, of class Controlador.
     * Ruta existe en el sistema, sin descripción
     */
    @Test
    public void testModificarRutaExistenteSinDescripcion(){
        System.out.println("modificarRuta");

        String nombreRuta = controlador.getListaRutasSistema().get(0).getNombreRuta();
        String descripcion = "";
        String dificultad = "MEDIA";
        String dniCreador = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.modificarRuta(nombreRuta, descripcion, dificultad, dniCreador);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(descripcion, controlador.getListaRutasSistema().get(0).getDescripcion());
    }

    //***********************************************************************************************//
    //*******************************************VALORACION******************************************//

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirValoracionNoExistenteSinExcepciones(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(2);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración no existe en el sistema, se añade correctamente
     */
    @Test
    public void testAniadirValoracionNoExistenteSeAniadeCorrectamente(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(2);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(puntuacion, controlador.getListaValoracionesSistema().get(controlador.getListaValoracionesSistema().size()-1).getPuntuacion());
        assertEquals(comentario, controlador.getListaValoracionesSistema().get(controlador.getListaValoracionesSistema().size()-1).getComentario());
        assertEquals(dniUsuario, controlador.getListaValoracionesSistema().get(controlador.getListaValoracionesSistema().size()-1).getUsuario().getDNI());
        assertEquals(ruta.getIdRuta(), controlador.getListaValoracionesSistema().get(controlador.getListaValoracionesSistema().size()-1).getRuta().getIdRuta());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración no existe en el sistema, hay una valoración más en el sistema
     */
    @Test
    public void testAniadirValoracionNoExistenteArrayTam(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(2);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Integer tamanoInicial = controlador.getListaValoracionesSistema().size();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial+1, controlador.getListaValoracionesSistema().size());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración no existe en el sistema, hay una valoración más en el array de valoraciones de la ruta
     */
    @Test
    public void testAniadirValoracionNoExistenteArrayValoracionesRutaTam(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(2);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Integer tamanoInicial = controlador.getListaRutasSistema().get(2).getListaValoraciones().size();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial+1, controlador.getListaRutasSistema().get(2).getListaValoraciones().size());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración no existe en el sistema, hay una valoración más en el array de valoraciones del usuario
     */
    @Test
    public void testAniadirValoracionNoExistenteArrayValoracionesUsuarioTam(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(2);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Integer tamanoInicial = controlador.getListaUsuariosSistema().get(0).getListaValoraciones().size();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial+1, controlador.getListaUsuariosSistema().get(0).getListaValoraciones().size());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración no existe en el sistema, se modifica la puntuación media de la ruta
     */
    @Test
    public void testAniadirValoracionNoExistentePuntuacionMediaRuta(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(2);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";
        Double puntuacionMediaPrevia = ruta.getPuntuacionMedia();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertNotEquals(puntuacionMediaPrevia, controlador.getListaRutasSistema().get(2).getPuntuacionMedia());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirValoracionExistenteNoException(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(0);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración existe en el sistema, el array de valoraciones no se modifica
     */
    @Test
    public void testAniadirValoracionExistenteArrayNoModificado(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(0);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Integer tamanoInicial = controlador.getListaValoracionesSistema().size();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(tamanoInicial, controlador.getListaValoracionesSistema().size());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración existe en el sistema, el array de valoraciones de la ruta no se modifica
     */
    @Test
    public void testAniadirValoracionExistenteArrayValoracionesRutaNoModificado(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(0);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Integer tamanoInicial = ruta.getListaValoraciones().size();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(tamanoInicial, ruta.getListaValoraciones().size());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración existe en el sistema, el array de valoraciones del usuario no se modifica
     */
    @Test
    public void testAniadirValoracionExistenteArrayValoracionesUsuarioNoModificado(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(0);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Integer tamanoInicial = controlador.getListaUsuariosSistema().get(0).getListaValoraciones().size();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(tamanoInicial, controlador.getListaUsuariosSistema().get(0).getListaValoraciones().size());
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     * Valoración existe en el sistema, la puntuación media de la ruta no se modifica
     */
    @Test
    public void testAniadirValoracionExistentePuntuacionMediaRutaNoModificada(){
        System.out.println("aniadirValoracion");

        Ruta ruta = controlador.getListaRutasSistema().get(0);
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        Integer puntuacion = controlador.getListaValoracionesSistema().get(0).getPuntuacion();
        String comentario = "Comentario de prueba";
        Double puntuacionMediaPrevia = ruta.getPuntuacionMedia();

        try{
            controlador.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(SQLException sqle){
            fail("No debería lanzar excepciones");
        }
        catch(Exception e){
            fail("No debería lanzar excepcion genérica");
        }

        assertEquals(puntuacionMediaPrevia, controlador.getListaRutasSistema().get(0).getPuntuacionMedia());
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarValoracionNoExistenteSinExcepciones(){
        System.out.println("borrarValoracion");

        String nombreRuta = "Ruta que no existe";
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración no existe en el sistema, el array de valoraciones no se modifica
     */
    @Test
    public void testBorrarValoracionNoExistenteArrayNoModificado(){
        System.out.println("borrarValoracion");

        String nombreRuta = "Ruta que no existe";
        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();

        Integer tamanoInicial = controlador.getListaValoracionesSistema().size();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial, controlador.getListaValoracionesSistema().size());
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarValoracionExistenteSinExcepciones(){
        System.out.println("borrarValoracion");

        String nombreRuta = controlador.getListaValoracionesSistema().get(0).getRuta().getNombreRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración existe en el sistema, se borra correctamente
     */
    @Test
    public void testBorrarValoracionExistenteSeBorraCorrectamente(){
        System.out.println("borrarValoracion");

        String nombreRuta = controlador.getListaValoracionesSistema().get(0).getRuta().getNombreRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        boolean encontrado = false;
        for(int i = 0; i < controlador.getListaValoracionesSistema().size() && !encontrado; i++){
            if(controlador.getListaValoracionesSistema().get(i).getRuta().getNombreRuta().equals(nombreRuta) &&
                    controlador.getListaValoracionesSistema().get(i).getUsuario().getDNI().equals(dniUsuario)){
                encontrado = true;
            }
        }

        assertFalse(encontrado);
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración existe en el sistema, el array de valoraciones se reduce en 1
     */
    @Test
    public void testBorrarValoracionExistenteArrayTam(){
        System.out.println("borrarValoracion");

        String nombreRuta = controlador.getListaValoracionesSistema().get(0).getRuta().getNombreRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();

        Integer tamanoInicial = controlador.getListaValoracionesSistema().size();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaValoracionesSistema().size());
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración existe en el sistema, el array de valoraciones de la ruta se reduce en 1
     */
    @Test
    public void testBorrarValoracionExistenteArrayValoracionesRutaTam(){
        System.out.println("borrarValoracion");

        String nombreRuta = controlador.getListaValoracionesSistema().get(0).getRuta().getNombreRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();

        Integer tamanoInicial = controlador.getListaValoracionesSistema().get(0).getRuta().getListaValoraciones().size();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaValoracionesSistema().get(0).getRuta().getListaValoraciones().size());
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración existe en el sistema, el array de valoraciones del usuario se reduce en 1
     */
    @Test
    public void testBorrarValoracionExistenteArrayValoracionesUsuarioTam(){
        System.out.println("borrarValoracion");

        String nombreRuta = controlador.getListaValoracionesSistema().get(0).getRuta().getNombreRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();

        Integer tamanoInicial = controlador.getListaValoracionesSistema().get(0).getUsuario().getListaValoraciones().size();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        for(int i = 0; i < controlador.getListaUsuariosSistema().size(); i++){
            if(controlador.getListaUsuariosSistema().get(i).getDNI().equals(dniUsuario)){
                assertEquals(tamanoInicial-1, controlador.getListaUsuariosSistema().get(i).getListaValoraciones().size());
            }
        }
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     * Valoración existe en el sistema, la puntuación media de la ruta se modifica
     */
    @Test
    public void testBorrarValoracionExistentePuntuacionMediaRutaModificada(){
        System.out.println("borrarValoracion");

        String nombreRuta = controlador.getListaValoracionesSistema().get(0).getRuta().getNombreRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();
        Double puntuacionMediaPrevia = controlador.getListaValoracionesSistema().get(0).getRuta().getPuntuacionMedia();

        try{
            controlador.borrarValoracion(nombreRuta, dniUsuario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertNotEquals(puntuacionMediaPrevia, controlador.getListaValoracionesSistema().get(0).getRuta().getPuntuacionMedia());
    }

    /**
     * Test of modificarValoracion method, of class Controlador.
     * Valoración no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testModificarValoracionNoExistenteSinExcepciones(){
        System.out.println("modificarValoracion");

        Ruta ruta = controlador.getListaValoracionesSistema().get(0).getRuta();
        String dniUsuario = "Usuario que no existe";
        Integer puntuacion = controlador.getListaValoracionesSistema().get(0).getPuntuacion() -1;
        String comentario = "Comentario de prueba";

        try{
            controlador.modificarValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of modificarValoracion method, of class Controlador.
     * Valoración existe en el sistema, se modifica correctamente
     */
    @Test
    public void testModificarValoracionExistenteSeModificaCorrectamente(){
        System.out.println("modificarValoracion");

        Ruta ruta = controlador.getListaValoracionesSistema().get(0).getRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();
        Integer puntuacion = controlador.getListaValoracionesSistema().get(0).getPuntuacion() -1;
        String comentario = "Comentario de prueba";

        try{
            controlador.modificarValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(puntuacion, controlador.getListaValoracionesSistema().get(0).getPuntuacion());
        assertEquals(comentario, controlador.getListaValoracionesSistema().get(0).getComentario());
    }

    /**
     * Test of modificarValoracion method, of class Controlador.
     * Valoración existe en el sistema, la valoración es distinta
     */
    @Test
    public void testModificarValoracionExistenteValoracionDistinta(){
        System.out.println("modificarValoracion");

        Valoracion valoracion = controlador.getListaValoracionesSistema().get(0);

        Ruta ruta = valoracion.getRuta();
        String dniUsuario = valoracion.getUsuario().getDNI();
        Integer puntuacion = valoracion.getPuntuacion() -1;
        String comentario = "Comentario de prueba";

        try{
            controlador.modificarValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        for(int i = 0; i < controlador.getListaValoracionesSistema().size(); i++){
            if(controlador.getListaValoracionesSistema().get(i).getRuta().getIdRuta().equals(ruta.getIdRuta()) &&
                    controlador.getListaValoracionesSistema().get(i).getUsuario().getDNI().equals(dniUsuario)){
                assertNotEquals(valoracion, controlador.getListaValoracionesSistema().get(i));
            }
        }
    }

    /**
     * Test of modificarValoracion method, of class Controlador.
     * Valoración existe en el sistema, la puntuación media de la ruta se modifica
     */
    @Test
    public void testModificarValoracionExistentePuntuacionMediaRutaModificada(){
        System.out.println("modificarValoracion");

        Ruta ruta = controlador.getListaValoracionesSistema().get(0).getRuta();
        String dniUsuario = controlador.getListaValoracionesSistema().get(0).getUsuario().getDNI();
        Integer puntuacion = controlador.getListaValoracionesSistema().get(0).getPuntuacion() -1;
        String comentario = "Comentario de prueba";
        Double puntuacionMediaPrevia = ruta.getPuntuacionMedia();

        try{
            controlador.modificarValoracion(ruta, dniUsuario, puntuacion, comentario);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertNotEquals(puntuacionMediaPrevia, controlador.getListaValoracionesSistema().get(0).getRuta().getPuntuacionMedia());
    }

    //***********************************************************************************************//
    //***************************************FOTO DE PERFIL******************************************//

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirFotoPerfilNoExistenteSinExcepciones(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = "Usuario que no existe";
        String nombreFoto = "Foto de perfil";
        Integer resolucion = 100;
        Integer tamanio = 100;

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario no existe en el sistema, el array de fotos de perfil no se modifica
     */
    @Test
    public void testAniadirFotoPerfilNoExistenteArrayNoModificado(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = "Usuario que no existe";
        String nombreFoto = "Foto de perfil";
        Integer resolucion = 100;
        Integer tamanio = 100;

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, no lanza excepciones
     */
    @Test
    public void testAniadirFotoPerfilExistenteSinExcepciones(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 100;

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, se añade correctamente
     */
    @Test
    public void testAniadirFotoPerfilExistenteSeAniadeCorrectamente(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 100;

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(nombreFoto, controlador.getListaFotosPerfilSistema().get(controlador.getListaFotosPerfilSistema().size()-1).getNombreImagen());
        assertEquals(resolucion, controlador.getListaFotosPerfilSistema().get(controlador.getListaFotosPerfilSistema().size()-1).getResolucionImagenMp());
        assertEquals(tamanio, controlador.getListaFotosPerfilSistema().get(controlador.getListaFotosPerfilSistema().size()-1).getTamanioKb());
        assertEquals(dniUsuario, controlador.getListaFotosPerfilSistema().get(controlador.getListaFotosPerfilSistema().size()-1).getUsuario().getDNI());
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, el array de fotos de perfil se incrementa en 1
     */
    @Test
    public void testAniadirFotoPerfilExistenteArrayTam(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 100;

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial+1, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, el usuario tiene la foto de perfil
     */
    @Test
    public void testAniadirFotoPerfilExistenteUsuarioTieneFotoPerfil(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 100;

        Integer idFoto = controlador.getListaUsuariosSistema().get(0).getFotoPerfil().getIDfoto();

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
        
        assertNotEquals(idFoto, controlador.getListaUsuariosSistema().get(0).getFotoPerfil().getIDfoto());
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, resolución =0 lanza SQLException
     */
    @Test
    public void testAniadirFotoPerfilExistenteResolucion0SQLException(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 0;
        Integer tamanio = 100;

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
            fail("Debería lanzar SQLException");
        }
        catch(SQLException sqle){
            assertTrue(true);
        }
        catch(Exception e){
            fail("Debería lanzar SQLException");
        }
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, tamnio =0 lanza SQLException
     */
    @Test
    public void testAniadirFotoPerfilExistenteTamanio0SQLException(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 0;

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
            fail("Debería lanzar SQLException");
        }
        catch(SQLException sqle){
            assertTrue(true);
        }
        catch(Exception e){
            fail("Debería lanzar SQLException");
        }
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, resolución=0 no se añade la foto de perfil
     */
    @Test
    public void testAniadirFotoPerfilExistenteResolucion0NoAniadeFotoPerfil(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 0;
        Integer tamanio = 100;

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
            fail("Debería lanzar SQLException");
        }
        catch(SQLException sqle){
            assertTrue(true);
        }
        catch(Exception e){
            fail("Debería lanzar SQLException");
        }

        assertEquals(tamanoInicial, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     * Usuario existe en el sistema, tamanio=0 no se añade la foto de perfil
     */
    @Test
    public void testAniadirFotoPerfilExistenteTamanio0NoAniadeFotoPerfil(){
        System.out.println("aniadirFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 0;

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.aniadirFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
            fail("Debería lanzar SQLException");
        }
        catch(SQLException sqle){
            assertTrue(true);
        }
        catch(Exception e){
            fail("Debería lanzar SQLException");
        }

        assertEquals(tamanoInicial, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of modificarFotoPerfil method, of class Controlador.
     * Usuario no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testModificarFotoPerfilNoExistenteSinExcepciones(){
        System.out.println("modificarFotoPerfil");

        String dniUsuario = "Usuario que no existe";
        String nombreFoto = "Foto de perfil";
        Integer resolucion = 100;
        Integer tamanio = 100;

        try{
            controlador.modificarFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of modificarFotoPerfil method, of class Controlador.
     * Usuario existe y tiene foto de perfil, se modifica correctamente
     */
    @Test
    public void testModificarFotoPerfilExistenteSeModificaCorrectamente(){
        System.out.println("modificarFotoPerfil");

        String dniUsuario = controlador.getListaUsuariosSistema().get(0).getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 100;

        try{
            controlador.modificarFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(nombreFoto, controlador.getListaUsuariosSistema().get(0).getFotoPerfil().getNombreImagen());
        assertEquals(resolucion, controlador.getListaUsuariosSistema().get(0).getFotoPerfil().getResolucionImagenMp());
        assertEquals(tamanio, controlador.getListaUsuariosSistema().get(0).getFotoPerfil().getTamanioKb());
        assertEquals(dniUsuario, controlador.getListaUsuariosSistema().get(0).getFotoPerfil().getUsuario().getDNI());
    }

    /**
     * Test of modificarFotoPerfil method, of class Controlador.
     * Usuario existe y tiene foto de perfil, la foto de perfil es distinta
     */
    @Test
    public void testModificarFotoPerfilExistenteFotoPerfilDistinta(){
        System.out.println("modificarFotoPerfil");

        FotoPerfil foto = controlador.getListaFotosPerfilSistema().get(0);
        Integer idFoto = foto.getIDfoto();

        String dniUsuario = foto.getUsuario().getDNI();
        String nombreFoto = "Foto de perfil test";
        Integer resolucion = 100;
        Integer tamanio = 100;

        try{
            controlador.modificarFotoPerfil(dniUsuario, nombreFoto, resolucion, tamanio);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        for(int i = 0; i < controlador.getListaFotosPerfilSistema().size(); i++){
            if(controlador.getListaFotosPerfilSistema().get(i).getIDfoto().equals(idFoto)){
                assertNotEquals(foto, controlador.getListaFotosPerfilSistema().get(i));
            }
        }
    }

    /**
     * Test of borrarFotoPerfil method, of class Controlador.
     * Foto no existe en el sistema, no lanza excepciones
     */
    @Test
    public void testBorrarFotoPerfilNoExistenteSinExcepciones(){
        System.out.println("borrarFotoPerfil");

        Integer idFoto = 85478;

        try{
            controlador.borrarFotoPerfil(idFoto);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }
    }

    /**
     * Test of borrarFotoPerfil method, of class Controlador.
     * Foto no existe en el sistema, no se modifica el array de fotos de perfil
     */
    @Test
    public void testBorrarFotoPerfilNoExistenteArrayNoModificado(){
        System.out.println("borrarFotoPerfil");

        Integer idFoto = 85478;

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.borrarFotoPerfil(idFoto);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of borrarFotoPerfil method, of class Controlador.
     * Foto existe en el sistema, se borra correctamente
     */
    @Test
    public void testBorrarFotoPerfilExistenteSeBorraCorrectamente(){
        System.out.println("borrarFotoPerfil");

        FotoPerfil foto = controlador.getListaFotosPerfilSistema().get(0);
        Integer idFoto = foto.getIDfoto();

        try{
            controlador.borrarFotoPerfil(idFoto);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        boolean encontrado = false;
        for(int i = 0; i < controlador.getListaFotosPerfilSistema().size() && !encontrado; i++){
            if(controlador.getListaFotosPerfilSistema().get(i).getIDfoto().equals(idFoto)){
                encontrado = true;
            }
        }

        assertFalse(encontrado);
    }

    /**
     * Test of borrarFotoPerfil method, of class Controlador.
     * Foto existe en el sistema, el array de fotos de perfil se reduce en 1
     */
    @Test
    public void testBorrarFotoPerfilExistenteArrayTam(){
        System.out.println("borrarFotoPerfil");

        FotoPerfil foto = controlador.getListaFotosPerfilSistema().get(0);
        Integer idFoto = foto.getIDfoto();

        Integer tamanoInicial = controlador.getListaFotosPerfilSistema().size();

        try{
            controlador.borrarFotoPerfil(idFoto);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        assertEquals(tamanoInicial-1, controlador.getListaFotosPerfilSistema().size());
    }

    /**
     * Test of borrarFotoPerfil method, of class Controlador.
     * Foto existe en el sistema, el usuario no tiene foto de perfil
     */
    @Test
    public void testBorrarFotoPerfilExistenteUsuarioNoTieneFotoPerfil(){
        System.out.println("borrarFotoPerfil");

        FotoPerfil foto = controlador.getListaFotosPerfilSistema().get(0);
        Integer idFoto = foto.getIDfoto();

        Integer idUsuario = foto.getUsuario().getIDUsuario();

        try{
            controlador.borrarFotoPerfil(idFoto);
        }
        catch(Exception e){
            fail("No debería lanzar excepciones");
        }

        for(int i = 0; i < controlador.getListaUsuariosSistema().size(); i++){
            if(controlador.getListaUsuariosSistema().get(i).getIDUsuario().equals(idUsuario)){
                assertNull(controlador.getListaUsuariosSistema().get(i).getFotoPerfil());
            }
        }
    }

    //***********************************************************************************************//
    //***************************************CLASIFICACION*******************************************//
}
