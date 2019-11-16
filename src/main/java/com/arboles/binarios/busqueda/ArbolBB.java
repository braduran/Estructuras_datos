package com.arboles.binarios.busqueda;

public class ArbolBB {
    private Nodo raiz;
    
    public ArbolBB(){
        this.raiz = null;
    }
    
    public void recPreorden(Nodo R, String prefijo){
        if(R != null){
            System.out.println(prefijo + R.getPersona().toString());
            recPreorden(R.getLI(), prefijo + " ");
            recPreorden(R.getLD(), prefijo + " ");
        }
    }
    
    public void recInorden(Nodo R, String prefijo){
        if(R != null){
            recInorden(R.getLI(), prefijo + " ");
            System.out.println(prefijo + R.getPersona().toString());
            recInorden(R.getLD(), prefijo + " ");
        }
    }
    
    public void recPostorden(Nodo R, String prefijo){
        if(R != null){
            recPostorden(R.getLI(), prefijo + " ");
            recPostorden(R.getLD(), prefijo + " ");
            System.out.println(prefijo + R.getPersona().toString());
        }
    }
    
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public void insertar(Persona per){
        Nodo P = raiz, ant = null;
        boolean sw = false;
        
        while (P != null && !sw) {            
            ant = P;
            if(per.getCedula().compareTo(P.getPersona().getCedula()) > 0){ // a > b
                P = P.getLD();
            }else{
                if(per.getCedula().compareTo(P.getPersona().getCedula()) < 0){ // a < b
                    P = P.getLI();
                }else{
                    sw = true;
                }
            }
        }
        
        if(sw){
            System.out.println("La persona ya existe");
        }else{
            P = new Nodo(per);
            if(raiz == null){
                raiz = P;
            }else{
                if(per.getCedula().compareTo(ant.getPersona().getCedula()) < 0){ // a < b
                    ant.setLI(P);
                }else{
                    ant.setLD(P);
                }
            }
        }
    }
    
    public void buscar(String cedula){
        Nodo p = raiz;
        
        if(p != null){
            if(p.getPersona().getCedula().compareTo(cedula) < 0){ //a < b
                buscar(p.getLI().getPersona().getCedula());
            }else{
                if(p.getPersona().getCedula().compareTo(cedula) > 0){ // a > b
                    buscar(p.getLD().getPersona().getCedula());
                }else{
                    System.out.println(p.getPersona().toString());
                }
            }
        }
    }
}
