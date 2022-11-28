/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.Listas.ListaEnlazada;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vivi
 */
public class ModeloTabla extends AbstractTableModel {

    private ListaEnlazada<Persona> personas;

    public ListaEnlazada<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ListaEnlazada<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        // System.out.println("Size" + personas.getUltimaPosicion());
        return personas.getUltimaPosicion();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return "ID";
            case 1:
                return "Nombres";
            case 2:
                return "Genero";
            case 3:
                return "Edad";
            case 4:
                return "Categoría";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona persona = null;

        try {
            persona = personas.obtener(i);
        } catch (Exception ex) {
            System.out.println("Error getValueAt, Modelo tabla" + ex);
        }

        switch (i1) {
            case 0:
                return (persona != null) ? persona.getId() : (i + 1);
            case 1:
                return (persona != null) ? persona.getNombres() : "NO DEFINIDO";
            case 2:
                return (persona != null) ? persona.getGenero() : "NO DEFINIDO";
            case 3:
                return (persona != null) ? persona.getEdad() : "NO DEFINIDO";
            case 4:
                return (persona != null && persona.getCategoria() != null)
                        ? persona.getCategoria().getNombre()
                        : "NO HAY CATEGORÍA";
            default:
                return null;
        }
    }

}
