
package Graficos;

import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author carlos
 */
public class Assets {

	
	public static BufferedImage player;
	
	// effects
	
	public static BufferedImage speed;
	
	// explosion
	
	public static BufferedImage[] exp = new BufferedImage[9];
	
	// lasers
	
	public static BufferedImage blueLaser, greenLaser, redLaser;
	
	// Meteors
	
	public static BufferedImage[] bigs = new BufferedImage[4];
	public static BufferedImage[] meds = new BufferedImage[2];
	public static BufferedImage[] smalls = new BufferedImage[2];
	public static BufferedImage[] tinies = new BufferedImage[2];
	
	// ufo
	
	public static BufferedImage ufo;
	
	// numbers
	
	public static BufferedImage[] numbers = new BufferedImage[11];
	
	public static BufferedImage life;
	
	// fonts
	
	public static Font fontBig;
	public static Font fontMed;
	
	public static Clip backgroundMusic, explosion, playerLoose, playerShoot, ufoShoot;
	
	// ui
	
	public static BufferedImage blueBtn;
	public static BufferedImage greyBtn;
	
	public static void init() throws UnsupportedAudioFileException
	{
		player = Loader.ImageLoader("iNaveespacial.png");
		
		speed = Loader.ImageLoader("fire08.png");
		
		blueLaser = Loader.ImageLoader("iLaser.png");
		
		greenLaser = Loader.ImageLoader("laserGreen11.png");
		
		redLaser = Loader.ImageLoader("laserRed01.png");
		
		ufo = Loader.ImageLoader("ufo.png");
		
		life = Loader.ImageLoader("life.png");
		
		for(int i = 0; i < bigs.length; i++)
			bigs[i] = Loader.ImageLoader("big"+(i+1)+".png");
		
		for(int i = 0; i < meds.length; i++)
			meds[i] = Loader.ImageLoader("med"+(i+1)+".png");
		
		for(int i = 0; i < smalls.length; i++)
			smalls[i] = Loader.ImageLoader("small"+(i+1)+".png");
		
		for(int i = 0; i < tinies.length; i++)
			tinies[i] = Loader.ImageLoader("tiny"+(i+1)+".png");
		
		for(int i = 0; i < exp.length; i++)
			exp[i] = Loader.ImageLoader("exp"+i+".png");
		
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = Loader.ImageLoader(""+i+".png");
		backgroundMusic = Loader.loadSound("backgroundMusic.wav");
		explosion = Loader.loadSound("explosion.wav");
		playerLoose = Loader.loadSound("playerLoose.wav");
		playerShoot = Loader.loadSound("playerShoot.wav");
		ufoShoot = Loader.loadSound("ufoShoot.wav");
		
	
	}
	
}
