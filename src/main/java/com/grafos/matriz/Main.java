package com.grafos.matriz;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Matriz matriz = new Matriz(10);
	    
		matriz.agregar(0, 5, 8);
		matriz.agregar(0, 6, 8);
		matriz.agregar(0, 9, 2);
		
		matriz.agregar(1, 4, 4);
		matriz.agregar(1, 6, 2);
		
		matriz.agregar(2, 5, 6);
		matriz.agregar(2, 7, 4);
		matriz.agregar(2, 8, 6);
		matriz.agregar(2, 9, 4);
		
		matriz.agregar(3, 6, 8);
		matriz.agregar(3, 9, 2);
		
		matriz.agregar(4, 1, 4);
		matriz.agregar(4, 7, 2);
		matriz.agregar(4, 8, 6);
		
		matriz.agregar(5, 0, 8);
		matriz.agregar(5, 2, 6);
		matriz.agregar(5, 9, 4);
		
		matriz.agregar(6, 0, 8);
		matriz.agregar(6, 1, 2);
		matriz.agregar(6, 3, 8);
		
		matriz.agregar(7, 2, 4);
		matriz.agregar(7, 4, 2);
		matriz.agregar(7, 9, 2);
		
		matriz.agregar(8, 2, 6);
		matriz.agregar(8, 4, 6);
		
		matriz.agregar(9, 0, 2);
		matriz.agregar(9, 2, 4);
		matriz.agregar(9, 3, 2);
		matriz.agregar(9, 5, 4);
		matriz.agregar(9, 7, 2);
	    
	    matriz.imprimir();
	    //JOptionPane.showMessageDialog(null, matriz.gradoVertice(2));
	    //matriz.DFS_Madya(3);
	    matriz.dijkstra(3);
	}
}
