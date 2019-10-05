package com.matrices.lista.ListasF1;

import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args){
        int nf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de filas"));
        int nc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas"));
        int cd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de datos"));
        
        MDListaF1 mdf1 = new MDListaF1(nf, nc);
        mdf1.ingresarDatos(cd);
        mdf1.mostrar();
    }
}
