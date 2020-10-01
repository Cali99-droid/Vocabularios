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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/*
   Clase Vocabulario
   
*/

public class Vocabulario {
    
   
    /**
     * atributo elementos: arraylist que contiene los elementos o simbolos del vocabulario
     */ 
    private ArrayList<String> elementos = new ArrayList<>();
    
    /**
     *  atributo arrayDeCadenas: array que contiene arrays al generar cadenas
     */ 
    private  ArrayList<ArrayList<String>> arrayDeCadenas = new ArrayList(); 


    /**
     *  atributo longitud: determina la longitud del vocabulario
     */    
    private  int longitud ;
    
    /**
     *  atributo nombre: determina el nombre del vocabulario
     */ 
    private String nombre;
   
    /**
     * 
     * <b>post: </b> El objeto vocabulario se crea solamente con un longitud y un nombre
     * @param longitud  - pertenece al intervalo mayor a 0 y menor a 7
     * @param nombre - da nombre al vocabulario}
     */
    public Vocabulario(int longitud, String nombre) {
        this.longitud = longitud;
        this.nombre = nombre;
    }
    
    /**
     * Retorna el nombre del Vocabulario
     * @return nombre del Vocabulario
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Asigna el nombre del Vocabulario
     *
     * @param nombre - nombre del Vocabulario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Retorna los elementos del vocabulario
     * @return elementos del Vocabulario
     */
    public ArrayList<String> getElementos() {
        return elementos;
    }

    /**
     * asigna elementos al vocabulario(no usuado)
     * 
     * @param elementos - elementos del vocabulario
     */
    public void setElementos(ArrayList<String> elementos) {
        this.elementos = elementos;
    }
    /**
     * Retorna la longitud del vocabulario
     * @return longitud del vocabulario
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Asigna la longitud del vocabulario
     * 
     * @param longitud -  longitud del vocabulario
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    /**
     * Agrega y valida los elementos que seran del vocabulario
     * @param valor - elemento a añadir
     * @return b - codigo de error al validar
     */
    public int agregarElementos(String valor) {
        int b = 0;
        if (elementos.size() >= longitud) {
            b = 1;
        } else if (elementos.contains(valor)) {
            b = 2;
        } else if (valor.length() == 0) {
            b = 3;
        } else {
            elementos.add(valor);
        }

        return b;
    }
    
    /**
     * Retorna el conjunto de las cadenas generadas del vocabulario
     * @return conjunto de las cadenas generadas del vocabulario
     */
    public ArrayList<ArrayList<String>> getArrayDeCadenas() {
        return arrayDeCadenas;
    }

    /**
     * Asigna un conjunto de las cadenas generadas del vocabulario(no usado)
     * 
     * @param arrayDeCadenas - no usado
     */
    public void setArrayDeCadenas(ArrayList<ArrayList<String>> arrayDeCadenas) {
        this.arrayDeCadenas = arrayDeCadenas;
    }
    
    /**
     * crea cadena con longitud aleatoria con los simbolos del Vocabulario
     * @param cantidadCadena - cantidad de cadenas que se generaran
     */
    public void crearCadena( int cantidadCadena){
        arrayDeCadenas.clear(); 
       
       // Vocabulario voc = vocabularios.get(indice);
        
        ArrayList<String> cad     = elementos; 
        List<String> ejemploLista = cad;  
        
        for (int i = 0; i < cantidadCadena; i++) {
            ArrayList<String> cadenaGenerada = new ArrayList<>();
         //   Collections.shuffle(ejemploLista);
            int longi =   devolverLongitudAleatoria();
                for (int e = 0; e < longi; e++) {
                    Collections.shuffle(ejemploLista);
                    cadenaGenerada.add(ejemploLista.get(devolverElementoAleatoria()));
                 }          
           arrayDeCadenas.add(cadenaGenerada);            
        }
     
    }
    
    /**
     * Devuelve un arraylist con las cadenas generadas pero con 
     * cada simbolo concatenado
     * @return  cadenas - arraylist con las cadenas generadas concatenadas
     */
    public ArrayList<String> devolverCadenaConcatenada(){   
       ArrayList<String> cadenas = new ArrayList<>();
       
       for (int i = 0; i < arrayDeCadenas.size(); i++) {
           
            ArrayList<String> ara = arrayDeCadenas.get(i);
            StringBuilder cadena  = new StringBuilder();
            
            for (int j = 0; j < ara.size(); j++) {
                cadena.append( ara.get(j));    
            }
             cadenas.add(cadena.toString());            
            }
       return  cadenas;
   }
    
    /**
     * Devuelve un numero aleatorio que sera la longitud de 
     * las cadenas generadas
     * @return  longitud aleatoria
     */
    public int devolverLongitudAleatoria(){
        
       // System.out.println("indice seleccionado: " + indice);
        return (int)(Math.random()*10+1);
    }
    
    /**
     * Devuelve un numero aleatorio que sera el índice del
     * simbolo de la cadena que se creara
     * @return  numero aleatorio 
     */
      public int devolverElementoAleatoria(){
        int limite = getLongitud() - 1;
       // System.out.println("indice seleccionado: " + indice);
        return (int)(Math.random()*limite+0);
    }
    
    

}
