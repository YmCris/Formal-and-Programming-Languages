package ymcris.parser.model.word.errors;

import ymcris.parser.model.word.Word;

/**
 * The ErrorWord class is the class responsible for be an error
 *
 * @author YmCris
 * @see Word
 * @since Oct 16, 2025
 */
public class ErrorWord extends Word {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String description;
    private ErrorType errorType;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private char errorCharacter;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public ErrorWord(String lexeme, int row, int column, boolean isToken,
            char errorCharacter, ErrorType errorType) {

        super(lexeme, row, column, isToken);

        this.errorCharacter = errorCharacter;
        this.errorType = errorType;
        this.description = errorType.getDescription();
    }

    @Override
    public void print() {
        System.out.println(
                "Lexeme: " + this.getLexeme() + " Error Character: " + errorCharacter
                + " Error type: " + errorType + " Description: " + description
                + " line: " + this.getRow() + " column: " + this.getColumn()
        );
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
