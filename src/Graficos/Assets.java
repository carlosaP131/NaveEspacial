/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 5-01-2023 ***
 *Fecha de actualización:13-12-2023
 *Descripción: Los asset son todos los enlaces o rutaas de los archivos del juego
 *
 * *************************************************************************** */
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

    /**
     * Ocuparemos la clase Bufferedimage ya que esta nos brinda una funcion para
     * guardar las imagenes en memoria y asi ahorrar tiempo de ejecucion
     * esta declaracion es para la nave 
     */
    public static BufferedImage Jugador;

    /**
     * Esta Para los efectos 
     * 
     */
    public static BufferedImage Postcombustion;

    /**
     * Esta para las explociones 
     */
    public static BufferedImage[] exp = new BufferedImage[9];

        /**
         * para los diferentes tipos de balas aliadas o enemigas 
         */
    public static BufferedImage blueLaser, greenLaser, redLaser;

    /**
     * Esta Para los Meteoritos
     * 
     */
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];

    /**
     * Esta Para los Enemigos 
     */
    public static BufferedImage ufo;

    /**
     * Numeros que se mostraran en pantalla 
     */
    public static BufferedImage[] numbers = new BufferedImage[11];
    /**
     * Las vidas del jugador 
     */
    public static BufferedImage life;

    /**
     * Tamaño de los mensajes mostrados 
     */
    public static Font fontBig;
    public static Font fontMed;

    public static Clip backgroundMusic, explosion, playerLoose, playerShoot, ufoShoot;

 

    public static void init() throws UnsupportedAudioFileException {
        Jugador = Loader.ImageLoader("iNaveespacial.png");

        Postcombustion = Loader.ImageLoader("fire08.png");

        blueLaser = Loader.ImageLoader("iLaser.png");

        greenLaser = Loader.ImageLoader("laserGreen11.png");

        redLaser = Loader.ImageLoader("laserRed01.png");

        ufo = Loader.ImageLoader("ufo.png");

        life = Loader.ImageLoader("life.png");

        for (int i = 0; i < bigs.length; i++) {
            bigs[i] = Loader.ImageLoader("big" + (i + 1) + ".png");
        }

        for (int i = 0; i < meds.length; i++) {
            meds[i] = Loader.ImageLoader("med" + (i + 1) + ".png");
        }

        for (int i = 0; i < smalls.length; i++) {
            smalls[i] = Loader.ImageLoader("small" + (i + 1) + ".png");
        }

        for (int i = 0; i < tinies.length; i++) {
            tinies[i] = Loader.ImageLoader("tiny" + (i + 1) + ".png");
        }

        for (int i = 0; i < exp.length; i++) {
            exp[i] = Loader.ImageLoader("exp" + i + ".png");
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Loader.ImageLoader("" + i + ".png");
        }
        backgroundMusic = Loader.loadSound("backgroundMusic.wav");
        explosion = Loader.loadSound("explosion.wav");
        playerLoose = Loader.loadSound("playerLoose.wav");
        playerShoot = Loader.loadSound("playerShoot.wav");
        ufoShoot = Loader.loadSound("ufoShoot.wav");

    }

}
