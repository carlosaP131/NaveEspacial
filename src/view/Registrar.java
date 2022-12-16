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

        Contraseña = new javax.swing.JPasswordField();
        Usuario = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        Lcontraseña = new javax.swing.JLabel();
        Lnombre = new javax.swing.JLabel();
        LtituloReg = new javax.swing.JLabel();
        Ledad = new javax.swing.JLabel();
        Lsexo = new javax.swing.JLabel();
        Ldireccion = new javax.swing.JLabel();
        Ltelefono = new javax.swing.JLabel();
        Lcorreo = new javax.swing.JLabel();
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

        Contraseña.setBackground(new java.awt.Color(1, 39, 61));
        Contraseña.setForeground(new java.awt.Color(233, 74, 218));
        Contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 240, -1));

        Usuario.setBackground(new java.awt.Color(1, 39, 61));
        Usuario.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Usuario.setForeground(new java.awt.Color(233, 74, 218));
        Usuario.setText("Ingresar Usuario");
        Usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuarioMouseClicked(evt);
            }
        });
        add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 240, -1));

        registrar.setBackground(new java.awt.Color(1, 39, 61));
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
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
        add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, -1, -1));

        Lcontraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ICONTRASEÑA.png"))); // NOI18N
        Lcontraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Lcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 150, -1));

        Lnombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/IUSUARIO.png"))); // NOI18N
        Lnombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Lnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 100, -1));

        LtituloReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iRegistrarTitulo.png"))); // NOI18N
        add(LtituloReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 840, 60));

        Ledad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Iedad.png"))); // NOI18N
        Ledad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Ledad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, -1, -1));

        Lsexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Isexo.png"))); // NOI18N
        Lsexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Lsexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        Ldireccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/IDireccion.png"))); // NOI18N
        Ldireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Ldireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, -1, -1));

        Ltelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Ltelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, -1, 20));

        Lcorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ICorreo.png"))); // NOI18N
        Lcorreo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Lcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, -1));

        Edad.setBackground(new java.awt.Color(1, 39, 61));
        Edad.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Edad.setForeground(new java.awt.Color(233, 74, 218));
        Edad.setText("Edad");
        Edad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Edad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EdadMouseClicked(evt);
            }
        });
        add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 240, -1));

        Sexo.setBackground(new java.awt.Color(1, 39, 61));
        Sexo.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Sexo.setForeground(new java.awt.Color(233, 74, 218));
        Sexo.setText("Sexo");
        Sexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Sexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SexoMouseClicked(evt);
            }
        });
        add(Sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 240, -1));

        Telefono.setBackground(new java.awt.Color(1, 39, 61));
        Telefono.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Telefono.setForeground(new java.awt.Color(233, 74, 218));
        Telefono.setText("Telefono");
        Telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelefonoMouseClicked(evt);
            }
        });
        add(Telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 240, -1));

        Direccion.setBackground(new java.awt.Color(1, 39, 61));
        Direccion.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Direccion.setForeground(new java.awt.Color(233, 74, 218));
        Direccion.setText("Direccion");
        Direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DireccionMouseClicked(evt);
            }
        });
        add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 240, -1));

        Correo.setBackground(new java.awt.Color(1, 39, 61));
        Correo.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Correo.setForeground(new java.awt.Color(233, 74, 218));
        Correo.setText("Correo");
        Correo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CorreoMouseClicked(evt);
            }
        });
        add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 240, -1));

        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        Nickname.setBackground(new java.awt.Color(1, 39, 61));
        Nickname.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Nickname.setForeground(new java.awt.Color(233, 74, 218));
        Nickname.setText("NickName");
        Nickname.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Nickname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NicknameMouseClicked(evt);
            }
        });
        add(Nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 240, -1));

        Roles.setForeground(new java.awt.Color(233, 74, 218));
        Roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador", "Admin", "Invitado" }));
        Roles.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(Roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, -1, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
       
    }//GEN-LAST:event_ContraseñaActionPerformed

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
            usuario.setUser(this.Usuario.getText());
            usuario.setPwd(this.Contraseña.getText());
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
            usuario.setUser(this.Usuario.getText());
            usuario.setPwd(this.Contraseña.getText());
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
             usuario.setUser(this.Usuario.getText());
             usuario.setPwd(this.Contraseña.getText());
            usuario.setRol("Invitado");

             usuariocontroller.InsertarRegistro(usuario);
        }
       usuario.setIdJugador(jugador.getIdJugador());


    }//GEN-LAST:event_registrarMouseClicked

    private void UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioMouseClicked
        Usuario.setText("");
    }//GEN-LAST:event_UsuarioMouseClicked

    private void NicknameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NicknameMouseClicked
        Nickname.setText("");
    }//GEN-LAST:event_NicknameMouseClicked

    private void EdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EdadMouseClicked
        Edad.setText("");
    }//GEN-LAST:event_EdadMouseClicked

    private void SexoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SexoMouseClicked
       Sexo.setText("");
    }//GEN-LAST:event_SexoMouseClicked

    private void TelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelefonoMouseClicked
        Telefono.setText("");
    }//GEN-LAST:event_TelefonoMouseClicked

    private void DireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DireccionMouseClicked
        Direccion.setText("");
    }//GEN-LAST:event_DireccionMouseClicked

    private void CorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CorreoMouseClicked
       Correo.setText("");
    }//GEN-LAST:event_CorreoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Edad;
    private javax.swing.JLabel Lcontraseña;
    private javax.swing.JLabel Lcorreo;
    private javax.swing.JLabel Ldireccion;
    private javax.swing.JLabel Ledad;
    private javax.swing.JLabel Lnombre;
    private javax.swing.JLabel Lsexo;
    private javax.swing.JLabel Ltelefono;
    private javax.swing.JLabel LtituloReg;
    private javax.swing.JTextField Nickname;
    private javax.swing.JComboBox<String> Roles;
    private javax.swing.JTextField Sexo;
    private javax.swing.JTextField Telefono;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
