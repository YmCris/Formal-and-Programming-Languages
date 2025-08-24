package ymcris.languages.practice.lexicalanalyzer;

import ymcris.languages.practice.lexicalanalyzer.frontend.JFMenuPrincipal;

/**
 *
 * @author YmCris
 * @since
 */
public class AnalizadorLexico {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenuPrincipal().setVisible(true);
            }
        });
    }
}
