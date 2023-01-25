/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Interfaz base para el service de las tres entidades 
 **
 * ****************************************************************************/
package Service.base;

import java.util.List;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 * @param <Usuario>
 */
public interface IRegistroServiceBase<Usuario> {

    public void InsertarRegistro(Usuario Registro);

    public List<Usuario> ObtenerRegistro();

    public void ActualizarRegistro(Usuario idRegistro);

    public void EliminarRegistro(int id);

    public Usuario BuscarRegistro(int id);
    public void ActulaizarPuntaje(Usuario Registro,int Puntaje);
           
}
