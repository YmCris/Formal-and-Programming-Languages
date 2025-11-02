package ymcris.parser.backend.parser;
// See all parser documentation here -> https://docs.google.com/document/d/1Unn_hdKVNWP-eRf-zg7QK7U1yz4jdrrPSI7KXPFra2Q/edit?tab=t.0#heading=h.p6zle2rgd88w

import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import ymcris.parser.model.word.Word;
import ymcris.parser.model.word.tokens.Token;
import ymcris.parser.model.word.tokens.TokenType;

/**
 * The Parser class is the class responsible for be the parser that the program
 * will use then of use lexer.java, (this syntactic analyzer analyze lines
 * whitout lexical erros)
 *
 * @see Token
 * @see TokenType
 * @author YmCris
 * @since Oct 31, 2025
 */
public class Parser {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String[][] table;
    private List<Word> words;

    private String[] nonTerminals = {"S", "A", "A'", "B", "B'", "C", "D", "E", "F",
        "G", "H", "I", "J", "K", "L", "M", "N"};

    private String[] terminals = {
        "$",//Start Sign
        "identificador",//Identifier
        "entero", "decimal", "cadena", "DEFINIR", "ESCRIBIR", "COMO",//Reserved Words
        "+", "-", "*", "/", "%", "=",//Arithmetic Operators
        ";",//Punctuation Marks
        "(", ")"//Grouping Marks
    };

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private int index = 0;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Parser(List<Word> words) {
        this.words = words;
        this.table = new String[nonTerminals.length][terminals.length];
        initializeTable();
    }

    // SPECIFIC METHODS --------------------------------------------------------
    private void initializeTable() {
        //...................... Initialize all cells ..........................
        for (int i = 0; i < nonTerminals.length; i++) {
            Arrays.fill(table[i], "ERROR");
        }

        // S -> (lista de sentencias) S | ε
        set("S", "DEFINIR", "G S");
        set("S", "identificador", "D S");
        set("S", "entero", "A S");
        set("S", "decimal", "A S");
        set("S", "cadena", "A S");
        set("S", "ESCRIBIR", "K S");
        set("S", "$", "ε");

        //..................... DEFINITION OF VARIABLES ........................
        // G → H
        set("G", "DEFINIR", "H");
        set("G", "$", "H");

        // H → IH | ε
        set("H", "DEFINIR", "I H");
        set("H", "$", "ε");
        //NUEVO
        set("H", ";", "ε");
        set("H", "identificador", "ε");
        set("H", "ESCRIBIR", "ε");

        // I → DEFINIR identificador COMO J ;
        set("I", "DEFINIR", "DEFINIR identificador COMO J ;");

        // J → ( cadena | entero | decimal );
        set("J", "cadena", "cadena");
        set("J", "entero", "entero");
        set("J", "decimal", "decimal");

        //........................... EXPRESSIONS ..............................
        //  A → BA'
        set("A", "identificador", "B A'");
        set("A", "entero", "B A'");
        set("A", "decimal", "B A'");
        set("A", "cadena", "C A'");

        // A' → +BA' | -BA' | ε
        set("A'", "+", "+ B A'");
        set("A'", "-", "- B A'");
        set("A'", ";", "ε");
        set("A'", "$", "ε");
        set("A'", ")", "ε");

        //  B → CB'
        set("B", "identificador", "C B'");
        set("B", "entero", "C B'");
        set("B", "decimal", "C B'");
        set("B'", ")", "ε");

        // B' → *CB' | /CB' | ε
        set("B'", "*", "* C B'");
        set("B'", "/", "/ C B'");
        set("B'", "+", "ε");
        set("B'", "-", "ε");
        set("B'", ";", "ε");
        set("B'", "$", "ε");

        //  C → identificador | entero | decimal
        set("C", "identificador", "identificador");
        set("C", "entero", "entero");
        set("C", "decimal", "decimal");
        set("C", "cadena", "cadena");

        //.................. ASSIGNING VALUES TO VARIABLES .....................
        // D → E
        set("D", "identificador", "E");
        set("D", "$", "E");

        // E → FE | ε
        set("E", "identificador", "F E");
        set("E", "$", "ε");

        // F → identicador = A;
        set("F", "identificador", "identificador = A ;");

        //......................... WRITE FUNCTION .............................
        // K → L
        set("K", "ESCRIBIR", "L");
        set("K", "$", "L");

        // L → ML | ε
        set("L", "ESCRIBIR", "M L");
        set("L", "$", "ε");

        // M → ESCRIBIR ( N );
        set("M", "ESCRIBIR", "ESCRIBIR ( N ) ;");

        // N → cadena | entero | decimal | identificador
        set("N", "cadena", "A");
        set("N", "entero", "A");
        set("N", "decimal", "A");
        set("N", "identificador", "A");
        set("N", ")", "ε");

    }

    private void set(String nonTerminal, String terminal, String production) {
        int i = indexOf(nonTerminals, nonTerminal);
        int j = indexOf(terminals, terminal);
        if (i != -1 && j != -1) {
            table[i][j] = production;
        }
    }

    // FUNCTIONS ---------------------------------------------------------------
    private int indexOf(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    private String lookAhead() {
        if (index < words.size()) {
            Word word = words.get(index);
            if (word instanceof Token token) {
                System.out.println("token: " + token.getLexeme() + " type: " + token.getTokenType());
                return mapToken(token.getTokenType());
            }
        }
        return "$";
    }

    private String mapToken(TokenType type) {
        return switch (type) {
            case IDENTIFIER ->
                "identificador";
            case EQUALS ->
                "=";
            case NUMBER ->
                "entero";
            case DECIMAL ->
                "decimal";
            case STRING ->
                "cadena";
            case PLUS ->
                "+";
            case MINUS ->
                "-";
            case MULTIPLY ->
                "*";
            case DIVIDE ->
                "/";
            case SEMICOLON ->
                ";";
            case DEFINE ->
                "DEFINIR";
            case HOW ->
                "COMO";
            case WRITE ->
                "ESCRIBIR";
            case OPENING_PARENTHESES ->
                "(";
            case CLOSING_PARENTHESES ->
                ")";
            case RESERVED_WORD_STRING ->
                "cadena";
            case RESERVED_WORD_INTEGER ->
                "entero";
            case RESERVED_WORD_DECIMAL ->
                "decimal";
            case LINE_COMMENT ->
                "$";
            case BLOCK_COMMENT ->
                "$";
            case ERROR ->
                "ERROR";//$
            default -> {
                System.out.println("mapToken: token no mapeado -> " + type);
                yield "ERROR";
            }
        };
    }

    public boolean parse() {
        Stack<String> stack = new Stack<>();// LIFO
        // push = insertar | peek = obtener el ultimo sin eliminarlo | pop = peek pero elimina
        stack.push("$");
        stack.push("S");
        System.out.println("\n".repeat(2));
        System.out.printf("%-45s %-20s %-30s%n", "PILA", "ENTRADA", "ACCIÓN");
        System.out.println("--------------------------------------------------------------------------------------");

        while (!stack.isEmpty()) {

            String top = stack.peek();
            String currentToken = lookAhead();

            System.out.printf("%-45s %-20s ", stack.toString(), currentToken);
            if (isTerminal(top)) {
                if (top.equals(currentToken)) {
                    stack.pop();
                    index++;
                    System.out.println("match(" + currentToken + ")");
                } else {
                    System.out.println("Error: se esperaba " + top + " pero llegó " + currentToken);
                    return false;
                }
            } else {
                int i = indexOf(nonTerminals, top);
                int j = indexOf(terminals, currentToken);
                if (i == -1 || j == -1) {
                    System.out.println(" Error: símbolo no reconocido");
                    return false;
                }

                String produccion = table[i][j];
                if (produccion.equals("ERROR")) {
                    System.out.println("Error: no hay regla para [" + top + ", " + currentToken + "]");
                    return false;
                }

                stack.pop();

                if (!produccion.equals("ε")) {
                    String[] symbols = produccion.trim().split("\\s+");
                    for (int k = symbols.length - 1; k >= 0; k--) {
                        stack.push(symbols[k]);
                    }
                }

                System.out.println(top + " -> " + produccion);
            }
        }

        System.out.println("\n Análisis sintáctico exitoso");
        return true;
    }

    private boolean isTerminal(String symbol) {
        return Arrays.asList(
                "$",//Start Sign
                "identificador",//Identifier
                "entero", "decimal", "cadena", "DEFINIR", "ESCRIBIR", "COMO",//Reserved Words
                "+", "-", "*", "/", "%", "=",//Arithmetic Operators
                ";",//Punctuation Marks
                "(", ")"//Grouping Marks
        ).contains(symbol);
    }

}
