/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase para los botones del menu 
 **
 * ****************************************************************************/
package InterfazUsuario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Graficos.Assets;
import Graficos.Texto;
import input.MovimientoMouse;
import Calculos.Vector2D;

public class Boton {
    /**
     * Variiables para los botones 
     */
    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private Accion action;
    private String text;
    /**
     * Constructor con parametros 
     * @param mouseOutImg
     * @param mouseInImg
     * @param x
     * @param y
     * @param text
     * @param action 
     */
    public Boton(
            BufferedImage mouseOutImg,
            BufferedImage mouseInImg,
            int x, int y,
            String text,
            Accion action
    ) {
        this.mouseInImg = mouseInImg;
        this.mouseOutImg = mouseOutImg;
        this.text = text;
        boundingBox = new Rectangle(x, y, mouseInImg.getWidth(), 
                mouseInImg.getHeight());
        this.action = action;
    }

    public void update() {

        if (boundingBox.contains(MovimientoMouse.X, MovimientoMouse.Y)) {
            mouseIn = true;
        } else {
            mouseIn = false;
        }

        if (mouseIn && MovimientoMouse.MLB) {
            action.doAction();
        }
    }

    public void draw(Graphics g) {

        if (mouseIn) {
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }

        Texto.drawText(
                g,
                text,
                new Vector2D(
                        boundingBox.getX() + boundingBox.getWidth() / 2,
                        boundingBox.getY() + boundingBox.getHeight()),
                true,
                Color.BLACK,
                Assets.fontMed);

    }

}
