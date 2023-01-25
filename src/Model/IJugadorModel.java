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
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public interface IJugadorModel {
    //metodos abstractos del CRUD
    public void insertarregistro(Jugador jugador);
    public  List<Jugador> ObtenerRegistro();
   public void ActualizarRegistro(Jugador jugadornuevo);
   public void EliminarRegistro(int jugador);
   public Jugador BuscarRegistro(int jugador);
   public void ActualizarPuntaje(Jugador jugador,int Puntaje ); 
    
}
