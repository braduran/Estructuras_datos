package com.grafos.lista;

public class Main {

	public static void main(String[] args) {
		ListaAdya l = new ListaAdya(9);
		
		l.insertarVertice(0, 5);
		l.insertarVertice(0, 6);
		l.insertarVertice(0, 9);
		l.insertarVertice(1, 4);
		l.insertarVertice(1, 6);
		l.insertarVertice(2, 5);
		l.insertarVertice(2, 7);
		l.insertarVertice(2, 9);
		l.insertarVertice(3, 6);
		l.insertarVertice(3, 9);
		l.insertarVertice(4, 1);
		l.insertarVertice(4, 7);
		l.insertarVertice(4, 8);
		l.insertarVertice(5, 0);
		l.insertarVertice(5, 2);
		l.insertarVertice(5, 9);
		l.insertarVertice(6, 0);
		l.insertarVertice(6, 1);
		l.insertarVertice(6, 3);
		l.insertarVertice(7, 2);
		l.insertarVertice(7, 4);
		l.insertarVertice(7, 9);
		l.insertarVertice(8, 2);
		l.insertarVertice(8, 4);
		l.insertarVertice(9, 2);
		l.insertarVertice(9, 3);
		l.insertarVertice(9, 5);
		l.insertarVertice(9, 7);
		
		l.mostrarGrafo();
	}
}
