/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Panel para mostrar usuarios
 **
 * *************************************************************************** */
package view;

import java.sql.*;
import java.sql.ResultSet;
import Controller.UsuarioController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GETZEMANI ALEJANDRO GONZALEZ CRUZ
 */
public class Tabla_Usuario extends javax.swing.JPanel {

    private final UsuarioController usuariocontroller;
    private final DefaultTableModel modelo;
    Connection con;
    Statement st;
    ResultSet rs;
    private int idUsuario;

    public Tabla_Usuario() {
        initComponents();
        modelo = (DefaultTableModel) TablaUsuarios.getModel();
        usuariocontroller = new UsuarioController();
        usuariocontroller.mostrar(modelo);
        nombre.setText("Nombre Nuevo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        nombre = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Mostrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(990, 910));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "id Jugador", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaUsuarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        nombre.setText("Nombre nuevo");
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        Eliminar.setBackground(new java.awt.Color(1, 39, 61));
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iEliminarBot.png"))); // NOI18N
        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
        });
        add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        Modificar.setBackground(new java.awt.Color(1, 39, 61));
        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iModificarBot.png"))); // NOI18N
        Modificar.setBorderPainted(false);
        Modificar.setContentAreaFilled(false);
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarMouseClicked(evt);
            }
        });
        add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        Mostrar.setBackground(new java.awt.Color(1, 39, 61));
        Mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iMostrarB.png"))); // NOI18N
        Mostrar.setBorderPainted(false);
        Mostrar.setContentAreaFilled(false);
        Mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MostrarMouseClicked(evt);
            }
        });
        add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 130, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iTablaUsuarioTitulo.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MostrarMouseClicked
        usuariocontroller.mostrar(modelo);
    }//GEN-LAST:event_MostrarMouseClicked

    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/nave_espacial", "root", "root");
            st = con.createStatement();
            st.execute("update usuario set usuario='" + nombre.getText() + "' where id_usuario='" + idUsuario + "';");
            JOptionPane.showMessageDialog(null, "actualizacion correctamente");
            usuariocontroller.mostrar(modelo);
            con.close();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_ModificarMouseClicked

    private void TablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaUsuariosMouseClicked
        idUsuario = Integer.parseInt(TablaUsuarios.getValueAt(TablaUsuarios.getSelectedRow(), 0).toString());
        nombre.setText(TablaUsuarios.getValueAt(TablaUsuarios.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_TablaUsuariosMouseClicked

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/nave_espacial", "root", "root");
            st = con.createStatement();
            st.execute("DELETE FROM usuario WHERE id_usuario='" + idUsuario + "'");
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            usuariocontroller.mostrar(modelo);
            con.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_EliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
