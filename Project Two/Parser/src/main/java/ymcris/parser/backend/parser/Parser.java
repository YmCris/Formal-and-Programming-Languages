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

    private String[] nonTerminals = {"A", "A'", "B", "B'", "C", "D", "E'", "F",
        "G", "H", "I", "J", "K", "L", "M", "N"};

    private String[] terminals = {
        "$",//Start Sign
        "identificador",//Identifier
        "entero", "decimal", "cadena",//Reserved Words
        "+", "-", "*", "/", "%", "=",//Arithmetic Operators
        ";",//Punctuation Marks
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
        // Initialize all cells like errors (Start of analyze)
        for (int i = 0; i < nonTerminals.length; i++) {
            Arrays.fill(table[i], "ERROR");
        }

        //..................... DEFINITION OF VARIABLES ........................
        // G → H
        set("G", "DEFINIR", "H");
        set("G", "$", "H");

        // H → IH | ε
        set("H", "DEFINIR", "I H");
        set("H", "$", "ε");

        // I → DEFINIR identificador COMO J
        set("I", "DEFINIR", "DEFINIR identificador COMO J");

        // J → ( cadena | entero | decimal );
        set("J", "cadena", "cadena");
        set("J", "entero", "entero");
        set("J", "decimal", "decimal");

        //........................... EXPRESSIONS ..............................
        //  A → BA'
        set("A", "identificador", "B A'");
        set("A", "entero", "B A'");
        set("A", "decimal", "B A'");

        // A' → +BA' | -BA' | ε
        set("A'", "+", "+ B A'");
        set("A'", "-", "- B A'");
        set("A'", ";", "ε");

        //  B → CB'
        set("B", "identificador", "C B'");
        set("B", "entero", "C B'");
        set("B", "decimal", "C B'");

        // B' → *CB' | /CB' | ε
        set("B'", "*", "* C B'");
        set("B'", "/", "/ C B'");
        set("B'", "+", "ε");
        set("B'", "-", "ε");
        set("B'", ";", "ε");

        //  C → identificador | entero | decimal
        set("C", "identificador", "identificador");
        set("C", "entero", "entero");
        set("C", "decimal", "decimal");

        //.................. ASSIGNING VALUES TO VARIABLES .....................
        // D → E
        set("D", "identificador", "E");
        set("D", "$", "E");

        // E → FE | ε
        set("E", "identificador", "F E");
        set("E", "$", "ε");

        // F → identicador = A;
        set("F", "identificador", "identificador = A");

        //......................... WRITE FUNCTION .............................
        // K → L
        set("K", "ESCRIBIR", "L");
        set("K", "$", "L");

        // L → ML | ε
        set("L", "ESCRIBIR", "M L");
        set("L", "$", "ε");

        // M → ESCRIBIR ( N );
        set("M", "ESCRIBIR", "ESCRIBIR ( N );");

        // N → cadena | entero | decimal | identificador
        set("N", "cadena", "cadena");
        set("N", "entero", "entero");
        set("N", "decimal", "decimal");
        set("N", "identificador", "identificador");

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
                return mapToken(token.getTokenType());
            }
        }
        return "$";
    }

    private String mapToken(TokenType type) {
        return switch (type) {
            case IDENTIFIER ->
                "ID";
            case IGUAL ->
                "=";
            case NUMBER ->
                "NUMERO";
            case DECIMAL ->
                "DECIMAL";
            case PCOMA ->
                ";";
            case MAS ->
                "+";
            case MENOS ->
                "-";
            case POR ->
                "*";
            case DIV ->
                "/";
            case ERROR ->
                "$";
            default ->
                "ERROR";
        };
    }

    public boolean parse() {
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push("P");

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
        return Arrays.asList("ID", "=", "NUMERO", "DECIMAL", "+", "-", "*", "/", ";", "$").contains(symbol);
    }

}
