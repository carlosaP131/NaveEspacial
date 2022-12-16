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

        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\carlos\\Downloads\\NaveEspacial\\src\\resources\\img\\Fjuego2.jpg")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 940));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
public void paint(Graphics g) {
        setOpaque(false);
        super.paint(g);
        Graphics2D Nave = (Graphics2D) g;
        Toolkit t2 = Toolkit.getDefaultToolkit();
        Image imgnave = t2.getImage("C:\\Users\\carlos\\Downloads\\NaveEspacial\\src\\resources\\img\\iNaveespacial.png");//Cargar imagen pelota1
        Nave.drawImage(imgnave, x, y, this);
        Graphics2D Bala = (Graphics2D) g;
        Toolkit t2 = Toolkit.getDefaultToolkit();
        Image imgbala = t2.getImage("C:\\Users\\carlos\\Downloads\\NaveEspacial\\src\\resources\\img\\i");//Cargar imagen pelota1
        Bala.drawImage(imgbala, x, y, this);
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
