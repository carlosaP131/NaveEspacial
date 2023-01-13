/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase abstracta para los objetos y su posicion junto con su textura 
 * ****************************************************************************/
package Objetos;

import Math.Vector;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author labdessw09
 */
public abstract class ObjetosJuego {
    protected BufferedImage texture;
	protected Vector position;
	
	public ObjetosJuego(Vector position, BufferedImage texture)
	{
		this.position = position;
		this.texture = texture;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}
	
}
