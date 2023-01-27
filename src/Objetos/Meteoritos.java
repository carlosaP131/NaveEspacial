package Objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Calculos.Vector2D;
import Estados.EstadoJuego;
import entity.Jugador;

public class Meteoritos extends MovimientoObjetos {

    private Tamaño size;
    
    private Jugador jugador;
            
    public Meteoritos(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, EstadoJuego gameState, Tamaño size) {
        super(position, velocity, maxVel, texture, gameState);
        this.size = size;
        this.velocity = velocity.scale(maxVel);

    }

    @Override
    public void update() {
        position = position.add(velocity);

        if (position.getX() > Constantes.WIDTH) {
            position.setX(-width);
        }
        if (position.getY() > Constantes.HEIGHT) {
            position.setY(-height);
        }

        if (position.getX() < -width) {
            position.setX(Constantes.WIDTH);
        }
        if (position.getY() < -height) {
            position.setY(Constantes.HEIGHT);
        }

        angle += Constantes.DELTAANGLE / 2;

    }

    @Override
    public void destroy() {
        gameState.divideMeteor(this);
        gameState.addScore(Constantes.METEOR_SCORE, position);
        super.destroy();
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());

        at.rotate(angle, width / 2, height / 2);

        g2d.drawImage(texture, at, null);
    }

    public Tamaño getSize() {
        return size;
    }

}
