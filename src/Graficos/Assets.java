/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase para cargar los archivos nesesarios 
 **
 * ****************************************************************************/
package Graficos;

import java.awt.Font;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;

public class Assets {

    public static boolean loaded = false;
    public static float contar = 0;
    public static float MAX_COUNT = 46;

    public static BufferedImage jugador;

    // effects
    public static BufferedImage velocidad;

    // explosion
    public static BufferedImage[] exp = new BufferedImage[9];

    // lasers
    public static BufferedImage laserAzul, laserVerde, laserRojo;

    // Meteors
    public static BufferedImage[] grandre = new BufferedImage[4];
    public static BufferedImage[] mediano = new BufferedImage[2];
    public static BufferedImage[] pequeño = new BufferedImage[2];
    public static BufferedImage[] diminutas = new BufferedImage[2];

    // ufo
    public static BufferedImage ufo;

    // numbers
    public static BufferedImage[] numeros = new BufferedImage[11];

    public static BufferedImage vidas;

    // fonts
    public static Font fontBig;
    public static Font fontMed;

    public static Clip musicaFondo, explosion, jugadorSuelto, jugadorDispador, ovniDispara;

    // ui
    public static BufferedImage btnAzul;
    public static BufferedImage btnGris;

    public static void init() {
        jugador = loadImage("/ImagenesObjetos/iNaveespacial.png");//Agregale una l a iNaveespacial y la imagen cambiara de tamaño.

        velocidad = loadImage("/ImagenesObjetos/fire08.png");

        laserAzul = loadImage("/ImagenesObjetos/laserGreen11.png");

        laserVerde = loadImage("/ImagenesObjetos/laserGreen11.png");

        laserRojo = loadImage("/ImagenesObjetos/laserRed01.png");

        ufo = loadImage("/ImagenesObjetos/ufo.png");

        vidas = loadImage("/ImagenesObjetos/life.png");

        fontBig = loadFont("/Fonts/futureFont.ttf", 42);

        fontMed = loadFont("/Fonts/futureFont.ttf", 20);

        for (int i = 0; i < grandre.length; i++) {
            grandre[i] = loadImage("/ImagenesObjetos/big" + (i + 1) + ".png");
        }

        for (int i = 0; i < mediano.length; i++) {
            mediano[i] = loadImage("/ImagenesObjetos/med" + (i + 1) + ".png");
        }

        for (int i = 0; i < pequeño.length; i++) {
            pequeño[i] = loadImage("/ImagenesObjetos/small" + (i + 1) + ".png");
        }

        for (int i = 0; i < diminutas.length; i++) {
            diminutas[i] = loadImage("/ImagenesObjetos/tiny" + (i + 1) + ".png");
        }

        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/ImagenesExplosion/" + i + ".png");
        }

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = loadImage("/ImagenesNumeros/" + i + ".png");
        }

        musicaFondo = loadSound("/Sonido/backgroundMusic.wav");
        explosion = loadSound("/Sonido/explosion.wav");
        jugadorSuelto = loadSound("/Sonido/playerLoose.wav");
        jugadorDispador = loadSound("/Sonido/playerShoot.wav");
        ovniDispara = loadSound("/Sonido/ufoShoot.wav");

        btnGris = loadImage("/ImagenesObjetos/grey_button.png");
        btnAzul = loadImage("/ImagenesObjetos/blue_button.png");

        // ===========================================================
        loaded = true;

    }

    public static BufferedImage loadImage(String path) {
        contar++;
        return Cargador.ImageLoader(path);
    }

    public static Font loadFont(String path, int size) {
        contar++;
        return Cargador.loadFont(path, size);
    }

    public static Clip loadSound(String path) {
        contar++;
        return Cargador.loadSound(path);
    }

}
