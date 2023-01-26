/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 
 *Fecha de actualización:4-01-2023
 *Descripción: Clase Abstracta para los estados
 **
 * ****************************************************************************/
package Estados;

import java.awt.Graphics;
/**
 * 
 * @author Carlos Aurelio Alcantara Perez 
 */
public abstract class Estado {
    /**
     * Variiable para saber en que estado estamos
     */
    private static Estado estadoActual = null;
    /**
     * Regresa el estado en el que se encuentra el objeto o el programa 
     * @return regresa el estado
     */
    public static Estado getCurrentState() {
        return estadoActual;
    }
    /**
     * Cambia el estado actual del objeto o del programa 
     * @param newState regresa un nuevo estado
     */
    public static void changeState(Estado newState) {
        estadoActual = newState;
    }
    /**
     * Actualiza el estado 
     */
    public abstract void update();
    /**
     * Dibuja los estados
     * @param g 
     */
    public abstract void draw(Graphics g);

}
