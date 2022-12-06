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

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class JugadorController extends RegistroControllerBase<Jugador> {
    //Instancia al service de jugador 
    private IJugadorService service;

       public void ini(){
           service = new JugadorServiceImpl();
           super.setServise(service);
       }
  /*
  *
  * metodo para insertar
  */
    public void InsertarRegistro(Jugador jugador) {
        ini();

        super.setRegistro(jugador);
        super.crearActualizarRegistro();
    }

}
