package Objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Calculos.Vector2D;
import Estados.EstadoJuego;

public class Laser extends MovimientoObjetos {

    public Laser(Vector2D position, Vector2D velocity, double maxVel, double angle, BufferedImage texture, EstadoJuego gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.angle = angle;
        this.velocity = velocity.scale(maxVel);
    }

    @Override
    public void update() {
        position = position.add(velocity);
        if (position.getX() < 0 || position.getX() > Constantes.WIDTH
                || position.getY() < 0 || position.getY() > Constantes.HEIGHT) {
            destroy();
        }

        collidesWith();

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        at = AffineTransform.getTranslateInstance(position.getX() - width / 2, position.getY());

        at.rotate(angle, width / 2, 0);

        g2d.drawImage(texture, at, null);

    }

    @Override
    public Vector2D getCenter() {
        return new Vector2D(position.getX() + width / 2, position.getY() + width / 2);
    }

}
