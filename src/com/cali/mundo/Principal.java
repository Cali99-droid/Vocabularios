package com.cali.mundo;

import com.cali.interfaz.FrameVocabulario;
import com.cali.controladores.Controlador;
import java.util.ArrayList;

public class Principal {


	public static void main(String[] args) {
		
            FrameVocabulario frm = new FrameVocabulario();
            Controlador ctrl = new Controlador(frm);
            ctrl.iniciar();
		
	}
	
	
	
	

}
