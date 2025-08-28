package ymcris.languages.practice.lexicalanalyzer;

import ymcris.languages.practice.lexicalanalyzer.backend.json.ArchivoJSON;
import ymcris.languages.practice.lexicalanalyzer.frontend.JFMenuPrincipal;

/**
 * Clase AnalizadorLexico es la clase main encargada de inicar el programa,
 * crear el JSON inicial e iniciar el menú
 *
 * @author YmCris
 */
public class AnalizadorLexico {

    /**
     * Método encargado de iniciar el programa
     *
     * @param args argumentos para iniciar una actividad inmediata
     */
    public static void main(String[] args) {
        ArchivoJSON json = new ArchivoJSON();
        json.crearArchivoJSON();
        new JFMenuPrincipal(json).setVisible(true);
    }
}
