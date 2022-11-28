/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Colas.Excepciones;

/**
 *
 * @author Admin
 */
public class ColaNullException extends Exception{
        public ColaNullException(String msg) {
        super(msg);
    }
    public ColaNullException() {
        super("Pila Vacia");
    }
    
}
