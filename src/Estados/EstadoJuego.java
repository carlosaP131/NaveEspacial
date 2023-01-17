package Estados;

import Graficos.Animacion;
import Graficos.Assets;
import Math.Vector;
import Objetos.Constantes;
import Objetos.Cronometro;
import Objetos.JugadorJuego;
import Objetos.Meteorito;
import Objetos.Movimiento;
import Objetos.Size;
import Objetos.Ufo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author carlos
 */
public class EstadoJuego {

    private JugadorJuego player;
    private ArrayList<Movimiento> movingObjects = new ArrayList<Movimiento>();
    private ArrayList<Animacion> explosions = new ArrayList<Animacion>();
    

    private int score = 0;
    private int lives = 3;

    private int meteors;

    public EstadoJuego() {
        player = new JugadorJuego(new Vector(Constantes.WIDTH / 2 - Assets.player.getWidth() / 2,
                Constantes.HEIGHT / 2 - Assets.player.getHeight() / 2), new Vector(),
                Constantes.PLAYER_MAX_VEL, Assets.player, this);
        
        

        movingObjects.add(player);

        meteors = 1;
        startWave();
    }

    public void addScore(int value) {
        score += value;
    }

    public void divideMeteorito(Meteorito meteor) {

        Size size = meteor.getSize();

        BufferedImage[] textures = size.textures;

        Size newSize = null;

        switch (size) {
            case BIG:
                newSize = Size.MED;
                break;
            case MED:
                newSize = Size.SMALL;
                break;
            case SMALL:
                newSize = Size.TINY;
                break;
            default:
                return;
        }

        for (int i = 0; i < size.quantity; i++) {
            movingObjects.add(new Meteorito(
                    meteor.getPosition(),
                    new Vector(0, 1).setDirection(Math.random() * Math.PI * 2),
                    Constantes.METEOR_VEL * Math.random() + 1,
                    textures[(int) (Math.random() * textures.length)],
                    this,
                    newSize
            ));
        }
    }

    private void startWave() {

        double x, y;

        for (int i = 0; i < meteors; i++) {

            x = i % 2 == 0 ? Math.random() * Constantes.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random() * Constantes.HEIGHT;

            BufferedImage texture = Assets.bigs[(int) (Math.random() * Assets.bigs.length)];

            movingObjects.add(new Meteorito(
                    new Vector(x, y),
                    new Vector(0, 1).setDirection(Math.random() * Math.PI * 2),
                    Constantes.METEOR_VEL * Math.random() + 1,
                    texture,
                    this,
                    Size.BIG
            ));

        }
        meteors++;
        spawnUfo();
    }

    public void playExplosion(Vector position) {
        explosions.add(new Animacion(
                Assets.exp,
                50,
                position.subtract(new Vector(Assets.exp[0].getWidth() / 2, Assets.exp[0].getHeight() / 2))
        ));
    }

    private void spawnUfo() {

        int rand = (int) (Math.random() * 2);

        double x = rand == 0 ? (Math.random() * Constantes.WIDTH) : Constantes.WIDTH;
        double y = rand == 0 ? Constantes.HEIGHT : (Math.random() * Constantes.HEIGHT);

        ArrayList<Vector> path = new ArrayList<Vector>();

        double posX, posY;

        posX = Math.random() * Constantes.WIDTH / 2;
        posY = Math.random() * Constantes.HEIGHT / 2;
        path.add(new Vector(posX, posY));

        posX = Math.random() * (Constantes.WIDTH / 2) + Constantes.WIDTH / 2;
        posY = Math.random() * Constantes.HEIGHT / 2;
        path.add(new Vector(posX, posY));

        posX = Math.random() * Constantes.WIDTH / 2;
        posY = Math.random() * (Constantes.HEIGHT / 2) + Constantes.HEIGHT / 2;
        path.add(new Vector(posX, posY));

        posX = Math.random() * (Constantes.WIDTH / 2) + Constantes.WIDTH / 2;
        posY = Math.random() * (Constantes.HEIGHT / 2) + Constantes.HEIGHT / 2;
        path.add(new Vector(posX, posY));

        movingObjects.add(new Ufo(
                new Vector(x, y),
                new Vector(),
                Constantes.UFO_MAX_VEL,
                Assets.ufo,
                path,
                this
        ));

    }

    public void update() {
        for (int i = 0; i < movingObjects.size(); i++) {
            movingObjects.get(i).update();
        }

        for (int i = 0; i < explosions.size(); i++) {
            Animacion anim = explosions.get(i);
            anim.update();
            if (!anim.isRunning()) {
                explosions.remove(i);
            }

        }

        for (int i = 0; i < movingObjects.size(); i++) {
            if (movingObjects.get(i) instanceof Meteorito) {
                return;
            }
        }

        startWave();

    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        for (int i = 0; i < movingObjects.size(); i++) {
            movingObjects.get(i).draw(g);
        }

        for (int i = 0; i < explosions.size(); i++) {
            Animacion anim = explosions.get(i);
            g2d.drawImage(anim.getCurrentFrame(), (int) anim.getPosition().getX(), (int) anim.getPosition().getY(),
                    null);

        }
        drawScore(g);
        drawLives(g);
    }
    // Método privado para contar el puntaje del jugador.

    private void drawScore(Graphics g) {

        Vector pos = new Vector(850, 25);

        String scoreToString = Integer.toString(score);

        for (int i = 0; i < scoreToString.length(); i++) {

            g.drawImage(Assets.numbers[Integer.parseInt(scoreToString.substring(i, i + 1))],
                    (int) pos.getX(), (int) pos.getY(), null);
            pos.setX(pos.getX() + 20);

        }

    }
    // Método privado para contar el las vidas que le restan al jugador.

    private void drawLives(Graphics g) {

        Vector livePosition = new Vector(25, 25);
        //Se dibuja el simbolo de vida.
        g.drawImage(Assets.life, (int) livePosition.getX(), (int) livePosition.getY(), null);

        g.drawImage(Assets.numbers[10], (int) livePosition.getX() + 40,
                (int) livePosition.getY() + 5, null);

        String livesToString = Integer.toString(lives);

        Vector pos = new Vector(livePosition.getX(), livePosition.getY());

        for (int i = 0; i < livesToString.length(); i++) {
            int number = Integer.parseInt(livesToString.substring(i, i + 1));

            if (number <= 0) {
                break;
            }
            g.drawImage(Assets.numbers[number],
                    (int) pos.getX() + 60, (int) pos.getY() + 5, null);
            pos.setX(pos.getX() + 20);
        }

    }

    public ArrayList<Movimiento> getMovingObjects() {
        return movingObjects;
    }

    public JugadorJuego getPlayer() {
        return player;
    }
    // Método para restar una vida al jugador.
    public void subtractLife() {lives --;
    
    }
	
}

