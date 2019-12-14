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
	
	public void agregar(int i, int j, int distancia){
        matriz[i][j] = distancia;
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
	
	public void dijkstra(int v) {
		int cost[][] = new int[n][n];
		int distance[] = new int[n];
		int pred[]= new int[n];
		int visited[] = new int[n];
		int count, mindistance, nextnode = 0, i, j;
		
		   for(i=0;i<n;i++) {
		      for(j=0;j<n;j++) {
			   if(matriz[i][j]==0){
			      cost[i][j] = Integer.MAX_VALUE;
			   }else {
			      cost[i][j] = matriz[i][j];
			   }
		      }
		   }
			   
		   for(i=0; i<n; i++) {
		      distance[i] = cost[v][i];
		      pred[i] = v;
		      visited[i] = 0;
		   }
		   
		   distance[v]=0;
		   visited[v]=1;
		   count=1;
		   
		   while(count<n-1) {
		      mindistance= Integer.MAX_VALUE;
		      
		      for(i=0; i<n; i++) {
		         if(distance[i] < mindistance && visited[i] == 0) {
			         mindistance = distance[i];
			         nextnode = i;
		         }
		      }
		      
		      visited[nextnode]=1;
		      
		      for(i=0;i<n;i++) {
		         if(visited[i] == 0) {
					  if(mindistance+cost[nextnode][i]<distance[i]) {
					     distance[i]=mindistance+cost[nextnode][i];
					     pred[i]=nextnode;
					  }
		         }
			      count++;
		      }
		   }
		   
		   for(i=0; i<n; i++)
		   if(i != v) {
			   System.out.println("Distancia del nodo " + i + " = " + distance[i] + " desde " + i);
			   j = 1;
			   do {
		         j=pred[j];
		         System.out.println(" <- " + j);
			   }while(j!=v);
		   }
	}
}
