package com.polinomio.vector.F2;

import javax.swing.JOptionPane;

public class PolvF2 {

    private int n;
    private float vec[];

    public PolvF2(int canterm) {
        this.n = (int) canterm * 2 + 1;
        this.vec = new float[n];
        this.vec[0] = canterm;
    }
    
    public PolvF2 copia() {
    	PolvF2 copia = new PolvF2((int)vec[0]);
        copia.vec = this.vec;
        copia.n = this.n;
        return copia;
    }
    
    public float getDato(int posicion){
        return vec[posicion];
    }
    
    public void setDato(int posicion, float dato){
        vec[posicion] = dato;
    }
    
    public void eliminar(){
        vec = new float[0];
    }
    
    public void mostrar(){
        String salida = "<html>";
        float cantDatosUtiles = vec[0] * 2 + 1;
        
        for (int i = 1; i < cantDatosUtiles; i+=2) {
            int exp = (int)vec[i];
            int coef = (int) vec[i+1];
            if(coef > 0 && i > 2){
                salida = salida + "+";
            }
            
            if(coef != 0) {
            	salida = salida + coef + "x<sup>" + exp + "</sup>";
            }
            
        }
        salida = salida + "</html>";
        JOptionPane.showMessageDialog(null, salida);
    }
    
    public void insertarTerm(float coef, int exp){
    	int k = 1;
    	int dimension = (int) vec[0] * 2 + 1;
    	
    	if(exp < 0) {
            System.out.println("El exponente no es valido...");
    	}else {
            while (k < dimension && vec[k] > exp) {
                k+=2;
            }

            if((k < dimension) && (getDato(k) == exp)){
                if(vec[k+1] + coef != 0){
                        vec[k+1] += coef;
                }else{
                    for (int j = k+2; j < dimension; j++) {
                        vec[j-2] = vec[j];
                    }
                    vec[0]--;
                }
            }else {
            	if(((int) vec[0] * 2 + 1) == this.n){
            		this.redimensionar();
            	}
                for (int m = (int)vec[0]*2 + 1; m >= k; m--) {
                    vec[m+2] = vec[m];
                }
                vec[k] = exp;
                vec[k+1] = coef;
                vec[0] += 1;
            }
    	}
    }
    
    public void almacenarTerm(float coef, int exp){
        int k = 1;
        int dimension = (int) vec[0] * 2;
        
        while ((k <= dimension) && (vec[k] > exp) && (vec[k+1] != 0)) {            
            k+=2;
        }
        
        if((k <= dimension) && (vec[k] == exp) && (vec[k+1] != 0)){
            JOptionPane.showMessageDialog(null, "Ya hay un termino con ese exponente...");
        }else{
            vec[k] = exp;
            vec[k+1] = coef;
        }
    }
    
    public void redimensionar(){
        int dimension = (int) this.vec[0] * 2 + 1;
        float aux[] = new float[n+=2];

        for (int i = 1;i < dimension; i++) {
            aux[i] = this.vec[i];
        }
        vec = aux;
    }
    
    public float evaluar(float x){
        int elevarVariable, resultadoDeTermino, resultadoTotal = 0;
        
        for (int i = 1; i < n; i+=2) {
            elevarVariable = (int) Math.pow(x,  vec[i]);
            resultadoDeTermino = (int) vec[i+1] * elevarVariable;
            resultadoTotal += resultadoDeTermino;
        }
        return resultadoTotal;
    }
    
    public PolvF2 sumar(PolvF2 B){
        int k=1, j=1, expA, expB, gm, sumaCoeficientes;
        
        int cantTermA = (int) vec[0];
        int cantTermB = (int) B.vec[0];
                
        if(cantTermA > cantTermB){
            gm = (int) vec[0];
        }else{
            gm = (int) B.vec[0];
        }
        
        PolvF2 R = new PolvF2(gm);
        
        int dimensionA = cantTermA * 2;
        int dimensionB = cantTermB * 2;
        
        while (k < dimensionA && j < dimensionB) {
            
            expA = (int) vec[k];
            expB = (int) B.vec[j];
            
            if(expA == expB){
               sumaCoeficientes =  (int) (vec[k+1] + B.vec[j+1]);
               R.insertarTerm(sumaCoeficientes, expA);
               k+=2;
               j+=2;
            }else{
                if(expA > expB){
                    R.insertarTerm(vec[k+1], expA);
                    k+=2;
                }else{
                    R.insertarTerm(B.vec[j+1], expB);
                    j+=2;
                }
            }
        }
        return R;
    }
    
    public PolvF2 dividir(PolvF2 B) {
        int exp, coef, expA, coefA;
        PolvF2 R = null;
        
        if(vec[1] >= B.vec[1]) {
            PolvF2 copia = this.copia();
            R = new PolvF2((int) this.getDato(0));
            
            while (copia.getDato(1) >= B.getDato(1)) {
            	exp = (int)(copia.getDato(1) - B.getDato(1));
                coef = (int)(copia.getDato(2) / B.getDato(2));
                R.insertarTerm(coef, exp);
                
                int cantDatosUtiles = (int)(B.getDato(0) * 2 + 1);
                for (int  k = 1; k < cantDatosUtiles; k+=2) {
                	expA = (int)(exp + B.getDato(k));
                    coefA = (int)(coef * B.getDato(k+1));
                    
                    copia.setDato(k, expA);
                    copia.setDato(k+1, copia.getDato(k+1) - coefA);
                }
                
                int dimension = (int) copia.getDato(0) * 2 + 1;
                for (int i = 1; i < dimension; i+=2) {
            		copia.setDato(i, copia.getDato(i+2));
            		copia.setDato(i+1, copia.getDato(i+3));
				}
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
