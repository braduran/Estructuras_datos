package com.polinomio.lista;

import javax.swing.JOptionPane;

public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }
    
    public Nodo getCabeza() {
    	return this.cabeza;
    }
    
    public void setCabeza(Nodo cab) {
    	this.cabeza = cab;
    }
    
    public Lista getCopia() {
    	return this;
    }
    
    public void insertarTerm(float coef, int exp){
        Nodo cab = cabeza, anterior = null, nodo = null;
        int suma;
        
        while (cab != null && cab.getExp() > exp) {
			anterior = cab;
			cab = cab.getLiga();
		}
        
        if((cab != null && cab.getExp() < exp) || cab == null) {
        	nodo = new Nodo(coef, exp);
        	
        	if(cabeza == cab) {
        		nodo.setLiga(cab);
        		cabeza = nodo;
        	}else {
        		nodo.setLiga(cab);
        		anterior.setLiga(nodo);
        	}
        }else { // En este caso cab != null y cab.getExp() == exp
        	suma = (int)(cab.getCoef() + coef);
        	if(suma != 0) {
        		cab.setCoef(suma);
        	}else { //Se debe borrar el nodo cab
        		if(cab == cabeza) {
        			cabeza = cab.getLiga();
        		}else {
        			anterior.setLiga(cab.getLiga());
        		}
        		cab = null;
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
    
    public Lista sumar(Lista B) {
    	Nodo cabA = cabeza, cabB = B.getCabeza();
    	int expA, expB, coefA, coefB;
    	Lista C = new Lista();
    	
    	while(cabA != null && cabB != null) {
    		expA = cabA.getExp();
    		coefA = (int) cabA.getCoef();
    		expB = cabB.getExp();
    		coefB = (int) cabB.getCoef();
    		
    		if(expA == expB) {
    			C.insertarTerm(coefA + coefB, expA);
    			cabA = cabA.getLiga();
    			cabB = cabB.getLiga();
    		}else {
    			if(expA > expB) {
    				C.insertarTerm(coefA, expA);
    				cabA = cabA.getLiga();
    			}else {
    				C.insertarTerm(coefB, expB);
    				cabB = cabB.getLiga();
    			}
    		}
    	}
    	
    	while (cabA != null) {
			C.insertarTerm(cabA.getCoef(), cabA.getExp());
			cabA = cabA.getLiga();
		}
    	
    	while (cabB != null) {
			C.insertarTerm(cabB.getCoef(), cabB.getExp());
			cabB = cabB.getLiga();
		}
    	
    	return C;
    }
    
    public Lista dividir(Lista B) {
    	int exp, coef, expA, coefA;
    	Nodo cabA = cabeza, cabB = B.getCabeza(), aux;
    	Lista R = new Lista(), copia = null;
    	
    	if(cabA.getExp() >= cabB.getExp()) {
    		copia = this.getCopia();
    		
    		while (copia.getCabeza().getExp() >= cabB.getExp()) {
    			coef = (int)(copia.getCabeza().getCoef() / cabB.getCoef());
				exp = copia.getCabeza().getExp() - cabB.getExp();
				R.insertarTerm(coef, exp);
				
				aux = cabB;
				while (cabB != null && copia.getCabeza() != null) {
					coefA = (int)(coef * cabB.getCoef());
					expA = exp + cabB.getExp();
					copia.insertarTerm(-coefA, expA);
					cabB = cabB.getLiga();
				}
				cabB = aux;
			}
    	}else {
    		System.out.println("No se puede dividir los polinomios...");
    	}
    	return R;
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
