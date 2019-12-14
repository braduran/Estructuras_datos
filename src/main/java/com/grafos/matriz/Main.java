package com.grafos.matriz;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Matriz matriz = new Matriz(10);
	    
		matriz.agregar(0, 5);
		matriz.agregar(0, 6);
		matriz.agregar(0, 9);
		
		matriz.agregar(1, 4);
		matriz.agregar(1, 6);
		
		matriz.agregar(2, 5);
		matriz.agregar(2, 7);
		matriz.agregar(2, 8);
		matriz.agregar(2, 9);
		
		matriz.agregar(3, 6);
		matriz.agregar(3, 9);
		
		matriz.agregar(4, 1);
		matriz.agregar(4, 7);
		matriz.agregar(4, 8);
		
		matriz.agregar(5, 0);
		matriz.agregar(5, 2);
		matriz.agregar(5, 9);
		
		matriz.agregar(6, 0);
		matriz.agregar(6, 1);
		matriz.agregar(6, 3);
		
		matriz.agregar(7, 2);
		matriz.agregar(7, 4);
		matriz.agregar(7, 9);
		
		matriz.agregar(8, 2);
		matriz.agregar(8, 4);
		
		matriz.agregar(9, 0);
		matriz.agregar(9, 2);
		matriz.agregar(9, 3);
		matriz.agregar(9, 5);
		matriz.agregar(9, 7);
	    
	    matriz.imprimir();
	    JOptionPane.showMessageDialog(null, matriz.gradoVertice(2));
	    
	    matriz.DFS_Madya(3);
	}
}
