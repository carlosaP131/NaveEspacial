/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase Abstracta para los Puntajes
 **
 * ****************************************************************************/
package Estados;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import Objetos.Constantes;
import Graficos.Assets;
import Graficos.Texto;
import Input.Puntuaciones;
import Calculos.Vector2D;
import InterfazUsuario.Boton;
import InterfazUsuario.Accion;

public class Puntaje extends Estado {
    /**
     * 
     */
    private Boton btnRegreso;

    private PriorityQueue<Puntuaciones> puntuacionAlta;

    private Comparator<Puntuaciones> comparacionPuntaje;

    private Puntuaciones[] auxArray;

    public Puntaje() {
        btnRegreso = new Boton(
                Assets.btnGris,
                Assets.btnGris,
                Assets.btnGris.getHeight(),
                Constantes.HEIGHT - Assets.btnGris.getHeight() * 2,
                Constantes.RETURN,
                new Accion() {
            @Override
            public void doAction() {
                Estado.changeState(new EstadoMenu());
            }
        }
        );

        comparacionPuntaje = new Comparator<Puntuaciones>() {
            @Override
            public int compare(Puntuaciones e1, Puntuaciones e2) {
                return e1.getScore() < e2.getScore() ? -1 : e1.getScore() > e2.getScore() ? 1 : 0;
            }
        };

        puntuacionAlta = new PriorityQueue<Puntuaciones>(10, comparacionPuntaje);

    }

    @Override
    public void update() {
        btnRegreso.update();
    }

    @Override
    public void draw(Graphics g) {
        btnRegreso.draw(g);

        auxArray = puntuacionAlta.toArray(new Puntuaciones[puntuacionAlta.size()]);

        Arrays.sort(auxArray, comparacionPuntaje);

        Vector2D scorePos = new Vector2D(
                Constantes.WIDTH / 2 - 200,
                100
        );
        Vector2D datePos = new Vector2D(
                Constantes.WIDTH / 2 + 200,
                100
        );

        Texto.drawText(g, Constantes.SCORE, scorePos, true, Color.BLUE, Assets.fontBig);
        Texto.drawText(g, Constantes.DATE, datePos, true, Color.BLUE, Assets.fontBig);

        scorePos.setY(scorePos.getY() + 40);
        datePos.setY(datePos.getY() + 40);

        for (int i = auxArray.length - 1; i > -1; i--) {

            Puntuaciones d = auxArray[i];

            Texto.drawText(g, Integer.toString(d.getScore()), scorePos, true, Color.WHITE, Assets.fontMed);
            Texto.drawText(g, d.getDate(), datePos, true, Color.WHITE, Assets.fontMed);

            scorePos.setY(scorePos.getY() + 40);
            datePos.setY(datePos.getY() + 40);

        }

    }

}
