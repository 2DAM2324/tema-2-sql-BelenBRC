//Belén Robustillo Carmona

package Principal;

import Vista.Ventana1;
import java.io.IOException;

import org.xml.sax.SAXException;

import Controlador.Controlador;
import Modelo.Conector;
/**
 *
 * @author belen
 */
public class Main {

    public static void main(String[] args) {

        Controlador controlador = Controlador.newInstance();

        controlador.deserializarCategoria();
        controlador.deserializarUsuario();
        controlador.deserializarRuta();
        controlador.deserializarValoracion();
        controlador.deserializarFotoPerfil();


        controlador.getConector().conectar();

       Ventana1 ventana;
        try{
                ventana = new Ventana1();
                ventana.setVisible(true);
        }   
        catch(IOException | ClassNotFoundException | SAXException ex){
        }

        controlador.getConector().printCategoriasDB();

        controlador.getConector().desconectar();
    }
}
