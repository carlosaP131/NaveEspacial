/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción:Clase enum para la validacion del combobox
 **
 * ****************************************************************************/
package Utilidades;






public enum EnumValida {
   ADMIN("Admin"),
    Invitado("Invitado"),
    Jugador("Jugador");
    
    private final String tipo;


     EnumValida(String tipo) {
        this.tipo = tipo;
    }
    
    public String getValue(){
        return tipo;
    }
}


