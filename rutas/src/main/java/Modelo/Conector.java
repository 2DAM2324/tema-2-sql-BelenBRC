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
     * @throws SQLException     Excepción de SQL
     * @throws Exception        Excepción general
     */
    public void conectar() throws SQLException, Exception{
        if(getConexion() == null){
            setConexion(DriverManager.getConnection("jdbc:sqlite:" + getUrl()));
        }
    }

    /**
     * @brief   Método que cierra la conexión con la base de datos
     * @pre     La conexión debe estar abierta
     * @post    Conexión cerrada
     * @throws SQLException     Excepción de SQL
     * @throws Exception        Excepción general
     */
    public void desconectar() throws SQLException, Exception{
        getConexion().close();
        setConexion(null);
    }

    /**
     * @brief   Método que cierra una sentencia de la base de datos si está abierta
     * @param sentencia         (PreparedStatement)     Sentencia de la base de datos
     * @throws SQLException     Excepción de SQL
     * @throws Exception        Excepción general
     */
    private void cerrarSentencia(PreparedStatement sentencia) throws SQLException, Exception{
        if(sentencia != null){
            sentencia.close();
        }
    }

    /**
     * @brief   Método que cierra un resultado de la base de datos si está abierto
     * @param resultado         (ResultSet)     Resultado de la base de datos
     * @throws SQLException     Excepción de SQL
     * @throws Exception        Excepción general
     */
    private void cerrarResultado(ResultSet resultado) throws SQLException, Exception{
        if(resultado != null){
            resultado.close();
        }
    }

    //*********************************************************//
    //*********************** READ ***************************//

    /**
     * @brief   Método que obtiene toda la información de la base de datos
     * @post    Los elementos de las listas de categorías, fotos de perfil, rutas, usuarios y valoraciones tendrán todos los datos de la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void bajarBaseDatos() throws SQLException, Exception{
        getFotosPerfilBaseDatos();
        getUsuariosBaseDatos();
        getRutasBaseDatos();
        getCategoriasBaseDatos();
        vincularCategoriasConRutas();
        getValoracionesBaseDatos();
    }

    /**
     * @brief   Método que obtiene todas las fotos de perfil de la base de datos sin usuario
     * @post    Los elementos de la lista de fotos de perfil no tendrán asignado el usuario
     *          Se debe invocar seguidamente el método getUsuariosBaseDatos() para asignar el usuario
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void getFotosPerfilBaseDatos() throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_FOTO_PERFIL);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        getListaFotosPerfil().clear();

        sentencia = getConexion().prepareStatement(sql);
        resultado = sentencia.executeQuery();

        while (resultado.next()) {
            Integer id = resultado.getInt("id_foto_perfil");
            String nombre = resultado.getString("nombre_foto");
            Integer resolucionMp = resultado.getInt("resolucion_mpx");
            Integer tamanioKb = resultado.getInt("tamanio_kb");

            FotoPerfil fotoPerfil = new FotoPerfil(id, nombre, resolucionMp, tamanioKb);
            getListaFotosPerfil().add(fotoPerfil);
        }
        cerrarResultado(resultado);
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que obtiene todos los usuarios de la base de datos con foto de perfil si la tiene, sin listas
     * @post    Los elementos de la lista de fotos de perfil tendrán asignado el usuario
     * @post    Los elementos de la lista de usuarios no tendrán asignadas las rutas ni las valoraciones
     *          Se debe invocar seguidamente el método getRutasBaseDatos() para asignar las rutas
     *          y posteriormente el método getValoracionesBaseDatos() para asignar las valoraciones
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void getUsuariosBaseDatos() throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_USUARIO);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        getListaUsuarios().clear();

        sentencia = getConexion().prepareStatement(sql);
        resultado = sentencia.executeQuery();

        while (resultado.next()) {
            Integer id = resultado.getInt("id_usuario");
            String nombre = resultado.getString("nombre");
            String apellido1 = resultado.getString("apellido1");
            String apellido2 = resultado.getString("apellido2");
            String email = resultado.getString("email");
            String contrasena = resultado.getString("password");
            String dni = resultado.getString("dni");
            Integer idFotoPerfil = resultado.getInt("id_foto_perfil");

            Usuario usuario = new Usuario(id, nombre, apellido1, apellido2, email, contrasena, dni);

            if(idFotoPerfil != 0 && idFotoPerfil != null){
                //Vincular foto de perfil con usuario
                boolean encontrado = false;
                for(int i=0; i<getListaFotosPerfil().size() && !encontrado; i++){
                    if(getListaFotosPerfil().get(i).getIDfoto() == idFotoPerfil){
                        usuario.setFotoPerfil(getListaFotosPerfil().get(i));
                        getListaFotosPerfil().get(i).setUsuario(usuario);
                        encontrado = true;
                    }
                }
            }
            getListaUsuarios().add(usuario);
        }
        cerrarResultado(resultado);
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que obtiene todas las rutas de la base de datos, con el creador asignado, pero sin categorías ni valoraciones
     * @post    Los elementos de la lista de usuarios tendrán asignadas las rutas creadas
     * @post    Los elementos de la lista de rutas no tendrán asignadas las categorías ni las valoraciones
     *          Se debe invocar seguidamente el método getCategoriasBaseDatos() para asignar las categorías
     *          y posteriormente el método getValoracionesBaseDatos() para asignar las valoraciones
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void getRutasBaseDatos() throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_RUTA);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        getListaRutas().clear();

        sentencia = getConexion().prepareStatement(sql);
        resultado = sentencia.executeQuery();

        while (resultado.next()) {
            Integer id = resultado.getInt("id_ruta");
            String nombre = resultado.getString("nombre_ruta");
            String descripcion = resultado.getString("descripcion");
            Double distancia = resultado.getDouble("distancia_km");
            String dificultad = resultado.getString("dificultad");
            Double tiempoH = resultado.getDouble("tiempo_h");
            Double puntuacionMedia = resultado.getDouble("puntuacion_media");
            Integer idUsuario = resultado.getInt("id_usuario");
            
            Ruta ruta = null;
            Usuario usuario = null;
            //Obtener el usuario creador de la lista de usuarios
            boolean encontrado = false;
            for(int i=0; i< getListaUsuarios().size() && !encontrado; i++){
                if(getListaUsuarios().get(i).getIDUsuario() == idUsuario){
                    usuario = getListaUsuarios().get(i);
                    ruta = new Ruta(id, nombre, descripcion, distancia, dificultad, tiempoH, puntuacionMedia, usuario);
                    usuario.getListaRutas().add(ruta);
                    encontrado = true;
                }
            }

            getListaRutas().add(ruta);
        }
        cerrarResultado(resultado);
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que obtiene todas las categorías de la base de datos, sin rutas asignadas
     * @post    Los elementos de la lista de categorías no tendrán asignadas las rutas
     *          Se debe invocar seguidamente el método vincularCategoriasConRutas() para asignar las rutas
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void getCategoriasBaseDatos() throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_CATEGORIA);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        getListaCategorias().clear();
        
        sentencia = getConexion().prepareStatement(sql);
        resultado = sentencia.executeQuery();

        while(resultado.next()){
            Integer id = resultado.getInt("id_categoria");
            String nombre = resultado.getString("nombre");

            Categoria categoria = new Categoria(nombre, id);
            getListaCategorias().add(categoria);
        }
        cerrarResultado(resultado);
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que vincula las categorías y las rutas de la base de datos
     * @pre     Las categorías y las rutas deben estar en las listas correspondientes
     * @post    Los elementos de la lista de categorías tendrán asignadas las rutas
     *          Los elementos de la lista de rutas tendrán asignadas las categorías 
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void vincularCategoriasConRutas() throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_CLASIFICACION);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        sentencia = getConexion().prepareStatement(sql);
        resultado = sentencia.executeQuery();

        while(resultado.next()){
            Integer idCategoria = resultado.getInt("id_categoria");
            Integer idRuta = resultado.getInt("id_ruta");

            //Obtener la categoría de la lista de categorías
            boolean encontrado = false;
            for(int i=0; i< getListaCategorias().size() && !encontrado; i++){
                if(getListaCategorias().get(i).getIDCategoria() == idCategoria){
                    //Obtener la ruta de la lista de rutas
                    for(int j=0; j< getListaRutas().size() && !encontrado; j++){
                        if(getListaRutas().get(j).getIdRuta() == idRuta){
                            getListaCategorias().get(i).setRutaEnLista(getListaRutas().get(j));
                            getListaRutas().get(j).setCategoriaEnLista(getListaCategorias().get(i));
                            encontrado = true;
                        }
                    }
                }
            }
        }
        cerrarResultado(resultado);
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que obtiene todas las valoraciones de la base de datos, con usuario y ruta asignados
     * @pre     Los usuarios y las rutas deben estar en las listas correspondientes
     * @post    Los elementos de la lista de usuarios tendrán asignadas las valoraciones
     *          Los elementos de la lista de rutas tendrán asignadas las valoraciones
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void getValoracionesBaseDatos() throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_VALORACION);
        String sql = "SELECT * FROM " + getNombreTabla();
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        getListaValoraciones().clear();

        sentencia = getConexion().prepareStatement(sql);
        resultado = sentencia.executeQuery();

        while(resultado.next()){
            Integer idUsuario = resultado.getInt("id_usuario");
            Integer idRuta = resultado.getInt("id_ruta");
            String comentario = resultado.getString("comentario");
            Integer puntuacion = resultado.getInt("puntuacion");

            Usuario usuario = null;
            Ruta ruta = null;

            //Obtener el usuario de la lista de usuarios
            boolean encontrado = false;
            for(int i=0; i< getListaUsuarios().size() && !encontrado; i++){
                if(getListaUsuarios().get(i).getIDUsuario() == idUsuario){
                    usuario = getListaUsuarios().get(i);
                    encontrado = true;
                }
            }

            //Obtener la ruta de la lista de rutas
            encontrado = false;
            for(int i=0; i< getListaRutas().size() && !encontrado; i++){
                if(getListaRutas().get(i).getIdRuta() == idRuta){
                    ruta = getListaRutas().get(i);
                    encontrado = true;
                }
            }

            Valoracion valoracion = new Valoracion(ruta, usuario, puntuacion, comentario);
            usuario.getListaValoraciones().add(valoracion);
            ruta.getListaValoraciones().add(valoracion);

            getListaValoraciones().add(valoracion);
        }
        cerrarResultado(resultado);
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que obtiene todas las categorías de la base de datos
     * @return  (ArrayList<Categoria>)    Lista de categorías de la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public ArrayList<Categoria> getTodasLasCategorias() throws SQLException, Exception{
        bajarBaseDatos();
        return getListaCategorias();
    }

    /**
     * @brief   Método que obtiene todas las fotos de perfil de la base de datos
     * @return  (ArrayList<FotoPerfil>)   Lista de fotos de perfil de la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public ArrayList<FotoPerfil> getTodasLasFotosPerfil() throws SQLException, Exception{
        bajarBaseDatos();
        return getListaFotosPerfil();
    }

    /**
     * @brief   Método que obtiene todas las rutas de la base de datos
     * @return  (ArrayList<Ruta>)   Lista de rutas de la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public ArrayList<Ruta> getTodasLasRutas() throws SQLException, Exception{
        bajarBaseDatos();
        return getListaRutas();
    }

    /**
     * @brief   Método que obtiene todos los usuarios de la base de datos
     * @return  (ArrayList<Usuario>) Lista de usuarios de la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public ArrayList<Usuario> getTodosLosUsuarios() throws SQLException, Exception{
        bajarBaseDatos();
        return getListaUsuarios();
    }

    /**
     * @brief   Método que obtiene todas las valoraciones de la base de datos
     * @return  (ArrayList<Valoracion>) Lista de valoraciones de la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public ArrayList<Valoracion> getTodasLasValoraciones() throws SQLException, Exception{
        bajarBaseDatos();
        return getListaValoraciones();
    }

    //*********************************************************//
    //************************ CREATE *************************//

    /**
     * @brief   Método que crea una categoría en la base de datos
     * @param categoria     (Categoria)    Categoría a crear
     * @throws SQLException Excepción de SQL
     * @throws Exception    Excepción general
     */
    public void createCategoria(Categoria categoria) throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_CATEGORIA);
        String sql = "INSERT INTO " + getNombreTabla() + " (nombre) VALUES (?)";
        PreparedStatement sentencia = null;

        sentencia = getConexion().prepareStatement(sql);
        sentencia.setString(1, categoria.getNombreCategoria());
        sentencia.executeUpdate();
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que crea un usuario en la base de datos
     * @param usuario       (Usuario)   Usuario a crear
     * @throws SQLException Excepción de SQL
     * @throws Exception    Excepción general
     */
    public void createUsuario(Usuario usuario) throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_USUARIO);
        String sql = "INSERT INTO " + getNombreTabla() + " (nombre, apellido1, apellido2, email, password, dni) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = null;

        sentencia = getConexion().prepareStatement(sql);
        sentencia.setString(1, usuario.getNombreUsuario());
        sentencia.setString(2, usuario.getApellido1());
        sentencia.setString(3, usuario.getApellido2());
        sentencia.setString(4, usuario.getCorreoElectronico());
        sentencia.setString(5, usuario.getContrasenia());
        sentencia.setString(6, usuario.getDNI());

        sentencia.executeUpdate();
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que crea una ruta en la base de datos
     * @param ruta          (Ruta)  Ruta a crear
     * @throws SQLException Excepción de SQL
     * @throws Exception    Excepción general
     */
    public void createRuta(Ruta ruta) throws SQLException, Exception{
        setNombreTabla(NOMBRE_TABLA_RUTA);
        String sql = "INSERT INTO " + getNombreTabla() + " (nombre_ruta, descripcion, distancia_km, dificultad, tiempo_h, puntuacion_media, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia = null;

        sentencia = getConexion().prepareStatement(sql);
        sentencia.setString(1, ruta.getNombreRuta());
        sentencia.setString(2, ruta.getDescripcion());
        sentencia.setDouble(3, ruta.getDistanciaKm());
        sentencia.setString(4, ruta.getDificultad());
        sentencia.setDouble(5, ruta.getTiempoHoras());
        sentencia.setDouble(6, ruta.getPuntuacionMedia());
        sentencia.setInt(7, ruta.getCreadorRuta().getIDUsuario());

        sentencia.executeUpdate();
        cerrarSentencia(sentencia);
    }

    /**
     * @brief   Método que crea una foto de perfil en la base de datos y la asigna a un usuario
     * @param fotoPerfil    (FotoPerfil)    Foto de perfil a crear
     * @throws SQLException Excepción de SQL
     * @throws Exception    Excepción general
     * @post    La foto de perfil se asigna al usuario en la base de datos
     */
    public void createFotoPerfil(FotoPerfil fotoPerfil) throws SQLException, Exception{
        //Transacción
        getConexion().setAutoCommit(false);
        setNombreTabla(NOMBRE_TABLA_FOTO_PERFIL);
        String sql = "INSERT INTO " + getNombreTabla() + " (nombre_foto, resolucion_mpx, tamanio_kb) VALUES (?, ?, ?)";
        PreparedStatement sentencia = null;

        sentencia = getConexion().prepareStatement(sql);
        sentencia.setString(1, fotoPerfil.getNombreImagen());
        sentencia.setInt(2, fotoPerfil.getResolucionImagenMp());
        sentencia.setInt(3, fotoPerfil.getTamanioKb());

        sentencia.executeUpdate();

        //Obtener el id de la foto de perfil creada
        ResultSet idFotoPerfil = sentencia.getGeneratedKeys();
        idFotoPerfil.next();
        Integer id = idFotoPerfil.getInt(1);
  
        cerrarSentencia(sentencia);

        //Asignar la foto de perfil al usuario
        setNombreTabla(NOMBRE_TABLA_USUARIO);
        sql = "UPDATE " + getNombreTabla() + " SET id_foto_perfil = ? WHERE id_usuario = ?";
        sentencia = null;

        sentencia = getConexion().prepareStatement(sql);
        sentencia.setInt(1, id);
        sentencia.setInt(2, fotoPerfil.getUsuario().getIDUsuario());

        sentencia.executeUpdate();
        getConexion().commit();
        getConexion().setAutoCommit(true);

        cerrarSentencia(sentencia);
    }
}