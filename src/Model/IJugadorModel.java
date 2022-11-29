
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
