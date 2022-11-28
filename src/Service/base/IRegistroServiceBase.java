/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.base;

import entity.Usuario;
import java.util.List;

/**
 *
 * @author labdessw09
 */
public interface IRegistroServiceBase<Usuario> {

    public void InsertarRegistro(Usuario Registro);

    public List<Usuario> ObtenerRegistro();

    public void ActualizarRegistro(Usuario idRegistro);

    public void EliminarRegistro(int id);

    public Usuario BuscarRegistro(int id);
}
