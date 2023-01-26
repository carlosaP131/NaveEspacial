/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase  para los estados del menu
 **
 * ****************************************************************************/
package Estados;

import java.awt.Graphics;
import java.util.ArrayList;

import Objetos.Constantes;
import Graficos.Assets;
import InterfazUsuario.Boton;
import InterfazUsuario.Accion;
/**
 * 
 * @author Carlos Aurelio Alcantara Perez 
 */
public class EstadoMenu extends Estado {
    /**
     * Variable para los botones
     */
    private ArrayList<Boton> botones;
    /**
     * Constructor sin parametros
     */
    public EstadoMenu() {
        botones = new ArrayList<Boton>();

        botones.add(new Boton(
                Assets.btnGris,
                Assets.btnAzul,
                Constantes.WIDTH / 2 - Assets.btnGris.getWidth() / 2,
                Constantes.HEIGHT / 2 - Assets.btnGris.getHeight() * 2,
                Constantes.PLAY,
                new Accion() {
            @Override
            public void doAction() {
                Estado.changeState(new EstadoJuego());
            }
        }
        ));

        botones.add(new Boton(
                Assets.btnGris,
                Assets.btnAzul,
                Constantes.WIDTH / 2 - Assets.btnGris.getWidth() / 2,
                Constantes.HEIGHT / 2 + Assets.btnGris.getHeight() * 2,
                Constantes.EXIT,
                new Accion() {
            @Override
            public void doAction() {
                System.exit(0);
            }
        }
        ));

        botones.add(new Boton(
                Assets.btnGris,
                Assets.btnAzul,
                Constantes.WIDTH / 2 - Assets.btnGris.getWidth() / 2,
                Constantes.HEIGHT / 2,
                Constantes.HIGH_SCORES,
                new Accion() {
            @Override
            public void doAction() {
                Estado.changeState(new Puntaje());
            }
        }
        ));

    }
    /**
     * Actualizar el estado
     */
    @Override
    public void update() {
        for (Boton b : botones) {
            b.update();
        }
    }
    /**
     * Dibuja los botones 
     * @param g 
     */
    @Override
    public void draw(Graphics g) {
        for (Boton b : botones) {
            b.draw(g);
        }
    }

}
