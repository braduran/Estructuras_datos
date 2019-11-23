package com.arboles.binarios.busqueda;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args){
        ArbolBB a = new ArbolBB();
        
        List<Persona> lp = new ArrayList<>();
        lp.add(new Persona("20", "Brayan", 22));
        lp.add(new Persona("55", "Victoria", 21));
        lp.add(new Persona("50", "Octupus", 102));
        lp.add(new Persona("35", "pepe", 12));
        lp.add(new Persona("10", "lola", 9));
        lp.add(new Persona("60", "gilda", 99));
        lp.add(new Persona("8", "A", 12));
        lp.add(new Persona("5", "B", 56));
        lp.add(new Persona("11", "C", 8));

        //int numeroPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de personas"));
        /*for (int i = 0; i < numeroPersonas; i++) {
            String cedula = JOptionPane.showInputDialog(null, "Ingrese cedula", "Persona #" + (i+1), JOptionPane.INFORMATION_MESSAGE);
            String nombre = JOptionPane.showInputDialog("Ingrese nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
            Persona p = new Persona(cedula, nombre, edad);
            a.insertar(p);
        }*/
        
        for(Persona p : lp){
            a.insertar(new Persona(p.getCedula(), p.getNombre(), p.getEdad()));
        }
        
        mostrarOpciones(a);
    }

    public static String mostrarMenu(){
        return JOptionPane.showInputDialog("\t \t MENU \n"
                + "1. Mostrar \n"
                + "2. Buscar \n"
                + "3. Modificar \n"
                + "4. Eliminar \n"
                + "5. Mostrar altura del arbol \n"
                + "6. Mostrar nodos de un nivel \n"
                + "0. Salir ");
    }    
    
    public static String mostrarMenuOrden(){
        return JOptionPane.showInputDialog("\t \t MENU \n"
                + "1. Mostrar en preorden \n"
                + "2. Mostrar en inorden \n"
                + "3. Mostrar en postorden \n"
                + "0. Salir ");
    }
    
    public static void mostrarOpciones(ArbolBB a){
        String rta = mostrarMenu();
        switch (rta) {
            case "1":
                String rtaMostrar = mostrarMenuOrden();
                switch(rtaMostrar){
                    case "1":
                        a.recPreorden(a.getRaiz(), "");
                    break;
                    case "2":
                        a.recInorden(a.getRaiz(), "");
                    break;
                    case "3":
                        a.recPostorden(a.getRaiz(), "");
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "¡¡ Hasta luego !!");
                    return;
                }
            break;
            case "2":
                String cedula = JOptionPane.showInputDialog("Ingrese cedula");
                a.buscar(cedula);
            break;
            case "3":
                String cedulaMod = JOptionPane.showInputDialog("Ingrese cedula");
                String nombreMod = JOptionPane.showInputDialog("Ingrese nombre");
                int edadMod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
                a.modificar(new Persona(cedulaMod, nombreMod, edadMod));
            break;
            case "4":
                System.out.println("Eliminar");
            break;
            case "5":
                JOptionPane.showMessageDialog(null, a.altura(a.getRaiz()));
            break;
            case "6":
                System.out.println("Mostrar nodos de un nivel");
            break;
            
            default:
                JOptionPane.showMessageDialog(null, "¡¡ Hasta luego !!");
            return;
        }
        
        mostrarOpciones(a);
    }
}
