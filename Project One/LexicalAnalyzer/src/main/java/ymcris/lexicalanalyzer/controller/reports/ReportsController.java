package ymcris.lexicalanalyzer.controller.reports;

import java.util.ArrayList;
import ymcris.lexicalanalyzer.model.word.Word;
import ymcris.lexicalanalyzer.model.word.tokens.Token;
import ymcris.lexicalanalyzer.view.analyzer.JFLexicalAnalyzer;

/**
 * The ReportsController class is the class responsible for be the controller's
 * reports
 *
 * @author YmCris
 * @since Oct 1, 2025
 */
public class ReportsController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<Word> errors;
    private ArrayList<Token> lexemes;
    private ArrayList<Token> reportTokens;
    private JFLexicalAnalyzer jFLexicalAnalyzer;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public ReportsController(JFLexicalAnalyzer jFLexicalAnalyzer) {
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

    public JFLexicalAnalyzer getjFLexicalAnalyzer() {
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
