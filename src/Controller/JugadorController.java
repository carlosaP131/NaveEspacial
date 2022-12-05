/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Jugador
 **
 * ****************************************************************************/
package Controller;

import Controller.base.RegistroControllerBase;
import Service.IJugadorService;
import Service.JugadorServiceImpl;
import entity.Jugador;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JugadorController extends RegistroControllerBase<Jugador> {

    private IJugadorService service;

       public void ini(){
           service = new JugadorServiceImpl();
           super.setServise(service);
       }
  /*
  *
  *
  */
    public void InsertarRegistro(Jugador jugador) {
        ini();

        super.setRegistro(jugador);
        super.crearActualizarRegistro();
    }

}
