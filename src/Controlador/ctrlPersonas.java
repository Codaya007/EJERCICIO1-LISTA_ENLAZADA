package Controlador;

import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Listas.ListaEnlazada;
import Modelo.Persona;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vivi
 */
public class ctrlPersonas {

    ListaEnlazada<Persona> listaPersonas = new ListaEnlazada<>();

    public ListaEnlazada<Persona> getListaPersona() {
        listaPersonas.setSize(25);
        return listaPersonas;
    }

    public Boolean setListaPersona(Persona persona) throws PosicionException {
        if (listaPersonas.getSize() == listaPersonas.getUltimaPosicion()) {
            return false;
        }
        this.listaPersonas.insertarPosicion(persona, listaPersonas.getUltimaPosicion());

        return true;
    }

    public int getSize() {
        return listaPersonas.getSize();
    }

    public void guardar() throws IOException, ListaNullException, PosicionException {
        Gson json = new Gson();
        Persona[] personas = new Persona[listaPersonas.getUltimaPosicion()];
        for (int i = 0; i < personas.length; i++) {
            personas[i] = listaPersonas.obtener(i);
        }
        String jsons = json.toJson(personas);
        FileWriter fw = new FileWriter("Personas" + ".json");
        fw.write(jsons);
        fw.flush();
    }

    public void cargar() {
        try {
            System.out.println("Cargando data...");
            Gson json = new Gson();
            FileReader fr = new FileReader("Personas" + ".json");
            StringBuilder jsons = new StringBuilder();
            // boolean isComa;
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Persona[] aux = json.fromJson(jsons.toString(), Persona[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                // insertarAlInicio estaba antes
                listaPersonas.insertarCabecera(aux[i]);
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados en el json!");
        }
    }
}
