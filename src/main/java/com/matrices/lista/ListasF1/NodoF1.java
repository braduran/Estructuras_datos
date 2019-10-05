package com.matrices.lista.ListasF1;

public class NodoF1 {
    private int fila;
    private int columna;
    private float dato;
    private NodoF1 ligaCol;
    private NodoF1 ligaFila;
    private NodoF1 liga;

    public NodoF1(int fila, int columna, float dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
        this.ligaCol = null;
        this.ligaFila = null;
        this.liga = null;
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
    }

    public NodoF1 getLigaCol() {
        return ligaCol;
    }

    public void setLigaCol(NodoF1 ligaCol) {
        this.ligaCol = ligaCol;
    }

    public NodoF1 getLigaFila() {
        return ligaFila;
    }

    public void setLigaFila(NodoF1 ligaFila) {
        this.ligaFila = ligaFila;
    }

    public NodoF1 getLiga() {
        return liga;
    }

    public void setLiga(NodoF1 liga) {
        this.liga = liga;
    }   
}
