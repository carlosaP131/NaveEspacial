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
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public interface IRolModel {
    //metodos abstractos del CRUD
    public void insertarregistro(Rol rol);
    public  List<Rol> ObtenerRegistro();
   public void ActualizarRegistro(Rol rolnuevo);
   public void EliminarRegistro(Rol rol);
   public Rol BuscarRegistro(int id);
    
    
}
