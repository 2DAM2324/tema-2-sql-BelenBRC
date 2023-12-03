package Modelo;

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
public class UsuarioTest {
    private static Usuario instance;
    static public Conector conector;
    private static String url = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\tests.db";
    
    
    public UsuarioTest() {
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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setValoracionEnLista method, of class Usuario.
     * Valoración no existente
     */
    @Test
    public void testSetValoracionEnLista() {
        System.out.println("setValoracionEnLista");
        instance = new Usuario("UsuarioPrueba", "Prueba", "Prueba", "hola@tu.es", "1234", "12345678Z");
        Ruta ruta = conector.getListaRutas().get(0);
        Valoracion valoracion = new Valoracion(ruta, instance, 5, "Comentario de prueba");

        instance.setValoracionEnLista(valoracion);
        assertEquals(instance.getListaValoraciones().get(0), valoracion);
    }

    /**
     * Test of setValoracionEnLista method, of class Usuario.
     * Valoración existente no se añade
     */
    @Test
    public void testSetValoracionEnLista2() {
        System.out.println("setValoracionEnLista");
        instance = new Usuario("UsuarioPrueba", "Prueba", "Prueba", "hola@tu.es", "1234", "12345678Z");
        Ruta ruta = conector.getListaRutas().get(0);
        Valoracion valoracion = new Valoracion(ruta, instance, 5, "Comentario de prueba");

        instance.setValoracionEnLista(valoracion);
        instance.setValoracionEnLista(valoracion);
        assertEquals(instance.getListaValoraciones().size(), 1);
    }

    /**
     * Test of setValoracionEnLista method, of class Usuario.
     * Nueva valoracion incrementa el array en 1
     */
    @Test
    public void testSetValoracionEnLista3() {
        System.out.println("setValoracionEnLista");
        instance = new Usuario("UsuarioPrueba", "Prueba", "Prueba", "hola@tu.es", "1234", "12345678Z");
        Ruta ruta = conector.getListaRutas().get(0);
        Valoracion valoracion = new Valoracion(ruta, instance, 5, "Comentario de prueba");
        instance.setValoracionEnLista(valoracion);

        Integer tamanoInicial = instance.getListaValoraciones().size();

        Valoracion valoracion2 = new Valoracion(ruta, instance, 5, "Comentario de prueba");
        instance.setValoracionEnLista(valoracion2);

        Integer tamanoFinal = instance.getListaValoraciones().size();

        assertEquals(tamanoInicial + 1, tamanoFinal);
    }

    /**
     * Test of getFotoPerfil method, of class Usuario.
     * Usuario sin foto de perfil devuelve null
     */
    @Test
    public void testGetFotoPerfil() {
        System.out.println("getFotoPerfil");
        instance = new Usuario("UsuarioPrueba", "Prueba", "Prueba", "hola@tu.es", "1234", "12345678Z");
        FotoPerfil expResult = null;

        FotoPerfil result = instance.getFotoPerfil();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFotoPerfil method, of class Usuario.
     * Usuario con foto de perfil devuelve la foto de perfil
     */
    @Test
    public void testGetFotoPerfil2() {
        System.out.println("getFotoPerfil");
        instance = conector.getListaUsuarios().get(0);

        FotoPerfil result = instance.getFotoPerfil();
        assertNotNull(result);
    }
}
