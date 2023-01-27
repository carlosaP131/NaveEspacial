/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase controller del Rol
 **
 * ****************************************************************************/
package Controller;

import Controller.base.RegistroControllerBase;
import Service.RolServiceImpl;
import Entity.Rol;
import Service.IRolService;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class RolController extends RegistroControllerBase<Rol> {

    private IRolService service;
       public void ini(){
           service = new RolServiceImpl();
           super.setServise(service);
       }
  /*
   
       
   */     

   
    public void crearActualizarRegistro(Rol rol) {
        //ini();
        super.setRegistro(rol);
        super.crearActualizarRegistro();

    }

}
