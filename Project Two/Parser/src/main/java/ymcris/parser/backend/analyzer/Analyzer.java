package ymcris.parser.backend.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.io.StringReader;
import ymcris.parser.model.word.Word;
import ymcris.parser.backend.lexer.Lexer;
import ymcris.parser.backend.parser.Parser;
import ymcris.parser.model.expresion.AssignmentExpresion;
import ymcris.parser.model.expresion.Expresion;
import ymcris.parser.model.variables.Variable;
import ymcris.parser.model.word.tokens.TokenType;

/**
 * The Analyzer class is the class responsible for do the respectives analyzer
 * features
 *
 * @author YmCris
 * @since Oct 20, 2025
 */
public class Analyzer {

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<Variable> variables;
    private ArrayList<ArrayList<Word>> outputLines;
    private ArrayList<String> values;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Analyzer() {
        this.outputLines = new ArrayList<>();
        this.variables = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    // SPECIFIC METHODS --------------------------------------------------------
    /**
     * Method responsible for analyzing a <strong>line of text</strong>
     * and adding the words in the line to an array of words according to
     * whether they are tokens or errors.
     *
     * @param line line to be analyzed
     * @param row row in which it is found
     * @throws IOException
     */
    public void analyze(String line, int row) throws IOException {

        //0. Create the line list to save the words analyzed
        ArrayList<Word> lineWords = new ArrayList<>(15);

        //1. Create the Lexer instance with the line
        Lexer lexer = new Lexer(new StringReader(line));

        //2. Do the lexer analysis
        lexer.yylex();

        ArrayList<Word> words = lexer.getWords();

        //3. Add the lexer words to the line list
        for (Word word : words) {

            //4. Set the row word
            word.setRow(row);

            //5. Save the words to the line words
            lineWords.add(word);

        }

        //6. Add the break line
        lineWords.add(new Word("\n", 0, 0, false));

        Parser parser = new Parser(words);
        Object object = parser.parse();

        doAction(object, parser.getVariableValue());

        parser.restartParser();

        //7. Save the line words to the output lines list
        outputLines.add(lineWords);

    }

    private void doAction(Object object, AssignmentExpresion assigns) {
        if (object instanceof Variable variable) {
            System.out.println("VOY A GUARDAR UNA VARIABLE");
            variables.add(variable);
        }
        if (object instanceof Expresion expresion) {
            if (expresion.getExpresion().get(0).getTokenType().equals(TokenType.WRITE)) {
                if (expresion.isIsNumber()) {
                    System.out.println("VOY A ESCRIBIR UNA OPERACIÓN");
                    expresion.setVariables(variables);
                    double result = expresion.calculateMathematicExpresion();
                    values.add(String.valueOf(result));
                } else {
                    System.out.println("VOY A ESCRIBIR UNA CADENA");
                    expresion.setVariables(variables);
                    String result = expresion.printString();
                    values.add(String.valueOf(result));
                }
            } else {
                System.out.println("VOY A HACER UNA OPERACIÓN");
                expresion.setVariables(variables);
                double result = expresion.calculateMathematicExpresion();
                System.out.println(result);
            }
        }
        if (object instanceof AssignmentExpresion assign) {
            System.out.println("VOY A ASIGNAR UN VALOR");
            System.out.println("EXPRESION " + assigns.getExpresion());
            System.out.println("VARIABLE NAME " + assigns.getVariableName());
            assign.setVariables(variables);
            assign.assignValue();
        }
    }

    public void deleteLine(int row) {
        outputLines.remove(row);
    }

    public void addLine(int row, String line) throws IOException {
        //0. Create the line list to save the words analyzed
        ArrayList<Word> lineWords = new ArrayList<>(15);

        //1. Create the Lexer instance with the line
        Lexer lexer = new Lexer(new StringReader(line));

        //2. Do the lexer analysis
        lexer.yylex();

        //3. Add the lexer words to the line list
        for (Word word : lexer.getWords()) {

            //4. Set the row word
            word.setRow(row);

            //5. Save the words to the line words
            lineWords.add(word);

        }

        //6. Add the break line
        lineWords.add(new Word("\n", 0, 0, false));

        //7. Save the line words to the output lines list
        outputLines.add(row, lineWords);
    }

    public void modifiLine(int row, String text) throws IOException {
        deleteLine(row);
        addLine(row, text);
    }

    /**
     * Method responsible for resetting the word list so that words do not
     * accumulate
     */
    public void restartAnalysis() {
        outputLines = new ArrayList<>(50);
        variables = new ArrayList<>();
        values = new ArrayList<>();
    }

    /**
     * Method responsible for print all words in the list
     */
    public void printWords() {
        System.out.println("\n".repeat(5));

        for (ArrayList<Word> words : outputLines) {
            for (Word word : words) {

                word.print();

            }
        }
    }

    public void printVariables() {
        for (Variable variable : variables) {
            System.out.println("Variable: " + variable.getName() + " type: " + variable.getType()+" value "+variable.getValue());
        }
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<ArrayList<Word>> getOutputLines() {
        return outputLines;
    }

    public ArrayList<Word> getRowAnalyzed(int row) {
        return outputLines.get(row);
    }

    public ArrayList<String> getValues() {
        return values;
    }

}
