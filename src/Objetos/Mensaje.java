/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Clase para los mensajes
 *
 * ****************************************************************************/
package Objetos;

import Estados.EstadoJuego;
import Graficos.Textos;
import Math.Vector;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author labdessw09
 */
public class Mensaje {
    private EstadoJuego gameState;
	private float alpha;
	private String text;
	private Vector position;
	private Color color;
	private boolean center;
	private boolean fade;
	private Font font;
	private final float deltaAlpha = 0.01f;
	private boolean dead;
	public Mensaje(Vector position, boolean fade, String text, Color color,
			boolean center, Font font) {
		this.font = font;
		this.text = text;
		this.position = position;
		this.fade = fade;
		this.color = color;
		this.center = center;
		this.dead = false;
		
		if(fade)
			alpha = 1;
		else
			alpha = 0;
		
	}
	
	public void draw(Graphics2D g2d) {
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		
		Textos.drawText(g2d, text, position, center, color, font);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
		
		position.setY(position.getY() - 1);
		
		if(fade)
			alpha -= deltaAlpha;
		else
			alpha += deltaAlpha;
		
		if(fade && alpha < 0) {
			gameState.getMessages().remove(this);
		}
		
		if(!fade && alpha > 1) {
			fade = true;
			alpha = 1;
		}
		
		
	}
	public boolean isDead() {return dead;}
}
