package ymcris.languages.practice.lexicalanalyzer.backend.tokens;

/**
 * Clase Palabra es la clase encargada de representar una palabra dentro del
 * análisis del analizador léxico teniendo atributos que le permiten identificar
 * qué tipo de lexema (palabra perteneciente al lenguaje) es.
 *
 * @author YmCris
 * @since Aug 26, 2025
 */
public class Token {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String tipo;
    private String color;
    private String lexema;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int fila;
    private int columna;
    private boolean esToken;
    private boolean esComentario;
    private boolean estaResaltado;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Token(String lexema) {
        this.lexema = lexema;
    }

    // GETTERS -----------------------------------------------------------------
    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean esToken() {
        return esToken;
    }

    public boolean esComentario() {
        return esComentario;
    }

    public boolean estaResaltado() {
        return estaResaltado;
    }
    
    

    // SETTERS -----------------------------------------------------------------
    public void setColor(String color) {
        this.color = color;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFila(int linea) {
        this.fila = linea;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setEsToken(boolean esToken) {
        this.esToken = esToken;
    }

    public void setEsComentario(boolean esComentario) {
        this.esComentario = esComentario;
    }

    public void setEstaResaltado(boolean estaResaltado) {
        this.estaResaltado = estaResaltado;
    }

}
