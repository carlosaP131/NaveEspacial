/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:31-11-2022
 *Descripción: Panel para Registrar Usuarios
 * ****************************************************************************/
package view;

import Controller.JugadorController;
import entity.Jugador;
import entity.Usuario;
import Controller.UsuarioController;
import Model.UsuarioModelImpl;
import Utilidades.EnumValida;
import java.util.Arrays;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class Registrar extends javax.swing.JPanel {

    Jugador juador = new Jugador();
   
    private final UsuarioController usuariocontroller;
    private final JugadorController jugadorcontroller;

    public Registrar() {
        initComponents();
        usuariocontroller = new UsuarioController();
        jugadorcontroller = new JugadorController();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        Lcontraseña = new javax.swing.JLabel();
        Lnombre = new javax.swing.JLabel();
        LtituloReg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Edad = new javax.swing.JTextField();
        Sexo = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Nickname = new javax.swing.JTextField();
        Roles = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(990, 910));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 240, -1));

        jTextField1.setText("INGRESA TU USUARIO");
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 240, -1));

        registrar.setBackground(new java.awt.Color(1, 39, 61));
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iRegistrarBot.png"))); // NOI18N
        registrar.setBorderPainted(false);
        registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarMouseClicked(evt);
            }
        });
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        Lcontraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ICONTRASEÑA.png"))); // NOI18N
        add(Lcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 150, -1));

        Lnombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/IUSUARIO.png"))); // NOI18N
        add(Lnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 100, -1));

        LtituloReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iRegistrarTitulo.png"))); // NOI18N
        add(LtituloReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 840, 60));

        jLabel5.setText("Edad");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        jLabel6.setText("Sexo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel7.setText("Direccion");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        jLabel8.setText("Telefono");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, 20));

        jLabel9.setText("Correo");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));
        add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 240, -1));
        add(Sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 240, -1));
        add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 240, -1));
        add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 240, -1));
        add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 240, -1));

        jLabel10.setText("Nickname");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));
        add(Nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 240, -1));

        Roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador", "Admin", "Invitado" }));
        add(Roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, -1, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
       
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
      
    }//GEN-LAST:event_registrarActionPerformed
    //metodo para el boton registrar 
    private void registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarMouseClicked
        Usuario usuario = new Usuario();
        Jugador jugador = new Jugador();// se instancia jugador y usuario
        UsuarioModelImpl usuarioid = new UsuarioModelImpl();

        String tipo = this.Roles.getSelectedItem().toString();
        //se selecciona un rol 
        if (tipo.compareTo(EnumValida.ADMIN.getValue()) == 0) {
            // se definen los datos de los Jugadores
            jugador.setSexo(this.Sexo.getText());
            jugador.setNombre(this.Nickname.getText());
            jugador.setEdad(Integer.parseInt(this.Edad.getText()));
            jugador.setDireccion(this.Direccion.getText());
            jugador.setCorreo(this.Correo.getText());
            jugador.setTelefono(this.Telefono.getText());
            jugadorcontroller.InsertarRegistro(jugador);
            // se definen los usuarios
            usuario.setUser(this.jTextField1.getText());
            usuario.setPwd(Arrays.toString(this.jPasswordField1.getPassword()));
            usuario.setRol("Administrador");
            
             usuariocontroller.InsertarRegistro(usuario);
        }
        if (tipo.compareTo(EnumValida.Jugador.getValue()) == 0) {

            jugador.setSexo(this.Sexo.getText());
            jugador.setNombre(this.Nickname.getText());
            jugador.setEdad(Integer.parseInt(this.Edad.getText()));
            jugador.setDireccion(this.Direccion.getText());
            jugador.setCorreo(this.Correo.getText());
            jugador.setTelefono(this.Telefono.getText());
            jugadorcontroller.InsertarRegistro(jugador);
            usuario.setUser(this.jTextField1.getText());
            usuario.setPwd(Arrays.toString(this.jPasswordField1.getPassword()));
            usuario.setRol("Jugador");
             usuariocontroller.InsertarRegistro(usuario);
        }
        if (tipo.compareTo(EnumValida.Invitado.getValue()) == 0) {
             jugador.setSexo("NULL");
            jugador.setNombre(this.Nickname.getText());
            jugador.setEdad(0);
            jugador.setDireccion("NULL");
            jugador.setCorreo("NULL");
            jugador.setTelefono("NULL");
            jugadorcontroller.InsertarRegistro(jugador);
             usuario.setUser(this.jTextField1.getText());
            usuario.setPwd(Arrays.toString(this.jPasswordField1.getPassword()));
            usuario.setRol("Invitado");

             usuariocontroller.InsertarRegistro(usuario);
        }
       usuario.setIdJugador(jugador.getIdJugador());


    }//GEN-LAST:event_registrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Edad;
    private javax.swing.JLabel Lcontraseña;
    private javax.swing.JLabel Lnombre;
    private javax.swing.JLabel LtituloReg;
    private javax.swing.JTextField Nickname;
    private javax.swing.JComboBox<String> Roles;
    private javax.swing.JTextField Sexo;
    private javax.swing.JTextField Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
