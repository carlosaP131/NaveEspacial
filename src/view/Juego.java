/** ****************************************************************************
 *Autores:Carlos Aurelio Alcántara Pérez & Baldomero Sainos Hernández.
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:20-12-2022
 *Descripción:Panel para la portada del juego, donde se va a mover los ateroides,
 * naves y balas.
 *
 * *************************************************************************** */
package view;

/**
 * Importación de los paquetes.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase donde se declaran las variables y se inicialización.
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

    /**
     * Se activa la escucha del gragged.
     */
    public Juego() {
        initComponents();
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }
    //En está clase de definirá el puntaje del juegog de las naves del jugador.
    public class Score implements Comparable<Score>, Serializable {
        //Definición de las variables para el puntaje.
        private String name;
        private int points;
        private int puntaje;

        public Score(String name, int score) {
            this.name = name;
            this.points = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
        //Método abstracto para comparar el puntaje de los jugadores.
        @Override
        public int compareTo(Score o) {
            if (this.points < o.points) {
                return 1;
            } else if (this.points > o.points) {
                return -1;
            } else {
                return 0;
            }
        }

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 50, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(233, 74, 218));
        jLabel4.setText("GALAXI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 140, 30));

        jButton1.setText("Pausa");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jButton2.setText("Play");
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jButton3.setText("Reset");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jLabel1.setBackground(new java.awt.Color(1, 39, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/iFondoJuego2.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 940));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    /**
     * Método paint para pintar la neve, la bla y los meteoritos para el juego,
     * mediante hilos.
     */
    public void paint(Graphics g) {

        setOpaque(false);
        super.paint(g);
        Graphics2D Nave = (Graphics2D) g;
        Toolkit tnave = Toolkit.getDefaultToolkit();
        Image imgnave = tnave.getImage("src/resources/img/iNaveespacial.png");//Cargar imagen pelota1
        Nave.drawImage(imgnave, x, 700, this);
        Graphics2D Bala = (Graphics2D) g;
        Toolkit tbala = Toolkit.getDefaultToolkit();
        Image imgbala = tbala.getImage("src/resources/img/iLaser.png");//Cargar imagen pelota1
        Bala.drawImage(imgbala, Balax, Balay, this);
        Graphics2D Mett1 = (Graphics2D) g;
        Toolkit tMet1 = Toolkit.getDefaultToolkit();
        Image imgmet1 = tMet1.getImage("src/resources/img/iMeteoritot1.png");//Cargar imagen pelota1
        Mett1.drawImage(imgmet1, M1ubicacion, Caer, this);
        Graphics2D Mett2 = (Graphics2D) g;
        Toolkit tMet2 = Toolkit.getDefaultToolkit();
        Image imgmet2 = tMet2.getImage("src/resources/img/iMeteoritot2.png");//Cargar imagen pelota1
        Mett2.drawImage(imgmet2, M2ubicacion, Caer, this);
        Graphics2D Mett3 = (Graphics2D) g;
        Toolkit tMet3 = Toolkit.getDefaultToolkit();
        Image imgmet3 = tMet3.getImage("src/resources/img/iMeteoritot3.png");//Cargar imagen pelota1
        Mett3.drawImage(imgmet3, M3ubicacion, Caer, this);
        Graphics2D Mett4 = (Graphics2D) g;
        Toolkit tMet4 = Toolkit.getDefaultToolkit();
        Image imgmet4 = tMet4.getImage("src/resources/img/iMeteoritot4.png");//Cargar imagen pelota1
        Mett4.drawImage(imgmet4, M4ubicacion, Caer, this);
        hilo = new Thread(this);
        hilo.start();
        try {

            Thread.sleep(8);
        } catch (InterruptedException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

        repaint();
    }

    /**
     * Método abstracto run para disparar y mover la neve, este método
     * especifica realmente la tarea a realizar.
     */
    @Override
    public void run() {
        mover();
        Disparo();
    }

    /**
     * Método mover donde se incrementa a caer.
     */
    public void mover() {
        Caer++;
    }

    /**
     * Método dispara las balas d ela nave.
     */
    public void Disparo() {
        Balay--;
    }

    /**
     * Método abstracto para sobrescribir a mouseDragged.
     */
    @Override
    public void mouseDragged(MouseEvent me) {

    }

    /**
     * Método abstracto controlar la nave con el mouse.
     */
    @Override
    public void mouseMoved(MouseEvent me) {
        if ((me.getX() >= 0 && me.getY() >= 0) && (me.getX() <= this.getWidth()) && me.getY() <= this.getHeight() - 100) {
            x = me.getX();

        }
    }

    /**
     * Método abstracto controlar los disparos de nave con el mouse.
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        Balax = me.getX();
        Balay = me.getY();

    }

    /**
     * Métodos abstractos que se implemetaran posteriormente.
     */
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

}
