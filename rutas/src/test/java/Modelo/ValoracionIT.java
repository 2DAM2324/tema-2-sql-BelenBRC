/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
public class ValoracionIT {
    
    public ValoracionIT() {
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
     * Test of setPuntuacion method, of class Valoracion.
     */
    @Test
    public void testSetPuntuacion() {
        System.out.println("setPuntuacion");
        Integer puntuacion = null;
        Valoracion instance = null;
        instance.setPuntuacion(puntuacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComentario method, of class Valoracion.
     */
    @Test
    public void testSetComentario() {
        System.out.println("setComentario");
        String comentario = "";
        Valoracion instance = null;
        instance.setComentario(comentario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRuta method, of class Valoracion.
     */
    @Test
    public void testGetRuta() {
        System.out.println("getRuta");
        Valoracion instance = null;
        Ruta expResult = null;
        Ruta result = instance.getRuta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class Valoracion.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        Valoracion instance = null;
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPuntuacion method, of class Valoracion.
     */
    @Test
    public void testGetPuntuacion() {
        System.out.println("getPuntuacion");
        Valoracion instance = null;
        Integer expResult = null;
        Integer result = instance.getPuntuacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComentario method, of class Valoracion.
     */
    @Test
    public void testGetComentario() {
        System.out.println("getComentario");
        Valoracion instance = null;
        String expResult = "";
        String result = instance.getComentario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Valoracion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Valoracion instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
