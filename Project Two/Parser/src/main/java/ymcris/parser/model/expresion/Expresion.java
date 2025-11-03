package ymcris.parser.model.expresion;

import java.util.ArrayList;
import java.util.Stack;
import ymcris.parser.model.variables.Variable;
import ymcris.parser.model.word.tokens.Token;
import ymcris.parser.model.word.tokens.TokenType;

/**
 * The Expresion class is the class responsible for be a conjunt of tokens type
 *
 * @author YmCris
 * @since Nov 2, 2025
 */
public class Expresion {

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<Token> expresion;
    private ArrayList<Variable> variables;

    boolean isNumber;
    boolean blocked;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Expresion(ArrayList<Token> expresion) {
        this.expresion = expresion;
    }

    // FUNCTIONS ---------------------------------------------------------------
    private boolean variablesAreValidToPrint(Variable variable) {//
        return variable != null && variable.isValid();
    }

    private boolean variablesAreValidToOperate(Variable variable) {//
        return variable != null && variable.isValid();
    }

    public String printString() {
        StringBuilder builder = new StringBuilder();
        for (Variable variable : variables) {
            if (variablesAreValidToPrint(variable)) {
                builder.append(variable.getValue());
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public double calculateMathematicExpresion() {

        ArrayList<String> elements = getElements();

        Stack<Double> stack = new Stack<>();

        for (String element : elements) {
            if (isNumber(element)) {
                stack.push(Double.valueOf(element));
            } else if (isOperator(element)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida");
                }
                double b = stack.pop();
                double a = stack.pop();
                double result = switch (element) {
                    case "+" ->
                        a + b;
                    case "-" ->
                        a - b;
                    case "*" ->
                        a * b;
                    case "/" ->
                        a / b;
                    case "%" ->
                        a % b;
                    default ->
                        throw new IllegalArgumentException("Operador desconocido: " + element);
                };
                stack.push(result);
            } else {
                Double varValue = getVariableValue(element);
                if (varValue != null) {
                    stack.push(varValue);
                } else {
                    throw new IllegalArgumentException("Variable no definida: " + element);
                }
            }
        }

        return stack.isEmpty() ? 0.0 : stack.pop();
    }

    private ArrayList<String> getElements() {
        ArrayList<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (Token token : expresion) {
            String lexeme = token.getLexeme();
            TokenType type = token.getTokenType();

            switch (type) {
                case NUMBER, DECIMAL ->
                    output.add(lexeme);
                case IDENTIFIER ->
                    output.add(lexeme);
                case PLUS, MINUS, MULTIPLY, DIVIDE -> {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(lexeme)) {
                        output.add(operators.pop());
                    }
                    operators.push(lexeme);
                }
                case OPENING_PARENTHESES ->
                    operators.push(lexeme);
                case CLOSING_PARENTHESES -> {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        output.add(operators.pop());
                    }
                    if (!operators.isEmpty() && operators.peek().equals("(")) {
                        operators.pop();
                    }
                }
                default -> {
                }
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    private int precedence(String op) {
        return switch (op) {
            case "+", "-" ->
                1;
            case "*", "/", "%" ->
                2;
            default ->
                0;
        };
    }

    private boolean isNumber(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String tokenLexeme) {
        return tokenLexeme.equals("+")
                || tokenLexeme.equals("-")
                || tokenLexeme.equals("*")
                || tokenLexeme.equals("/")
                || tokenLexeme.equals("%");
    }

    private Double getVariableValue(String name) {
        if (variables == null) {
            return null;
        }
        for (Variable var : variables) {
            if (var.getName().equals(name)) {
                try {
                    System.out.println("value name " + var.getName());
                    System.out.println("value value " + var.getValue().getContent());
                    return Double.valueOf(var.getValue().toString());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }
        return null;
    }

    public void print() {
        for (Token token : expresion) {
            System.out.println("TOKEN: " + token.getLexeme() + " type: " + token.getTokenType());
        }
    }

    // GETTERS -----------------------------------------------------------------
    public String getContent() {
        StringBuilder build = new StringBuilder();
        if (expresion != null) {
            for (Token token : expresion) {
                build.append(token.getLexeme());
            }
        }
        return build.toString();
    }

    public ArrayList<Token> getExpresion() {
        return expresion;
    }

    public boolean isIsNumber() {
        return isNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    // SETTERS -----------------------------------------------------------------
    public void setExpresion(ArrayList<Token> expresion) {
        this.expresion = expresion;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public void setIsNumber(boolean isNumber) {
        this.isNumber = isNumber;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

}
