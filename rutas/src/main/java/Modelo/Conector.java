package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    private static Conector instancia = null;
    private String          url;
    private Connection      conexion;
    private String          nombreTabla;

    /**
     * @brief Constructor de la clase Conector con la url por defecto
     * @post  Conexión con url por defecto 
     */
    private Conector(){
        setUrl("C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\rutas.db");
    }

    /**
     * @brief Constructor de la clase Conector con parámetros
     * @param url           (String)    Url de la base de datos
     */
    private Conector(String url){
        setUrl(url);
    }

    //Sets y gets

    /**
     * @brief Establece la url de la base de datos
     * @param url   (String)    Url de la base de datos
     */
    private void setUrl(String url) {
        this.url = url;
    }

    /**
     * @brief Establece la conexión con la base de datos
     * @param conexion  (Connection)    Conexión con la base de datos
     */
    private void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * @brief Establece el nombre de la tabla de la base de datos
     * @param nombreTabla   (String)    Nombre de la tabla de la base de datos
     */
    private void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @brief Devuelve la url de la base de datos
     * @return url  (String)    Url de la base de datos
     */
    private String getUrl() {
        return url;
    }

    /**
     * @brief Devuelve la conexión con la base de datos
     * @return conexion  (Connection)    Conexión con la base de datos
     */
    private Connection getConexion() {
        return conexion;
    }

    /**
     * @brief Devuelve el nombre de la tabla de la base de datos
     * @return nombreTabla  (String)    Nombre de la tabla de la base de datos
     */
    private String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @brief   Método que devuelve la instancia de la clase Conector con la url por defecto
     * @return  (Conector)  Instancia de la clase Conector
     */
    public static Conector newInstance(){
        if(instancia == null){
            instancia = new Conector();
        }
        return instancia;
    }

    /**
     * @brief   Método que devuelve la instancia de la clase Conector con parámetros
     * @param url   (String)    Url de la base de datos
     * @return  (Conector)  Instancia de la clase Conector
     */
    public static Conector newInstance(String url){
        if(instancia == null){
            instancia = new Conector(url);
        }
        return instancia;
    }

    //Métodos
    /**
     * @brief   Método que establece la conexión con la base de datos
     * @pre     La base de datos debe existir
     * @post    Conexión con la base de datos
     * @post    Si la conexión falla, se asegura de cerrar la conexión si se ha abierto
     */
    public void conectar(){
        try{
            String url = "jdbc:sqlite:" + getUrl();
            setConexion(DriverManager.getConnection(url));
            //TODO eliminar debug
            System.out.println("Conexión establecida");
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(getConexion() != null){
                    getConexion().close();
                }
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
        }
    }

    /**
     * @brief   Método que cierra la conexión con la base de datos
     * @pre     La conexión debe estar abierta
     * @post    Conexión cerrada
     */
    public void desconectar(){
        try{
            getConexion().close();
            setConexion(null);
            //TODO eliminar debug
            System.out.println("Conexión cerrada");
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
