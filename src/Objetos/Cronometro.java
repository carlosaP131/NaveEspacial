/** ****************************************************************************
 *Autor:Baldomero Sainos Hernandez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase que cuenta el tiempo 
 *
 * ****************************************************************************/
package Objetos;

/**
 *
 * @author Sainos
 */
public class Cronometro {
    private long delta, lastTime;
	private long time;
	private boolean running;
	
	public Cronometro(){
		delta = 0;
		lastTime = 0;
		running = false;
	}
	
	public void run(long time){
		running = true;
		this.time = time;
	}
	
	public void update(){	
		if(running)
			delta += System.currentTimeMillis() - lastTime;
		if(delta >= time){
			running = false;
			delta = 0;
		}
		
		lastTime = System.currentTimeMillis();
	}
	
	public boolean isRunning(){
		return running;
	}
}
