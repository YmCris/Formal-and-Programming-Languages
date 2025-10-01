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
    public static final char[] ARITHMETIC_OPERATORS = {'+', '-', '*', '/', '%', '='};
    public static final String[] COMMENTS = {"//", "/*", "*/"};
    public static final String[] RESERVED_WORDS = {
        "SI", "si", "ENTONCES", "entonces", "PARA", "para", "ESCRIBIR", "escribir"
    };

    // SPECIFIC METHODS --------------------------------------------------------
    private boolean characterIsInTheArray(char[] characters, char character) {
        for (char c : characters) {
            if (c == character) {
                return true;
            }
        }
        return false;
    }

    private boolean numberIsInTheArray(int[] characters, char character) {
        for (int c : characters) {
            if (c == Integer.valueOf(character)) {
                return true;
            }
        }
        return false;
    }

    private boolean stringIsInTheArray(String[] strings, String string) {
        for (String s : strings) {
            if (s.equals(string)) {
                return true;
            }
        }
        return false;
    }

    public boolean characterIsInTheAlphabet(char character) {
        return characterIsInTheArray(ALPHABET, character);
    }

    public boolean characterIsSpecial(char character) {
        return characterIsInTheArray(SPECIAL_CHARACTERS, character);
    }

    public boolean characterIsDigit(char character) {
        return numberIsInTheArray(DIGITS, character);
    }

    public boolean characterIsPunctuationMark(char character) {
        return characterIsInTheArray(PUNCTUATION_MARKS, character);

    }

    public boolean characterIsGroupingMark(char character) {
        return characterIsInTheArray(GROUPING_MARKS, character);
    }

    public boolean characterIsArithmeticOperator(char character) {
        return characterIsInTheArray(ARITHMETIC_OPERATORS, character);
    }

    public boolean stringIsReservedWord(String string) {
        return stringIsInTheArray(RESERVED_WORDS, string);
    }

}
