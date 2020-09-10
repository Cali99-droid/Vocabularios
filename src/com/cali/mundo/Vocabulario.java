package com.cali.mundo;

import java.util.ArrayList;

public class Vocabulario {

    private ArrayList<String> elementos = new ArrayList<>();
    private  int longitud ;
    private String nombre;
   

    public Vocabulario(int longitud, String nombre) {
        this.longitud = longitud;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<String> elementos) {
        this.elementos = elementos;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

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

}
