package ymcris.lexicalanalyzer.controller.file;

import java.util.ArrayList;
import ymcris.lexicalanalyzer.backend.file.File;
import ymcris.lexicalanalyzer.view.analyzer.JFLexicalAnalyzer;

/**
 * The FileController class is the class responsible for be the controlller of
 * upload file.
 *
 * @author YmCris
 * @since Sep 29, 2025
 */
public class FileController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private File file;
    private String content;
    private ArrayList<String> textLines;
    private JFLexicalAnalyzer jFLexicalAnalyzer;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public FileController(JFLexicalAnalyzer analyzer) {
        this.jFLexicalAnalyzer = analyzer;
        this.file = new File();
    }

    // SPECIFIC METHODS --------------------------------------------------------
    public void updateTextForFile() {
        StringBuilder builder = new StringBuilder();
        for (String linea : textLines) {
            builder.append(linea);
            builder.append("\n");
        }
        jFLexicalAnalyzer.getJtpText().setText(builder.toString());
    }

    // GETTERS -----------------------------------------------------------------
    public File getFile() {
        return file;
    }

    public String getContent() {
        return content;
    }

    // SETTERS -----------------------------------------------------------------
    public void setTextLines(ArrayList<String> textLines) {
        this.textLines = textLines;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
