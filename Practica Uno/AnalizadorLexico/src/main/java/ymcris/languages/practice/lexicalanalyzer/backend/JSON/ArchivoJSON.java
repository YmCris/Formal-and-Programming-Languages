package ymcris.languages.practice.lexicalanalyzer.backend.JSON;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import ymcris.languages.practice.lexicalanalyzer.tokens.Token;

/**
 * Clase ArchivoJSON es la clase encargada de crear el archivo JSON
 *
 * @author YmCris
 * @since Aug 24, 2025
 */
public class ArchivoJSON {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    Token token;

    public ArchivoJSON() {
        File file = new File("config.json");
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new Gson();
                this.token = gson.fromJson(reader, Token.class);
            } catch (Exception e) {
                e.printStackTrace();
                this.token = new Token();
            }
        } else {
            this.token = new Token();
        }
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
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
            token.getSignosDePuntuacion().add("\"");
            token.getSignosDeAgrupacion().add("(");
            token.getSignosDeAgrupacion().add(")");
            token.getSignosDeAgrupacion().add("[");
            token.getSignosDeAgrupacion().add("]");
            token.getSignosDeAgrupacion().add("{");
            token.getSignosDeAgrupacion().add("}");
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

}
