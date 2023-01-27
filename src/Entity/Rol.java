/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Entidad Rol
 **
 * ****************************************************************************/
package Entity;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
import Entity.Base.IRegistroEntityBase;



public class Rol implements IRegistroEntityBase{
    private int idRol;
    private String rol;

    public Rol() {
    }

    public Rol(int idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }
    //geters y setters de  Rol
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int getId() {
      
        return getIdRol();
      
    }

    @Override
    public void setId(int id) {
        setIdRol(id);
    
    }
    
}
