/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase Meteorito
 *
 * ****************************************************************************/
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
public class Meteorito extends Movimiento{
    private Size size;
	
	public Meteorito(Vector position, Vector velocity, double maxVel, BufferedImage texture, EstadoJuego gameState, Size size) {
		super(position, velocity, maxVel, texture, gameState);
		this.size = size;
		this.velocity = velocity.scale(maxVel);
		
	}

	@Override
	public void update() {
		position = position.add(velocity);
		
		if(position.getX() > Constantes.WIDTH)
			position.setX(-width);
		if(position.getY() > Constantes.HEIGHT)
			position.setY(-height);
		
		if(position.getX() < -width)
			position.setX(Constantes.WIDTH);
		if(position.getY() < -height)
			position.setY(Constantes.HEIGHT);
		
		angle += Constantes.DELTAANGLE/2;
		
	}
	
	@Override
	public void Destroy(){
	
		super.Destroy();
	}
	
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
		
		at.rotate(angle, width/2, height/2);
		
		g2d.drawImage(texture, at, null);
	}

	public Size getSize(){
		return size;
	}
	
}
