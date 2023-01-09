/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Estados.EstadoJuego;
import Math.Vector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author labdessw09
 */
public abstract class Movimiento extends ObjetosJuego {
    protected Vector velocity;
	protected AffineTransform at;
	protected double angle;
	protected double maxVel;
	protected int width;
	protected int height;
	protected EstadoJuego gameState;
	
	public Movimiento(Vector position, Vector velocity, double maxVel, BufferedImage texture, EstadoJuego gameState) {
		super(position, texture);
		this.velocity = velocity;
		this.maxVel = maxVel;
		this.gameState = gameState;
		width = texture.getWidth();
		height = texture.getHeight();
		angle = 0;
		
	}
	
	protected void collidesWith(){
		
		ArrayList<Movimiento> movingObjects = gameState.getMovingObjects(); 
		
		for(int i = 0; i < movingObjects.size(); i++){
			
			Movimiento m  = movingObjects.get(i);
			
			if(m.equals(this))
				continue;
			
			double distance = m.getCenter().subtract(getCenter()).getMagnitude();
			
			if(distance < m.width/2 + width/2 && movingObjects.contains(this)){
				objectCollision(m, this);
			}
		}
	}
	
	private void objectCollision(Movimiento a, Movimiento b){
		
		if(!(a instanceof Meteorito && b instanceof Meteorito)){
			a.Destroy();
			b.Destroy();
		}
		
	}
	
	
	protected void Destroy(){
		gameState.getMovingObjects().remove(this);
	}
	
	protected Vector getCenter(){
		return new Vector(position.getX() + width/2, position.getY() + height/2);
	}
	
}
