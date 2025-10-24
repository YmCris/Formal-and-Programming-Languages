package ymcris.parser.backend.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.io.StringReader;
import ymcris.parser.model.word.Word;
import ymcris.parser.backend.lexer.Lexer;

/**
 * The Analyzer class is the class responsible for do the respectives analyzer
 * features
 *
 * @author YmCris
 * @since Oct 20, 2025
 */
public class Analyzer {

    // REFERENCE VARIABLES -----------------------------------------------------
    private ArrayList<Word> words;

    // CONSTRUCTOR METHOD ------------------------------------------------------
    public Analyzer() {
        this.words = new ArrayList<>();
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

        Lexer lexer = new Lexer(new StringReader(line));//1. Create the Lexer instance
        lexer.yylex();//2. Do the lexer analysis

        for (Word word : lexer.getWords()) {//3. Add the lexer words to the words list

            word.setRow(row);//4. Set the row word
            words.add(word);

        }

    }

    /**
     * Method responsible for resetting the word list so that words do not
     * accumulate
     */
    public void restartAnalysis() {
        words = new ArrayList<>(50);
    }

    /**
     * Method responsible for print all words in the list
     */
    public void printWords() {
        System.out.println("\n".repeat(5));
        for (Word word : words) {
            word.print();
        }
    }

    // GETTERS -----------------------------------------------------------------
    public ArrayList<Word> getWords() {
        return words;
    }

}
