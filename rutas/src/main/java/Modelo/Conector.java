package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conector {
    private static Conector instancia = null;
    private String          url;
    private Connection      conexion;
    private String          nombreTabla;

    private static final String NOMBRE_TABLA_CATEGORIA = "categoria";
    private static final String NOMBRE_TABLA_CLASIFICACION = "clasificacion";
    private static final String NOMBRE_TABLA_FOTO_PERFIL = "foto_perfil";
    private static final String NOMBRE_TABLA_RUTA = "ruta";
    private static final String NOMBRE_TABLA_USUARIO = "usuario";
    private static final String NOMBRE_TABLA_VALORACION = "valoracion";

    private ArrayList<Categoria>        listaCategorias;
    private ArrayList<FotoPerfil>       listaFotosPerfil;
    private ArrayList<Ruta>             listaRutas;
    private ArrayList<Usuario>          listaUsuarios;
    private ArrayList<Valoracion>       listaValoraciones;

    /**
     * @brief Constructor de la clase Conector con la url por defecto
     * @post  Conexión con url por defecto 
     */
    private Conector(){
        setUrl("C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\rutas.db");
        
        setListaCategorias(new ArrayList<Categoria>());
        setListaFotosPerfil(new ArrayList<FotoPerfil>());
        setListaRutas(new ArrayList<Ruta>());
        setListaUsuarios(new ArrayList<Usuario>());
        setListaValoraciones(new ArrayList<Valoracion>());
    }

    /**
     * @brief Constructor de la clase Conector con parámetros
     * @param url           (String)    Url de la base de datos
     */
    private Conector(String url){
        setUrl(url);

        setListaCategorias(new ArrayList<Categoria>());
        setListaFotosPerfil(new ArrayList<FotoPerfil>());
        setListaRutas(new ArrayList<Ruta>());
        setListaUsuarios(new ArrayList<Usuario>());
        setListaValoraciones(new ArrayList<Valoracion>());
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
     * @brief Establece la lista de categorías de la base de datos
     * @param listaCategorias   (ArrayList<Categoria>)    Lista de categorías
     */
    private void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    /**
     * @brief Establece la lista de fotos de perfil de la base de datos
     * @param listaFotosPerfil  (ArrayList<FotoPerfil>)   Lista de fotos de perfil
     */
    private void setListaFotosPerfil(ArrayList<FotoPerfil> listaFotosPerfil) {
        this.listaFotosPerfil = listaFotosPerfil;
    }

    /**
     * @brief Establece la lista de rutas de la base de datos
     * @param listaRutas    (ArrayList<Ruta>)   Lista de rutas
     */
    private void setListaRutas(ArrayList<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }

    /**
     * @brief Establece la lista de usuarios de la base de datos
     * @param listaUsuarios (ArrayList<Usuario>) Lista de usuarios
     */
    private void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * @brief Establece la lista de valoraciones de la base de datos
     * @param listaValoraciones (ArrayList<Valoracion>) Lista de valoraciones
     */
    private void setListaValoraciones(ArrayList<Valoracion> listaValoraciones) {
        this.listaValoraciones = listaValoraciones;
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
     * @brief Devuelve la lista de categorías de la base de datos
     * @return (ArrayList<Categoria>)    Lista de categorías
     */
    private ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    /**
     * @brief Devuelve la lista de fotos de perfil de la base de datos
     * @return (ArrayList<FotoPerfil>)   Lista de fotos de perfil
     */
    private ArrayList<FotoPerfil> getListaFotosPerfil() {
        return listaFotosPerfil;
    }

    /**
     * @brief Devuelve la lista de rutas de la base de datos
     * @return (ArrayList<Ruta>)   Lista de rutas
     */
    private ArrayList<Ruta> getListaRutas() {
        return listaRutas;
    }

    /**
     * @brief Devuelve la lista de usuarios de la base de datos
     * @return (ArrayList<Usuario>) Lista de usuarios
     */
    private ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @brief Devuelve la lista de valoraciones de la base de datos
     * @return (ArrayList<Valoracion>) Lista de valoraciones
     */
    private ArrayList<Valoracion> getListaValoraciones() {
        return listaValoraciones;
    }


    //*********************************************************//

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
        if(getConexion() == null){
            try{
                setConexion(DriverManager.getConnection("jdbc:sqlite:" + getUrl()));
            }
            catch(SQLException sqle){
                sqle.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
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


    
    public void printCategoriasDB(){
        setNombreTabla(NOMBRE_TABLA_CATEGORIA);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try{

            sentencia = getConexion().prepareStatement(sql);
            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                System.out.println("id:\t" + resultado.getString("id_categoria"));
                System.out.println("nombre:\t" + resultado.getString("nombre")); 
            }

        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        finally{
            if(sentencia != null){
                try{
                    if(resultado != null){
                        resultado.close();
                    }
                    if(sentencia != null){
                        sentencia.close();
                    }
                }
                catch(SQLException sqle){
                    sqle.printStackTrace();
                }
            }
        }
    }
}
