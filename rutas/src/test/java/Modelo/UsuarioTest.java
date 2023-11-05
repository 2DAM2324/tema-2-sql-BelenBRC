//Belén Robustillo Carmona

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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of setApellido1 method, of class Usuario.
     */
    @Test
    public void testSetApellido1() {
        System.out.println("setApellido1");
        String apellido1 = "";
        Usuario instance = null;
        instance.setApellido1(apellido1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido2 method, of class Usuario.
     */
    @Test
    public void testSetApellido2() {
        System.out.println("setApellido2");
        String apellido2 = "";
        Usuario instance = null;
        instance.setApellido2(apellido2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCorreoElectronico method, of class Usuario.
     */
    @Test
    public void testSetCorreoElectronico() {
        System.out.println("setCorreoElectronico");
        String correo = "";
        Usuario instance = null;
        instance.setCorreoElectronico(correo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrasenia method, of class Usuario.
     */
    @Test
    public void testSetContrasenia() {
        System.out.println("setContrasenia");
        String contrasenia = "";
        Usuario instance = null;
        instance.setContrasenia(contrasenia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFotoPerfil method, of class Usuario.
     */
    @Test
    public void testSetFotoPerfil() {
        System.out.println("setFotoPerfil");
        FotoPerfil fotoPerfil = null;
        Usuario instance = null;
        instance.setFotoPerfil(fotoPerfil);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaValoraciones method, of class Usuario.
     */
    @Test
    public void testSetListaValoraciones() {
        System.out.println("setListaValoraciones");
        ArrayList<Valoracion> listaValoraciones = null;
        Usuario instance = null;
        instance.setListaValoraciones(listaValoraciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValoracionEnLista method, of class Usuario.
     */
    @Test
    public void testSetValoracionEnLista() {
        System.out.println("setValoracionEnLista");
        Valoracion valoracion = null;
        Usuario instance = null;
        instance.setValoracionEnLista(valoracion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaRutas method, of class Usuario.
     */
    @Test
    public void testSetListaRutas() {
        System.out.println("setListaRutas");
        ArrayList<Ruta> listaRutas = null;
        Usuario instance = null;
        instance.setListaRutas(listaRutas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutaEnLista method, of class Usuario.
     */
    @Test
    public void testSetRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = null;
        Usuario instance = null;
        instance.setRutaEnLista(ruta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIDUsuario method, of class Usuario.
     */
    @Test
    public void testGetIDUsuario() {
        System.out.println("getIDUsuario");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getIDUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreUsuario method, of class Usuario.
     */
    @Test
    public void testGetNombreUsuario() {
        System.out.println("getNombreUsuario");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido1 method, of class Usuario.
     */
    @Test
    public void testGetApellido1() {
        System.out.println("getApellido1");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getApellido1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido2 method, of class Usuario.
     */
    @Test
    public void testGetApellido2() {
        System.out.println("getApellido2");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getApellido2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorreoElectronico method, of class Usuario.
     */
    @Test
    public void testGetCorreoElectronico() {
        System.out.println("getCorreoElectronico");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getCorreoElectronico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrasenia method, of class Usuario.
     */
    @Test
    public void testGetContrasenia() {
        System.out.println("getContrasenia");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getContrasenia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDNI method, of class Usuario.
     */
    @Test
    public void testGetDNI() {
        System.out.println("getDNI");
        Usuario instance = null;
        String expResult = "";
        String result = instance.getDNI();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFotoPerfil method, of class Usuario.
     */
    @Test
    public void testGetFotoPerfil() {
        System.out.println("getFotoPerfil");
        Usuario instance = null;
        FotoPerfil expResult = null;
        FotoPerfil result = instance.getFotoPerfil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaValoraciones method, of class Usuario.
     */
    @Test
    public void testGetListaValoraciones() {
        System.out.println("getListaValoraciones");
        Usuario instance = null;
        ArrayList<Valoracion> expResult = null;
        ArrayList<Valoracion> result = instance.getListaValoraciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValoracionEnListaPorPosicion method, of class Usuario.
     */
    @Test
    public void testGetValoracionEnListaPorPosicion() {
        System.out.println("getValoracionEnListaPorPosicion");
        Integer posicion = null;
        Usuario instance = null;
        Valoracion expResult = null;
        Valoracion result = instance.getValoracionEnListaPorPosicion(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaRutas method, of class Usuario.
     */
    @Test
    public void testGetListaRutas() {
        System.out.println("getListaRutas");
        Usuario instance = null;
        ArrayList<Ruta> expResult = null;
        ArrayList<Ruta> result = instance.getListaRutas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutaEnListaPorPosicion method, of class Usuario.
     */
    @Test
    public void testGetRutaEnListaPorPosicion() {
        System.out.println("getRutaEnListaPorPosicion");
        Integer posicion = null;
        Usuario instance = null;
        Ruta expResult = null;
        Ruta result = instance.getRutaEnListaPorPosicion(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
