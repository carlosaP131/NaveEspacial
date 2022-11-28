/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import entity.Jugador;
import entity.Usuario;
import Controller.UsuarioController;

/**
 *
 * @author labdessw09
 */
public class Registrar extends javax.swing.JPanel {
      Jugador juador =  new Jugador();
    /**
     * Creates new form InicioView
     */
    private UsuarioController usuariocontroller;
    public Registrar() {
        initComponents();
       usuariocontroller = new UsuarioController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        seleccionarRol = new javax.swing.JComboBox<>();
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
        add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ICONTRASEÑA.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/IUSUARIO.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iRegistrarTitulo.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel5.setText("Edad");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        jLabel6.setText("Sexo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        jLabel7.setText("Direccion");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        jLabel8.setText("Telefono");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 20));

        jLabel9.setText("Correo");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 240, -1));
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 240, -1));
        add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 240, -1));
        add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 240, -1));
        add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 240, -1));

        seleccionarRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugador", "Admin", "Super Admin" }));
        seleccionarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarRolActionPerformed(evt);
            }
        });
        add(seleccionarRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, -1, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarActionPerformed

    private void registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarMouseClicked
        Usuario usuario = new Usuario();
        
     
        usuario.setUser(this.jTextField1.getText());
        usuario.setPwd(this.jPasswordField1.getPassword().toString());
        usuario.setIdUsuario(juador.getIdJugador());
        usuariocontroller.InsertarRegistro(usuario);
        
    }//GEN-LAST:event_registrarMouseClicked

    private void seleccionarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionarRolActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JButton registrar;
    private javax.swing.JComboBox<String> seleccionarRol;
    // End of variables declaration//GEN-END:variables
}
