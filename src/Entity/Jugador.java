/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Entidad Jugador
 **
 * ****************************************************************************/
package Entity;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
import Entity.Base.IRegistroEntityBase;

public class Jugador extends Persona implements IRegistroEntityBase {

    private int IdJugador;
    private int Puntos;
    //geters y setters de Jugador 
    public int getIdJugador() {
        return IdJugador;
    }

    public void setIdJugador(int IdJugador) {
        this.IdJugador = IdJugador;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    @Override
    public int getId() {
        return getIdJugador();
    }

    @Override
    public void setId(int id) {
        setIdJugador(id);
    }

}
