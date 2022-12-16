/** ****************************************************************************
 *Autor:Sainos Hernández Baldomero
 *Fecha de creación: 16-12-2022 ***
 *Fecha de actualización:16-12-2022***
 *Descripción:Panel para la portada.
 *
 * ****************************************************************************/
package view;
/*
*Pantalla para visualisar la pantalla donde el usuario va a interactuar con el 
*juego que se va arealizar.
*/
public class PantallaJuego extends javax.swing.JFrame {

    public PantallaJuego() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlay = new javax.swing.JButton();
        btnPausa = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        btbSalir = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jfJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlay.setText("PLAY");
        btnPlay.setPreferredSize(new java.awt.Dimension(115, 24));
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 120, -1));

        btnPausa.setText("PAUSA");
        btnPausa.setPreferredSize(new java.awt.Dimension(115, 24));
        btnPausa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPausaMouseClicked(evt);
            }
        });
        getContentPane().add(btnPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 120, -1));

        btnContinuar.setText("CONTINUAR");
        btnContinuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContinuarMouseClicked(evt);
            }
        });
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 120, -1));

        btbSalir.setText("SALIR");
        btbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btbSalirMouseClicked(evt);
            }
        });
        getContentPane().add(btbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 220, 120, -1));

        jToggleButton1.setText("jToggleButton1");
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, -1));

        jfJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/FONDOJUEGO.gif"))); // NOI18N
        getContentPane().add(jfJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    /*
    *Botón para poner en acción al juego.
    */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlayActionPerformed
    /*
    *Botón para poner en acción el juego.
    */
    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        
    }//GEN-LAST:event_btnPlayMouseClicked
    /*
    *Botón para poner pausa al juego.
    */
    private void btnPausaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPausaMouseClicked
        
    }//GEN-LAST:event_btnPausaMouseClicked
    /*
    *Botón para poner continuar el juego.
    */
    private void btnContinuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinuarMouseClicked
      
    }//GEN-LAST:event_btnContinuarMouseClicked
    /*
    *Botón para salir del juego.
    */
    private void btbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btbSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btbSalirMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbSalir;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnPausa;
    private javax.swing.JButton btnPlay;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jfJuego;
    // End of variables declaration//GEN-END:variables
}
