package ymcris.lexicalanalyzer.controller;

import java.util.ArrayList;
import ymcris.lexicalanalyzer.backend.File;
import ymcris.lexicalanalyzer.frontend.JFLexicalAnalyzer;

/**
 * The UploadFileController class is the class responsible for be the
 * controlller of upload file.
 *
 * @author YmCris
 * @since Sep 29, 2025
 */
public class UploadFileController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private JFLexicalAnalyzer jFLexicalAnalyzer;
    private ArrayList<String> textLines;
    private File file;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public UploadFileController(JFLexicalAnalyzer analyzer) {
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

    // SETTERS -----------------------------------------------------------------
    public void setTextLines(ArrayList<String> textLines) {
        this.textLines = textLines;
    }

}
