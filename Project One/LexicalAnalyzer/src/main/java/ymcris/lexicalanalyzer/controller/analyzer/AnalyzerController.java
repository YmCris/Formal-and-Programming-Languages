package ymcris.lexicalanalyzer.controller.analyzer;

import java.awt.Color;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.BadLocationException;
import ymcris.lexicalanalyzer.model.word.Word;
import ymcris.lexicalanalyzer.model.word.tokens.Token;
import ymcris.lexicalanalyzer.backend.automata.Automata;
import ymcris.lexicalanalyzer.model.word.tokens.TokenType;
import ymcris.lexicalanalyzer.view.analyzer.JFLexicalAnalyzer;

/**
 * The AnalyzerController class is the class responsible for be the lexical
 * analyzer controller, being the responsible to check the enteries, and send
 * information with distins models
 *
 * @author YmCris
 * @since Sep 29, 2025
 */
public class AnalyzerController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private Automata automata;
    private ArrayList<Word> words;
    private ArrayList<String> lines;
    private ArrayList<Word> errors;
    private ArrayList<Token> lexemes;
    private ArrayList<Token> tokensReports;
    private JFLexicalAnalyzer jFLexicalAnalyzer;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    public boolean areErrors = false;
    public boolean analysisPerformed = false;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public AnalyzerController(JFLexicalAnalyzer jFLexicalAnalyzer) {
        this.jFLexicalAnalyzer = jFLexicalAnalyzer;
        this.lines = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.words = new ArrayList<>();
        this.lexemes = new ArrayList<>();
        this.tokensReports = new ArrayList<>();
        this.automata = new Automata(this);
    }

    // SPECIFIC METHODS --------------------------------------------------------
    public void updateLines() {
        lines.clear();
        String text = jFLexicalAnalyzer.getJtpText().getText();
        String[] textLines = text.split("\\n");
        this.lines.addAll(Arrays.asList(textLines));
    }

    private void insertToken(JTextPane jtpText, Word word) throws BadLocationException {
        StyledDocument doc = jtpText.getStyledDocument();
        String color = word.getColor();
        Style style = jtpText.addStyle("tokenStyle", null);
        System.out.println("Soy la palabra " + word.getLexeme() + " mi color es " + color);
        if (word.getLexeme().equals("\n")) {
            doc.insertString(doc.getLength(), "\n", null);
            return;
        }
        Token token = null;
        if (word instanceof Token) {
            token = new Token(word.getLexeme(), TokenType.IDENTIFIER, word.getRow(), word.getColumn());
        }
        switch (color) {
            case "AZUL" -> {// palabras reservadas
                StyleConstants.setForeground(style, Color.BLUE);
                token.setTokenType(TokenType.RESERVED_WORD);
                tokensReports.add(token);
            }
            case "CAFE" -> {// identificadores
                StyleConstants.setForeground(style, new Color(139, 69, 19));
                token.setTokenType(TokenType.IDENTIFIER);
                tokensReports.add(token);
            }
            case "VERDE" -> {// números
                StyleConstants.setForeground(style, Color.GREEN);
                token.setTokenType(TokenType.NUMBER);
                tokensReports.add(token);
            }
            case "NARANJA" -> {// cadena
                StyleConstants.setForeground(style, Color.ORANGE);
                token.setTokenType(TokenType.STRING);
                tokensReports.add(token);
            }
            case "NEGRO" -> {// decimales
                StyleConstants.setForeground(style, Color.BLACK);
                token.setTokenType(TokenType.DECIMAL);
                tokensReports.add(token);
            }
            case "VERDE_OSCURO" -> {// comentarios de línea o bloque
                StyleConstants.setForeground(style, Color.CYAN);
                token.setTokenType(TokenType.LINE_COMMENT);
                tokensReports.add(token);
            }
            case "AMARILLO" -> { // operadores
                StyleConstants.setForeground(style, Color.YELLOW);
                token.setTokenType(TokenType.ARITHMETIC_OPERATOR);
                tokensReports.add(token);
            }
            case "MORADO" -> { // agrupación
                StyleConstants.setForeground(style, new Color(128, 0, 128));
                token.setTokenType(TokenType.GROUPING_MARKS);
                tokensReports.add(token);
            }
            case "ROJO" -> { // errores
                StyleConstants.setForeground(style, Color.RED);
                errors.add(word);
                areErrors = true;
            }
            default ->
                StyleConstants.setForeground(style, Color.BLACK);
        }
        doc.insertString(doc.getLength(), word.getLexeme() + " ", style);
    }

    public void showTokensInTextPane(JTextPane jtpText) {
        StyledDocument doc = jtpText.getStyledDocument();
        try {
            doc.remove(0, doc.getLength());
            for (Word word : words) {
                insertToken(jtpText, word);
            }
            doc.insertString(doc.getLength(), "\n", null);
        } catch (BadLocationException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al mostrar los tokens en el pane porque " + e.getMessage());
            e.printStackTrace();
        }
        analysisPerformed = true;
    }

    public void analyze() {
        words.clear();
        int count = 0;
        for (String line : lines) {
            automata.analyze(line, count++);
            words.add(new Token("\n", TokenType.SPACE, 0, 0));
        }
        showTokensInTextPane(jFLexicalAnalyzer.getJtpText());
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<String> getLines() {
        return lines;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public ArrayList<Word> getErrors() {
        return errors;
    }

    public ArrayList<Token> getTokensReports() {
        return tokensReports;
    }

    public ArrayList<Token> getLexemes() {
        return lexemes;
    }

    public boolean isAreErrors() {
        return areErrors;
    }

    // SETTERS -----------------------------------------------------------------
    public void setLines(ArrayList<String> textLines) {
        this.lines = textLines;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public void setAreErrors(boolean areErrors) {
        this.areErrors = areErrors;
    }

}
