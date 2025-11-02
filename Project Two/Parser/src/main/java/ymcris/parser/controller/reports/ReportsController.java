package ymcris.parser.controller.reports;

import java.util.ArrayList;
import ymcris.parser.model.word.Word;
import ymcris.parser.model.word.tokens.Token;
import ymcris.parser.view.analyzer.JFAnalyzer;
import ymcris.parser.model.word.errors.ErrorWord;

/**
 * The ReportsController class is the class responsible for be the controller's
 * reports
 *
 * @author YmCris
 * @see Token
 * @see JFAnalyzer
 * @since Oct 16, 2025
 */
public class ReportsController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<Token> lexemes;
    private ArrayList<ErrorWord> errors;
    private JFAnalyzer jFLexicalAnalyzer;
    private ArrayList<Token> reportTokens;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public ReportsController(JFAnalyzer jFLexicalAnalyzer) {
        this.jFLexicalAnalyzer = jFLexicalAnalyzer;
        this.errors = new ArrayList<>();
        this.reportTokens = new ArrayList<>();
        this.lexemes = new ArrayList<>();
        this.errors = jFLexicalAnalyzer.getAnalyzerController().getComponentsUpdater().getErrors();
        this.reportTokens = jFLexicalAnalyzer.getAnalyzerController().getComponentsUpdater().getTokensReports();
    }

    // SPECIFIC METHODS --------------------------------------------------------
    // GETTERS -----------------------------------------------------------------
    public ArrayList<Token> getReportTokens() {
        return reportTokens;
    }

    public ArrayList<Token> getLexemes() {
        return lexemes;
    }

    public JFAnalyzer getjFLexicalAnalyzer() {
        return jFLexicalAnalyzer;
    }

    public ArrayList<ErrorWord> getErrors() {
        return errors;
    }

    // SETTERS -----------------------------------------------------------------
    public void setReportTokens(ArrayList<Token> reportTokens) {
        this.reportTokens = reportTokens;
    }

    public void setLexemes(ArrayList<Token> lexemes) {
        this.lexemes = lexemes;
    }

    public void setErrors(ArrayList<ErrorWord> errors) {
        this.errors = errors;
    }

}
