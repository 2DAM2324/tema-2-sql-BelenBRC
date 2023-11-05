//Belén Robustillo Carmona

package Controlador;

import Modelo.Categoria;
import Modelo.FotoPerfil;
import Modelo.Ruta;
import Modelo.Usuario;
import Modelo.Valoracion;
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
public class ControladorTest {
    
    public ControladorTest() {
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
     * Test of setListaCategoriasSistema method, of class Controlador.
     */
    @Test
    public void testSetListaCategoriasSistema() {
        System.out.println("setListaCategoriasSistema");
        ArrayList<Categoria> listaCategoriasSistema = null;
        Controlador instance = new Controlador();
        instance.setListaCategoriasSistema(listaCategoriasSistema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoriaEnLista method, of class Controlador.
     */
    @Test
    public void testSetCategoriaEnLista() {
        System.out.println("setCategoriaEnLista");
        Categoria categoria = null;
        Controlador instance = new Controlador();
        instance.setCategoriaEnLista(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaUsuariosSistema method, of class Controlador.
     */
    @Test
    public void testSetListaUsuariosSistema() {
        System.out.println("setListaUsuariosSistema");
        ArrayList<Usuario> listaUsuariosSistema = null;
        Controlador instance = new Controlador();
        instance.setListaUsuariosSistema(listaUsuariosSistema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuarioEnLista method, of class Controlador.
     */
    @Test
    public void testSetUsuarioEnLista() {
        System.out.println("setUsuarioEnLista");
        Usuario usuario = null;
        Controlador instance = new Controlador();
        instance.setUsuarioEnLista(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaFotosPerfilSistema method, of class Controlador.
     */
    @Test
    public void testSetListaFotosPerfilSistema() {
        System.out.println("setListaFotosPerfilSistema");
        ArrayList<FotoPerfil> listaFotosPerfilSistema = null;
        Controlador instance = new Controlador();
        instance.setListaFotosPerfilSistema(listaFotosPerfilSistema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFotoPerfilEnLista method, of class Controlador.
     */
    @Test
    public void testSetFotoPerfilEnLista() {
        System.out.println("setFotoPerfilEnLista");
        FotoPerfil fotoPerfil = null;
        Controlador instance = new Controlador();
        instance.setFotoPerfilEnLista(fotoPerfil);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaRutasSistema method, of class Controlador.
     */
    @Test
    public void testSetListaRutasSistema() {
        System.out.println("setListaRutasSistema");
        ArrayList<Ruta> listaRutasSistema = null;
        Controlador instance = new Controlador();
        instance.setListaRutasSistema(listaRutasSistema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutaEnLista method, of class Controlador.
     */
    @Test
    public void testSetRutaEnLista() {
        System.out.println("setRutaEnLista");
        Ruta ruta = null;
        Controlador instance = new Controlador();
        instance.setRutaEnLista(ruta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaValoracionesSistema method, of class Controlador.
     */
    @Test
    public void testSetListaValoracionesSistema() {
        System.out.println("setListaValoracionesSistema");
        ArrayList<Valoracion> listaValoracionesSistema = null;
        Controlador instance = new Controlador();
        instance.setListaValoracionesSistema(listaValoracionesSistema);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValoracionEnLista method, of class Controlador.
     */
    @Test
    public void testSetValoracionEnLista() {
        System.out.println("setValoracionEnLista");
        Valoracion valoracion = null;
        Controlador instance = new Controlador();
        instance.setValoracionEnLista(valoracion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCategoriasSistema method, of class Controlador.
     */
    @Test
    public void testGetListaCategoriasSistema() {
        System.out.println("getListaCategoriasSistema");
        Controlador instance = new Controlador();
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.getListaCategoriasSistema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaRutasCategoria method, of class Controlador.
     */
    @Test
    public void testGetListaRutasCategoria() {
        System.out.println("getListaRutasCategoria");
        String IDcategoria = "";
        Controlador instance = new Controlador();
        ArrayList<Ruta> expResult = null;
        ArrayList<Ruta> result = instance.getListaRutasCategoria(IDcategoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUsuariosSistema method, of class Controlador.
     */
    @Test
    public void testGetListaUsuariosSistema() {
        System.out.println("getListaUsuariosSistema");
        Controlador instance = new Controlador();
        ArrayList<Usuario> expResult = null;
        ArrayList<Usuario> result = instance.getListaUsuariosSistema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUsuarioSistema method, of class Controlador.
     */
    @Test
    public void testGetIdUsuarioSistema() {
        System.out.println("getIdUsuarioSistema");
        String dni = "";
        Controlador instance = new Controlador();
        String expResult = "";
        String result = instance.getIdUsuarioSistema(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaFotosPerfilSistema method, of class Controlador.
     */
    @Test
    public void testGetListaFotosPerfilSistema() {
        System.out.println("getListaFotosPerfilSistema");
        Controlador instance = new Controlador();
        ArrayList<FotoPerfil> expResult = null;
        ArrayList<FotoPerfil> result = instance.getListaFotosPerfilSistema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaRutasSistema method, of class Controlador.
     */
    @Test
    public void testGetListaRutasSistema() {
        System.out.println("getListaRutasSistema");
        Controlador instance = new Controlador();
        ArrayList<Ruta> expResult = null;
        ArrayList<Ruta> result = instance.getListaRutasSistema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIDrutaSistema method, of class Controlador.
     */
    @Test
    public void testGetIDrutaSistema() {
        System.out.println("getIDrutaSistema");
        String nombreRuta = "";
        String IDcreadorRuta = "";
        Controlador instance = new Controlador();
        String expResult = "";
        String result = instance.getIDrutaSistema(nombreRuta, IDcreadorRuta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaValoracionesSistema method, of class Controlador.
     */
    @Test
    public void testGetListaValoracionesSistema() {
        System.out.println("getListaValoracionesSistema");
        Controlador instance = new Controlador();
        ArrayList<Valoracion> expResult = null;
        ArrayList<Valoracion> result = instance.getListaValoracionesSistema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newInstance method, of class Controlador.
     */
    @Test
    public void testNewInstance() {
        System.out.println("newInstance");
        Controlador expResult = null;
        Controlador result = Controlador.newInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarFormatoDNICorrecto method, of class Controlador.
     */
    @Test
    public void testComprobarFormatoDNICorrecto() {
        System.out.println("comprobarFormatoDNICorrecto");
        String dni = "";
        Controlador instance = new Controlador();
        boolean expResult = false;
        boolean result = instance.comprobarFormatoDNICorrecto(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniadirCategoria method, of class Controlador.
     */
    @Test
    public void testAniadirCategoria() {
        System.out.println("aniadirCategoria");
        String nombreCategoria = "";
        Controlador instance = new Controlador();
        instance.aniadirCategoria(nombreCategoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarCategoria method, of class Controlador.
     */
    @Test
    public void testBorrarCategoria() {
        System.out.println("borrarCategoria");
        String IDcategoriaEliminada = "";
        Controlador instance = new Controlador();
        instance.borrarCategoria(IDcategoriaEliminada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniadirUsuario method, of class Controlador.
     */
    @Test
    public void testAniadirUsuario() {
        System.out.println("aniadirUsuario");
        String DNI = "";
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        String correo = "";
        String contrasenia = "";
        Controlador instance = new Controlador();
        instance.aniadirUsuario(DNI, nombre, apellido1, apellido2, correo, contrasenia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarUsuario method, of class Controlador.
     */
    @Test
    public void testModificarUsuario() {
        System.out.println("modificarUsuario");
        String DNI = "";
        String apellido1 = "";
        String apellido2 = "";
        String correo = "";
        String contrasenia = "";
        Controlador instance = new Controlador();
        instance.modificarUsuario(DNI, apellido1, apellido2, correo, contrasenia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarUsuario method, of class Controlador.
     */
    @Test
    public void testBorrarUsuario() {
        System.out.println("borrarUsuario");
        String dni = "";
        Controlador instance = new Controlador();
        instance.borrarUsuario(dni);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniadirRuta method, of class Controlador.
     */
    @Test
    public void testAniadirRuta() {
        System.out.println("aniadirRuta");
        String nombreRuta = "";
        String descripcion = "";
        double distanciaKm = 0.0;
        double tiempoHoras = 0.0;
        String dificultad = "";
        String DNIcreadorRuta = "";
        Controlador instance = new Controlador();
        instance.aniadirRuta(nombreRuta, descripcion, distanciaKm, tiempoHoras, dificultad, DNIcreadorRuta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarRuta method, of class Controlador.
     */
    @Test
    public void testBorrarRuta() {
        System.out.println("borrarRuta");
        String nombreRutaEliminada = "";
        String dniCreadorRutaEliminada = "";
        Controlador instance = new Controlador();
        instance.borrarRuta(nombreRutaEliminada, dniCreadorRutaEliminada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarRuta method, of class Controlador.
     */
    @Test
    public void testModificarRuta() {
        System.out.println("modificarRuta");
        String nombreRuta = "";
        String descripcion = "";
        String dificultad = "";
        String dniCreador = "";
        Controlador instance = new Controlador();
        instance.modificarRuta(nombreRuta, descripcion, dificultad, dniCreador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniadirValoracion method, of class Controlador.
     */
    @Test
    public void testAniadirValoracion() {
        System.out.println("aniadirValoracion");
        Ruta ruta = null;
        String dniUsuario = "";
        Integer puntuacion = null;
        String comentario = "";
        Controlador instance = new Controlador();
        instance.aniadirValoracion(ruta, dniUsuario, puntuacion, comentario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarValoracion method, of class Controlador.
     */
    @Test
    public void testBorrarValoracion() {
        System.out.println("borrarValoracion");
        String nombreRuta = "";
        String usuario = "";
        Controlador instance = new Controlador();
        instance.borrarValoracion(nombreRuta, usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarValoracion method, of class Controlador.
     */
    @Test
    public void testModificarValoracion() {
        System.out.println("modificarValoracion");
        Ruta rutaValorada = null;
        String dniUsuario = "";
        Integer puntuacion = null;
        String comentario = "";
        Controlador instance = new Controlador();
        instance.modificarValoracion(rutaValorada, dniUsuario, puntuacion, comentario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aniadirFotoPerfil method, of class Controlador.
     */
    @Test
    public void testAniadirFotoPerfil() {
        System.out.println("aniadirFotoPerfil");
        String dniUsuario = "";
        String nombreImagen = "";
        Integer resolucionImagenMp = null;
        Integer tamanioKb = null;
        Controlador instance = new Controlador();
        instance.aniadirFotoPerfil(dniUsuario, nombreImagen, resolucionImagenMp, tamanioKb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarFotoPerfil method, of class Controlador.
     */
    @Test
    public void testModificarFotoPerfil() {
        System.out.println("modificarFotoPerfil");
        String dniUsuario = "";
        String nombreImagen = "";
        Integer resolucionImagenMp = null;
        Integer tamanioKb = null;
        Controlador instance = new Controlador();
        instance.modificarFotoPerfil(dniUsuario, nombreImagen, resolucionImagenMp, tamanioKb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarFotoPerfil method, of class Controlador.
     */
    @Test
    public void testBorrarFotoPerfil() {
        System.out.println("borrarFotoPerfil");
        String idFotoEliminada = "";
        Controlador instance = new Controlador();
        instance.borrarFotoPerfil(idFotoEliminada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarRutaDeCategoria method, of class Controlador.
     */
    @Test
    public void testEliminarRutaDeCategoria() {
        System.out.println("eliminarRutaDeCategoria");
        String idRuta = "";
        String idCategoria = "";
        Controlador instance = new Controlador();
        instance.eliminarRutaDeCategoria(idRuta, idCategoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializarCategoria method, of class Controlador.
     */
    @Test
    public void testSerializarCategoria() {
        System.out.println("serializarCategoria");
        Controlador instance = new Controlador();
        instance.serializarCategoria();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserializarCategoria method, of class Controlador.
     */
    @Test
    public void testDeserializarCategoria() {
        System.out.println("deserializarCategoria");
        Controlador instance = new Controlador();
        instance.deserializarCategoria();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializarFotoPerfil method, of class Controlador.
     */
    @Test
    public void testSerializarFotoPerfil() {
        System.out.println("serializarFotoPerfil");
        Controlador instance = new Controlador();
        instance.serializarFotoPerfil();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserializarFotoPerfil method, of class Controlador.
     */
    @Test
    public void testDeserializarFotoPerfil() {
        System.out.println("deserializarFotoPerfil");
        Controlador instance = new Controlador();
        instance.deserializarFotoPerfil();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializarRuta method, of class Controlador.
     */
    @Test
    public void testSerializarRuta() {
        System.out.println("serializarRuta");
        Controlador instance = new Controlador();
        instance.serializarRuta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserializarRuta method, of class Controlador.
     */
    @Test
    public void testDeserializarRuta() {
        System.out.println("deserializarRuta");
        Controlador instance = new Controlador();
        instance.deserializarRuta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializarUsuario method, of class Controlador.
     */
    @Test
    public void testSerializarUsuario() {
        System.out.println("serializarUsuario");
        Controlador instance = new Controlador();
        instance.serializarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserializarUsuario method, of class Controlador.
     */
    @Test
    public void testDeserializarUsuario() {
        System.out.println("deserializarUsuario");
        Controlador instance = new Controlador();
        instance.deserializarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serializarValoracion method, of class Controlador.
     */
    @Test
    public void testSerializarValoracion() {
        System.out.println("serializarValoracion");
        Controlador instance = new Controlador();
        instance.serializarValoracion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserializarValoracion method, of class Controlador.
     */
    @Test
    public void testDeserializarValoracion() {
        System.out.println("deserializarValoracion");
        Controlador instance = new Controlador();
        instance.deserializarValoracion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
