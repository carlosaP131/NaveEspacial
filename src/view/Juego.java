/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Panel Juego
 *
 * *************************************************************************** */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class Juego extends javax.swing.JPanel implements Runnable, MouseMotionListener, MouseListener {

    private int x;
    private int Caer = 50;
    private int M1ubicacion = 250;
    private int M2ubicacion = 350;
    private int M3ubicacion = 450;
    private int M4ubicacion = 550;
    private int Balax;
    private int Balay;
    private Thread hilo;
    private boolean srtStp = true;
    private int Nivel = 0;
    public Juego() {
        initComponents();
        this.addMouseMotionListener(this);//activar la escucha del gragged
        this.addMouseListener(this);//activar el listener 
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Jtpuntaje = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Jtnivel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Bpausa = new javax.swing.JButton();
        Bplay = new javax.swing.JButton();
        Breset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 39, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(233, 74, 218));
        jLabel2.setText("Puntaje :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Jtpuntaje.setBackground(new java.awt.Color(1, 39, 61));
        Jtpuntaje.setForeground(new java.awt.Color(233, 74, 218));
        jPanel1.add(Jtpuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 40, -1));

        jLabel3.setForeground(new java.awt.Color(233, 74, 218));
        jLabel3.setText("Nivel:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        Jtnivel.setEditable(false);
        Jtnivel.setBackground(new java.awt.Color(1, 39, 61));
        Jtnivel.setForeground(new java.awt.Color(233, 74, 218));
        jPanel1.add(Jtnivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 50, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(233, 74, 218));
        jLabel4.setText("GALAXI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 140, 30));

        Bpausa.setText("Pausa");
        Bpausa.setContentAreaFilled(false);
        Bpausa.setFocusPainted(false);
        Bpausa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BpausaMouseClicked(evt);
            }
        });
        jPanel1.add(Bpausa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        Bplay.setText("Play");
        Bplay.setContentAreaFilled(false);
        Bplay.setFocusPainted(false);
        Bplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BplayMouseClicked(evt);
            }
        });
        jPanel1.add(Bplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        Breset.setText("Reset");
        Breset.setContentAreaFilled(false);
        Breset.setFocusPainted(false);
        jPanel1.add(Breset, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlos\\Downloads\\NaveEspacial\\src\\resources\\img\\Juego\\iFondoJuego2.jpg")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 940));
    }// </editor-fold>//GEN-END:initComponents

    private void BpausaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BpausaMouseClicked
        setSrtStp(false);
    }//GEN-LAST:event_BpausaMouseClicked

    private void BplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BplayMouseClicked
        setSrtStp(true);
    }//GEN-LAST:event_BplayMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bpausa;
    private javax.swing.JButton Bplay;
    private javax.swing.JButton Breset;
    private javax.swing.JTextField Jtnivel;
    private javax.swing.JTextField Jtpuntaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
public void paint(Graphics g) {
        setOpaque(false);
        super.paint(g);
        Graphics2D Nave = (Graphics2D) g;
        Toolkit tnave = Toolkit.getDefaultToolkit();
        Image imgnave = tnave.getImage("src/resources/img/iNaveespacial.png");//Cargar imagen nave espacial
        Nave.drawImage(imgnave, x, 700, this);
        Graphics2D Bala = (Graphics2D) g;
        Toolkit tbala = Toolkit.getDefaultToolkit();
        Image imgbala = tbala.getImage("src/resources/img/iLaser.png");//Cargar imagen Laser
        Bala.drawImage(imgbala, Balax, Balay, this);
        Graphics2D Mett1 = (Graphics2D) g;
        Toolkit tMet1 = Toolkit.getDefaultToolkit();
        Image imgmet1 = tMet1.getImage("src/resources/img/iMeteoritot1.png");//Cargar imagen Meteorito
        Mett1.drawImage(imgmet1, M1ubicacion, Caer, this);
        Graphics2D Mett2 = (Graphics2D) g;
        Toolkit tMet2 = Toolkit.getDefaultToolkit();
        Image imgmet2 = tMet2.getImage("src/resources/img/iMeteoritot2.png");//Cargar imagen Meteorito 2
        Mett2.drawImage(imgmet2, M2ubicacion, Caer, this);
        Graphics2D Mett3 = (Graphics2D) g;
        Toolkit tMet3 = Toolkit.getDefaultToolkit();
        Image imgmet3 = tMet3.getImage("src/resources/img/iMeteoritot3.png");//Cargar imagen Meteorito3
        Mett3.drawImage(imgmet3, M3ubicacion, Caer, this);
        Graphics2D Mett4 = (Graphics2D) g;
        Toolkit tMet4 = Toolkit.getDefaultToolkit();
        Image imgmet4 = tMet4.getImage("src/resources/img/iMeteoritot4.png");//Cargar imagen Meteorito4
        Mett4.drawImage(imgmet4, M4ubicacion, Caer, this);
        hilo = new Thread(this);
        if (srtStp) {
            hilo.start();

        } else {
            hilo.interrupt();
        }
        try {

            Thread.sleep(8);
        } catch (InterruptedException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

        repaint();
    }

    @Override
    public void run() {
        mover();
        Disparo();
        aumentarnivel();
    }

    public void mover() {

        Caer++;
 
      
          }

    public void Disparo() {
        Balay--;
    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if ((me.getX() >= 0 && me.getY() >= 0) && (me.getX() <= this.getWidth()) && me.getY() <= this.getHeight() - 100) {
            x = me.getX();
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        Balax = x+50;
        Balay = 700;
     

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
   
public void setSrtStp(boolean srtStp) {
        this.srtStp = srtStp;
    }

    public boolean isSrtStp() {
        return srtStp;
    }
    
    public void aumentarnivel(){
     
            Nivel =  Nivel++;
         
    }
   
}
