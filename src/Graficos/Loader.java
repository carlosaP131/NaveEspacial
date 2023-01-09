
package Graficos;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Loader {
    public static BufferedImage Imageloader(String path){

  
	{
		try {
                    System.out.println(path);
			return ImageIO.read(Loader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	return null;
	}
    
}
}
