/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.sql.Connection;
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
public class ConectorTest {

    static public Conector conector;
    private static String url = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\tests.db";
    
    public ConectorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        try{
            conector = Conector.newInstance(url);
            conector.conectar();
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
        // Prueba la conexión exitosa
        assertNotNull(conector.getConexion());
    }

    /**
     * Test of conectar method, of class Conector.
     * Comprobar reconexión a la base de datos cuando ya hay conexión
     * La conexión debe ser igual a la original
     */
    @Test
    public void testReconectar() {
        // Prueba la reconexión exitosa
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
        // Prueba la desconexión exitosa
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
        // Prueba la desconexión doble
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
     */
    @Test
    public void testBajarBaseDatos() throws Exception {
        System.out.println("bajarBaseDatos");
    }

    /**
     * Test of getFotosPerfilBaseDatos method, of class Conector.
     */
    @Test
    public void testGetFotosPerfilBaseDatos() throws Exception {
        System.out.println("getFotosPerfilBaseDatos");
    }

    /**
     * Test of getUsuariosBaseDatos method, of class Conector.
     */
    @Test
    public void testGetUsuariosBaseDatos() throws Exception {
        System.out.println("getUsuariosBaseDatos");
    }

    /**
     * Test of getRutasBaseDatos method, of class Conector.
     */
    @Test
    public void testGetRutasBaseDatos() throws Exception {
        System.out.println("getRutasBaseDatos");
    }

    /**
     * Test of getCategoriasBaseDatos method, of class Conector.
     */
    @Test
    public void testGetCategoriasBaseDatos() throws Exception {
        System.out.println("getCategoriasBaseDatos");
    }

    /**
     * Test of vincularCategoriasConRutas method, of class Conector.
     */
    @Test
    public void testVincularCategoriasConRutas() throws Exception {
        System.out.println("vincularCategoriasConRutas");
    }

    /**
     * Test of getValoracionesBaseDatos method, of class Conector.
     */
    @Test
    public void testGetValoracionesBaseDatos() throws Exception {
        System.out.println("getValoracionesBaseDatos");
    }

    /**
     * Test of getTodasLasCategorias method, of class Conector.
     */
    @Test
    public void testGetTodasLasCategorias() throws Exception {
        System.out.println("getTodasLasCategorias");
    }

    /**
     * Test of getTodasLasFotosPerfil method, of class Conector.
     */
    @Test
    public void testGetTodasLasFotosPerfil() throws Exception {
        System.out.println("getTodasLasFotosPerfil");
    }

    /**
     * Test of getTodasLasRutas method, of class Conector.
     */
    @Test
    public void testGetTodasLasRutas() throws Exception {
        System.out.println("getTodasLasRutas");
    }

    /**
     * Test of getTodosLosUsuarios method, of class Conector.
     */
    @Test
    public void testGetTodosLosUsuarios() throws Exception {
        System.out.println("getTodosLosUsuarios");
    }

    /**
     * Test of getTodasLasValoraciones method, of class Conector.
     */
    @Test
    public void testGetTodasLasValoraciones() throws Exception {
        System.out.println("getTodasLasValoraciones");
    }

    /**
     * Test of createCategoria method, of class Conector.
     */
    @Test
    public void testCreateCategoria() throws Exception {
        System.out.println("createCategoria");
    }

    /**
     * Test of createUsuario method, of class Conector.
     */
    @Test
    public void testCreateUsuario() throws Exception {
        System.out.println("createUsuario");
    }

    /**
     * Test of createRuta method, of class Conector.
     */
    @Test
    public void testCreateRuta() throws Exception {
        System.out.println("createRuta");
    }

    /**
     * Test of createFotoPerfil method, of class Conector.
     */
    @Test
    public void testCreateFotoPerfil() throws Exception {
        System.out.println("createFotoPerfil");
    }

    /**
     * Test of createValoracion method, of class Conector.
     */
    @Test
    public void testCreateValoracion() throws Exception {
        System.out.println("createValoracion");
    }

    /**
     * Test of createClasificacion method, of class Conector.
     */
    @Test
    public void testCreateClasificacion() throws Exception {
        System.out.println("createClasificacion");
    }

    /**
     * Test of updateUsuario method, of class Conector.
     */
    @Test
    public void testUpdateUsuario() throws Exception {
        System.out.println("updateUsuario");
    }

    /**
     * Test of updateRuta method, of class Conector.
     */
    @Test
    public void testUpdateRuta() throws Exception {
        System.out.println("updateRuta");
    }

    /**
     * Test of updateFotoPerfil method, of class Conector.
     */
    @Test
    public void testUpdateFotoPerfil() throws Exception {
        System.out.println("updateFotoPerfil");
    }

    /**
     * Test of updateValoracion method, of class Conector.
     */
    @Test
    public void testUpdateValoracion() throws Exception {
        System.out.println("updateValoracion");
    }

    /**
     * Test of deleteCategoria method, of class Conector.
     */
    @Test
    public void testDeleteCategoria() throws Exception {
        System.out.println("deleteCategoria");
    }

    /**
     * Test of deleteUsuario method, of class Conector.
     */
    @Test
    public void testDeleteUsuario() throws Exception {
        System.out.println("deleteUsuario");
    }

    /**
     * Test of deleteRuta method, of class Conector.
     */
    @Test
    public void testDeleteRuta() throws Exception {
        System.out.println("deleteRuta");
    }

    /**
     * Test of deleteValoracion method, of class Conector.
     */
    @Test
    public void testDeleteValoracion() throws Exception {
        System.out.println("deleteValoracion");
    }

    /**
     * Test of deleteFotoPerfil method, of class Conector.
     */
    @Test
    public void testDeleteFotoPerfil() throws Exception {
        System.out.println("deleteFotoPerfil");
    }

    /**
     * Test of deleteClasificacion method, of class Conector.
     */
    @Test
    public void testDeleteClasificacion() throws Exception {
        System.out.println("deleteClasificacion");
    }
    
}
