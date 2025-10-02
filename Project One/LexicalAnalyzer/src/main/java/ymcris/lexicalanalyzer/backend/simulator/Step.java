package ymcris.lexicalanalyzer.backend.simulator;

import ymcris.lexicalanalyzer.model.word.tokens.TokenType;

/**
 * Clase Step es la clase encargada de
 *
 * @author YmCris
 * @since Oct 2, 2025
 */
public class Step {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private int index;
    private int nextState;
    private int previousState;
    private char readedCharacter;
    private boolean error;
    private boolean finalizedToken;
    private boolean acceptedState;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private TokenType tokenType;
    private String message;
    private String lexemeBefore;
    private String lexemeAfter;

    // GETTERS -----------------------------------------------------------------
    public int getIndex() {
        return index;
    }

    public int getNextState() {
        return nextState;
    }

    public int getPreviousState() {
        return previousState;
    }

    public char getReadedCharacter() {
        return readedCharacter;
    }

    public boolean isError() {
        return error;
    }

    public boolean isFinalizedToken() {
        return finalizedToken;
    }

    public boolean isAcceptedState() {
        return acceptedState;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getMessage() {
        return message;
    }

    public String getLexemeBefore() {
        return lexemeBefore;
    }

    public String getLexemeAfter() {
        return lexemeAfter;
    }

    // SETTERS -----------------------------------------------------------------
    public void setIndex(int index) {
        this.index = index;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }

    public void setPreviousState(int previousState) {
        this.previousState = previousState;
    }

    public void setReadedCharacter(char readedCharacter) {
        this.readedCharacter = readedCharacter;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setFinalizedToken(boolean finalizedToken) {
        this.finalizedToken = finalizedToken;
    }

    public void setAcceptedState(boolean acceptedState) {
        this.acceptedState = acceptedState;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLexemeBefore(String lexemeBefore) {
        this.lexemeBefore = lexemeBefore;
    }

    public void setLexemeAfter(String lexemeAfter) {
        this.lexemeAfter = lexemeAfter;
    }

}
