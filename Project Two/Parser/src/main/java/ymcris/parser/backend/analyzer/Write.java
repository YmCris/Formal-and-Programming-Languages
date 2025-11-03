package ymcris.parser.backend.analyzer;

import java.util.ArrayList;
import ymcris.parser.model.variables.Variable;
import ymcris.parser.view.analyzer.JFAnalyzer;

/**
 * The Write class is the class responsible for do the write feature in the
 * frontend
 *
 * @author YmCris
 * @see Variable
 * @since Nov 2, 2025
 */
public class Write {

    // REFERENCE VARIABLES -----------------------------------------------------
    private JFAnalyzer jFAnalyzer;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Write(JFAnalyzer jFAnalyzer) {
        this.jFAnalyzer = jFAnalyzer;
    }

    // SPECIFIC METHODS --------------------------------------------------------
    public void print(ArrayList<String> values) {
        for (String value : values) {
            jFAnalyzer.getJtpConsole().setText(value);
        }
    }

    // SETTERS -----------------------------------------------------------------

}
