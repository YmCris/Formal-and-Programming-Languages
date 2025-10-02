package ymcris.lexicalanalyzer.backend.automata;

import java.util.ArrayList;
import ymcris.lexicalanalyzer.model.word.Word;
import ymcris.lexicalanalyzer.model.word.tokens.Token;
import ymcris.lexicalanalyzer.backend.language.Language;
import ymcris.lexicalanalyzer.model.word.tokens.TokenType;
import ymcris.lexicalanalyzer.controller.analyzer.AnalyzerController;

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
    // ENTERIES (COLUMNS)
    private static final int ERROR = -1;
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
    private static final int NEWLINE = 10; // agrega al final de tus columnas

    // STATES (ROWS)
    private static final int STATE_ZERO = 0;
    private static final int STATE_ONE = 1;
    private static final int STATE_TWO = 2;
    private static final int STATE_THREE = 3;
    private static final int STATE_FOUR = 4;
    private static final int STATE_FIVE = 5;
    private static final int STATE_SIX = 6;
    private static final int STATE_SEVEN = 7;
    private static final int STATE_EIGHT = 8;
    private static final int STATE_NINE = 9;
    private static final int STATE_TEN = 10;
    private static final int STATE_ELEVEN = 11;
    private static final int STATE_STRING_END = 12;
    private static final int STATE_COMMENT_ASTERISK = 13;
    private static final int STATE_ERROR_ABSORB = 14;

    // REFERENCE VARIABLES -----------------------------------------------------
    private Language language = new Language();
    private AnalyzerController analyzerController;
    private ArrayList<Word> words = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private int currentStatus = 0;
    private int previusStatus = 0;
    public boolean isChain = false;
    private int[][] transitions = new int[15][11];

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Automata(AnalyzerController analyzerController) {
        this.analyzerController = analyzerController;
        // state 0: start
        transitions[STATE_ZERO][DIGIT] = STATE_ONE;
        transitions[STATE_ZERO][LETTER] = STATE_FOUR;
        transitions[STATE_ZERO][DOT] = ERROR;
        transitions[STATE_ZERO][PUNCTUATION_MARKS] = STATE_FIVE;
        transitions[STATE_ZERO][GROUPING_MARKS] = STATE_SIX;
        transitions[STATE_ZERO][ARITHMETIC_OPERATOR] = STATE_SEVEN;
        transitions[STATE_ZERO][QUOTE] = STATE_EIGHT;
        transitions[STATE_ZERO][SLASH] = STATE_NINE;

        // state 1: integer
        transitions[STATE_ONE][DIGIT] = STATE_ONE;
        transitions[STATE_ONE][DOT] = STATE_TWO;
        transitions[STATE_ONE][LETTER] = ERROR;

        // state 2: before dot
        transitions[STATE_TWO][DIGIT] = STATE_THREE;
        transitions[STATE_TWO][DOT] = ERROR;
        transitions[STATE_TWO][LETTER] = ERROR;

        // state 3: decimal
        transitions[STATE_THREE][DIGIT] = STATE_THREE;
        transitions[STATE_THREE][DOT] = STATE_ERROR_ABSORB;
        transitions[STATE_THREE][LETTER] = ERROR;

        // state 4: identifier
        transitions[STATE_FOUR][DIGIT] = STATE_FOUR;
        transitions[STATE_FOUR][LETTER] = STATE_FOUR;
        transitions[STATE_FOUR][DOT] = STATE_ERROR_ABSORB;

        // state 5: punctuation
        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_FIVE][c] = ERROR;
        }

        // state 6: grouping
        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_SIX][c] = ERROR;
        }

        // state 7: operator
        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_SEVEN][c] = ERROR;
        }

        // satate 8: string
        transitions[STATE_EIGHT][QUOTE] = STATE_STRING_END;
        transitions[STATE_EIGHT][DIGIT] = STATE_EIGHT;
        transitions[STATE_EIGHT][LETTER] = STATE_EIGHT;
        transitions[STATE_EIGHT][SPACE] = STATE_EIGHT;
        transitions[STATE_EIGHT][SPECIAL_CHARACTER] = STATE_EIGHT;
        transitions[STATE_EIGHT][DOT] = STATE_EIGHT;
        transitions[STATE_EIGHT][PUNCTUATION_MARKS] = STATE_EIGHT;
        transitions[STATE_EIGHT][GROUPING_MARKS] = STATE_EIGHT;
        transitions[STATE_EIGHT][ARITHMETIC_OPERATOR] = STATE_EIGHT;

        // state 9: line commentary
        transitions[STATE_NINE][SLASH] = STATE_TEN;
        transitions[STATE_NINE][ARITHMETIC_OPERATOR] = STATE_SEVEN;
        transitions[STATE_NINE][SPECIAL_CHARACTER] = STATE_ELEVEN;

        // state 10: line comment
        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_TEN][c] = STATE_TEN;
        }
        transitions[STATE_TEN][NEWLINE] = STATE_ZERO;

        // state 11: block commenter
        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_ELEVEN][c] = STATE_ELEVEN;
        }
        transitions[STATE_ELEVEN][ARITHMETIC_OPERATOR] = STATE_COMMENT_ASTERISK;

        // state 13: end block commenter
        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_COMMENT_ASTERISK][c] = STATE_ELEVEN;
        }
        transitions[STATE_COMMENT_ASTERISK][SLASH] = STATE_STRING_END;

        for (int c = 0; c < transitions[STATE_ZERO].length; c++) {
            transitions[STATE_ERROR_ABSORB][c] = STATE_ERROR_ABSORB;
        }

    }

    // SPECIFIC METHODS --------------------------------------------------------
    public ArrayList<Word> analyze(String text, int row) {
        String lexeme = "";
        int column = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int type = getCharacterType(character);
            if (type == SPACE) {
                if (currentStatus == STATE_EIGHT || currentStatus == STATE_STRING_END) {
                    lexeme = lexeme + character;
                } else {
                    restartAutomata(lexeme, i, row);
                    lexeme = "";
                }
            } else if (currentStatus == STATE_TEN) {
                lexeme += character;
                if (type == NEWLINE) {
                    restartAutomata(lexeme, i, row);
                    lexeme = "";
                    currentStatus = STATE_TEN;
                }
                continue;
            } else if (type == ERROR) {
                currentStatus = ERROR;
                restartAutomata(lexeme, i, row);
                lexeme = "";
                currentStatus = STATE_ZERO;
            } else {
                previusStatus = currentStatus;
                if (currentStatus == ERROR) {
                    restartAutomata(lexeme, i - 1, row);
                    lexeme = "" + character;
                    currentStatus = transitions[STATE_ZERO][type];
                    continue;
                }
                int nextStatus = transitions[currentStatus][type];
                if (nextStatus == ERROR) {
                    restartAutomata(lexeme, i - 1, row);
                    lexeme = "" + character;
                    currentStatus = transitions[STATE_ZERO][type];
                } else {
                    currentStatus = nextStatus;
                    messages.add("Me movi del estado: " + previusStatus
                            + " al estado: " + currentStatus + " con: "
                            + character);
                    lexeme = lexeme + character;

                    if (currentStatus == STATE_STRING_END) {
                        restartAutomata(lexeme, i, row);
                        lexeme = "";
                        currentStatus = STATE_ZERO;
                    }
                }
            }
            column = i;
        }
        if (currentStatus == STATE_TEN && !lexeme.isEmpty()) {
            restartAutomata(lexeme, column, row);
            lexeme = "";
            currentStatus = STATE_ZERO;
        }
        restartAutomata(lexeme, column, row);
        analyzerController.setWords(words);
        return words;
    }

    public void restartAutomata(String lexeme, int column, int row) {
        if (!lexeme.equals("")) {
            Token newToken = new Token(lexeme, getTokenType(currentStatus, lexeme), row, column);
            if (currentStatus == STATE_TEN) {
                newToken.setColor(TokenType.LINE_COMMENT.getColor());
            }
            words.add(newToken);
            currentStatus = STATE_ZERO;
            previusStatus = STATE_ZERO;
            messages.add("Guardando el token del tipo " + newToken.getTokenType().getName() + " lexema: " + newToken.getLexeme());
        }
        messages.add("Reiniciando el automata");
        isChain = false;
    }

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
            case 5 -> {
                return TokenType.PUNCTUATION_MARKS;
            }
            case 6 -> {
                return TokenType.GROUPING_MARKS;
            }
            case 7 -> {
                return TokenType.ARITHMETIC_OPERATOR;
            }
            case 8 -> {
                return TokenType.STRING;
            }
            case 10 -> {
                return TokenType.LINE_COMMENT;
            }
            case 11 -> {
                return TokenType.BLOCK_COMMENT;
            }
            case 12 -> {
                isChain = true;
                return TokenType.STRING;
            }
            case 14 -> {
                return TokenType.ERROR;
            }
            default -> {
            }
        }
        return TokenType.ERROR;
    }

    public TokenType verifyReservedWord(String lexeme) {
        for (String reservedWord : Language.RESERVED_WORDS) {
            if (lexeme.equals(reservedWord)) {
                return TokenType.RESERVED_WORD;
            }
        }
        return TokenType.IDENTIFIER;
    }

    public int getCharacterType(char character) {
        int value = ERROR;
        if (Character.isDigit(character)) {
            return DIGIT;
        }
        if (language.characterIsInTheAlphabet(character)) {
            return LETTER;
        }
        if (character == '.') {
            return DOT;
        }
        if (Character.isWhitespace(character)) {
            return SPACE;
        }
        if (character == '"') {
            return QUOTE;
        }
        if (character == '/') {
            return SLASH;
        }
        if (language.characterIsSpecial(character)) {
            return SPECIAL_CHARACTER;
        }
        if (language.characterIsPunctuationMark(character)) {
            return PUNCTUATION_MARKS;
        }
        if (language.characterIsGroupingMark(character)) {
            return GROUPING_MARKS;
        }
        if (language.characterIsArithmeticOperator(character)) {
            return ARITHMETIC_OPERATOR;
        }
        if (character == '\n') {
            return NEWLINE;
        }
        return value;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

}
