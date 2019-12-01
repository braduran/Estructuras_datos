
package com.matrices.lista.tripletas;

import com.matrices.lista.ListasF2.MDListaF2;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int nf = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de filas"));
        int nc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas"));
        int cd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de datos"));
        
        MDTripletas mdt = new MDTripletas(nf, nc, cd);
        mdt.ingresarDato();
        
        String rta = mostrarMenu();
        
        switch (rta) {
            case "1":
            	mdt.mostrar();
            break;
            case "2":
                int f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de filas F2"));
                int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de columnas F2"));
                int d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de datos F2"));
        
                MDListaF2 mdf2 = new MDListaF2(f, c);
                mdf2.ingresarDatos(d);
                
                mdt.multiplicarConF1(mdf2);
            break;
            default:
            	return;
        }
    }
    
    private static String mostrarMenu(){
        return JOptionPane.showInputDialog("\t \t MENU \n"
                + "1. Mostrar \n"
                + "2. Multiplicar con matriz forma 2 \n"
                + "0. Salir ");
    }
}
