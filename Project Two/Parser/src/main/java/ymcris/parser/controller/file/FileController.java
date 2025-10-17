package ymcris.parser.controller.file;

import java.util.ArrayList;
import ymcris.parser.backend.file.File;
import ymcris.parser.view.analyzer.JFAnalyzer;

/**
 * The FileController class is the class responsible for be the controlller of
 * upload file.
 *
 * @author YmCris
 * @see File
 * @see JFAnalyzer
 * @since Oct 16, 2025
 */
public class FileController {

    // REFERENCE VARIABLES -----------------------------------------------------
    private File file;
    private String content;
    private ArrayList<String> textLines;
    private JFAnalyzer jFLexicalAnalyzer;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public FileController(JFAnalyzer analyzer) {
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
