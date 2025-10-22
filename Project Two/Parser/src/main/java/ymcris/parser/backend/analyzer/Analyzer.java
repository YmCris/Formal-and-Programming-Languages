package ymcris.parser.backend.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.io.StringReader;
import ymcris.parser.model.word.Word;
import ymcris.parser.backend.lexer.Lexer;
import ymcris.parser.backend.language.Language;
import ymcris.parser.model.word.tokens.TokenType;

/**
 * The Analyzer class is the class responsible for do the respectives analyzer
 * features
 *
 * @author YmCris
 * @since Oct 20, 2025
 */
public class Analyzer {

    private ArrayList<Word> words = new ArrayList<>();

    // SPECIFIC METHODS --------------------------------------------------------
    public void analyze(String line, int row) throws IOException {
        Lexer lexer;
        lexer = new Lexer(new StringReader(line));
        lexer.yylex();
        for (Word tmp : lexer.getWords()) {
            words.add(tmp);
            tmp.print();
        }
    }

    private TokenType verifyReservedWord(String lexeme) {
        for (String reservedWord : Language.RESERVED_WORDS) {
            if (lexeme.equals(reservedWord)) {
                return TokenType.RESERVED_WORD;
            }
        }
        return TokenType.IDENTIFIER;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

}
