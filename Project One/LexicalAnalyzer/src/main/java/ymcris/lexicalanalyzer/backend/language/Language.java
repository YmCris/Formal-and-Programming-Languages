package ymcris.lexicalanalyzer.backend.language;

/**
 * The Language class is the class responsible for contain the language's
 * elements
 *
 * @author YmCris
 * @since Sep 30, 2025
 */
public class Language {

    // CONSTANTS ---------------------------------------------------------------
    /**
     * '\t' Tabulación '\n' Salto de línea
     */
    public static final char[] SPECIAL_CHARACTERS = {' ', '\t', '\n'};
    public static final char[] ALPHABET = {
        'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G',
        'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N',
        'ñ', 'Ñ', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T',
        'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'
    };
    public static final int[] DIGITS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final char[] PUNCTUATION_MARKS = {'.', ',', ';', ':'};
    public static final char[] GROUPING_MARKS = {'(', ')', '[', ']', '{', '}'};
    public static final char[] ARITHMETIC_OPERATOR = {'+', '-', '*', '/', '%', '='};
    public static final String[] COMMENTS = {"//", "/*", "*/"};
    public static final String[] RESERVED_WORDS = {
        "SI", "si", "ENTONCES", "entonces", "PARA", "para", "ESCRIBIR", "escribir"
    };

    // SPECIFIC METHODS --------------------------------------------------------
    public boolean characterIsInTheAlphabet(char character) {
        for (char letter : ALPHABET) {
            if (letter == character) {
                return true;
            }
        }
        return false;
    }

    public boolean characterIsSpecial(char character) {
        for (char specialCharacter : SPECIAL_CHARACTERS) {
            if (specialCharacter == character) {
                return true;
            }
        }
        return false;
    }

}
