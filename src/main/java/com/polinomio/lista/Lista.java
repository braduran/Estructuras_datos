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
                while ((puntero != null) && (exp < puntero.getExp())) {
                    anterior = puntero;
                    puntero = puntero.getLiga();
                }
                if(puntero != null && exp == puntero.getExp()){
                    puntero.setCoef(coef + puntero.getCoef());
                }else{
                    nodo.setLiga(puntero);
                    anterior.setLiga(nodo);
                }
                
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
                    salida += "+" + q.getCoef() + "x" + "<sup>" + q.getExp() + "</sup>";
                }else{
                    salida += q.getCoef() + "x" + "<sup>" + q.getExp() + "</sup>";
                }
                q = q.getLiga();
            }
        }
        salida += "</html>";
        JOptionPane.showMessageDialog(null, salida);
    }
    
    public float evaluar(int x) {
    	float elevar, resultadoTotal = 0;
    	Nodo puntero = cabeza;
    	
    	while (puntero != null) {
    		elevar = (float) Math.pow(x, puntero.getExp());
    		resultadoTotal += elevar * puntero.getCoef();
    		puntero = puntero.getLiga();
		}
    	return resultadoTotal;
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
