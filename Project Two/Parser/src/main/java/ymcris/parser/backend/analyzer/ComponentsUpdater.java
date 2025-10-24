package ymcris.parser.backend.analyzer;

import java.awt.Color;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import ymcris.parser.model.word.Word;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.BadLocationException;
import ymcris.parser.model.word.tokens.Token;
import ymcris.parser.view.analyzer.JFAnalyzer;
import ymcris.parser.model.word.errors.ErrorWord;

/**
 * The ComponentsUpdater class is the class responsible for
 *
 * @author YmCris
 * @see JFAnalyzer
 * @since Oct 22, 2025
 */
public class ComponentsUpdater {

    // REFERENCE VARIABLES -----------------------------------------------------
    private JFAnalyzer jFAnalyzer;
    private ArrayList<String> lines;
    private ArrayList<ErrorWord> errors;
    private ArrayList<Token> tokensReports;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private boolean areErrors = false;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public ComponentsUpdater(JFAnalyzer jFAnalyzer) {
        this.jFAnalyzer = jFAnalyzer;
        this.lines = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.tokensReports = new ArrayList<>();
    }

    // SPECIFIC METHODS --------------------------------------------------------
    public void updateLines() {
        lines.clear();
        String text = jFAnalyzer.getJtpText().getText();
        String[] textLines = text.split("\\n");
        this.lines.addAll(Arrays.asList(textLines));
    }

    public void updateTextPane(JTextPane jtpText, ArrayList<Word> words) {

        StyledDocument styledDocument = jtpText.getStyledDocument();

        try {

            styledDocument.remove(0, styledDocument.getLength());

            for (Word word : words) {

                insertToken(jtpText, word);

            }

            styledDocument.insertString(styledDocument.getLength(), "\n", null);

        } catch (BadLocationException e) {
            jFAnalyzer.showMessage("ERROR", e.getMessage());
        }

    }

    private void insertToken(JTextPane jtpText, Word word) throws BadLocationException {
        StyledDocument doc = jtpText.getStyledDocument();
        String color = word.getColor();
        Style style = jtpText.addStyle("tokenStyle", null);

        if (word.getLexeme().equals("\n")) {
            doc.insertString(doc.getLength(), "\n", null);
            return;
        }

        if (word instanceof Token token) {
            tokensReports.add(token);
        }

        if (word instanceof ErrorWord error) {
            errors.add(error);
            areErrors = true;
        }

        switch (color) {
            case "AZUL" -> {// palabras reservadas
                StyleConstants.setForeground(style, Color.BLUE);
            }
            case "CAFE" -> {// identificadores
                StyleConstants.setForeground(style, new Color(139, 69, 19));
            }
            case "VERDE" -> {// números
                StyleConstants.setForeground(style, Color.GREEN);
            }
            case "NARANJA" -> {// cadena
                StyleConstants.setForeground(style, Color.ORANGE);
            }
            case "NEGRO" -> {// decimales
                StyleConstants.setForeground(style, Color.BLACK);
            }
            case "VERDE_OSCURO" -> {// comentarios de línea o bloque
                StyleConstants.setForeground(style, Color.CYAN);
            }
            case "AMARILLO" -> { // operadores
                StyleConstants.setForeground(style, Color.YELLOW);
            }
            case "MORADO" -> { // agrupación
                StyleConstants.setForeground(style, new Color(128, 0, 128));
            }
            case "ROJO" -> { // errores
                StyleConstants.setForeground(style, Color.RED);
            }
            default ->
                StyleConstants.setForeground(style, Color.BLACK);
        }
        doc.insertString(doc.getLength(), word.getLexeme() + " ", style);
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<String> getLines() {
        return lines;
    }

    public ArrayList<ErrorWord> getErrors() {
        return errors;
    }

    public ArrayList<Token> getTokensReports() {
        return tokensReports;
    }

    public boolean isAreErrors() {
        return areErrors;
    }

    // SETTERS -----------------------------------------------------------------
    public void setAreErrors(boolean areErrors) {
        this.areErrors = areErrors;
    }
}
