package com.polinomio.lista;

public class Nodo {
    private float coef;
    private int exp;
    private Nodo liga;

    public Nodo(float coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.liga = null;
    }

    public float getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
}
