package View;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import Objetos.Constantes;
import Graficos.Assets;
import Input.Teclas;
import Input.MovimientoMouse;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import Estados.EstadoCarga;
import Estados.Estado;

public class Juego extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private Canvas canvas;
    private Thread hilo;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private final int FPS = 60;
    private double tiempo = 1000000000 / FPS;
    private double delta = 0;
    private int promedioFPS = FPS;

    private Teclas keyBoard;
    private MovimientoMouse mouseInput;

    private BufferedImage imgFondo;
    int idJugador;

    public Juego() {
        setTitle("Juego de Nave & Ateroides");
        setSize(Constantes.WIDTH, Constantes.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        keyBoard = new Teclas();
        mouseInput = new MovimientoMouse();

        canvas.setPreferredSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        setVisible(true);
        try {
            File archivo = new File("src/ImagenesObjetos/image.jpg");
            imgFondo = ImageIO.read(archivo);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Juego().start();
    }

    Juego(int idJugador) {
        this.idJugador=idJugador;
        setTitle("Juego de Nave & Ateroides");
        setSize(Constantes.WIDTH, Constantes.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        keyBoard = new Teclas();
        mouseInput = new MovimientoMouse();

        canvas.setPreferredSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constantes.WIDTH, Constantes.HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        setVisible(true);
        try {
            File archivo = new File("src/ImagenesObjetos/image.jpg");
            imgFondo = ImageIO.read(archivo);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void update() {
        keyBoard.update();
        Estado.getCurrentState().update();
    }

    public void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //-----------------------
        g.fillRect(0, 0, Constantes.WIDTH, Constantes.HEIGHT);

        g.drawImage(imgFondo, 0, 0, this);

        Estado.getCurrentState().draw(g);

        g.setColor(Color.WHITE);

        g.drawString("" + promedioFPS, 10, 20);

        //---------------------
        g.dispose();
        bs.show();
    }

    public void init() {

        Thread loadingThread = new Thread(new Runnable() {

            @Override
            public void run() {
                Assets.init();
            }
        });

        Estado.changeState(new EstadoCarga(loadingThread));
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
            delta += (now - lastTime) / tiempo;
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                update();
                draw();
                delta--;
                frames++;
            }
            if (time >= 1000000000) {
                promedioFPS = frames;
                frames = 0;
                time = 0;

            }

        }

        stop();
    }

    public void start() {

        hilo = new Thread(this);
        hilo.start();
        running = true;

    }

    public void stop() {
        try {
            hilo.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
