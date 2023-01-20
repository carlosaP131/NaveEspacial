package Estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Objetos.Constantes;
import Graficos.Assets;
import Graficos.Cargador;
import Graficos.Texto;
import Calculos.Vector2D;

public class EstadoCarga extends Estado {

    private Thread hiloDeCarga;

    private Font font;

    public EstadoCarga(Thread loadingThread) {
        this.hiloDeCarga = loadingThread;
        this.hiloDeCarga.start();
        font = Cargador.loadFont("/fonts/futureFont.ttf", 38);
    }

    @Override
    public void update() {
        if (Assets.loaded) {
            Estado.changeState(new EstadoMenu());
            try {
                hiloDeCarga.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        GradientPaint gp = new GradientPaint(
                Constantes.WIDTH / 2 - Constantes.LOADING_BAR_WIDTH / 2,
                Constantes.HEIGHT / 2 - Constantes.LOADING_BAR_HEIGHT / 2,
                Color.WHITE,
                Constantes.WIDTH / 2 + Constantes.LOADING_BAR_WIDTH / 2,
                Constantes.HEIGHT / 2 + Constantes.LOADING_BAR_HEIGHT / 2,
                Color.BLUE
        );

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(gp);

        float percentage = (Assets.contar / Assets.MAX_COUNT);

        g2d.fillRect(Constantes.WIDTH / 2 - Constantes.LOADING_BAR_WIDTH / 2,
                Constantes.HEIGHT / 2 - Constantes.LOADING_BAR_HEIGHT / 2,
                (int) (Constantes.LOADING_BAR_WIDTH * percentage),
                Constantes.LOADING_BAR_HEIGHT);

        g2d.drawRect(Constantes.WIDTH / 2 - Constantes.LOADING_BAR_WIDTH / 2,
                Constantes.HEIGHT / 2 - Constantes.LOADING_BAR_HEIGHT / 2,
                Constantes.LOADING_BAR_WIDTH,
                Constantes.LOADING_BAR_HEIGHT);

        Texto.drawText(g2d, "Juego de Nave &   Ateroides", new Vector2D(Constantes.WIDTH / 2, Constantes.HEIGHT / 2 - 50),
                true, Color.WHITE, font);

        Texto.drawText(g2d, "CARGANDO...", new Vector2D(Constantes.WIDTH / 2, Constantes.HEIGHT / 2 + 40),
                true, Color.WHITE, font);

    }

}
