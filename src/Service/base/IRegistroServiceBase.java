/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Interfaz base para el service de las tres entidades 
 **
 * ****************************************************************************/
package Service.base;

import Entity.Usuario;
import java.util.List;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 * @param <Usuario>
 */
public interface IRegistroServiceBase<Usuario> {

    public void insertarRegistro(Usuario Registro);

    public List<Usuario> obtenerRegistro();

    public void actualizarRegistro(Usuario idRegistro);

    public void eliminarRegistro(int id);

    public Usuario buscarRegistro(int id);
}
