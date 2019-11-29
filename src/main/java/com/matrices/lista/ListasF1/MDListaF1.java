package com.matrices.lista.ListasF1;

import javax.swing.JOptionPane;

public class MDListaF1 {
    
    private NodoF1 cab;
    
    public MDListaF1(int nf, int nc){
        this.cab = crearCabezas(nf, nc);
    }
    
    public NodoF1 getCab(){
    	return cab;
    }
    
    private NodoF1 crearCabezas(int nf, int nc){
        int n,k;
        NodoF1 p, x, ult;
        
        p = new NodoF1(nf, nc, 0);
        p.setLigaCol(p);
        p.setLigaFila(p);
        
        ult = p;
        
        if(nf > nc){
            n = nf;
        }else{
            n = nc;
        }
        
        for (k = 0; k < n; k++) {
            x = new NodoF1(k, k, 0);
            x.setLigaFila(x);
            x.setLigaCol(x);
            ult.setLiga(x);
            ult = x;
        }
        
        ult.setLiga(p);
        
        return p;
    }
    
    public void mostrar(){
        NodoF1 p = cab.getLiga(), q;
        String salida = "<html><table border='1'>";
        int k, j;
        
        for (k = 0; k < cab.getFila(); k++) {
            q = p.getLigaFila();
            salida += "<tr>";
            for (j = 0; j < cab.getColumna(); j++) {
                if(q.getFila() == k && q.getColumna() == j && q.getDato() != 0){
                    salida += "<td color='blue'>" + q.getDato() + "</td>";
                    q = q.getLigaFila();
                }else{
                    salida += "<td>0.0</td>";
                }
            }
            salida += "</tr>";
            p = p.getLiga();
            
        }
        salida += "</table></html>";
        JOptionPane.showMessageDialog(null,  salida, "Datos de la matriz F1 " + cab.getFila() + "x" +  cab.getColumna(), 1);
    }
    
    public void insertarDato(int f, int c, float d){
        NodoF1 p = cab.getLiga(), q, antF, antC, x;
        
        while (p != cab && p.getFila() < f) {            
            p = p .getLiga();
        }
        antF = p;
        q = p.getLigaFila();
        
        while (q != p  && q.getColumna() < c) {
        	antF = q;
            q = q.getLigaFila();
        }
        p = cab.getLiga();
        
        while(p != cab && p.getColumna() < c){
            p = p.getLiga();
        }
        antC = p;
        q = p.getLigaCol();
        
        while(q != p && p.getFila() < f){
        	antC = q;
            q = q.getLigaCol();
        }
        
        if(q != p && q.getFila() == f && q.getColumna() == c){
            float suma = q.getDato()+d;
            
            if(suma != 0){
                q.setDato(suma);
            }else{
                antF.setLigaFila(q.getLigaFila());
                antC.setLigaCol(q.getLigaCol());
                //delete(q) aqui se libera el nodo
            }
        }else{
            x = new NodoF1(f, c, d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaCol(antC.getLigaCol());
            antC.setLigaCol(x);
        }
    }
    
    public void almacenarDato(int f, int c, float d){
        NodoF1 p = cab.getLiga(), q, antF, antC, x;
        
        while (p != cab && p.getFila() < f) {            
            p = p .getLiga();
        }
        antF = p;
        q = p.getLigaFila();
        
        while (q != p  && q.getColumna() < c) {
        	antF = q;
            q = q.getLigaFila();
        }
        p = cab.getLiga();
        
        while(p != cab && p.getColumna() < c){
            p = p.getLiga();
        }
        antC = p;
        q = p.getLigaCol();
        
        while(q != p && p.getFila() < f){
        	antC = q;
            q = q.getLigaCol();
        }
        
        if(q != p && q.getFila() == f && q.getColumna() == c){
            JOptionPane.showMessageDialog(null, "El dato ya existe en las coordenadas indicadas");
        }else{
            x = new NodoF1(f, c, d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaCol(antC.getLigaCol());
            antC.setLigaCol(x);
        }
    }
    
    public void ingresarDatos(int cd){
        int f = 0, c;
        float d;
        
        for(int i = 0; i < cd; i++){
            f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));
            
            if(f >= 0 && f < cab.getFila() && c >= 0 && c < cab.getColumna()){
                d = Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
                this.insertarDato(f, c, d);
            }else{
                JOptionPane.showMessageDialog(null, "La posicion no es valida");
            }
        }
    }
}

