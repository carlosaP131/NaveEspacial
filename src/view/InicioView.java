/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Panel para el inicio de sesion 
 **
 * ****************************************************************************/
package view;


import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class InicioView extends javax.swing.JPanel {

 
    public InicioView() {
        initComponents();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contraseña = new javax.swing.JPasswordField();
        Usuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 240, -1));

        Usuario.setBackground(new java.awt.Color(1, 39, 61));
        Usuario.setForeground(new java.awt.Color(233, 74, 218));
        Usuario.setText("INGRESA TU USUARIO");
        add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 240, -1));

        jButton1.setBackground(new java.awt.Color(1, 39, 61));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iINGRESAR.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/ICONTRASEÑA.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/InombreJugador.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iINICIAR.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
      
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ingresar();
    }//GEN-LAST:event_jButton1MouseClicked
  public Connection Conectar() {
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nave_espacial", "root", "root");
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Erorr de conexión" + e.toString());
        }
        return con;
     }

    public void ingresar() {
        Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String User = Usuario.getText();
        String Pass = Contraseña.getText();
        if (User.equals("") || Pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Uno o más campos estan vacios");
        } else {
            try {
                con1 = Conectar();
                pst = con1.prepareStatement("select usuario,pdw from usuario where usuario='" + User + "' and pdw ='" + Pass + "'");
                rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Credenciales correctas");
                   // this.dispose();
                    //new Datos().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas");

                }

            } catch (SQLException e) {
                System.out.println("Error de conexión" + e.toString());

            }
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
