package ymcris.parser.model.word.tokens;

import ymcris.parser.model.word.Word;

/**
 * The Token class is the class responsible for representing a token
 *
 * @author YmCris
 * @see Word
 * @since Oct 16, 2025
 */
public class Token extends Word {

    // REFERENCE VARIABLES -----------------------------------------------------
    private TokenType tokenType;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Token(String lexeme, TokenType tokenType, int row, int column) {
        super(lexeme, row, column, true);
        this.tokenType = tokenType;
        this.setColor(tokenType.getColor());
    }
    
    // SPECIFIC METHODS --------------------------------------------------------
    // GETTERS -----------------------------------------------------------------
    public TokenType getTokenType() {
        return tokenType;
    }

    // SETTERS -----------------------------------------------------------------
    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

}
