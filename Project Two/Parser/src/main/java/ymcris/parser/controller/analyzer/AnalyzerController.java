package ymcris.parser.controller.analyzer;

import java.io.IOException;
import ymcris.parser.backend.analyzer.Write;
import ymcris.parser.view.analyzer.JFAnalyzer;
import ymcris.parser.backend.analyzer.Analyzer;
import ymcris.parser.backend.analyzer.ComponentsUpdater;

/**
 * The AnalyzerController class is the class responsible for be the lexical
 * analyzer controller, being the responsible to check the enteries, and send
 * information with distins models
 *
 * @author YmCris
 * @see Write
 * @see Analyzer
 * @see JFAnalyzer
 * @see ComponentsUpdater
 * @since Oct 16, 2025
 */
public class AnalyzerController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private Write write;
    private Analyzer analyzer;
    private JFAnalyzer jFAnalyzer;
    private ComponentsUpdater componentsUpdater;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public AnalyzerController(JFAnalyzer jFLexicalAnalyzer) {
        this.jFAnalyzer = jFLexicalAnalyzer;
        this.analyzer = new Analyzer();
        this.componentsUpdater = new ComponentsUpdater(jFAnalyzer);
        this.write = new Write(jFAnalyzer);
    }

    // SPECIFIC METHODS --------------------------------------------------------
    /**
     * Method responsible for analyzing the entire text, separating the text
     * into a list of lines and analyzing line by line and updating the view
     */
    public void analyze() {
        int rows = 0;
        //1. Travel all lines
        for (String line : componentsUpdater.getLines()) {
            try {
                //2. Analyze line by line (and add his row)
                analyzer.analyze(line, rows++);

            } catch (IOException e) {
                //3. Show error
                jFAnalyzer.showMessage("ANALYZER ERROR", e.getMessage());
            }
        }

        //4. Show analyzed words
        analyzer.printWords();
        analyzer.printVariables();

        //5. Update components
        componentsUpdater.updateTextPane(jFAnalyzer.getJtpText(), analyzer.getOutputLines());
        write.print(analyzer.getValues());
    }

    /**
     * Method responsible for resetting the word list so that words do not
     * accumulate
     */
    public void restartAnalysis() {
        analyzer.restartAnalysis();
    }

    // GETTERS -----------------------------------------------------------------
    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public JFAnalyzer getjFAnalyzer() {
        return jFAnalyzer;
    }

    public ComponentsUpdater getComponentsUpdater() {
        return componentsUpdater;
    }

}
