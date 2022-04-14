/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public Nodo getTope() {
        return tope;
    }
    
    public void setTope(Nodo nodo){
        this.tope = nodo;
    }
    
    public boolean isVacia(){
        return this.getTope() == null;
    }
    
    public Nodo desApilar(){
        Nodo aux = this.getTope();
        if(!this.isVacia()){
            this.setTope(this.getTope().getAnt());
            aux.setAnt(null);
        }
        return aux;
    }
    
    public Nodo verTope(){
        if(!this.isVacia()){
            Nodo aux = this.getTope();
            return aux;
        }
        return null;
    }    
    
    public void apilar(Nodo nodo){
        if(this.isVacia()){
            this.setTope(nodo);
        }else{
            nodo.setAnt(this.getTope());
            this.setTope(nodo);
        }
    }
    
    public void listar(){
        if(!this.isVacia()){
            Nodo aux = null;
            Pila pilaAux = new Pila();
            String datos = "datos Pila\n";
            while(!this.isVacia()){
                aux = this.desApilar();
                datos += "|"+aux.getDato()+"|\n";
                pilaAux.apilar(aux);
            }
            while(!pilaAux.isVacia()){
                aux = pilaAux.desApilar();
                this.apilar(aux);
            }
            JOptionPane.showMessageDialog(null, datos);
        }else{
            JOptionPane.showMessageDialog(null, "Pila vacia");
        }
    }
    
    public void vaciarPila(){
        this.setTope(null);
    }
    
    public int tamanioPila(){
        int tam = 0;
        if(!this.isVacia()){
            Nodo aux = null;
            Pila pilaAux = new Pila();
            String datos = "datos Pila\n";
            while(!this.isVacia()){
                tam++;
                aux = this.desApilar();
                pilaAux.apilar(aux);
            }
            while(!pilaAux.isVacia()){
                aux = pilaAux.desApilar();
                this.apilar(aux);
            }
        }
        return tam;
    }
    
    public boolean buscarNodo(int dato){
        Nodo aux = null;
        boolean devolver = false;
        if(!this.isVacia()){
            Pila pilaAux = new Pila();
            while(!this.isVacia()){
                aux = this.desApilar();
                pilaAux.apilar(aux);
                if(aux.getDato()==dato){
                    devolver = true;
                    break;
                }
            }
            while(!pilaAux.isVacia()){
                aux = pilaAux.desApilar();
                this.apilar(aux);
            }
        }
        return devolver;
    }
    
}
