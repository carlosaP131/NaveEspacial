/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Service Jugador
 **
 * ****************************************************************************/
package Service;


import Model.JugadorModelImpl;
import entity.Jugador;
import java.util.List;
import Model.IJugadorModel;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */

public class JugadorServiceImpl implements IJugadorService {

    //realizar una instancia ala capa model 
    IJugadorModel model = new JugadorModelImpl();
     //se hace un override a los metodos de IJugadorService
    @Override
    public void insertarRegistro(Jugador Registro) {
                model.insertarregistro(Registro);
    }

    @Override
    public List<Jugador> obtenerRegistro() {
      return  model.ObtenerRegistro();
    }

    @Override
    public void actualizarRegistro(Jugador  Registro) {
    //    model.actualizarRegistro();
    }

    @Override
    public void eliminarRegistro(int Registro) {
            model.EliminarRegistro(Registro);
    }

    @Override
    public Jugador buscarRegistro(int id) {
       return model.BuscarRegistro(id);
    }

}
