//Belén Robustillo Carmona

package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Controlador.Controlador;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author belen
 */
public class FotoPerfilTest {
    Controlador controlador;
    Usuario usuario;
    FotoPerfil instance;
    
    public FotoPerfilTest() {
        //Cargar datos de prueba de la base de datos
        controlador = Controlador.newInstance();
        controlador.deserializarCategoria();
        controlador.deserializarUsuario();
        controlador.deserializarRuta();
        controlador.deserializarValoracion();
        controlador.deserializarFotoPerfil();

        usuario = new Usuario("Usuario", "Prueba", "Foto perfil", "fepnf@`koadnf.com", "1234", "07257650T");

        instance = new FotoPerfil("Foto Prueba", 1, 1, usuario);
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
}
