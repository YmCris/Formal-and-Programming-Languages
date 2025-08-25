package ymcris.languages.practice.lexicalanalyzer.backend.JSON;

/**
 * Clase Comentario es la clase encargada de contener un bloque de comentario
 * (linea o más)
 *
 * @author YmCris
 * @since Aug 24, 2025
 */
public class Comentario {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String linea;
    private String bloqueInicio;
    private String bloqueFin;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Comentario(String linea, String bloqueInicio, String bloqueFin) {
        this.linea = linea;
        this.bloqueInicio = bloqueInicio;
        this.bloqueFin = bloqueFin;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    // GETTERS -----------------------------------------------------------------
    public String getLinea() {
        return linea;
    }

    public String getBloqueInicio() {
        return bloqueInicio;
    }

    public String getBloqueFin() {
        return bloqueFin;
    }

    // SETTERS -----------------------------------------------------------------
    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setBloqueInicio(String bloqueInicio) {
        this.bloqueInicio = bloqueInicio;
    }

    public void setBloqueFin(String bloqueFin) {
        this.bloqueFin = bloqueFin;
    }

}
