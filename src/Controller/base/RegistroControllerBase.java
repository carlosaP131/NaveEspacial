/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase generica para las clases controller
 *
 * ****************************************************************************/
package Controller.base;

import Entity.Base.IRegistroEntityBase;
import Service.base.IRegistroServiceBase;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 * @param <T>
 */

public abstract class RegistroControllerBase<T extends IRegistroEntityBase>{
   // Se crea una variable generica de tipo T
    private T registro;
    //La instancia a sevise de tipo T para aceptar cada componente 
   private IRegistroServiceBase<T> servise;
   //Se implemetan todos los metodos del CRUD
    public void crearActualizarRegistro(){
       if(registro.getId()<1){
       
        servise.insertarRegistro(registro);
       }else{
           servise.actualizarRegistro(registro);
       }
    }
    public void eliminarRegistro(int id){
        servise.eliminarRegistro(id);
    }
    //Se crean los set´s y get´s
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
