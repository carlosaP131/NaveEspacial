package View;

import javaReportes.Conexion;
import com.sun.jdi.connect.spi.Connection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Menu extends javax.swing.JFrame {

    TablaUsuario tablaUsuario;
    RegistrarUsuario registrar;
    TablaJugador tablaJugador;
    Juego juego;
    private Connection conection;
    private javaReportes.Conexion conexion;
    int idJugador;

    public Menu() {
        initComponents();

    }

    Menu(int id) {
        initComponents();
        idJugador=id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        Reporte = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        Jugador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlos\\Downloads\\NaveEspacial\\src\\img\\apagado.png")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jLabel4.setBackground(new java.awt.Color(102, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Menu");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, -1, -1));

        jugar.setBackground(new java.awt.Color(204, 204, 204));
        jugar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jugar.setForeground(new java.awt.Color(51, 51, 51));
        jugar.setText("Jugar");
        jugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jugarMouseClicked(evt);
            }
        });
        jPanel1.add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, -1));

        Reporte.setBackground(new java.awt.Color(204, 204, 204));
        Reporte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Reporte.setForeground(new java.awt.Color(51, 51, 51));
        Reporte.setText("Reporte");
        Reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReporteMouseClicked(evt);
            }
        });
        Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReporteActionPerformed(evt);
            }
        });
        jPanel1.add(Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 170, -1));

        Consultar.setBackground(new java.awt.Color(204, 204, 204));
        Consultar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Consultar.setForeground(new java.awt.Color(51, 51, 51));
        Consultar.setText("Consultar");
        Consultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsultarMouseClicked(evt);
            }
        });
        jPanel1.add(Consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 170, -1));

        Registrar.setBackground(new java.awt.Color(204, 204, 204));
        Registrar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Registrar.setForeground(new java.awt.Color(51, 51, 51));
        Registrar.setText("Registrar");
        Registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarMouseClicked(evt);
            }
        });
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 170, -1));

        Jugador.setBackground(new java.awt.Color(204, 204, 204));
        Jugador.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Jugador.setForeground(new java.awt.Color(51, 51, 51));
        Jugador.setText("Jugadores");
        Jugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JugadorMouseClicked(evt);
            }
        });
        jPanel1.add(Jugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 170, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlos\\Downloads\\NaveEspacial\\src\\img\\menu_1.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void ConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultarMouseClicked
        // TODO add your handling code here:
        tablaUsuario=  new TablaUsuario();
        this.setVisible(false);
        tablaUsuario.setVisible(true);

    }//GEN-LAST:event_ConsultarMouseClicked

    private void RegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarMouseClicked
        // TODO add your handling code here:
        registrar = new RegistrarUsuario();
        this.setVisible(false);
        registrar.setVisible(true);
    }//GEN-LAST:event_RegistrarMouseClicked

    private void ReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReporteMouseClicked
        try {
            conexion = new Conexion();
            //conection = (Connection) conexion.getConnection();
            String path="/home/labdessw09/NetBeansProjects/NaveEspacial/src/unsis/edu/mx/nave_espacial_reporte/report1.jasper";
            JasperReport jr=null;
            System.out.println("xgqsxgjksbx");
            jr=(JasperReport) JRLoader.loadObjectFromFile(path);
            System.out.println("kkkkkk");
            net.sf.jasperreports.engine.JasperPrint jp=JasperFillManager.fillReport(jr,null,conexion.getConnection());
            JasperViewer jv= new JasperViewer(jp);
            jv.setVisible(true);
            jv.setTitle(path);
            conexion.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ReporteMouseClicked

    private void jugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jugarMouseClicked
      new Juego(idJugador).start();
      this.setVisible(false);
    }//GEN-LAST:event_jugarMouseClicked

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarActionPerformed

    private void JugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JugadorMouseClicked
       // TODO add your handling code here:
        tablaJugador = new TablaJugador();
        this.setVisible(false);
        tablaJugador.setVisible(true);
    }//GEN-LAST:event_JugadorMouseClicked

    private void ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Jugador;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Reporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jugar;
    // End of variables declaration//GEN-END:variables
}
