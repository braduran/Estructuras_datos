/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polinomio.vector.F2;

import javax.swing.JOptionPane;

/**
 *
 * @author sala311
 */
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
        
        for (int i = 1; i < cantDatosUtiles; i++) {
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
            if(n == n){
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
        int k=1,j;
        int cantDatosUtiles = (int) vec[0] * 2+1;
        while (k < cantDatosUtiles && vec[k] > exp && vec[k+1] != 0) {            
            k+=2;
        }
        
        if((k < cantDatosUtiles) && (vec[k] == exp) && (vec[k+1] != 0)){
            JOptionPane.showMessageDialog(null, "Ya hay un termino con ese exponente...");
        }else{
            for (j = (int) vec[0]*2; j >= k; j--) {
                vec[j] = vec[j-2];
            }
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
    
    public void ingresarTerminos(int cantidadTerm){
        float coef;
        int exp;
        
        for (int i = 0; i < 10; i++) {
            exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
            coef = Float.parseFloat(JOptionPane.showInputDialog("Ingrese coeficiente"));
            this.almacenarTerm(coef, exp);
        }
    }
}
