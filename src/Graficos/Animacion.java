/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase para las animaciones 
 **
 * ****************************************************************************/
package Graficos;

import java.awt.image.BufferedImage;

import Calculos.Vector2D;
/**
 * 
 * @author Carlos Aurelio Alcantara Perez
 */
public class Animacion {
    /**
     * Las variables que se muestran aqui sirven para saber en donde se mostrara
     * la animacion
     */
    private BufferedImage[] frames;
    private int velocidad;
    private int indice;
    private boolean running;
    private Vector2D posicion;
    private long tiempo, tiempoFinal;
    /**
     * Constructor con parametros 
     * @param frames Velocidad de muestreo de imagenes 
     * @param velocity Velocidad de movimiento de los objetos
     * @param position posición de los objetos 
     */
    public Animacion(BufferedImage[] frames, int velocity, Vector2D position) {
        this.frames = frames;
        this.velocidad = velocity;
        this.posicion = position;
        indice = 0;
        running = true;
        tiempo = 0;
        tiempoFinal = System.currentTimeMillis();
    }
    /**
     * Actualizar la animacion 
     */
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
    /**
     * Saber si la animacion esta en ejecucion 
     * @return 
     */
    public boolean isRunning() {
        return running;
    }
    /**
     * obtener la posición de la animacion
     * @return 
     */
    public Vector2D getPosition() {
        return posicion;
    }
    /**
     * Saber cuantas imagenes por segundo se mostraran 
     * @return 
     */
    public BufferedImage getCurrentFrame() {
        return frames[indice];
    }

}
