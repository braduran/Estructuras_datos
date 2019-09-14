
package com.polinomio.vector.F2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int cantTerm = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos"));
        PolvF2 f2 = new PolvF2(cantTerm);
        f2.ingresarTerminos(cantTerm);
        f2.mostrar();
    }
}
