/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Service Usuario
 **
 * ****************************************************************************/
package Service;

import Model.IUsuarioModel;
import Model.UsuarioModelImpl;

import entity.Usuario;
import java.util.List;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */

public class UsuarioServiceImpl implements  IUsuarioService{
     IUsuarioModel model = new UsuarioModelImpl();
     
    /**
     *
     * @param Registro
     */
    @Override
    public void InsertarRegistro(Usuario Registro ) {
        model.insertarregistro(Registro);
    }

    @Override
    public List<Usuario> ObtenerRegistro() {
        return model.ObtenerRegistro();
    }

    @Override
    public void ActualizarRegistro(Usuario idRegistro) {
        model.ActualizarRegistro( idRegistro);
    }

    @Override
    public void EliminarRegistro(int id) {
        model.EliminarRegistro(id);
    }

    @Override
    public Usuario BuscarRegistro(int id) {
       return model.BuscarRegistro(id);
    }

   

}
