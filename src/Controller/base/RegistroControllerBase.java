/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase generica para las clases controller
 *
 * ****************************************************************************/
package Controller.base;

import Service.base.IRegistroServiceBase;
import entity.base.IRegistroEntityBase;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 * @param <T>
 */

public abstract class RegistroControllerBase<T extends IRegistroEntityBase>{
    private T registro;
   private IRegistroServiceBase<T> servise;
   
    public void crearActualizarRegistro(){
       if(registro.getId()<1){
       
        servise.InsertarRegistro(registro);
       }else{
           servise.ActualizarRegistro(registro);
       }
    }
    public void EliminarRegistro(int id){
        servise.EliminarRegistro(id);
    }
    //Se escriben los demas metodos 
    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

    public void setServise(IRegistroServiceBase<T> servise) {
        this.servise = servise;
    }
    
    
    
    
}
