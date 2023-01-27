/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Service Rol
 **
 * ****************************************************************************/
package Service;

import Model.RolModelImpl;
import entity.Rol;
import java.util.List;
import Model.IRolModel;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class RolServiceImpl implements IRolService {

    //realizar una instancia ala capa model 
    IRolModel model = new RolModelImpl();

    //se hace un override a los metodos de IRolService
    @Override
    public void insertarRegistro(Rol Registro) {
                model.insertarregistro(Registro);
    }

    @Override
    public List<Rol> obtenerRegistro() {
      return  model.ObtenerRegistro();
    }

    @Override
    public void actualizarRegistro(Rol  Registro) {
        model.ActualizarRegistro( Registro);
    }

    @Override
    public void eliminarRegistro(int Registro) {
            model.BuscarRegistro(Registro);
    }

    @Override
    public Rol buscarRegistro(int id) {
       return model.BuscarRegistro(id);
    }

}
