package com.grafos.lista;

public class ListaAdya {
	private int n;
	private Nodo[] lista;
	
	public ListaAdya(int vertices) {
		this.n = vertices;
		lista = new Nodo[vertices+1];
		for (int i = 0; i <= vertices; i++) {
			Nodo nodo = new Nodo(i);
			lista[i] = nodo;
		}
	}
	
	public void insertarVertice(int base, int vertice) {
		Nodo nuevo = new Nodo(vertice);
		
		if(lista[base] == null){
			lista[base] = nuevo;
		}else {
			Nodo actual = lista[base];
			while(actual.getLiga() != null) {
				actual = actual.getLiga();
			}
			actual.setLiga(nuevo);
		}
	}
	
	public void mostrarGrafo(){
		for(int i = 0; i <= this.n; i++){
			Nodo actual = lista[i].getLiga();
			
			while(actual != null){
				System.out.printf("%d -> %d\n", i, actual.getVertice());
				actual = actual.getLiga();
			}
			System.out.println();
		}
	}
}
