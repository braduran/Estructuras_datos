
package com.polinomio.vector.F2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int cantTerm = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos"));
        PolvF2 A = new PolvF2(cantTerm);
        A.ingresarTerminos(cantTerm);
        
        String rta = mostrarMenu();
       
        switch (rta) {
            case "1":
                A.mostrar();
            break;
            case "2":
                int variable = Integer.parseInt(JOptionPane.showInputDialog("Ingrese variable"));
                JOptionPane.showMessageDialog(null, "Resultado final: " + A.evaluar(variable));
            break;
            case "3":
                int cantTermSegundo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos segundo polinomio"));
                PolvF2 B = new PolvF2(cantTermSegundo);
                B.ingresarTerminos(cantTermSegundo);
                
                PolvF2 C = A.sumar(B);
                C.mostrar();
            break;
            case "5":
                int cantTerm2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos segundo polinomio"));
                PolvF2 B1 = new PolvF2(cantTerm2);
                B1.ingresarTerminos(cantTerm2);
                
                PolvF2 C1 = A.dividir(B1);
                C1.mostrar();
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
