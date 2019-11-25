package com.matrices.lista.ListasF2;

import javax.swing.JOptionPane;

import com.matrices.lista.ListasF1.NodoF1;

public class MDListaF2 {
    
    private NodoF2 cab;
    
    public MDListaF2(int nf, int nc){
        cab = new NodoF2(nf, nc, 0);
        cab.setLigaFila(cab);
        cab.setLigaCol(cab);
    }
    
    public void insertarDato(int f, int c, float d){
        NodoF2 p, q, antF = cab, antC = cab;
        p = cab.getLigaFila();
        
        while (p != cab && p.getFila() < f) {            
            antF = p;
            p = p.getLigaFila();
        }
        
        while (p != cab && p.getFila() == f && p.getColumna() < c) {            
            antF = p;
            p = p.getLigaFila();
        }
        p = cab.getLigaCol();
        
        while (p != cab && p.getColumna() < c) {            
            antC = p;
            p = p.getLigaCol();
        }
        while (p != cab && p.getFila() < f && p.getColumna() == c) {            
            antC = p;
            p = p.getLigaCol();
        }
        
        if(p != cab && p.getFila() == f && p.getColumna() == c){
            if(p.getDato()+d != 0){
                p.setDato(p.getDato() + d);
            }else{
                antF.setLigaFila(p.getLigaFila());
                antC.setLigaCol(p.getLigaCol());
                //delete(p)
                p = null;
            }
        }else{
            NodoF2 x = new NodoF2(f, c, d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaCol(p);
            antC.setLigaCol(x);
        }
    }
    
    public void mostrar(){
    	NodoF2 p = cab.getLigaFila(), q;
        String salida = "<html><table border='1'>";
        
        for (int k = 0; k < cab.getFila(); k++) {
        	salida += "<tr>";
    		for(int j = 0; j < cab.getColumna(); j++) {
    			if(k == p.getFila() && j == p.getColumna()) {
    				salida += "<td color='orange'>" + p.getDato() + "</td>";
    				p = p.getLigaFila();
    			}else {
    				salida += "<td>0.0</td>";
    			}
    		}
        	salida += "</tr>";
        }
        salida += "</table></html>";
        JOptionPane.showMessageDialog(null,  salida, "Datos de la matriz F2 " + cab.getFila() + "x" +  cab.getColumna(), 1);
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

