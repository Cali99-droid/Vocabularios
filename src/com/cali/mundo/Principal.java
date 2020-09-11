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

package com.cali.mundo;

import com.cali.interfaz.FrameVocabulario;
import com.cali.controladores.Controlador;


public class Principal {


	public static void main(String[] args) {
/**
 * inicializa el programa
 */
            FrameVocabulario frm = new FrameVocabulario();
            Controlador ctrl = new Controlador(frm);
            ctrl.iniciar();
		
	}
	
	
	
	

}
