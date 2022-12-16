/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Panel para mostrar usuarios
 **
 * *************************************************************************** */
package view;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
import Controller.UsuarioController;
import javax.swing.table.DefaultTableModel;

public class Tabla_Usuario extends javax.swing.JPanel {

    private final UsuarioController usuariocontroller;
    private final DefaultTableModel modelo;
    private int idUsuario;
    public Tabla_Usuario() {
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
        usuariocontroller = new UsuarioController();
        usuariocontroller.mostrar(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Nombre = new javax.swing.JTextField();
        Beliminar = new javax.swing.JButton();
        Bmodificar = new javax.swing.JButton();
        Bmostrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(990, 910));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        Nombre.setText("Nuevo Nombre ");
        add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 130, -1));

        Beliminar.setBackground(new java.awt.Color(1, 39, 61));
        Beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iEliminarBot.png"))); // NOI18N
        Beliminar.setBorderPainted(false);
        Beliminar.setContentAreaFilled(false);
        add(Beliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        Bmodificar.setBackground(new java.awt.Color(1, 39, 61));
        Bmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iModificarBot.png"))); // NOI18N
        Bmodificar.setBorderPainted(false);
        Bmodificar.setContentAreaFilled(false);
        add(Bmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        Bmostrar.setBackground(new java.awt.Color(1, 39, 61));
        Bmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iMostrarB.png"))); // NOI18N
        Bmostrar.setBorderPainted(false);
        Bmostrar.setContentAreaFilled(false);
        Bmostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BmostrarMouseClicked(evt);
            }
        });
        add(Bmostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iTablaUsuarioTitulo.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iFondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents

    private void BmostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BmostrarMouseClicked
        usuariocontroller.mostrar(modelo);
    }//GEN-LAST:event_BmostrarMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        Nombre.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        idUsuario = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Beliminar;
    private javax.swing.JButton Bmodificar;
    private javax.swing.JButton Bmostrar;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
