package view;
//Importación de librerias.

import Estados.EstadoJuego;
import Graficos.Assets;
import Input.KeyBoard;
import Objetos.Constantes;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class Juego extends JFrame implements Runnable {

    /**
     * Se declaran las estancias a las diferentes clases a ocupar y variables
     * locales
     */
    private static final long serialVersionUID = 1L;
    // Canvas nos sirve para cargar el fondo 
    private Canvas canvas;
    // thred es el hilo para los objetos con movimiento 
    private Thread thread;
    //esta declaracion booleana nos sirvepara pausar los hilos 
    private boolean running = false;
    //crea las imagenes
    private BufferStrategy bs;
    //clase grapis para mostrar(dibujar) las imagenes
    private Graphics g;
    //imagenes por segundo que se  mostraran en pantalla 
    private final int FPS = 60;
    private double TARGETTIME = 1000000000 / FPS;
    //angulo de los objetos 
    private double delta = 0;
    //nivel de fps
    private int AVERAGEFPS = FPS;
    /*
    * Istancia de la clase EstadoJuego que nos ayuda a saber en que estado se 
    * encuentran nuestros objetos 
     */

    private EstadoJuego gameState;
    /*
      Instancia para las teclas de juego 
     */
    private KeyBoard keyBoard;
    /*
      Instancia para el fondo del juego 
     */
    private BufferedImage imgFondo;

    /*
    *constructor 
     */
    public Juego() {
        setTitle("Galaxi");//titulo
        setSize(Constantes.WIDTH, Constantes.HEIGHT);//tamaño del frame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrado del frame 
        setResizable(false);//no se puede hacer mas grande 
        setLocationRelativeTo(null);//centrar en la pantalla 

        canvas = new Canvas();//declaracion del canvas
        keyBoard = new KeyBoard();//declaracion de la clase de las teclas  
        /**
         * Esta es la dimencion del fondo y del mismo frame
         */
        canvas.setPreferredSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        setVisible(true);
        //Bloque try para cargar la imagen de fondo del juego
        try {
            File archivo = new File("src/Graficos/iJuego2.jpg");
            imgFondo = ImageIO.read(archivo);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    /**
     * Metodo main
     *
     * @param args
     */
    public static void main(String[] args) {
        new Juego().start();
    }

    /**
     * Actualiza los estados del juego y las teclas precionadas
     */
    private void update() {
        keyBoard.update();
        gameState.update();
    }

    /**
     * Metodo para dibujar las imagenes
     */
    private void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        
        // Asignación de fondo al juego.
        g.fillRect(0, 0, Constantes.WIDTH, Constantes.HEIGHT);
        
        g.drawImage(imgFondo, 0, 0, this);
        
        gameState.draw(g);

        g.setColor(Color.WHITE);

        g.drawString("" + AVERAGEFPS, 10, 20);

        //---------------------
        g.dispose();
        bs.show();
    }

    /**
     * Cargar las direcciones de todos los elementos a usar
     *
     * @throws UnsupportedAudioFileException
     */
    private void init() throws UnsupportedAudioFileException {
        Assets.init();
        gameState = new EstadoJuego();
    }

    /**
     * Metodo para ejecutar los Hilos
     */
    @Override
    public void run() {

        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        try {
            init();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                update();
                draw();
                delta--;
                frames++;
            }
            if (time >= 1000000000) {
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;

            }

        }

        stop();
    }

    /**
     * Metodo para comenzar el juego
     */
    private void start() {

        thread = new Thread(this);
        thread.start();
        running = true;

    }

    /**
     * Metodo para parar el juego
     */
    private void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
