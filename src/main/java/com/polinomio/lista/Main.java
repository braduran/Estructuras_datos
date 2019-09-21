package com.polinomio.lista;

import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
    	int cantTerm = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos"));
        Lista list = new Lista();
        list.ingresarTerminos(cantTerm);
        list.mostrar();
    }
}
