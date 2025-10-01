package ymcris.lexicalanalyzer.model.word.errors;

import ymcris.lexicalanalyzer.model.word.Word;

/**
 * The Error class is the class responsible for
 *
 * @author YmCris
 * @since Sep 30, 2025
 */
public class Error extends Word {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String description;
    private ErrorType errorType;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Error(String lexeme, int row, int column, boolean isToken, String description, ErrorType errorType) {
        super(lexeme, row, column, isToken);
        this.description = description;
        this.errorType = errorType;
    }

    // GETTERS -----------------------------------------------------------------
    public String getDescription() {
        return description;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    // SETTERS -----------------------------------------------------------------
    public void setDescription(String description) {
        this.description = description;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

}
