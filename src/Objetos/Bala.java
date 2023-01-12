/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import Estados.EstadoJuego;
import Math.Vector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author labdessw09
 */
public class Bala extends Movimiento {
   public Bala(Vector position, Vector velocity, double maxVel, double angle, BufferedImage texture, EstadoJuego gameState) {
		super(position, velocity, maxVel, texture, gameState);
		this.angle = angle;
		this.velocity = velocity.scale(maxVel);
	}

	@Override
	public void update() {
		position = position.add(velocity);
		if(position.getX() < 0 || position.getX() > Constantes.WIDTH ||
				position.getY() < 0 || position.getY() > Constantes.HEIGHT){
			Destroy();
		}
		
		collidesWith();
		
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		at = AffineTransform.getTranslateInstance(position.getX() - width/2, position.getY());
		
		at.rotate(angle, width/2, 0);
		
		g2d.drawImage(texture, at, null);
		
	}
	
	@Override
	public Vector getCenter(){
		return new Vector(position.getX() + width/2, position.getY() + width/2);
	} 
}
