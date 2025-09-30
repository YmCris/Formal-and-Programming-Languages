package ymcris.lexicalanalyzer.model.word.tokens;

/**
 * The enum TokenType is the enum responsible for representing the toyen's
type
 *
 * @author YmCris
 * @since Sep 29, 2025
 */
public enum TokenType {

    // ENUMS -------------------------------------------------------------------
    RESERVED_WORD("Palabra Reservada", "AZUL", 0),
    IDENTIFIER("Identificador", "CAFE", 1),
    STRING("Cadena", "NARANJA", 2),
    NUMBER("Numero", "VERDE", 3),
    DECIMAL("Decimal", "NEGRO", 4),
    LINE_COMMENT("Comentario de Linea", "VERDE_OSCURO", 5),
    BLOCK_COMMENT("Comentario de Bloque", "VERDE_OSCURO", 6),
    ARITHMETIC_OPERATOR("Operador Aritmetico", "AMARILLO", 7),
    PUNCTUATION_MARKS("Signo de Puntuacion", "BLANCO", 8),
    GROUPING_MARKS("Signo de Agrupacion", "MORADO", 9),
    ERROR("Error", "ROJO", 10);

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private int number;

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private String name;
    private String color;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    private TokenType(String name, String color, int number) {
        this.name = name;
        this.color = color;
        this.number = number;
    }

    // GETTERS -----------------------------------------------------------------
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

}
