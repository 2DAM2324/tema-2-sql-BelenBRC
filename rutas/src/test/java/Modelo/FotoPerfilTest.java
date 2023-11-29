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
    private FotoPerfil instance;
    private Usuario usuario;
    
    public FotoPerfilTest() {
        usuario = new Usuario(1, "Prueba", "1", "1", "adj@hsd.com", "1234", "07896541P");
        instance = new FotoPerfil("Foto", 4587, 48765, usuario);
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
     * Set nombre vacío
     */
    @Test
    public void testSetNombreVacioImagen() {
        System.out.println("setNombreImagen");
        String nombre = "";
        instance.setNombreImagen(nombre);
        assertEquals(nombre, instance.getNombreImagen());
    }

    /**
     * Test of setNombreImagen method, of class FotoPerfil.
     * Set nombre null
     */
    @Test
    public void testSetNombreNullImagen() {
        System.out.println("setNombreImagen");
        String nombre = null;
        instance.setNombreImagen(nombre);
        assertEquals(nombre, instance.getNombreImagen());
    }

    /**
     * Test of setNombreImagen method, of class FotoPerfil.
     * Set nombre válido
     */
    @Test
    public void testSetNombreValidoImagen() {
        System.out.println("setNombreImagen");
        String nombre = "Fotografía chula";
        instance.setNombreImagen(nombre);
        assertEquals(nombre, instance.getNombreImagen());
    }

    /**
     * Test of setResolucionImagenMp method, of class FotoPerfil.
     * Set resolución null
     */
    @Test
    public void testSetResolucionImagenMp() {
        System.out.println("setResolucionImagenMp");
        Integer resolucionMp = null;
        instance.setResolucionImagenMp(resolucionMp);
        assertEquals(resolucionMp, instance.getResolucionImagenMp());
    }

    /**
     * Test of setResolucionImagenMp method, of class FotoPerfil.
     * Set resolución válida
     */
    @Test
    public void testSetResolucionValidaImagenMp() {
        System.out.println("setResolucionImagenMp");
        Integer resolucionMp = 4587;
        instance.setResolucionImagenMp(resolucionMp);
        assertEquals(resolucionMp, instance.getResolucionImagenMp());
    }

    /**
     * Test of setTamanioKb method, of class FotoPerfil.
     * Set tamaño null
     */
    @Test
    public void testSetTamanioKb() {
        System.out.println("setTamanioKb");
        Integer tamanioKb = null;
        instance.setTamanioKb(tamanioKb);
        assertEquals(tamanioKb, instance.getTamanioKb());
    }

    /**
     * Test of setTamanioKb method, of class FotoPerfil.
     * Set tamaño válido
     */
    @Test
    public void testSetTamanioValidoKb() {
        System.out.println("setTamanioKb");
        Integer tamanioKb = 4587;
        instance.setTamanioKb(tamanioKb);
        assertEquals(tamanioKb, instance.getTamanioKb());
    }

    /**
     * Test of setUsuario method, of class FotoPerfil.
     * Set usuario null
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        instance.setUsuario(usuario);
        assertEquals(usuario, instance.getUsuario());
    }

    /**
     * Test of setUsuario method, of class FotoPerfil.
     * Set usuario válido
     */
    @Test
    public void testSetValidUsuario() {
        System.out.println("setUsuario");
        instance.setUsuario(usuario);
        assertEquals(usuario, instance.getUsuario());
    }

    /**
     * Test of getIDfoto method, of class FotoPerfil.
     * Test ID null
     */
    @Test
    public void testGetIDfoto() {
        System.out.println("getIDfoto");
        Integer expResult = null;
        Integer result = instance.getIDfoto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIDfoto method, of class FotoPerfil.
     * Test ID válido
     */
    @Test
    public void testGetValidIDfoto() {
        System.out.println("getIDfoto");
        Integer expResult = 1;
        FotoPerfil instance = new FotoPerfil(1, "Foto", 4587, 48765);
        Integer result = instance.getIDfoto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreImagen method, of class FotoPerfil.
     * Test nombre null
     */
    @Test
    public void testGetNombreImagen() {
        System.out.println("getNombreImagen");
        instance.setNombreImagen(null);
        String expResult = null;
        String result = instance.getNombreImagen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreImagen method, of class FotoPerfil.
     * Test nombre vacío
     */
    @Test
    public void testGetNombreVacioImagen() {
        System.out.println("getNombreImagen");
        instance.setNombreImagen("");
        String expResult = "";
        String result = instance.getNombreImagen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreImagen method, of class FotoPerfil.
     * Test nombre válido
     */
    @Test
    public void testGetValidNombreImagen() {
        System.out.println("getNombreImagen");
        instance.setNombreImagen("Foto");
        String expResult = "Foto";
        String result = instance.getNombreImagen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResolucionImagenMp method, of class FotoPerfil.
     * Test resolución null
     */
    @Test
    public void testGetResolucionImagenMp() {
        System.out.println("getResolucionImagenMp");
        instance.setResolucionImagenMp(null);
        Integer expResult = null;
        Integer result = instance.getResolucionImagenMp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResolucionImagenMp method, of class FotoPerfil.
     * Test resolución válida
     */
    @Test
    public void testGetValidResolucionImagenMp() {
        System.out.println("getResolucionImagenMp");
        instance.setResolucionImagenMp(4587);
        Integer expResult = 4587;
        Integer result = instance.getResolucionImagenMp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTamanioKb method, of class FotoPerfil.
     * Test tamaño null
     */
    @Test
    public void testGetTamanioKb() {
        System.out.println("getTamanioKb");
        instance.setTamanioKb(null);
        Integer expResult = null;
        Integer result = instance.getTamanioKb();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTamanioKb method, of class FotoPerfil.
     * Test tamaño válido
     */
    @Test
    public void testGetValidTamanioKb() {
        System.out.println("getTamanioKb");
        instance.setTamanioKb(4587);
        Integer expResult = 4587;
        Integer result = instance.getTamanioKb();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsuario method, of class FotoPerfil.
     * Test usuario válido
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Usuario expResult = usuario;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsuario method, of class FotoPerfil.
     * Test usuario null
     */
    @Test
    public void testGetNullUsuario() {
        System.out.println("getUsuario");
        instance.setUsuario(null);
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
    }
    
}
