/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *      Sainos Hernández Baldomero.
 *Fecha de creación: 25- 11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Panel para el inicio de sesion
 **
 * *************************************************************************** */
package view;

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
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Juego extends JFrame implements Runnable {

    //Declaracion de las variables.
    private static final long serialVersionUID = 1L;

    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private final int FPS = 60;
    private double TARGETTIME = 1000000000 / FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;

    private EstadoJuego gameState;
    private KeyBoard keyBoard;

    private BufferedImage imgFondo;

    public Juego() {
        setTitle("Galaxi");
        setSize(Constantes.WIDTH, Constantes.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        keyBoard = new KeyBoard();

        canvas.setPreferredSize(new Dimension(Constantes.WIDTH,
                Constantes.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constantes.WIDTH,
                Constantes.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constantes.WIDTH,
                Constantes.HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        setVisible(true);

                try {
            File archivo = new File("src/view/espacio1.jpg");
            imgFondo = ImageIO.read(archivo);
                    System.err.println("Archivo encontrado: " + archivo.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Juego().start();
    }

    private void update() {
        keyBoard.update();
        gameState.update();
    }
    

    private void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //-----------------------
        // Asignación del fondo del juego
        g.drawImage(imgFondo, 0, 0, this);
        //g.dispose();
        
        
        
        //this.setOpaque(false);
        //super.paint(g);
        //g.setColor(Color.ORANGE);

        //revisar esta línea de código
        //g.fillRect(0, 0, Constantes.WIDTH, Constantes.HEIGHT);

        gameState.draw(g);

        g.setColor(Color.WHITE);

        g.drawString("" + AVERAGEFPS, 10, 20);

        //---------------------
        g.dispose();
        bs.show();
    }

    private void init() {
        Assets.init();
        gameState = new EstadoJuego();
    }

    @Override
    public void run() {
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;
        init();

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

    private void start() {
        thread = new Thread(this);
        thread.start();
        running = true;

    }

    private void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
