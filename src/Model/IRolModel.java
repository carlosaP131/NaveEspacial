/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Interfaz para la entidad Rol
 **
 * ****************************************************************************/
package Model;

import entity.Rol;
import java.util.List;

public interface IRolModel {
    public void insertarregistro(Rol rol);
    public  List<Rol> ObtenerRegistro();
   public void ActualizarRegistro(Rol rolnuevo);
   public void EliminarRegistro(Rol rol);
   public Rol BuscarRegistro(int id);
    
    
}
