/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Entidad Usuario
 **
 * ****************************************************************************/
package Entity;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
import Entity.Base.IRegistroEntityBase;


public class Usuario implements IRegistroEntityBase{
    private int idUsuario;
    private String User;
    private String Pwd;
    private int idJugador;
    private String Rol;
    //geters y setters de Usuario
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    @Override
    public int getId() {
        return getIdUsuario();
    }

    @Override
    public void setId(int id) {
        setIdUsuario(id);
    }

    
}
