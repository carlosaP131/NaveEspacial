package Objetos;

import java.awt.image.BufferedImage;

import Graficos.Assets;

public enum Tamaño {

    BIG(2, Assets.mediano), MED(2, Assets.pequeño), SMALL(2, Assets.diminutas), TINY(0, null);

    public int quantity;

    public BufferedImage[] textures;

    private Tamaño(int quantity, BufferedImage[] textures) {
        this.quantity = quantity;
        this.textures = textures;
    }

}
