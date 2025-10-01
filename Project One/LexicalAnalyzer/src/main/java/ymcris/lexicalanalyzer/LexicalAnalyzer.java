package ymcris.lexicalanalyzer;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import ymcris.lexicalanalyzer.backend.automata.Automata;
import ymcris.lexicalanalyzer.view.analyzer.JFLexicalAnalyzer;

/**
 * Clase main encargada de dar inicio al programa llamando al JFrame encargado
 * de mostrar la vista
 *
 * @author YmCris
 * @since Sep 25, 2025
 */
public class LexicalAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Automata automata = new Automata();
        while (true) {
            System.out.println("Ingrese el texto");
            String texto = scanner.nextLine();
            automata.analyze(texto);
        }
        /*
        try {
            java.awt.EventQueue.invokeAndWait(() -> {
                new JFLexicalAnalyzer().setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
         */
    }
}
