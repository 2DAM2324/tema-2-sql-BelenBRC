//Belén Robustillo Carmona

package Modelo;

import java.io.Serializable;

/**
 * Clase FotoPerfil con atributos:
 * ID_foto              Código identificador de la fotografía
 * nombre_imagen        Nombre del archivo de imagen
 * resolucionImagenMp   Resolución de la imagen en megapíxeles
 * tamanioKb            Tamaño de la imagen en kilobytes
 * usuario              Usuario al que pertenece la foto de perfil
 * @author belen
 */
public class FotoPerfil implements Serializable{
    private Integer ID_foto;     
    private String nombre_imagen;
    private Integer resolucionImagenMp;
    private Integer tamanioKb;
    private Usuario usuario;
    
    //Constructor
    /**
     * @brief   Constructor de un objeto de la clase FotoPerfil con parámetros
     * @param nombre            Nombre del archivo de imagen
     * @param resolucionMp      Resolución de la imagen en megapíxeles
     * @param tamanioKb         Tamaño de la imagen en kilobytes
     * @param usuario           Usuario al que pertenece la foto de perfil
     * @post    El ID será null
     */
    public FotoPerfil(String nombre, Integer resolucionMp, Integer tamanioKb, Usuario usuario){
        setNombreImagen(nombre);
        setResolucionImagenMp(resolucionMp);
        setTamanioKb(tamanioKb);
        setUsuario(usuario);
        setIDfoto(null);
        if(getUsuario().getFotoPerfil() == null){
            getUsuario().setFotoPerfil(this);
        }
    }

    /**
     * @brief   Constructor de un objeto de la clase FotoPerfil con parámetros y con ID, sin usuario
     * @param id                Código identificador de la fotografía
     * @param nombre            Nombre del archivo de imagen
     * @param resolucionMp      Resolución de la imagen en megapíxeles
     * @param tamanioKb         Tamaño de la imagen en kilobytes
     * @post    El usuario será null
     */
    public FotoPerfil(Integer id, String nombre, Integer resolucionMp, Integer tamanioKb){
        setIDfoto(id);
        setNombreImagen(nombre);
        setResolucionImagenMp(resolucionMp);
        setTamanioKb(tamanioKb);
        
        setUsuario(null);
    }

    //Sets y gets
    /**
     * @brief   Método que establece el código identificador de la fotografía
     * @param id    código identificador de la fotografía
     */
    private void setIDfoto(Integer id){
        this.ID_foto = id;
    }
    
    /**
     * @brief   Método que establece el nombre del archivo de imagen
     * @param nombre    Nombre del archivo de imagen
     */
    public void setNombreImagen(String nombre){
        this.nombre_imagen = nombre;
    }
    
    /**
     * @brief   Método que establece la resolución de la imagen en megapíxeles
     * @param resolucionMp    Resolución de la imagen en megapíxeles
     */
    public void setResolucionImagenMp(Integer resolucionMp){
        this.resolucionImagenMp = resolucionMp;
    }
    
    /**
     * @brief   Método que establece el tamaño de la imagen en kilobytes
     * @param tamanioKb   Tamaño de la imagen en kilobytes
     */
    public void setTamanioKb(Integer tamanioKb){
        this.tamanioKb = tamanioKb;
    }

    /**
     * @brief   Método que establece el código identificador único del usuario al que pertenece la foto de perfil
     * @param usuario    Usuario al que pertenece la foto de perfil
     */
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    /**
     * @brief   Método que devuelve el código identificador de la fotografía
     * @return  ID_foto     (Integer)    código identificador de la fotografía
     */
    public Integer getIDfoto(){
        return this.ID_foto;
    }
    
    /**
     * @brief   Método que devuelve el nombre del archivo de imagen
     * @return  nombre_imagen   (String)    Nombre del archivo de imagen
     */
    public String getNombreImagen(){
        return this.nombre_imagen;
    }
    
    /**
     * @brief   Método que devuelve la resolución de la imagen en megapíxeles
     * @return  resolucionImagenMp   (Integer)   Resolución de la imagen en megapíxeles
     */
    public Integer getResolucionImagenMp(){
        return this.resolucionImagenMp;
    }
    
    /**
     * @brief   Método que devuelve el tamaño de la imagen en kilobytes
     * @return  tamanioKb   (Integer)   Tamaño de la imagen en kilobytes
     */
    public Integer getTamanioKb(){
        return this.tamanioKb;
    }

    /**
     * @brief   Método que devuelve el código identificador único del usuario al que pertenece la foto de perfil
     * @return  usuario  (Usuario)    Usuario al que pertenece la foto de perfil
     */
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    //Métodos públicos
    /**
     * @brief   Método que permite imprimir nombre, resolución y tamaño de una foto de perfil pasando un objeto 
     *                  de la clase Usuario al método System.out.print o printline.
     * @return  (String)    Nombre, resolución y tamaño de la foto de perfil
     */
    @Override
    public String toString(){
        return getNombreImagen() + "\t" + getResolucionImagenMp() + " Mp\t" + getTamanioKb() + " kb";
    }
}
