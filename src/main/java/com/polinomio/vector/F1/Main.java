package com.polinomio.vector.F1;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int grado, numeroTerminos;
        String rta;
       
        grado = Integer.parseInt(mostrarMansaje("Ingrese el grado del polinomio"));
        PolvF1 A = new PolvF1(grado);
       
        numeroTerminos = Integer.parseInt(mostrarMansaje("Ingrese numero de terminos"));
        insertarTerminos(A, numeroTerminos);
       
        rta = mostrarMenu();
       
        switch (rta) {
            case "1":
                JOptionPane.showMessageDialog(null, A.mostrar());
            break;
            case "2":
                int variable = Integer.parseInt(mostrarMansaje("Ingrese variable"));
                JOptionPane.showMessageDialog(null, "Polinomio evaluado: " + A.evaluar(variable));
            break;
            case "3":
                grado = Integer.parseInt(mostrarMansaje("Ingrese el grado del segundo polinomio"));
                PolvF1 B = new PolvF1(grado);
                numeroTerminos = Integer.parseInt(mostrarMansaje("Ingrese numero de terminos"));
                insertarTerminos(B, numeroTerminos);
                PolvF1 C = A.sumar(B);
                System.out.println("Resultado de la suma: " + C.mostrar());
            break;
            case "4":

            break;
            case "5":

            break;

            default:
            mostrarMansaje("¡¡ Hasta luego !!");
            break;
            }
    }
   
    public static String mostrarMansaje(String str){
        return JOptionPane.showInputDialog(str);
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
   
    public static void insertarTerminos(PolvF1 polinomio, int numeroTerminos) {
        int exponente;
        float coeficiente;

        while (numeroTerminos != 0) {
            coeficiente = Float.parseFloat(mostrarMansaje("Ingresar el coeficiente"));
            exponente = Integer.parseInt(mostrarMansaje("Ingresar el exponente"));
            polinomio.insertarTerm(coeficiente, exponente);
            numeroTerminos--;
        }
    }
}