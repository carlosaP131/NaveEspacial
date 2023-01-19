/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase de animaciones
 *
 * ****************************************************************************/
package Graficos;

import Math.Vector;
import java.awt.image.BufferedImage;

/**
 *
 * @author Carlos
 */
public class Animacion {
        /**
         * Se declara un Bufferedimage para mostrar las imagenes
         * dos variables int para la velocidad y el control de los ciclos 
         * un boleano para la pausa y reanudacion del juego una instancia de la 
         * clase vector para saber la posicion en donde sera puesta la animacion
         * y una variable long para el tiempo 
         */
	private final BufferedImage[] frames;
	private final int velocidad;
	private int index;
	private boolean running;
	private final Vector posicion;
	private long time, lastTime;
	/**
         * Constructor que recive tres variables la imagen la velocidad y la posicion
         * @param frames
         * @param velocity
         * @param position 
         */
	public Animacion (BufferedImage[] frames, int velocity, Vector position){
            /**
             *Declaracion de las variables 
             */
            this.frames = frames;
		this.velocidad = velocity;
		this.posicion = position;
		index = 0;
		running = true;
		time = 0;
		lastTime = System.currentTimeMillis();
	}
	/**
         * metodo de actualizacion de estados 
         */
	public void update(){
		
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(time > velocidad){
			time  = 0;
			index ++;
			if(index >= frames.length){
				running = false;
			}
		}
	}
        /**
         * metodo para saber si esta corriendo el juego
         * @return 
         */
	public boolean isRunning() {
		return running;
	}
        /**
         * metodo para obtener la posicion 
         * @return 
         */
	public Vector getPosition() {
		return posicion;
	}
	/**
         * Metodo para obtener la imagen 
         * @return 
         */
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
	
	
	
}
