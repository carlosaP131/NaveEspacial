/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Entidad Persona para definir los atributos de usuario y jugador 
 **
 * ****************************************************************************/
package entity;

/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */
public class Persona {
    private String Nombre;
    private int Edad;
    private String Sexo;
    private String Telefono;
    private String Correo;
    private String Direccion;


    public Persona() {
    }

    public Persona(String Nombre, int Edad, String Sexo, String Telefono, String Correo, String Direccion) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
        
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

   

}
