package Estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Objetos.Cronometro;
import Objetos.Constantes;
import Objetos.Mensajes;
import Objetos.Meteoritos;
import Objetos.MovimientoObjetos;
import Objetos.JugadorJuego;
import Objetos.Tamaño;
import Objetos.EnemigoUfo;
import Graficos.Animacion;
import Graficos.Assets;
import Graficos.Sonidos;
import Calculos.Vector2D;
import DB.Conexion;
import Model.RolModelImpl;
import entity.Jugador;
import Objetos.JugadorJuego;
import entity.Rol;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstadoJuego extends Estado {

    public static final Vector2D PLAYER_START_POSITION = new Vector2D(Constantes.WIDTH / 2 - Assets.jugador.getWidth() / 2,
            Constantes.HEIGHT / 2 - Assets.jugador.getHeight() / 2);

    private JugadorJuego jugador;
    private Conexion conexion;
    private Connection connection;
    private Statement stm;
    private ArrayList<MovimientoObjetos> movingObjects = new ArrayList<MovimientoObjetos>();
    private ArrayList<Animacion> explosions = new ArrayList<Animacion>();
    private ArrayList<Mensajes> messages = new ArrayList<Mensajes>();

    private int puntaje = 0;
    private int vidas = 3;

    private int meteoritos;
    private int ondas = 1;

    private Sonidos backgroundMusic;
    private Cronometro temporizadorJuego;
    private boolean juegoTerminado;

    private Cronometro generadorOvnis;

    public EstadoJuego() {
        jugador = new JugadorJuego(PLAYER_START_POSITION, new Vector2D(),
                Constantes.PLAYER_MAX_VEL, Assets.jugador, this);

        temporizadorJuego = new Cronometro();
        juegoTerminado = false;
        movingObjects.add(jugador);

        meteoritos = 1;
        startWave();
        backgroundMusic = new Sonidos(Assets.musicaFondo);
        backgroundMusic.loop();//Aqui se sctiva la música.
        backgroundMusic.changeVolume(-10.0f);

        generadorOvnis = new Cronometro();
        generadorOvnis.run(Constantes.UFO_SPAWN_RATE);
    }

    public void addScore(int value, Vector2D position ) {
        puntaje += value;
        messages.add(new Mensajes(position, true, "+" + value + " puntos", Color.WHITE, false, Assets.fontMed));
         try {
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "call ActualizarPuntaje("+obtenerID()+","+puntaje+");";
             System.out.println("---: " + query);
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: "+ e.getMessage());
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(EstadoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int obtenerID(){
        int idaux= 4;
        try {
            int id = 0;
            ResultSet rs;
            String query = "select id_jugador from jugador where id_jugador="+idaux+";";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
             id =  rs.getInt("id_jugador"); 
            return id;
        } catch (SQLException e) {
            System.err.println("Error:");
        }
        return 6;
    }

    public void divideMeteor(Meteoritos meteor) {

        Tamaño size = meteor.getSize();

        BufferedImage[] textures = size.textures;

        Tamaño newSize = null;

        switch (size) {
            case BIG:
                newSize = Tamaño.MED;
                break;
            case MED:
                newSize = Tamaño.SMALL;
                break;
            case SMALL:
                newSize = Tamaño.TINY;
                break;
            default:
                return;
        }

        for (int i = 0; i < size.quantity; i++) {
            movingObjects.add(new Meteoritos(
                    meteor.getPosition(),
                    new Vector2D(0, 1).setDirection(Math.random() * Math.PI * 2),
                    Constantes.METEOR_VEL * Math.random() + 1,
                    textures[(int) (Math.random() * textures.length)],
                    this,
                    newSize
            ));
        }
    }

    private void startWave() {

        messages.add(new Mensajes(new Vector2D(Constantes.WIDTH / 2, Constantes.HEIGHT / 2), false,
                "Nueva ronda de meteoritos " + ondas, Color.WHITE, true, Assets.fontBig));

        double x, y;

        for (int i = 0; i < meteoritos; i++) {

            x = i % 2 == 0 ? Math.random() * Constantes.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random() * Constantes.HEIGHT;

            BufferedImage texture = Assets.grandre[(int) (Math.random() * Assets.grandre.length)];

            movingObjects.add(new Meteoritos(
                    new Vector2D(x, y),
                    new Vector2D(0, 1).setDirection(Math.random() * Math.PI * 2),
                    Constantes.METEOR_VEL * Math.random() + 1,
                    texture,
                    this,
                    Tamaño.BIG
            ));

        }
        meteoritos++;
    }

    public void playExplosion(Vector2D position) {
        explosions.add(new Animacion(
                Assets.exp,
                50,
                position.subtract(new Vector2D(Assets.exp[0].getWidth() / 2, Assets.exp[0].getHeight() / 2))
        ));
    }

    private void spawnUfo() {

        int rand = (int) (Math.random() * 2);

        double x = rand == 0 ? (Math.random() * Constantes.WIDTH) : Constantes.WIDTH;
        double y = rand == 0 ? Constantes.HEIGHT : (Math.random() * Constantes.HEIGHT);

        ArrayList<Vector2D> path = new ArrayList<Vector2D>();

        double posX, posY;

        posX = Math.random() * Constantes.WIDTH / 2;
        posY = Math.random() * Constantes.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * (Constantes.WIDTH / 2) + Constantes.WIDTH / 2;
        posY = Math.random() * Constantes.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * Constantes.WIDTH / 2;
        posY = Math.random() * (Constantes.HEIGHT / 2) + Constantes.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * (Constantes.WIDTH / 2) + Constantes.WIDTH / 2;
        posY = Math.random() * (Constantes.HEIGHT / 2) + Constantes.HEIGHT / 2;
        path.add(new Vector2D(posX, posY));

        movingObjects.add(new EnemigoUfo(
                new Vector2D(x, y),
                new Vector2D(),
                Constantes.UFO_MAX_VEL,
                Assets.ufo,
                path,
                this
        ));

    }

    public void update() {

        for (int i = 0; i < movingObjects.size(); i++) {

            MovimientoObjetos mo = movingObjects.get(i);

            mo.update();
            if (mo.isDead()) {
                movingObjects.remove(i);
                i--;
            }

        }

        for (int i = 0; i < explosions.size(); i++) {
            Animacion anim = explosions.get(i);
            anim.update();
            if (!anim.isRunning()) {
                explosions.remove(i);
            }

        }

        if (juegoTerminado && !temporizadorJuego.isRunning()) {
            Estado.changeState(new EstadoMenu());
        }

        if (!generadorOvnis.isRunning()) {
            generadorOvnis.run(Constantes.UFO_SPAWN_RATE);
            spawnUfo();
        }

        temporizadorJuego.update();
        generadorOvnis.update();

        for (int i = 0; i < movingObjects.size(); i++) {
            if (movingObjects.get(i) instanceof Meteoritos) {
                return;
            }
        }

        startWave();

    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        for (int i = 0; i < messages.size(); i++) {
            messages.get(i).draw(g2d);
            if (messages.get(i).isDead()) {
                messages.remove(i);
            }
        }

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

    private void drawScore(Graphics g) {

        Vector2D pos = new Vector2D(850, 25);

        String scoreToString = Integer.toString(puntaje);

        for (int i = 0; i < scoreToString.length(); i++) {

            g.drawImage(Assets.numeros[Integer.parseInt(scoreToString.substring(i, i + 1))],
                    (int) pos.getX(), (int) pos.getY(), null);
            pos.setX(pos.getX() + 20);

        }

    }

    private void drawLives(Graphics g) {

        if (vidas < 1) {
            return;
        }

        Vector2D livePosition = new Vector2D(25, 25);

        g.drawImage(Assets.vidas, (int) livePosition.getX(), (int) livePosition.getY(), null);

        g.drawImage(Assets.numeros[10], (int) livePosition.getX() + 40,
                (int) livePosition.getY() + 5, null);

        String livesToString = Integer.toString(vidas);

        Vector2D pos = new Vector2D(livePosition.getX(), livePosition.getY());

        for (int i = 0; i < livesToString.length(); i++) {
            int number = Integer.parseInt(livesToString.substring(i, i + 1));

            if (number <= 0) {
                break;
            }
            g.drawImage(Assets.numeros[number],
                    (int) pos.getX() + 60, (int) pos.getY() + 5, null);
            pos.setX(pos.getX() + 20);
        }

    }

    public ArrayList<MovimientoObjetos> getMovingObjects() {
        return movingObjects;
    }

    public ArrayList<Mensajes> getMessages() {
        return messages;
    }

    public JugadorJuego getPlayer() {
        return jugador;
    }

    public boolean subtractLife() {
        vidas--;
        return vidas > 0;
    }

    public void gameOver() {
        Mensajes gameOverMsg = new Mensajes(
                PLAYER_START_POSITION,
                true,
                "GAME OVER",
                Color.WHITE,
                true,
                Assets.fontBig);

        this.messages.add(gameOverMsg);
        temporizadorJuego.run(Constantes.GAME_OVER_TIME);
        juegoTerminado = true;
    }

}
