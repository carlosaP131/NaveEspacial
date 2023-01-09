/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Model de la entidad Usuario 
 *
 * ****************************************************************************/
package Model;

import DB.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Estadoment;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class UsuarioModelImpl implements IUsuarioModel {
    JugadorModelImpl jugador = new JugadorModelImpl();
    private Conexion conexion;
    private Connection connection;
    private Estadoment stm;
    //se hace un override a los metodos de IUsuarioModel
    @Override
    public void insertarregistro(Usuario usuario) {
      
        try {
           
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "insert into usuario(usuario,pdw,jugador_id,privilegio) values ('"+usuario.getUser()+"','"+usuario.getPwd()+"',"+1+",'"+usuario.getRol()+"');";
            stm = connection.createEstadoment();
            stm.execute(query);
            stm.close();
            connection.close();
            //id_usuario= id_usuario;
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> ObtenerRegistro() {
        try {
            List<Usuario> listarol = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "select * from usuario;";
            stm = connection.createEstadoment();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setUser(rs.getString("usuario"));
                usuario.setIdJugador(rs.getInt("jugador_id"));
                usuario.setRol(rs.getString("privilegio"));
                listarol.add(usuario);
            }
            stm.close();
            connection.close();
            return listarol;
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void ActualizarRegistro(Usuario rolnuevo) {

        try {

            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "call Actualizar('"+rolnuevo.getId()+"','"+rolnuevo.getUser()+"');";
            ResultSet rs;
            stm = connection.createEstadoment();
            stm.execute(query);
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
            stm.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void EliminarRegistro(int rol) {

        try {

            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "call Eliminar('"+rol+"');";
            stm = connection.createEstadoment();
            stm.execute(query);
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            stm.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario BuscarRegistro(int id) {
        try {
            Usuario rol = new Usuario();
            ResultSet rs;
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "call Buscar('"+id+"')";
            stm = connection.createEstadoment();
            rs = stm.executeQuery(query);
            rs.next();
            rol.setId(rs.getInt(1));
            rol.setUser(rs.getString(2));
            stm.close();
            connection.close();
            return rol;
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    


}
