package com.polinomio.lista;

import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
    	int cantTerm = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos"));
        Lista list = new Lista();
        list.ingresarTerminos(cantTerm);
    
		String rta = mostrarMenu();
		
		switch (rta) {
		    case "1":
		    	list.mostrar();
		    break;
		    case "2":
		        int variable = Integer.parseInt(JOptionPane.showInputDialog("Ingrese variable"));
		        JOptionPane.showMessageDialog(null, "Resultado final: " + list.evaluar(variable));
		    break;
		    default:
		        JOptionPane.showMessageDialog(null, "¡¡ Hasta luego !!");
		    break;
		    }
    }

	public static String mostrarMenu(){
	    return JOptionPane.showInputDialog("\t \t MENU \n"
	            + "1. Mostrar \n"
	            + "2. Evaluar \n"
	            + "3. Sumar \n"
	            + "4. Multiplicar \n"
	            + "5. Dividir \n"
	            + "0. Salir ");
	}
}
