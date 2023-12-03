package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 *
 * @author belen
 */
public class RutaTest {
    private static Ruta instance;
    static public Conector conector;
    private static String url = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\tests.db";
    
    
    public RutaTest() {
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
        instance = null;
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }
 
    /**
     * Test of setValoracionEnLista method, of class Ruta.
     * Valoración a ruta no valorada, el array de valoraciones de la ruta tendrá 1 elemento
     */
    @Test
    public void testSetValoracionEnLista1() {
        System.out.println("setValoracionEnLista1");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);

        instance.setValoracionEnLista(valoracion);

        assertEquals(1, instance.getListaValoraciones().size());
    }

    /**
     * Test of setValoracionEnLista method, of class Ruta.
     * Valoración a ruta no valorada, la puntuaación de la ruta será la misma que la valoración
     */
    @Test
    public void testSetValoracionEnLista2() {
        System.out.println("setValoracionEnLista2");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);

        instance.setValoracionEnLista(valoracion);

        assert(puntuacion == instance.getPuntuacionMedia());
    }

    /**
     * Test of setValoracionEnLista method, of class Ruta.
     * Valoración a ruta valorada, el array de valoraciones de la ruta tendrá 1 elemento más
     */
    @Test
    public void testSetValoracionEnLista3() {
        System.out.println("setValoracionEnLista3");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);

        instance.setValoracionEnLista(valoracion);
        
        Usuario usuario2 = conector.getListaUsuarios().get(1);
        Integer puntuacion2 = 4;
        String comentario2 = "Comentario de prueba 2";

        Valoracion valoracion2 = new Valoracion(instance, usuario2, puntuacion2, comentario2);

        instance.setValoracionEnLista(valoracion2);

        assertEquals(2, instance.getListaValoraciones().size());
    }

    /**
     * Test of setValoracionEnLista method, of class Ruta.
     * Valoración a ruta valorada, la puntuaación de la ruta será la media de las valoraciones
     */
    @Test
    public void testSetValoracionEnLista4() {
        System.out.println("setValoracionEnLista4");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);

        instance.setValoracionEnLista(valoracion);
        
        Usuario usuario2 = conector.getListaUsuarios().get(1);
        Integer puntuacion2 = 4;
        String comentario2 = "Comentario de prueba 2";

        Valoracion valoracion2 = new Valoracion(instance, usuario2, puntuacion2, comentario2);

        instance.setValoracionEnLista(valoracion2);

        Double media = (double) (puntuacion + puntuacion2) / 2;

        assert(instance.getPuntuacionMedia() == media);
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     * Lista de valoraciones vacía, el array de valoraciones de la ruta tendrá 0 elementos
     */
    @Test
    public void testSetListaValoraciones1() {
        System.out.println("setListaValoraciones1");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        ArrayList<Valoracion> listaValoraciones = new ArrayList<Valoracion>();
        instance.setListaValoraciones(listaValoraciones);

        assertEquals(0, instance.getListaValoraciones().size());
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     * Lista de valoraciones vacía, la puntuación media de la ruta será 0
     */
    @Test
    public void testSetListaValoraciones2() {
        System.out.println("setListaValoraciones2");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        ArrayList<Valoracion> listaValoraciones = new ArrayList<Valoracion>();
        instance.setListaValoraciones(listaValoraciones);

        assertEquals(0, instance.getPuntuacionMedia());
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     * Lista de valoraciones con 1 elemento, el array de valoraciones de la ruta tendrá 1 elemento
     */
    @Test
    public void testSetListaValoraciones3() {
        System.out.println("setListaValoraciones3");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        ArrayList<Valoracion> listaValoraciones = new ArrayList<Valoracion>();
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);
        listaValoraciones.add(valoracion);

        instance.setListaValoraciones(listaValoraciones);

        assertEquals(1, instance.getListaValoraciones().size());
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     * Lista de valoraciones con 1 elemento, la puntuación media de la ruta será la misma que la valoración
     */
    @Test
    public void testSetListaValoraciones4() {
        System.out.println("setListaValoraciones4");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        ArrayList<Valoracion> listaValoraciones = new ArrayList<Valoracion>();
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);
        listaValoraciones.add(valoracion);

        instance.setListaValoraciones(listaValoraciones);

        assert(puntuacion == instance.getPuntuacionMedia());
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     * Lista de valoraciones con 2 elementos, el array de valoraciones de la ruta tendrá 2 elementos
     */
    @Test
    public void testSetListaValoraciones5() {
        System.out.println("setListaValoraciones5");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        ArrayList<Valoracion> listaValoraciones = new ArrayList<Valoracion>();
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);
        listaValoraciones.add(valoracion);
        
        Usuario usuario2 = conector.getListaUsuarios().get(1);
        Integer puntuacion2 = 4;
        String comentario2 = "Comentario de prueba 2";

        Valoracion valoracion2 = new Valoracion(instance, usuario2, puntuacion2, comentario2);
        listaValoraciones.add(valoracion2);

        instance.setListaValoraciones(listaValoraciones);

        assertEquals(2, instance.getListaValoraciones().size());
    }

    /**
     * Test of setListaValoraciones method, of class Ruta.
     * Lista de valoraciones con 2 elementos, la puntuación media de la ruta será la media de las valoraciones
     */
    @Test
    public void testSetListaValoraciones6() {
        System.out.println("setListaValoraciones6");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        ArrayList<Valoracion> listaValoraciones = new ArrayList<Valoracion>();
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";

        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);
        listaValoraciones.add(valoracion);
        
        Usuario usuario2 = conector.getListaUsuarios().get(1);
        Integer puntuacion2 = 4;
        String comentario2 = "Comentario de prueba 2";

        Valoracion valoracion2 = new Valoracion(instance, usuario2, puntuacion2, comentario2);
        listaValoraciones.add(valoracion2);

        instance.setListaValoraciones(listaValoraciones);

        Double media = (double) (puntuacion + puntuacion2) / 2;

        assert(instance.getPuntuacionMedia() == media);
    }

    /**
     * Test of setCategoriaEnLista method, of class Ruta.
     * Categoría a ruta no categorizada, el array de categorías de la ruta tendrá 1 elemento
     */
    @Test
    public void testSetCategoriaEnLista1() {
        System.out.println("setCategoriaEnLista1");
        Categoria categoria = conector.getListaCategorias().get(0);

        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        instance.setCategoriaEnLista(categoria);

        assertEquals(1, instance.getListaCategorias().size());
    }

    /**
     * Test of setCategoriaEnLista method, of class Ruta.
     * Añadir categoría ya asignada a ruta, el array de categorías de la ruta tendrá 1 elemento
     */
    @Test
    public void testSetCategoriaEnLista2() {
        System.out.println("setCategoriaEnLista2");
        Categoria categoria = conector.getListaCategorias().get(0);

        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));

        instance.setCategoriaEnLista(categoria);
        instance.setCategoriaEnLista(categoria);

        assertEquals(1, instance.getListaCategorias().size());
    }

    /**
     * Test of calcularPuntuacionMedia method, of class Ruta.
     * Ruta sin valoraciones, la puntuación media de la ruta será 0
     */
    @Test
    public void testCalcularPuntuacionMedia1() {
        System.out.println("calcularPuntuacionMedia1");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));
        
        assert(0 == instance.getPuntuacionMedia());
    }

    /**
     * Test of calcularPuntuacionMedia method, of class Ruta.
     * Ruta con 1 valoración, la puntuación media de la ruta será la misma que la valoración
     */
    @Test
    public void testCalcularPuntuacionMedia2() {
        System.out.println("calcularPuntuacionMedia2");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";
        
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);
        
        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);
        
        instance.setValoracionEnLista(valoracion);
        
        assert(puntuacion == instance.getPuntuacionMedia());
    }

    /**
     * Test of calcularPuntuacionMedia method, of class Ruta.
     * Ruta con 2 valoraciones, la puntuación media de la ruta será la media de las valoraciones
     */
    @Test
    public void testCalcularPuntuacionMedia3() {
        System.out.println("calcularPuntuacionMedia3");
        Usuario usuario = conector.getListaUsuarios().get(0);
        Integer puntuacion = 5;
        String comentario = "Comentario de prueba";
        
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, usuario);
        
        Valoracion valoracion = new Valoracion(instance, usuario, puntuacion, comentario);
        
        instance.setValoracionEnLista(valoracion);
        
        Usuario usuario2 = conector.getListaUsuarios().get(1);
        Integer puntuacion2 = 4;
        String comentario2 = "Comentario de prueba 2";
        
        Valoracion valoracion2 = new Valoracion(instance, usuario2, puntuacion2, comentario2);
        
        instance.setValoracionEnLista(valoracion2);
        
        Double media = (double) (puntuacion + puntuacion2) / 2;
        
        assert(instance.getPuntuacionMedia() == media);
    }

    /**
     * Test of toString method, of class Ruta.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        instance = new Ruta("Ruta de prueba", "Descripción de prueba", 1, "ALTA", 1, conector.getListaUsuarios().get(0));
        
        String expResult = "Ruta de prueba - By: " + conector.getListaUsuarios().get(0).getDNI();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
