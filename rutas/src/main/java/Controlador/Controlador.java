// Belén Robustillo Carmona

package Controlador;

import Modelo.Categoria;
import Modelo.Conector;
import Modelo.FotoPerfil;
import Modelo.Ruta;
import Modelo.Usuario;
import Modelo.Valoracion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//TODO 2. Tests unitarios

/**
 * Clase Controlador con atributos:
 * listaCategoriasSistema      Lista de categorías del sistema
 * listaUsuariosSistema        Lista de usuarios del sistema
 * listaFotosPerfilSistema     Lista de fotos de perfil del sistema
 * listaRutasSistema           Lista de rutas del sistema
 * listaValoracionesSistema    Lista de valoraciones del sistema
 * @author belen
 */
public class Controlador {
    private static Controlador      instancia = null;
    private ArrayList<Categoria>    listaCategoriasSistema;
    private ArrayList<Usuario>      listaUsuariosSistema;
    private ArrayList<FotoPerfil>   listaFotosPerfilSistema;
    private ArrayList<Ruta>         listaRutasSistema;
    private ArrayList<Valoracion>   listaValoracionesSistema;

    private Conector conector;
    
    //Constructor
    /**
     * @brief   Constructor de un objeto de la clase Controlador
     * @post    Las listas de categorías, usuarios, fotos de perfil, rutas y valoraciones estarán vacías
     *          El conector estará inicializado y conectado a la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public Controlador() throws SQLException, Exception{
        listaCategoriasSistema      = new ArrayList<>();
        listaUsuariosSistema        = new ArrayList<>();
        listaFotosPerfilSistema     = new ArrayList<>();
        listaRutasSistema           = new ArrayList<>();
        listaValoracionesSistema    = new ArrayList<>();

        conector = Conector.newInstance();
        conector.conectar();

        //Cargar datos de la base de datos
        cargarDatosSistema();
    }

    //Sets y gets

    /**
     * @brief   Método que establece la lista de categorías del sistema
     * @param listaCategoriasSistema    Lista de categorías del sistema
     */
    public void setListaCategoriasSistema(ArrayList<Categoria> listaCategoriasSistema) {
        this.listaCategoriasSistema = listaCategoriasSistema;
    }

    /**
     * @brief   Método que añade una categoría a la lista de categorías del sistema
     * @param categoria    Categoría a añadir a la lista de categorías del sistema
     * @post    La categoría se ha añadido al final de la lista de categorías del sistema
     */
    public void setCategoriaEnLista(Categoria categoria) {
        this.listaCategoriasSistema.add(categoria);
    }

    /**
     * @brief   Método que establece la lista de usuarios del sistema
     * @param listaUsuariosSistema  Lista de usuarios del sistema
     */
    public void setListaUsuariosSistema(ArrayList<Usuario> listaUsuariosSistema) {
        this.listaUsuariosSistema = listaUsuariosSistema;
    }

    /**
     * @brief   Método que añade un usuario a la lista de usuarios del sistema
     * @param usuario   Usuario a añadir a la lista de usuarios del sistema
     * @post    El usuario se ha añadido al final de la lista de usuarios del sistema
     */
    public void setUsuarioEnLista(Usuario usuario) {
        this.listaUsuariosSistema.add(usuario);
    }

    /**
     * @brief   Método que establece la lista de fotos de perfil del sistema
     * @param listaFotosPerfilSistema   Lista de fotos de perfil del sistema
     */
    public void setListaFotosPerfilSistema(ArrayList<FotoPerfil> listaFotosPerfilSistema) {
        this.listaFotosPerfilSistema = listaFotosPerfilSistema;
    }

    /**
     * @brief   Método que añade una foto de perfil a la lista de fotos de perfil del sistema
     * @param fotoPerfil    Foto de perfil a añadir a la lista de fotos de perfil del sistema
     * @post    La foto de perfil se ha añadido al final de la lista de fotos de perfil del sistema
     */
    public void setFotoPerfilEnLista(FotoPerfil fotoPerfil) {
        this.listaFotosPerfilSistema.add(fotoPerfil);
    } 

    /**
     * @brief   Método que establece la lista de rutas del sistema
     * @param listaRutasSistema Lista de rutas del sistema
     */
    public void setListaRutasSistema(ArrayList<Ruta> listaRutasSistema) {
        this.listaRutasSistema = listaRutasSistema;
    }

    /**
     * @brief   Método que añade una ruta a la lista de rutas del sistema
     * @param ruta  Ruta a añadir a la lista de rutas del sistema
     * @post    La ruta se ha añadido al final de la lista de rutas del sistema
     */
    public void setRutaEnLista(Ruta ruta) {
        this.listaRutasSistema.add(ruta);
    }

    /**
     * @brief   Método que establece la lista de valoraciones del sistema
     * @param listaValoracionesSistema  Lista de valoraciones del sistema
     */
    public void setListaValoracionesSistema(ArrayList<Valoracion> listaValoracionesSistema) {
        this.listaValoracionesSistema = listaValoracionesSistema;
    }

    /**
     * @brief   Método que añade una valoración a la lista de valoraciones del sistema
     * @param valoracion    Valoración a añadir a la lista de valoraciones del sistema
     * @post    La valoración se ha añadido al final de la lista de valoraciones del sistema
     */
    public void setValoracionEnLista(Valoracion valoracion) {
        this.listaValoracionesSistema.add(valoracion);
    }

    /**
     * @brief   Método que establece el conector
     * @param conector  Conector para la base de datos
     */
    public void setConector(Conector conector) {
        this.conector = conector;
    }

    /**
     * @brief   Método que devuelve la lista de categorías del sistema
     * @return  Lista de categorías del sistema
     */
    public ArrayList<Categoria> getListaCategoriasSistema() {
        return listaCategoriasSistema;
    }

    /**
     * @brief   Método que devuelve la lista de rutas de una categoría del sistema
     * @param IDcategoria   ID de la categoría de la que se quiere obtener la lista de rutas
     * @return  Lista de rutas de la categoría indicada
     */
    public ArrayList<Ruta> getListaRutasCategoria(Integer IDcategoria){
        ArrayList<Ruta> listaRutasCategoria = new ArrayList<>();

        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(IDcategoria)){
                listaRutasCategoria = listaCategoriasSistema.get(i).getListaRutas();
            }
        }

        return listaRutasCategoria;
    }

    /**
     * @brief   Método que devuelve la lista de usuarios del sistema
     * @return  Lista de usuarios del sistema
     */
    public ArrayList<Usuario> getListaUsuariosSistema() {
        return listaUsuariosSistema;
    }

    /**
     * @brief   Método que devuelve la id del usuario del sistema con el DNI indicado
     * @param dni   DNI del usuario del que se quiere obtener la ID
     * @return  (Integer) ID del usuario del sistema con el DNI indicado
     */
    public Integer getIdUsuarioSistema(String dni){
        Integer IDusuario = 0;

        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dni)){
                IDusuario = listaUsuariosSistema.get(i).getIDUsuario();
            }
        }

        return IDusuario;
    }

    /**
     * @brief   Método que devuelve la lista de fotos de perfil del sistema
     * @return  Lista de fotos de perfil del sistema
     */
    public ArrayList<FotoPerfil> getListaFotosPerfilSistema() {
        return listaFotosPerfilSistema;
    }

    /**
     * @brief   Método que devuelve la lista de rutas del sistema
     * @return  Lista de rutas del sistema
     */
    public ArrayList<Ruta> getListaRutasSistema() {
        return listaRutasSistema;
    }

    /**
     * @brief   Método que devuelve el ID de la ruta del sistema
     * @param nombreRuta        Nombre de la ruta de la que se quiere obtener el ID
     * @param IDcreadorRuta     ID del creador de la ruta de la que se quiere obtener el ID
     * @return  (Integer)  ID de la ruta del sistema con el nombre y el ID del creador indicados
     */
    public Integer getIDrutaSistema(String nombreRuta, Integer IDcreadorRuta){
        Integer IDruta = 0;

        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRuta) && listaRutasSistema.get(i).getCreadorRuta().getIDUsuario().equals(IDcreadorRuta)){
                IDruta = listaRutasSistema.get(i).getIdRuta();
            }
        }

        return IDruta;
    }

    /**
     * @brief   Método que devuelve la ruta del sistema con el nombre y el DNI del creador indicados
     * @param nombreRuta        Nombre de la ruta de la que se quiere obtener el ID
     * @param DNIcreadorRuta    DNI del creador de la ruta de la que se quiere obtener el ID
     * @return  (Ruta)  Ruta del sistema con el nombre y el DNI del creador indicados
     */
    public Ruta getRutaSistema(String nombreRuta, String DNIcreadorRuta){
        Ruta ruta = null;

        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRuta) && listaRutasSistema.get(i).getCreadorRuta().getDNI().equals(DNIcreadorRuta)){
                ruta = listaRutasSistema.get(i);
            }
        }

        return ruta;
    }

    /**
     * @brief   Método que devuelve la lista de valoraciones del sistema
     * @return  Lista de valoraciones del sistema
     */
    public ArrayList<Valoracion> getListaValoracionesSistema() {
        return listaValoracionesSistema;
    }

    /**
     * @brief   Método que devuelve el conector para la base de datos
     * @return  (Conector)  Conector para la base de datos
     */
    public Conector getConector() {
        return conector;
    }

    //Métodos
    /**
     * @brief   Método que crea una instancia de la clase Controlador si no existe previamente
     * @return  Instancia de la clase Controlador
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public static Controlador newInstance() throws SQLException, Exception{
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }

    /**
     * @brief   Método que comprueba si el formato del DNI es correcto, es decir: tiene 8 números y una letra que corresponde con los números
     * @param dni   DNI a comprobar
     * @return      True si el formato del DNI es correcto, false en caso contrario
     */
    public boolean comprobarFormatoDNICorrecto(String dni){
        boolean formatoCorrecto = false;
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        if(dni.length() == 9){
            //Comprobar si los 8 primeros caracteres son números
            if(Character.isDigit(dni.charAt(0)) && Character.isDigit(dni.charAt(1)) && Character.isDigit(dni.charAt(2)) && Character.isDigit(dni.charAt(3)) && Character.isDigit(dni.charAt(4)) && Character.isDigit(dni.charAt(5)) && Character.isDigit(dni.charAt(6)) && Character.isDigit(dni.charAt(7))){
                //Comprobar si el último caracter es una letra
                if(Character.isLetter(dni.charAt(8))){
                    //Comprobar si la letra es correcta
                    if(dni.charAt(8) == letrasDNI.charAt(Integer.parseInt(dni.substring(0, 8)) % 23)){
                        formatoCorrecto = true;
                    }
                }
            }
        }

        return formatoCorrecto;
    }

    /**
     * @brief   Método que comprueba si el formato del correo electrónico es correcto
     * @param correo    Correo electrónico a comprobar
     * @return  True si el formato del correo electrónico es correcto, false en caso contrario
     */
    public boolean comprobarFormatoCorreoCorrecto(String correo){
        boolean formatoCorrecto = false;

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        formatoCorrecto = matcher.matches();

        return formatoCorrecto;
    }

    /**
     * @brief   Método que añade una categoría a la lista de categorías del sistema siempre que no exista ya
     * @param nombreCategoria   Nombre de la categoría a añadir a la lista de categorías del sistema
     * @throws SQLException     Excepción que se lanza si se produce un error en la base de datos
     * @throws Exception        Excepción general
     * @post    Se actualiza la base de datos
     */
    public void aniadirCategoria(String nombreCategoria) throws SQLException, Exception{
        Categoria categoria = new Categoria(nombreCategoria);

        conector.createCategoria(categoria);
        conector.getTodasLasCategorias();
    }
    
    /**
     * @brief   Método que borra una categoría de la lista de categorías del sistema
     * @param IDcategoriaEliminada  ID de la categoría a eliminar de la lista de categorías del sistema
     * @post    La categoría con el ID indicado se ha eliminado de la lista de categorías del sistema
     * @post    Se modifican todas las listas del sistema afectadas
     * @post    Se actualiza la base de datos
     * @throws SQLException     Excepción que se lanza si se produce un error en la base de datos
     * @throws Exception        Excepción general
     */
    public void borrarCategoria(Integer IDcategoriaEliminada) throws SQLException, Exception{
        Categoria categoriaEliminada = null;
        boolean encontrado = false;
        for(int i=0; i < listaCategoriasSistema.size() && !encontrado; i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(IDcategoriaEliminada)){
                categoriaEliminada = listaCategoriasSistema.get(i);
                encontrado = true;
            }
        }

        getConector().deleteCategoria(categoriaEliminada);
        getConector().getTodasLasCategorias();
        getConector().getTodasLasRutas();
        getConector().vincularCategoriasConRutas();
    }    

    /**
     * @brief   Método que añade un usuario a la lista de usuarios del sistema siempre que no exista ya
     * @param DNI           DNI del usuario a añadir a la lista de usuarios del sistema
     * @param nombre        Nombre del usuario a añadir a la lista de usuarios del sistema
     * @param apellido1     Primer apellido del usuario a añadir a la lista de usuarios del sistema
     * @param apellido2     Segundo apellido del usuario a añadir a la lista de usuarios del sistema
     * @param correo        Correo electrónico del usuario a añadir a la lista de usuarios del sistema
     * @param contrasenia   Contraseña del usuario a añadir a la lista de usuarios del sistema
     * @post    Se actualiza la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void aniadirUsuario(String DNI, String nombre, String apellido1, String apellido2, String correo, String contrasenia) throws SQLException, Exception{
        Usuario usuario = new Usuario(nombre, apellido1, apellido2, correo, contrasenia, DNI);

        getConector().createUsuario(usuario);
        getConector().getTodosLosUsuarios();
    }

    /**
     * @brief   Método que modifica los datos de un usuario de la lista de usuarios del sistema
     * @param DNI           DNI del usuario a modificar
     * @param apellido1     Primer apellido del usuario a modificar
     * @param apellido2     Segundo apellido del usuario a modificar
     * @param correo        Correo electrónico del usuario a modificar
     * @param contrasenia   Contraseña del usuario a modificar
     * @post    El usuario con el DNI indicado tiene los datos modificados
     * @post    Se actualiza la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void modificarUsuario(String DNI, String apellido1, String apellido2, String correo, String contrasenia) throws SQLException, Exception{
        Usuario usuario = null;
        boolean encontrado = false;
        for(int i=0; i < listaUsuariosSistema.size() && !encontrado; i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(DNI)){
                usuario = listaUsuariosSistema.get(i);
                encontrado = true;
            }
        }

        usuario.setApellido1 (apellido1);
        usuario.setApellido2(apellido2);
        usuario.setCorreoElectronico(correo);
        if(contrasenia.equals("********")){
            //No se ha modificado, no hacer nada
        }
        else{
            usuario.setContrasenia(contrasenia);
        }

        getConector().updateUsuario(usuario);
        leerUsuariosBD();
    }

    /**
     * @brief   Método que borra un usuario de la lista de usuarios del sistema
     * @param dni   DNI del usuario a borrar de la lista de usuarios del sistema
     * @post    El usuario con el DNI indicado se ha eliminado de la lista de usuarios del sistema
     * @post    Se han borrado las valoraciones del usuario
     * @post    Se han borrado las rutas del usuario
     * @post    Se ha borrado la foto de perfil del usuario
     * @post    Se modifican todas las listas del sistema afectadas
     * @post    Se actualiza la base de datos
     * @throws SQLException     Excepción que se lanza si se produce un error en la base de datos
     * @throws Exception        Excepción general
     */
    public void borrarUsuario(String dni) throws SQLException, Exception{
        Usuario usuarioEliminado = null;
        boolean encontrado = false;
        for(int i=0; i < listaUsuariosSistema.size() && !encontrado; i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dni)){
                usuarioEliminado = listaUsuariosSistema.get(i);
                encontrado = true;
            }
        }

        getConector().deleteUsuario(usuarioEliminado);
        cargarDatosSistema();
    }

    /**
     * @brief   Método que añade una ruta a la lista de rutas del sistema siempre que no exista ya
     * @param nombreRuta        Nombre de la ruta a añadir a la lista de rutas del sistema
     * @param descripcion       Descripción de la ruta a añadir a la lista de rutas del sistema
     * @param distanciaKm       Distancia de la ruta a añadir a la lista de rutas del sistema
     * @param tiempoHoras       Tiempo de la ruta a añadir a la lista de rutas del sistema
     * @param dificultad        Dificultad de la ruta a añadir a la lista de rutas del sistema
     * @param DNIcreadorRuta    DNI del creador de la ruta a añadir a la lista de rutas del sistema
     * @post    Se actualiza la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void aniadirRuta(String nombreRuta, String descripcion, double distanciaKm, double tiempoHoras, String dificultad, String DNIcreadorRuta) throws SQLException, Exception{
        boolean existeRuta = false;
        //Buscar usuario con IDcreadorRuta en listaUsuariosSistema
        Usuario creadorRuta = null;
        boolean encontrado = false;
        for(int i=0; i < listaUsuariosSistema.size() && !encontrado; i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(DNIcreadorRuta)){
                creadorRuta = listaUsuariosSistema.get(i);
                encontrado = true;
            }
        }
        Ruta ruta = new Ruta(nombreRuta, descripcion, distanciaKm, dificultad, tiempoHoras, creadorRuta);

        getConector().createRuta(ruta);
        getConector().getTodasLasRutas();
    }

    /**
     * @brief   Método que borra una ruta de la lista de rutas del sistema
     * @param nombreRutaEliminada       Nombre de la ruta a borrar de la lista de rutas del sistema
     * @param dniCreadorRutaEliminada   DNI del creador de la ruta a borrar de la lista de rutas del sistema
     * @post    La ruta con el nombre y el dni del creador indicados se ha eliminado de la lista de rutas del sistema
     * @post    Se modifican todas las listas del sistema afectadas
     * @post    Se actualiza la base de datos
     * @throws SQLException     Excepción que se lanza si se produce un error en la base de datos
     * @throws Exception        Excepción general
     */
    public void borrarRuta(String nombreRutaEliminada, String dniCreadorRutaEliminada) throws SQLException, Exception{
        Ruta rutaEliminada = null;
        boolean encontrada = false;

        for(int i=0; i < listaRutasSistema.size() && !encontrada; i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRutaEliminada) && listaRutasSistema.get(i).getCreadorRuta().getDNI().equals(dniCreadorRutaEliminada)){
                rutaEliminada = listaRutasSistema.get(i);
                encontrada=true;
            }
        }

        getConector().deleteRuta(rutaEliminada);
        cargarDatosSistema();
    }

    /**
     * @brief   Método que modifica los datos de una ruta de la lista de rutas del sistema
     * @param nombreRuta    Nombre de la ruta a modificar
     * @param descripcion   Descripción de la ruta a modificar
     * @param dificultad    Dificultad de la ruta a modificar
     * @param dniCreador    DNI del creador de la ruta a modificar
     * @post    La ruta con el nombre y el dni del creador indicados tiene los datos modificados
     * @post    La base de datos se ha actualizado
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void modificarRuta(String nombreRuta, String descripcion, String dificultad, String dniCreador) throws SQLException, Exception{
        //Buscar ID del usuario creador de la ruta
        Integer IDcreadorRuta = 0;
        boolean encontrado = false;
        for(int i=0; i < listaUsuariosSistema.size() && !encontrado; i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniCreador)){
                IDcreadorRuta = listaUsuariosSistema.get(i).getIDUsuario();
                encontrado = true;
            }
        }

        Ruta ruta = null;
        encontrado = false;
        //Buscar la ruta en la lista de rutas del sistema por el nombre y el id del creador
        for(int i=0; i < listaRutasSistema.size() && !encontrado; i++){
            if(listaRutasSistema.get(i).getNombreRuta().equals(nombreRuta) && listaRutasSistema.get(i).getCreadorRuta().getIDUsuario().equals(IDcreadorRuta)){
                ruta = listaRutasSistema.get(i);
                encontrado = true;
            }
        }

        ruta.setDescripcion(descripcion);
        ruta.setDificultad(dificultad);
        getConector().updateRuta(ruta);
        leerRutasBD();
    }

    /**
     * @brief   Método que añade una valoración a la lista de valoraciones del sistema siempre que no exista ya
     * @param ruta          Ruta a la que se le añade la valoración
     * @param dniUsuario    DNI del usuario que realiza la valoración
     * @param puntuacion    Puntuación de la valoración
     * @param comentario    Comentario de la valoración
     * @post    Se actualiza la base de datos
     * @post    Se actualiza la puntuación media de la ruta
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void aniadirValoracion(Ruta ruta, String dniUsuario, Integer puntuacion, String comentario) throws SQLException, Exception{
        //Buscar usuario con dni
        Usuario usuario = null;
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniUsuario)){
                usuario = listaUsuariosSistema.get(i);
            }
        }
        
        Valoracion valoracion = new Valoracion(ruta, usuario, puntuacion, comentario);
        ruta.setValoracionEnLista(valoracion);      //Para actualizar la puntuación media de la ruta

        getConector().createValoracion(valoracion);
        getConector().getTodasLasValoraciones();
        getConector().getTodasLasRutas();
        getConector().getTodosLosUsuarios();
    }
    
    /**
     * @brief   Método que borra una valoración de la lista de valoraciones del sistema
     * @param nombreRuta    Nombre de la ruta a la que se le borra la valoración
     * @param usuario       DNI del usuario que realiza la valoración
     * @post    La valoración con el nombre de la ruta y el dni del usuario indicados se ha eliminado de la lista de valoraciones del sistema
     * @post    El fichero XML contiene la lista de valoraciones del sistema actualizada
     */
    public void borrarValoracion(String nombreRuta, String usuario){
        Integer IDvaloracionEliminada = 0;
        //Buscar la valoración en el sistema
        for(int i=0; i < listaValoracionesSistema.size(); i++){
            if(listaValoracionesSistema.get(i).getRuta().getNombreRuta().equals(nombreRuta) && listaValoracionesSistema.get(i).getUsuario().getDNI().equals(usuario)){
                IDvaloracionEliminada = listaValoracionesSistema.get(i).getIDValoracion();
                //Eliminar la valoración de la lista de valoraciones del usuario
                for(Usuario usu : listaUsuariosSistema){
                    for(Valoracion val : usu.getListaValoraciones()){
                        if(val.getIDValoracion().equals(IDvaloracionEliminada)){
                            //Sobreescribir el array de valoraciones del usuario ignorando esta valoración
                            ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                            for(int j=0; j < usu.getListaValoraciones().size(); j++){
                                if(!usu.getListaValoraciones().get(j).getIDValoracion().equals(IDvaloracionEliminada)){
                                    listaValoracionesAux.add(usu.getListaValoraciones().get(j));
                                }
                            }
                            usu.setListaValoraciones(listaValoracionesAux);
                        }
                    }
                }

                //Eliminar la valoración de la lista de valoraciones de la ruta
                for(Ruta ruta : listaRutasSistema){
                    for(Valoracion val : ruta.getListaValoraciones()){
                        if(val.getIDValoracion().equals(IDvaloracionEliminada)){
                            //Sobreescribir el array de valoraciones de la ruta ignorando esta valoración
                            ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                            for(int j=0; j < ruta.getListaValoraciones().size(); j++){
                                if(!ruta.getListaValoraciones().get(j).getIDValoracion().equals(IDvaloracionEliminada)){
                                    listaValoracionesAux.add(ruta.getListaValoraciones().get(j));
                                }
                            }
                            ruta.setListaValoraciones(listaValoracionesAux);
                        }
                    }
                }

                //Eliminar la valoración de la lista de valoraciones del sistema
                listaValoracionesSistema.remove(i);
            }
        }
        serializarValoracion();
        serializarRuta();
        serializarUsuario();
    }

    /**
     * @brief   Método que modifica los datos de una valoración de la lista de valoraciones del sistema
     * @param rutaValorada      Ruta a la que se le modifica la valoración
     * @param dniUsuario        DNI del usuario que realiza la valoración
     * @param puntuacion        Puntuación de la valoración
     * @param comentario        Comentario de la valoración
     * @post    La valoración con el nombre de la ruta y el dni del usuario indicados tiene los datos modificados
     * @post    El fichero XML contiene la lista de valoraciones del sistema actualizada
     */
    public void modificarValoracion(Ruta rutaValorada, String dniUsuario, Integer puntuacion, String comentario){
        //Buscar la valoración en la lista de valoraciones del sistema
        for(int i=0; i < listaValoracionesSistema.size(); i++){
            if(listaValoracionesSistema.get(i).getRuta().getIdRuta().equals(rutaValorada.getIdRuta()) && listaValoracionesSistema.get(i).getUsuario().getDNI().equals(dniUsuario)){
                //Sobreescribir el array del usuario sin esta valoracion
                ArrayList<Valoracion> listaValoracionesAux = new ArrayList<>();
                for(int j=0; j < listaValoracionesSistema.get(i).getUsuario().getListaValoraciones().size(); j++){
                    if(!listaValoracionesSistema.get(i).getUsuario().getListaValoraciones().get(j).getIDValoracion().equals(listaValoracionesSistema.get(i).getIDValoracion())){
                        listaValoracionesAux.add(listaValoracionesSistema.get(i).getUsuario().getListaValoraciones().get(j));
                    }
                }
                listaValoracionesSistema.get(i).getUsuario().setListaValoraciones(listaValoracionesAux);

                //Sobreescribir el array de la ruta sin esta valoracion
                listaValoracionesAux = new ArrayList<>();
                for(int j=0; j < listaValoracionesSistema.get(i).getRuta().getListaValoraciones().size(); j++){
                    if(!listaValoracionesSistema.get(i).getRuta().getListaValoraciones().get(j).getIDValoracion().equals(listaValoracionesSistema.get(i).getIDValoracion())){
                        listaValoracionesAux.add(listaValoracionesSistema.get(i).getRuta().getListaValoraciones().get(j));
                    }
                }
                listaValoracionesSistema.get(i).getRuta().setListaValoraciones(listaValoracionesAux);
                listaValoracionesSistema.get(i).setPuntuacion(puntuacion);
                listaValoracionesSistema.get(i).setComentario(comentario);
                
                //Añadir la valoración modificada a la lista de valoraciones del usuario
                listaValoracionesSistema.get(i).getUsuario().setValoracionEnLista(listaValoracionesSistema.get(i));
                //Añadir la valoración modificada a la lista de valoraciones de la ruta
                listaValoracionesSistema.get(i).getRuta().setValoracionEnLista(listaValoracionesSistema.get(i));
            }
        }
        serializarValoracion();
        serializarRuta();
    }

    /**
     * @brief   Método que añade una foto de perfil a la lista de fotos de perfil del sistema siempre que no exista ya
     * @param dniUsuario            DNI del usuario al que se le añade la foto de perfil
     * @param nombreImagen          Nombre de la imagen de la foto de perfil
     * @param resolucionImagenMp    Resolución de la imagen de la foto de perfil
     * @param tamanioKb             Tamaño de la imagen de la foto de perfil
     * @post    Se actualiza la base de datos
     * @post    Se actualiza la lista de fotos de perfil del usuario
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void aniadirFotoPerfil(String dniUsuario, String nombreImagen, Integer resolucionImagenMp, Integer tamanioKb) throws SQLException, Exception{
        //Buscar usuario con dni
        Usuario usuario = null;
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniUsuario)){
                usuario = listaUsuariosSistema.get(i);
            }
        }

        FotoPerfil fotoPerfil = new FotoPerfil(nombreImagen, resolucionImagenMp, tamanioKb, usuario);

        getConector().createFotoPerfil(fotoPerfil);
        getConector().getTodasLasFotosPerfil();
        getConector().getTodosLosUsuarios();
    }

    /**
     * @brief   Método que modifica los datos de una foto de perfil de la lista de fotos de perfil del sistema
     * @param dniUsuario            DNI del usuario al que se le modifica la foto de perfil
     * @param nombreImagen          Nombre de la imagen de la foto de perfil
     * @param resolucionImagenMp    Resolución de la imagen de la foto de perfil
     * @param tamanioKb             Tamaño de la imagen de la foto de perfil
     * @post    La foto de perfil del usuario con el dni indicado tiene los datos modificados
     * @post    El fichero XML contiene la lista de fotos de perfil del sistema actualizada
     */
    public void modificarFotoPerfil(String dniUsuario, String nombreImagen, Integer resolucionImagenMp, Integer tamanioKb){
        //Buscar la foto de perfil en la lista de fotos de perfil del sistema
        for(int i=0; i < listaFotosPerfilSistema.size(); i++){
            if(listaFotosPerfilSistema.get(i).getUsuario().getDNI().equals(dniUsuario)){
                listaFotosPerfilSistema.get(i).setNombreImagen(nombreImagen);
                listaFotosPerfilSistema.get(i).setResolucionImagenMp(resolucionImagenMp);
                listaFotosPerfilSistema.get(i).setTamanioKb(tamanioKb);
            }
        }
        serializarFotoPerfil();
        serializarUsuario();
    }

    /**
     * @brief   Método que borra una foto de perfil de la lista de fotos de perfil del sistema
     * @param idFotoEliminada   ID de la foto de perfil a eliminar de la lista de fotos de perfil del sistema
     * @post    La foto de perfil con el ID indicado se ha eliminado de la lista de fotos de perfil del sistema
     * @post    El fichero XML contiene la lista de fotos de perfil del sistema actualizada
     */
    public void borrarFotoPerfil(Integer idFotoEliminada){
        String dniUsuario = "";
        //Eliminar la foto de perfil del sistema
        for(int i=0; i < listaFotosPerfilSistema.size(); i++){
            if(listaFotosPerfilSistema.get(i).getIDfoto().equals(idFotoEliminada)){
                dniUsuario = listaFotosPerfilSistema.get(i).getUsuario().getDNI();
                listaFotosPerfilSistema.remove(i);
            }
        }
        //Eliminar la foto de perfil del usuario
        for(int i=0; i < listaUsuariosSistema.size(); i++){
            if(listaUsuariosSistema.get(i).getDNI().equals(dniUsuario)){
                listaUsuariosSistema.get(i).setFotoPerfil(null);
            }
        }
        serializarFotoPerfil();
        serializarUsuario();
    }
    
    /**
     * @brief   Método que elimina una ruta de una categoría y una categoría de una ruta
     * @param idRuta        ID de la ruta a eliminar de la categoría
     * @param idCategoria   ID de la categoría a eliminar de la ruta
     * @post    La ruta con el ID indicado se ha eliminado de la categoría con el ID indicado
     * @post    La categoría con el ID indicado se ha eliminado de la ruta con el ID indicado
     * @post    Se actualizan los ficheros XML
     * @post    Se actualizan las listas del sistema
     */
    public void eliminarRutaDeCategoria(Integer idRuta, Integer idCategoria){
        //Buscar la ruta en la lista de rutas del sistema
        Ruta ruta = null;
        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getIdRuta().equals(idRuta)){
                ruta = listaRutasSistema.get(i);
            }
        }
        //Buscar la categoría en la lista de categorías del sistema
        Categoria categoria = null;
        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(idCategoria)){
                categoria = listaCategoriasSistema.get(i);
            }
        }
        //Sobreescribir el array de rutas de la categoría ignorando esta ruta
        ArrayList<Ruta> listaRutasAux = new ArrayList<>();
        for(int i=0; i < categoria.getListaRutas().size(); i++){
            if(!categoria.getListaRutas().get(i).getIdRuta().equals(idRuta)){
                listaRutasAux.add(categoria.getListaRutas().get(i));
            }
        }
        categoria.setListaRutas(listaRutasAux);

        //Sobreescibir el array de categorías de la ruta ignorando esta categoría
        ArrayList<Categoria> listaCategoriasAux = new ArrayList<>();
        for(int i=0; i < ruta.getListaCategorias().size(); i++){
            if(!ruta.getListaCategorias().get(i).getIDCategoria().equals(idCategoria)){
                listaCategoriasAux.add(ruta.getListaCategorias().get(i));
            }
        }
        ruta.setListaCategorias(listaCategoriasAux);

        serializarCategoria();
        serializarRuta();
    }

    /**
     * @brief   Método que añade una ruta a una categoría y una categoría a una ruta siempre que no estén ya añadidos
     * @param ruta      Ruta a añadir a la categoría
     * @param categoria Categoría a añadir a la ruta
     * @post    Se actualiza la base de datos
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void aniadirRutaACategoria(Ruta ruta, Categoria categoria) throws SQLException, Exception{
        boolean existeRuta = false;
        boolean existeCategoria = false;
        //Buscar la ruta en la lista de rutas del sistema
        for(int i=0; i < listaRutasSistema.size(); i++){
            if(listaRutasSistema.get(i).getIdRuta().equals(ruta.getIdRuta())){
                existeRuta = true;
            }
        }

        //Buscar la categoría en la lista de categorías del sistema
        for(int i=0; i < listaCategoriasSistema.size(); i++){
            if(listaCategoriasSistema.get(i).getIDCategoria().equals(categoria.getIDCategoria())){
                existeCategoria = true;
            }
        }

        if(existeRuta && existeCategoria){
            getConector().createClasificacion(categoria, ruta);
            getConector().getTodasLasCategorias();
            getConector().getTodasLasRutas();
            getConector().vincularCategoriasConRutas();
        }
    }

    /**
     * @brief   Método que serializa la lista de categorías del sistema
     */
    public void serializarCategoria(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("Categorias.dat"));
            serializador.writeObject(listaCategoriasSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de categorías del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de categorías del sistema");
                }
            }
        }
    }

   

    /**
     * @brief   Método que obtiene toda la información de la base de datos y la almacena en las listas del sistema
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void cargarDatosSistema() throws SQLException, Exception{
        leerCategoriasBD();
        leerFotosPerfilBD();
        leerUsuariosBD();
        leerRutasBD();
        leerValoracionesBD();
    }

    /**
     * @brief   Método que obtiene la lista de completa de categorías de la base de datos
     * @post    Se obtiene la lista de categorías de la base de datos
     * @post    Si la conexión con la base de datos falla, la lista de categorías del sistema se queda vacía
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void leerCategoriasBD() throws SQLException, Exception{
        listaCategoriasSistema.clear();
        listaCategoriasSistema = getConector().getTodasLasCategorias();
    }

    /**
     * @brief   Método que obtiene la lista de completa de fotos de perfil de la base de datos
     * @post    Se obtiene la lista de fotos de perfil de la base de datos
     * @post    Si la conexión con la base de datos falla, la lista de fotos de perfil del sistema se queda vacía
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void leerFotosPerfilBD() throws SQLException, Exception{
        listaFotosPerfilSistema.clear();
        listaFotosPerfilSistema = getConector().getTodasLasFotosPerfil();
    }

    /**
     * @brief   Método que obtiene la lista de completa de usuarios de la base de datos
     * @post    Se obtiene la lista de usuarios de la base de datos
     * @post    Si la conexión con la base de datos falla, la lista de usuarios del sistema se queda vacía
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void leerUsuariosBD() throws SQLException, Exception{
        listaUsuariosSistema.clear();
        listaUsuariosSistema = getConector().getTodosLosUsuarios();
    }

    /**
     * @brief   Método que obtiene la lista de completa de rutas de la base de datos
     * @post    Se obtiene la lista de rutas de la base de datos
     * @post    Si la conexión con la base de datos falla, la lista de rutas del sistema se queda vacía
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void leerRutasBD() throws SQLException, Exception{
        listaRutasSistema.clear();
        listaRutasSistema = getConector().getTodasLasRutas();
    }

    /**
     * @brief   Método que obtiene la lista de completa de valoraciones de la base de datos
     * @post    Se obtiene la lista de valoraciones de la base de datos
     * @post    Si la conexión con la base de datos falla, la lista de valoraciones del sistema se queda vacía
     * @throws  SQLException     Excepción de SQL
     * @throws  Exception        Excepción general
     */
    public void leerValoracionesBD() throws SQLException, Exception{
        listaValoracionesSistema.clear();
        listaValoracionesSistema = getConector().getTodasLasValoraciones();
    }

    /**
     * @brief   Método que serializa la lista de fotos de perfil del sistema
     */
    public void serializarFotoPerfil(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("FotosPerfil.dat"));
            serializador.writeObject(listaFotosPerfilSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de fotos de perfil del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de fotos de perfil del sistema");
                }
            }
        }
    }

    /**
     * @brief   Método que serializa la lista de rutas del sistema
     */
    public void serializarRuta(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("Rutas.dat"));
            serializador.writeObject(listaRutasSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de rutas del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de rutas del sistema");
                }
            }
        }
    }

    /**
     * @brief   Método que serializa la lista de usuarios del sistema
     */
    public void serializarUsuario(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));
            serializador.writeObject(listaUsuariosSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de usuarios del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de usuarios del sistema");
                }
            }
        }
    }

    /**
     * @brief   Método que serializa la lista de valoraciones del sistema
     */
    public void serializarValoracion(){
        ObjectOutputStream serializador = null;
        try{
            serializador = new ObjectOutputStream(new FileOutputStream("Valoraciones.dat"));
            serializador.writeObject(listaValoracionesSistema);
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al serializar la lista de valoraciones del sistema");
        }
        finally{
            if(serializador != null){
                try{
                    serializador.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                    System.out.println("Error al cerrar el serializador de la lista de valoraciones del sistema");
                }
            }
        }
    }

    
}
