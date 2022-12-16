/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Panel para la portada 
 *
 * ****************************************************************************/
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
public class Juego extends javax.swing.JPanel implements Runnable,MouseListener{
    private int x;
    private int y;
    private int Mousex;
    private int Mousey;
    private Thread hilo;
    public Juego() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 39, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(233, 74, 218));
        jLabel2.setText("Puntaje :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTextField1.setBackground(new java.awt.Color(1, 39, 61));
        jTextField1.setForeground(new java.awt.Color(233, 74, 218));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 40, -1));

        jLabel3.setForeground(new java.awt.Color(233, 74, 218));
        jLabel3.setText("Nivel:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(1, 39, 61));
        jTextField2.setForeground(new java.awt.Color(233, 74, 218));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 30, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(233, 74, 218));
        jLabel4.setText("GALAXI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 140, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/Fjuego2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 940));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
public void paint(Graphics g) {
        setOpaque(false);
        super.paint(g);
        Graphics2D Nave = (Graphics2D) g;
        Toolkit tnave = Toolkit.getDefaultToolkit();
        Image imgnave = tnave.getImage("src/resources/img/iNaveespacial.png");//Cargar imagen pelota1
        Nave.drawImage(imgnave, x+10, y+30, this);
        Graphics2D Bala = (Graphics2D) g;
        Toolkit tbala = Toolkit.getDefaultToolkit();
        Image imgbala = tbala.getImage("src/resources/img/iLaser.png");//Cargar imagen pelota1
        Bala.drawImage(imgbala, x+80, y+120, this);
        Graphics2D Mett1 = (Graphics2D) g;
        Toolkit tMet1 = Toolkit.getDefaultToolkit();
        Image imgmet1 = tMet1.getImage("src/resources/img/iMeteoritot1.png");//Cargar imagen pelota1
        Mett1.drawImage(imgmet1, x+120, y+150, this);
        Graphics2D Mett2 = (Graphics2D) g;
        Toolkit tMet2 = Toolkit.getDefaultToolkit();
        Image imgmet2 = tMet2.getImage("src/resources/img/iMeteoritot2.png");//Cargar imagen pelota1
        Mett2.drawImage(imgmet2, x+150, y+200, this);
        Graphics2D Mett3 = (Graphics2D) g;
        Toolkit tMet3 = Toolkit.getDefaultToolkit();
        Image imgmet3 = tMet3.getImage("src/resources/img/iMeteoritot3.png");//Cargar imagen pelota1
        Mett3.drawImage(imgmet3, x+160, y+250, this);
        Graphics2D Mett4 = (Graphics2D) g;
        Toolkit tMet4 = Toolkit.getDefaultToolkit();
        Image imgmet4 = tMet4.getImage("src/resources/img/iMeteoritot4.png");//Cargar imagen pelota1
        Mett4.drawImage(imgmet4, x+135, y+300, this);
        hilo = new Thread(this);
        hilo.start();
        try {

            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

        repaint();
    }
    @Override
    public void run() {
       
    
    }

    

   

    @Override
    public void mouseClicked(MouseEvent e) {
     x= e.getX();
      y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
