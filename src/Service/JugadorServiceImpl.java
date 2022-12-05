/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Service Jugador
 **
 * ****************************************************************************/
package Service;


import Model.IJugadorModel;
import Model.JugadorModelImpl;
import Model.JugadorModelImpl;
import entity.Jugador;
import java.util.List;


public class JugadorServiceImpl implements IJugadorService {

    //realizar una instancia ala capa model 
    IJugadorModel model = new JugadorModelImpl();

    @Override
    public void InsertarRegistro(Jugador Registro) {
                model.insertarregistro(Registro);
    }

    @Override
    public List<Jugador> ObtenerRegistro() {
      return  model.ObtenerRegistro();
    }

    @Override
    public void ActualizarRegistro(Jugador  Registro) {
    //    model.ActualizarRegistro();
    }

    @Override
    public void EliminarRegistro(int Registro) {
            model.EliminarRegistro(Registro);
    }

    @Override
    public Jugador BuscarRegistro(int id) {
       return model.BuscarRegistro(id);
    }

}
