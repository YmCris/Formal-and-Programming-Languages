package ymcris.languages.practice.lexicalanalyzer.backend.manejodetokens;

import java.util.ArrayList;
import ymcris.languages.practice.lexicalanalyzer.backend.tokens.Token;
import ymcris.languages.practice.lexicalanalyzer.controller.validation.LexemaController;

/**
 * Clase ClasificadorDeToken es la clase encargada de recibir los tokens
 * descritos por el usuario y transformarlos a tokens según su estructura.
 * Verificando su posición en el texto, las veces que aparecen y su tipo de
 * token.
 *
 * @author YmCris
 * @since Aug 26, 2025
 */
public class ClasificadorDeToken {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private ArrayList<Token[]> tokens;
    private LexemaController controller;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public ClasificadorDeToken(ArrayList<Token[]> tokens, LexemaController controller) {
        this.tokens = tokens;
        this.controller = controller;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    // ********** MÉTODOS PARA OBTENER LA POSICIÓN DE UN TOKEN *****************
    /**
     * Método encargado de obtener la fila (número de línea) de una palabra
     *
     * @param palabra a la cual se va a analizar.
     * @return arreglo de filas donde se encuentre la palabra.
     */
    private int[] obtenerFilaDeLaPalabra(Token palabra) {
        return null;
    }

    /**
     * Método encargado de obtener la columna de una palabra
     *
     * @param palabra - palabra a de la cual se va a analizar.
     * @return arreglo de columnas donde se encuentra la palabra.
     */
    private int[] obtenerColumnaDeLaPalabra(Token palabra) {
        return null;
    }

    private void darPosicionALosTokens() {
        for (Token[] lineas : tokens) {
            for (Token palabra : lineas) {
                obtenerFilaDeLaPalabra(palabra);
                obtenerColumnaDeLaPalabra(palabra);
            }
        }
    }

    // ***************** MÉTODOS PARA BUSCAR UNA PALABRA ***********************
    /**
     * Método encargado de subrayar la palabra que se desa buscar y retornar
     * true si existe la palabra
     *
     * @param palabraABuscar palabra que se desa buscar en el archivo de texto
     * @return true si existe la palabra
     */
    public boolean existePalabra(String palabraABuscar) {
        boolean existePalabra = false;
        int cantidad = 0;
        for (Token[] linea : tokens) {
            for (Token palabra : linea) {
                if (palabra.getLexema().equals(palabraABuscar)) {
                    palabra.setEstaResaltado(true);
                    existePalabra = true;
                    cantidad++;
                }
            }
        }
        System.out.println("La palabra se repite " + cantidad + " veces");
        return existePalabra;
    }

    // ***************** MÉTODOS PARA CLASIFICAR UN TOKEN **********************
    /**
     * Método final encargado de analizar todos los tokens existentes en el
     * texto
     */
    public void analizarTokens() {
        darPosicionALosTokens();
        for (Token[] token : tokens) {
            for (Token tok : token) {
                if (tok.esToken()) {
                    clasificarToken(tok);
                } else {
                    tok.setTipo("error");
                    tok.setColor("waza");
                }
            }
        }
        analizarLineasParaAgregarComentarios();
        controller.getJfAnalizador().setTokens(tokens);
    }

    private void analizarLineasParaAgregarComentarios() {
        for (Token[] token : tokens) {
            lineaEsUnComentarioDeLinea(token);
        }
    }

    /**
     * Método encargado de asignar el tipo y el color a un token
     *
     * @param token - token a modificar
     * @param tipo - tipo de token que será.
     * @param color - color definido por el tipo.
     */
    private void asignarTipoyColorAToken(Token token, String tipo, String color) {
        if (token.esToken()) {
            token.setTipo(tipo);
            token.setColor(color);
        } else {
            token.setTipo("error");
            token.setColor("rojo");
            System.out.println("El token " + token.getLexema() + " no es un token, por lo cual es de tipo " + token.getTipo() + " de color " + token.getColor());
        }
    }

    /**
     * Método encargado de clasificar token de forma indifvidual
     *
     * @param token token a evaluar.
     */
    private void clasificarToken(Token token) {
        if (tokenEsUnaPalabraReservada(token)) {
            return;
        }
        if (tokenEsUnIdentificador(token)) {
            return;
        }
        if (tokenEsUnNumero(token)) {
            return;
        }
        if (tokenEsUnDecimal(token)) {
            return;
        }
        if (tokenEsUnaCadena(token)) {
            return;
        }
        if (tokenEsUnOperadorAritmetico(token)) {
            return;
        }
        if (tokenEsUnSignoDePuntuacion(token)) {
            return;
        }
        if (tokenEsUnSignoDeAgrupacion(token)) {
            return;
        }
        asignarTipoyColorAToken(token, "error", "rojo");
    }

    /**
     * Método encargado de verificar si palabra es una palabra reservada.
     *
     * @param palabra palabra a analizar
     * @return true si es una palabra reservada
     */
    private boolean esPalabraReservada(String palabra) {
        String[] palabrasReservadas = controller.getPalabrasReservadas();
        for (String palabraReservada : palabrasReservadas) {
            if (palabraReservada.equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de verificar si el token es un identificador.
     *
     * @param token token a verificar
     * @return true si es un identificador
     */
    private boolean tokenEsUnIdentificador(Token token) {//Cafés
        char[] caracteresDeLaPalabra = token.getLexema().toCharArray();
        if (!(caracterEstaEnElArreglo(caracteresDeLaPalabra[0], LexemaController.LETRAS_MINUSCULAS)
                || caracterEstaEnElArreglo(caracteresDeLaPalabra[0], LexemaController.LETRAS_MAYUSCULAS))) {
            return false;
        }
        for (char caracter : caracteresDeLaPalabra) {
            if (!(caracterEstaEnElArreglo(caracter, LexemaController.LETRAS_MAYUSCULAS)
                    || caracterEstaEnElArreglo(caracter, LexemaController.LETRAS_MINUSCULAS)
                    || caracterEstaEnElArreglo(caracter, LexemaController.DIGITOS_NUMERICOS))) {
                return false;
            }
        }
        asignarTipoyColorAToken(token, "identificador", "cafe");
        System.out.println("El token " + token.getLexema() + " es un identificador de color " + token.getColor());
        return true;
    }

    /**
     * Método encargado de verificar si el token es un número.
     *
     * @param token token a verificar
     * @return true si es un número
     */
    private boolean tokenEsUnNumero(Token token) {//Verdes
        char[] caracteresDeLaPalabra = token.getLexema().toCharArray();
        for (char caracter : caracteresDeLaPalabra) {
            if (!caracterEstaEnElArreglo(caracter, LexemaController.DIGITOS_NUMERICOS)) {
                return false;
            }
        }
        asignarTipoyColorAToken(token, "numero", "verde");
        System.out.println("El token " + token.getLexema() + " es un numero de color " + token.getColor());
        return true;
    }

    /**
     * Método encargado de verificar si el token es un decimal
     *
     * @param token token a verificar
     * @return true si es un decimal
     */
    private boolean tokenEsUnDecimal(Token token) {//Negro
        char[] caracteresDeLaPalabra = token.getLexema().toCharArray();
        if (caracterEstaEnElArreglo(caracteresDeLaPalabra[0], LexemaController.DIGITOS_NUMERICOS)
                && token.getLexema().contains(".")
                && token.getLexema().indexOf(".") == token.getLexema().lastIndexOf(".")) {
            asignarTipoyColorAToken(token, "decimal", "negro");
            System.out.println("El token " + token.getLexema() + " es un decimal de color " + token.getColor());
            return true;
        }
        return false;
    }

    /**
     * Método encargado de verificar si el token es una cadena.
     *
     * @param token token a verificar
     * @return true si es una cadena
     */
    private boolean tokenEsUnaCadena(Token token) {//Naranja
        char[] caracteresDeLaPalabra = token.getLexema().toCharArray();
        if (caracteresDeLaPalabra[0] == '"'
                && caracteresDeLaPalabra[token.getLexema().length() - 1] == '"'
                && cantidadDeCaracteresEnUnaPalabra(token.getLexema(), '"') == 2) {
            asignarTipoyColorAToken(token, "cadena", "naranja");
            System.out.println("El token " + token.getLexema() + " es una cadena de color " + token.getColor());
            return true;
        }
        return false;
    }

    /**
     * Método encargado de verificar si el token es una palabra reservada.
     *
     * @param token token a verificar
     * @return true si es una palabra reservada.
     */
    private boolean tokenEsUnaPalabraReservada(Token token) {//Azul
        if (esPalabraReservada(token.getLexema())) {
            asignarTipoyColorAToken(token, "palabraReservada", "azul");
            System.out.println("El token " + token.getLexema() + " es una palabra reservada de color " + token.getColor());
            return true;
        }
        return false;
    }

    /**
     * Método encargado de verificar si el token es un operador aritmetico
     *
     * @param token token a verificar
     * @return true si es un operador aritmetico
     */
    private boolean tokenEsUnOperadorAritmetico(Token token) {//Amarillo
        char[] operadoresAritmeticos = controller.getOperadoresAritmeticos();
        for (char operadoreAritmetico : operadoresAritmeticos) {
            if (token.getLexema().equals(String.valueOf(operadoreAritmetico))) {
                asignarTipoyColorAToken(token, "operadorAritmetico", "amarillo");
                System.out.println("El token " + token.getLexema() + " es un operador aritmetico de color " + token.getColor());
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de verificar si el token es un signo de agrupacion
     *
     * @param token token a verificar
     * @return true si es un signo de agrupacion
     */
    private boolean tokenEsUnSignoDePuntuacion(Token token) {//blanco
        char[] signosDePuntuacion = controller.getSignosDePuntuacion();
        for (char signoDePuntuacion : signosDePuntuacion) {
            if (token.getLexema().equals(String.valueOf(signoDePuntuacion))) {
                asignarTipoyColorAToken(token, "signoDePuntuacion", "blanco");
                System.out.println("El token " + token.getLexema() + " es un signo de puntuacion de color " + token.getColor());
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de verificar si el token es un signo de agrupacion.
     *
     * @param token token a verificar
     * @return true si es un signo de agrupacion
     */
    private boolean tokenEsUnSignoDeAgrupacion(Token token) {//Morado
        char[] signosDeAgrupacion = controller.getSignosDeAgrupacion();
        for (char signoDeAgrupacion : signosDeAgrupacion) {
            if (token.getLexema().equals(String.valueOf(signoDeAgrupacion))) {
                asignarTipoyColorAToken(token, "signoDeAgrupacion", "morado");
                System.out.println("El token " + token.getLexema() + " es un signo de agrupacion de color " + token.getColor());
                return true;
            }
        }
        return false;
    }

    /**
     * Método encargado de verificar si una línea es un comentario de línea.
     *
     * @param tokens arreglo de tokens a verificar si es una línea comentada
     * @return true si es una línea comentada.
     */
    private boolean lineaEsUnComentarioDeLinea(Token[] tokens) {//Verde Oscuro
        if (tokens[0].getLexema().equals("/") && tokens[1].getLexema().equals("/") || tokens[0].getLexema().equals("//")) {
            System.out.println("Es un comentario de línea");
            for (Token token : tokens) {
                token.setTipo("comentarioDeLinea");
                token.setColor("verdeOscuro");
                token.setEsComentario(true);
                token.setEstaResaltado(true);
                System.out.println("El token " + token.getLexema() + " es un comentario de linea? " + token.esComentario() + " tiene el color " + token.getColor()+" es del tipo "+token.getTipo());
            }
            return true;
        }
        return false;
    }
    // ************************ MÉTODOS AUXILIARES *****************************

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

    /**
     * Método encargado de verificar la cantidad de carácteres que existen en
     * una palabra
     *
     * @param palabra Palabra a analizar
     * @param caracterDeInteres - caracter a buscar dentro de la palabra
     * @return cantidad de veces que aparece el caracter en una palabra.
     */
    private int cantidadDeCaracteresEnUnaPalabra(String palabra, char caracterDeInteres) {
        char[] caracteres = palabra.toCharArray();
        int cantidad = 0;
        for (char caracter : caracteres) {
            if (caracter == caracterDeInteres) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<Token[]> getTokens() {
        return tokens;
    }

    // SETTERS -----------------------------------------------------------------
    public void setTokens(ArrayList<Token[]> tokens) {
        this.tokens = tokens;
    }

}
