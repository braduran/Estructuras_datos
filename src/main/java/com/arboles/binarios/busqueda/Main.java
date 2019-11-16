package com.arboles.binarios.busqueda;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args){
        ArbolBB a = new ArbolBB();
        
        //int numeroPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de personas"));
        
        List<Persona> lp = new ArrayList<>();
        lp.add(new Persona("20", "Brayan", 22));
        lp.add(new Persona("55", "Victoria", 21));
        lp.add(new Persona("50", "Octupus", 102));
        lp.add(new Persona("35", "pepe", 12));
        lp.add(new Persona("10", "lola", 9));
        lp.add(new Persona("60", "gilda", 99));

        /*for (int i = 0; i < lp.size(); i++) {
            String cedula = JOptionPane.showInputDialog(null, "Ingrese cedula", "Persona #" + (i+1), JOptionPane.INFORMATION_MESSAGE);
            String nombre = JOptionPane.showInputDialog("Ingrese nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
            Persona p = new Persona(cedula, nombre, edad);
            a.insertar(p);
        }*/
        
        for(Persona p : lp){
            a.insertar(new Persona(p.getCedula(), p.getNombre(), p.getEdad()));
        }
        
        String rta = mostrarMenu();
        
        switch (rta) {
            case "1":
                a.recPreorden(a.getRaiz(), "");
            break;
            case "2":
                a.recInorden(a.getRaiz(), "");
            break;
            case "3":
                a.recPostorden(a.getRaiz(), "");
            break;
            case "4":
                String cedula = JOptionPane.showInputDialog("Ingrese cedula");
                a.buscar(cedula);
            break;
            case "5":
                System.out.println("Eliminar");
            break;
            
            default:
                JOptionPane.showMessageDialog(null, "¡¡ Hasta luego !!");
            break;
        }
    }

    public static String mostrarMenu(){
        return JOptionPane.showInputDialog("\t \t MENU \n"
                + "1. Mostrar en preorden \n"
                + "2. Mostrar en inorden \n"
                + "3. Mostrar en postorden \n"
                + "4. Buscar \n"
                + "5. Eliminar \n"
                + "0. Salir ");
    }    
}
