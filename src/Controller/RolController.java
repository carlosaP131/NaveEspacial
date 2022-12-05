/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Rol
 **
 * ****************************************************************************/
package Controller;

import Controller.base.RegistroControllerBase;
import Service.IRolService;
import Service.RolServiceImpl;
import entity.Rol;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RolController extends RegistroControllerBase<Rol> {

    private IRolService service;
       public void ini(){
           service = new RolServiceImpl();
           super.setServise(service);
       }
  /*
   
       
   */     

   
    public void CrearActualizarRegistro(Rol rol) {
        //ini();
        super.setRegistro(rol);
        super.crearActualizarRegistro();

    }

}
