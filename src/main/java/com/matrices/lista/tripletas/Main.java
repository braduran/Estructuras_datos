
package com.matrices.lista.tripletas;

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
            	System.out.println("Multiplicacion con F1");
            break;
            default:
            	return;
        }
    }
    
    private static String mostrarMenu(){
        return JOptionPane.showInputDialog("\t \t MENU \n"
                + "1. Mostrar \n"
                + "2. Multiplicar con matriz forma 1 \n"
                + "0. Salir ");
    }
}
