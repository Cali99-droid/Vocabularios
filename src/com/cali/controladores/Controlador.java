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

import com.cali.interfaz.FrameVocabulario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.cali.mundo.Vocabulario;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author CARLOS ORELLANO
 */
public class Controlador implements ActionListener, ListSelectionListener {
    
    /**
     * Vista, interfaz del programa
     */
    private FrameVocabulario frmVocabulario;
    
    /**
     * Objeto para validar
     */
    private ValidarEntrada validar ;
    
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    /**
     * Limite de Vocabularios
     */
    private static int LIMITE_DE_VOCABULARIOS   = 6;
    
    /**
     * Longitud Maxima
     */
    private static int LONGITUD_MAXIMA = 7;
    
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    
    /**
     * Array de objetos tipo vocabulario
     */
    private  ArrayList<Vocabulario> vocabularios = new ArrayList<>();
   // private  ArrayList<ArrayList<String>> arrayDeCadenas = new ArrayList();  
    
    
   /**
     * Crea el controlador y agrega oyentes a cada componente<br>
     * <b>post: </b> El Controlador comunica Vocabulario con Interfaz
     * @param frmVocabulario  - interfaz del programa
     */
    public Controlador(FrameVocabulario frmVocabulario) {
        this.frmVocabulario = frmVocabulario;
        this.frmVocabulario.btnAgregar.addActionListener(this);
       // this.frmVocabulario.btnAgregarElemto.addActionListener(this);
        this.frmVocabulario.listVocabulario.addListSelectionListener(this);
        this.frmVocabulario.btnGenerarCadenas.addActionListener(this);
        this.frmVocabulario.btnLimpiar.addActionListener(this);
        this.frmVocabulario.btnAgregarElemto.setVisible(false);
        

    }

     /**
     * Inicializa el modelo y la vista
     */
    public void iniciar() {

        frmVocabulario.setTitle("Vocabularios");
        frmVocabulario.setLocationRelativeTo(null);
        frmVocabulario.setVisible(true);

    }
    
    
    /**
     * Implementa el metodo de las interfaces
     * ActionListener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVocabulario.btnAgregar) {

            if (frmVocabulario.txtLongitud.getText().length() == 0 || frmVocabulario.txtNombreVoc.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            } else {
                if (!validar.validarLongitud(frmVocabulario.txtLongitud.getText())) {
                    JOptionPane.showMessageDialog(null, "Incorrecto, corrija formato de longitud");
                }else{
                int longitud  = Integer.parseInt(frmVocabulario.txtLongitud.getText());
                String nombre = frmVocabulario.txtNombreVoc.getText().toString();
                agregarVocabulario(longitud, nombre);
                llenarListVoc();
                limpiar();
                }
            }
        }
//        if (e.getSource() == frmVocabulario.btnAgregarElemto) {
//            agregarElmento();
//        }
        if (e.getSource() == frmVocabulario.btnGenerarCadenas) {
        
            String cantidad = JOptionPane.showInputDialog(null, "Ingrese la cantidad de cadenas");
            if (!validar.validarLongitud(cantidad)) {
                JOptionPane.showMessageDialog(null, "Incorrecto, corrija formato de cantidad");
            }else{
                int cantidadCadenas = Integer.parseInt(cantidad);
                //Agregue esto
                if(cantidadCadenas <= 1){
                    
                    JOptionPane.showMessageDialog(null, "ingrese mas de dos cadenas ");
                }else{
                     generarCadenas(cantidadCadenas);
                }
               
                //llenarCadenas(); 
            }
           
            
        }
        
        if (e.getSource() == frmVocabulario.btnLimpiar) {
           reiniciar();
            
        }

    }

    
    /**
     * Llena la JList del vocabulario
     */
    public void llenarListVoc() {
        frmVocabulario.mVocabulario.removeAllElements();
        for (int i = 0; i < vocabularios.size(); i++) {
            frmVocabulario.mVocabulario.add(i, vocabularios.get(i).getNombre());

        }
    }

    /**
     * Agrega un nuevo vocabulario al 
     * arraylist vocabularios
     * @param longitud - longitud del nuevo vocabulario
     * @param nombre - nombre del nuevo vocabulario
     */
    public void agregarVocabulario(int longitud, String nombre) {
        
        if (LONGITUD_MAXIMA>longitud) {
            vocabularios.add(new Vocabulario(longitud, nombre));
            frmVocabulario.txtNombreVoc.setEnabled(false);
            frmVocabulario.txtLongitud.setEnabled(false);
            int i = 0;
            while(i<longitud){
                if (agregarElmento()){
                     i++;
                }else{
                    i--;
                } 
            }
            
        } else  {
            JOptionPane.showMessageDialog(null, "La longitud sobrepasa el límite, LONGITUD MAXIMA = 7");
        }
    }

    /**
     * Limpiar los JTextField
     */
    public void limpiar() {
        frmVocabulario.txtLongitud.setText("");
        frmVocabulario.txtNombreVoc.setText("");
    }
    
   /**
     * Agregar y valida un elemento a un vocabulario
     * @return b boleana que confirma el elemento agregado
     */
    public boolean agregarElmento() {
        Vocabulario auxVoc;
      //  int indice = frmVocabulario.listVocabulario.getSelectedIndex();
      int indice = 0;
      boolean b= true;
      String valor;
        int aviso;
        if (indice != -1) {
            auxVoc = vocabularios.get(indice);
            valor  = JOptionPane.showInputDialog("Ingrese elemento del vocabulario: " + auxVoc.getNombre());
//            auxVoc.agregarElementos(valor);
            aviso = auxVoc.agregarElementos(valor);
            if ( aviso == 1) {
                frmVocabulario.lbMensaje.setForeground(Color.red);
                frmVocabulario.lbMensaje.setText("¡Vocabulario lleno !!");
            }else if (aviso == 2) {
                      frmVocabulario.lbMensaje.setForeground(Color.red);
                      frmVocabulario.lbMensaje.setText("¡Este elemento ya existe!!");
                }else if (aviso == 3) {
                          frmVocabulario.lbMensaje.setForeground(Color.red);
                          frmVocabulario.lbMensaje.setText("¡Ingrese un elemento vàlido!!");
                          b = false;
                }else{
                            frmVocabulario.lbMensaje.setForeground(Color.green);
                            frmVocabulario.lbMensaje.setText("¡Agregado con exito!!");
            }
            
            frmVocabulario.mElemento.removeAllElements();
            for (int i = 0; i < auxVoc.getElementos().size(); i++) {
                frmVocabulario.mElemento.add(i, auxVoc.getElementos().get(i));
            }

        } else {
            frmVocabulario.lbMensaje.setForeground(Color.red);
            frmVocabulario.lbMensaje.setText("¡Seleccione un Vocabulario de la lista!!");

        }
    return b;
    }

    /**
     * implementa la interfaz de
     * ListSelectionListener
     * @param e - ListSelectionEvent evento de seleccionde item del JList
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Vocabulario auxVoc;
        int indice = frmVocabulario.listVocabulario.getSelectedIndex();

        if (indice != -1) {
            auxVoc = vocabularios.get(indice);
            frmVocabulario.lbMensaje.setForeground(Color.blue);
            frmVocabulario.lbMensaje.setText("LONGITUD: " + vocabularios.get(indice).getLongitud());
            
            frmVocabulario.mElemento.removeAllElements();
            
            for (int i = 0; i < auxVoc.getElementos().size(); i++) {
                frmVocabulario.mElemento.add(i, auxVoc.getElementos().get(i));
            }
        }

    }
    
    /**
     * Genera las cadenas del vocabulario seleccionado en el JList
     * @param cantidadCadena - cantidad de cadenas a crearse
     */
    public void generarCadenas(int cantidadCadena){
        
        int indice = frmVocabulario.listVocabulario.getSelectedIndex();
        if(indice == -1){
            JOptionPane.showMessageDialog(null, "Selecciona un vocabulario");
         }else{
            
        Vocabulario voc = vocabularios.get(indice);
       // int longi =  devolverAleatorio();
        voc.crearCadena(cantidadCadena);
        
        llenarCadenas(voc);
        }
        
        
        
        
        
//        arrayDeCadenas.clear();
//        int indice = frmVocabulario.listVocabulario.getSelectedIndex();
//        
//        if(indice == -1){
//            JOptionPane.showMessageDialog(null, "Selecciona un vocabulario");
//        }else{
//        Vocabulario voc = vocabularios.get(indice);
//        
//        ArrayList<String> cad = voc.getElementos();
//        
//        List<String> ejemploLista = cad;          
//        for (int i = 0; i < cantidadCadena; i++) {
//            ArrayList<String> cadenaGenerada = new ArrayList<>();
//            Collections.shuffle(ejemploLista);
//            int longi =  devolverAleatorio();
//            for (int e = 0; e < longi; e++) {
//               cadenaGenerada.add(ejemploLista.get(e));
//           }           
//           arrayDeCadenas.add(cadenaGenerada);            
//        }
//  
//        }

    }
    
    /**
     * llena las cadenas generadas de longitudes diferentes
     * @param voc - vocabulario del que se generaran las cadenas
     */
    public void llenarCadenas(Vocabulario voc){
        frmVocabulario.mCadena.removeAllElements();
        for (int i = 0; i <  voc.devolverCadenaConcatenada().size(); i++) {
            frmVocabulario.mCadena.add(i, voc.devolverCadenaConcatenada().get(i));
            System.out.println(voc.devolverCadenaConcatenada().get(i));

        }
    }
    
    
    /**
     * No usado
     * @return nada
     */
    public int devolverAleatorio(){
        int indice      = frmVocabulario.listVocabulario.getSelectedIndex();
        Vocabulario voc = vocabularios.get(indice);
       // System.out.println("indice seleccionado: " + indice);
        return (int)(Math.random()*voc.getElementos().size()+1);
    }
    
    
//   public ArrayList<String> devolverCadena(){
//       ArrayList<String> cadenas = new ArrayList<>();
//       
//       for (int i = 0; i < arrayDeCadenas.size(); i++) {
//            ArrayList<String> ara = arrayDeCadenas.get(i);
//            StringBuilder cadena = new StringBuilder();
//            for (int j = 0; j < ara.size(); j++) {
//                cadena.append( ara.get(j));    
//            }
//             cadenas.add(cadena.toString());            
//            }
//       return  cadenas;
//   }
   
   public void reiniciar(){
       vocabularios.clear();
       llenarListVoc();
       //arrayDeCadenas.clear();
       frmVocabulario.mCadena.removeAllElements();
       frmVocabulario.mElemento.removeAllElements();
       frmVocabulario.txtLongitud.setEnabled(true);
       frmVocabulario.txtNombreVoc.setEnabled(true);
   }

}
