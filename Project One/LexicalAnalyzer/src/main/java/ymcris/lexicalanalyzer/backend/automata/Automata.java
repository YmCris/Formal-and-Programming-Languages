package ymcris.lexicalanalyzer.backend.automata;

import java.util.ArrayList;
import ymcris.lexicalanalyzer.backend.language.Language;
import ymcris.lexicalanalyzer.model.word.tokens.Token;
import ymcris.lexicalanalyzer.model.word.tokens.TokenType;

/**
 * The Automata class is the class responsible for be the automata for the
 * analyzer
 *
 * @author YmCris
 * @see Token
 * @see TokenType
 * @since Sep 29, 2025
 */
public class Automata {

    // CONSTANTS ---------------------------------------------------------------
    // COLUMNS
    // 0: dígitos    1: letras    2: punto decimal     3: special character
    // 4: punctuation marks      5: grouping marks         6: arithmetic operator
    private static final int DIGIT = 0;
    private static final int LETTER = 1;
    private static final int DOT = 2;
    private static final int SPACE = 3;
    private static final int QUOTE = 4;
    private static final int SLASH = 5;
    private static final int SPECIAL_CHARACTER = 6;
    private static final int PUNCTUATION_MARKS = 7;
    private static final int GROUPING_MARKS = 8;
    private static final int ARITHMETIC_OPERATOR = 9;
    // STATES
    private static final int STATE_ZERO = 0;
    private static final int STATE_ONE = 1;
    private static final int STATE_TWO = 2;
    private static final int STATE_THREE = 3;
    private static final int STATE_FOUR = 4;

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<Token> tokens = new ArrayList<>();

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private int currentStatus = 0;
    private int previusStatus = 0;

    /**
     * Matriz de transicion de 5 estados (filas) y 7 tipos de simbolos
     * (columnas)
     */
    private int[][] transitions = new int[5][10];// x = states y = symbols

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Automata() {
        // Estado 0: inicio
        transitions[STATE_ZERO][DIGIT] = 1; // dígito → estado 1 (inicio de número)
        transitions[STATE_ZERO][LETTER] = 4; // letra → estado 4 (inicio de identificador)
        transitions[STATE_ZERO][DOT] = -1; // punto → error

        // Estado 1: número entero
        transitions[STATE_ONE][DIGIT] = 1; // dígito → sigue siendo entero
        transitions[STATE_ONE][LETTER] = 1; // letra → sigue (error semántico, pero lo acepta)
        transitions[STATE_ONE][DOT] = 2; // punto → posible decimal

        // Estado 2: después del punto
        transitions[STATE_TWO][DIGIT] = 3; // dígito → decimal válido
        transitions[STATE_TWO][LETTER] = -1; // letra → error
        transitions[STATE_TWO][DOT] = -1; // punto → error

        // Estado 3: decimal
        transitions[STATE_THREE][DIGIT] = 3; // dígito → sigue siendo decimal
        transitions[STATE_THREE][LETTER] = -1; // letra → error
        transitions[STATE_THREE][DOT] = -1; // punto → error

        // Estado 4: identificador
        transitions[STATE_FOUR][DIGIT] = 4; // dígito → sigue siendo identificador
        transitions[STATE_FOUR][LETTER] = 4; // letra → sigue siendo identificador
        transitions[STATE_FOUR][DOT] = -1; // punto → error
    }

    // SPECIFIC METHODS --------------------------------------------------------
    /**
     * Este método recorre el texto carácter por carácter y simula el autómata.
     *
     * @param text
     */
    public void analyze(String text) {
        String lexeme = "";
        int column = 0;
        for (int i = 0; i < text.length(); i++) {
            //1. Clasifica el carácter como dígito, letra, punto o espacio.
            char character = text.charAt(i);
            int type = getCharacterType(character);
            if (type != 3) {
                lexeme = lexeme + character;
            }
            //2. Acumula el lexema mientras no sea espacio.
            if (type == 3) {// are two words in one text
                //2.1 Espacio: separamos tokens
                restartAutomata(lexeme, i);
                lexeme = "";
            } else if (type == -1) {
                //3 Carácter inválido
                System.out.println("ERROR EL CARACTER NO ESTA EN EL ALFABETO");
                currentStatus = -1;
                restartAutomata(lexeme, i);
                lexeme = "";
            } else {
                //4. Transición válida
                previusStatus = currentStatus;
                currentStatus = transitions[currentStatus][type];
                if (currentStatus == -1) {
                    //5. Transición inválida
                    System.out.println("ERROR");
                    restartAutomata(lexeme, i);
                    lexeme = "";
                } else {
                    //6. Movimiento válido
                    System.out.println("me movi del estado: " + previusStatus
                            + " al estado: " + currentStatus + " con un: "
                            + character);
                }
            }
            column = i;
        }
        //7. Al final del texto, se analiza el último lexema acumulado:
        restartAutomata(lexeme, column);
        printTokens();
        tokens = new ArrayList<>();
    }

    /**
     * Si el lexema no está vacío, se crea un token y se reinicia el autómata.
     *
     * @param lexeme
     * @param column
     */
    public void restartAutomata(String lexeme, int column) {
        System.out.println("LEXEME: " + lexeme);
        if (!lexeme.equals("")) {
            Token newToken = new Token(lexeme, getTokenType(currentStatus, lexeme), 0, column);
            tokens.add(newToken);
            currentStatus = 0;
            previusStatus = 0;
        }
    }

    /**
     * Determina el tipo de token según el estado final alcanzado.
     *
     * @param currenStatus
     * @param lexeme
     * @return
     */
    public TokenType getTokenType(int currenStatus, String lexeme) {
        switch (currenStatus) {
            case -1 -> {
                return TokenType.ERROR;
            }
            case 1 -> {
                return TokenType.NUMBER;
            }
            case 3 -> {
                return TokenType.DECIMAL;
            }
            case 4 -> {
                return verifyReservedWord(lexeme);
            }
            default -> {
            }
        }
        return TokenType.ERROR;
    }

    /**
     * Si el lexema coincide con una palabra reservada, se clasifica como tal.
     * Si no, es identificador.
     *
     * @param lexeme
     * @return
     */
    public TokenType verifyReservedWord(String lexeme) {
        for (String reservedWord : Language.RESERVED_WORDS) {
            if (lexeme.equals(reservedWord)) {
                return TokenType.RESERVED_WORD;
            }
        }
        return TokenType.IDENTIFIER;
    }

    public void printTokens() {
        System.out.println("TOKENS ENCONTRADOS");
        for (Token token : tokens) {
            System.out.println("Lexema: " + token.getLexeme()
                    + " token type: " + token.getTokenType());
        }
    }

    /**
     * Clasifica el carácter para usarlo en la matriz de transición.
     *
     * @param character
     * @return
     */
    public int getCharacterType(char character) {
        int value = -1;
        if (Character.isDigit(character)) {
            return 0;
        }
        if (Character.isLetter(character)) {
            return 1;
        }
        if (character == '.') {
            return 2;
        }
        if (Character.isWhitespace(character)) {
            return 3;
        }
        return value;
    }
}
