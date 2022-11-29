/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author labdessw09
 */
public class UsuarioController  extends RegistroControllerBase<Usuario> {
     private IUsuarioService service;
  
//instancia a servicio 
//    IRolService service = new RolServiceImpl();
//    
    public void InsertarRegistro(Usuario usuario) {
        service = new UsuarioServiceImpl();
//        service.InsertarRegistro(rol);
        super.setServise(service);
        super.setRegistro(usuario);
        super.crearActualizarRegistro();
    }
  public void mostrar(DefaultTableModel modelo){
      service = new UsuarioServiceImpl();
       List<Usuario> listausuario = service.ObtenerRegistro();
        modelo.setRowCount(0);
        for (Usuario usuario : listausuario) {
            Object[] fila = new Object[3];
            fila[0] =String.valueOf(usuario.getIdUsuario());
            fila[1] = usuario.getUser();
            fila[2] = usuario.getIdJugador();
            modelo.addRow(fila);
          
        }
       
   
   
  
}
   
}
