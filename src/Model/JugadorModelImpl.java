/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Model de la entidad Jugador 
 **
 * ****************************************************************************/
package Model;

import DB.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Jugador;
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
public class JugadorModelImpl implements IJugadorModel {

    private Conexion conexion;
    private Connection connection;
    private Statement stm;
     int id;
    @Override
    public void insertarregistro(Jugador jugador) {
        try {
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "insert into jugador(nombre,edad,sexo,telefono,correo,direccion,puntos)values('"
                    +jugador.getNombre()+"',"+jugador.getEdad()+",'"+jugador.getSexo()+"',"
                    + "'"+jugador.getTelefono()+"','"+jugador.getCorreo()+"','"+jugador.getDireccion()+"',"+jugador.getPuntos()+");";
            stm = connection.createStatement();
            stm.execute(query);
            stm.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JugadorModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Jugador> ObtenerRegistro() {
        try {
            List<Jugador> listajugador = new ArrayList<>();
            ResultSet rs;
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "select * from jugador;";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            while (rs.next()) {
                Jugador jugador = new Jugador();
                jugador.setIdJugador(rs.getInt(1));
                jugador.setNombre(rs.getString(2));
                listajugador.add(jugador);
            }
            stm.close();
            connection.close();
            return listajugador;
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JugadorModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void ActualizarRegistro( Jugador jugadornuevo) {

        try {

            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "call Actualizar('"+jugadornuevo.getIdJugador()+"','"+jugadornuevo.getNombre()+"');";
            ResultSet rs;
            stm = connection.createStatement();
            stm.execute(query);
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
            stm.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JugadorModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void EliminarRegistro(int jugador) {

        try {

            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "delete from jugador where id_jugador='"+jugador+"';";
            stm = connection.createStatement();
            stm.execute(query);
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            stm.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JugadorModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Jugador BuscarRegistro(int id) {
        try {
            Jugador jugador = new Jugador();
            ResultSet rs;
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "call Buscar('"+id+"')";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
            rs.next();
            jugador.setIdJugador(rs.getInt(1));
            jugador.setNombre(rs.getString(2));
            stm.close();
            connection.close();
            return jugador;
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JugadorModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int regresarid (Jugador jugador){
         try {
         
            ResultSet rs;
            conexion = new Conexion();//se establece la conexion
            connection = conexion.getConnection();//se obtiene la conexion de la base de datos 
            String query = "select id_jugador from jugador  where nombre='"+jugador.getNombre()+"';";
            stm = connection.createStatement();
            rs = stm.executeQuery(query);
           while (rs.next()) {
               
                jugador.setIdJugador(rs.getInt(1));
                  id = jugador.getIdJugador();
               
            }
           stm.close();
            connection.close();
           return id;
        } catch (SQLException e) {
            System.err.println("Error:");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JugadorModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
       
    }
//    public static void main(String[] args) throws ClassNotFoundException {
//        IJugadorModel model = new JugadorModelImpl();
//        Jugador jugador = new Jugador();
//        jugador.setNombre("arbol");
//        jugador.setCorreo("hjdkasuyakda");
//        jugador.setEdad(15);
//        jugador.setDireccion("hjdkasuyakda");
//        jugador.setSexo("masculino");
//        jugador.setTelefono("8446984984");
//        
//        model.insertarregistro(jugador);
//        List<Jugador> lista = model.ObtenerRegistro();
//        for (int i = 0; i < lista.size(); i++) {
//            System.out.println(lista.get(i).getNombre());
//        }
//        Jugador jugador2 = new Jugador();
//        jugador2.setNombre("arbol2");
//        model.ActualizarRegistro(jugador.getId(), jugador2);
//         model.EliminarRegistro(jugador);
//    }

}
