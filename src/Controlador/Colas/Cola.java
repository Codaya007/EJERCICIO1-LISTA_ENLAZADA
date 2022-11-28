/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Colas;

import Controlador.Colas.Excepciones.CimaException;
import Controlador.Colas.Excepciones.ColaNullException;
import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Listas.ListaEnlazada;

/**
 *
 * @author Admin
 */
public class Cola<E> extends ListaEnlazada<E> {

    private Integer cima;

    public Cola(Integer cima) {
        this.cima = cima;
    }

    public Boolean estaLLeno() {
        return cima == getSize();
    }

    public void queue(E dato) throws PosicionException, CimaException {
        if (!estaLLeno()) {
            //insertarPosicion(dato, getSize() - 1);
            insertar(dato);
        } else {
            throw new CimaException();
        }
    }

    public E dequeue() throws PosicionException, ListaNullException, ColaNullException {
        if (!estaVacia()) {
            E dato = eliminarDato(0);
            return dato;
        } else throw new ColaNullException();
        }
    }
