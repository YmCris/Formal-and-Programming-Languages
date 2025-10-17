package ymcris.parser.controller.reports;

import java.util.ArrayList;
import ymcris.parser.model.word.Word;
import ymcris.parser.model.word.tokens.Token;
import ymcris.parser.view.analyzer.JFAnalyzer;

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
    private ArrayList<Word> errors;
    private ArrayList<Token> lexemes;
    private ArrayList<Token> reportTokens;
    private JFAnalyzer jFLexicalAnalyzer;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public ReportsController(JFAnalyzer jFLexicalAnalyzer) {
        this.jFLexicalAnalyzer = jFLexicalAnalyzer;
        this.errors = new ArrayList<>();
        this.reportTokens = new ArrayList<>();
        this.lexemes = new ArrayList<>();
        this.errors = jFLexicalAnalyzer.getAnalyzerController().getErrors();
        this.reportTokens = jFLexicalAnalyzer.getAnalyzerController().getTokensReports();
    }

    // SPECIFIC METHODS --------------------------------------------------------
    // GETTERS -----------------------------------------------------------------
    public ArrayList<Word> getErrors() {
        return errors;
    }

    public ArrayList<Token> getReportTokens() {
        return reportTokens;
    }

    public ArrayList<Token> getLexemes() {
        return lexemes;
    }

    public JFAnalyzer getjFLexicalAnalyzer() {
        return jFLexicalAnalyzer;
    }

    // SETTERS -----------------------------------------------------------------
    public void setErrors(ArrayList<Word> errors) {
        this.errors = errors;
    }

    public void setReportTokens(ArrayList<Token> reportTokens) {
        this.reportTokens = reportTokens;
    }

    public void setLexemes(ArrayList<Token> lexemes) {
        this.lexemes = lexemes;
    }

}
