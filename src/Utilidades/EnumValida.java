
package Utilidades;






public enum EnumValida {
    Admin("Super Admin"),
    Invitado("Invitado"),
    Jugador("Admin");
    
    private final String tipo;


     EnumValida(String tipo) {
        this.tipo = tipo;
    }
    
    public String getValue(){
        return tipo;
    }
}
