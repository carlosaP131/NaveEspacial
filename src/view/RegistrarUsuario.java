package view;

import Controller.JugadorController;
import Controller.UsuarioController;
import Model.UsuarioModelImpl;
import Utilidades.EnumValida;
import entity.Jugador;
import entity.Usuario;

public class RegistrarUsuario extends javax.swing.JFrame {

    Login login;
    private final UsuarioController usuariocontroller;
    private final JugadorController jugadorcontroller;

    public RegistrarUsuario() {
        usuariocontroller = new UsuarioController();
        jugadorcontroller = new JugadorController();
        

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JTextField();
        Nickname = new javax.swing.JTextField();
        Edad = new javax.swing.JTextField();
        Correo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Roles = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Registrar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel5.setText("NickName");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jLabel6.setText("Edad");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 40, -1));

        jLabel7.setText("Correo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        Usuario.setBackground(new java.awt.Color(204, 204, 204));
        Usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 160, -1));

        Contraseña.setBackground(new java.awt.Color(204, 204, 204));
        Contraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 160, -1));

        Nickname.setBackground(new java.awt.Color(204, 204, 204));
        Nickname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 160, -1));

        Edad.setBackground(new java.awt.Color(204, 204, 204));
        Edad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 160, -1));

        Correo.setBackground(new java.awt.Color(204, 204, 204));
        Correo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 160, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 102));
        jButton3.setText("Registrar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 160, -1));

        Roles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Jugador", "Invitado", " ", " " }));
        Roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolesActionPerformed(evt);
            }
        });
        jPanel1.add(Roles, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 160, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/astroanuts (1).png"))); // NOI18N
        jLabel9.setToolTipText("hola");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contrasena.png"))); // NOI18N
        jLabel8.setToolTipText("Contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anonimo.png"))); // NOI18N
        jLabel10.setToolTipText("NickName");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limite-de-edad.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gmail.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apagado.png"))); // NOI18N
        jLabel13.setToolTipText("Salir");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 40, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/casa.png"))); // NOI18N
        jLabel14.setToolTipText("Login");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 880, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioActionPerformed

    private void RolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RolesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        Usuario usuario = new Usuario();
        Jugador jugador = new Jugador();// se instancia jugador y usuario
        UsuarioModelImpl usuarioid = new UsuarioModelImpl();

        String tipo = this.Roles.getSelectedItem().toString();
        //se selecciona un rol 
        if (tipo.compareTo(EnumValida.ADMIN.getValue()) == 0) {
            // se definen los datos de los Jugadores
            jugador.setNombre(this.Nickname.getText());
            jugador.setEdad(Integer.parseInt(this.Edad.getText()));
            jugador.setCorreo(this.Correo.getText());
            jugadorcontroller.InsertarRegistro(jugador);
            // se definen los usuarios
            usuario.setUser(this.Usuario.getText());
            usuario.setPwd(this.Contraseña.getText());
            usuario.setRol("Administrador");
            
             usuariocontroller.InsertarRegistro(usuario);
        }
        if (tipo.compareTo(EnumValida.Jugador.getValue()) == 0) {

            jugador.setNombre(this.Nickname.getText());
            jugador.setEdad(Integer.parseInt(this.Edad.getText()));
            jugador.setCorreo(this.Correo.getText());
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
        
    }//GEN-LAST:event_jButton3MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contraseña;
    private javax.swing.JTextField Correo;
    private javax.swing.JTextField Edad;
    private javax.swing.JTextField Nickname;
    private javax.swing.JComboBox<String> Roles;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
