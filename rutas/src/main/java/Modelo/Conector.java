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


    /**
     * @brief   Método que lee las categorías de la base de datos y las almacena en una lista de categorías
     * @return  (ArrayList<Categoria>)    Lista de categorías de la base de datos
     * @post    La lista de categorías estará inicializada con las categorías de la base de datos
     * @post    Si la conexión falla, se asegura de cerrar la conexión si se ha abierto
     *          y devuelve una lista vacía
     */
    public ArrayList<Categoria> getCategoriasDB(){
        setNombreTabla(NOMBRE_TABLA_CATEGORIA);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        getListaCategorias().clear();

        try{

            sentencia = getConexion().prepareStatement(sql);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt("id_categoria");
                String nombre = resultado.getString("nombre");

                ArrayList<Ruta> listaRutas = getRutasCategoria(id);
                
                Categoria categoria = new Categoria(nombre, id, listaRutas);
                getListaCategorias().add(categoria);
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

        return getListaCategorias();
    }

    /**
     * @brief   Método que lee las fotos de perfil de la base de datos y las almacena en una lista de fotos de perfil
     * @return  (ArrayList<FotoPerfil>)   Lista de fotos de perfil de la base de datos
     * @post    La lista de fotos de perfil estará inicializada con las fotos de perfil de la base de datos
     * @post    Si la conexión falla, se asegura de cerrar la conexión si se ha abierto
     *          y devuelve una lista vacía
     */
    public ArrayList<Ruta> getRutasCategoria(Integer idCategoria){
        setNombreTabla(NOMBRE_TABLA_CLASIFICACION);
        ArrayList<Ruta> listaRutas = new ArrayList<Ruta>();

        String sql = "SELECT * FROM " + getNombreTabla() + " WHERE id_categoria = " + idCategoria;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;        

        try{
            sentencia = getConexion().prepareStatement(sql);
            resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Integer idRuta = resultado.getInt("id_ruta");
                Ruta ruta = getRutaPorID(idRuta);
                listaRutas.add(ruta);                
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

        return listaRutas;
    }

    /**
     * @brief   Método que busca una ruta por su id
     * @param idRuta    (Integer)   Código identificador único de la ruta
     * @return  (Ruta)  Ruta con el id pasado por parámetro, con su usuario asignado 
     * @post    Si la conexión falla, se asegura de cerrar la conexión si se ha abierto
     *          y devuelve null
     * @post    Si no se encuentra la ruta, devuelve null
     * @post    NO ESTÁN ASIGNADAS LAS VALORACIONES NI LAS CATEGORIAS //TODO
     */
    public Ruta getRutaPorID(Integer idRuta){
        setNombreTabla(NOMBRE_TABLA_RUTA);
        String sql = "SELECT * FROM " + getNombreTabla() + " WHERE id_ruta = " + idRuta;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Ruta ruta = null;

        try{
            sentencia = getConexion().prepareStatement(sql);
            resultado = sentencia.executeQuery();

            Integer id = resultado.getInt("id_ruta");
            String nombre = resultado.getString("nombre_ruta");
            String descripcion = resultado.getString("descripcion");
            Double distanciaKm = resultado.getDouble("distancia_km");
            String dificultad = resultado.getString("dificultad");
            Double tiempoH = resultado.getDouble("tiempo_h");
            Double puntuacionMedia = resultado.getDouble("puntuacion_media");
            Integer idUsuario = resultado.getInt("id_usuario");

            Usuario usuario = getUsuarioPorID(idUsuario);

            ruta = new Ruta(id, nombre, descripcion, distanciaKm, dificultad, tiempoH, puntuacionMedia, usuario);
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

        return ruta;
    }

    /**
     * @brief   Método que busca un usuario por su id
     * @param idUsuario (Integer)   Código identificador único del usuario
     * @return  (Usuario)   Usuario con el id pasado por parámetro, con su foto de perfil asignada si la tiene
     * @post    Si la conexión falla, se asegura de cerrar la conexión si se ha abierto
     *          y devuelve null
     * @post    Si no se encuentra el usuario, devuelve null
     * @post    NO ESTÁN ASIGNADAS LAS RUTAS NI LAS VALORACIONES //TODO
     */
    public Usuario getUsuarioPorID(Integer idUsuario){
        setNombreTabla(NOMBRE_TABLA_USUARIO);
        String sql = "SELECT * FROM " + getNombreTabla() + " WHERE id_usuario = " + idUsuario;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        Usuario usuario = null;

        try{
            sentencia = getConexion().prepareStatement(sql);
            resultado = sentencia.executeQuery();

            Integer id = resultado.getInt("id_usuario");
            String nombre = resultado.getString("nombre");
            String apellido1 = resultado.getString("apellido1");
            String apellido2 = resultado.getString("apellido2");
            String email = resultado.getString("email");
            String contrasena = resultado.getString("password");
            String dni = resultado.getString("dni");
            Integer idFotoPerfil = resultado.getInt("id_foto_perfil");
            System.out.println("idFotoPerfil: " + idFotoPerfil);

            usuario = new Usuario(id, nombre, apellido1, apellido2, email, contrasena, dni);

            if(idFotoPerfil != 0){
                FotoPerfil fotoPerfil = getFotoPerfilPorID(idFotoPerfil);
                fotoPerfil.setUsuario(usuario);
                usuario.setFotoPerfil(fotoPerfil);
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

        return usuario;
    }

    /**
     * @brief   Método que busca una foto de perfil por su id
     * @param idFotoPerfil  (Integer)   Código identificador único de la foto de perfil
     * @return  (FotoPerfil)    Foto de perfil con el id pasado por parámetro, SIN USUARIO ASIGNADO
     * @post    Si la conexión falla, se asegura de cerrar la conexión si se ha abierto
     *          y devuelve null
     * @post    Si no se encuentra la foto de perfil, devuelve null
     * @post    Se debe asignar el usuario a la foto de perfil
     */
    public FotoPerfil getFotoPerfilPorID(Integer idFotoPerfil){
        setNombreTabla(NOMBRE_TABLA_FOTO_PERFIL);
        String sql = "SELECT * FROM " + getNombreTabla() + " WHERE id_foto_perfil = " + idFotoPerfil;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        FotoPerfil fotoPerfil = null;

        try{
            sentencia = getConexion().prepareStatement(sql);
            resultado = sentencia.executeQuery();

            Integer id = resultado.getInt("id_foto_perfil");
            String nombre = resultado.getString("nombre_foto");
            Integer resolucionMp = resultado.getInt("resolucion_mpx");
            Integer tamanioKb = resultado.getInt("tamanio_kb");

            fotoPerfil = new FotoPerfil(id, nombre, resolucionMp, tamanioKb);

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

        return fotoPerfil;
    }
}
