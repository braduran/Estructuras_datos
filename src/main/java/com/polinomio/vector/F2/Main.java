
package com.polinomio.vector.F2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int cantTerm = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos"));
        PolvF2 f2 = new PolvF2(cantTerm);
        f2.ingresarTerminos(cantTerm);
        
        String rta = mostrarMenu();
       
        switch (rta) {
            case "1":
                f2.mostrar();
            break;
            case "2":
                int variable = Integer.parseInt(JOptionPane.showInputDialog("Ingrese variable"));
                JOptionPane.showMessageDialog(null, "Resultado final: " + f2.evaluar(variable));
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
