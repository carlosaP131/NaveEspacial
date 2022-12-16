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
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlay = new javax.swing.JButton();
        btnPausa = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        jfJuego = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlay.setText("PLAY");
        btnPlay.setPreferredSize(new java.awt.Dimension(115, 24));
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 120, -1));

        btnPausa.setText("PAUSA");
        btnPausa.setPreferredSize(new java.awt.Dimension(115, 24));
        getContentPane().add(btnPausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 120, -1));

        btnContinuar.setText("CONTINUAR");
        getContentPane().add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        jfJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/FONDOJUEGO.gif"))); // NOI18N
        getContentPane().add(jfJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPlayActionPerformed

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
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnPausa;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel jfJuego;
    // End of variables declaration//GEN-END:variables
}
