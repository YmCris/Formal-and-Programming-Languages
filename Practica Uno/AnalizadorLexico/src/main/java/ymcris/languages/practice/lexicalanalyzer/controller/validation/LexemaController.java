package ymcris.languages.practice.lexicalanalyzer.controller.validation;

import java.util.ArrayList;
import ymcris.languages.practice.lexicalanalyzer.backend.tokens.Token;
import ymcris.languages.practice.lexicalanalyzer.backend.json.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.backend.manejodetokens.ClasificadorDeToken;
import ymcris.languages.practice.lexicalanalyzer.frontend.uploadfile.JFAnalizador;

/**
 * Clase LexemaController es la clase encargada de ser el verificador de la
 * información del frontend y así porder hacer la lógica para el backend.
 *
 * @author YmCris
 * @since Aug 25, 2025
 */
public class LexemaController {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private ArrayList<String> lineas;
    private JFAnalizador jfAnalizador;
    private String[] palabrasReservadas;
    private ArrayList<Token[]> palabrasDeLasLineas;//Guarda las palabras de cada línea

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private char[] signosDePuntuacion;
    private char[] signosDeAgrupacion;
    private char[] operadoresAritmeticos;

    // CONSTANTES --------------------------------------------------------------
    public static final char[] LETRAS_MINUSCULAS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] LETRAS_MAYUSCULAS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final char[] DIGITOS_NUMERICOS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // INSTANCIAS --------------------------------------------------------------    
    ArchivoJSON json = new ArchivoJSON();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public LexemaController(JFAnalizador jfAnalizador) {
        this.jfAnalizador = jfAnalizador;
        this.palabrasReservadas = json.recuperarValoresDeClaveEnJSON("palabrasReservadas");
        this.operadoresAritmeticos = json.recuperarValorDeClaveEnJSON("operadoresAritmeticos");
        this.signosDePuntuacion = json.recuperarValorDeClaveEnJSON("signosDePuntuacion");
        this.signosDeAgrupacion = json.recuperarValorDeClaveEnJSON("signosDeAgrupacion");
        this.palabrasDeLasLineas = new ArrayList<>();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    // ********* MÉTODOS PARA VER SI UN LEXEMA PERTENECE AL LENGUAJE ***********
    /**
     * Método encargado de analizar si un lexema pertentece a un lenguaje.
     *
     * @param palabra - palabra a analizar
     * @return true si pertenece al lenguaje
     */
    private boolean lexemaPertenezcaAlLenguaje(Token palabra) {
        if (palabra.getLexema().isEmpty() || palabra.getLexema().isBlank()) {
            return false;
        }
        char[] caracteresDePalabra = palabra.getLexema().toCharArray();
        for (int i = 0; i < caracteresDePalabra.length; i++) {
            if (caracterPerteneceAlLenguaje(caracteresDePalabra[i]) == false) {
                palabra.setEsToken(true);
                palabra.setColor("rojo");
                System.out.println("El lexema " + palabra.getLexema() + " no pertenece al lenguaje");
                return false;
            }
        }
        System.out.println("El lexema " + palabra.getLexema() + " pertenece al lenguaje");
        palabra.setEsToken(true);
        return true;
    }

    /**
     * Método encargado de verificar si un caracter pertenece al lenguaje
     *
     * @param caracter - caracter al cual se verificará
     * @return true si pertenece al lenguaje.
     */
    private boolean caracterPerteneceAlLenguaje(char caracter) {
        return caracterEstaEnElArreglo(caracter, LETRAS_MINUSCULAS)
                || caracterEstaEnElArreglo(caracter, LETRAS_MAYUSCULAS)
                || caracterEstaEnElArreglo(caracter, DIGITOS_NUMERICOS)
                || caracterEstaEnElArreglo(caracter, operadoresAritmeticos)
                || caracterEstaEnElArreglo(caracter, signosDePuntuacion)
                || caracterEstaEnElArreglo(caracter, signosDeAgrupacion);
    }

    /**
     * Mëtodo encargado de verificar si el caracter se encuentra en un arreglo
     * definido del lenguaje.
     *
     * @param caracter - caracter a evaluar
     * @param caracteres - arreglo a verificar si existe el caracter ahí.
     * @return true si existe en ese arreglo.
     */
    private boolean caracterEstaEnElArreglo(char caracter, char[] caracteres) {
        for (char caractere : caracteres) {
            if (caractere == caracter) {
                return true;
            }
        }
        return false;
    }

    // *************** MÉTODOS PARA SEPARAR LAS LÍNEAS *************************
    /**
     * Método encargado de separar las palabras de una línea y almacenarlas en
     * un arreglo de palabras.
     *
     * @param linea - línea de la cual se extraerán las palabras.
     * @return arreglo con todas las palabras incluyendo los espacios que
     * existan en una línea.
     */
    private Token[] separarPalabrasDeUnaLinea(String linea) {
        char[] caracteresLinea = linea.toCharArray();
        ArrayList<Token> listaDePalabras = new ArrayList<>();
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < linea.length(); i++) {
            if (caracteresLinea[i] != ' ' && caracteresLinea[i] != '\n') {
                build.append(caracteresLinea[i]);
            } else {
                if (build.length() > 0) {
                    Token token = new Token(build.toString());
                    token.setColumna(i);
                    listaDePalabras.add(token);
                    build.setLength(0);
                }
                Token token = new Token(String.valueOf(caracteresLinea[i]));
                token.setColumna(i);
                listaDePalabras.add(token);
            }
        }
        if (build.length() > 0) {
            listaDePalabras.add(new Token(build.toString()));
        }
        return listaDePalabras.toArray(Token[]::new);
    }

    /**
     * Método encargado de agregar palabras al arreglo de las palabras
     * existentes en una línea.
     *
     * @param linea - línea de la cual se extraerán las palabras
     */
    private void agregarPalabrasDeUnaLineaAUnArreglo(String linea) {
        if (linea.isBlank() || linea.isEmpty()) {
            Token token = new Token(linea);
            token.setEsToken(true);
            token.setTipo("error");
            token.setColor("waza");
            palabrasDeLasLineas.add(new Token[]{token});
        } else {
            palabrasDeLasLineas.add(separarPalabrasDeUnaLinea(linea));
        }
    }

    /**
     * Método encargado de realizar el análisis de las palabras existentes en
     * las líneas del texto de entrada. Para determinar si son lexemas o no.
     */
    private void analizarLosLexemasDeLasLineas() {
        for (int i = 0; i < palabrasDeLasLineas.size(); i++) {
            Token[] palabrasExistentesEnUnaLinea = palabrasDeLasLineas.get(i);
            for (Token palabra : palabrasExistentesEnUnaLinea) {
                lexemaPertenezcaAlLenguaje(palabra);
            }
        }
    }

    // **************** MÉTODOS PARA UNIR LOS PROCESOS *************************
    /**
     * Método encargado de analizar el texto de entrada y clasificar todos sus
     * componentes.
     */
    public void analizar() {
        for (String linea : lineas) {
            agregarPalabrasDeUnaLineaAUnArreglo(linea);
        }
        analizarLosLexemasDeLasLineas();
        leerContenidoDeLasLineas();
        ClasificadorDeToken clasificador = new ClasificadorDeToken(palabrasDeLasLineas, this);
        clasificador.analizarTokens();
    }

    /**
     * Método encargado de leer las líneas existentes luego de modificarlas
     */
    private void leerContenidoDeLasLineas() {
        System.out.println("\n".repeat(5));
        for (int i = 0; i < lineas.size(); i++) {
            String linea = lineas.get(i);
            Token[] palabras = palabrasDeLasLineas.get(i);
            System.out.println("Línea " + (i + 1) + ": " + linea);
            System.out.print("Palabras: ");
            for (Token palabra : palabras) {
                System.out.print("[" + palabra.getLexema() + "] ");
            }
            System.out.println("\n");
        }
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<String> getLineas() {
        return lineas;
    }

    public String[] getPalabrasReservadas() {
        return palabrasReservadas;
    }

    public char[] getSignosDePuntuacion() {
        return signosDePuntuacion;
    }

    public char[] getSignosDeAgrupacion() {
        return signosDeAgrupacion;
    }

    public char[] getOperadoresAritmeticos() {
        return operadoresAritmeticos;
    }

    public JFAnalizador getJfAnalizador() {
        return jfAnalizador;
    }

    // SETTERS -----------------------------------------------------------------
    public void setLineas(ArrayList<String> lineas) {
        this.lineas = lineas;
    }

    public void setPalabrasDeLasLineas(ArrayList<Token[]> palabrasDeLasLineas) {
        this.palabrasDeLasLineas = palabrasDeLasLineas;
    }

}
