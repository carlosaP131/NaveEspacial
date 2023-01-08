
package Graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author carlos
 */
public class Assets {
    public static BufferedImage player;
    public static void init(){
        player = Loader.Imageloader("/src/resources/img/Juego/iNaveespacial.png"); 
                
    }
}
