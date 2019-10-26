package com.matrices.lista.ListasF2;

public class NodoF2 {
    private int fila;
    private int columna;
    private float dato;
    private NodoF2 ligaCol;
    private NodoF2 ligaFila;

    public NodoF2(int fila, int columna, float dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
        this.ligaCol = null;
        this.ligaFila = null;
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

    public NodoF2 getLigaCol() {
        return ligaCol;
    }

    public void setLigaCol(NodoF2 ligaCol) {
        this.ligaCol = ligaCol;
    }

    public NodoF2 getLigaFila() {
        return ligaFila;
    }

    public void setLigaFila(NodoF2 ligaFila) {
        this.ligaFila = ligaFila;
    } 
}
