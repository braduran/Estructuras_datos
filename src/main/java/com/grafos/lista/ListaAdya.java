package com.grafos.lista;

public class ListaAdya {
	private int n;
	private Nodo[] lista;
	
	public ListaAdya(int vertices) {
		this.n = vertices;
		lista = new Nodo[vertices+1];
	}
	
	public void insertarVertice(int i, int vertice) {
		Nodo nuevo;
		
		if(i <= n){
			nuevo = new Nodo(vertice);
			
			if(lista[i] == null) {
				lista[i] = nuevo;
			}else {
				Nodo actual = lista[i];
				while(actual.getLiga() !=  null){
					actual = actual.getLiga();
				}
				actual.setLiga(nuevo);
			}
		}
	}
	
	public void mostrarGrafo(){
		for(int i = 0; i < this.n; i++){
			Nodo actual = lista[i];
			
			while(actual != null){
				System.out.printf("%d -> %d\n", i, actual.getVertice());
				actual = actual.getLiga();
			}
			System.out.println();
		}
	}
}
