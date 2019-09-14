package com.polinomio.vector.F1;

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
    
    public int getPosicion(int i){
        return (int) vec[0] + 1 - i;
    }
    
    public int getGrado() {
    	return (int) vec[0];
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
               pos = this.getPosicion(exp);
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
            expA = this.getPosicion(k);
            expB = B.getPosicion(j);
            
            if(expA == expB){
               posR = R.getPosicion(expA);
               sumaCoeficientes = (int) (this.getDato(k) + B.getDato(j));
               R.setDato(posR, sumaCoeficientes);
               k++;
               j++;
            }else{
                if(expA > expB){
                    posR = R.getPosicion(expA);
                    R.setDato(posR, this.getDato(k));
                    k++;
                }else{
                    posR = R.getPosicion(expB);
                    R.setDato(posR, B.getDato(j));
                    j++;
                }
            }
        }
        return R;
    }
    
    public PolvF1 dividir(PolvF1 B) {
    	PolvF1 aux = new PolvF1(0);
    	PolvF1 resultado = new PolvF1(0);
    	
    	float[] arrayVacio = new float[0];
    	
    	while(getGrado() >= B.getGrado()) {
    		int coef1 = (int) ((int) getDato(0) / B.getDato(0));
    		int exp1 = getPosicion(1) - B.getPosicion(1);
    		
    		aux.eliminar(aux.vec);
    		for (int i = 1; i < B.getDimension(); i++) {
				int coef2 = coef1 * (int) B.getDato(i);
				if(coef2 != 0) {
					int exp2 = exp1 + (int) B.getPosicion(i);
					aux.insertarTerm(coef2, exp2);
				}
			}
    		
    		resultado.eliminar(arrayVacio);
    		for (int j = 1; j < getDimension(); j++) {    							
				int expOriginal = (int) getPosicion(j);
				int expResultado = (int) aux.getPosicion(j);
				
				int coefOriginal = (int) getDato(j);
				int coefResultado = (int) aux.getDato(j);
				
				if(expOriginal == expResultado && coefOriginal != 0) {
					int rsCoef =  coefOriginal - coefResultado;
					resultado.insertarTerm(rsCoef, expOriginal);
				}				
			}
    		resultado.ajustar();
    		this.vec = resultado.vec;
    		this.n = resultado.n;
    	}
    	aux.vec = vec;
    	return aux;
    }
}
