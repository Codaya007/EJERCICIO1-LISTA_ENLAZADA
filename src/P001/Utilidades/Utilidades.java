package P001.Utilidades;

import Controlador.Listas.Excepciones.PosicionException;
import Controlador.Listas.ListaEnlazada;
import Modelo.Categoria;

/**
 *
 * @author vivi
 */
public class Utilidades {
    public static ListaEnlazada<Categoria> inicializarCategorias() throws PosicionException{
        System.out.println("Inicializando categorías");
         ListaEnlazada<Categoria> categorias = new ListaEnlazada<>();
         categorias.setSize(4);

        // Inicializo las categorías
        // 1. Niños
        Categoria nino = new Categoria();
        nino.setNombre("Niño");
        nino.setMinEdad(0);
        nino.setMaxEdad(17);
        // 2. Joven
        Categoria joven = new Categoria();
        joven.setNombre("Joven");
        joven.setMinEdad(18);
        joven.setMaxEdad(26);
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
        categorias.insertarPosicion(nino, 0);
        categorias.insertarPosicion(joven, 1);
        categorias.insertarPosicion(adulto, 2);
        categorias.insertarPosicion(tercera_edad, 3);
        
        categorias.imprimir();
        return categorias;
    }
}
