/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import Math.Vector;
import java.awt.image.BufferedImage;

/**
 *
 * @author labdessw09
 */
public class Animacion {
    
	private BufferedImage[] frames;
	private int velocity;
	private int index;
	private boolean running;
	private Vector position;
	private long time, lastTime;
	
	public Animacion (BufferedImage[] frames, int velocity, Vector position){
		this.frames = frames;
		this.velocity = velocity;
		this.position = position;
		index = 0;
		running = true;
		time = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void update(){
		
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(time > velocity){
			time  = 0;
			index ++;
			if(index >= frames.length){
				running = false;
			}
		}
	}

	public boolean isRunning() {
		return running;
	}

	public Vector getPosition() {
		return position;
	}
	
	public BufferedImage getCurrentFrame(){
		return frames[index];
	}
	
	
	
	
}
