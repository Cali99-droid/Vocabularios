/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cali.controladores;

/**
 *
 * @author CARLOS ORELLANO
 */
public class ValidarEntrada {
    
     public static boolean validarLongitud(String dni){
        return dni.matches("\\d{1,300000}");    
    }
    
    public static boolean validarPlaca(String placa){
        return placa.matches("\\d{2}[a-zA-Z]\\.[a-zA-Z]{2}");
    }
    
    
}
