/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        Pila tope = new Pila();
        int dato;
        int op = -1;
        boolean sw = true;
        while(sw == true){
            try{
                op = new Integer(
                    JOptionPane.showInputDialog(""
                            + "MENU DE OPCIONES\n\n"
                            + "1. Apilar\n"
                            + "2. Desapilar\n"
                            + "3. ver Tope\n"
                            + "4. Buscar dato\n"
                            + "5. Listar\n"
                            + "6. Vaciar pila\n"
                            + "7. Ver tamaño pila\n"
                            + "8. Salir\n"));
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error en la informacion suministrada, debe digitar un numero");
            }
            switch(op){
                case 1:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a apilar"));
                    Nodo nodo = new Nodo(dato);
                    tope.apilar(nodo);
                    break;
                }
                case 2:{
                    Nodo nodo = tope.desApilar();
                    if(nodo != null){
                        JOptionPane.showMessageDialog(null, "Nodo desapillado: " + nodo.getDato());
                    }else{
                        JOptionPane.showMessageDialog(null, "Pila vacia");
                    }
                    break;
                }
                case 3:{
                    Nodo nodo = tope.verTope();
                    if(nodo != null){
                        JOptionPane.showMessageDialog(null, "Tope pila: " + nodo.getDato());
                    }else{
                        JOptionPane.showMessageDialog(null, "Pila vacia");
                    }
                    break;
                }
                case 4:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    boolean buscar = tope.buscarNodo(dato);
                    if(buscar){
                        JOptionPane.showMessageDialog(null, "El dato existe en la pila." );
                    }else{
                        JOptionPane.showMessageDialog(null, "Dato no encontrado");
                    }
                    break;
                }
                case 5:{
                    tope.listar();
                    break;
                }
                case 6:{
                    tope.vaciarPila();
                    JOptionPane.showMessageDialog(null, "La pila fue vaceada");
                    break;
                }
                case 7:{
                    dato = tope.tamanioPila();
                    JOptionPane.showMessageDialog(null, "La pila tiene un tamaño de: " + dato);
                    break;
                }
                case 8:{
                    int salir = JOptionPane.showConfirmDialog(null, "Realmente desea salir?");
                    if(salir == 0){
                        sw = false;
                    }
                    break;
                }
                default:{
                    
                    break;
                }
            }
        }
    }
}
