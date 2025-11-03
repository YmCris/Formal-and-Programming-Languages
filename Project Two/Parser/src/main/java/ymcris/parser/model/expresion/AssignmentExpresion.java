package ymcris.parser.model.expresion;

import java.util.ArrayList;
import ymcris.parser.model.variables.Variable;
import ymcris.parser.model.word.tokens.Token;

/**
 * The AssignmentExpresion class is the class responsible for
 *
 * @author YmCris
 * @since Nov 3, 2025
 */
public class AssignmentExpresion {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String variableName;
    private ArrayList<Token> expresion;
    private ArrayList<Variable> variables;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public AssignmentExpresion(String variableName, ArrayList<Token> expresion) {
        this.variableName = variableName;
        this.expresion = expresion;
    }

    // SPECIFIC METHODS --------------------------------------------------------
    public void assignValue() {
        for (Variable variable : variables) {
            if (variable.getName().equals(variableName)) {
                Expresion expresionValue = new Expresion(expresion);
                variable.setValue(expresionValue);
            }
        }
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public String getVariableName() {
        return variableName;
    }

    public ArrayList<Token> getExpresion() {
        return expresion;
    }

    // SETTERS -----------------------------------------------------------------
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public void setExpresion(ArrayList<Token> expresion) {
        this.expresion = expresion;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

}
