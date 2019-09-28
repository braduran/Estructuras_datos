
package com.matrices.lista.tripletas;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int nf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de filas"));
        int nc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas"));
        int cd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de datos"));
        
        MDTripletas mdt = new MDTripletas(nf, nc, cd);
        mdt.ingresarDato();
        mdt.mostar();
    }
}
