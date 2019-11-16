package com.arboles.binarios.busqueda;

public class Nodo {
    private Persona persona;
    private Nodo LD;
    private Nodo LI;

    public Nodo(Persona per){
        this.persona = per;
        this.LD = null;
        this.LI = null;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Nodo getLD() {
        return LD;
    }

    public void setLD(Nodo LD) {
        this.LD = LD;
    }

    public Nodo getLI() {
        return LI;
    }

    public void setLI(Nodo LI) {
        this.LI = LI;
    }
}
