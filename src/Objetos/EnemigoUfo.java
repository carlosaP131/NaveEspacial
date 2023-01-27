/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-12-2022 
 *Fecha de actualización:4-01-2023
 *Descripción:Clase con los parametros del enemigo 
 **
 * ****************************************************************************/
package Objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graficos.Assets;
import Graficos.Sonidos;
import Calculos.Vector2D;
import Estados.EstadoJuego;
import Entity.Jugador;

public class EnemigoUfo extends MovimientoObjetos {
    /**
     * Variables 
     */
    private ArrayList<Vector2D> path;

    private Vector2D currentNode;
    
    private Jugador jugador;
    
    private int index;

    private boolean following;

    private Cronometro fireRate;

    private Sonidos shoot;

    public EnemigoUfo(Vector2D position, Vector2D velocity, 
            double maxVel, BufferedImage texture,
            ArrayList<Vector2D> path, EstadoJuego gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.path = path;
        index = 0;
        following = true;
        fireRate = new Cronometro();
        fireRate.run(Constantes.UFO_FIRE_RATE);
        shoot = new Sonidos(Assets.ovniDispara);
    }

    private Vector2D pathFollowing() {
        currentNode = path.get(index);

        double distanceToNode = currentNode.subtract(
                getCenter()).getMagnitude();

        if (distanceToNode < Constantes.NODE_RADIUS) {
            index++;
            if (index >= path.size()) {
                following = false;
            }
        }

        return seekForce(currentNode);

    }

    private Vector2D seekForce(Vector2D target) {
        Vector2D desiredVelocity = target.subtract(getCenter());
        desiredVelocity = desiredVelocity.normalize().scale(maxVel);
        return desiredVelocity.subtract(velocity);
    }

    @Override
    public void update() {

        Vector2D pathFollowing;

        if (following) {
            pathFollowing = pathFollowing();
        } else {
            pathFollowing = new Vector2D();
        }

        pathFollowing = pathFollowing.scale(1 / Constantes.UFO_MASS);

        velocity = velocity.add(pathFollowing);

        velocity = velocity.limit(maxVel);

        position = position.add(velocity);

        if (position.getX() > Constantes.WIDTH || position.getY() >
                Constantes.HEIGHT
                || position.getX() < -width || position.getY() < -height) {
            destroy();
        }

        // shoot
        if (!fireRate.isRunning()) {

            Vector2D toPlayer = gameState.getPlayer().getCenter().subtract
        (getCenter());

            toPlayer = toPlayer.normalize();

            double currentAngle = toPlayer.getAngle();

            currentAngle += Math.random() * Constantes.UFO_ANGLE_RANGE -
                    Constantes.UFO_ANGLE_RANGE / 2;

            if (toPlayer.getX() < 0) {
                currentAngle = -currentAngle + Math.PI;
            }

            toPlayer = toPlayer.setDirection(currentAngle);

            Laser laser = new Laser(
                    getCenter().add(toPlayer.scale(width)),
                    toPlayer,
                    Constantes.LASER_VEL,
                    currentAngle + Math.PI / 2,
                    Assets.laserRojo,
                    gameState
            );

            gameState.getMovingObjects().add(0, laser);

            fireRate.run(Constantes.UFO_FIRE_RATE);

            shoot.play();

        }

        if (shoot.getFramePosition() > 8500) {
            shoot.stop();
        }

        angle += 0.05;

        collidesWith();
        fireRate.update();

    }

    @Override
    public void destroy() {
        gameState.addScore(Constantes.UFO_SCORE, position);
        super.destroy();
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        at = AffineTransform.getTranslateInstance(position.getX(),
                position.getY());

        at.rotate(angle, width / 2, height / 2);

        g2d.drawImage(texture, at, null);

    }

}
