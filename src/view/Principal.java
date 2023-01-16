/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Frame Principal para mostrar los paneles secundarios 
 *
 * ****************************************************************************/
package view;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class Principal extends javax.swing.JFrame {
    //corrdenadas
    private int xMouse;
    private int yMouse;//posicion mause
    InicioView inicio;// instancia de el panel de inicio de sesion 
    Portada portada;//instancia de portada 
    Registrar regis;//intancia de registrar usuario
    Tabla_Usuario tUsuario;//instancia de tabla usuario
    Juego juego;
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(this);
        portada = new Portada();
        inicio = new InicioView();
        regis = new Registrar();
        tUsuario = new Tabla_Usuario();
        juego = new Juego();
        Pprincipal.add(portada);
        
        portada.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pprincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Biniciar = new javax.swing.JButton();
        Bjugar = new javax.swing.JButton();
        Bregistrar = new javax.swing.JButton();
        Bconsultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Cerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(990, 940));
        setUndecorated(true);

        Pprincipal.setMinimumSize(new java.awt.Dimension(990, 900));
        Pprincipal.setPreferredSize(new java.awt.Dimension(990, 940));
        Pprincipal.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(1, 39, 61));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Titulos/iMenu.png"))); // NOI18N

        Biniciar.setBackground(new java.awt.Color(1, 39, 61));
        Biniciar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Biniciar.setForeground(new java.awt.Color(233, 74, 218));
        Biniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Botones/iIniciarSesionPrincipal.png"))); // NOI18N
        Biniciar.setBorderPainted(false);
        Biniciar.setContentAreaFilled(false);
        Biniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BiniciarMouseClicked(evt);
            }
        });
        Biniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BiniciarActionPerformed(evt);
            }
        });

        Bjugar.setBackground(new java.awt.Color(1, 39, 61));
        Bjugar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Bjugar.setForeground(new java.awt.Color(233, 74, 218));
        Bjugar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Botones/iJugar.png"))); // NOI18N
        Bjugar.setBorderPainted(false);
        Bjugar.setContentAreaFilled(false);
        Bjugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BjugarMouseClicked(evt);
            }
        });

        Bregistrar.setBackground(new java.awt.Color(1, 39, 61));
        Bregistrar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Bregistrar.setForeground(new java.awt.Color(233, 74, 218));
        Bregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Botones/iRegistrarBot.png"))); // NOI18N
        Bregistrar.setBorderPainted(false);
        Bregistrar.setContentAreaFilled(false);
        Bregistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BregistrarMouseClicked(evt);
            }
        });

        Bconsultar.setBackground(new java.awt.Color(1, 39, 61));
        Bconsultar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        Bconsultar.setForeground(new java.awt.Color(233, 74, 218));
        Bconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Botones/iMostrarB.png"))); // NOI18N
        Bconsultar.setBorderPainted(false);
        Bconsultar.setContentAreaFilled(false);
        Bconsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BconsultarMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondos/iFondo3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(Bjugar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bconsultar)
                            .addComponent(Bregistrar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(Biniciar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(Biniciar)
                .addGap(18, 18, 18)
                .addComponent(Bjugar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Bregistrar)
                .addGap(18, 18, 18)
                .addComponent(Bconsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Pprincipal.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(1, 39, 61));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cerrar.setBackground(new java.awt.Color(255, 0, 0));
        Cerrar.setText("X");
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
        });
        jPanel2.add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/fondos/iFondo4.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 250, 55));

        Pprincipal.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(Pprincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked

        System.exit(0);
    }//GEN-LAST:event_CerrarMouseClicked

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
         yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
     int x = evt.getXOnScreen();
     int y = evt.getYOnScreen();
     this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void BconsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BconsultarMouseClicked
        Pprincipal.add(tUsuario);
        inicio.setVisible(false);
        portada.setVisible(false);
        regis.setVisible(false);
        tUsuario.setVisible(true);
        Pprincipal.validate();
        deshabilitarBotones();
    }//GEN-LAST:event_BconsultarMouseClicked

    private void BregistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BregistrarMouseClicked
        Pprincipal.add(regis);
        inicio.setVisible(false);
        portada.setVisible(false);
        tUsuario.setVisible(false);
        regis.setVisible(true);
        Pprincipal.validate();
    }//GEN-LAST:event_BregistrarMouseClicked

    private void BiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BiniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BiniciarActionPerformed

    private void BiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BiniciarMouseClicked

        Pprincipal.add(inicio);
        inicio.setVisible(true);
        portada.setVisible(false);
        Pprincipal.validate();
        regis.setVisible(false);
        tUsuario.setVisible(false);
    }//GEN-LAST:event_BiniciarMouseClicked

    private void BjugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BjugarMouseClicked
       Pprincipal.add(juego);
        inicio.setVisible(false);
        portada.setVisible(false);      
        regis.setVisible(false);
        tUsuario.setVisible(false);
        juego.setVisible(true);
        Pprincipal.validate();
    }//GEN-LAST:event_BjugarMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
 private void deshabilitarBotones() {
        if (Pprincipal.isVisible()) {
            Bconsultar.setEnabled(true);
            Biniciar.setEnabled(true);
            Bjugar.setEnabled(true);
            Bregistrar.setEnabled(true);
        } else if (inicio.isVisible()) {
            Bconsultar.setEnabled(false);
            Biniciar.setEnabled(true);
            Bjugar.setEnabled(true);
            Bregistrar.setEnabled(true);
        } else if (regis.isVisible()) {
            Bconsultar.setEnabled(false);
            Biniciar.setEnabled(true);
            Bjugar.setEnabled(true);
            Bregistrar.setEnabled(true);
        } else if (tUsuario.isVisible()) {
           Bconsultar.setEnabled(false);
            Biniciar.setEnabled(true);
            Bjugar.setEnabled(true);
            Bregistrar.setEnabled(true);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bconsultar;
    private javax.swing.JButton Biniciar;
    private javax.swing.JButton Bjugar;
    private javax.swing.JButton Bregistrar;
    private javax.swing.JButton Cerrar;
    private javax.swing.JPanel Pprincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
