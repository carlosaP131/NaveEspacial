package Objetos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Graficos.Assets;
import Graficos.Sonidos;
import input.Teclas;
import Calculos.Vector2D;
import Estados.EstadoJuego;

public class Jugador extends MovimientoObjetos {

    private Vector2D heading;
    private Vector2D acceleration;

    private boolean accelerating = false;
    private Cronometro velocidadFuego;

    private boolean spawning, visible;

    private Cronometro spawnTime, flickerTime;

    private Sonidos shoot, loose;

    public Jugador(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, EstadoJuego gameState) {
        super(position, velocity, maxVel, texture, gameState);
        heading = new Vector2D(0, 1);
        acceleration = new Vector2D();
        velocidadFuego = new Cronometro();
        spawnTime = new Cronometro();
        flickerTime = new Cronometro();
        shoot = new Sonidos(Assets.jugadorDispador);
        loose = new Sonidos(Assets.jugadorSuelto);
    }

    @Override
    public void update() {

        if (!spawnTime.isRunning()) {
            spawning = false;
            visible = true;
        }

        if (spawning) {

            if (!flickerTime.isRunning()) {

                flickerTime.run(Constantes.FLICKER_TIME);
                visible = !visible;

            }

        }

        if (Teclas.SHOOT && !velocidadFuego.isRunning() && !spawning) {
            gameState.getMovingObjects().add(0, new Laser(
                    getCenter().add(heading.scale(width)),
                    heading,
                    Constantes.LASER_VEL,
                    angle,
                    Assets.laserAzul,
                    gameState
            ));
            velocidadFuego.run(Constantes.FIRERATE);
            shoot.play();
        }

        if (shoot.getFramePosition() > 8500) {
            shoot.stop();
        }

        if (Teclas.RIGHT) {
            angle += Constantes.DELTAANGLE;
        }
        if (Teclas.LEFT) {
            angle -= Constantes.DELTAANGLE;
        }

        if (Teclas.UP) {
            acceleration = heading.scale(Constantes.ACC);
            accelerating = true;
        } else {
            if (velocity.getMagnitude() != 0) {
                acceleration = (velocity.scale(-1).normalize()).scale(Constantes.ACC / 2);
            }
            accelerating = false;
        }

        velocity = velocity.add(acceleration);

        velocity = velocity.limit(maxVel);

        heading = heading.setDirection(angle - Math.PI / 2);

        position = position.add(velocity);

        if (position.getX() > Constantes.WIDTH) {
            position.setX(0);
        }
        if (position.getY() > Constantes.HEIGHT) {
            position.setY(0);
        }

        if (position.getX() < -width) {
            position.setX(Constantes.WIDTH);
        }
        if (position.getY() < -height) {
            position.setY(Constantes.HEIGHT);
        }

        velocidadFuego.update();
        spawnTime.update();
        flickerTime.update();
        collidesWith();
    }

    @Override
    public void Destroy() {
        spawning = true;
        spawnTime.run(Constantes.SPAWNING_TIME);
        loose.play();
        if (!gameState.subtractLife()) {
            gameState.gameOver();
            super.Destroy();
        }
        resetValues();

    }

    private void resetValues() {

        angle = 0;
        velocity = new Vector2D();
        position = EstadoJuego.PLAYER_START_POSITION;
    }

    @Override
    public void draw(Graphics g) {

        if (!visible) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        AffineTransform at1 = AffineTransform.getTranslateInstance(position.getX() + width / 2 + 5,
                position.getY() + height / 2 + 10);

        AffineTransform at2 = AffineTransform.getTranslateInstance(position.getX() + 5, position.getY() + height / 2 + 10);

        at1.rotate(angle, -5, -10);
        at2.rotate(angle, width / 2 - 5, -10);

        if (accelerating) {
            g2d.drawImage(Assets.velocidad, at1, null);
            g2d.drawImage(Assets.velocidad, at2, null);
        }

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());

        at.rotate(angle, width / 2, height / 2);

        g2d.drawImage(texture, at, null);

    }

    public boolean isSpawning() {
        return spawning;
    }

}
