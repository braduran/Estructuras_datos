package com.polinomio.lista;

import javax.swing.JOptionPane;

public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }
    
    public void insertarTerm(float coef, int exp){
        Nodo nodo = new Nodo(coef, exp);
        Nodo anterior = null;
        
        if(cabeza == null) {
        	nodo.setLiga(cabeza);
        	cabeza = nodo;
        }else if(cabeza.getLiga() == null){        	
       		cabeza.setLiga(nodo);
    	}else {
    		
        	if(cabeza.getExp() == exp) {
        		cabeza.setCoef(cabeza.getCoef() + coef);
        	}else if(exp > cabeza.getExp()) {
        		nodo.setLiga(cabeza);
        		cabeza = nodo;
        	}else if(exp < cabeza.getExp()){
        		Nodo puntero = cabeza;
        		puntero = puntero.getLiga();
        		while (puntero != null && exp < puntero.getExp()) {
        			anterior = puntero;
        			puntero = puntero.getLiga();
				}
        		nodo.setLiga(puntero);
        		anterior.setLiga(nodo);
	        }
    	}
    }
    
    public void mostrar(){
        String salida = "<html>";
        Nodo q = cabeza;
        
        if(cabeza == null){
           JOptionPane.showMessageDialog(null, "La lista esta vacia...");
        }else{
            while(q != null){
                if(q.getCoef() > 0 && q != cabeza){
                    salida += "+";
                }else{
                    salida += q.getCoef() + "<sup>" + q.getExp() + "</sup>";
                }
                q = q.getLiga();
            }
        }
        salida += "</html>";
        JOptionPane.showMessageDialog(null, salida);
    }
    
    public void ingresarTerminos(int cantidadTerm){
        float coef;
        int exp;
        
        for (int i = 0; i < cantidadTerm; i++) {
            exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
            coef = Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
            this.insertarTerm(coef, exp);
        }
    }
}
