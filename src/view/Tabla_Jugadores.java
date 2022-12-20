/** ****************************************************************************
 *Autor:Getzemani Alejandro Gonzalez Cruz
 *Fecha de creación: 16-12-2022
 *Fecha de actualización:20-12-2022
 *Descripción:Panel para ver jugadores
 *
 * *************************************************************************** */
package view;

import Controller.JugadorController;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 * @author Getzemani Alejandro Gonzalez Cruz
 */
public class Tabla_Jugadores extends javax.swing.JPanel {

    //definición de variables globales
    private final JugadorController jugadorController;
    private final DefaultTableModel modelo;
    Connection con;
    Statement st;
    Resultset rs;

    public Tabla_Jugadores() {
        //Mostar tabla y bloquear edición del jtextfield
        initComponents();
        modelo = (DefaultTableModel) TablaJugador.getModel();
        jugadorController = new JugadorController();
        jugadorController.mostrar(modelo);
        nombre.setEditable(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEliminar = new javax.swing.JButton();
        botonMostrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaJugador = new javax.swing.JTable();
        nombre = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonEliminar.setText("Eliminar");
        botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEliminarMouseClicked(evt);
            }
        });
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 100, 30));

        botonMostrar.setText("Mostrar");
        botonMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMostrarMouseClicked(evt);
            }
        });
        add(botonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 100, 30));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tabla usuario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 280, -1));

        botonActualizar.setText("Actualizar");
        botonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonActualizarMouseClicked(evt);
            }
        });
        add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 100, 30));

        TablaJugador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Jugador", "edad", "sexo", "correo", "puntos"
            }
        ));
        TablaJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaJugadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaJugador);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        nombre.setText(" ");
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 110, -1));

        jTextField2.setText(" ");
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 110, -1));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondo2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 880));
    }// </editor-fold>//GEN-END:initComponents
    //Botón de borrar jugador
    private void botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEliminarMouseClicked
        String nombre1;
        nombre1 = nombre.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nave_espacial", "root", "CETI");
            st = con.createStatement();
            st.execute("DELETE FROM nave_espacial.jugador WHERE nombre='" + nombre1 + "'");
            System.out.println("eliminado correctamente");
            jugadorController.mostrar(modelo);
            con.close();

        } catch (Exception e) {
            System.err.println("a" + e);
        }


    }//GEN-LAST:event_botonEliminarMouseClicked

    //botón de mostrar jugador
    private void botonMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMostrarMouseClicked
        jugadorController.mostrar(modelo);


    }//GEN-LAST:event_botonMostrarMouseClicked

    //botón de actualizar jugador
    private void botonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonActualizarMouseClicked
        String nombre1, nombre2;
        nombre1 = nombre.getText();
        nombre2 = jTextField2.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nave_espacial", "root", "CETI");
            st = con.createStatement();
            st.execute("update jugador set nombre='" + nombre2 + "' where jugador.nombre='" + nombre1 + "';");
            System.out.println("Actualizado");
            jugadorController.mostrar(modelo);

            con.close();

        } catch (Exception e) {
            System.err.println("a" + e);
        }


    }//GEN-LAST:event_botonActualizarMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void TablaJugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaJugadorMouseClicked
        nombre.setText(TablaJugador.getValueAt(TablaJugador.getSelectedRow(), 1).toString());

    }//GEN-LAST:event_TablaJugadorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaJugador;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
