package com.polinomio.lista;

import javax.swing.JOptionPane;

public class Lista {
    private Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }
    
    public void insertarTerm(float coef, int exp){
        Nodo q = cabeza, anterior = null, nuevo = null;
        
        while (q != null && q.getExp() > exp) {            
            anterior = q;
            q = q.getLiga();
        }
        
        if(q != null && q.getExp() == exp){
            q.setCoef(q.getCoef() + coef);
            
            if(q.getCoef() == 0){
                anterior = q.getLiga();
                q = null;
            }
            
        }else{
            if(q == cabeza){
                anterior = new Nodo(coef, exp);
                anterior.setLiga(q);
            }else if(q.getExp() < exp){
                nuevo = new Nodo(coef, exp);
                q.setLiga(nuevo);
            }else{
                nuevo = new Nodo(coef, exp);
                q.setLiga(nuevo);
                nuevo.setLiga(q.getLiga());
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
}
