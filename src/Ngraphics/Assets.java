package graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

public class Assets {
	
	public static boolean loaded = false;
	public static float count = 0;
	public static float MAX_COUNT = 46;
	
	
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
	
	public static void init()
	{
		player = loadImage("/imgObjetos/player.png");
		
		speed = loadImage("/imgObjetos/fire08.png");
		
		blueLaser = loadImage("/imgObjetos/laserGreen11.png");
		
		greenLaser = loadImage("/imgObjetos/laserGreen11.png");
		
		redLaser = loadImage("/imgObjetos/laserRed01.png");
		
		ufo = loadImage("/imgObjetos/ufo.png");
		
		life = loadImage("/imgObjetos/life.png");
		
		fontBig = loadFont("/fonts/futureFont.ttf", 42);
		
		fontMed = loadFont("/fonts/futureFont.ttf", 20);
		
		for(int i = 0; i < bigs.length; i++)
			bigs[i] = loadImage("/imgObjetos/big"+(i+1)+".png");
		
		for(int i = 0; i < meds.length; i++)
			meds[i] = loadImage("/imgObjetos/med"+(i+1)+".png");
		
		for(int i = 0; i < smalls.length; i++)
			smalls[i] = loadImage("/imgObjetos/small"+(i+1)+".png");
		
		for(int i = 0; i < tinies.length; i++)
			tinies[i] = loadImage("/imgObjetos/tiny"+(i+1)+".png");
		
		for(int i = 0; i < exp.length; i++)
			exp[i] = loadImage("/imgExplosion/"+i+".png");
		
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = loadImage("/imgNumeros/"+i+".png");
		
		backgroundMusic = loadSound("/sonido/backgroundMusic.wav");
		explosion = loadSound("/sonido/explosion.wav");
		playerLoose = loadSound("/sonido/playerLoose.wav");
		playerShoot = loadSound("/sonido/playerShoot.wav");
		ufoShoot = loadSound("/sonido/ufoShoot.wav");
		
		greyBtn = loadImage("/imgObjetos/grey_button.png");
		blueBtn = loadImage("/imgObjetos/blue_button.png");
		
		// ===========================================================
		
		loaded = true;
		
	}

	public static BufferedImage loadImage(String path) {
		count ++;
		return Loader.ImageLoader(path);
	}
	public static Font loadFont(String path, int size) {
		count ++;
		return Loader.loadFont(path, size);
	}
	public static Clip loadSound(String path) {
		count ++;
		return Loader.loadSound(path);
	}
	
}
