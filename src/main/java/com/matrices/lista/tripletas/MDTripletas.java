package com.matrices.lista.tripletas;

import javax.swing.JOptionPane;

import com.matrices.lista.ListasF1.MDListaF1;
import com.matrices.lista.ListasF2.MDListaF2;
import com.matrices.lista.ListasF2.NodoF2;

public class MDTripletas {

   private int NFilas, NCol, Nt;
   private float listaTri[][];

    public MDTripletas(int nf, int nc, int cd) {
        this.NFilas = nf;
        this.NCol = nc;
        this.Nt = cd + 1;
        
        listaTri = new float[Nt][3];
        listaTri[0][0] = NFilas;
        listaTri[0][1] = NCol;
        listaTri[0][2] = cd;
    }
    
    public void setDato(int f, int c, float d){
        //this.listaTri[f][c] = d;
        this.listaTri[f][0] = f;
        this.listaTri[c][1] = c;
        this.listaTri[(int)d][2] = d;
    }
    
    public void mostrar(){
        String salida = "<html><table border='1'>";
        int t = 1;
        
        for (int k = 0; k < NFilas; k++) {
            salida += "<tr>";
            for (int j = 0; j < NCol; j++) {
                if(t <= listaTri[0][2] && listaTri[t][0] == k && listaTri[t][1] == j){
                    salida += "<td color='blue'>" + listaTri[t][2] + "</td>";
                    t++;
                }else{
                    salida += "<td>0.0</td>";
                }
            }
            salida += "</tr>";
        }
        salida += "</table></html>";
        JOptionPane.showMessageDialog(null, salida, "Datos de la matriz", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void almacenarTrip(int f, int c, float d){
        int k = 1, j;
        int tripUtiles = (int) listaTri[0][2] + 1;
        while ((k < tripUtiles) && (listaTri[k][0] < f) && (listaTri[k][2] != 0)) {            
            k++;
        }
        
        while ((k < tripUtiles) && (listaTri[k][0] == f) && (listaTri[k][1] < c) 
        		&& (listaTri[k][2] != 0)) {            
            k++;
        }
        
        if((k <= tripUtiles) && (listaTri[k][0] == f) && (listaTri[k][1] == c) && (listaTri[k][2] + d) != 0){
            JOptionPane.showMessageDialog(null, "Ya existe el dato");
        }else{
            for (j = (int) listaTri[0][2]; j > k; j--) {
                listaTri[j][0] = listaTri[j-1][0];
                listaTri[j][1] = listaTri[j-1][1];
                listaTri[j][2] = listaTri[j-1][2];
            }
            listaTri[k][0] = f;
            listaTri[k][1] = c;
            listaTri[k][2] = d;
        }
    }
    
    public void insertarTrip(int f, int c, float d){
        int k = 1;
        int tripUtiles = (int) listaTri[0][2] + 1;
        
        while ((k < tripUtiles) && (listaTri[k][0] < f) && (listaTri[k][2] != 0)) {            
            k++;
        }
        
        while ((k < tripUtiles) && (listaTri[k][0] <= f) 
                && (listaTri[k][1] < 0) && (listaTri[0][2] != 0)) {            
            k++;
        }
        
        if((k <= tripUtiles) && (listaTri[k][0] == f) && (listaTri[k][1] == c)){
            if((listaTri[k][2] + d) != 0){
                listaTri[k][2] = listaTri[k][2] + d;
            }else{
                for (int j = k; j < listaTri[0][2]; j++) {
                    listaTri[j][0] = listaTri[j+1][0];
                    listaTri[j][1] = listaTri[j+1][1];
                    listaTri[j][2] = listaTri[j+1][2];
                }
                listaTri[0][2] = listaTri[0][2] - 1;
            }
        }else{
            if((listaTri[0][2]+1) == Nt){
                redimensionar();
            }
            
            for (int m = (int) listaTri[0][2]+1; m >= k; m--) {
                listaTri[m+1][0] = listaTri[m][0];
                listaTri[m+1][1] = listaTri[m][1];
                listaTri[m+1][2] = listaTri[m][2];
            }
            listaTri[k][0] = f;
            listaTri[k][1] = c;
            listaTri[k][2] = d;
            
            listaTri[0][2] = listaTri[0][2] + 1;
        }
    }
    
    public void redimensionar() {
    	int filas = (int) listaTri[0][2] + 2;
    	float[][] aux = new float [filas][3];
    	for (int k = 0; k < listaTri[0][2]+1; k++) {
			aux[k][0] = listaTri[k][0];
			aux[k][1] = listaTri[k][1];
			aux[k][2] = listaTri[k][2];
		}
    	listaTri = aux;
    }
    
    //Tripletas x F2 = F1
    public MDListaF1 multiplicarConF1(MDListaF2 F2) {
    	int fila=0, columna, dato, l = 1;
    	boolean sw = false;
    	NodoF2 p = F2.getCab().getLigaFila();
        int suma[][] = new int[NFilas][F2.getCab().getColumna()];
    	MDListaF1 matrizResultado = null;
    	
        int columnasTrip = (int) listaTri[0][1];
        int filasF2 = (int) F2.getCab().getFila();

        if(columnasTrip == filasF2) {
            matrizResultado = new MDListaF1(this.NFilas, F2.getCab().getColumna()); 
            
            
            for(int x = 0; x < this.NFilas; x++) { //FilasA
            	if(sw) {
            		p = p.getLigaFila();
            	}
            	sw = false;
            	
            	for(int y = 0; y < F2.getCab().getColumna(); y++) { //ColumnasB
            		if(sw) {
                		l = l - this.NCol;
                	}
            		
            		for (int z = 0; z < this.NCol; z++) {
						
            			fila = (int) listaTri[l][0];
                        columna = (int) listaTri[l][1];
                        dato = (int) listaTri[l][2];
                        
                        if(columna == p.getFila()){
                        	suma[fila][p.getColumna()] += (dato * (int) p.getDato());
                            p = p.getLigaCol();
                        }
            			l++;
					}
            		sw = true;
            	}
            }
            
            for (int i = 0; i < suma.length; i++) { //Filas
				for (int j = 0; j < suma[0].length; j++) { //Columnas
					matrizResultado.insertarDato(i, j, suma[i][j]);
				}
			}
            
            matrizResultado.mostrar();
    	}else {
            JOptionPane.showMessageDialog(null, "El numero de columnas la matriz de tripletas, "
                            + "debe ser el mismo que el numero de filas de la matriz en forma 2");
    	}
    	return null;
    }
    
    public void ingresarDato(){
        int f, c;
        float d;
        
        for (int k = 1; k < Nt; k++) {
            f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));
            
            if(f >= 0 && f < listaTri[0][0] && c >= 0 && c < listaTri[0][1]){
                d = Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
                this.almacenarTrip(f, c, d);
            }else{
                JOptionPane.showMessageDialog(null, "La posicion no es valida");
                k--;
            }
        }
    }
}
