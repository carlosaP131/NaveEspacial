package Objetos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Calculos.Vector2D;

public abstract class ObjteosJuego {

    protected BufferedImage texture;
    protected Vector2D position;

    public ObjteosJuego(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

}
