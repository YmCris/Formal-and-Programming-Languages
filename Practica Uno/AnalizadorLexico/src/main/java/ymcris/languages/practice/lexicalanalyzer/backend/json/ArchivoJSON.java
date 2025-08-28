package ymcris.languages.practice.lexicalanalyzer.backend.json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ymcris.languages.practice.lexicalanalyzer.backend.lenguaje.LexicoDelLenguaje;

/**
 * Clase ArchivoJSON es la clase encargada de crear el archivo JSON y
 * actualizarlo, además de llamar los métodos de la clase token para poder
 * modificar el archivo.
 *
 * @author YmCris
 * @since Aug 24, 2025
 */
public class ArchivoJSON {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    LexicoDelLenguaje token;

    public ArchivoJSON() {
        File file = new File("config.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new Gson();
                this.token = gson.fromJson(reader, LexicoDelLenguaje.class);
            } catch (Exception e) {
                this.token = new LexicoDelLenguaje();
            }
        } else {
            this.token = new LexicoDelLenguaje();
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear el archivo JSON inicial, cuando se ejecute el
     * programa.
     */
    public void crearArchivoJSON() {
        File file = new File("config.json");
        if (!file.exists()) {
            token.getPalabrasReservadas().add("SI");
            token.getPalabrasReservadas().add("si");
            token.getPalabrasReservadas().add("ENTONCES");
            token.getPalabrasReservadas().add("entonces");
            token.getPalabrasReservadas().add("PARA");
            token.getPalabrasReservadas().add("para");
            token.getOperadoresAritmeticos().add("+");
            token.getOperadoresAritmeticos().add("-");
            token.getOperadoresAritmeticos().add("*");
            token.getOperadoresAritmeticos().add("/");
            token.getOperadoresAritmeticos().add("%");
            token.getOperadoresAritmeticos().add("=");
            token.getSignosDePuntuacion().add(".");
            token.getSignosDePuntuacion().add(",");
            token.getSignosDePuntuacion().add(";");
            token.getSignosDePuntuacion().add(":");
            token.getSignosDePuntuacion().add("'");
            token.getSignosDeAgrupacion().add("(");
            token.getSignosDeAgrupacion().add(")");
            token.getSignosDeAgrupacion().add("[");
            token.getSignosDeAgrupacion().add("]");
            token.getSignosDeAgrupacion().add("{");
            token.getSignosDeAgrupacion().add("}");
            token.getSignosDeAgrupacion().add("\"");
            token.setComentarios(new Comentario("//", "/*", "*/"));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String contenidoJSON = gson.toJson(token);
            System.out.println(contenidoJSON);
            try (FileWriter writer = new FileWriter("config.json")) {
                gson.toJson(token, writer);
            } catch (IOException e) {
                System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar la creación del JSON porque " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * Método encargado de agregar una palabra al archivo JSON en sus distintas
     * claves.
     *
     * @param lista clave a la cual le asignará un valor nuevo.
     * @param palabra valor que será asignado a una clave ya existente.
     */
    public void agregarPalabraAJSON(String lista, String palabra) {
        switch (lista) {
            case "palabrasReservadas" -> {
                token.agregarPalabraReservada(palabra);
            }
            case "operadoresAritmeticos" -> {
                token.agregarOperadorAritmetico(palabra);
            }
            case "signosDePuntuacion" -> {
                token.agregarSignoDePuntuacion(palabra);
            }
            case "signosDeAgrupacion" -> {
                token.agregarSignoDeAgrupacion(palabra);
            }
            default -> {
                System.out.println("No se puede agregar esa instrucción");
            }
        }
        actualizarJSON();
    }

    /**
     * Mëtodo encargado de modificar una palabra ya existente por otra nueva.
     *
     * @param lista clave a la cual se modificará una palabra
     * @param palabra palabra existente en la clave
     * @param nuevaPalabra palabra que remplazará la palbra ya existente.
     */
    public void modificarPalabraJSON(String lista, String palabra, String nuevaPalabra) {
        switch (lista) {
            case "palabrasReservadas" -> {
                token.modificarPalabraReservada(palabra, nuevaPalabra);
            }
            case "operadoresAritmeticos" -> {
                token.modificarOperadorArimetico(palabra, nuevaPalabra);
            }
            case "signosDePuntuacion" -> {
                token.modificarSignoDePuntuacion(palabra, nuevaPalabra);
            }
            case "signosDeAgrupacion" -> {
                token.modificarSignoDeAgrupacion(palabra, nuevaPalabra);
            }
            default -> {
                System.out.println("No se puede modificar esa instrucción");
            }
        }
        actualizarJSON();
    }

    /**
     * Método encargado de eliminar una palabra en el archivo JSON
     *
     * @param lista clave donde se eliminará una palabra.
     * @param palabra palabra que será eliminada.
     */
    public void eliminarPalabraEnJSON(String lista, String palabra) {
        switch (lista) {
            case "palabrasReservadas" -> {
                token.eliminarPalabraReservada(palabra);
            }
            case "operadoresAritmeticos" -> {
                token.eliminarOperadorAritmetico(palabra);
            }
            case "signosDePuntuacion" -> {
                token.eliminarSignoDePuntuacion(palabra);
            }
            case "signosDeAgrupacion" -> {
                token.eliminarSignoDeAgrupacion(palabra);
            }
            default -> {
                System.out.println("No se puede elminar esa palabra");
            }
        }
        actualizarJSON();
    }

    /**
     * Método encargado de actualizar el archivo JSON cada vez que se le aplique
     * un cambio desde la interfaz de usuario.
     */
    private void actualizarJSON() {
        try (FileWriter writer = new FileWriter("config.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String contenidoJSON = gson.toJson(token);
            System.out.println(contenidoJSON);
            gson.toJson(token, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mëtodo encargado de recuperar la inforemación guardada en el JSON
     *
     * @param clave clave de la cual se va a recuperar todo
     * @return arreglo con el contenido.
     */
    public String[] recuperarValoresDeClaveEnJSON(String clave) {
        return switch (clave) {
            case "palabrasReservadas" ->
                token.getPalabrasReservadas().toArray(new String[0]);
            case "operadoresAritmeticos" ->
                token.getOperadoresAritmeticos().toArray(new String[0]);
            case "signosDePuntuacion" ->
                token.getSignosDePuntuacion().toArray(new String[0]);
            case "signosDeAgrupacion" ->
                token.getSignosDeAgrupacion().toArray(new String[0]);
            case "comentarios" ->
                new String[]{
                    token.getComentarios().getLinea(),
                    token.getComentarios().getBloqueInicio(),
                    token.getComentarios().getBloqueFin()
                };
            default ->
                null;
        };
    }

    /**
     * Mëtodo encargado de recuperar la inforemación guardada en el JSON
     * unicamente utilizar para los operadores, puntuacion y agrupacion.
     *
     * @param clave clave de la cual se va a recuperar todo
     * @return arreglo con el contenido.
     */
    public char[] recuperarValorDeClaveEnJSON(String clave) {
        return switch (clave) {
            case "palabrasReservadas" ->
                convertirArregloStringAArregloChar(token.getPalabrasReservadas().toArray(new String[0]));
            case "operadoresAritmeticos" ->
                convertirArregloStringAArregloChar(token.getOperadoresAritmeticos().toArray(new String[0]));
            case "signosDePuntuacion" ->
                convertirArregloStringAArregloChar(token.getSignosDePuntuacion().toArray(new String[0]));
            case "signosDeAgrupacion" ->
                convertirArregloStringAArregloChar(token.getSignosDeAgrupacion().toArray(new String[0]));
            case "comentarios" ->
                convertirArregloStringAArregloChar(new String[]{
                    token.getComentarios().getLinea(),
                    token.getComentarios().getBloqueInicio(),
                    token.getComentarios().getBloqueFin()
                }
                );
            default ->
                null;
        };
    }

    /**
     * Método encargado de convertir un arreglo de strings a un arreglo de char
     * unicamente utilizar para los operadores, puntuacion y agrupacion.
     *
     * @param arregloString - arreglo a transformar
     * @return arreglo de char
     */
    private char[] convertirArregloStringAArregloChar(String[] arregloString) {
        char[] arregloChar = new char[arregloString.length];
        for (int i = 0; i < arregloChar.length; i++) {
            if (arregloString[i].length() == 1) {
                arregloChar[i] = arregloString[i].charAt(0);
            }
        }
        return arregloChar;
    }

}
