/*HEADER*/

package ymcris.parser.backend.lexer;

import java.lang.Error;
import java.util.ArrayList;
import ymcris.parser.model.word.Word;
import ymcris.parser.model.word.tokens.Token;
import ymcris.parser.backend.language.Language;
import ymcris.parser.model.word.errors.ErrorWord;
import ymcris.parser.model.word.errors.ErrorType;
import ymcris.parser.model.word.tokens.TokenType;

%%

/*SETTINGS*/

%class Lexer
%public
%unicode
%line
%column
%type Word

/*JAVA CODE*/

%{

    // REFERENCE VARIABLES -----------------------------------------------------
    private Language language = new Language();
    ArrayList<Word> words = new ArrayList<>();// Save Tokens and Errors

    // SPECIFIC METHODS --------------------------------------------------------
    public void saveError(Word word, ErrorType errorType){
        if(!word.isToken()){

            ErrorWord error = new ErrorWord(word.getLexeme(), word.getRow(), word.getColumn(),
            false, 'x', errorType);

            words.add(error);

        }
    }

    private void saveToken(Word word, TokenType tokenType){
        if(word.isToken()){

            Token token = new Token(word.getLexeme(), tokenType, word.getRow(), 
            word.getColumn());

            words.add(token);

        }
    }

    public ArrayList<Word> getWords(){
        return words;
    }
    
%}

/* REGULAR EXPRESSIONS  IDENTIFIERS, NUMBERS, DECIMALS, RESERVED WORDS */

Identifier = [:jletter:] [:jletterdigit:]*
Digit = [0-9]
Number = 0 | [1-9]{Digit}*
NUM_MAL = {Digit}+\.?[^0-9]?
Decimal = ({Number}\.{Digit}+ | \.{Digit}+)
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

%%

/*ACTIONS*/

"write"             {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.STRING);}
"integer"           {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.NUMBER);}
{Identifier}        {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.IDENTIFIER);}
{Number}            {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.NUMBER);}
{Decimal}           {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.DECIMAL);}
{NUM_MAL}           {saveError(new Word(yytext(), yyline, yycolumn, true), ErrorType.GRAMMAR_ERROR);}
{LineTerminator}    {/*IGNORE*/}
{WhiteSpace}        {/*IGNORE*/}
[^]                 {System.out.println("INVALID CHARACTER");}
