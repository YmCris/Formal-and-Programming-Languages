package ymcris.parser;

import ymcris.parser.view.analyzer.JFAnalyzer;
import java.lang.reflect.InvocationTargetException;

/**
 * Parser Class is the class responsabilty for start the application showing the
 * initial JFrame 'JFAnalyzer'
 *
 * @author YmCris
 * @see JFAnalyzer
 * @since Oct 16, 2025
 */
public class Parser {

    /**
     * Main method is the responsabilty for start the application
     *
     * @param args Shortcuts that could be have the app
     * @throws InvocationTargetException if something does'nt looks good
     */
    public static void main(String[] args) throws InvocationTargetException {
        try {
            java.awt.EventQueue.invokeAndWait(() -> {
                new JFAnalyzer().setVisible(true);
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
