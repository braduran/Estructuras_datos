package com.polinomio.vector.F1;

import javax.swing.JOptionPane;

import com.polinomio.lista.Lista;
import com.polinomio.vector.F2.PolvF2;

public class Main {

    public static void main(String[] args) {
        PolvF1 A = nuevoPoinomio();
       
        String rta = mostrarMenu();
       
        switch (rta) {
            case "1":
                JOptionPane.showMessageDialog(null, A.mostrar());
            break;
            case "2":
                int variable = Integer.parseInt(mostrarMansaje("Ingrese variable"));
                JOptionPane.showMessageDialog(null, "Polinomio evaluado: " + A.evaluar(variable));
            break;
            case "3":
                PolvF1 B = nuevoPoinomio();
                PolvF1 B1 = A.sumar(B);
                
                JOptionPane.showMessageDialog(null, B1.mostrar());
            break;
            case "4":

            break;
            case "5":
            	PolvF1 C = nuevoPoinomio();
                PolvF1 C1 = A.dividir(C);
                
                JOptionPane.showMessageDialog(null, C1.mostrar());
            break;
            
            case "6":
            	int numTerm = Integer.parseInt(mostrarMansaje("Ingrese numero de terminos PoLista"));
                Lista list = new Lista();
                list.ingresarTerminos(numTerm);
                
                PolvF2 F1List = A.sumar(list);
                F1List.mostrar();
            break;
            case "7":
                int cantTermF2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos PolvF2"));
                PolvF2 F2 = new PolvF2(cantTermF2);
                F2.ingresarTerminos(cantTermF2);
                
                A.dividir(F2).mostrar();
            break;
            case "8":
                PolvF1 D = nuevoPoinomio();
                
                if(A.comparar(D)){
                    JOptionPane.showMessageDialog(null, D.mostrar(), 
                            "Los polinomios son iguales",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Los polinomios no son iguales...");
                }
            break;
            case "9":
            	int ctF2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de terminos PolvF2"));
                PolvF2 B2 = new PolvF2(ctF2);
                B2.ingresarTerminos(ctF2);
                
                if(A.comparar(B2)){
                    JOptionPane.showMessageDialog(null, A.mostrar(), 
                            "Los polinomios son iguales",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Los polinomios no son iguales...");
                }
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
                + "6. Sumar con Polinomio Lista \n"
                + "7. Dividir con Polinomio F2 \n"
                + "8. Comparar \n"
                + "9. Comparar con PolvF2 \n"
                + "0. Salir ");
    }
   
    public static PolvF1 nuevoPoinomio() {
        int exponente;
        float coeficiente;
        
        int grado = Integer.parseInt(mostrarMansaje("Ingrese el grado del polinomio"));
        PolvF1 X = new PolvF1(grado);
        
        int numeroTerminos = Integer.parseInt(mostrarMansaje("Ingrese numero de terminos"));

        while (numeroTerminos != 0) {
            coeficiente = Float.parseFloat(mostrarMansaje("Ingresar el coeficiente"));
            exponente = Integer.parseInt(mostrarMansaje("Ingresar el exponente"));
            X.insertarTerm(coeficiente, exponente);
            numeroTerminos--;
        }
        return X;
    }
}
