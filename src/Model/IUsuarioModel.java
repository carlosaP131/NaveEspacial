/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Interfaz para la entidad Usuario
 **
 * ****************************************************************************/
package Model;



import entity.Usuario;
import java.util.List;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public interface IUsuarioModel {
    //metodos abstractos del CRUD
    public void insertarregistro(Usuario usuario);
    public  List<Usuario> ObtenerRegistro();
   public void ActualizarRegistro(Usuario usuario);
   public void EliminarRegistro(int usuario);
   public Usuario BuscarRegistro(int id);
    
    
}
