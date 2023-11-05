//Belén Robustillo Carmona

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
public class FotoPerfilTest {
    
    public FotoPerfilTest() {
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
     * Test of setNombreImagen method, of class FotoPerfil.
     */
    @Test
    public void testSetNombreImagen() {
        System.out.println("setNombreImagen");
        String nombre = "";
        FotoPerfil instance = null;
        instance.setNombreImagen(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResolucionImagenMp method, of class FotoPerfil.
     */
    @Test
    public void testSetResolucionImagenMp() {
        System.out.println("setResolucionImagenMp");
        Integer resolucionMp = null;
        FotoPerfil instance = null;
        instance.setResolucionImagenMp(resolucionMp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTamanioKb method, of class FotoPerfil.
     */
    @Test
    public void testSetTamanioKb() {
        System.out.println("setTamanioKb");
        Integer tamanioKb = null;
        FotoPerfil instance = null;
        instance.setTamanioKb(tamanioKb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIDfoto method, of class FotoPerfil.
     */
    @Test
    public void testGetIDfoto() {
        System.out.println("getIDfoto");
        FotoPerfil instance = null;
        String expResult = "";
        String result = instance.getIDfoto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreImagen method, of class FotoPerfil.
     */
    @Test
    public void testGetNombreImagen() {
        System.out.println("getNombreImagen");
        FotoPerfil instance = null;
        String expResult = "";
        String result = instance.getNombreImagen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResolucionImagenMp method, of class FotoPerfil.
     */
    @Test
    public void testGetResolucionImagenMp() {
        System.out.println("getResolucionImagenMp");
        FotoPerfil instance = null;
        Integer expResult = null;
        Integer result = instance.getResolucionImagenMp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTamanioKb method, of class FotoPerfil.
     */
    @Test
    public void testGetTamanioKb() {
        System.out.println("getTamanioKb");
        FotoPerfil instance = null;
        Integer expResult = null;
        Integer result = instance.getTamanioKb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class FotoPerfil.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        FotoPerfil instance = null;
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FotoPerfil.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FotoPerfil instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
