/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graficos;

import Math.Vector;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author labdessw09
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
