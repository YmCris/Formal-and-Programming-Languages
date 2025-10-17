package ymcris.parser.model.word.errors;

import ymcris.parser.model.word.Word;

/**
 * The Error class is the class responsible for be an error
 *
 * @author YmCris
 * @see Word
 * @since Oct 16, 2025
 */
public class Error extends Word {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String description;
    private ErrorType errorType;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private char errorCharacter;

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

    public char getErrorCharacter() {
        return errorCharacter;
    }

    // SETTERS -----------------------------------------------------------------
    public void setDescription(String description) {
        this.description = description;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public void setErrorCharacter(char errorCharacter) {
        this.errorCharacter = errorCharacter;
    }

}
