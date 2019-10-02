package com.polinomio.lista;

import javax.swing.JOptionPane;

import com.polinomio.vector.F1.PolvF1;
import com.polinomio.vector.F2.PolvF2;


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
		    case "3":
		    	int cantTermB = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos segundo polinomio"));
		        Lista listB = new Lista();
		        listB.ingresarTerminos(cantTermB);
		        
		        list.sumar(listB).mostrar();
		    break;
		    case "5":
		    	int cantTermC = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos segundo polinomio"));
		        Lista listC = new Lista();
		        listC.ingresarTerminos(cantTermC);
		        
		        list.dividir(listC).mostrar();
		    break;
		    case "6":
		    	int cantTermF2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos PolvF2"));
		    	PolvF2 F2 = new PolvF2(cantTermF2);
                F2.ingresarTerminos(cantTermF2);
                
                PolvF1 F1 = list.dividir(F2);
                JOptionPane.showMessageDialog(null, F1.mostrar());
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
	            + "6. Dividir con Polinomio F2 \n"
	            + "0. Salir ");
	}
}
