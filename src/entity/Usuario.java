/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.base.IRegistroEntityBase;

/**
 *
 * @author labdessw09
 */
public class Usuario implements IRegistroEntityBase{
    private int idUsuario;
    private String User;
    private String Pwd;
    private int idJugador;
    private String Rol;

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
