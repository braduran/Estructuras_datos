package com.matrices.lista.tripletas;

import javax.swing.JOptionPane;

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
    
    public void mostar(){
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
        JOptionPane.showMessageDialog(null, "Datos de 1 matriz: \n" + salida);
    }
    
    public void almacenarTrip(int f, int c, float d){
        int k = 1, j;
        int tripUtiles = (int) listaTri[0][2] + 1;
        while ((k < tripUtiles) && (listaTri[k][0] < f) && (listaTri[k][2] != 0)) {            
            k++;
        }
        
        while ((k < tripUtiles) && (listaTri[k][0] <= f) 
                && (listaTri[k][1] < 0) && (listaTri[0][2] != 0)) {            
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