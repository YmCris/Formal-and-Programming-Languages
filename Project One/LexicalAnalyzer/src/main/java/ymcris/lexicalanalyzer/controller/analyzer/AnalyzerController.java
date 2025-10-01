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
import ymcris.lexicalanalyzer.backend.automata.Automata;
import ymcris.lexicalanalyzer.model.word.tokens.Token;
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
    private ArrayList<String> lines;

    private ArrayList<Word> words;

    private ArrayList<Word> errores;
    private ArrayList<Word> tokensReportes;
    private JFLexicalAnalyzer jFLexicalAnalyzer;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private int cantidadErrores = 0;
    private int tokensValidos = 0;
    public boolean analisisRealizado = false;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public AnalyzerController(JFLexicalAnalyzer jFLexicalAnalyzer) {
        this.jFLexicalAnalyzer = jFLexicalAnalyzer;
        this.lines = new ArrayList<>();
        this.errores = new ArrayList<>();
        this.words = new ArrayList<>();
        this.tokensReportes = new ArrayList<>();
        this.automata = new Automata(this);
    }

    // SPECIFIC METHODS --------------------------------------------------------
    public void updateLines() {
        lines.clear();
        String text = jFLexicalAnalyzer.getJtpText().getText();
        String[] textLines = text.split("\\n");
        this.lines.addAll(Arrays.asList(textLines));
    }

    private void insertarToken(JTextPane jtpText, Word word) throws BadLocationException {
        StyledDocument doc = jtpText.getStyledDocument();
        String color = word.getColor();
        Style style = jtpText.addStyle("tokenStyle", null);
        System.out.println("Soy la palabra " + word.getLexeme() + " mi color es " + color);
        if (word.getLexeme().equals("\n")) {
            doc.insertString(doc.getLength(), "\n", null);
            return;
        }
        switch (color) {
            case "AZUL" -> {// palabras reservadas
                StyleConstants.setForeground(style, Color.BLUE);
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "CAFE" -> {// identificadores
                StyleConstants.setForeground(style, new Color(139, 69, 19));
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "VERDE" -> {// números
                StyleConstants.setForeground(style, Color.GREEN);
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "NARANJA" -> {// cadena
                StyleConstants.setForeground(style, Color.ORANGE);
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "NEGRO" -> {// decimales
                StyleConstants.setForeground(style, Color.BLACK);
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "VERDE_OSCURO" -> {// comentarios de línea o bloque
                StyleConstants.setForeground(style, Color.CYAN);
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "AMARILLO" -> { // operadores
                StyleConstants.setForeground(style, Color.YELLOW);
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "MORADO" -> { // agrupación
                StyleConstants.setForeground(style, new Color(128, 0, 128));
                tokensValidos++;
                tokensReportes.add(word);
            }
            case "ROJO" -> { // errores
                StyleConstants.setForeground(style, Color.RED);
                errores.add(word);
                cantidadErrores++;
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
                insertarToken(jtpText, word);
            }
            doc.insertString(doc.getLength(), "\n", null);
        } catch (BadLocationException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al mostrar los tokens en el pane porque " + e.getMessage());
            e.printStackTrace();
        }
        analisisRealizado = true;
    }

    public void analizar() {
        words.clear();
        for (String line : lines) {
            automata.analyze(line);
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

    // SETTERS -----------------------------------------------------------------
    public void setLines(ArrayList<String> textLines) {
        this.lines = textLines;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

}
