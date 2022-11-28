/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Pilas.Excepciones;

/**
 *
 * @author Admin
 */
public class PilaNullException extends Exception{
    public PilaNullException(String msg) {
        super(msg);
    }
    public PilaNullException() {
        super("Pila Vacia");
    }
    
}
