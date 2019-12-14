package com.grafos.matriz;

public class Matriz {
	private int n;
	private int[][] matriz;
	private int[] visitado;
	
	public Matriz(int n) {
		this.n = n;
		matriz = new int[n][n];
		visitado = new int[n];
	}
	
	public void agregar(int i, int j){
        matriz[i][j] += 1;
    }
	
	public void remover(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }
	
	public void imprimir(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "  " );        
            }
            System.out.println();
        }  
    }
	
	public int gradoVertice(int vertice) {
		int c = 0;
		
		if(vertice <= n) {
			for (int i = 0; i < n; i++) {
				if(matriz[vertice][i] == 1) {
					c++;
				}
			}
		}
		return c;
	}
	
	public void DFS_Madya(int v) {
		visitado[v] = 1;
		System.out.println(v);
		
		for (int i = 0; i < n; i++) {
			if(matriz[v][i] == 1) {
				if(visitado[i] == 0) {
					DFS_Madya(i);
				}
			}
		}
	}
}
