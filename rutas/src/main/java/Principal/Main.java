//Belén Robustillo Carmona

package Principal;

import Vista.Ventana1;
import java.io.IOException;

import org.xml.sax.SAXException;

/**
 *
 * @author belen
 */
public class Main {

    public static void main(String[] args) {
       Ventana1 ventana;
        try{
                ventana = new Ventana1();
                ventana.setVisible(true);
        }   
        catch(IOException | ClassNotFoundException | SAXException ex){
        }
    }
}