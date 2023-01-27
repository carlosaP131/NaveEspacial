package Objetos;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graficos.Assets;
import Graficos.Sonidos;
import Calculos.Vector2D;
import Estados.EstadoJuego;

public abstract class MovimientoObjetos extends ObjteosJuego {

    protected Vector2D velocity;
    protected AffineTransform at;
    protected double angle;
    protected double maxVel;
    protected int width;
    protected int height;
    protected EstadoJuego gameState;

    private Sonidos explosion;

    protected boolean Dead;

    public MovimientoObjetos(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, EstadoJuego gameState) {
        super(position, texture);
        this.velocity = velocity;
        this.maxVel = maxVel;
        this.gameState = gameState;
        width = texture.getWidth();
        height = texture.getHeight();
        angle = 0;
        explosion = new Sonidos(Assets.explosion);
        Dead = false;
    }

    protected void collidesWith() {

        ArrayList<MovimientoObjetos> movingObjects = gameState.getMovingObjects();

        for (int i = 0; i < movingObjects.size(); i++) {

            MovimientoObjetos m = movingObjects.get(i);

            if (m.equals(this)) {
                continue;
            }

            double distance = m.getCenter().subtract(getCenter()).getMagnitude();

            if (distance < m.width / 2 + width / 2 && movingObjects.contains(this) && !m.Dead && !Dead) {
                objectCollision(m, this);
            }
        }
    }

    private void objectCollision(MovimientoObjetos a, MovimientoObjetos b) {

        if (a instanceof JugadorJuego && ((JugadorJuego) a).isSpawning()) {
            return;
        }
        if (b instanceof JugadorJuego && ((JugadorJuego) b).isSpawning()) {
            return;
        }

        if (!(a instanceof Meteoritos && b instanceof Meteoritos)) {
            gameState.playExplosion(getCenter());
            a.destroy();
            b.destroy();
        }
    }

    protected void destroy() {
        Dead = true;
        if (!(this instanceof Laser)) {
            explosion.play();
        }
    }

    protected Vector2D getCenter() {
        return new Vector2D(position.getX() + width / 2, position.getY() + height / 2);
    }

    public boolean isDead() {
        return Dead;
    }

}
