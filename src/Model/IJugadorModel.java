/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Interfaz para la entidad Jugador
 **
 * ****************************************************************************/
package Model;

import entity.Jugador;

import java.util.List;

public interface IJugadorModel {
    public void insertarregistro(Jugador jugador);
    public  List<Jugador> ObtenerRegistro();
   public void ActualizarRegistro(Jugador jugadornuevo);
   public void EliminarRegistro(int jugador);
   public Jugador BuscarRegistro(int jugador);
    
    
}
