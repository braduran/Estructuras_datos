package com.polinomio.vector.F1;

import com.polinomio.lista.Lista;
import com.polinomio.lista.Nodo;
import com.polinomio.vector.F2.PolvF2;

public class PolvF1 {
    int n;
    float vec[];
   
    public PolvF1(int grado){
        this.n = grado + 2;
        vec = new float[this.n];
        vec[0] = grado;
    }
    
    public float getDato(int posicion){
        return vec[posicion];
    }
    
    public void setDato(int posicion, float dato){
        vec[posicion] = dato;
    }
    
    public void eliminar(float[] vector){
        vector = new float[0];
    }
    
    public int getDimension(){
      return n;  
    }
    
    public int getPOE(int i){
        return (int) vec[0] + 1 - i;
    }
    
    public int getGrado() {
    	return (int) vec[0];
    }
    
    public PolvF1 copia() {
    	PolvF1 copia = new PolvF1((int) vec[0]);
    	copia.vec = vec;
    	return copia;
    }
   
    //Mostrar el polinomio
    public String mostrar(){
        float datosUtiles = vec[0] + 2;
        String salida = "<html>";
       
        for(int i = 1; i < datosUtiles; i++){
            float valor = vec[i];
           
            if(valor != 0){
                int pos = (int) vec[0] + 1 - i;
                if(valor > 0 && i > 1){
                    salida = salida + "+" + valor + "x" + "<sup>" + pos + "</sup>";
                }else{
                    salida = salida + valor + "x" + "<sup>" + pos + "</sup>";
                }
            }
        }
        salida = salida + "</html>";
        return salida;
    }
   
    //Almacenar un termino del polinomio
    @Deprecated
    public void almacenarTermino(float coeficiente, int exponente){
        int pos;
        if(exponente >= 0 && exponente <= vec[0]){
            pos = (int) vec[0] + 1 - exponente;
            float posicion = vec[pos];
            if(posicion == 0){
                vec[pos] = coeficiente;
            }else{
                System.out.println("Ya hay termino con ese exponente...");
            }
        }else{
            System.out.println("Exponente no permitido...");
        }
    }
   
    //Evaluar polinomio con una variable
    public float evaluar(float x){
        float elevarVariable = 0, exponente = 0, resultadoDeTermino = 0, resultadoTotal = 0;
        for (int i = 1; i < vec.length; i++) {
            if(vec[i] != 0){
                exponente = vec[0] + 1 - i;
                elevarVariable = (float) Math.pow(x, exponente);
                resultadoDeTermino = vec[i] * elevarVariable;
                System.out.println("Termino evaluado: " + vec[i] + "("+x+")" + "X^" + exponente + " = " + resultadoDeTermino);
                resultadoTotal = resultadoTotal + resultadoDeTermino;
            }
        }
        return resultadoTotal;
    }
    
    //Redimensionar pone un vector mas grande
    public void redimensionar(int exp){
        int k, pos = exp + 1;
        
        float aux[] = new float[exp + 2];
        
        int primeraPosicion = (int) vec[0] + 1;
        for (k = primeraPosicion; k  > 0; k--) {
            aux[pos] = vec[k];
            pos--;
        }
        eliminar(vec);
        vec = aux;
    }
    
    //Ajustar pone el vector mas pequeño
    public void ajustar(){
        int k, j=1, cont = 0;
        int dimension = (int) vec[0] + 2;
        
        while (j < dimension && vec[j] == 0) {            
            cont++;
            j++;
        }
        
        for (k = j; k < dimension; k++) {
            vec[k-cont] = vec[k];
        }
        
        vec[0] = vec[0] - cont;
    }
    
    //Insertar termino
    public void insertarTerm(float coeficiente, int exp){
        int pos;
        
        if(exp < 0){
            System.out.println("El exponente no es valido...");
        }else{
            if(exp <= getDato(0)){
               pos = this.getPOE(exp);
               vec[pos] = (int) (this.getDato(pos) + coeficiente);
               this.ajustar();
            }else{
                this.redimensionar(exp);
                this.setDato(0, exp);
                this.setDato(1, coeficiente);
            }
        }
    }
    
    public PolvF1 sumar(PolvF1 B){
        int k=1, j=1, expA, expB, gm, posR, sumaCoeficientes;
        
        if(this.getDato(0) > B.getDato(0)){
            gm = (int) this.getDato(0);
        }else{
            gm = (int) B.getDato(0);
        }
        
        PolvF1 R = new PolvF1(gm);
        int dimensionA = this.getDimension();
        int dimensionB = B.getDimension();
        
        while (k < dimensionA && j < dimensionB) {            
            expA = this.getPOE(k);
            expB = B.getPOE(j);
            
            if(expA == expB){
               posR = R.getPOE(expA);
               sumaCoeficientes = (int) (this.getDato(k) + B.getDato(j));
               R.setDato(posR, sumaCoeficientes);
               k++;
               j++;
            }else{
                if(expA > expB){
                    posR = R.getPOE(expA);
                    R.setDato(posR, this.getDato(k));
                    k++;
                }else{
                    posR = R.getPOE(expB);
                    R.setDato(posR, B.getDato(j));
                    j++;
                }
            }
        }
        return R;
    }
    
    public PolvF1 dividir(PolvF1 B) {
    	int expt, posR, expA, posA;
    	float coet, coeA;
    	PolvF1 R = null;
    	
    	if (vec[0] >= B.getDato(0)) {
            PolvF1 copia = this.copia();

            int grado = (int) vec[0] - (int) B.getDato(0);
            R = new PolvF1(grado);

            while (copia.getDato(0) >= B.getDato(0)) {
                expt = (int) copia.getDato(0) - (int) B.getDato(0);
                coet = (int) copia.getDato(1) / (int) B.getDato(1);
                posR = (int) R.getDato(0) + 1 - expt;
                R.setDato(posR, coet);

                for (int k = 1; k < (B.getDato(0) + 2); k++) {
                    expA = expt + (int) B.getDato(0) + 1 - k;
                    coeA = coet * (int) B.getDato(k);
                    posA = (int) copia.getDato(0) + 1 - expA;
                    copia.setDato(posA, copia.getDato(posA) - coeA);
                }
                copia.ajustar();
            }
    	}else {
            System.out.println("No se puede dividir...");
    	}
    	return R;
    }
    
    public PolvF2 sumar(Lista B) {
    	//Sumar F1 con Lista y da F2

    	int k=1, expA, expB, gm, sumaCoeficientes;
    	Nodo cab = B.getCabeza();
    	
        if(this.getDato(0) > cab.getExp()){
            gm = (int) this.getDato(0);
        }else{
            gm = (int) cab.getExp();
        }
        
        PolvF2 R = new PolvF2(gm);
        int dimensionA = this.getDimension();
        
        while (k < dimensionA &&  cab != null) {            
            expA = this.getPOE(k);
            expB = cab.getExp();
            
            if(expA == expB){
               sumaCoeficientes = (int) (this.getDato(k) + cab.getCoef());
               R.insertarTerm(sumaCoeficientes, expA);
               k++;
               cab = cab.getLiga();
            }else{
                if(expA > expB){
                	R.insertarTerm(this.getDato(k), expA);
                    k++;
                }else{
                	R.insertarTerm(cab.getCoef(), expB);
                    cab = cab.getLiga();
                }
            }
        }
        return R;
    }
    
    public Lista dividir(PolvF2 B) {
    	//Dividir F1 con F2 y da Lista
    	
    	int exp, expA, posA;
    	float coef, coefA;
    	Lista R = new Lista();
    	
    	if (getDato(0) >= B.getDato(0)) {
            PolvF1 copia = this.copia();

            while (copia.getDato(0) >= B.getDato(1)) {
                exp = (int) copia.getDato(0) - (int) B.getDato(1);
                coef = (int) copia.getDato(1) / (int) B.getDato(2);
                R.insertarTerm(coef, exp);
                
                int cantDatosUtiles = (int)(B.getDato(0) * 2 + 1);
                for (int  k = 1; k < cantDatosUtiles; k+=2) {
                	expA = (int)(exp + B.getDato(k));
                    coefA = (int)(coef * B.getDato(k+1));
                    
                    posA = (int) copia.getDato(0) + 1 - expA;
                    copia.setDato(posA, copia.getDato(posA) - coefA);
                }
                
                copia.ajustar();
            }
    	}else {
            System.out.println("No se puede dividir el polinomio...");
    	}
    	return R;
    }
    
    public boolean comparar(PolvF2 B) {
    	//Comparar F1 con F2
    	return false;
    }
}