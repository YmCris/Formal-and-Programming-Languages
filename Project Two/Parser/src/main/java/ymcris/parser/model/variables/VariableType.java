package ymcris.parser.model.variables;

/**
 * The enum VariableType is the enum responsible for representing the variable's
 * type
 *
 * @author YmCris
 * @since Nov 2, 2025
 */
public enum VariableType {

    // ENUMS -------------------------------------------------------------------
    NUMERO("decimal"),
    ENTERO("entero"),
    EXPRESION("expresion"),
    IDENTIFICADOR("identificador"),
    CADENA("cadena");

    // PRIMITIVE VARIABLES -----------------------------------------------------
    private String name;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    private VariableType(String name) {
        this.name = name;
    }
    // GETTERS -----------------------------------------------------------------

    public String getName() {
        return name;
    }

}
