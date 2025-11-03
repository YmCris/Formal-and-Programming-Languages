package ymcris.parser.backend.exceptions;

/**
 * The NonExistentVariableException class is the class responsible for show that
 * some variable is'nt exists
 *
 * @author YmCris
 * @since Nov 2, 2025
 */
public class NonExistentVariableException extends Exception {

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public NonExistentVariableException(String message) {
        super(message);
    }
}
