//Belén Robustillo Carmona

package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Categoria con atributos:
 * ID_categoria             Código identificador único para cada categoría
 * nombre_categoria         Nombre de la categoría
 * listaRutas               Lista de rutas que pertenecen a la categoría
 * @author belen
 */
public class Categoria implements Serializable{
    private Integer ID_categoria;        
    private String nombre_categoria;
    private ArrayList<Ruta> listaRutas;

    //Constructor
    /**
     * @brief   Constructor de un objeto de la clase Categoria con parámetros, sin rutas asignadas
     * @param nombre    Nombre de la categoría
     * @post    El ID será null
     *          La lista de rutas estará vacía
     */
    public Categoria(String nombre){
        setNombreCategoria(nombre);
        setIDCategoria(null);
        setListaRutas(new ArrayList<Ruta>());
    }

    /**
     * @brief   Constructor de un objeto de la clase Categoria con parámetros, sin rutas asignadas
     * @param nombre    Nombre de la categoría
     * @param id        Código identificador único de la categoría
     * @post    La lista de rutas estará vacía
     */
    public Categoria(String nombre, Integer id){
        setNombreCategoria(nombre);
        setIDCategoria(id);
        setListaRutas(new ArrayList<Ruta>());
    }

    //Sets y gets
    /**
     * @brief   Método que establece el código identificador único de la categoría
     * @param id    Código identificador único de la categoría
     */
    public void setIDCategoria(Integer id){
        this.ID_categoria = id;
    }

    /**
     * @brief   Método que establece el nombre de la categoría
     * @param nombre    Nombre de la categoría
     */
    public void setNombreCategoria(String nombre){
        this.nombre_categoria = nombre;
    }

    /**
     * @brief   Método que establece la lista de rutas que pertenecen a la categoría
     * @param lista     Lista de rutas que pertenecen a la categoría
     */
    public void setListaRutas(ArrayList<Ruta> lista){
        this.listaRutas = lista;
    }

    /**
     * @brief   Método que añade una ruta a la lista de rutas que pertenecen a la categoría
     * @param ruta     Ruta que pertenece a la categoría
     */
    public void setRutaEnLista(Ruta ruta){
        //Comprobar que no exista ya la ruta en la lista
        boolean existe = false;

        for(Ruta r : getListaRutas()){
            if(r.getIdRuta().equals(ruta.getIdRuta())){
                existe = true;
            }
        }

        if(!existe){
            getListaRutas().add(ruta);
        }
    }

    /**
     * @brief   Método que devuelve el código identificador único de la categoría
     * @return  ID_categoria    (Integer)    Código identificador único de la categoría
     */
    public Integer getIDCategoria(){
        return this.ID_categoria;
    }

    /**
     * @brief   Método que devuelve el nombre de la categoría
     * @return  nombre_categoria    (String)    Nombre de la categoría
     */
    public String getNombreCategoria(){
        return this.nombre_categoria;
    }

    /**
     * @brief   Método que devuelve la lista de rutas que pertenecen a la categoría
     * @return  listaRutas     (ArrayList<Ruta>)    Lista de rutas que pertenecen a la categoría
     */
    public ArrayList<Ruta> getListaRutas(){
        return this.listaRutas;
    }
}