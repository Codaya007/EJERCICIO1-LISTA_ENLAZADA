/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Utilidades;

import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Listas.ListaEnlazada;
import Modelo.Categoria;
import Modelo.Enums.Genero;
import Modelo.Persona;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author vivi
 */
public class Utilidades {

    public static Boolean anadirCategoria(ListaEnlazada<Categoria> categorias, Persona p) throws ListaNullException, PosicionException {
        for (int i = 0; i <= categorias.getUltimaPosicion(); i++) {
            Categoria category = categorias.obtener(i);
            System.out.println(i + " - " + p.getNombres() + " pertenece a " + category.getNombre()+ ": " + category.perteneceACategoria(p));
            
            if (category != null && category.perteneceACategoria(p)) {
                p.setCategory(category);
                return true;
            }
        }

        return false;
    }

    public static JComboBox cargarComboGenero(JComboBox cbx) {
        cbx.removeAllItems();
        for (Genero genero : Genero.values()) {
            cbx.addItem(genero);
        }

        return cbx;
    }

    public static void cargarCombosFecha(JComboBox dia, JComboBox mes, JComboBox anio) {
        dia.removeAllItems();
        mes.removeAllItems();
        anio.removeAllItems();

        // Lleno el combo de dias del 1 al 31
        for (int i = 1; i <= 31; i++) {
            dia.addItem(i);
        }

        // Lleno el combo de mes del 1 al 12
        for (int i = 1; i <= 12; i++) {
            mes.addItem(i);
        }

        // Lleno el combo de año desde los 100 años anteriores
        Integer anio_actual = new Date().getYear() + 1900;
        for (int i = anio_actual; i >= (anio_actual - 100); i--) {
            anio.addItem(i);
        }
    }

    public static ListaEnlazada<Categoria> inicializarCategorias() {
        ListaEnlazada<Categoria> categorias = new ListaEnlazada<>();

        // Inicializo las categorías
        // 1. Niños
        Categoria nino = new Categoria();
        nino.setNombre("Niño");
        nino.setMinEdad(0);
        nino.setMaxEdad(17);
        nino.setMedicinas("Para niños menores a 5 años, no usar medicinas a menos de ser necesario. En niños mayores se puede usar ibuprofeno o paracetamol en pequeñas cantidades para aliviar los síntomas.");
        // 2. Joven
        Categoria joven = new Categoria();
        joven.setNombre("Joven");
        joven.setMinEdad(18);
        joven.setMaxEdad(26);
        joven.setMedicinas("Para niños menores a 5 años, no usar medicinas a menos de ser necesario. En niños mayores se puede usar ibuprofeno o paracetamol en pequeñas cantidades para aliviar los síntomas.");
        // 3. Adulto
        Categoria adulto = new Categoria();
        adulto.setNombre("Adulto");
        adulto.setMinEdad(27);
        adulto.setMaxEdad(59);
        // 4. Tercera Edad
        Categoria tercera_edad = new Categoria();
        tercera_edad.setNombre("Tercera Edad");
        tercera_edad.setMinEdad(60);
        tercera_edad.setMaxEdad(125);

        // Añado las categorias creadas
        categorias.insertarCabecera(nino);
        categorias.insertarCabecera(joven);
        categorias.insertarCabecera(adulto);
        categorias.insertarCabecera(tercera_edad);

        return categorias;
    }
}
