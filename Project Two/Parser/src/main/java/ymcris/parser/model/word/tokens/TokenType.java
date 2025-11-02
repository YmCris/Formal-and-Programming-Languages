package ymcris.parser.model.word.tokens;

/**
 * The enum TokenType is the enum responsible for representing the toyen's type
 *
 * @author YmCris
 * @since Oct 16, 2025
 */
public enum TokenType {

    // ENUMS -------------------------------------------------------------------
    /*
      NARANJA = CADENAS
      AZUL = RESERVADAS
      CAFÉ= ID
      VERDE= NÚMEROS
      NEGRO= DECIMALES
      VERDE OSCURO= COM
      AMARRILLO= OPERADOR
      MORADO= AGRUPACIÓN
      ROJO= ERROR
     */
    //STRINGS
    STRING("Cadena", "NARANJA"),
    //RESERVED WORDS
    RESERVED_WORD("palabra reservada", "AZUL"),
    WRITE("ESCRIBIR", "AZUL"),
    DEFINE("DEFINIR", "AZUL"),
    HOW("COMO", "AZUL"),
    RESERVED_WORD_INTEGER("entero","AZUL"),
    RESERVED_WORD_DECIMAL("decimal","AZUL"),
    RESERVED_WORD_STRING("cadena","AZUL"),
    //ID
    IDENTIFIER("Identificador", "CAFE"),
    //NUMBERS
    NUMBER("Numero", "VERDE"),
    //DECIMALS
    DECIMAL("Decimal", "NEGRO"),
    //COMMENTS
    LINE_COMMENT("Comentario de Linea", "VERDE_OSCURO"),
    BLOCK_COMMENT("Comentario de Bloque", "VERDE_OSCURO"),
    //PUNCTUATION
    PUNCTUATION_MARKS("Signo de puntuación","BLANCO"),
    //OPERATOR
    ARITHMETIC_OPERATOR("Operador aritmético","AMARILLO"),
    EQUALS("Igual", "AMARILLO"),
    SEMICOLON("Punto y Coma", "BLANCO"),
    PLUS("Mas", "AMARILLO"),
    MINUS("Menos", "AMARILLO"),
    MULTIPLY("Por", "AMARILLO"),
    MODUL("Por", "AMARILLO"),
    DIVIDE("Divición", "AMARILLO"),
    //AGRUPATION
    GROUPING_MARKS("Signon de agrupación", "MORADO"),
    OPENING_PARENTHESES("(", "MORADO"),
    CLOSING_PARENTHESES(")", "MORADO"),
    //ERROR
    TAB("TAB","ROJO"),
    ERROR("Error", "ROJO");

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private String name;
    private String color;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    private TokenType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // GETTERS -----------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

}
