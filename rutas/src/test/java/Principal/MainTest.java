//Belén Robustillo Carmona

package Principal;

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
public class MainTest {
    
    public MainTest() {
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
     * Test of main method, of class Main.
     * Comprueba que se ejecuta el main sin errores
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        try{
            Main.main(args);
        }
        catch(Exception e){
            fail("Error al ejecutar el main.");
        }    
    }  
    
}
