package ymcris.parser.model.word;

/**
 * The Word class is the class responsible for be the word
 *
 * @author YmCris
 * @since Oct 16, 2025
 */
public class Word {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String color;
    private String lexeme;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private int row;
    private int column;
    private boolean token;
    private boolean comment;
    private boolean highlighted;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Word(String lexeme, int row, int column, boolean token) {
        this.lexeme = lexeme;
        this.row = row;
        this.column = column;
        this.token = token;
    }

    public void print() {
        System.out.println("Lexeme: " + this.getLexeme() + " line: " + this.getRow() + " column: " + this.getColumn() + " token: " + token);
    }

    // GETTERS -----------------------------------------------------------------
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isToken() {
        return token;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String getColor() {
        return color;
    }

    public boolean isComment() {
        return comment;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    // SETTERS -----------------------------------------------------------------
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setToken(boolean isToken) {
        this.token = isToken;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

}
