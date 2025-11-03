package ymcris.parser.model.variables;

import org.apache.commons.lang3.StringUtils;
import ymcris.parser.model.expresion.Expresion;

/**
 * The Variable class is the class responsible for be a variable
 *
 * @author YmCris
 * @see VariableType
 * @since Nov 2, 2025
 */
public class Variable {

    // REFERENCE VARIABLES -----------------------------------------------------
    private String name;
    private Expresion value;
    private VariableType type;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Variable(VariableType type, String name) {
        this.type = type;
        this.name = name;
    }

    // SPECIFIC METHODS --------------------------------------------------------
  

    public boolean isValid() {
        return StringUtils.isNotBlank(name) && type != null && value != null;
    }

    // GETTERS -----------------------------------------------------------------
    public VariableType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Expresion getValue() {
        return value;
    }

    // SETTERS -----------------------------------------------------------------
    public void setType(VariableType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Expresion value) {
        this.value = value;
    }

}
