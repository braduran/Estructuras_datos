package com.arboles.binarios.busqueda;

import javax.swing.JOptionPane;

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
    
    public void setRaiz(Nodo r){
        this.raiz = r;
    }
    
    public void insertar(Persona per){
        Nodo P = raiz, ant = null;
        boolean sw = false;
        
        while (P != null && !sw) {            
            ant = P;
            if(per.getCedula() > P.getPersona().getCedula()){ // a > b
                P = P.getLD();
            }else{
                if(per.getCedula() < P.getPersona().getCedula()){ // a < b
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
                if(per.getCedula() < ant.getPersona().getCedula()){ // a < b
                    ant.setLI(P);
                }else{
                    ant.setLD(P);
                }
            }
        }
    }
    
    public void buscar(int cedula){
        Nodo p = raiz;
        boolean sw = false;
        String mensaje = null;
        
        while (p != null && !sw) {            
            if(cedula > p.getPersona().getCedula()){
                p = p.getLD();
            }else{
                if(cedula < p.getPersona().getCedula()){
                    p = p.getLI();
                }else{
                    sw = true;
                }
            }
        }
        
        if(sw){
            mensaje = "<html>"
                    +"<table border='1'>"
                        +"<tr>"
                            +"<th>Cedula</th>"
                            +"<th>Nombre</th>"
                            +"<th>Edad</th>"
                        +"<tr>"
                        +"<tr>"
                            +"<td>"+ p.getPersona().getCedula() +"</td>"
                            +"<td>"+ p.getPersona().getNombre() +"</td>"
                            +"<td>"+ p.getPersona().getEdad()+"</td>"
                        +"</tr>"
                    +"</table>"
                    + "</html>";
        }else{
            mensaje = "La persona no existe";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public int altura(Nodo r){
        if(r != null){
            int pi = altura(r.getLD());
            int pd = altura(r.getLI());

            if (pi > pd){ 
               return (pi + 1);
            }else{
               return (pd + 1);
            }
        }else{
            return 0;
        }
    }
    
    public void modificar(Persona per){
        Nodo p = raiz;
        boolean sw = false;
        String mensaje = null;
        
        while (p != null && !sw) {            
            if(per.getCedula() > p.getPersona().getCedula()){
                p = p.getLD();
            }else{
                if(per.getCedula() < p.getPersona().getCedula()){
                    p = p.getLI();
                }else{
                    sw = true;
                }
            }
        }
        
        if(sw){
            p.getPersona().setNombre(per.getNombre());
            p.getPersona().setEdad(per.getEdad());
            mensaje = "Persona modificada con exito :)";
        }else{
            mensaje = "La persona no existe";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void eliminar(int cedula) {
    	Nodo p = raiz, ant = null;
        boolean sw = false;
        String mensaje = null;
        
        while (p != null && !sw) {
            if(cedula > p.getPersona().getCedula()){
            	ant = p;
                p = p.getLD();
            }else{
                if(cedula < p.getPersona().getCedula()){
                	ant = p;
                    p = p.getLI();
                }else{
                    sw = true;
                }
            }
        }
        
        if(sw) {
        	if(p != raiz) {
	        	if(p.getLD() == null && p.getLI() == null) {
	        		ant.setLD(null);
	        		ant.setLI(null);
	        	}else if(p.getLD() != null && p.getLI() == null) {
	        		ant.setLI(p.getLD());
	        	}else if(p.getLD() == null && p.getLI() != null) {
	        		ant.setLI(p.getLI());
	        	}else if(p.getLD() != null && p.getLI() != null) {
	        		if(ant.getLD() == p) {
		        		ant.setLD(p.getLD());
		        		ant.getLD().setLI(p.getLI());
	        		}else if(ant.getLI() == p) {
	        			ant.setLI(p.getLD());
	        			ant.getLI().setLI(p.getLI());
	        		}
	        	}
	        	mensaje = "Persona con cedula " + p.getPersona().getCedula() + " eliminada exitosamente :)";
        	}else {
        		if(p.getLD() != null && p.getLD().getLD() != null && p.getLD().getLI() != null) {
        			Nodo ld = p.getLD();
            		Nodo li = p.getLI();
            		Nodo ldd = p.getLD().getLD();
            		Nodo ldi = p.getLD().getLI();
            		
            		ldd.setLI(ldi);
            		ld.setLD(ldd);
            		ld.setLI(li);
            		this.setRaiz(ld);
            		mensaje = "Nueva raiz " + this.getRaiz().getPersona().getCedula() + " :)";
        		}
        	}
        	
        }else {
        	mensaje = "La persona no existe";
        }
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
 