/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Nacional Santiago Antunez de Mayolo
 * Ingeniería de Sistemas e Infomatica
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Curso: Teoria del Lenguaje
 * Ejercicio: Vocabularios
 * Autor: Orellano Rondan Carlos - Noviembre - 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.cali.controladores;

/**
 *
 * @author CARLOS ORELLANO
 */
public class ValidarEntrada {
    
    /**
     * Expresion regular que valida el formato longitud y 
     * cantidad de cadenas
     * @param  dni - longitud o cantidad 
     */
     public static boolean validarLongitud(String dni){
        return dni.matches("\\d{1,300000}");    
    }
    
     /**
     * Expresion regular no usada
     * @param placa no usada
     * @return no usada
     */
    public static boolean validarPlaca(String placa){
        return placa.matches("\\d{2}[a-zA-Z]\\.[a-zA-Z]{2}");
    }
    
    
}
