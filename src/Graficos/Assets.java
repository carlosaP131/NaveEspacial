
package Graficos;

import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

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
	
	public static void init()
	{
		player = Loader.Imageloader("/ships/player.png");
		
		speed = Loader.Imageloader("/effects/fire08.png");
		
		blueLaser = Loader.Imageloader("/lasers/laserBlue01.png");
		
		greenLaser = Loader.Imageloader("/lasers/laserGreen11.png");
		
		redLaser = Loader.Imageloader("/lasers/laserRed01.png");
		
		ufo = Loader.Imageloader("/ships/ufo.png");
		
		life = Loader.Imageloader("/others/life.png");
		
		for(int i = 0; i < bigs.length; i++)
			bigs[i] = Loader.Imageloader("/meteors/big"+(i+1)+".png");
		
		for(int i = 0; i < meds.length; i++)
			meds[i] = Loader.Imageloader("/meteors/med"+(i+1)+".png");
		
		for(int i = 0; i < smalls.length; i++)
			smalls[i] = Loader.Imageloader("/meteors/small"+(i+1)+".png");
		
		for(int i = 0; i < tinies.length; i++)
			tinies[i] = Loader.Imageloader("/meteors/tiny"+(i+1)+".png");
		
		for(int i = 0; i < exp.length; i++)
			exp[i] = Loader.Imageloader("/explosion/"+i+".png");
		
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = Loader.Imageloader("/numbers/"+i+".png");
		
	}
	
}
