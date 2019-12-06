package com.arboles.binarios.busqueda;

import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args){
        ArbolBB a = new ArbolBB();
        
        int numeroPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de personas"));
        for (int i = 0; i < numeroPersonas; i++) {
            int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cedula", "Persona #" + (i+1), JOptionPane.INFORMATION_MESSAGE));
            String nombre = JOptionPane.showInputDialog("Ingrese nombre");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
            Persona p = new Persona(cedula, nombre, edad);
            a.insertar(p);
        }
        
        mostrarOpciones(a);
    }
    
    public static void mostrarOpciones(ArbolBB a){
        String rta = mostrarMenu();
        switch (rta) {
            case "1":
                String rtaMostrar = mostrarMenuOrden();
                switch(rtaMostrar){
                    case "1":
                        a.recPreorden(a.getRaiz(), "");
                        System.out.println("----------------");
                    break;
                    case "2":
                        a.recInorden(a.getRaiz(), "");
                        System.out.println("----------------");
                    break;
                    case "3":
                        a.recPostorden(a.getRaiz(), "");
                        System.out.println("----------------");
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "¡¡ Hasta luego !!");
                    return;
                }
            break;
            case "2":
                int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula"));
                a.buscar(cedula);
            break;
            case "3":
                int cedulaMod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula"));
                String nombreMod = JOptionPane.showInputDialog("Ingrese nombre");
                int edadMod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
                a.modificar(new Persona(cedulaMod, nombreMod, edadMod));
            break;
            case "4":
            	int cedulaEli = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula"));
            	a.eliminar(cedulaEli);
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
}
