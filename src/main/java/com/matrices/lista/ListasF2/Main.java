package com.matrices.lista.ListasF2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int nf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de filas"));
        int nc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas"));
        int cd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de datos"));
        
        MDListaF2 mdf2 = new MDListaF2(nf, nc);
        mdf2.ingresarDatos(cd);
        mdf2.mostrar();
    }
}
