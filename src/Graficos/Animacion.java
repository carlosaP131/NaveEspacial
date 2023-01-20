package Graficos;

import java.awt.image.BufferedImage;

import Calculos.Vector2D;

public class Animacion {

    private BufferedImage[] frames;
    private int velocidad;
    private int indice;
    private boolean running;
    private Vector2D posicion;
    private long tiempo, tiempoFinal;

    public Animacion(BufferedImage[] frames, int velocity, Vector2D position) {
        this.frames = frames;
        this.velocidad = velocity;
        this.posicion = position;
        indice = 0;
        running = true;
        tiempo = 0;
        tiempoFinal = System.currentTimeMillis();
    }

    public void update() {

        tiempo += System.currentTimeMillis() - tiempoFinal;
        tiempoFinal = System.currentTimeMillis();

        if (tiempo > velocidad) {
            tiempo = 0;
            indice++;
            if (indice >= frames.length) {
                running = false;
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public Vector2D getPosition() {
        return posicion;
    }

    public BufferedImage getCurrentFrame() {
        return frames[indice];
    }

}
