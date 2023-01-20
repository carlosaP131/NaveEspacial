/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Jugador
 **
 * *************************************************************************** */
package Controller;

import Controller.base.RegistroControllerBase;
import Service.IJugadorService;
import Service.JugadorServiceImpl;
import entity.Jugador;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class JugadorController extends RegistroControllerBase<Jugador> {

    //Instancia al service de jugador 
    private IJugadorService service;

    public void ini() {
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

    public void mostrar(DefaultTableModel modelo) {
        service = new JugadorServiceImpl();
        List<Jugador> listajugador = service.ObtenerRegistro();
        modelo.setRowCount(0);
        for (Jugador jugador : listajugador) {
            Object[] fila = new Object[11];
            fila[0] = String.valueOf(jugador.getIdJugador());
            fila[1] = jugador.getNombre();
            fila[2] = jugador.getEdad();
            fila[3] = jugador.getCorreo();
            fila[4] = jugador.getPuntos();

            modelo.addRow(fila);

        }

    }

}
