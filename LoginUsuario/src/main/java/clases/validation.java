/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author mariu
 */
public class validation {
    public static String validarCamposVacios(String nombre ,String contra) {
        String mesaje="";
        if (nombre.equals("") ) {
            mesaje= " se debe introducir un nombre de usuario";
        }else if(contra.equals("") )
        {
            mesaje= "falta la contraseña";
        }
        return mesaje;
    }
    }// fin comprobar
    

