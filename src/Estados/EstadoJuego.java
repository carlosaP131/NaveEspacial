/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Esta clase es para ver en que estado se encuentra el juego 
 *
 * ****************************************************************************/
package Estados;

import Graficos.Animacion;
import Graficos.Assets;
import Math.Vector;
import Objetos.Constantes;
import Objetos.JugadorJuego;
import Objetos.Mensaje;
import Objetos.Meteorito;
import Objetos.Movimiento;
import Objetos.Size;
import Objetos.Ufo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 *
 * @author carlos
 */
public class EstadoJuego {
        /**
         * Esta clase se encarga de ver en que estado esta el juego 
         * se declaran las variables de instancias a otras clases y cuatro ints 
         * que son el puntaje,las vidas,los meteoritos en pantalla y los niveles 
         */
	private JugadorJuego Jugador;
	private ArrayList<Movimiento> movingObjects = new ArrayList<Movimiento>();
	private ArrayList<Animacion> explosions = new ArrayList<Animacion>();
	private ArrayList<Mensaje> messages = new ArrayList<Mensaje>();
	private int Puntaje= 0;
	private int Vidas = 3;
	private int meteoritos;
	private int Niveles = 1;
        /**
         * Constructor
         */
	public EstadoJuego()
	{
            /**
             * Se crea un nuevo jugador cada que se actualize el estado esto 
             * ya que si el jugador muere se le resetea una vida y se crea otro 
             * asi hasta que se terminen sus vidas
             */
		Jugador = new JugadorJuego(new Vector(Constantes.WIDTH/2 - Assets.Jugador.getWidth()/2,
				Constantes.HEIGHT/2 - Assets.Jugador.getHeight()/2), new Vector(),
				Constantes.PLAYER_MAX_VEL, Assets.Jugador, this);
		
		movingObjects.add(Jugador);
		/**
                 * meteritos creados 
                 */
		meteoritos = 1;
		startWave();
	}
	/**
         * Este metodo aumenta el puntaje se recive el valor del puntaje 
         * y tambien la posicion donde se mostrara
         * @param value
         * @param position 
         */
	public void addScore(int value, Vector position) {
		Puntaje += value;
                messages.add(new Mensaje(position, true, "+"+value+" score", Color.WHITE, false, Assets.fontMed, this));
	}
	/**
         * divide los meteoritos si recibe un disparo el tamaño es la mitad del 
         * meteorito anterior
         * @param meteor 
         */
	public void  divideMeteorito(Meteorito meteor){
		
		Size size = meteor.getSize();
		
		BufferedImage[] textures = size.textures;
		
		Size newSize = null;
		
		switch(size){
		case BIG:
			newSize =  Size.MED;
			break;
		case MED:
			newSize = Size.SMALL;
			break;
		case SMALL:
			newSize = Size.TINY;
			break;
		default:
			return;
		}
		
		for(int i = 0; i < size.quantity; i++){
			movingObjects.add(new Meteorito(
					meteor.getPosition(),
					new Vector(0, 1).setDirection(Math.random()*Math.PI*2),
					Constantes.METEOR_VEL*Math.random() + 1,
					textures[(int)(Math.random()*textures.length)],
					this,
					newSize
					));
		}
	}
	
	/**
         * Iniciar los niveles al igual que las vidas este metodo solo es para 
         * mostrar un texto e igual para aumentar el numero de meteoritos 
         */
	private void startWave(){
		messages.add(new Mensaje(new Vector(Constantes.WIDTH/2, Constantes.HEIGHT/2), false,
				"Nivel "+Niveles, Color.WHITE, true, Assets.fontBig, this));
		double x, y;
		
		for(int i = 0; i < meteoritos; i++){
			 
			x = i % 2 == 0 ? Math.random()*Constantes.WIDTH : 0;
			y = i % 2 == 0 ? 0 : Math.random()*Constantes.HEIGHT;
			
			BufferedImage texture = Assets.bigs[(int)(Math.random()*Assets.bigs.length)];
			
			movingObjects.add(new Meteorito(
					new Vector(x, y),
					new Vector(0, 1).setDirection(Math.random()*Math.PI*2),
					Constantes.METEOR_VEL*Math.random() + 1,
					texture,
					this,
					Size.BIG
					));
			
		}
		meteoritos ++;
		spawnUfo();
	}
	/**
         * reproduce las explociones
         * @param position 
         */
	public void playExplosion(Vector position){
		explosions.add(new Animacion(
				Assets.exp,
				50,
				position.subtract(new Vector(Assets.exp[0].getWidth()/2, Assets.exp[0].getHeight()/2))
				));
	}
	/**
         * espawnea enemigos en una posicion random
         */
	private void spawnUfo(){
		
		int rand = (int) (Math.random()*2);
		
		double x = rand == 0 ? (Math.random()*Constantes.WIDTH): Constantes.WIDTH;
		double y = rand == 0 ? Constantes.HEIGHT : (Math.random()*Constantes.HEIGHT);
		
		ArrayList<Vector> path = new ArrayList<Vector>();
		
		double posX, posY;
		
		posX = Math.random()*Constantes.WIDTH/2;
		posY = Math.random()*Constantes.HEIGHT/2;	
		path.add(new Vector(posX, posY));

		posX = Math.random()*(Constantes.WIDTH/2) + Constantes.WIDTH/2;
		posY = Math.random()*Constantes.HEIGHT/2;	
		path.add(new Vector(posX, posY));
		
		posX = Math.random()*Constantes.WIDTH/2;
		posY = Math.random()*(Constantes.HEIGHT/2) + Constantes.HEIGHT/2;	
		path.add(new Vector(posX, posY));
		
		posX = Math.random()*(Constantes.WIDTH/2) + Constantes.WIDTH/2;
		posY = Math.random()*(Constantes.HEIGHT/2) + Constantes.HEIGHT/2;	
		path.add(new Vector(posX, posY));
		
		movingObjects.add(new Ufo(
				new Vector(x, y),
				new Vector(),
				Constantes.UFO_MAX_VEL,
				Assets.ufo,
				path,
				this
				));
		
	}

	/**
         * actualiza el estado de el juego  
         */
	public void update()
	{
		for(int i = 0; i < movingObjects.size(); i++)
			movingObjects.get(i).update();
		
		for(int i = 0; i < explosions.size(); i++){
			Animacion anim = explosions.get(i);
			anim.update();
			if(!anim.isRunning()){
				explosions.remove(i);
			}
			
		}
		
		for(int i = 0; i < movingObjects.size(); i++)
			if(movingObjects.get(i) instanceof Meteorito)
				return;
		
		startWave();
		
	}
	/**
         * dibuja los objetos 
         * @param g 
         */
	public void draw(Graphics g)
	{	
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                for(int i = 0; i < messages.size(); i++)
			messages.get(i).draw(g2d);
		
		for(int i = 0; i < movingObjects.size(); i++)
			movingObjects.get(i).draw(g);
		
		for(int i = 0; i < explosions.size(); i++){
			Animacion anim = explosions.get(i);
			g2d.drawImage(anim.getCurrentFrame(), (int)anim.getPosition().getX(), (int)anim.getPosition().getY(),
					null);
			
		}
		drawScore(g);
		drawLives(g);
	}
	/**
         * dibuja el puntaje
         * @param g 
         */
	private void drawScore(Graphics g) {
		
		Vector pos = new Vector(850, 25);
		
		String scoreToString = Integer.toString(Puntaje);
		
		for(int i = 0; i < scoreToString.length(); i++) {
			
			g.drawImage(Assets.numbers[Integer.parseInt(scoreToString.substring(i, i + 1))],
					(int)pos.getX(), (int)pos.getY(), null);
			pos.setX(pos.getX() + 20);
			
		}
		
	}
	/**
         * dibuja las vidas 
         * @param g 
         */
	private void drawLives(Graphics g){
		
		Vector livePosition = new Vector(25, 25);
		
		g.drawImage(Assets.life, (int)livePosition.getX(), (int)livePosition.getY(), null);
		
		g.drawImage(Assets.numbers[10], (int)livePosition.getX() + 40,
				(int)livePosition.getY() + 5, null);
		
		String livesToString = Integer.toString(Vidas);
		
		Vector pos = new Vector(livePosition.getX(), livePosition.getY());
		
		for(int i = 0; i < livesToString.length(); i ++)
		{
			int number = Integer.parseInt(livesToString.substring(i, i+1));
			
			if(number <= 0)
				break;
			g.drawImage(Assets.numbers[number],
					(int)pos.getX() + 60, (int)pos.getY() + 5, null);
			pos.setX(pos.getX() + 20);
		}
		
	}
	
	public ArrayList<Movimiento> getMovingObjects() {
		return movingObjects;
	}
	public ArrayList<Mensaje> getMessages() {
		return messages;
	}
	public JugadorJuego getPlayer() {
		return Jugador;
	}
	public void subtractLife() {Vidas --;}
}
