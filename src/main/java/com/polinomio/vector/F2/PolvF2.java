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
    
    public void mostrar(){
        String salida = "<html>";
        float cantDatosUtiles = vec[0] * 2 + 1;
        
        for (int i = 1; i < cantDatosUtiles; i+=2) {
            int exp = (int)vec[i];
            int coef = (int) vec[i+1];
            if(coef > 0 && i > 2){
                salida = salida + "+";
            }
            salida = salida + coef + "x<sup>" + exp + "</sup>";
        }
        salida = salida + "</html>";
        JOptionPane.showMessageDialog(null, salida);
    }
    
    public void insertarTerm(float coef, int exp){
        int k=1,j;
        while ((k < vec[0] * 2+1) && (vec[k] > exp) && (vec[k+1] != 0)) {            
            k+=2;
        }
        
        if((k < vec[0] * 2+1) && (vec[k] == exp) && (vec[k+1] != 0)){
            if(vec[k+1] + coef != 0){
                vec[k+1] += coef;
            }else{
                for (j = k; vec[0] * 2-1 < 10; j+=2) {
                    vec[j] = vec[j+2];
                    vec[j+1] = vec[j+3];
                }
                vec[0]--;
            }
        }else{
            if(vec[0] * 2+1 == n){
                this.redimensionar();
            }
            for (j = (int) vec[0]*2; j >= k; j--) {
                vec[j+2] = vec[j];
            }
            vec[k] = exp;
            vec[k+1] = coef;
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
        n+=2;
        float aux[] = new float[n];
        
        int cantDatosUtiles = (int) vec[0] * 2+1;
        for (int i = 1;i < cantDatosUtiles; i++) {
            aux[i] = vec[i];
        }
        //Aqui se libera la memoria
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
    
    /*public PolvF2 sumar(PolvF2 B){
        int k=1, j=1, expA, expB, gm, posR, sumaCoeficientes;
        
        int cantTermA = (int) vec[0];
        int cantTermB = (int) B.vec[0];
                
        if(cantTermA > cantTermB){
            gm = (int) vec[0];
        }else{
            gm = (int) B.vec[0];
        }
        
        PolvF2 R = new PolvF2(gm);
        
        int dimensionA = cantTermA * 2 + 1;
        int dimensionB = cantTermB * 2 + 1;
        
        while (k < dimensionA && j < dimensionB) {
            
            expA = (int) vec[k];
            expB = (int) B.vec[j];
            
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
    }*/
    
    public void ingresarTerminos(int cantidadTerm){
        float coef;
        int exp;
        
        for (int i = 0; i < cantidadTerm; i++) {
            exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
            coef = Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
            this.almacenarTerm(coef, exp);
        }
    }
}
