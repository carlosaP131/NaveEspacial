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
    public void InsertarRegistro(Rol Registro) {
                model.insertarregistro(Registro);
    }

    @Override
    public List<Rol> ObtenerRegistro() {
      return  model.ObtenerRegistro();
    }

    @Override
    public void ActualizarRegistro(Rol  Registro) {
        model.ActualizarRegistro( Registro);
    }

    @Override
    public void EliminarRegistro(int Registro) {
            model.BuscarRegistro(Registro);
    }

    @Override
    public Rol BuscarRegistro(int id) {
       return model.BuscarRegistro(id);
    }

    @Override
    public void ActulaizarPuntaje(Rol Registro, int Puntaje) {
        
    }

}
