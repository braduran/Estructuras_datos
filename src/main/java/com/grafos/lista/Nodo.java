package com.grafos.lista;

public class Nodo {
	private int vertice;
	private Nodo liga;
	
	public Nodo(int vertice) {
		this.vertice = vertice;
		this.liga = null;
	}

	public int getVertice() {
		return vertice;
	}

	public void setVertice(int vertice) {
		this.vertice = vertice;
	}

	public Nodo getLiga() {
		return liga;
	}

	public void setLiga(Nodo liga) {
		this.liga = liga;
	}
}
