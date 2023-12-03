//Belén Robustillo Carmona

package Vista;

import Modelo.Categoria;
import Modelo.Ruta;
import Modelo.Usuario;
import Modelo.Valoracion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.xml.sax.SAXException;

import Controlador.Controlador;
import Modelo.FotoPerfil;

/**
 * Clase Ventana 1
 * @author BelenBRC
 */
public final class Ventana1 extends javax.swing.JFrame {
    public Controlador controladorVista;
    public boolean aniadiendo = false;
    public boolean modificando = false;

    /**
     * @brief   Constructor de la ventana principal
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.NotSerializableException
     * @throws org.xml.sax.SAXException
     */
    public Ventana1() throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException {
        initComponents();

        try{
            controladorVista = Controlador.newInstance();
            controladorVista.getConector().conectar();
            controladorVista.cargarDatosSistema();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del sistema\n" + ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error inesperado al cargar los datos del sistema\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Ocultar campos modificables en las pestañas
        ocultarCamposCategorias();
        ocultarCamposRutas();
        ocultarCamposUsuarios();
        ocultarCamposValoraciones();
        ocultarCamposFotosPerfil();

        //Establecer los valores del combobox de dificultad
        jComboBox_dificultad_ruta.addItem("BAJA");
        jComboBox_dificultad_ruta.addItem("MEDIA");
        jComboBox_dificultad_ruta.addItem("ALTA");
        
        //Pintar datos en las tablas
        pintarDatosCategoria();
        pintarDatosRuta();
        pintarDatosUsuario();
        pintarDatosValoracion();
        pintarDatosFotoPerfil();

        //Ocultar tablas de info extra
        jScrollPane1.setVisible(false);
        jLabel_tabla_rutas_de_categoria.setVisible(false);
        jButton_eliminar_ruta_de_categoria.setVisible(false);
        jButton_guardar_modificacion_categoria.setVisible(false);
        jButton_aniadir_ruta_de_categoria.setVisible(false);
        jComboBox1.setVisible(false);
        jButton_confirmar_aniadir_ruta_de_categoria.setVisible(false);

        jLabel_valoraciones_ruta.setVisible(false);
        jScrollPane_valoraciones_ruta.setVisible(false);
        jLabel_categorias_ruta.setVisible(false);
        jScrollPane_categorias_ruta.setVisible(false);
        jButton_aniadir_categoria_en_ruta.setVisible(false);
        jButton_borrar_categoria_en_ruta.setVisible(false);
        jButton_guardar_categoria_en_ruta.setVisible(false);
        jButton_confirmar_aniadir_categoria_en_ruta3.setVisible(false);
        jComboBox_categoris_aniadibles_a_ruta.setVisible(false);

        jLabel_valoraciones_usuario.setVisible(false);
        jScrollPane_valoraciones_usuario.setVisible(false);
        jLabel_rutas_usuario.setVisible(false);
        jScrollPane_rutas_usuario.setVisible(false);
    }

    /**
     * @brief   Método que oculta los campos editables de la pestaña categorías
     */
    private void ocultarCamposCategorias(){
        jLabel_nombre_categoria.setVisible(false);
        jTextField_nombre_categoria.setVisible(false);

        jButton_guardar_categoria.setVisible(false);
        jButton_cancelar_cantegoria.setVisible(false);

        //Mostrar tabla rutas de categoria
        jScrollPane1.setVisible(true);
        jLabel_tabla_rutas_de_categoria.setVisible(true);
    }

    /**
     * @brief   Método que muestra los campos editables de la pestaña categorías
     */
    private void mostrarCamposCategorias(){
        jLabel_nombre_categoria.setVisible(true);
        jTextField_nombre_categoria.setVisible(true);

        jButton_guardar_categoria.setVisible(true);
        jButton_cancelar_cantegoria.setVisible(true);

        //Ocultar tabla rutas de categoria
        jScrollPane1.setVisible(false);
        jLabel_tabla_rutas_de_categoria.setVisible(false);
    }

    /**
     * @brief   Método que oculta los campos editables de la pestaña usuarios
     */
    private void ocultarCamposUsuarios(){
        jLabel_dni_usuario.setVisible(false);
        jTextField_dni_persona.setVisible(false);
        jLabel_nombre_usuario.setVisible(false);
        jTextField_nombre_usuario.setVisible(false);
        jLabel_apellido1_usuario.setVisible(false);
        jTextField_apellido1_usuario.setVisible(false);
        jLabel_apellido2_usuario.setVisible(false);
        jTextField_apellido2_usuario.setVisible(false);
        jLabel_correo_usuario.setVisible(false);
        jTextField_correo_usuario.setVisible(false);
        jLabel_contrasenia_usuario.setVisible(false);
        jPasswordField_contrasenia_usuario.setVisible(false);
        
        jButton_guardar_usuario.setVisible(false);
        jButton_cancelar_usuario.setVisible(false);

        //Mostrar tablas de info extra
        jLabel_valoraciones_usuario.setVisible(true);
        jScrollPane_valoraciones_usuario.setVisible(true);
        jLabel_rutas_usuario.setVisible(true);
        jScrollPane_rutas_usuario.setVisible(true);
    }

    /**
     * @brief   Método que muestra los campos editables de la pestaña usuarios
     */
    private void mostrarCamposUsuarios(){
        jLabel_dni_usuario.setVisible(true);
        jTextField_dni_persona.setVisible(true);
        jLabel_nombre_usuario.setVisible(true);
        jTextField_nombre_usuario.setVisible(true);
        jLabel_apellido1_usuario.setVisible(true);
        jTextField_apellido1_usuario.setVisible(true);
        jLabel_apellido2_usuario.setVisible(true);
        jTextField_apellido2_usuario.setVisible(true);
        jLabel_correo_usuario.setVisible(true);
        jTextField_correo_usuario.setVisible(true);
        jLabel_contrasenia_usuario.setVisible(true);
        jPasswordField_contrasenia_usuario.setVisible(true);
        
        jButton_guardar_usuario.setVisible(true);
        jButton_cancelar_usuario.setVisible(true);

        //Ocultar tablas de info extra
        jLabel_valoraciones_usuario.setVisible(false);
        jScrollPane_valoraciones_usuario.setVisible(false);
        jLabel_rutas_usuario.setVisible(false);
        jScrollPane_rutas_usuario.setVisible(false);

        //Habilitar los campos que no se pueden modificar
        jTextField_dni_persona.setEnabled(true);
        jTextField_nombre_usuario.setEnabled(true);
    }

    /**
     * @brief   Método que oculta las etiquetas, campos de texto, combobox y botones de la parte modificable de la pestaña valoraciones
     */
    private void ocultarCamposValoraciones(){
        jLabel_ruta_valoracion.setVisible(false);
        jLabel_usuario_valoracion.setVisible(false);
        jLabel_puntuacion_valoracion.setVisible(false);
        jLabel_comentario_valoracion.setVisible(false);
        jComboBox_ruta_valoracion.setVisible(false);
        jComboBox_usuario_valoracion.setVisible(false);
        jComboBox_puntuacion_valoracion.setVisible(false);
        jScrollPane_comentario_valoracion.setVisible(false);
        jTextArea_comentario_valoracion.setVisible(false);
        jButton_guardar_valoracion.setVisible(false);
        jButton_cancelar_valoracion.setVisible(false);
    }

    /**
     * @brief   Método que muestra las etiquetas, campos de texto, combobox y botones de la parte modificable de la pestaña valoraciones
     */
    private void mostrarCamposValoraciones(){
        jLabel_ruta_valoracion.setVisible(true);
        jLabel_usuario_valoracion.setVisible(true);
        jLabel_puntuacion_valoracion.setVisible(true);
        jLabel_comentario_valoracion.setVisible(true);
        jComboBox_ruta_valoracion.setVisible(true);
        jComboBox_usuario_valoracion.setVisible(true);
        jComboBox_puntuacion_valoracion.setVisible(true);
        jScrollPane_comentario_valoracion.setVisible(true);
        jTextArea_comentario_valoracion.setVisible(true);
        jButton_guardar_valoracion.setVisible(true);
        jButton_cancelar_valoracion.setVisible(true);

        //Habilitar los campos que no se pueden modificar
        jComboBox_ruta_valoracion.setEnabled(true);
        jComboBox_usuario_valoracion.setEnabled(true);
    }

    /**
     * @brief   Método que oculta las etiquetas, campos de texto, combobox y botones de la parte modificable de la pestaña rutas
     */
    private void ocultarCamposRutas(){
        jLabel_nombre_ruta.setVisible(false);
        jTextField_nombre_ruta.setVisible(false);
        jLabel_distancia_ruta.setVisible(false);
        jTextField_distancia_ruta.setVisible(false);
        jLabel_tiempo_ruta.setVisible(false);
        jTextField_tiempo_ruta.setVisible(false);
        jLabel_descripcion_ruta.setVisible(false);
        jScrollPane_descripcion_ruta.setVisible(false);
        jTextArea_descripcion_ruta.setVisible(false);
        jLabel_dificultad_ruta.setVisible(false);
        jComboBox_dificultad_ruta.setVisible(false);
        jLabel_credor.setVisible(false);
        jComboBox_credor.setVisible(false);

        jButton_guardar_ruta.setVisible(false);
        jButton_cancelar_ruta.setVisible(false);

        //Mostrar tablas de info extra
        jLabel_valoraciones_ruta.setVisible(true);
        jScrollPane_valoraciones_ruta.setVisible(true);
        jLabel_categorias_ruta.setVisible(true);
        jScrollPane_categorias_ruta.setVisible(true);
    }

    /**
     * @brief   Método que muestra las etiquetas, campos de texto, combobox y botones de la parte modificable de la pestaña rutas
     */
    private void mostrarCamposRutas(){
        jLabel_nombre_ruta.setVisible(true);
        jTextField_nombre_ruta.setVisible(true);
        jLabel_distancia_ruta.setVisible(true);
        jTextField_distancia_ruta.setVisible(true);
        jLabel_tiempo_ruta.setVisible(true);
        jTextField_tiempo_ruta.setVisible(true);
        jLabel_descripcion_ruta.setVisible(true);
        jScrollPane_descripcion_ruta.setVisible(true);
        jTextArea_descripcion_ruta.setVisible(true);
        jLabel_dificultad_ruta.setVisible(true);
        jComboBox_dificultad_ruta.setVisible(true);
        jLabel_credor.setVisible(true);
        jComboBox_credor.setVisible(true);

        jButton_guardar_ruta.setVisible(true);
        jButton_cancelar_ruta.setVisible(true);

        //Ocultar tablas de info extra
        jLabel_valoraciones_ruta.setVisible(false);
        jScrollPane_valoraciones_ruta.setVisible(false);
        jLabel_categorias_ruta.setVisible(false);
        jScrollPane_categorias_ruta.setVisible(false);

        //Habilitar los campos que no se pueden modificar
        jTextField_nombre_ruta.setEnabled(true);
        jComboBox_credor.setEnabled(true);
    }

    /**
     * @brief   Método que oculta las etiquetas, campos de texto, combobox y botones de la parte modificable de la pestaña categorías
     */
    private void ocultarCamposFotosPerfil(){
        jLabel_usuario_foto_perfil.setVisible(false);
        jComboBox_usuario_foto_perfil.setVisible(false);
        jLabel_nombre_imagen_foto_perfil.setVisible(false);
        jTextField_nombre_imagen_foto_perfil.setVisible(false);
        jLabel_resolucion_foto_perfil.setVisible(false);
        jTextField_reolucion_foto_perfil.setVisible(false);
        jLabel_tamanio_foto_perfil.setVisible(false);
        jTextField_tamanio_foto_perfil.setVisible(false);

        jButton_guardar_foto_perfil.setVisible(false);
        jButton_cancelar_foto_perfil.setVisible(false);
    }

    /**
     * @brief   Método que muestra las etiquetas, campos de texto, combobox y botones de la parte modificable de la pestaña categorías
     */
    private void mostrarCamposFotosPerfil(){
        jLabel_usuario_foto_perfil.setVisible(true);
        jComboBox_usuario_foto_perfil.setVisible(true);
        jLabel_nombre_imagen_foto_perfil.setVisible(true);
        jTextField_nombre_imagen_foto_perfil.setVisible(true);
        jLabel_resolucion_foto_perfil.setVisible(true);
        jTextField_reolucion_foto_perfil.setVisible(true);
        jLabel_tamanio_foto_perfil.setVisible(true);
        jTextField_tamanio_foto_perfil.setVisible(true);

        jButton_guardar_foto_perfil.setVisible(true);
        jButton_cancelar_foto_perfil.setVisible(true);

        //Habilitar los campos que no se pueden modificar
        jComboBox_usuario_foto_perfil.setEnabled(true);
    }

    /**
     * @brief   Método que borra los datos de la tabla
     * @param modelo    Modelo de la tabla
     */
    private void LimpiarTabla(DefaultTableModel modelo){
        for(int i=0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
        }
    }
    
    /**
     * @brief   Método que pinta los datos de la tabla de categorías en la vista
     */
    public void pintarDatosCategoria(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_categoria.getModel();
        //Limpiar tabla
        LimpiarTabla(modelo);
        modelo.setRowCount(0);
        categorias = controladorVista.getListaCategoriasSistema();
        for (int i = 0; i < categorias.size(); i++) {
            Object[] fila = new Object[2];
            fila[0] = categorias.get(i).getIDCategoria();
            fila[1] = categorias.get(i).getNombreCategoria();
            modelo.addRow(fila);
        }
    }

    /**
     * @brief   Método que pinta los datos de la tabla de rutas en la vista
     */
    public void pintarDatosRuta(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_rutas.getModel();
        //Limpiar tabla
        LimpiarTabla(modelo);
        modelo.setRowCount(0);
        rutas = controladorVista.getListaRutasSistema();
        for (int i = 0; i < rutas.size(); i++) {
            Object[] fila = new Object[7];
            fila[0] = rutas.get(i).getNombreRuta();
            fila[1] = rutas.get(i).getDistanciaKm();
            fila[2] = rutas.get(i).getDificultad();
            fila[3] = rutas.get(i).getTiempoHoras();
            //Comprobar si es NaN
            if(Double.isNaN(rutas.get(i).getPuntuacionMedia())){
                fila[4] = "Sin valorar";
            }
            else{
                fila[4] = rutas.get(i).getPuntuacionMedia();
            }
            fila[5] = rutas.get(i).getDescripcion();
            fila[6] = rutas.get(i).getCreadorRuta().getDNI();
            modelo.addRow(fila);
        }

        //Establecer los valores del combobox de rutas
        jComboBox_ruta_valoracion.removeAllItems();
        for(int i = 0; i < controladorVista.getListaRutasSistema().size(); i++){
            jComboBox_ruta_valoracion.addItem(controladorVista.getListaRutasSistema().get(i));
        }
    }

    /**
     * @brief   Método que pinta los datos de la tabla de usuarios en la vista
     */
    public void pintarDatosUsuario(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_usuario.getModel();
        //Limpiar tabla
        LimpiarTabla(modelo);
        modelo.setRowCount(0);
        usuarios = controladorVista.getListaUsuariosSistema();
        for (int i = 0; i < usuarios.size(); i++) {
            Object[] fila = new Object[6];
            fila[0] = usuarios.get(i).getDNI();
            fila[1] = usuarios.get(i).getNombreUsuario();
            fila[2] = usuarios.get(i).getApellido1();
            fila[3] = usuarios.get(i).getApellido2();
            fila[4] = usuarios.get(i).getCorreoElectronico();
            //Si tiene foto de perfil
            if(usuarios.get(i).getFotoPerfil() != null){
                fila[5] = usuarios.get(i).getFotoPerfil().getIDfoto();
            }
            else{
                fila[5] = "Sin foto de perfil";
            }
            modelo.addRow(fila);
        }

        //Establecer los valores del combobox de credor
        jComboBox_credor.removeAllItems();
        for(int i = 0; i < controladorVista.getListaUsuariosSistema().size(); i++){
            jComboBox_credor.addItem(controladorVista.getListaUsuariosSistema().get(i).getDNI());
        }

        //Establecer los valores del combobox de usuarios
        jComboBox_usuario_valoracion.removeAllItems();
        for(int i = 0; i < controladorVista.getListaUsuariosSistema().size(); i++){
            jComboBox_usuario_valoracion.addItem(controladorVista.getListaUsuariosSistema().get(i).getDNI());
        }

        //Establecer los valores del combobox de usuarios que aún no tienen foto de perfil en fotos de perfil
        jComboBox_usuario_foto_perfil.removeAllItems();
        for(int i = 0; i < controladorVista.getListaUsuariosSistema().size(); i++){
            if(controladorVista.getListaUsuariosSistema().get(i).getFotoPerfil() == null){
                jComboBox_usuario_foto_perfil.addItem(controladorVista.getListaUsuariosSistema().get(i).getDNI());
            }
        }
    }

    /**
     * @brief   Método que pinta los datos de la tabla de valoraciones en la vista
     */
    public void pintarDatosValoracion(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_valoraciones.getModel();
        //Limpiar tabla
        LimpiarTabla(modelo);
        modelo.setRowCount(0);
        valoraciones = controladorVista.getListaValoracionesSistema();
        for (int i = 0; i < valoraciones.size(); i++) {
            Object[] fila = new Object[4];
            fila[0] = valoraciones.get(i).getRuta().getNombreRuta();
            fila[1] = valoraciones.get(i).getUsuario().getDNI();
            fila[2] = valoraciones.get(i).getPuntuacion();
            fila[3] = valoraciones.get(i).getComentario();
            modelo.addRow(fila);
        }
    }

    /**
     * @brief   Método que pinta los datos de la tabla de fotos de perfil en la vista
     */
    public void pintarDatosFotoPerfil(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_fotosPerfil.getModel();
        //Limpiar tabla
        LimpiarTabla(modelo);
        modelo.setRowCount(0);
        fotosPerfil = controladorVista.getListaFotosPerfilSistema();
        for (int i = 0; i < fotosPerfil.size(); i++) {
            Object[] fila = new Object[5];
            fila[0] = fotosPerfil.get(i).getIDfoto();
            fila[1] = fotosPerfil.get(i).getNombreImagen();
            fila[2] = fotosPerfil.get(i).getResolucionImagenMp();
            fila[3] = fotosPerfil.get(i).getTamanioKb();
            fila[4] = fotosPerfil.get(i).getUsuario().getDNI();
            modelo.addRow(fila);
        }
    }

    /**
     * @brief Método para cerrar la ventana, que solicita confirmación antes de cerrar
     * @param evt   Evento de ventana
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // Mostrar un cuadro de diálogo de confirmación
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar la aplicación?", "Cerrar aplicación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // Si el usuario confirma, cerrar la ventana y la aplicación
            try{
                controladorVista.getConector().desconectar();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Error al desconectar de la base de datos\n" + ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al desconectar de la base de datos\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            System.exit(0); 
        }
        else if(opcion == JOptionPane.NO_OPTION){
            // Si el usuario no confirma, no cerrar la ventana
            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_ruta = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_rutas = new javax.swing.JTable();
        jLabel_nombre_ruta = new javax.swing.JLabel();
        jTextField_nombre_ruta = new javax.swing.JTextField();
        jLabel_distancia_ruta = new javax.swing.JLabel();
        jTextField_distancia_ruta = new javax.swing.JTextField();
        jLabel_tiempo_ruta = new javax.swing.JLabel();
        jTextField_tiempo_ruta = new javax.swing.JTextField();
        jLabel_descripcion_ruta = new javax.swing.JLabel();
        jScrollPane_descripcion_ruta = new javax.swing.JScrollPane();
        jTextArea_descripcion_ruta = new javax.swing.JTextArea();
        jLabel_dificultad_ruta = new javax.swing.JLabel();
        jComboBox_dificultad_ruta = new javax.swing.JComboBox<>();
        jLabel_credor = new javax.swing.JLabel();
        jComboBox_credor = new javax.swing.JComboBox<>();
        jButton_aniadir_ruta = new javax.swing.JButton();
        jButton_modificar_ruta = new javax.swing.JButton();
        jButton_borrar_ruta = new javax.swing.JButton();
        jButton_guardar_ruta = new javax.swing.JButton();
        jButton_cancelar_ruta = new javax.swing.JButton();
        jLabel_valoraciones_ruta = new javax.swing.JLabel();
        jScrollPane_valoraciones_ruta = new javax.swing.JScrollPane();
        jTable_valoraciones_ruta = new javax.swing.JTable();
        jLabel_categorias_ruta = new javax.swing.JLabel();
        jScrollPane_categorias_ruta = new javax.swing.JScrollPane();
        jTable_categorias_ruta = new javax.swing.JTable();
        jComboBox_categoris_aniadibles_a_ruta = new javax.swing.JComboBox<>();
        jButton_aniadir_categoria_en_ruta = new javax.swing.JButton();
        jButton_borrar_categoria_en_ruta = new javax.swing.JButton();
        jButton_guardar_categoria_en_ruta = new javax.swing.JButton();
        jButton_confirmar_aniadir_categoria_en_ruta3 = new javax.swing.JButton();
        jPanel_usuario = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_usuario = new javax.swing.JTable();
        jLabel_dni_usuario = new javax.swing.JLabel();
        jTextField_dni_persona = new javax.swing.JTextField();
        jLabel_nombre_usuario = new javax.swing.JLabel();
        jTextField_nombre_usuario = new javax.swing.JTextField();
        jLabel_apellido1_usuario = new javax.swing.JLabel();
        jTextField_apellido1_usuario = new javax.swing.JTextField();
        jLabel_apellido2_usuario = new javax.swing.JLabel();
        jTextField_apellido2_usuario = new javax.swing.JTextField();
        jLabel_correo_usuario = new javax.swing.JLabel();
        jTextField_correo_usuario = new javax.swing.JTextField();
        jLabel_contrasenia_usuario = new javax.swing.JLabel();
        jPasswordField_contrasenia_usuario = new javax.swing.JPasswordField();
        jButton_aniadir_usuario = new javax.swing.JButton();
        jButton_modificar_usuario = new javax.swing.JButton();
        jButton_borrar_usuario = new javax.swing.JButton();
        jButton_guardar_usuario = new javax.swing.JButton();
        jButton_cancelar_usuario = new javax.swing.JButton();
        jLabel_valoraciones_usuario = new javax.swing.JLabel();
        jScrollPane_valoraciones_usuario = new javax.swing.JScrollPane();
        jTable_valoraciones_usuario = new javax.swing.JTable();
        jLabel_rutas_usuario = new javax.swing.JLabel();
        jScrollPane_rutas_usuario = new javax.swing.JScrollPane();
        jTable_rutas_usuario = new javax.swing.JTable();
        jPanel_valoraciones = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_valoraciones = new javax.swing.JTable();
        jLabel_ruta_valoracion = new javax.swing.JLabel();
        jLabel_usuario_valoracion = new javax.swing.JLabel();
        jLabel_puntuacion_valoracion = new javax.swing.JLabel();
        jButton_guardar_valoracion = new javax.swing.JButton();
        jButton_cancelar_valoracion = new javax.swing.JButton();
        jButton_borrar_valoracion = new javax.swing.JButton();
        jButton_aniadir_valoracion = new javax.swing.JButton();
        jLabel_comentario_valoracion = new javax.swing.JLabel();
        jScrollPane_comentario_valoracion = new javax.swing.JScrollPane();
        jTextArea_comentario_valoracion = new javax.swing.JTextArea();
        jComboBox_ruta_valoracion = new javax.swing.JComboBox<>();
        jComboBox_usuario_valoracion = new javax.swing.JComboBox<>();
        jComboBox_puntuacion_valoracion = new javax.swing.JComboBox<>();
        jButton_modificar_valoracion = new javax.swing.JButton();
        jPanel_categoria = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_categoria = new javax.swing.JTable();
        jLabel_nombre_categoria = new javax.swing.JLabel();
        jTextField_nombre_categoria = new javax.swing.JTextField();
        jButton_guardar_categoria = new javax.swing.JButton();
        jButton_cancelar_cantegoria = new javax.swing.JButton();
        jButton_aniadir_categoria = new javax.swing.JButton();
        jButton_borrar_categoria = new javax.swing.JButton();
        jButton_modificar_categoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_rutas_de_categoria = new javax.swing.JTable();
        jLabel_tabla_rutas_de_categoria = new javax.swing.JLabel();
        jButton_eliminar_ruta_de_categoria = new javax.swing.JButton();
        jButton_guardar_modificacion_categoria = new javax.swing.JButton();
        jButton_aniadir_ruta_de_categoria = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_confirmar_aniadir_ruta_de_categoria = new javax.swing.JButton();
        jPanel_fotosPerfil = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_fotosPerfil = new javax.swing.JTable();
        jLabel_usuario_foto_perfil = new javax.swing.JLabel();
        jComboBox_usuario_foto_perfil = new javax.swing.JComboBox<>();
        jLabel_nombre_imagen_foto_perfil = new javax.swing.JLabel();
        jTextField_nombre_imagen_foto_perfil = new javax.swing.JTextField();
        jLabel_resolucion_foto_perfil = new javax.swing.JLabel();
        jTextField_reolucion_foto_perfil = new javax.swing.JTextField();
        jLabel_tamanio_foto_perfil = new javax.swing.JLabel();
        jTextField_tamanio_foto_perfil = new javax.swing.JTextField();
        jButton_guardar_foto_perfil = new javax.swing.JButton();
        jButton_cancelar_foto_perfil = new javax.swing.JButton();
        jButton_borrar_foto_perfil = new javax.swing.JButton();
        jButton_aniadir_foto_perfil = new javax.swing.JButton();
        jButton_modificar_foto_perfil = new javax.swing.JButton();
        jButtonReestablecerDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable_rutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Distancia", "Dificultad", "Tiempo", "Puntuacion", "Descripcion", "Creador"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_rutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_rutasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_rutas);
        if (jTable_rutas.getColumnModel().getColumnCount() > 0) {
            jTable_rutas.getColumnModel().getColumn(0).setHeaderValue("Nombre");
            jTable_rutas.getColumnModel().getColumn(1).setResizable(false);
            jTable_rutas.getColumnModel().getColumn(1).setHeaderValue("Distancia");
            jTable_rutas.getColumnModel().getColumn(2).setResizable(false);
            jTable_rutas.getColumnModel().getColumn(2).setHeaderValue("Dificultad");
            jTable_rutas.getColumnModel().getColumn(3).setResizable(false);
            jTable_rutas.getColumnModel().getColumn(3).setHeaderValue("Tiempo");
            jTable_rutas.getColumnModel().getColumn(4).setHeaderValue("Puntuacion");
            jTable_rutas.getColumnModel().getColumn(5).setHeaderValue("Descripcion");
            jTable_rutas.getColumnModel().getColumn(6).setResizable(false);
            jTable_rutas.getColumnModel().getColumn(6).setHeaderValue("Creador");
        }

        jLabel_nombre_ruta.setText("Nombre:");

        jLabel_distancia_ruta.setText("Distancia (km):");

        jLabel_tiempo_ruta.setText("Tiempo (h):");

        jLabel_descripcion_ruta.setText("Descripción:");

        jTextArea_descripcion_ruta.setColumns(20);
        jTextArea_descripcion_ruta.setRows(5);
        jScrollPane_descripcion_ruta.setViewportView(jTextArea_descripcion_ruta);

        jLabel_dificultad_ruta.setText("Dificultad");

        jLabel_credor.setText("Creador");

        jButton_aniadir_ruta.setText("Añadir");
        jButton_aniadir_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_rutaActionPerformed(evt);
            }
        });

        jButton_modificar_ruta.setText("Modificar");
        jButton_modificar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_rutaActionPerformed(evt);
            }
        });

        jButton_borrar_ruta.setText("Borrar");
        jButton_borrar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_rutaActionPerformed(evt);
            }
        });

        jButton_guardar_ruta.setText("Guardar");
        jButton_guardar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_rutaActionPerformed(evt);
            }
        });

        jButton_cancelar_ruta.setText("Cancelar");
        jButton_cancelar_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_rutaActionPerformed(evt);
            }
        });

        jLabel_valoraciones_ruta.setText("Valoraciones de la ruta:");

        jTable_valoraciones_ruta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI Usuario", "Puntuación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_valoraciones_ruta.setViewportView(jTable_valoraciones_ruta);

        jLabel_categorias_ruta.setText("Categorías de la ruta:");

        jTable_categorias_ruta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID categoria", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_categorias_ruta.setViewportView(jTable_categorias_ruta);

        jComboBox_categoris_aniadibles_a_ruta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_categoris_aniadibles_a_ruta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_categoris_aniadibles_a_rutaMouseClicked(evt);
            }
        });

        jButton_aniadir_categoria_en_ruta.setText("Añadir categoria");
        jButton_aniadir_categoria_en_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_categoria_en_rutaActionPerformed(evt);
            }
        });

        jButton_borrar_categoria_en_ruta.setText("Borrar categoria");
        jButton_borrar_categoria_en_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_categoria_en_rutaActionPerformed(evt);
            }
        });

        jButton_guardar_categoria_en_ruta.setText("Cerrar modificar");
        jButton_guardar_categoria_en_ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_categoria_en_rutaActionPerformed(evt);
            }
        });

        jButton_confirmar_aniadir_categoria_en_ruta3.setText("Añadir ");
        jButton_confirmar_aniadir_categoria_en_ruta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_confirmar_aniadir_categoria_en_ruta3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_rutaLayout = new javax.swing.GroupLayout(jPanel_ruta);
        jPanel_ruta.setLayout(jPanel_rutaLayout);
        jPanel_rutaLayout.setHorizontalGroup(
            jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_rutaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_modificar_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_rutaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nombre_ruta)
                            .addComponent(jLabel_distancia_ruta)
                            .addComponent(jLabel_tiempo_ruta)
                            .addComponent(jLabel_descripcion_ruta))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                                .addComponent(jLabel_dificultad_ruta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox_dificultad_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_credor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_credor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_nombre_ruta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_distancia_ruta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_tiempo_ruta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane_descripcion_ruta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_categoris_aniadibles_a_ruta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_guardar_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_categoria_en_ruta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_categoria_en_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_guardar_categoria_en_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_confirmar_aniadir_categoria_en_ruta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_cancelar_ruta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane_categorias_ruta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane_valoraciones_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_valoraciones_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_categorias_ruta))
                                .addGap(0, 54, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel_rutaLayout.setVerticalGroup(
            jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_rutaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton_aniadir_ruta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_ruta))
                    .addGroup(jPanel_rutaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_nombre_ruta)
                        .addComponent(jTextField_nombre_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_valoraciones_ruta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_rutaLayout.createSequentialGroup()
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_distancia_ruta)
                                    .addComponent(jTextField_distancia_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_tiempo_ruta)
                                    .addComponent(jTextField_tiempo_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                                .addComponent(jButton_guardar_ruta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_cancelar_ruta)))
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(jComboBox_categoris_aniadibles_a_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_rutaLayout.createSequentialGroup()
                                        .addComponent(jScrollPane_descripcion_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_rutaLayout.createSequentialGroup()
                                        .addComponent(jButton_aniadir_categoria_en_ruta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton_borrar_categoria_en_ruta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_credor)
                                    .addComponent(jComboBox_credor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_dificultad_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_dificultad_ruta)
                                    .addComponent(jButton_guardar_categoria_en_ruta))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel_rutaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_descripcion_ruta)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel_rutaLayout.createSequentialGroup()
                        .addComponent(jScrollPane_valoraciones_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_rutaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_categorias_ruta)
                            .addComponent(jButton_confirmar_aniadir_categoria_en_ruta3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane_categorias_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        jTabbedPane.addTab("Rutas", jPanel_ruta);

        jTable_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellido1", "Apellido2", "Correo", "Foto perfil"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_usuarioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable_usuario);
        if (jTable_usuario.getColumnModel().getColumnCount() > 0) {
            jTable_usuario.getColumnModel().getColumn(0).setResizable(false);
            jTable_usuario.getColumnModel().getColumn(1).setResizable(false);
            jTable_usuario.getColumnModel().getColumn(2).setResizable(false);
            jTable_usuario.getColumnModel().getColumn(3).setResizable(false);
            jTable_usuario.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel_dni_usuario.setText("DNI:");

        jLabel_nombre_usuario.setText("Nombre:");

        jLabel_apellido1_usuario.setText("Apellido1:");

        jLabel_apellido2_usuario.setText("Apellido2:");

        jLabel_correo_usuario.setText("Correo:");

        jLabel_contrasenia_usuario.setText("Contraseña:");

        jButton_aniadir_usuario.setText("Añadir");
        jButton_aniadir_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_usuarioActionPerformed(evt);
            }
        });

        jButton_modificar_usuario.setText("Modificar");
        jButton_modificar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_usuarioActionPerformed(evt);
            }
        });

        jButton_borrar_usuario.setText("Borrar");
        jButton_borrar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_usuarioActionPerformed(evt);
            }
        });

        jButton_guardar_usuario.setText("Guardar");
        jButton_guardar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_usuarioActionPerformed(evt);
            }
        });

        jButton_cancelar_usuario.setText("Cancelar");
        jButton_cancelar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_usuarioActionPerformed(evt);
            }
        });

        jLabel_valoraciones_usuario.setText("Valoraciones del usuario:");

        jTable_valoraciones_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ruta", "Puntuación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_valoraciones_usuario.setViewportView(jTable_valoraciones_usuario);

        jLabel_rutas_usuario.setText("Rutas creadas por el usuario:");

        jTable_rutas_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ruta", "Ruta", "Km", "Horas", "Dificultad", "Puntuación media"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_rutas_usuario.setViewportView(jTable_rutas_usuario);

        javax.swing.GroupLayout jPanel_usuarioLayout = new javax.swing.GroupLayout(jPanel_usuario);
        jPanel_usuario.setLayout(jPanel_usuarioLayout);
        jPanel_usuarioLayout.setHorizontalGroup(
            jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_dni_usuario)
                    .addComponent(jLabel_nombre_usuario)
                    .addComponent(jLabel_apellido1_usuario)
                    .addComponent(jLabel_correo_usuario)
                    .addComponent(jLabel_apellido2_usuario)
                    .addComponent(jLabel_contrasenia_usuario))
                .addGap(24, 24, 24)
                .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_dni_persona, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jTextField_nombre_usuario)
                            .addComponent(jTextField_apellido1_usuario)
                            .addComponent(jTextField_apellido2_usuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_correo_usuario))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_guardar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_cancelar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane_valoraciones_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel_valoraciones_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane_rutas_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel_rutas_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addComponent(jPasswordField_contrasenia_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addGap(18, 18, 18)
                .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_modificar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(jButton_aniadir_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_borrar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61))
        );
        jPanel_usuarioLayout.setVerticalGroup(
            jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_usuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_aniadir_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_usuario)))
                .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_dni_usuario)
                            .addComponent(jTextField_dni_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_valoraciones_usuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_nombre_usuario)
                            .addComponent(jTextField_nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_guardar_usuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_apellido1_usuario)
                            .addComponent(jTextField_apellido1_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_cancelar_usuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_apellido2_usuario)
                            .addComponent(jTextField_apellido2_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_correo_usuario)
                            .addComponent(jTextField_correo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_contrasenia_usuario)
                            .addComponent(jPasswordField_contrasenia_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane_valoraciones_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_rutas_usuario)
                            .addGroup(jPanel_usuarioLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane_rutas_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(95, Short.MAX_VALUE))))
        );

        jTabbedPane.addTab("Usuarios", jPanel_usuario);

        jTable_valoraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ruta", "Usuario", "Puntuación", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable_valoraciones);
        if (jTable_valoraciones.getColumnModel().getColumnCount() > 0) {
            jTable_valoraciones.getColumnModel().getColumn(0).setHeaderValue("Ruta");
            jTable_valoraciones.getColumnModel().getColumn(1).setHeaderValue("Usuario");
            jTable_valoraciones.getColumnModel().getColumn(2).setHeaderValue("Puntuación");
            jTable_valoraciones.getColumnModel().getColumn(3).setHeaderValue("Comentario");
        }

        jLabel_ruta_valoracion.setText("Ruta:");

        jLabel_usuario_valoracion.setText("Usuario:");

        jLabel_puntuacion_valoracion.setText("Puntuación:");

        jButton_guardar_valoracion.setText("Guardar");
        jButton_guardar_valoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_valoracionActionPerformed(evt);
            }
        });

        jButton_cancelar_valoracion.setText("Cancelar");
        jButton_cancelar_valoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_valoracionActionPerformed(evt);
            }
        });

        jButton_borrar_valoracion.setText("Borrar");
        jButton_borrar_valoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_valoracionActionPerformed(evt);
            }
        });

        jButton_aniadir_valoracion.setText("Añadir");
        jButton_aniadir_valoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_valoracionActionPerformed(evt);
            }
        });

        jLabel_comentario_valoracion.setText("Comentario:");

        jTextArea_comentario_valoracion.setColumns(20);
        jTextArea_comentario_valoracion.setRows(5);
        jScrollPane_comentario_valoracion.setViewportView(jTextArea_comentario_valoracion);

        jComboBox_puntuacion_valoracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jButton_modificar_valoracion.setText("Modificar");
        jButton_modificar_valoracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_valoracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_valoracionesLayout = new javax.swing.GroupLayout(jPanel_valoraciones);
        jPanel_valoraciones.setLayout(jPanel_valoracionesLayout);
        jPanel_valoracionesLayout.setHorizontalGroup(
            jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_aniadir_valoracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_valoracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_modificar_valoracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_ruta_valoracion)
                            .addComponent(jLabel_usuario_valoracion)
                            .addComponent(jLabel_puntuacion_valoracion)
                            .addComponent(jLabel_comentario_valoracion))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane_comentario_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBox_puntuacion_valoracion, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE)
                                        .addComponent(jComboBox_usuario_valoracion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_guardar_valoracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_cancelar_valoracion, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                            .addComponent(jComboBox_ruta_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel_valoracionesLayout.setVerticalGroup(
            jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_valoracion)
                        .addGap(7, 7, 7)
                        .addComponent(jButton_modificar_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_valoracion))
                    .addGroup(jPanel_valoracionesLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ruta_valoracion)
                    .addComponent(jComboBox_ruta_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_usuario_valoracion)
                    .addComponent(jButton_guardar_valoracion)
                    .addComponent(jComboBox_usuario_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_puntuacion_valoracion)
                    .addComponent(jButton_cancelar_valoracion)
                    .addComponent(jComboBox_puntuacion_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_valoracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_comentario_valoracion)
                    .addComponent(jScrollPane_comentario_valoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Valoraciones", jPanel_valoraciones);

        jTable_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_categoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_categoria);
        if (jTable_categoria.getColumnModel().getColumnCount() > 0) {
            jTable_categoria.getColumnModel().getColumn(0).setResizable(false);
            jTable_categoria.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_nombre_categoria.setText("Nombre:");

        jButton_guardar_categoria.setText("Guardar");
        jButton_guardar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_categoriaActionPerformed(evt);
            }
        });

        jButton_cancelar_cantegoria.setText("Cancelar");
        jButton_cancelar_cantegoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_cantegoriaActionPerformed(evt);
            }
        });

        jButton_aniadir_categoria.setText("Añadir");
        jButton_aniadir_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_categoriaActionPerformed(evt);
            }
        });

        jButton_borrar_categoria.setText("Borrar");
        jButton_borrar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_categoriaActionPerformed(evt);
            }
        });

        jButton_modificar_categoria.setText("Modificar");
        jButton_modificar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_categoriaActionPerformed(evt);
            }
        });

        jTable_rutas_de_categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_ruta", "Nombre ruta", "Creador", "Valoración media"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_rutas_de_categoria);

        jLabel_tabla_rutas_de_categoria.setText("Rutas que pertenecen a esta categoría:");

        jButton_eliminar_ruta_de_categoria.setText("Quitar esta ruta");
        jButton_eliminar_ruta_de_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminar_ruta_de_categoriaActionPerformed(evt);
            }
        });

        jButton_guardar_modificacion_categoria.setText("Guardar modificación");
        jButton_guardar_modificacion_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_modificacion_categoriaActionPerformed(evt);
            }
        });

        jButton_aniadir_ruta_de_categoria.setText("Añadir una ruta");
        jButton_aniadir_ruta_de_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_ruta_de_categoriaActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jButton_confirmar_aniadir_ruta_de_categoria.setText("Añadir");
        jButton_confirmar_aniadir_ruta_de_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_confirmar_aniadir_ruta_de_categoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_categoriaLayout = new javax.swing.GroupLayout(jPanel_categoria);
        jPanel_categoria.setLayout(jPanel_categoriaLayout);
        jPanel_categoriaLayout.setHorizontalGroup(
            jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_aniadir_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_modificar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel_nombre_categoria)
                        .addGap(41, 41, 41)
                        .addComponent(jTextField_nombre_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_cancelar_cantegoria, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_guardar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                        .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel_tabla_rutas_de_categoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_eliminar_ruta_de_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_guardar_modificacion_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_ruta_de_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jButton_confirmar_aniadir_ruta_de_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel_categoriaLayout.setVerticalGroup(
            jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_categoria)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_nombre_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_guardar_categoria))
                    .addComponent(jLabel_nombre_categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_cancelar_cantegoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jLabel_tabla_rutas_de_categoria)
                .addGap(18, 18, 18)
                .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_categoriaLayout.createSequentialGroup()
                        .addGroup(jPanel_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_confirmar_aniadir_ruta_de_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_aniadir_ruta_de_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_eliminar_ruta_de_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_guardar_modificacion_categoria)))
                .addGap(29, 29, 29))
        );

        jTabbedPane.addTab("Categorias", jPanel_categoria);

        jTable_fotosPerfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID foto", "Nombre imagen ", "Resolución (Mp) ", "Tamaño (Kb) ", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable_fotosPerfil);
        if (jTable_fotosPerfil.getColumnModel().getColumnCount() > 0) {
            jTable_fotosPerfil.getColumnModel().getColumn(0).setResizable(false);
            jTable_fotosPerfil.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_usuario_foto_perfil.setText("Usuario:");

        jLabel_nombre_imagen_foto_perfil.setText("Nombre imagen");

        jLabel_resolucion_foto_perfil.setText("Resolución (Mp)");

        jLabel_tamanio_foto_perfil.setText("Tamaño (Kb)");

        jButton_guardar_foto_perfil.setText("Guardar");
        jButton_guardar_foto_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_foto_perfilActionPerformed(evt);
            }
        });

        jButton_cancelar_foto_perfil.setText("Cancelar");
        jButton_cancelar_foto_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_foto_perfilActionPerformed(evt);
            }
        });

        jButton_borrar_foto_perfil.setText("Borrar");
        jButton_borrar_foto_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_foto_perfilActionPerformed(evt);
            }
        });

        jButton_aniadir_foto_perfil.setText("Añadir");
        jButton_aniadir_foto_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_foto_perfilActionPerformed(evt);
            }
        });

        jButton_modificar_foto_perfil.setText("Modificar");
        jButton_modificar_foto_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_foto_perfilActionPerformed(evt);
            }
        });

        jButtonReestablecerDatos.setBackground(new java.awt.Color(255, 0, 0));
        jButtonReestablecerDatos.setForeground(new java.awt.Color(0, 0, 0));
        jButtonReestablecerDatos.setText("Reestablecer datos desde copia");
        jButtonReestablecerDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReestablecerDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_fotosPerfilLayout = new javax.swing.GroupLayout(jPanel_fotosPerfil);
        jPanel_fotosPerfil.setLayout(jPanel_fotosPerfilLayout);
        jPanel_fotosPerfilLayout.setHorizontalGroup(
            jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_fotosPerfilLayout.createSequentialGroup()
                .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_fotosPerfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_aniadir_foto_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_foto_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_modificar_foto_perfil)))
                    .addGroup(jPanel_fotosPerfilLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_usuario_foto_perfil)
                            .addComponent(jLabel_nombre_imagen_foto_perfil)
                            .addComponent(jLabel_resolucion_foto_perfil)
                            .addComponent(jLabel_tamanio_foto_perfil))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_tamanio_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_usuario_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_reolucion_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_nombre_imagen_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReestablecerDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_guardar_foto_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_cancelar_foto_perfil, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel_fotosPerfilLayout.setVerticalGroup(
            jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_fotosPerfilLayout.createSequentialGroup()
                .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_fotosPerfilLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_foto_perfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_foto_perfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_foto_perfil))
                    .addGroup(jPanel_fotosPerfilLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_usuario_foto_perfil)
                    .addComponent(jComboBox_usuario_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_guardar_foto_perfil)
                    .addComponent(jLabel_nombre_imagen_foto_perfil)
                    .addComponent(jTextField_nombre_imagen_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_cancelar_foto_perfil)
                    .addComponent(jLabel_resolucion_foto_perfil)
                    .addComponent(jTextField_reolucion_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_fotosPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_tamanio_foto_perfil)
                    .addComponent(jTextField_tamanio_foto_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jButtonReestablecerDatos)
                .addGap(34, 34, 34))
        );

        jTabbedPane.addTab("Fotos de Perfil", jPanel_fotosPerfil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Ciudad");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de borrar de la pestaña categoria
     * @param evt   Evento
     * @post    Se borra la categoria seleccionada de la tabla
     *          Se actualiza la tabla
     *          Se elimina del array de categorías del sistema
     *          Se actualiza la base de datos
     */
    private void jButton_borrar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_categoriaActionPerformed
        if (jTable_categoria.getSelectedRow() != -1) {
            int fila = jTable_categoria.getSelectedRow();
            Integer id = (Integer) jTable_categoria.getValueAt(fila, 0);

            try{
                controladorVista.borrarCategoria(id);
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al borrar la categoria. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error al borrar la categoria", "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            pintarDatosCategoria();
            pintarDatosRuta();
        } 
        else {
                JOptionPane.showMessageDialog(this, "Selecciona una categoria", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_borrar_categoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de añadir de la pestaña categoria
     * @param evt   Evento
     * @post    Se hacen visibles los botones de guardar y cancelar y el campo de texto
     *          Se inhabilitan los botones de añadir, modificar y borrar
     */
    private void jButton_aniadir_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_categoriaActionPerformed
        //Modificar variable de estado
        aniadiendo=true;
        //Hacer visibles los botones de guardar y cancelar
        mostrarCamposCategorias();
        //Inhabilitar los botones de añadir y borrar
        jButton_aniadir_categoria.setEnabled(false);
        jButton_borrar_categoria.setEnabled(false);
        jButton_modificar_categoria.setEnabled(false);
    }//GEN-LAST:event_jButton_aniadir_categoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de cancelar de la pestaña categoria
     * @param evt   Evento
     * @post    Se ocultan los botones de guardar y cancelar y el campo de texto
     *          Se habilitan los botones de añadir, modificar y borrar
     */
    private void jButton_cancelar_cantegoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_cantegoriaActionPerformed
        //Ocultar los botones de guardar y cancelar y el campo de texto
        ocultarCamposCategorias();
        //Habilitar los botones de añadir, modificar y borrar
        jButton_aniadir_categoria.setEnabled(true);
        jButton_borrar_categoria.setEnabled(true);
        jButton_modificar_categoria.setEnabled(true);

        //Borrar los datos del campo de texto
        jTextField_nombre_categoria.setText("");

        //Modificar variable de estado
        aniadiendo=false;
        modificando=false;
    }//GEN-LAST:event_jButton_cancelar_cantegoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar de la pestaña categoria
     * @param evt   Evento
     * @post    Se añade la categoria al sistema si no existe ya
     *          Se actualiza la tabla
     *          Se actualiza la base de datos
     */
    private void jButton_guardar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_categoriaActionPerformed
        //Comprobar que el nombre no está vacío
        if (jTextField_nombre_categoria.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        //Comprobar que el nombre contiene al menos una letra
        else if (!jTextField_nombre_categoria.getText().matches(".*[a-zA-Z]+.*")) {
                JOptionPane.showMessageDialog(this, "El nombre debe contener al menos una letra", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Comprobar que no exista el nombre en la tabla
            boolean existe = false;
            String nombreLimpio = jTextField_nombre_categoria.getText().toUpperCase().trim();
            for (Categoria categoria : controladorVista.getListaCategoriasSistema()) {
                if (categoria.getNombreCategoria().toUpperCase().trim().equals(nombreLimpio)) {
                    existe = true;
                }
            }
            if (existe) {
                    JOptionPane.showMessageDialog(this, "Ya existe una categoria con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                //Añadir la categoria al sistema
                try{
                    controladorVista.aniadirCategoria(jTextField_nombre_categoria.getText());
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Error al añadir la categoria", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //Pintar los datos de la categoria
                pintarDatosCategoria();
                //Ocultar los botones de guardar y cancelar y el campo de texto
                ocultarCamposCategorias();
                //Habilitar los botones de añadir, modificar y borrar
                jButton_aniadir_categoria.setEnabled(true);
                jButton_borrar_categoria.setEnabled(true);
                jButton_modificar_categoria.setEnabled(true);
                //Borrar los datos del campo de texto
                jTextField_nombre_categoria.setText("");
                //Modificar variable de estado
                aniadiendo=false;
                modificando=false;
            }
        }
    }//GEN-LAST:event_jButton_guardar_categoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de modificar de la pestaña categoria
     * @param evt   Evento
     */
    private void jButton_modificar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_categoriaActionPerformed
        //Comprobar si hay una fila seleccionada
        if (jTable_categoria.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una categoria", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Modificar variable de estado
            modificando=true;
            //Inhabilitar los botones de añadir, modificar y borrar
            jButton_aniadir_categoria.setEnabled(false);
            jButton_modificar_categoria.setEnabled(false);
            jButton_borrar_categoria.setEnabled(false);
            
            //Mostrar los botones de eliminar ruta y guardar modificacion
            jButton_eliminar_ruta_de_categoria.setVisible(true);
            jButton_guardar_modificacion_categoria.setVisible(true);
            jButton_aniadir_ruta_de_categoria.setVisible(true);

        }
    }//GEN-LAST:event_jButton_modificar_categoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de eliminar ruta de la pestaña categoria
     * @param evt   Evento
     */
    private void jButton_eliminar_ruta_de_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminar_ruta_de_categoriaActionPerformed
        //Comprobar que haya alguna fila seleccionada en la tabla de rutas de categoria
        if (jTable_rutas_de_categoria.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una ruta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Categoría seleccionada en la tabla de arriba
            int filaCat = jTable_categoria.getSelectedRow();
            Integer idCategoria = (Integer) jTable_categoria.getValueAt(filaCat, 0);

            //Eliminar esa fila de la tabla
            int fila = jTable_rutas_de_categoria.getSelectedRow();
            Integer id = (Integer) jTable_rutas_de_categoria.getValueAt(fila, 0);
            String nombre = (String) jTable_rutas_de_categoria.getValueAt(fila, 1);
            try{
                controladorVista.eliminarRutaDeCategoria(id, idCategoria);
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al eliminar la ruta de la categoria. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al eliminar la ruta de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            }
            pintarDatosRuta();
            pintarDatosCategoria();
            //Actualizar la tabla de rutas de categoria
            jTable_categoriaMouseClicked(null);        
        }
    }//GEN-LAST:event_jButton_eliminar_ruta_de_categoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar modificacion de la pestaña categoria
     * @param evt   Evento
     */
    private void jButton_guardar_modificacion_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_modificacion_categoriaActionPerformed
        //Ocultar los botones de eliminar ruta y guardar modificacion
        jButton_eliminar_ruta_de_categoria.setVisible(false);
        jButton_guardar_modificacion_categoria.setVisible(false);
        jButton_aniadir_ruta_de_categoria.setVisible(false);
        jComboBox1.setVisible(false);
        jButton_confirmar_aniadir_ruta_de_categoria.setVisible(false);

        //Habilitar los botones
        jButton_aniadir_categoria.setEnabled(true);
        jButton_modificar_categoria.setEnabled(true);
        jButton_borrar_categoria.setEnabled(true);
        jButton_aniadir_ruta_de_categoria.setEnabled(true);
        jButton_eliminar_ruta_de_categoria.setEnabled(true);

        //Modificar variable de estado
        modificando=false;
    }//GEN-LAST:event_jButton_guardar_modificacion_categoriaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se clica sobre el botón Añadir una ruta de la pestaña Categorías
     */
    private void jButton_aniadir_ruta_de_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_ruta_de_categoriaActionPerformed
        //Rellenar el combobox con las rutas que no están en la categoría
        actualizarComboBoxRutasAniadibles();
        //Mostrar combobox de rutas
        jComboBox1.setVisible(true);
        //Mostrar botón de confirmar
        jButton_confirmar_aniadir_ruta_de_categoria.setVisible(true);
        //Inhabilitar añadir y quitar
        jButton_aniadir_ruta_de_categoria.setEnabled(false);
        jButton_eliminar_ruta_de_categoria.setEnabled(false);
    }//GEN-LAST:event_jButton_aniadir_ruta_de_categoriaActionPerformed

    /**
     * @brief Metodo que actualiza las rutas añadibles para la categoría seleccionada
     */
    private void actualizarComboBoxRutasAniadibles(){
        jComboBox1.removeAllItems();
        Categoria categoria = null;
        for(Categoria categoriaAux : controladorVista.getListaCategoriasSistema()){
            if(categoriaAux.getIDCategoria().equals(jTable_categoria.getValueAt(jTable_categoria.getSelectedRow(), 0))){
                categoria = categoriaAux;
            }
        }

        for(Ruta ruta : controladorVista.getListaRutasSistema()){
            boolean existe = false;
            for(Categoria categoriaAux : ruta.getListaCategorias()){
                if(categoriaAux.getIDCategoria().equals(categoria.getIDCategoria())){
                    existe = true;
                }
            }
            if(!existe){
                jComboBox1.addItem(ruta.getNombreRuta());
            }
        }
    }

    // ComboBox de rutas añadibles a la categoría
    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        //TODO eliminar
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton_confirmar_aniadir_ruta_de_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_confirmar_aniadir_ruta_de_categoriaActionPerformed
        if(jComboBox1.getItemCount() != 0){
            //Encontrar la ruta seleccionada
            Ruta ruta = null;
            for(Ruta rutaAux : controladorVista.getListaRutasSistema()){
                if(rutaAux.getNombreRuta().equals(jComboBox1.getSelectedItem().toString())){
                    ruta = rutaAux;
                }
            }
            //Encontrar la categoría seleccionada
            int fila = jTable_categoria.getSelectedRow();
            Categoria categoria = null;
            for(Categoria categoriaAux : controladorVista.getListaCategoriasSistema()){
                if(categoriaAux.getIDCategoria().equals(jTable_categoria.getValueAt(jTable_categoria.getSelectedRow(), 0))){
                    categoria = categoriaAux;
                }
            }
            //Comprobar que la ruta no esté ya en la categoría
            boolean existe = false;
            for(Ruta rutaAux : categoria.getListaRutas()){
                if(rutaAux.getNombreRuta().equals(ruta.getNombreRuta())){
                    existe = true;
                }
            }
            if(existe){
                JOptionPane.showMessageDialog(this, "La ruta ya está en la categoría", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                //Añadir la ruta a la categoría
                try{
                    controladorVista.aniadirRutaACategoria(ruta, categoria);
                }
                catch(SQLException sqle){
                    JOptionPane.showMessageDialog(this, "Error al añadir la ruta a la categoría. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Error inesperado al añadir la ruta a la categoría", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //Actualizar la tabla de categorías de la ruta
                actualizarTablaRutasDeCategoria();
                //Pintar la tabla de rutas
                pintarDatosRuta();
                //Pintar la tabla de categorías
                pintarDatosCategoria();
            }

            //Ocultar combobox
            jComboBox1.setVisible(false);

            //Ocultar este botón
            jButton_confirmar_aniadir_ruta_de_categoria.setVisible(false);

            //Habilitar añadir y quitar
            jButton_aniadir_ruta_de_categoria.setEnabled(true);
            jButton_eliminar_ruta_de_categoria.setEnabled(true);

            //Seleccionar en la tabla de categorías la categoría seleccionada
            jTable_categoria.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_jButton_confirmar_aniadir_ruta_de_categoriaActionPerformed


    /**
     * @brief Metodo que se ejecuta cuando se clica sobre una fila de la tabla de categorias
     * @param evt   Evento
     */
    private void jTable_categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_categoriaMouseClicked
        //Si hay una fila seleccionada
        if(jTable_categoria.getSelectedRow() != -1){
            //Hacer la tabla de rutas de la categoria visible
            jScrollPane1.setVisible(true);
            jLabel_tabla_rutas_de_categoria.setVisible(true);
            //Actualizar la tabla de rutas de la categoria
            actualizarTablaRutasDeCategoria();
        }
    }//GEN-LAST:event_jTable_categoriaMouseClicked

    /**
     * @brief Metodo que actualiza la información mostrada en la tabla de rutas de la categoría seleccionada en la tabla superior
     * @pre     La tabla de categorias tiene una fila seleccionada
     * @post    Se actualiza la tabla de rutas de la categoría seleccionada
     */
    private void actualizarTablaRutasDeCategoria(){
        Integer id = (Integer) jTable_categoria.getValueAt(jTable_categoria.getSelectedRow(), 0);
        DefaultTableModel model = (DefaultTableModel) jTable_rutas_de_categoria.getModel();
        model.setRowCount(0);
        for(Ruta ruta : controladorVista.getListaRutasSistema()){
            for(Categoria categoria : ruta.getListaCategorias()){
                if(categoria.getIDCategoria() == id){
                    model.addRow(new Object[]{ruta.getIdRuta(), ruta.getNombreRuta(), ruta.getCreadorRuta().getDNI(), ruta.getPuntuacionMedia()});
                }
            }
        }
        actualizarComboBoxRutasAniadibles();
    }

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de gurdar de la pestaña valoracion
     * @param evt   Evento
     */
    private void jButton_guardar_valoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_valoracionActionPerformed
        //Comprobar que no exista la valoración
        boolean existe = false;
        for(Valoracion valoracion : controladorVista.getListaValoracionesSistema()){
            if(jComboBox_ruta_valoracion.getSelectedItem().toString().contains(valoracion.getRuta().getNombreRuta()) 
                && jComboBox_ruta_valoracion.getSelectedItem().toString().contains(valoracion.getRuta().getCreadorRuta().getDNI()) 
                && jComboBox_usuario_valoracion.getSelectedItem().toString().equals(valoracion.getUsuario().getDNI())){
                existe = true;
            }
        }

        if(existe&&aniadiendo){
            JOptionPane.showMessageDialog(this, "Ya existe una valoración para ese usuario y esa ruta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int valoracion = Integer.parseInt(jComboBox_puntuacion_valoracion.getSelectedItem().toString());
            Ruta ruta = null;
            for(Ruta rutaAux : controladorVista.getListaRutasSistema()){
                if(jComboBox_ruta_valoracion.getSelectedItem().toString().contains(rutaAux.getNombreRuta()) && jComboBox_ruta_valoracion.getSelectedItem().toString().contains(rutaAux.getCreadorRuta().getDNI())){
                    ruta = rutaAux;
                }
            }
            if(!existe && aniadiendo){
                //Añadir la valoración al sistema
                try{
                    controladorVista.aniadirValoracion(ruta, jComboBox_usuario_valoracion.getSelectedItem().toString(), valoracion, jTextArea_comentario_valoracion.getText());
                }
                catch(SQLException sqle){
                    JOptionPane.showMessageDialog(this, "Error al añadir la valoración. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    try{
                        controladorVista.getConector().getConexion().rollback();
                        controladorVista.getConector().getConexion().setAutoCommit(true);
                    }
                    catch(SQLException sqle2){
                        JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Error inesperado al añadir la valoración", "Error", JOptionPane.ERROR_MESSAGE);
                    try{
                        controladorVista.getConector().getConexion().rollback();
                        controladorVista.getConector().getConexion().setAutoCommit(true);
                    }
                    catch(SQLException sqle2){
                        JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else if(modificando){
                //Modificar la valoración en el sistema
                try{
                    controladorVista.modificarValoracion(ruta, jComboBox_usuario_valoracion.getSelectedItem().toString(), valoracion, jTextArea_comentario_valoracion.getText());
                }
                catch(SQLException sqle){
                    JOptionPane.showMessageDialog(this, "Error al modificar la valoración. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Error inesperado al modificar la valoración", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            //Pintar los datos de la valoración
            pintarDatosValoracion();
            pintarDatosUsuario();
            pintarDatosRuta();

            //Ocultar los botones de guardar y cancelar y campos de texto
            ocultarCamposValoraciones();

            //Habilitar los botones de añadir, modificar y borrar
            jButton_aniadir_valoracion.setEnabled(true);
            jButton_borrar_valoracion.setEnabled(true);
            jButton_modificar_valoracion.setEnabled(true);

            //Vaciar campos de texto
            jComboBox_ruta_valoracion.setSelectedIndex(0);
            jComboBox_usuario_valoracion.setSelectedIndex(0);
            jComboBox_puntuacion_valoracion.setSelectedIndex(0);
            jTextArea_comentario_valoracion.setText("");

            //Modificar variable de estado
            aniadiendo=false;
            modificando=false;
        }
    }//GEN-LAST:event_jButton_guardar_valoracionActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de cancelar de la pestaña valoracion
     * @param evt   Evento
     */
    private void jButton_cancelar_valoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_valoracionActionPerformed
        //Ocultar los botones y campos
        ocultarCamposValoraciones();

        //Habilitar los botones de añadir, modificar y borrar
        jButton_aniadir_valoracion.setEnabled(true);
        jButton_borrar_valoracion.setEnabled(true);
        jButton_modificar_valoracion.setEnabled(true);

        //Vaciar campos de texto
        jComboBox_ruta_valoracion.setSelectedIndex(0);
        jComboBox_usuario_valoracion.setSelectedIndex(0);
        jComboBox_puntuacion_valoracion.setSelectedIndex(0);
        jTextArea_comentario_valoracion.setText("");

        //Modificar variable de estado
        aniadiendo=false;
        modificando=false;
    }//GEN-LAST:event_jButton_cancelar_valoracionActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de modificar de la pestaña valoración
     * @param evt   Evento
     */
    private void jButton_modificar_valoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_valoracionActionPerformed
        //Comprobar si hay una fila seleccionada
        if(jTable_valoraciones.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una valoración", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Modificar la variable de estado
            modificando=true;

            //Inhabilitar los botones de añadir, modificar y borrar
            jButton_aniadir_valoracion.setEnabled(false);
            jButton_modificar_valoracion.setEnabled(false);
            jButton_borrar_valoracion.setEnabled(false);

            //Hacer visible la parte modificable
            mostrarCamposValoraciones();

            //Inhabilitar los campos que no se pueden modificar
            jComboBox_ruta_valoracion.setEnabled(false);
            jComboBox_usuario_valoracion.setEnabled(false);

            //Colocar sus datos en los campos
            int fila = jTable_valoraciones.getSelectedRow();
            Ruta ruta = null;
            for(Valoracion valoracion : controladorVista.getListaValoracionesSistema()){
                if(valoracion.getRuta().getNombreRuta().equals((String) jTable_valoraciones.getValueAt(fila, 0)) && valoracion.getUsuario().getDNI().equals((String) jTable_valoraciones.getValueAt(fila, 1)) && valoracion.getPuntuacion() == (int) jTable_valoraciones.getValueAt(fila, 2) && valoracion.getComentario().equals((String) jTable_valoraciones.getValueAt(fila, 3))){
                    ruta = valoracion.getRuta();
                }
            }
            jComboBox_ruta_valoracion.setSelectedItem(ruta);
            jComboBox_usuario_valoracion.setSelectedItem((String) jTable_valoraciones.getValueAt(fila, 1));
            jComboBox_puntuacion_valoracion.setSelectedItem((int) jTable_valoraciones.getValueAt(fila, 2) + "");
            jTextArea_comentario_valoracion.setText((String) jTable_valoraciones.getValueAt(fila, 3));
        }
    }//GEN-LAST:event_jButton_modificar_valoracionActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de borrar de la pestaña valoracion
     * @param evt   Evento
     */
    private void jButton_borrar_valoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_valoracionActionPerformed
        //Comprobar que hay una fila seleccionada
        if(jTable_valoraciones.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una valoración", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Borrar la valoración del sistema
            int fila = jTable_valoraciones.getSelectedRow();
            try{    
                controladorVista.borrarValoracion((String) jTable_valoraciones.getValueAt(fila, 0), (String) jTable_valoraciones.getValueAt(fila, 1));
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al borrar la valoración. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al borrar la valoración", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //Pintar los datos de la valoración
            pintarDatosValoracion();
            pintarDatosUsuario();
            pintarDatosRuta();
        }
    }//GEN-LAST:event_jButton_borrar_valoracionActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de añadir de la pestaña valoracion
     * @param evt   Evento
     */
    private void jButton_aniadir_valoracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_valoracionActionPerformed
        //Comprobar que el combobox de usuarios tenga opciones elegibles
        if(jComboBox_usuario_valoracion.getItemCount() == 0){
            JOptionPane.showMessageDialog(this, "No hay usuarios en el sistema para realizar valoraciones", "Acción no disponible", JOptionPane.INFORMATION_MESSAGE);
        }
        //Comprobar que el combobox de rutas tenga opciones elegibles
        else if(jComboBox_ruta_valoracion.getItemCount() == 0){
            JOptionPane.showMessageDialog(this, "No hay rutas en el sistema para realizar valoraciones", "Acción no disponible", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            //Modificar la variable de estado
            aniadiendo=true;

            //Hacer visibles los botones de guardar y cancelar y campos de texto
            mostrarCamposValoraciones();

            //Inhabilitar botones de añadir, modificar y borrar
            jButton_aniadir_valoracion.setEnabled(false);
            jButton_borrar_valoracion.setEnabled(false);
            jButton_modificar_valoracion.setEnabled(false);

            //Vaciar campos de texto
            jComboBox_ruta_valoracion.setSelectedIndex(0);
            jComboBox_usuario_valoracion.setSelectedIndex(0);
            jComboBox_puntuacion_valoracion.setSelectedIndex(0);
            jTextArea_comentario_valoracion.setText("");
        }
    }//GEN-LAST:event_jButton_aniadir_valoracionActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar de la pestaña foto perfil
     * @param evt   Evento
     */
    private void jButton_guardar_foto_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_foto_perfilActionPerformed
        //Comprobar que no esté vacío el campo del nombre
        if(jTextField_nombre_imagen_foto_perfil.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el tamaño no esté vacío
        else if(jTextField_tamanio_foto_perfil.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El tamaño no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el tamaño es un número entero
        else if(!jTextField_tamanio_foto_perfil.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "El tamaño debe ser un número entero positivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el tamaño es mayor que cero
        else if(Integer.valueOf(jTextField_tamanio_foto_perfil.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "El tamaño debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que la resolución no esté vacía
        else if(jTextField_reolucion_foto_perfil.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "La resolución no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que es un entero
        else if(!jTextField_reolucion_foto_perfil.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "La resolución debe ser un número entero positivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que es mayor que cero
        else if(Integer.valueOf(jTextField_reolucion_foto_perfil.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "La resolución debe ser mayor que cero", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            //Comprobar que el usuario seleccionado no tenga ya foto de perfil
            boolean existe = false;

            for(FotoPerfil fotoPerfil : controladorVista.getListaFotosPerfilSistema()){
                if(fotoPerfil.getUsuario().getDNI().equals(jComboBox_usuario_foto_perfil.getSelectedItem().toString())){
                    existe = true;
                }
            }

            if(existe && aniadiendo){
                JOptionPane.showMessageDialog(this, "Este usuario ya tiene foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                if(!existe && aniadiendo){
                    //Añadir la foto al sistema
                    try{
                        controladorVista.aniadirFotoPerfil(jComboBox_usuario_foto_perfil.getSelectedItem().toString(), jTextField_nombre_imagen_foto_perfil.getText(), Integer.valueOf(jTextField_reolucion_foto_perfil.getText()), Integer.valueOf(jTextField_tamanio_foto_perfil.getText()));
                    }
                    catch(SQLException sqle){
                        JOptionPane.showMessageDialog(this, "Error al añadir la foto de perfil + \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                        try{
                            controladorVista.getConector().getConexion().rollback();
                            controladorVista.getConector().getConexion().setAutoCommit(true);
                        }
                        catch(SQLException sqle2){
                            JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error al añadir la foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
                        try{
                            controladorVista.getConector().getConexion().rollback();
                            controladorVista.getConector().getConexion().setAutoCommit(true);
                        }
                        catch(SQLException sqle2){
                            JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else if(modificando){
                    //Modificar la foto en el sistema
                    try{
                        controladorVista.modificarFotoPerfil(jComboBox_usuario_foto_perfil.getSelectedItem().toString(), jTextField_nombre_imagen_foto_perfil.getText(), Integer.valueOf(jTextField_reolucion_foto_perfil.getText()), Integer.valueOf(jTextField_tamanio_foto_perfil.getText()));
                    }
                    catch(SQLException sqle){
                        JOptionPane.showMessageDialog(this, "Error al modificar la foto de perfil + \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error al modificar la foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                //Pintar los datos de la foto
                pintarDatosFotoPerfil();
                pintarDatosUsuario();

                //Ocultar los botones y campos
                ocultarCamposFotosPerfil();

                //Habilitar los botones de añadir y borrar
                jButton_aniadir_foto_perfil.setEnabled(true);
                jButton_borrar_foto_perfil.setEnabled(true);
                jButton_modificar_foto_perfil.setEnabled(true);

                //Vaciar campos de texto
                jComboBox_usuario_foto_perfil.setSelectedIndex(0);
                jTextField_nombre_imagen_foto_perfil.setText("");
                jTextField_tamanio_foto_perfil.setText("");
                jTextField_reolucion_foto_perfil.setText("");

                //Modificar variable de estado
                aniadiendo=false;
                modificando=false;
            }
        }
    }//GEN-LAST:event_jButton_guardar_foto_perfilActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de cancelar de la pestaña foto perfil
     * @param evt   Evento
     */
    private void jButton_cancelar_foto_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_foto_perfilActionPerformed
        //Vaciar los campos
        jComboBox_usuario_foto_perfil.setSelectedIndex(0);
        jTextField_nombre_imagen_foto_perfil.setText("");
        jTextField_tamanio_foto_perfil.setText("");
        jTextField_reolucion_foto_perfil.setText("");

        //Ocultarlos
        ocultarCamposFotosPerfil();

        //Habilitar los botones de añadir y borrar
        jButton_aniadir_foto_perfil.setEnabled(true);
        jButton_borrar_foto_perfil.setEnabled(true);
        jButton_modificar_foto_perfil.setEnabled(true);

        //Modificar variable de estado
        aniadiendo=false;
        modificando=false;
    }//GEN-LAST:event_jButton_cancelar_foto_perfilActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de borrar de la pestaña foto perfil
     * @param evt   Evento
     */
    private void jButton_borrar_foto_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_foto_perfilActionPerformed
        // Comprobar que hay una fila seleccionada
        if(jTable_fotosPerfil.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Borrar la foto de perfil del sistema
            int fila = jTable_fotosPerfil.getSelectedRow();
            try{
                controladorVista.borrarFotoPerfil((Integer) jTable_fotosPerfil.getValueAt(fila, 0));
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al borrar la foto de perfil. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al borrar la foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            //Pintar los datos de la foto de perfil
            pintarDatosFotoPerfil();
            pintarDatosUsuario();
        }
    }//GEN-LAST:event_jButton_borrar_foto_perfilActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de añadir de la pestaña foto perfil
     * @param evt   Evento
     */
    private void jButton_aniadir_foto_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_foto_perfilActionPerformed
        //Comprobar que el combobox de usuarios tenga opciones elegibles
        if(jComboBox_usuario_foto_perfil.getItemCount() == 0){
            JOptionPane.showMessageDialog(this, "Todos los usuarios del sistema tienen asignada una foto de perfil", "Acción no disponible", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            //Hacer visibles los campos
            mostrarCamposFotosPerfil();

            //Inhabilitar los botones de añadir y borrar
            jButton_aniadir_foto_perfil.setEnabled(false);
            jButton_borrar_foto_perfil.setEnabled(false);
            jButton_modificar_foto_perfil.setEnabled(false);

            //Modificar variable de estado
            aniadiendo=true;
        }
    }//GEN-LAST:event_jButton_aniadir_foto_perfilActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de modificar de la pestaña foto perfil
     * @param evt   Evento
     */
    private void jButton_modificar_foto_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_foto_perfilActionPerformed
        //Comprobar si hay una fila seleccionada
        if(jTable_fotosPerfil.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una foto de perfil", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Modificar la variable de estado
            modificando=true;

            //Inhabilitar los botones de añadir, modificar y borrar
            jButton_aniadir_foto_perfil.setEnabled(false);
            jButton_modificar_foto_perfil.setEnabled(false);
            jButton_borrar_foto_perfil.setEnabled(false);

            //Hacer visible la parte modificable
            mostrarCamposFotosPerfil();

            //Inhabilitar los campos que no se pueden modificar
            jComboBox_usuario_foto_perfil.setEnabled(false);

            //Modificar seleccionables del combobox por todos los usuarios
            jComboBox_usuario_foto_perfil.removeAllItems();
            for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                jComboBox_usuario_foto_perfil.addItem(usuario.getDNI());
            }

            //Colocar sus datos en los campos
            int fila = jTable_fotosPerfil.getSelectedRow();
            jComboBox_usuario_foto_perfil.setSelectedItem((String) jTable_fotosPerfil.getValueAt(fila, 4));
            jTextField_nombre_imagen_foto_perfil.setText((String) jTable_fotosPerfil.getValueAt(fila, 1));
            jTextField_tamanio_foto_perfil.setText((int) jTable_fotosPerfil.getValueAt(fila, 2) + "");
            jTextField_reolucion_foto_perfil.setText((int) jTable_fotosPerfil.getValueAt(fila, 3) + "");
        }
    }//GEN-LAST:event_jButton_modificar_foto_perfilActionPerformed

        /**
         * @brief Metodo que se ejecuta cuando se pulsa el boton de cancelar de la pestaña usuario
         * @param evt   Evento
         */
    private void jButton_cancelar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_usuarioActionPerformed
        //Ocultar los botones de guardar y cancelar y el campo de texto
        ocultarCamposUsuarios();

        //Habilitar los botones de añadir, modificar y borrar
        jButton_aniadir_usuario.setEnabled(true);
        jButton_modificar_usuario.setEnabled(true);
        jButton_borrar_usuario.setEnabled(true);

        //Poner a false variables de estado
        modificando=false;
        aniadiendo=false;
    }//GEN-LAST:event_jButton_cancelar_usuarioActionPerformed

        /**
         * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar de la pestaña usuario
         * @param evt   Evento
         */
    private void jButton_guardar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_usuarioActionPerformed
        //Comprobar que el DNI no está vacío
        if(jTextField_dni_persona.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El DNI no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el DNI tiene 8 números y una letra correcta
        else if(!controladorVista.comprobarFormatoDNICorrecto(jTextField_dni_persona.getText())){
            JOptionPane.showMessageDialog(this, "El DNI no tiene un formato correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el nombre no está vacío
        else if(jTextField_nombre_usuario.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el apellido 1 no esté vacío
        else if(jTextField_apellido1_usuario.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El apellido 1 no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el correo no esté vacío
        else if(jTextField_correo_usuario.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "El correo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que el correo sea correcto
        else if(!controladorVista.comprobarFormatoCorreoCorrecto(jTextField_correo_usuario.getText())){
            JOptionPane.showMessageDialog(this, "El correo debe tener un formato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //Comprobar que la contraseña no esté vacía
        else if(jPasswordField_contrasenia_usuario.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "La contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Comprobar que no exista el DNI en la tabla
            boolean existe = false;
            String dniLimpio = jTextField_dni_persona.getText().toUpperCase().trim();
            for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                if(usuario.getDNI().toUpperCase().trim().equals(dniLimpio)){
                    existe = true;
                }
            }
            if(existe && aniadiendo){
                JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(!existe && aniadiendo){
                    //Añadir el usuario al sistema
                    try{
                        controladorVista.aniadirUsuario(jTextField_dni_persona.getText(), jTextField_nombre_usuario.getText(), jTextField_apellido1_usuario.getText(), jTextField_apellido2_usuario.getText(), jTextField_correo_usuario.getText(), jPasswordField_contrasenia_usuario.getText());
                    }
                    catch(SQLException ex){
                        JOptionPane.showMessageDialog(this, "Error al añadir el usuario\n" + ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error inesperado al añadir el usuario\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(modificando){
                    //Modificar el usuario en el sistema
                    try{
                        controladorVista.modificarUsuario(jTextField_dni_persona.getText(), jTextField_apellido1_usuario.getText(), jTextField_apellido2_usuario.getText(), jTextField_correo_usuario.getText(), jPasswordField_contrasenia_usuario.getText());
                    }
                    catch(SQLException ex){
                        JOptionPane.showMessageDialog(this, "Error al modificar el usuario\nCódigo: " + ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error inesperado al modificar el usuario\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                //Pintar los datos del usuario
                pintarDatosUsuario();
                //Ocultar los botones de guardar y cancelar y el campo de texto
                ocultarCamposUsuarios();
                //Habilitar los botones de añadir, modificar y borrar
                jButton_aniadir_usuario.setEnabled(true);
                jButton_modificar_usuario.setEnabled(true);
                jButton_borrar_usuario.setEnabled(true);
                //Borrar los datos del campo de texto
                jTextField_dni_persona.setText("");
                jTextField_nombre_usuario.setText("");
                jTextField_apellido1_usuario.setText("");
                jTextField_apellido2_usuario.setText("");
                jTextField_correo_usuario.setText("");
                jPasswordField_contrasenia_usuario.setText("");
                //Poner a false variables de estado
                modificando=false;
                aniadiendo=false;

                //Actualizar los combobox de usuarios
                jComboBox_credor.removeAllItems();
                for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                    jComboBox_credor.addItem(usuario.getDNI());
                }

                jComboBox_usuario_valoracion.removeAllItems();
                for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                    jComboBox_usuario_valoracion.addItem(usuario.getDNI());
                }

                jComboBox_usuario_foto_perfil.removeAllItems();
                for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                    jComboBox_usuario_foto_perfil.addItem(usuario.getDNI());
                }
            }
        }
    }//GEN-LAST:event_jButton_guardar_usuarioActionPerformed

        /**
         * @brief Metodo que se ejecuta cuando se pulsa el boton de borrar de la pestaña usuario
         * @param evt   Evento
         */
    private void jButton_borrar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_usuarioActionPerformed
        //Comprobar que hay una fila seleccionada
        if (jTable_usuario.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Borrar el usuario del sistema
            int fila = jTable_usuario.getSelectedRow();
            String dni = (String) jTable_usuario.getValueAt(fila, 0);

            try{
                controladorVista.borrarUsuario(dni);
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al borrar el usuario\nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al borrar el usuario\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            //Actualizar los combobox de usuarios
            jComboBox_credor.removeAllItems();
            for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                jComboBox_credor.addItem(usuario.getDNI());
            }

            jComboBox_usuario_valoracion.removeAllItems();
            for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                jComboBox_usuario_valoracion.addItem(usuario.getDNI());
            }

            jComboBox_usuario_foto_perfil.removeAllItems();
            for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                jComboBox_usuario_foto_perfil.addItem(usuario.getDNI());
            }

            //Pintar los datos del usuario
            pintarDatosUsuario();
            pintarDatosFotoPerfil();
            pintarDatosRuta();
            pintarDatosValoracion();

        }
    }//GEN-LAST:event_jButton_borrar_usuarioActionPerformed

        /**
         * @brief Metodo que se ejecuta cuando se pulsa el boton de modificar de la pestaña usuario
         * @param evt   Evento
         */
    private void jButton_modificar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_usuarioActionPerformed
        //Comprobar si hay una fila seleccionada
        if (jTable_usuario.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            //Modificar variable de estado
            modificando=true;

            //Inhabilitar los botones de añadir, modificar y borrar
            jButton_aniadir_usuario.setEnabled(false);
            jButton_modificar_usuario.setEnabled(false);
            jButton_borrar_usuario.setEnabled(false);

            //Hacer visibles los campos
            mostrarCamposUsuarios();

            //Colocar sus datos en los campos
            int fila = jTable_usuario.getSelectedRow();
            jTextField_dni_persona.setText((String) jTable_usuario.getValueAt(fila, 0));
            jTextField_nombre_usuario.setText((String) jTable_usuario.getValueAt(fila, 1));
            jTextField_apellido1_usuario.setText((String) jTable_usuario.getValueAt(fila, 2));
            jTextField_apellido2_usuario.setText((String) jTable_usuario.getValueAt(fila, 3));
            jTextField_correo_usuario.setText((String) jTable_usuario.getValueAt(fila, 4));

            jPasswordField_contrasenia_usuario.setText("********");

            //Inhabilitar los campos que no se pueden modificar
            jTextField_dni_persona.setEnabled(false);
            jTextField_nombre_usuario.setEnabled(false);
        }
    }//GEN-LAST:event_jButton_modificar_usuarioActionPerformed

        /**
         * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar de la pestaña usuario
         * @param evt   Evento
         * @post    Se añade el usuario al sistema si no existe ya
         *          Se actualiza la tabla
         *          Se actualiza la base de datos
         */
    private void jButton_aniadir_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_usuarioActionPerformed
        //Modificar variable de estado
        aniadiendo=true;

        //Hacer visibles los botones de guardar y cancelar y campos de texto
        mostrarCamposUsuarios();

        //Habilitar campos nombre y dni
        jTextField_dni_persona.setEnabled(true);
        jTextField_nombre_usuario.setEnabled(true);

        //Inhabilitar los botones de añadir, modificar y borrar
        jButton_aniadir_usuario.setEnabled(false);
        jButton_modificar_usuario.setEnabled(false);
        jButton_borrar_usuario.setEnabled(false);

        //Borrar los datos de los campos de texto
        jTextField_dni_persona.setText("");
        jTextField_nombre_usuario.setText("");
        jTextField_apellido1_usuario.setText("");
        jTextField_apellido2_usuario.setText("");
        jTextField_correo_usuario.setText("");
        jPasswordField_contrasenia_usuario.setText("");
    }//GEN-LAST:event_jButton_aniadir_usuarioActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se clica sobre una fila de la tabla de usuarios
     * @param evt   Evento
     */
    private void jTable_usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_usuarioMouseClicked
        //Comprobar que haya una fila seleccionada
        if(jTable_usuario.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona un usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Hacer visibles las tablas de rutas y valoraciones
            jLabel_rutas_usuario.setVisible(true);
            jScrollPane_rutas_usuario.setVisible(true);
            jLabel_valoraciones_usuario.setVisible(true);
            jScrollPane_valoraciones_usuario.setVisible(true);

            //Encontrar el usuario seleccionado
            int fila = jTable_usuario.getSelectedRow();
            String dni = (String) jTable_usuario.getValueAt(fila, 0);
            Usuario usuario = null;
            for(Usuario usuarioAux : controladorVista.getListaUsuariosSistema()){
                if(usuarioAux.getDNI().equals(dni)){
                    usuario = usuarioAux;
                }
            }

            //Pintar la tabla de valoraciones
            DefaultTableModel model2 = (DefaultTableModel) jTable_valoraciones_usuario.getModel();
            model2.setRowCount(0);
            for(Valoracion valoracion : usuario.getListaValoraciones()){
                model2.addRow(new Object[]{valoracion.getRuta().toString(), valoracion.getPuntuacion()});
            }

            //Pintar la tabla de rutas
            DefaultTableModel model = (DefaultTableModel) jTable_rutas_usuario.getModel();
            model.setRowCount(0);
            for(Ruta ruta : usuario.getListaRutas()){
                model.addRow(new Object[]{ruta.getIdRuta(), ruta.toString(), ruta.getDistanciaKm(), ruta.getTiempoHoras(), ruta.getDificultad(), ruta.getPuntuacionMedia()});
            }
        }
    }//GEN-LAST:event_jTable_usuarioMouseClicked

    private void jComboBox_categoris_aniadibles_a_rutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_categoris_aniadibles_a_rutaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_categoris_aniadibles_a_rutaMouseClicked

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de cancelar de la pestaña ruta
     * @param evt   Evento
     */
    private void jButton_cancelar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_rutaActionPerformed
        //Ocultar los botones de guardar y cancelar y campos de texto
        ocultarCamposRutas();

        //Habilitar los botones de añadir, modificar y borrar
        jButton_aniadir_ruta.setEnabled(true);
        jButton_borrar_ruta.setEnabled(true);
        jButton_modificar_ruta.setEnabled(true);

        //Vaciar campos de texto
        jTextField_nombre_ruta.setText("");
        jTextField_distancia_ruta.setText("");
        jTextField_tiempo_ruta.setText("");
        jComboBox_dificultad_ruta.setSelectedIndex(0);

        //Ocultar
        jLabel_categorias_ruta.setVisible(false);
        jScrollPane_categorias_ruta.setVisible(false);
        jButton_aniadir_categoria_en_ruta.setVisible(false);
        jButton_borrar_categoria_en_ruta.setVisible(false);
        jButton_confirmar_aniadir_categoria_en_ruta3.setVisible(false);
        jButton_guardar_categoria_en_ruta.setVisible(false);
        jComboBox_categoris_aniadibles_a_ruta.setVisible(false);

        //Habilitar la tabla de rutas
        jTable_rutas.setEnabled(true);

        //Modificar variable de estado
        aniadiendo=false;
        modificando=false;
    }//GEN-LAST:event_jButton_cancelar_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar de la pestaña ruta
     * @param evt   Evento
     * @post    Se añade la ruta al sistema si no existe ya
     *          Se actualiza la tabla
     *          Se actualiza la base de datos
     */
    private void jButton_guardar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_rutaActionPerformed
        boolean correcto = true;
        //Comprobar que el nombre no está vacío
        if (jTextField_nombre_ruta.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            correcto = false;
        }
        if(aniadiendo){
            //Comprobar que la distancia no está vacía
            if (jTextField_distancia_ruta.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "La distancia no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
            //Comprobar que el tiempo no está vacío
            else if (jTextField_tiempo_ruta.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "El tiempo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
            //Comprobar que tiempo y distancia son doubles
            try{
                Double.valueOf(jTextField_distancia_ruta.getText());
                Double.valueOf(jTextField_tiempo_ruta.getText());

                //Compobar que tiempo y distancia son positivos
                if(Double.parseDouble(jTextField_distancia_ruta.getText()) <= 0.0){
                    JOptionPane.showMessageDialog(this, "La distancia debe ser positiva", "Error", JOptionPane.ERROR_MESSAGE);
                    correcto = false;
                }
                if(Double.parseDouble(jTextField_tiempo_ruta.getText()) <= 0.0){
                    JOptionPane.showMessageDialog(this, "El tiempo debe ser positivo", "Error", JOptionPane.ERROR_MESSAGE);
                    correcto = false;
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "La distancia y el tiempo deben ser números", "Error", JOptionPane.ERROR_MESSAGE);
                correcto = false;
            }
        }
        if(correcto){
            //Comprobar que no exista ya la ruta
            boolean existe = false;
            for(Ruta ruta : controladorVista.getListaRutasSistema()){
                if(ruta.getIdRuta().equals(controladorVista.getIDrutaSistema(jTextField_nombre_ruta.getText(), controladorVista.getIdUsuarioSistema(jComboBox_credor.getSelectedItem().toString())))){
                    existe = true;
                }
            }
            if(existe && aniadiendo){
                JOptionPane.showMessageDialog(this, "Ya existe una ruta con ese nombre para ese usuario creador", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(!existe && aniadiendo){
                    //Añadir la ruta al sistema
                    try{
                        controladorVista.aniadirRuta(jTextField_nombre_ruta.getText(), jTextArea_descripcion_ruta.getText(), Double.parseDouble(jTextField_distancia_ruta.getText()), Double.parseDouble(jTextField_tiempo_ruta.getText()), jComboBox_dificultad_ruta.getSelectedItem().toString(), jComboBox_credor.getSelectedItem().toString());
                    }
                    catch(SQLException ex){
                        JOptionPane.showMessageDialog(this, "Error al añadir la ruta\n" + ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error inesperado al añadir la ruta\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(modificando){
                    //Modificar la ruta en el sistema
                    try{
                        controladorVista.modificarRuta(jTextField_nombre_ruta.getText(), jTextArea_descripcion_ruta.getText(), jComboBox_dificultad_ruta.getSelectedItem().toString(), jComboBox_credor.getSelectedItem().toString());
                    }
                    catch(SQLException ex){
                        JOptionPane.showMessageDialog(this, "Error al modificar la ruta\nCódigo: " + ex.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Error inesperado al modificar la ruta\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                //Pintar los datos de la ruta
                pintarDatosRuta();
                pintarDatosCategoria();
                pintarDatosValoracion();
                pintarDatosUsuario();

                //Ocultar los botones de guardar y cancelar y campos de texto
                ocultarCamposRutas();

                //Ocultar
                jLabel_categorias_ruta.setVisible(false);
                jScrollPane_categorias_ruta.setVisible(false);
                jButton_aniadir_categoria_en_ruta.setVisible(false);
                jButton_borrar_categoria_en_ruta.setVisible(false);
                jButton_confirmar_aniadir_categoria_en_ruta3.setVisible(false);
                jButton_guardar_categoria_en_ruta.setVisible(false);
                jComboBox_categoris_aniadibles_a_ruta.setVisible(false);

                //Habilitar los botones de añadir, modificar y borrar
                jButton_aniadir_ruta.setEnabled(true);
                jButton_borrar_ruta.setEnabled(true);
                jButton_modificar_ruta.setEnabled(true);

                //Habilitar la tabla de rutas
                jTable_rutas.setEnabled(true);

                //Vaciar campos de texto
                jTextField_nombre_ruta.setText("");
                jTextField_distancia_ruta.setText("");
                jTextField_tiempo_ruta.setText("");
                jTextArea_descripcion_ruta.setText("");
                jComboBox_dificultad_ruta.setSelectedIndex(0);

                //Modificar variable de estado
                aniadiendo=false;
                modificando=false;

                //Actualizar combobox rutas
                jComboBox_ruta_valoracion.removeAllItems();
                for(int i = 0; i < controladorVista.getListaRutasSistema().size(); i++){
                    jComboBox_ruta_valoracion.addItem(controladorVista.getListaRutasSistema().get(i));
                }
            }
        }
    }//GEN-LAST:event_jButton_guardar_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de borrar de la pestaña ruta
     * @param evt   Evento
     */
    private void jButton_borrar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_rutaActionPerformed
        //Comprobar que hay una fila seleccionada
        if(jTable_rutas.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una ruta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Borrar la ruta del sistema
            int fila = jTable_rutas.getSelectedRow();
            String nombre = (String) jTable_rutas.getValueAt(fila, 0);
            String creador = (String) jTable_rutas.getValueAt(fila, 6);
            
            try{
                controladorVista.borrarRuta(nombre, creador);
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al borrar la ruta\nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al borrar la ruta\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                try{
                    controladorVista.getConector().getConexion().rollback();
                    controladorVista.getConector().getConexion().setAutoCommit(true);
                }
                catch(SQLException sqle2){
                    JOptionPane.showMessageDialog(this, "Error al hacer rollback\nCódigo: " + sqle2.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            //Pintar los datos de la ruta
            pintarDatosRuta();
            pintarDatosCategoria();
            pintarDatosValoracion();
            pintarDatosUsuario();
        }
    }//GEN-LAST:event_jButton_borrar_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de modificar de la pestaña ruta
     * @param evt  Evento
     */
    private void jButton_modificar_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_rutaActionPerformed
        //Comprobar si hay una fila seleccionada
        if(jTable_rutas.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una ruta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Modificar la variable de estado
            modificando=true;

            //Inhabilitar los botones de añadir, modificar y borrar
            jButton_aniadir_ruta.setEnabled(false);
            jButton_modificar_ruta.setEnabled(false);
            jButton_borrar_ruta.setEnabled(false);

            //Hacer visible la parte modificable
            mostrarCamposRutas();
            jLabel_categorias_ruta.setVisible(true);
            jScrollPane_categorias_ruta.setVisible(true);
            jButton_aniadir_categoria_en_ruta.setVisible(true);
            jButton_borrar_categoria_en_ruta.setVisible(true);
            jButton_guardar_categoria_en_ruta.setVisible(true);

            //Hacer invisible lo que no se puede modificar
            jLabel_distancia_ruta.setVisible(false);
            jTextField_distancia_ruta.setVisible(false);
            jLabel_tiempo_ruta.setVisible(false);
            jTextField_tiempo_ruta.setVisible(false);

            jTextField_nombre_ruta.setEnabled(false);
            jComboBox_credor.setEnabled(false);

            //Colocar sus datos en los campos
            int fila = jTable_rutas.getSelectedRow();
            jTextField_nombre_ruta.setText((String) jTable_rutas.getValueAt(fila, 0));
            jTextArea_descripcion_ruta.setText((String) jTable_rutas.getValueAt(fila, 5));
            jComboBox_dificultad_ruta.setSelectedItem((String) jTable_rutas.getValueAt(fila, 2));
            jComboBox_credor.setSelectedItem((String) jTable_rutas.getValueAt(fila, 6));

            //Inhabilitar los campos que no se pueden modificar
            jTextField_nombre_ruta.setEnabled(false);
            jComboBox_credor.setEnabled(false);

            //Hacer invisible info extra
            jLabel_valoraciones_ruta.setVisible(false);
            jScrollPane_valoraciones_ruta.setVisible(false);

            //Inhabilitar la tabla de rutas
            jTable_rutas.setEnabled(false);
        }
    }//GEN-LAST:event_jButton_modificar_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de añadir categoria de la pestaña ruta
     * @param evt   Evento
     */
    private void jButton_aniadir_categoria_en_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_categoria_en_rutaActionPerformed
        //Inhabilitar este botón y borrar
        jButton_aniadir_categoria_en_ruta.setEnabled(false);
        jButton_borrar_categoria_en_ruta.setEnabled(false);
        //Hacer visible el combobox
        jComboBox_categoris_aniadibles_a_ruta.setVisible(true);
        //Actualizar el combobox
        actualizarComboBoxCategoriasAniadibles();
        //Hacer visible el botón de confirmar
        jButton_confirmar_aniadir_categoria_en_ruta3.setVisible(true);
        //Haer visible el botón de guardar
        jButton_guardar_categoria_en_ruta.setVisible(true);
    }                                                                 

    /**
     * @brief Metodo que actualiza los datos del combobox de categorías añadibles a la ruta
     * @post   Se actualiza el combobox con las categorías que no están en la ruta seleccionada
     */
    private void actualizarComboBoxCategoriasAniadibles(){
        //Vaciar el combobox
        jComboBox_categoris_aniadibles_a_ruta.removeAllItems();
        Ruta ruta = null;
        Integer idRuta = controladorVista.getIDrutaSistema(jTextField_nombre_ruta.getText(), controladorVista.getIdUsuarioSistema(jComboBox_credor.getSelectedItem().toString()));
        for(Ruta rutaAux : controladorVista.getListaRutasSistema()){
            if(rutaAux.getIdRuta().equals(idRuta)){
                ruta = rutaAux;
            }
        }

        //Añadir las categorías que no están en la ruta
        for(Categoria categoria : controladorVista.getListaCategoriasSistema()){
            boolean existe = false;
            for(Categoria categoriaAux : ruta.getListaCategorias()){
                if(categoriaAux.getNombreCategoria().equals(categoria.getNombreCategoria())){
                    existe = true;
                }
            }
            if(!existe){
                jComboBox_categoris_aniadibles_a_ruta.addItem(categoria.getNombreCategoria());
            }
        }
    }//GEN-LAST:event_jButton_aniadir_categoria_en_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de borrar categoria de la pestaña ruta
     * @param evt   Evento
     */
    private void jButton_borrar_categoria_en_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_categoria_en_rutaActionPerformed
        //Comprobamos que hay una fila seleccionada
        if(jTable_categorias_ruta.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Borrar la categoría de la ruta
            int fila = jTable_categorias_ruta.getSelectedRow();
            Integer idCategoria = (Integer) jTable_categorias_ruta.getValueAt(fila, 0);
            Integer idRuta = controladorVista.getIDrutaSistema(jTextField_nombre_ruta.getText(), controladorVista.getIdUsuarioSistema(jComboBox_credor.getSelectedItem().toString()));
            try{
                controladorVista.eliminarRutaDeCategoria(idRuta, idCategoria);
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al eliminar la ruta de la categoría\nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al eliminar la ruta de la categoría\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //Pintar los datos de la ruta
            pintarDatosRuta();
            pintarDatosCategoria();
            //Haer visible el botón guardar
            jButton_guardar_categoria_en_ruta.setVisible(true);
        }
    }//GEN-LAST:event_jButton_borrar_categoria_en_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de cerrar modificar de la pestaña ruta
     * @param evt   Evento
     */
    private void jButton_guardar_categoria_en_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_categoria_en_rutaActionPerformed
        //Habilitar añadir y borrar
        jButton_aniadir_categoria_en_ruta.setEnabled(true);
        jButton_borrar_categoria_en_ruta.setEnabled(true);
        //Hacer invisible el combobox
        jComboBox_categoris_aniadibles_a_ruta.setVisible(false);
        //Hacer invisible el botón de confirmar
        jButton_confirmar_aniadir_categoria_en_ruta3.setVisible(false);
        //Hacer invisible el botón de guardar
        jButton_guardar_categoria_en_ruta.setVisible(false);
    }//GEN-LAST:event_jButton_guardar_categoria_en_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de añadir junto a las categorias de la ruta de la pestaña ruta
     * @param evt   Evento
     */
    private void jButton_confirmar_aniadir_categoria_en_ruta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_confirmar_aniadir_categoria_en_ruta3ActionPerformed
        //Comprobar que hay una categoría seleccionada
        if(jComboBox_categoris_aniadibles_a_ruta.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Selecciona una categoría", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //Comprobar qué ruta estamos modificando
            Ruta ruta = null;
            ruta = controladorVista.getRutaSistema(jTextField_nombre_ruta.getText(), jComboBox_credor.getSelectedItem().toString());
            int fila = jTable_rutas.getSelectedRow();
            for(int i=0; i < jTable_rutas.getRowCount(); i++){
                if(jTable_rutas.getValueAt(i, 0).equals(ruta.getNombreRuta()) && jTable_rutas.getValueAt(i, 6).equals(ruta.getCreadorRuta().getDNI())){
                    fila = i;
                }
            }

            //Encontrar la categoría seleccionada
            Categoria categoria = null;
            for(Categoria categoriaAux : controladorVista.getListaCategoriasSistema()){
                if(categoriaAux.getNombreCategoria().equals(jComboBox_categoris_aniadibles_a_ruta.getSelectedItem().toString())){
                    categoria = categoriaAux;
                }
            }

            //Comprobar que la categoría no está ya en la ruta
            boolean existe = false;
            for(Categoria categoriaAux : ruta.getListaCategorias()){
                if(categoriaAux.getNombreCategoria().equals(categoria.getNombreCategoria())){
                    existe = true;
                }
            }

            if(existe){
                JOptionPane.showMessageDialog(this, "La categoría ya está añadida a la ruta", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                //Añadir la categoría a la ruta
                try{
                    controladorVista.aniadirRutaACategoria(ruta, categoria);
                }
                catch(SQLException sqle){
                    JOptionPane.showMessageDialog(this, "Error al añadir la ruta a la categoría. \nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Error inesperado al añadir la ruta a la categoría", "Error", JOptionPane.ERROR_MESSAGE);
                }
                //Pintar los datos de la ruta
                pintarDatosRuta();
                pintarDatosCategoria();
                //Actulizar el combobox de categorías añadibles
                actualizarComboBoxCategoriasAniadibles();
                actualizarTablaCategoriasDeRuta();
                
                //Habilitar añadir y borrar
                jButton_aniadir_categoria_en_ruta.setEnabled(true);
                jButton_borrar_categoria_en_ruta.setEnabled(true);
                //Hacer invisible el combobox
                jComboBox_categoris_aniadibles_a_ruta.setVisible(false);
                //Hacer invisible el botón de confirmar
                jButton_confirmar_aniadir_categoria_en_ruta3.setVisible(false);
                //Hacer invisible el botón de guardar
                jButton_guardar_categoria_en_ruta.setVisible(false);

                //Seleccionar en la tabla de rutas la ruta que se estaba modificando
                jTable_rutas.setRowSelectionInterval(fila, fila);
            }
        }
    }//GEN-LAST:event_jButton_confirmar_aniadir_categoria_en_ruta3ActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de guardar de la pestaña ruta
     * @param evt   Evento
     * @post    Se añade la ruta al sistema si no existe ya
     *          Se actualiza la tabla
     *          Se actualiza la base de datos 
     */
    private void jButton_aniadir_rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_rutaActionPerformed
        //Comprobar que el combobox de creador tiene opciones seleccionables
        if(jComboBox_credor.getItemCount() == 0){
            JOptionPane.showMessageDialog(this, "No hay usuarios en el sistema que puedan crear rutas", "Acción no disponible", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            //Modificar variable de estado
            aniadiendo=true;

            //Hacer visibles los botones de guardar y cancelar y campos de texto
            mostrarCamposRutas();

            //Inhabilitar los botones de añadir y borrar
            jButton_aniadir_ruta.setEnabled(false);
            jButton_borrar_ruta.setEnabled(false);
            jButton_modificar_ruta.setEnabled(false);

            //Vaciar campos de texto
            jTextField_nombre_ruta.setText("");
            jTextField_distancia_ruta.setText("");
            jTextField_tiempo_ruta.setText("");
            jComboBox_dificultad_ruta.setSelectedIndex(0);

            //Ocultar info extra
            jLabel_valoraciones_ruta.setVisible(false);
            jScrollPane_valoraciones_ruta.setVisible(false);
            jLabel_categorias_ruta.setVisible(false);
            jScrollPane_categorias_ruta.setVisible(false);
        }
    }//GEN-LAST:event_jButton_aniadir_rutaActionPerformed

    /**
     * @brief Metodo que se ejecuta cuando se pulsa el boton de reestablecer datos
     */
    private void jButtonReestablecerDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReestablecerDatosActionPerformed
        String backup = "C:\\Users\\belen\\Documents\\NetBeansProjects\\BRC-2DAM-AD\\tema-2-sql-BelenBRC\\rutas\\DatabaseFile.sql";


        //Preguntar si se quiere reestablecer los datos
        int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres reestablecer los datos?\nEsta acción eliminará todas las modificaciones y cargará los datos de la última copia de seguridad.", "Reestablecer datos", JOptionPane.YES_NO_OPTION);
        if(opcion == JOptionPane.YES_OPTION){
            try{
                controladorVista.getConector().recuperarBackup(backup);
                JOptionPane.showMessageDialog(this, "Datos reestablecidos correctamente", "Acción completada", JOptionPane.INFORMATION_MESSAGE);
                //Actualizar las tablas
                controladorVista.cargarDatosSistema();
                pintarDatosUsuario();
                pintarDatosRuta();
                pintarDatosCategoria();
                pintarDatosValoracion();
                pintarDatosFotoPerfil();
            }
            catch(SQLException sqle){
                JOptionPane.showMessageDialog(this, "Error al reestablecer los datos\nCódigo: " + sqle.getErrorCode(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error inesperado al reestablecer los datos\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButtonReestablecerDatosActionPerformed

    /**
     * @brief Metodo que se clica sobre una fila de la tabla de rutas
     * @param evt   Evento
     */
    private void jTable_rutasMouseClicked(java.awt.event.MouseEvent evt) {                                          
        //Si hay alguna fila seleccionada
        if(jTable_rutas.getSelectedRow() != -1){
            //Mostrar la información extra
            jScrollPane_valoraciones_ruta.setVisible(true);
            jLabel_valoraciones_ruta.setVisible(true);
            jScrollPane_categorias_ruta.setVisible(true);
            jLabel_categorias_ruta.setVisible(true);

            //Encontrar la ruta seleccionada
            int fila = jTable_rutas.getSelectedRow();
            String nombre = (String) jTable_rutas.getValueAt(fila, 0);
            String creador = (String) jTable_rutas.getValueAt(fila, 6);
            Usuario creadorRuta = null;
            for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
                if(usuario.getDNI().equals(creador)){
                    creadorRuta = usuario;
                }
            }

            Ruta ruta = null;
            for(Ruta rutaAux : controladorVista.getListaRutasSistema()){
                if(rutaAux.getIdRuta().equals(controladorVista.getIDrutaSistema(nombre, creadorRuta.getIDUsuario()))){
                    ruta = rutaAux;
                }
            }

            //Pintar la tabla de valoraciones
            DefaultTableModel model = (DefaultTableModel) jTable_valoraciones_ruta.getModel();
            model.setRowCount(0);
            for(Valoracion valoracion : ruta.getListaValoraciones()){
                model.addRow(new Object[]{valoracion.getUsuario().getDNI(), valoracion.getPuntuacion()});
            }

            //Pintar la tabla de categorias
            DefaultTableModel model2 = (DefaultTableModel) jTable_categorias_ruta.getModel();
            model2.setRowCount(0);
            for(Categoria categoria : ruta.getListaCategorias()){
                model2.addRow(new Object[]{categoria.getIDCategoria(), categoria.getNombreCategoria()});
            }
        }
    }
    
    /**
     * @brief Metodo que actualiza la tabla de categorias de la ruta, mostrando las categorias que tiene la ruta seleccionada
     */
    public void actualizarTablaCategoriasDeRuta(){
        //Encontrar la ruta seleccionada
        Ruta rutaSeleccionada = null;
        rutaSeleccionada = controladorVista.getRutaSistema(jTextField_nombre_ruta.getText(), jComboBox_credor.getSelectedItem().toString());
        int fila = jTable_rutas.getSelectedRow();
        for(int i=0; i < jTable_rutas.getRowCount(); i++){
            if(jTable_rutas.getValueAt(i, 0).equals(rutaSeleccionada.getNombreRuta()) && jTable_rutas.getValueAt(i, 6).equals(rutaSeleccionada.getCreadorRuta().getDNI())){
                fila = i;
            }
        }
        String nombre = (String) jTable_rutas.getValueAt(fila, 0);
        String creador = (String) jTable_rutas.getValueAt(fila, 6);
        Usuario creadorRuta = null;
        for(Usuario usuario : controladorVista.getListaUsuariosSistema()){
            if(usuario.getDNI().equals(creador)){
                creadorRuta = usuario;
            }
        }

        Ruta ruta = null;
        for(Ruta rutaAux : controladorVista.getListaRutasSistema()){
            if(rutaAux.getIdRuta().equals(controladorVista.getIDrutaSistema(nombre, creadorRuta.getIDUsuario()))){
                ruta = rutaAux;
            }
        }
        //Pintar la tabla de categorias
        DefaultTableModel model2 = (DefaultTableModel) jTable_categorias_ruta.getModel();
        model2.setRowCount(0);
        for(Categoria categoria : ruta.getListaCategorias()){
            model2.addRow(new Object[]{categoria.getIDCategoria(), categoria.getNombreCategoria()});
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReestablecerDatos;
    private javax.swing.JButton jButton_aniadir_categoria;
    private javax.swing.JButton jButton_aniadir_categoria_en_ruta;
    public javax.swing.JButton jButton_aniadir_foto_perfil;
    private javax.swing.JButton jButton_aniadir_ruta;
    private javax.swing.JButton jButton_aniadir_ruta_de_categoria;
    public javax.swing.JButton jButton_aniadir_usuario;
    public javax.swing.JButton jButton_aniadir_valoracion;
    private javax.swing.JButton jButton_borrar_categoria;
    private javax.swing.JButton jButton_borrar_categoria_en_ruta;
    public javax.swing.JButton jButton_borrar_foto_perfil;
    private javax.swing.JButton jButton_borrar_ruta;
    public javax.swing.JButton jButton_borrar_usuario;
    public javax.swing.JButton jButton_borrar_valoracion;
    private javax.swing.JButton jButton_cancelar_cantegoria;
    private javax.swing.JButton jButton_cancelar_foto_perfil;
    public javax.swing.JButton jButton_cancelar_ruta;
    private javax.swing.JButton jButton_cancelar_usuario;
    private javax.swing.JButton jButton_cancelar_valoracion;
    private javax.swing.JButton jButton_confirmar_aniadir_categoria_en_ruta3;
    private javax.swing.JButton jButton_confirmar_aniadir_ruta_de_categoria;
    private javax.swing.JButton jButton_eliminar_ruta_de_categoria;
    private javax.swing.JButton jButton_guardar_categoria;
    private javax.swing.JButton jButton_guardar_categoria_en_ruta;
    private javax.swing.JButton jButton_guardar_foto_perfil;
    private javax.swing.JButton jButton_guardar_modificacion_categoria;
    public javax.swing.JButton jButton_guardar_ruta;
    private javax.swing.JButton jButton_guardar_usuario;
    private javax.swing.JButton jButton_guardar_valoracion;
    public javax.swing.JButton jButton_modificar_categoria;
    public javax.swing.JButton jButton_modificar_foto_perfil;
    private javax.swing.JButton jButton_modificar_ruta;
    public javax.swing.JButton jButton_modificar_usuario;
    public javax.swing.JButton jButton_modificar_valoracion;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox_categoris_aniadibles_a_ruta;
    public javax.swing.JComboBox<String> jComboBox_credor;
    public javax.swing.JComboBox<String> jComboBox_dificultad_ruta;
    private javax.swing.JComboBox<String> jComboBox_puntuacion_valoracion;
    private javax.swing.JComboBox<Ruta> jComboBox_ruta_valoracion;
    private javax.swing.JComboBox<String> jComboBox_usuario_foto_perfil;
    private javax.swing.JComboBox<String> jComboBox_usuario_valoracion;
    private javax.swing.JLabel jLabel_apellido1_usuario;
    private javax.swing.JLabel jLabel_apellido2_usuario;
    private javax.swing.JLabel jLabel_categorias_ruta;
    private javax.swing.JLabel jLabel_comentario_valoracion;
    private javax.swing.JLabel jLabel_contrasenia_usuario;
    private javax.swing.JLabel jLabel_correo_usuario;
    private javax.swing.JLabel jLabel_credor;
    private javax.swing.JLabel jLabel_descripcion_ruta;
    private javax.swing.JLabel jLabel_dificultad_ruta;
    private javax.swing.JLabel jLabel_distancia_ruta;
    private javax.swing.JLabel jLabel_dni_usuario;
    private javax.swing.JLabel jLabel_nombre_categoria;
    private javax.swing.JLabel jLabel_nombre_imagen_foto_perfil;
    private javax.swing.JLabel jLabel_nombre_ruta;
    private javax.swing.JLabel jLabel_nombre_usuario;
    private javax.swing.JLabel jLabel_puntuacion_valoracion;
    private javax.swing.JLabel jLabel_resolucion_foto_perfil;
    private javax.swing.JLabel jLabel_ruta_valoracion;
    private javax.swing.JLabel jLabel_rutas_usuario;
    private javax.swing.JLabel jLabel_tabla_rutas_de_categoria;
    private javax.swing.JLabel jLabel_tamanio_foto_perfil;
    private javax.swing.JLabel jLabel_tiempo_ruta;
    private javax.swing.JLabel jLabel_usuario_foto_perfil;
    private javax.swing.JLabel jLabel_usuario_valoracion;
    private javax.swing.JLabel jLabel_valoraciones_ruta;
    private javax.swing.JLabel jLabel_valoraciones_usuario;
    private javax.swing.JPanel jPanel_categoria;
    private javax.swing.JPanel jPanel_fotosPerfil;
    private javax.swing.JPanel jPanel_ruta;
    private javax.swing.JPanel jPanel_usuario;
    private javax.swing.JPanel jPanel_valoraciones;
    private javax.swing.JPasswordField jPasswordField_contrasenia_usuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane_categorias_ruta;
    private javax.swing.JScrollPane jScrollPane_comentario_valoracion;
    private javax.swing.JScrollPane jScrollPane_descripcion_ruta;
    private javax.swing.JScrollPane jScrollPane_rutas_usuario;
    private javax.swing.JScrollPane jScrollPane_valoraciones_ruta;
    private javax.swing.JScrollPane jScrollPane_valoraciones_usuario;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable_categoria;
    private javax.swing.JTable jTable_categorias_ruta;
    public javax.swing.JTable jTable_fotosPerfil;
    private javax.swing.JTable jTable_rutas;
    private javax.swing.JTable jTable_rutas_de_categoria;
    private javax.swing.JTable jTable_rutas_usuario;
    public javax.swing.JTable jTable_usuario;
    public javax.swing.JTable jTable_valoraciones;
    private javax.swing.JTable jTable_valoraciones_ruta;
    private javax.swing.JTable jTable_valoraciones_usuario;
    private javax.swing.JTextArea jTextArea_comentario_valoracion;
    private javax.swing.JTextArea jTextArea_descripcion_ruta;
    private javax.swing.JTextField jTextField_apellido1_usuario;
    private javax.swing.JTextField jTextField_apellido2_usuario;
    private javax.swing.JTextField jTextField_correo_usuario;
    private javax.swing.JTextField jTextField_distancia_ruta;
    private javax.swing.JTextField jTextField_dni_persona;
    public javax.swing.JTextField jTextField_nombre_categoria;
    private javax.swing.JTextField jTextField_nombre_imagen_foto_perfil;
    private javax.swing.JTextField jTextField_nombre_ruta;
    private javax.swing.JTextField jTextField_nombre_usuario;
    private javax.swing.JTextField jTextField_reolucion_foto_perfil;
    private javax.swing.JTextField jTextField_tamanio_foto_perfil;
    private javax.swing.JTextField jTextField_tiempo_ruta;
    // End of variables declaration//GEN-END:variables
        
    private ArrayList<Categoria> categorias;
    private ArrayList<Ruta> rutas;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Valoracion> valoraciones;
    private ArrayList<FotoPerfil> fotosPerfil;
}
