/** ****************************************************************************
 *Autor:Carlos Sainos Hernández Baldomero
 *Fecha de creación: 25/12/2022 ***
 *Fecha de actualización:13/01/2023
 *Descripción:Clase para controlar las vidas del jugador y que reaparezaca.
 *
 * ****************************************************************************/
package Objetos;

import Estados.EstadoJuego;
import Graficos.Assets;
import Input.KeyBoard;
import Math.Vector;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author labdessw09
 */
public class JugadorJuego extends Movimiento {
    private Vector heading;	
	private Vector acceleration;

	private boolean accelerating = false;
	private Cronometro fireRate;
        
        private boolean spawning, visible;
	
	private Cronometro spawnTime, flickerTime; //flickerTime parpadear

	public JugadorJuego(Vector position, Vector velocity, double maxVel, BufferedImage texture, EstadoJuego gameState) {
		super(position, velocity, maxVel, texture, gameState);
		heading = new Vector(0, 1);
		acceleration = new Vector();
		fireRate = new Cronometro();
                spawnTime  =new Cronometro();
                flickerTime = new Cronometro();
                
	}
	/* Método abstracto para que la neve vuelve a reaparecer y controlar sus 
        vidas, pero cuando esta reapareciendo el jugador no puede disparar y 
        tampoco puede moriri poruqe esta reapareciendo.*/
	@Override
	public void update() 
	{   
            //Condicion para ocultar y reaparecer a la neve cunado es atropellado por un meteorito.
            // En la segundo if se controla que cunado va apareciendo no puede disparar.
                if(!spawnTime.isRunning()) {
			spawning = false;
			visible = true;
		}
		
		if(spawning) {
			
			if(!flickerTime.isRunning()) {
				
				flickerTime.run(Constantes.FLICKER_TIME);
				visible = !visible;
				
			}
			
		}
		
		
		if(KeyBoard.SHOOT &&  !fireRate.isRunning())
		{		
			gameState.getMovingObjects().add(0,new Bala(
					getCenter().add(heading.scale(width)),
					heading,
					Constantes.LASER_VEL,
					angle,
					Assets.blueLaser,
					gameState
					));
			fireRate.run(Constantes.FIRERATE);
		}
		
		
		if(KeyBoard.RIGHT)
			angle += Constantes.DELTAANGLE;
		if(KeyBoard.LEFT)
			angle -= Constantes.DELTAANGLE;
		
		if(KeyBoard.UP)
		{
			acceleration = heading.scale(Constantes.ACC);
			accelerating = true;
		}else
		{
			if(velocity.getMagnitude() != 0)
				acceleration = (velocity.scale(-1).normalize()).scale(Constantes.ACC/2);
			accelerating = false;
		}
		
		velocity = velocity.add(acceleration);
		
		velocity = velocity.limit(maxVel);
		
		heading = heading.setDirection(angle - Math.PI/2);
		
		position = position.add(velocity);
		
		if(position.getX() > Constantes.WIDTH)
			position.setX(0);
		if(position.getY() > Constantes.HEIGHT)
			position.setY(0);
		
		if(position.getX() < 0)
			position.setX(Constantes.WIDTH);
		if(position.getY() < 0)
			position.setY(Constantes.HEIGHT);
		
		
		fireRate.update();
                spawnTime.update();
                fireRate.update();
		collidesWith();
	}
        
    @Override
    public void Destroy(){
        spawning = true;
		spawnTime.run(Constantes.SPAWNING_TIME);
		//resetValues();
		//gameState.subtractLife();
    }
	
	
	@Override
	public void draw(Graphics g) {
            
            if(!visible)
			return;
		
		Graphics2D g2d = (Graphics2D)g;
		
		AffineTransform at1 = AffineTransform.getTranslateInstance(position.getX() + width/2 + 5,
				position.getY() + height/2 + 10);
		
		AffineTransform at2 = AffineTransform.getTranslateInstance(position.getX() + 5, position.getY() + height/2 + 10);
		
		at1.rotate(angle, -5, -10);
		at2.rotate(angle, width/2 -5, -10);
		
		if(accelerating)
		{
			g2d.drawImage(Assets.speed, at1, null);
			g2d.drawImage(Assets.speed, at2, null);
		}
		
		
		
		at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
		
		at.rotate(angle, width/2, height/2);
		
		g2d.drawImage(texture, at, null);
		
	}
        //Método para que los objetos sepan si el jugador esta en ese tiempo o no.
        public boolean isSpawning() {return spawning;
        
        }
	
}
	

