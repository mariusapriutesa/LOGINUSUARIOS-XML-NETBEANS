/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author dam2
 */
public class Usuarios {
    
    String nombre;
    String contrasena;
    String rol;
    String correo;

    public Usuarios(String nombre, String contrasena, String rol, String correo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        this.correo = correo;
    }

    public Usuarios() {
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
}
