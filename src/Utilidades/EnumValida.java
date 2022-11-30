
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


