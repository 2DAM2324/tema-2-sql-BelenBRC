package Modelo;

import java.sql.Connection;

public class Conector {
    private String usuario;
    private String contrasenia;
    private String url;
    private Connection conexion;
    private String nombreTabla;

    /**
     * @brief Constructor de la clase Conector con el usuario por defecto
     * @post  Conexión con usuario por defecto: 
     */
    public Conector(){
        setUsuario("");
        setContrasenia("");
        setUrl("");
    }

    /**
     * @brief Constructor de la clase Conector con parámetros
     * @param usuario       (String)    Usuario de la base de datos
     * @param contrasenia   (String)    Contraseña de la base de datos
     * @param url           (String)    Url de la base de datos
     */
    public Conector(String usuario, String contrasenia, String url){
        setUsuario(usuario);
        setContrasenia(contrasenia);
        setUrl(url);
    }

    //Sets y gets
    /**
     * @brief Establece el usuario de la base de datos
     * @param usuario   (String)    Usuario de la base de datos
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @brief Establece la contraseña de la base de datos
     * @param contrasenia   (String)    Contraseña de la base de datos
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @brief Establece la url de la base de datos
     * @param url   (String)    Url de la base de datos
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @brief Establece la conexión con la base de datos
     * @param conexion  (Connection)    Conexión con la base de datos
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * @brief Establece el nombre de la tabla de la base de datos
     * @param nombreTabla   (String)    Nombre de la tabla de la base de datos
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @brief Devuelve el usuario de la base de datos
     * @return usuario  (String)    Usuario de la base de datos
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @brief Devuelve la contraseña de la base de datos
     * @return contrasenia  (String)    Contraseña de la base de datos
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @brief Devuelve la url de la base de datos
     * @return url  (String)    Url de la base de datos
     */
    public String getUrl() {
        return url;
    }

    /**
     * @brief Devuelve la conexión con la base de datos
     * @return conexion  (Connection)    Conexión con la base de datos
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @brief Devuelve el nombre de la tabla de la base de datos
     * @return nombreTabla  (String)    Nombre de la tabla de la base de datos
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    
}
