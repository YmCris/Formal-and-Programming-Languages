package ymcris.languages.practice.lexicalanalyzer.backend.lenguaje;

import java.util.List;
import java.util.ArrayList;
import ymcris.languages.practice.lexicalanalyzer.backend.json.Comentario;
import ymcris.languages.practice.lexicalanalyzer.frontend.json.JFConfigJSON;

/**
 * Clase LexicoDelLenguaje es la clase encargada de ser el concepto de token en
 * el programa, por ende tendrá todos los atributos para que hacer el archivo
 * JSON y modificarlo después.
 *
 * @author YmCris
 * @see Comentario
 * @since Aug 24, 2025
 */
public class LexicoDelLenguaje {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private List<String> palabrasReservadas;
    private List<String> operadoresAritmeticos;
    private List<String> signosDePuntuacion;
    private List<String> signosDeAgrupacion;
    private Comentario comentarios;

    // MÉTODOS CONCRETOS -------------------------------------------------------    
    public LexicoDelLenguaje() {
        this.palabrasReservadas = new ArrayList<>();
        this.operadoresAritmeticos = new ArrayList<>();
        this.signosDePuntuacion = new ArrayList<>();
        this.signosDeAgrupacion = new ArrayList<>();
    }

    // EXISTENCIA DE UNA PALABRA -----------------------------------------------
    /**
     * Método encargado de verificar si una palabra existe en una lista
     *
     * @param palabra palabra a buscar si existe
     * @param lista Lista de palabras donde se verificará la existencia.
     * @return true si existe.
     */
    private boolean existePalabra(String palabra, List<String> lista) {
        for (String elemento : lista) {
            if (elemento.equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    // AGREGAR PALABRA ---------------------------------------------------------
    /**
     * Método encargado de agregar una palabra en una lista
     *
     * @param palabra palabra a agregar
     * @param lista clave a la cual se agregará la palabra.
     */
    private void agregarPalabra(String palabra, List<String> lista) {
        if (existePalabra(palabra, lista)) {
            JFConfigJSON.mostrarInformacion("La palabra " + palabra + " ya existe en la lista");
            return;
        }
        lista.add(palabra);
        JFConfigJSON.mostrarInformacion("La palabra " + palabra + " se ha agregado correctamente");
    }

    public void agregarPalabraReservada(String palabraReservada) {
        agregarPalabra(palabraReservada, palabrasReservadas);
    }

    public void agregarOperadorAritmetico(String operadorAritmetico) {
        agregarPalabra(operadorAritmetico, operadoresAritmeticos);
    }

    public void agregarSignoDePuntuacion(String signoDePuntuacion) {
        agregarPalabra(signoDePuntuacion, signosDePuntuacion);
    }

    public void agregarSignoDeAgrupacion(String signoDeAgrupacion) {
        agregarPalabra(signoDeAgrupacion, signosDeAgrupacion);
    }

    // MODIFICAR PALABRA -------------------------------------------------------
    /**
     * Método encargado de cambiar una palabra por otra dentro de la lista.
     *
     * @param palabraActual palabra existente
     * @param palabraNueva nueva palabra
     * @param lista lista de palabras
     */
    private void cambiarPalabra(String palabraActual, String palabraNueva, List<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(palabraActual)) {
                lista.set(i, palabraNueva);
                JFConfigJSON.mostrarInformacion("La palabra " + palabraActual + " ha sido cambiada por " + palabraNueva);
                return;
            }
        }
        JFConfigJSON.mostrarInformacion("La palabra " + palabraActual + " no existe en la lista por lo que no se ha podido cambiar por " + palabraNueva);
    }

    public void modificarPalabraReservada(String palabraReservadaActual, String nuevaPalabraReservada) {
        cambiarPalabra(palabraReservadaActual, nuevaPalabraReservada, palabrasReservadas);
    }

    public void modificarOperadorArimetico(String operadorArimeticoActual, String nuevoOperadorAritmetico) {
        cambiarPalabra(operadorArimeticoActual, nuevoOperadorAritmetico, operadoresAritmeticos);
    }

    public void modificarSignoDePuntuacion(String signoDePuntuacionActual, String nuevoSignoDePuntuacion) {
        cambiarPalabra(signoDePuntuacionActual, nuevoSignoDePuntuacion, signosDePuntuacion);
    }

    public void modificarSignoDeAgrupacion(String signoDeAgrupacionActual, String nuevoSignoDeAgrupacion) {
        cambiarPalabra(signoDeAgrupacionActual, nuevoSignoDeAgrupacion, signosDeAgrupacion);
    }

    // ELIMINAR ----------------------------------------------------------------
    /**
     * Método encargado de eliminar una palabra de una lista
     *
     * @param palabraAEliminar - Palabra que se desea eliminar.
     * @param lista - Clave de la cual se eliminará la palabra.
     */
    private void eliminarPalabra(String palabraAEliminar, List<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(palabraAEliminar)) {
                lista.remove(i);
                JFConfigJSON.mostrarInformacion("La palabra " + palabraAEliminar + " ha sido eliminada de la lista");
                return;
            }
        }
        JFConfigJSON.mostrarInformacion("La palabra " + palabraAEliminar + " no existe en la lista por lo que no se ha eliminado");
    }

    public void eliminarPalabraReservada(String palabraReservadaAEliminar) {
        eliminarPalabra(palabraReservadaAEliminar, palabrasReservadas);
    }

    public void eliminarOperadorAritmetico(String operadorAritmeticoAEliminar) {
        eliminarPalabra(operadorAritmeticoAEliminar, operadoresAritmeticos);
    }

    public void eliminarSignoDePuntuacion(String signoDePuntuacionAEliminar) {
        eliminarPalabra(signoDePuntuacionAEliminar, signosDePuntuacion);
    }

    public void eliminarSignoDeAgrupacion(String signoDeAgrupacionAEliminar) {
        eliminarPalabra(signoDeAgrupacionAEliminar, signosDeAgrupacion);
    }

    // GETTERS -----------------------------------------------------------------
    public List<String> getPalabrasReservadas() {
        return palabrasReservadas;
    }

    public List<String> getOperadoresAritmeticos() {
        return operadoresAritmeticos;
    }

    public List<String> getSignosDePuntuacion() {
        return signosDePuntuacion;
    }

    public List<String> getSignosDeAgrupacion() {
        return signosDeAgrupacion;
    }

    public Comentario getComentarios() {
        return comentarios;
    }

    // SETTER ------------------------------------------------------------------
    public void setPalabrasReservadas(List<String> palabrasReservadas) {
        this.palabrasReservadas = palabrasReservadas;
    }

    public void setOperadoresAritmeticos(List<String> operadoresAritmeticos) {
        this.operadoresAritmeticos = operadoresAritmeticos;
    }

    public void setSignosDePuntuacion(List<String> signosDePuntuacion) {
        this.signosDePuntuacion = signosDePuntuacion;
    }

    public void setSignosDeAgrupacion(List<String> signosDeAgrupacion) {
        this.signosDeAgrupacion = signosDeAgrupacion;
    }

    public void setComentarios(Comentario comentarios) {
        this.comentarios = comentarios;
    }

}
