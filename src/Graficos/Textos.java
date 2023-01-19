/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Aqui se crean los textos 
 *
 * ****************************************************************************/
package Graficos;

import Math.Vector;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *En sesta Clase solo se crean textos 
 * @author carlos
 */
public class Textos {
    public static void drawText(Graphics g, String text, Vector pos, boolean center, Color color, Font font) {
		g.setColor(color);
		g.setFont(font);
		Vector position = new Vector(pos.getX(), pos.getY());
		
		if(center) {
			FontMetrics fm = g.getFontMetrics();
			position.setX(position.getX() - fm.stringWidth(text) / 2);
			position.setY(position.getY() - fm.getHeight() / 2);
			
		}
		
		g.drawString(text, (int)position.getX(), (int)position.getY());
		
	}
}
