/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase de la nave enemiga
 *
 * ****************************************************************************/
package Objetos;

import Estados.EstadoJuego;
import Graficos.Assets;
import Math.Vector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author labdessw09
 */
public class Ufo extends Movimiento{
	
	private ArrayList<Vector> path;
	
	private Vector currentNode;
	
	private int index;
	
	private boolean following;
	
	private Cronometro fireRate;
	
	public Ufo(Vector position, Vector velocity, double maxVel, BufferedImage texture,
			ArrayList<Vector> path, EstadoJuego gameState) {
		super(position, velocity, maxVel, texture, gameState);
		this.path = path;
		index = 0;
		following = true;
		fireRate = new Cronometro();
		fireRate.run(Constantes.UFO_FIRE_RATE);
	}
	
	private Vector pathFollowing() {
		currentNode = path.get(index);
		
		double distanceToNode = currentNode.subtract(getCenter()).getMagnitude();
		
		if(distanceToNode < Constantes.NODE_RADIUS) {
			index ++;
			if(index >= path.size()) {
				following = false;
			}
		}
		
		return seekForce(currentNode);
		
	}
	
	private Vector seekForce(Vector target) {
		Vector desiredVelocity = target.subtract(getCenter());
		desiredVelocity = desiredVelocity.normalize().scale(maxVel);
		return desiredVelocity.subtract(velocity);
	}
	
	@Override
	public void update() {
		
		Vector pathFollowing;
		
		if(following)
			pathFollowing = pathFollowing();
		else
			pathFollowing = new Vector();
		
		pathFollowing = pathFollowing.scale(1/Constantes.UFO_MASS);
		
		velocity = velocity.add(pathFollowing);
		
		velocity = velocity.limit(maxVel);
		
		position = position.add(velocity);
		
		if(position.getX() > Constantes.WIDTH || position.getY() > Constantes.HEIGHT
				|| position.getX() < 0 || position.getY() < 0)
			Destroy();
		
		// shoot
		
		if(!fireRate.isRunning()) {
			
			Vector toPlayer = gameState.getPlayer().getCenter().subtract(getCenter());
			
			toPlayer = toPlayer.normalize();
			
			double newAngle = toPlayer.getAngle();
			
		//	double newAngle = Math.random()*(Math.PI) - Math.PI/2 + currentAngle;
                       
                        newAngle += Math.random()*Constantes.UFO_ANGLE_RANGE - Constantes.UFO_ANGLE_RANGE / 2;
			
			if(toPlayer.getX() < 0)
				newAngle = -newAngle + Math.PI;
                        
			
			toPlayer = toPlayer.setDirection(newAngle);
			
			Bala laser = new Bala(
					getCenter().add(toPlayer.scale(width)),
					toPlayer,
					Constantes.LASER_VEL,
					newAngle + Math.PI/2,
					Assets.redLaser,
					gameState
					);
			
			gameState.getMovingObjects().add(0, laser);
			
			fireRate.run(Constantes.UFO_FIRE_RATE);
			
		}
		
		angle += 0.05;
		
		collidesWith();
		fireRate.update();
	}
        
        @Override
	public void Destroy() {
		gameState.addScore(Constantes.UFO_SCORE, position);
		super.Destroy();
	}

	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
		
		at.rotate(angle, width/2, height/2);
		
		g2d.drawImage(texture, at, null);

	}
}
