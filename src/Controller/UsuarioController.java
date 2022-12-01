/** **************************************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Usuario
 **
 * ************************************************************************************************ */
package Controller;

import Controller.base.RegistroControllerBase;
import Service.IUsuarioService;
import Service.UsuarioServiceImpl;
import entity.Usuario;
import entity.Jugador;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class UsuarioController extends RegistroControllerBase<Usuario> {

    private IUsuarioService service;

    /**
     *Método para crear un usuario usando la instancia a la clase 
     *service con el metodo crearActualisarRegistro 
     * 
     *@param usuario El parámetro Usuario es un objeto de tipo usuario
     */
    public void InsertarRegistro(Usuario usuario) {
        
        service = new UsuarioServiceImpl();
        super.setServise(service);
        super.setRegistro(usuario);
        super.crearActualizarRegistro();
    }
    /*
    *Método para mostrar un usuario ya creado 
    */
    public void mostrar(DefaultTableModel modelo) {
        service = new UsuarioServiceImpl();
        List<Usuario> listausuario = service.ObtenerRegistro();
        modelo.setRowCount(0);
        for (Usuario usuario : listausuario) {
            Object[] fila = new Object[4];
            fila[0] = String.valueOf(usuario.getIdUsuario());
            fila[1] = usuario.getUser();
            fila[2] = usuario.getIdJugador();
            fila[3] = usuario.getRol();
            modelo.addRow(fila);

        }

    }

}
