package Modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
public class ConectorTest {

    static public Conector conector;
    private static String url = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\tests.db";
    private static String backup = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\DatabaseFile.sql";
    
    public ConectorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        try{
            conector = Conector.newInstance(url);
            conector.conectar();
            conector.bajarBaseDatos();
        }
        catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
    }
    
    @AfterAll
    public static void tearDownClass() {
        try{
            conector.desconectar();
        }
        catch(Exception e){
            System.out.println("Error al desconectar con la base de datos");
        }
    }
    
    @BeforeEach
    public void setUp() {
        //Restaurar la base de datos al estado inicial con backup
        try{
            conector.recuperarBackup(backup);
            conector.conectar();
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
     * Test of getConexion method, of class Conector.
     * Comprueba que la conexión no es nula
     */
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        Connection result = conector.getConexion();
        assertNotNull(result);
    }

    /**
     * Test of newInstance method, of class Conector.
     * Comprobar poniendo instancia a null que se crea una nueva instancia
     */
    @Test
    public void testNewInstanceNull() {
        System.out.println("newInstance");
        conector = null;
        conector = Conector.newInstance();
        assertNotNull(conector);
    }

    /**
     * Test of newInstance method, of class Conector.
     * Comprobar que no se crea una nueva instancia si ya existe
     */
    @Test
    public void testNewInstanceNotNull() {
        System.out.println("newInstance");
        Conector result = Conector.newInstance();
        assertEquals(conector, result); 
    }

    /**
     * Test of conectar method, of class Conector.
     * Comprobar que se conecta a la base de datos exitosamente
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        assertNotNull(conector.getConexion());
    }

    /**
     * Test of conectar method, of class Conector.
     * Comprobar reconexión a la base de datos cuando ya hay conexión
     * La conexión debe ser igual a la original
     */
    @Test
    public void testReconectar() {
        System.out.println("reconectar");
        try {
            conector.conectar();
            assertEquals(conector.getConexion(), conector.getConexion());
        } catch (Exception e) {
            fail("No se esperaba una excepción al reconectar");
        }
    }

    /**
     * Test of desconectar method, of class Conector.
     * Comprobar que se desconecta de la base de datos cuando hay conexión
     */
    @Test
    public void testDesconectar() {
        System.out.println("desconectar");
        try {
            conector.desconectar();
            assertNull(conector.getConexion(), "La conexión debe ser nula después de desconectar");
        } catch (Exception e) {
            fail("No se esperaba una excepción al desconectar");
        }
    }

    /**
     * Test of desconectar method, of class Conector.
     * Comprobar una desconexión doble
     */
    @Test
    public void testDesconectarDoble() {
        System.out.println("desconectar");
        try {
            conector.desconectar();
            conector.desconectar();
            assertNull(conector.getConexion(), "La conexión debe ser nula después de desconectar");
        } catch (Exception e) {
            fail("No se esperaba una excepción al desconectar");
        }
    }





    //*******************************************************************//

    /**
     * Test of bajarBaseDatos method, of class Conector.
     * Prueba que, tras instanciarlo, todos los arrays tienen tamaño > 0
     */
    @Test
    public void testBajarBaseDatos() throws Exception {
        System.out.println("bajarBaseDatos");
        conector.bajarBaseDatos();
        assertTrue(conector.getTodasLasCategorias().size() > 0);
        assertTrue(conector.getTodosLosUsuarios().size() > 0);
        assertTrue(conector.getTodasLasRutas().size() > 0);
        assertTrue(conector.getTodasLasValoraciones().size() > 0);
        assertTrue(conector.getTodasLasFotosPerfil().size() > 0);
    }

    /**
     * Test of bajarBaseDatos method, of class Conector.
     * Prueba de consistencia. Al llamarlo dos veces, los arrays deben tener el mismo tamaño
     */
    @Test
    public void testBajarBaseDatosConsistencia() throws Exception {
        System.out.println("bajarBaseDatos");
        conector.bajarBaseDatos();
        int tamCategorias = conector.getTodasLasCategorias().size();
        int tamUsuarios = conector.getTodosLosUsuarios().size();
        int tamRutas = conector.getTodasLasRutas().size();
        int tamValoraciones = conector.getTodasLasValoraciones().size();
        int tamFotosPerfil = conector.getTodasLasFotosPerfil().size();
        conector.bajarBaseDatos();
        assertEquals(tamCategorias, conector.getTodasLasCategorias().size());
        assertEquals(tamUsuarios, conector.getTodosLosUsuarios().size());
        assertEquals(tamRutas, conector.getTodasLasRutas().size());
        assertEquals(tamValoraciones, conector.getTodasLasValoraciones().size());
        assertEquals(tamFotosPerfil, conector.getTodasLasFotosPerfil().size());
    }

    /**
     * Test of bajarBaseDatos method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testBajarBaseDatosThrows(){
        System.out.println("bajarBaseDatos");
        try{
            conector.bajarBaseDatos();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al bajar la base de datos");
        }
    }

    /**
     * Test of recuperarBackup method, of class Conector.
     * Prueba que no se lancen excepciones al restaurar la base de datos
     */
    @Test
    public void testRecuperarBackup() {
        System.out.println("recuperarBackup");
        try{
            conector.recuperarBackup(backup);
        }
        catch(IOException ioe){
            fail("No se esperaba una excepción al leer el fichero de backup");
            ioe.printStackTrace();
        }
        catch(SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch(Exception e){
            fail("Excepción inesperada al restaurar la base de datos");
            e.printStackTrace();
        }
    }

    /**
     * Test of recuperarBackup method, of class Conector.
     * Prueba que todos los arrays tienen tamaño > 0
     */
    @Test
    public void testRecuperarBackupDatos() throws Exception{
        System.out.println("recuperarBackup");
        conector.recuperarBackup(backup);
        assertTrue(conector.getTodasLasCategorias().size() > 0);
        assertTrue(conector.getTodosLosUsuarios().size() > 0);
        assertTrue(conector.getTodasLasRutas().size() > 0);
        assertTrue(conector.getTodasLasValoraciones().size() > 0);
        assertTrue(conector.getTodasLasFotosPerfil().size() > 0);
    }

    /**
     * Test of getFotosPerfilBaseDatos method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetFotosPerfilBaseDatosExcepciones() {
        System.out.println("getFotosPerfilBaseDatos");
        try{
            conector.getFotosPerfilBaseDatos();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener las fotos de perfil");
        }
    }

    /**
     * Test of getFotosPerfilBaseDatos method, of class Conector.
     * Prueba que ninguna foto de perfil tenga un usuario asignado
     */
    @Test
    public void testGetFotosPerfilBaseDatosUsuarioNull() throws Exception{
        System.out.println("getFotosPerfilBaseDatos");
        conector.getFotosPerfilBaseDatos();
        for (FotoPerfil fotoPerfil : conector.getListaFotosPerfil()){
            assertNull(fotoPerfil.getUsuario());
        }
    }

    /**
     * Test of getFotosPerfilBaseDatos method, of class Conector.
     * Prueba que el array de fotos de perfil contenga al menos una foto
     */
    @Test
    public void testGetFotosPerfilBaseDatosTam() throws Exception{
        System.out.println("getFotosPerfilBaseDatos");
        conector.getFotosPerfilBaseDatos();
        assertTrue(conector.getListaFotosPerfil().size() > 0);
    }

    /**
     * Test of getUsuariosBaseDatos method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetUsuariosBaseDatosExcepciones() {
        System.out.println("getUsuariosBaseDatos");
        try{
            conector.getUsuariosBaseDatos();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener los usuarios");
        }
    }

    /**
     * Test of getUsuariosBaseDatos method, of class Conector.
     * Prueba que el array de usuarios contenga al menos un usuario
     */
    @Test
    public void testGetUsuariosBaseDatosTam() throws Exception{
        System.out.println("getUsuariosBaseDatos");
        conector.getUsuariosBaseDatos();
        assertTrue(conector.getListaUsuarios().size() > 0);
    }

    /**
     * Test of getUsuariosBaseDatos method, of class Conector.
     * Prueba que todas las listas de rutas de los usuarios están vacías
     */
    @Test
    public void testGetUsuariosBaseDatosRutasVacias() throws Exception{
        System.out.println("getUsuariosBaseDatos");
        conector.getUsuariosBaseDatos();
        for(Usuario usuario : conector.getListaUsuarios()){
            assertTrue(usuario.getListaRutas().isEmpty());
        }
    }

    /**
     * Test of getUsuariosBaseDatos method, of class Conector.
     * Prueba que todas las listas de valoraciones de los usuarios están vacías
     */
    @Test
    public void testGetUsuariosBaseDatosValoracionesVacias() throws Exception{
        System.out.println("getUsuariosBaseDatos");
        conector.getUsuariosBaseDatos();
        for(Usuario usuario : conector.getListaUsuarios()){
            assertTrue(usuario.getListaValoraciones().isEmpty());
        }
    }

    /**
     * Test of getUsuariosBaseDatos method, of class Conector.
     * Prueba que al menos un usuario tenga una foto de perfil asignada
     */
    @Test
    public void testGetUsuariosBaseDatosFotoPerfilVinculada() throws Exception{
        System.out.println("getUsuariosBaseDatos");
        conector.getUsuariosBaseDatos();
        for(Usuario usuario : conector.getListaUsuarios()){
            if(usuario.getFotoPerfil() != null){
                assertTrue(conector.getListaFotosPerfil().contains(usuario.getFotoPerfil()));
                assertTrue(usuario.getFotoPerfil().getUsuario().equals(usuario));
            }
        }
    }

    /**
     * Test of getRutasBaseDatos method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetRutasBaseDatosExcepciones() {
        System.out.println("getRutasBaseDatos");
        try{
            conector.getRutasBaseDatos();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener las rutas");
        }
    }

    /**
     * Test of getRutasBaseDatos method, of class Conector.
     * Prueba que el array de rutas contenga al menos una ruta
     */
    @Test
    public void testGetRutasBaseDatosTam() throws Exception{
        System.out.println("getRutasBaseDatos");
        conector.getRutasBaseDatos();
        assertTrue(conector.getListaRutas().size() > 0);
    }

    /**
     * Test of getRutasBaseDatos method, of class Conector.
     * Prueba que todas las listas de valoraciones de las rutas están vacías
     */
    @Test
    public void testGetRutasBaseDatosValoracionesVacias() throws Exception{
        System.out.println("getRutasBaseDatos");
        conector.getRutasBaseDatos();
        for(Ruta ruta : conector.getListaRutas()){
            assertTrue(ruta.getListaValoraciones().isEmpty());
        }
    }

    /**
     * Test of getRutasBaseDatos method, of class Conector.
     * Prueba que todas las listas de categorías de las rutas están vacías
     */
    @Test
    public void testGetRutasBaseDatosCategoriasVacias() throws Exception{
        System.out.println("getRutasBaseDatos");
        conector.getRutasBaseDatos();
        for(Ruta ruta : conector.getListaRutas()){
            assertTrue(ruta.getListaCategorias().isEmpty());
        }
    }

    /**
     * Test of getRutasBaseDatos method, of class Conector.
     * Prueba que se han vinculado correctamente las rutas con los usuarios
     */
    @Test
    public void testGetRutasBaseDatosUsuariosVinculados() throws Exception{
        System.out.println("getRutasBaseDatos");
        conector.getRutasBaseDatos();
        for(Ruta ruta : conector.getListaRutas()){
            assertTrue(conector.getListaUsuarios().contains(ruta.getCreadorRuta()));
            assertTrue(ruta.getCreadorRuta().getListaRutas().contains(ruta));
        }
    }

    /**
     * Test of getCategoriasBaseDatos method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetCategoriasBaseDatosExcepciones() {
        System.out.println("getCategoriasBaseDatos");
        try{
            conector.getCategoriasBaseDatos();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener las categorías");
        }
    }

    /**
     * Test of getCategoriasBaseDatos method, of class Conector.
     * Prueba que el array de categorías contenga al menos una categoría
     */
    @Test
    public void testGetCategoriasBaseDatosTam() throws Exception{
        System.out.println("getCategoriasBaseDatos");
        conector.getCategoriasBaseDatos();
        assertTrue(conector.getListaCategorias().size() > 0);
    }

    /**
     * Test of getCategoriasBaseDatos method, of class Conector.
     * Prueba que todas las listas de rutas de las categorías están vacías
     */
    @Test
    public void testGetCategoriasBaseDatosRutasVacias() throws Exception{
        System.out.println("getCategoriasBaseDatos");
        conector.getCategoriasBaseDatos();
        for(Categoria categoria : conector.getListaCategorias()){
            assertTrue(categoria.getListaRutas().isEmpty());
        }
    }

    /**
     * Test of vincularCategoriasConRutas method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testVincularCategoriasConRutasExcepciones() {
        System.out.println("vincularCategoriasConRutas");
        try{
            conector.vincularCategoriasConRutas();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al vincular las rutas con las categorías");
        }
    }

    /**
     * Test of vincularCategoriasConRutas method, of class Conector.
     * Prueba que las categorías se han vinculado correctamente con las rutas
     */
    @Test
    public void testVincularCategoriasConRutas() throws Exception{
        System.out.println("vincularCategoriasConRutas");
        conector.vincularCategoriasConRutas();
        for(Categoria categoria : conector.getListaCategorias()){
            for(Ruta ruta : categoria.getListaRutas()){
                assertTrue(ruta.getListaCategorias().contains(categoria));
            }
        }
    }

    /**
     * Test of vincularCategoriasConRutas method, of class Conector.
     * Prueba que las rutas se han vinculado correctamente con las categorías
     */
    @Test
    public void testVincularCategoriasConRutasInverso() throws Exception{
        System.out.println("vincularCategoriasConRutas");
        conector.vincularCategoriasConRutas();
        for(Ruta ruta : conector.getListaRutas()){
            for(Categoria categoria : ruta.getListaCategorias()){
                assertTrue(categoria.getListaRutas().contains(ruta));
            }
        }
    }

    /**
     * Test of getValoracionesBaseDatos method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetValoracionesBaseDatosExcepciones() {
        System.out.println("getValoracionesBaseDatos");
        try{
            conector.getValoracionesBaseDatos();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener las valoraciones");
        }
    }

    /**
     * Test of getValoracionesBaseDatos method, of class Conector.
     * Prueba que el array de valoraciones contenga al menos una valoración
     */
    @Test
    public void testGetValoracionesBaseDatosTam() throws Exception{
        System.out.println("getValoracionesBaseDatos");
        conector.getValoracionesBaseDatos();
        assertTrue(conector.getListaValoraciones().size() > 0);
    }

    /**
     * Test of getValoracionesBaseDatos method, of class Conector.
     * Prueba que se han vinculado correctamente las valoraciones con las rutas
     */
    @Test
    public void testGetValoracionesBaseDatosRutasVinculadas() throws Exception{
        System.out.println("getValoracionesBaseDatos");
        conector.getValoracionesBaseDatos();
        for(Valoracion valoracion : conector.getListaValoraciones()){
            assertTrue(conector.getListaRutas().contains(valoracion.getRuta()));
            assertTrue(valoracion.getRuta().getListaValoraciones().contains(valoracion));
        }
    }

    /**
     * Test of getValoracionesBaseDatos method, of class Conector.
     * Prueba que se han vinculado correctamente las valoraciones con los usuarios
     */
    @Test
    public void testGetValoracionesBaseDatosUsuariosVinculados() throws Exception{
        System.out.println("getValoracionesBaseDatos");
        conector.getValoracionesBaseDatos();
        for(Valoracion valoracion : conector.getListaValoraciones()){
            assertTrue(conector.getListaUsuarios().contains(valoracion.getUsuario()));
            assertTrue(valoracion.getUsuario().getListaValoraciones().contains(valoracion));
        }
    }

    /**
     * Test of getTodasLasCategorias method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetTodasLasCategoriasExcepciones() {
        System.out.println("getTodasLasCategorias");
        try{
            conector.getTodasLasCategorias();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener todas las categorías");
        }
    }

    /**
     * Test of getTodasLasCategorias method, of class Conector.
     * Prueba que el array de categorías contenga al menos una categoría
     */
    @Test
    public void testGetTodasLasCategoriasTam() throws Exception{
        System.out.println("getTodasLasCategorias");
        assertTrue(conector.getTodasLasCategorias().size() > 0);
    }

    /**
     * Test of getTodasLasCategorias method, of class Conector.
     * Prueba que al menos una categoría tenga una ruta asignada
     */
    @Test
    public void testGetTodasLasCategoriasRutasVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasCategorias");
        for(Categoria categoria : conector.getTodasLasCategorias()){
            if(!categoria.getListaRutas().isEmpty()){
                if(categoria.getListaRutas().get(0).getListaCategorias().contains(categoria)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodasLasFotosPerfil method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetTodasLasFotosPerfilExcepciones() {
        System.out.println("getTodasLasFotosPerfil");
        try{
            conector.getTodasLasFotosPerfil();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener todas las fotos de perfil");
        }
    }

    /**
     * Test of getTodasLasFotosPerfil method, of class Conector.
     * Prueba que el array de fotos de perfil contenga al menos una foto
     */
    @Test
    public void testGetTodasLasFotosPerfilTam() throws Exception{
        System.out.println("getTodasLasFotosPerfil");
        assertTrue(conector.getTodasLasFotosPerfil().size() > 0);
    }

    /**
     * Test of getTodasLasFotosPerfil method, of class Conector.
     * Prueba que al menos una foto de perfil tenga un usuario asignado
     */
    @Test
    public void testGetTodasLasFotosPerfilUsuariosVinculados() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasFotosPerfil");
        for(FotoPerfil fotoPerfil : conector.getTodasLasFotosPerfil()){
            if(fotoPerfil.getUsuario() != null){
                if(fotoPerfil.getUsuario().getFotoPerfil().equals(fotoPerfil)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodasLasRutas method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetTodasLasRutasExcepciones() {
        System.out.println("getTodasLasRutas");
        try{
            conector.getTodasLasRutas();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener todas las rutas");
        }
    }

    /**
     * Test of getTodasLasRutas method, of class Conector.
     * Prueba que el array de rutas contenga al menos una ruta
     */
    @Test
    public void testGetTodasLasRutasTam() throws Exception{
        System.out.println("getTodasLasRutas");
        assertTrue(conector.getTodasLasRutas().size() > 0);
    }

    /**
     * Test of getTodasLasRutas method, of class Conector.
     * Prueba que al menos una ruta tenga una categoría asignada
     */
    @Test
    public void testGetTodasLasRutasCategoriasVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasRutas");
        for(Ruta ruta : conector.getTodasLasRutas()){
            if(!ruta.getListaCategorias().isEmpty()){
                if(ruta.getListaCategorias().get(0).getListaRutas().contains(ruta)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodasLasRutas method, of class Conector.
     * Prueba que al menos una ruta tenga una valoración asignada
     */
    @Test
    public void testGetTodasLasRutasValoracionesVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasRutas");
        for(Ruta ruta : conector.getTodasLasRutas()){
            if(!ruta.getListaValoraciones().isEmpty()){
                if(ruta.getListaValoraciones().get(0).getRuta().equals(ruta)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodasLasRutas method, of class Conector.
     * Prueba que al menos una ruta tenga un usuario asignado
     */
    @Test
    public void testGetTodasLasRutasUsuariosVinculados() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasRutas");
        for(Ruta ruta : conector.getTodasLasRutas()){
            if(ruta.getCreadorRuta() != null){
                if(ruta.getCreadorRuta().getListaRutas().contains(ruta)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodosLosUsuarios method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetTodosLosUsuariosExcepciones() {
        System.out.println("getTodosLosUsuarios");
        try{
            conector.getTodosLosUsuarios();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener todos los usuarios");
        }
    }

    /**
     * Test of getTodosLosUsuarios method, of class Conector.
     * Prueba que el array de usuarios contenga al menos un usuario
     */
    @Test
    public void testGetTodosLosUsuariosTam() throws Exception{
        System.out.println("getTodosLosUsuarios");
        assertTrue(conector.getTodosLosUsuarios().size() > 0);
    }

    /**
     * Test of getTodosLosUsuarios method, of class Conector.
     * Prueba que al menos un usuario tenga una ruta asignada
     */
    @Test
    public void testGetTodosLosUsuariosRutasVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodosLosUsuarios");
        for(Usuario usuario : conector.getTodosLosUsuarios()){
            if(!usuario.getListaRutas().isEmpty()){
                if(usuario.getListaRutas().get(0).getCreadorRuta().equals(usuario)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodosLosUsuarios method, of class Conector.
     * Prueba que al menos un usuario tenga una valoración asignada
     */
    @Test
    public void testGetTodosLosUsuariosValoracionesVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodosLosUsuarios");
        for(Usuario usuario : conector.getTodosLosUsuarios()){
            if(!usuario.getListaValoraciones().isEmpty()){
                if(usuario.getListaValoraciones().get(0).getUsuario().equals(usuario)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodosLosUsuarios method, of class Conector.
     * Prueba que al menos un usuario tenga una foto de perfil asignada
     */
    @Test
    public void testGetTodosLosUsuariosFotosPerfilVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodosLosUsuarios");
        for(Usuario usuario : conector.getTodosLosUsuarios()){
            if(usuario.getFotoPerfil() != null){
                if(usuario.getFotoPerfil().getUsuario().equals(usuario)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodasLasValoraciones method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testGetTodasLasValoracionesExcepciones() {
        System.out.println("getTodasLasValoraciones");
        try{
            conector.getTodasLasValoraciones();
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            fail("Excepción inesperada al obtener todas las valoraciones");
        }
    }

    /**
     * Test of getTodasLasValoraciones method, of class Conector.
     * Prueba que el array de valoraciones contenga al menos una valoración
     */
    @Test
    public void testGetTodasLasValoracionesTam() throws Exception{
        System.out.println("getTodasLasValoraciones");
        assertTrue(conector.getTodasLasValoraciones().size() > 0);
    }

    /**
     * Test of getTodasLasValoraciones method, of class Conector.
     * Prueba que al menos una valoración tenga una ruta asignada
     */
    @Test
    public void testGetTodasLasValoracionesRutasVinculadas() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasValoraciones");
        for(Valoracion valoracion : conector.getTodasLasValoraciones()){
            if(valoracion.getRuta() != null){
                if(valoracion.getRuta().getListaValoraciones().contains(valoracion)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    /**
     * Test of getTodasLasValoraciones method, of class Conector.
     * Prueba que al menos una valoración tenga un usuario asignado
     */
    @Test
    public void testGetTodasLasValoracionesUsuariosVinculados() throws Exception{
        boolean vinculada = false;
        System.out.println("getTodasLasValoraciones");
        for(Valoracion valoracion : conector.getTodasLasValoraciones()){
            if(valoracion.getUsuario() != null){
                if(valoracion.getUsuario().getListaValoraciones().contains(valoracion)){
                    vinculada = true;
                }
            }
        }
        assertTrue(vinculada);
    }

    //*******************************************************************//

    /**
     * Test of createCategoria method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testCreateCategoriaExcepciones() {
        System.out.println("createCategoria");
        Categoria categoria = new Categoria("categoria");
        try{
            conector.createCategoria(categoria);
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch (Exception e){
            fail("Excepción inesperada al crear la categoría");
            e.printStackTrace();
        }
    }

    /**
     * Test of createCategoria method, of class Conector.
     * Prueba que la categoría se ha creado correctamente
     */
    @Test
    public void testCreateCategoria() throws Exception {
        System.out.println("createCategoria");
        Categoria categoria = new Categoria("categoria");
        conector.createCategoria(categoria);
        conector.getTodasLasCategorias();
        boolean creada = false;
        for(Categoria categoriaAux : conector.getListaCategorias()){
            if(categoriaAux.getNombreCategoria().equals(categoria.getNombreCategoria())){
                 creada = true;
            }
        }

        assertTrue(creada);
    }

    /**
     * Test of createCategoria method, of class Conector.
     * Prueba que hay una categoría más en la base de datos
     */
    @Test
    public void testCreateCategoriaTam() throws Exception {
        System.out.println("createCategoria");
        int tam = conector.getTodasLasCategorias().size();

        Categoria categoria = new Categoria("categoria");
        conector.createCategoria(categoria);
        conector.getTodasLasCategorias();

        assertEquals(tam + 1, conector.getListaCategorias().size());
    }

    /**
     * Test of createUsuario method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testCreateUsuarioExcepciones() {
        System.out.println("createUsuario");
        Usuario usuario = new Usuario("Prueba", "Prueba", "Prueba", "ahd@sda.cs", "Prueba", "99999999R");
        try{
            conector.createUsuario(usuario);
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch (Exception e){
            fail("Excepción inesperada al crear el usuario");
            e.printStackTrace();
        }
    }

    /**
     * Test of createUsuario method, of class Conector.
     * Prueba que el usuario se ha creado correctamente
     */
    @Test
    public void testCreateUsuario() throws Exception {
        System.out.println("createUsuario");
        Usuario usuario = new Usuario("Prueba", "Prueba", "Prueba", "ahd@sda.cs", "Prueba", "99999999R");
        conector.createUsuario(usuario);
        conector.getTodosLosUsuarios();
        boolean creado = false;
        for(Usuario usuarioAux : conector.getListaUsuarios()){
            if(usuarioAux.getDNI().equals(usuario.getDNI())){
                 creado = true;
            }
        }

        assertTrue(creado);
    }

    /**
     * Test of createUsuario method, of class Conector.
     * Prueba que hay un usuario más en la base de datos
     */
    @Test
    public void testCreateUsuarioTam() throws Exception {
        System.out.println("createUsuario");
        int tam = conector.getTodosLosUsuarios().size();
        Usuario usuario = new Usuario("Prueba", "Prueba", "Prueba", "ahd@sda.cs", "Prueba", "99999999R");
        conector.createUsuario(usuario);
        conector.getTodosLosUsuarios();

        assertEquals(tam + 1, conector.getListaUsuarios().size());
    }

    /**
     * Test of createRuta method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testCreateRutaExcepciones() {
        System.out.println("createRuta");
        Ruta ruta = new Ruta("Prueba", "Ruta de prueba", 0.1, "BAJA", 0.1, conector.getListaUsuarios().get(0));
        try{
            conector.createRuta(ruta);
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch (Exception e){
            fail("Excepción inesperada al crear la ruta");
            e.printStackTrace();
        }
    }

    /**
     * Test of createRuta method, of class Conector.
     * Prueba que la ruta se ha creado correctamente
     */
    @Test
    public void testCreateRuta() throws Exception {
        System.out.println("createRuta");
        Ruta ruta = new Ruta("Prueba", "Ruta de prueba", 0.1, "BAJA", 0.1, conector.getListaUsuarios().get(0));
        conector.createRuta(ruta);
        conector.getTodasLasRutas();
        boolean creada = false;
        for(Ruta rutaAux : conector.getListaRutas()){
            if(rutaAux.getNombreRuta().equals(ruta.getNombreRuta())){
                 creada = true;
            }
        }

        assertTrue(creada);
    }

    /**
     * Test of createRuta method, of class Conector.
     * Prueba que hay una ruta más en la base de datos
     */
    @Test
    public void testCreateRutaTam() throws Exception {
        System.out.println("createRuta");
        int tam = conector.getTodasLasRutas().size();
        Ruta ruta = new Ruta("Prueba", "Ruta de prueba", 0.1, "BAJA", 0.1, conector.getListaUsuarios().get(0));
        conector.createRuta(ruta);
        conector.getTodasLasRutas();

        assertEquals(tam + 1, conector.getListaRutas().size());
    }

    /**
     * Test of createRuta method, of class Conector.
     * Prueba que la ruta creada tiene el usuario correcto asignado
     */
    @Test
    public void testCreateRutaUsuario() throws Exception {
        System.out.println("createRuta");
        Ruta ruta = new Ruta("Prueba", "Ruta de prueba", 0.1, "BAJA", 0.1, conector.getListaUsuarios().get(0));
        conector.createRuta(ruta);
        conector.getTodasLasRutas();
        boolean creada = false;
        for(Ruta rutaAux : conector.getListaRutas()){
            if(rutaAux.getNombreRuta().equals(ruta.getNombreRuta())){
                 creada = true;
                 assertEquals(rutaAux.getCreadorRuta().getIDUsuario(), ruta.getCreadorRuta().getIDUsuario());
            }
        }

        assertTrue(creada);
    }

    /**
     * Test of createFotoPerfil method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testCreateFotoPerfilExcepciones() {
        System.out.println("createFotoPerfil");
        FotoPerfil fotoPerfil = new FotoPerfil("Prueba", 24, 24, conector.getListaUsuarios().get(0));
        try{
            conector.createFotoPerfil(fotoPerfil);
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of createFotoPerfil method, of class Conector.
     * Prueba que la foto de perfil se ha creado correctamente
     */
    @Test
    public void testCreateFotoPerfil() throws Exception {
        System.out.println("createFotoPerfil");
        FotoPerfil fotoPerfil = new FotoPerfil("Prueba", 24, 24, conector.getListaUsuarios().get(0));
        conector.createFotoPerfil(fotoPerfil);
        conector.getTodasLasFotosPerfil();
        boolean creada = false;
        for(FotoPerfil fotoPerfilAux : conector.getListaFotosPerfil()){
            if(fotoPerfilAux.getNombreImagen().equals(fotoPerfil.getNombreImagen()) && fotoPerfilAux.getUsuario().getIDUsuario().equals(fotoPerfil.getUsuario().getIDUsuario())){
                 creada = true;
            }
        }

        assertTrue(creada);
    }

    /**
     * Test of createFotoPerfil method, of class Conector.
     * Prueba que hay una foto de perfil más en la base de datos
     */
    @Test
    public void testCreateFotoPerfilTam() throws Exception {
        System.out.println("createFotoPerfil");
        int tam = conector.getTodasLasFotosPerfil().size();
        FotoPerfil fotoPerfil = new FotoPerfil("Prueba", 24, 24, conector.getListaUsuarios().get(0));
        conector.createFotoPerfil(fotoPerfil);
        conector.getTodasLasFotosPerfil();

        assertEquals(tam + 1, conector.getListaFotosPerfil().size());
    }

    /**
     * Test of createFotoPerfil method, of class Conector.
     * Prueba que se ha asignado la foto de perfil al usuario correcto
     */
    @Test
    public void testCreateFotoPerfilUsuario() throws Exception {
        System.out.println("createFotoPerfil");
        FotoPerfil fotoPerfil = new FotoPerfil("Prueba", 24, 24, conector.getListaUsuarios().get(0));
        conector.createFotoPerfil(fotoPerfil);
        conector.getTodasLasFotosPerfil();
        boolean vinculada = false;

        Integer idUsuario = conector.getListaUsuarios().get(0).getIDUsuario();

        conector.getTodosLosUsuarios();

        for(Usuario usuarioAux : conector.getListaUsuarios()){
            if(usuarioAux.getIDUsuario().equals(idUsuario)){
                if(usuarioAux.getFotoPerfil().getNombreImagen().equals(fotoPerfil.getNombreImagen())){
                    vinculada = true;
                }
            }
        }

        assertTrue(vinculada);
    }

    /**
     * Test of createValoracion method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testCreateValoracionExcepciones() {
        System.out.println("createValoracion");
        Valoracion valoracion = new Valoracion(conector.getListaRutas().get(6), conector.getListaUsuarios().get(0), 5, "Prueba");
        try{
            conector.createValoracion(valoracion);
        }
        catch (SQLException sqle){
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of createValoracion method, of class Conector.
     * Prueba que la valoración se ha creado correctamente
     */
    @Test
    public void testCreateValoracion() throws Exception {
        System.out.println("createValoracion");
        Valoracion valoracion = new Valoracion(conector.getListaRutas().get(6), conector.getListaUsuarios().get(0), 5, "Prueba");
        conector.createValoracion(valoracion);
        conector.getTodasLasValoraciones();
        boolean creada = false;
        for(Valoracion valoracionAux : conector.getListaValoraciones()){
            if(valoracionAux.getRuta().getIdRuta().equals(conector.getListaRutas().get(6).getIdRuta()) && valoracionAux.getUsuario().getIDUsuario().equals(valoracion.getUsuario().getIDUsuario())){
                 creada = true;
            }
        }

        assertTrue(creada);
    }

    /**
     * Test of createValoracion method, of class Conector.
     * Prueba que hay una valoración más en la base de datos
     */
    @Test
    public void testCreateValoracionTam() throws Exception {
        System.out.println("createValoracion");
        int tam = conector.getTodasLasValoraciones().size();
        Valoracion valoracion = new Valoracion(conector.getListaRutas().get(6), conector.getListaUsuarios().get(0), 5, "Prueba");
        conector.createValoracion(valoracion);
        conector.getTodasLasValoraciones();

        assertEquals(tam + 1, conector.getListaValoraciones().size());
    }

    /**
     * Test of createValoracion method, of class Conector.
     * Prueba que la valoración media de la ruta ha cambiado
     */
    @Test
    public void testCreateValoracionMedia() throws Exception {
        System.out.println("createValoracion");
        Ruta ruta = conector.getListaRutas().get(6);
        Double valoracionMedia = ruta.getPuntuacionMedia();
        Integer idRuta = ruta.getIdRuta();
        Valoracion valoracion = new Valoracion(ruta, conector.getListaUsuarios().get(0), 1, "Prueba");
        conector.createValoracion(valoracion);
        conector.getTodasLasValoraciones();
        conector.getTodasLasRutas();

        for(Ruta rutaAux : conector.getListaRutas()){
            if(rutaAux.getIdRuta().equals(idRuta)){
                assertNotEquals(valoracionMedia, rutaAux.getPuntuacionMedia());
            }
        }
    }

    /**
     * Test of getClasificacion method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testCreateClasificacionExcepciones() {
        System.out.println("createClasificacion");
        try{
            conector.createClasificacion(conector.getListaCategorias().get(10), conector.getListaRutas().get(0));
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test of getClasificacion method, of class Conector.
     * Prueba que la clasificación se ha creado correctamente
     */
    @Test
    public void testCreateClasificacion() throws Exception {
        System.out.println("createClasificacion");
        conector.createClasificacion(conector.getListaCategorias().get(10), conector.getListaRutas().get(0));
        conector.getTodasLasCategorias();
        conector.getTodasLasRutas();
        boolean creada = false;
        for(Categoria categoriaAux : conector.getListaCategorias()){
            if(categoriaAux.getIDCategoria().equals(conector.getListaCategorias().get(10).getIDCategoria())){
                for(Ruta rutaAux : categoriaAux.getListaRutas()){
                    if(rutaAux.getIdRuta().equals(conector.getListaRutas().get(0).getIdRuta())){
                        creada = true;
                    }
                }
            }
        }

        assertTrue(creada);
    }

    //*******************************************************************//

    /**
     * Test of updateUsuario method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testUpdateUsuarioExcepciones() {
        System.out.println("updateUsuario");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Usuario usuarioAux = new Usuario(usuario.getIDUsuario(), usuario.getApellido1(), "Nuevo apellido1", usuario.getApellido2(), usuario.getCorreoElectronico(), usuario.getContrasenia(), usuario.getDNI());

        try{
            conector.updateUsuario(usuarioAux);
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            e.printStackTrace();
            fail("Excepción inesperada al actualizar el usuario");
        }
    }

    /**
     * Test of updateUsuario method, of class Conector.
     * Prueba que el usuario se ha actualizado correctamente
     */
    @Test
    public void testUpdateUsuario() throws Exception {
        System.out.println("updateUsuario");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Usuario usuarioAux = new Usuario(usuario.getIDUsuario(), usuario.getApellido1(), "Nuevo apellido1", usuario.getApellido2(), usuario.getCorreoElectronico(), usuario.getContrasenia(), usuario.getDNI());

        conector.updateUsuario(usuarioAux);
        conector.getTodosLosUsuarios();
        boolean actualizado = false;
        for(Usuario usuarioAux2 : conector.getListaUsuarios()){
            if(usuarioAux2.getIDUsuario().equals(usuario.getIDUsuario())){
                if(usuarioAux2.getApellido1().equals(usuarioAux.getApellido1())){
                    actualizado = true;
                }
            }
        }

        assertTrue(actualizado);
    }

    /**
     * Test of updateRuta method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testUpdateRutaExcepciones() {
        System.out.println("updateRuta");
        Ruta ruta = conector.getListaRutas().get(0);
        Ruta rutaAux = new Ruta(ruta.getIdRuta(), "Nuevo nombre ruta", ruta.getDescripcion(), ruta.getDistanciaKm(), ruta.getDificultad(), ruta.getTiempoHoras(), ruta.getPuntuacionMedia(), ruta.getCreadorRuta());

        try{
            conector.updateRuta(rutaAux);
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            e.printStackTrace();
            fail("Excepción inesperada al actualizar la ruta");
        }
    }

    /**
     * Test of updateRuta method, of class Conector.
     * Prueba que la ruta se ha actualizado correctamente
     */
    @Test
    public void testUpdateRuta() throws Exception {
        System.out.println("updateRuta");
        Ruta ruta = conector.getListaRutas().get(0);
        Ruta rutaAux = new Ruta(ruta.getIdRuta(), "Nuevo nombre ruta", ruta.getDescripcion(), ruta.getDistanciaKm(), ruta.getDificultad(), ruta.getTiempoHoras(), ruta.getPuntuacionMedia(), ruta.getCreadorRuta());

        conector.updateRuta(rutaAux);
        conector.getTodasLasRutas();
        boolean actualizada = false;
        for(Ruta rutaAux2 : conector.getListaRutas()){
            if(rutaAux2.getIdRuta().equals(ruta.getIdRuta())){
                if(rutaAux2.getNombreRuta().equals(rutaAux.getNombreRuta())){
                    actualizada = true;
                }
            }
        }

        assertTrue(actualizada);
    }

    /**
     * Test of updateFotoPerfil method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    public void testUpdateFotoPerfilExcepciones() {
        System.out.println("updateFotoPerfil");
        FotoPerfil fotoPerfil = conector.getListaFotosPerfil().get(0);
        FotoPerfil fotoPerfilAux = new FotoPerfil(fotoPerfil.getIDfoto(), "Nuevo nombre imagen", fotoPerfil.getResolucionImagenMp(), fotoPerfil.getTamanioKb());

        try{
            conector.updateFotoPerfil(fotoPerfilAux);
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            e.printStackTrace();
            fail("Excepción inesperada al actualizar la foto de perfil");
        }
    }

    /**
     * Test of updateFotoPerfil method, of class Conector.
     * Prueba que la foto de perfil se ha actualizado correctamente
     */
    @Test
    public void testUpdateFotoPerfil() throws Exception {
        System.out.println("updateFotoPerfil");
        FotoPerfil fotoPerfil = conector.getListaFotosPerfil().get(0);
        FotoPerfil fotoPerfilAux = new FotoPerfil(fotoPerfil.getIDfoto(), "Nuevo nombre imagen", fotoPerfil.getResolucionImagenMp(), fotoPerfil.getTamanioKb());

        conector.updateFotoPerfil(fotoPerfilAux);
        conector.getTodasLasFotosPerfil();
        boolean actualizada = false;
        for(FotoPerfil fotoPerfilAux2 : conector.getListaFotosPerfil()){
            if(fotoPerfilAux2.getIDfoto().equals(fotoPerfil.getIDfoto())){
                if(fotoPerfilAux2.getNombreImagen().equals(fotoPerfilAux.getNombreImagen())){
                    actualizada = true;
                }
            }
        }

        assertTrue(actualizada);
    }

    /**
     * Test of updateValoracion method, of class Conector.
     * Prueba que no se lancen excepciones
     */
    @Test
    public void testUpdateValoracionExcepciones() {
        System.out.println("updateValoracion");
        Valoracion valoracion = conector.getListaValoraciones().get(0);
        valoracion.setComentario("Nuevo comentario");

        try{
            conector.updateValoracion(valoracion);
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            fail("No se esperaba una excepción al ejecutar la sentencia SQL");
        }
        catch (Exception e){
            e.printStackTrace();
            fail("Excepción inesperada al actualizar la valoración");
        }
    }

    /**
     * Test of updateValoracion method, of class Conector.
     * Prueba que la valoración se ha actualizado correctamente
     */
    @Test
    public void testUpdateValoracion() throws Exception {
        System.out.println("updateValoracion");
        Valoracion valoracion = conector.getListaValoraciones().get(0);
        valoracion.setComentario("Nuevo comentario");

        conector.updateValoracion(valoracion);
        conector.getTodasLasValoraciones();
        boolean actualizada = false;
        for(Valoracion valoracionAux : conector.getListaValoraciones()){
            if(valoracionAux.getUsuario().getIDUsuario().equals(valoracion.getUsuario().getIDUsuario()) && valoracionAux.getRuta().getIdRuta().equals(valoracion.getRuta().getIdRuta())){
                if(valoracionAux.getComentario().equals(valoracion.getComentario())){
                    actualizada = true;
                }
            }
        }

        assertTrue(actualizada);
    }
}