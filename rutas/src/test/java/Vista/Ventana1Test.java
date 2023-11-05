//Belén Robustillo Carmona

package Vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author belen
 */
public class Ventana1Test {
    Ventana1 instance;
    
    public Ventana1Test() {
        try {
            instance = new Ventana1();
        } catch (IOException | ClassNotFoundException | SAXException ex) {
            Logger.getLogger(Ventana1Test.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * Test of LimpiarTabla method, of class Ventana1.
     */
    @Test
    public void testLimpiarTabla() {
        System.out.println("LimpiarTabla");
        DefaultTableModel modelo = null;
        
        instance.LimpiarTabla(modelo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintarDatosCategoria method, of class Ventana1.
     */
    @Test
    public void testPintarDatosCategoria() {
        System.out.println("pintarDatosCategoria");
        instance.pintarDatosCategoria();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintarDatosRuta method, of class Ventana1.
     */
    @Test
    public void testPintarDatosRuta() {
        System.out.println("pintarDatosRuta");
        
        instance.pintarDatosRuta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintarDatosUsuario method, of class Ventana1.
     */
    @Test
    public void testPintarDatosUsuario() {
        System.out.println("pintarDatosUsuario");
        
        instance.pintarDatosUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintarDatosValoracion method, of class Ventana1.
     */
    @Test
    public void testPintarDatosValoracion() {
        System.out.println("pintarDatosValoracion");
        
        instance.pintarDatosValoracion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
