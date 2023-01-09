/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estados;

import java.awt.Graphics;

/**
 *
 * @author carlos
 */
public abstract class Estado {
    private static Estado Estadoconcurrencia = null;
	
	public static Estado getCurrentState() {return Estadoconcurrencia;}
	public static void changeState(Estado newState) {
		Estadoconcurrencia = newState;
	}
	
	
	public abstract void update();
	public abstract void draw(Graphics g);
	
}
