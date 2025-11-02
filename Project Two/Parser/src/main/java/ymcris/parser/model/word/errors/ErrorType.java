package ymcris.parser.model.word.errors;

/**
 * The enum ErrorType is the enum responsible for representing the error types
 * that exists in the program
 *
 * @author YmCris
 * @since Oct 16, 2025
 */
public enum ErrorType {

    // ENUMS -------------------------------------------------------------------
    GRAMMAR_ERROR("this is a grammar error"),
    INVALID_CHARACTER_ERROR("this is a invalid character");

    // REFERENCE VARIABLES -----------------------------------------------------
    private String description;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    private ErrorType(String description) {
        this.description = description;
    }

    // GETTERS -----------------------------------------------------------------
    public String getDescription() {
        return description;
    }

    // SETTERS -----------------------------------------------------------------
    public void setDescription(String description) {
        this.description = description;
    }

}
