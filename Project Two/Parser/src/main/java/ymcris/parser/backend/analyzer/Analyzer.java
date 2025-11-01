package ymcris.parser.backend.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.io.StringReader;
import java.util.List;
import ymcris.parser.model.word.Word;
import ymcris.parser.backend.lexer.Lexer;
import ymcris.parser.backend.parser.Parser;

/**
 * The Analyzer class is the class responsible for do the respectives analyzer
 * features
 *
 * @author YmCris
 * @since Oct 20, 2025
 */
public class Analyzer {

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<ArrayList<Word>> outputLines;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Analyzer() {
        this.outputLines = new ArrayList<>();
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
        
        List<Word> words = lexer.getWords();
        Parser parser = new Parser(words);
        parser.parse();
        

        //3. Add the lexer words to the line list
        for (Word word : words) {

            //4. Set the row word
            word.setRow(row);

            //5. Save the words to the line words
            lineWords.add(word);

        }

        //6. Add the break line
        lineWords.add(new Word("\n", 0, 0, false));

        //7. Save the line words to the output lines list
        outputLines.add(lineWords);

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

    // GETTERS -----------------------------------------------------------------
    public ArrayList<ArrayList<Word>> getOutputLines() {
        return outputLines;
    }

    public ArrayList<Word> getRowAnalyzed(int row) {
        return outputLines.get(row);
    }
}
