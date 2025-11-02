/*HEADER*/

package ymcris.parser.backend.lexer;

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
%xstate BLOCK_COMMENT
%type Word

/*JAVA CODE*/

%{

    // REFERENCE VARIABLES -----------------------------------------------------

    private Language language = new Language();
    ArrayList<Word> words = new ArrayList<>();

    // SPECIFIC METHODS --------------------------------------------------------

    public void saveError(Word word, ErrorType errorType, Character errorChar){

        ErrorWord error = new ErrorWord(word.getLexeme(), word.getRow(), word.getColumn(),
        errorChar , errorType);
        
        words.add(error);
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


/* RESERVED WORDS */
SI      = [Ss][Ii]
ENTONCES = [Ee][Nn][Tt][Oo][Nn][Cc][Ee][Ss]
ENTERO  = [Ee][Nn][Tt][Ee][Rr][Oo]
NUMERO  = [Nn][Uu][Mm][Ee][Rr][Oo]
CADENA  = [Cc][Aa][Dd][Ee][Nn][Aa]
ESCRIBIR = [Ee][Ss][Cc][Rr][Ii][Bb][Ii][Rr]
DEFINIR = [Dd][Ee][Ff][Ii][Nn][Ii][Rr]
COMO    = [Cc][Oo][Mm][Oo]

/* STRINGS */
StringLiteral = \"([^\"\n\r])*\"

/* Tabulation */
Tab = \t

/* PUNCTUATION */
Period       = \.
Comma        = ,
Semicolon    = ;
Colon        = :

/* ARITHMETIC OPERATORS */
Plus         = \+
Minus        = \-
Multiply     = \*
Divide       = \/
Modulo       = %
Equal        = =

/* GROUPING SYMBOLS */
LParen      = \(
RParen      = \)
LBracket    = \[
RBracket    = \]
LBrace      = \{
RBrace      = \}

Digit        = [0-9]
Letter       = [a-zA-Z]
Identifier = [a-zA-Z] [a-zA-Z0-9_]*//Identifier = [:jletter:] [:jletterdigit:]*     
Number       = {Digit}+
Decimal      = {Digit}+ "." {Digit}+
NUM_MAL      = {Digit}+{Letter}+
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
LineComment = "//" [^\n\r]*

%%

/*ACTIONS*/

/* LINE COMMENTS */

{LineComment}         {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.LINE_COMMENT);}

/* BLOCK COMMENT: */

/* BLOCK COMMENT: simple, sin estados */
"/*"([^]*?)"*/" {
    saveToken(
        new Word(yytext(), yyline, yycolumn, true),
        TokenType.BLOCK_COMMENT
    );
}



/* RESERVED WORDS */

"si"|"SI"             {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.RESERVED_WORD);}
"entonces"|"ENTONCES" {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.RESERVED_WORD);}
"entero"|"ENTERO"     {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.RESERVED_WORD_INTEGER);}
"numero"|"NUMERO"     {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.RESERVED_WORD_DECIMAL);}
"cadena"|"CADENA"     {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.RESERVED_WORD_STRING);}
"escribir"|"ESCRIBIR" {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.WRITE);}
"definir"|"DEFINIR"   {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.DEFINE);}
"como"|"COMO"         {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.HOW);}

/* IDENTIFIERS */

{Identifier}        {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.IDENTIFIER);}

/* STRINGS */

{StringLiteral} {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.STRING);}

/* PUNCTUATION */

{Period}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.PUNCTUATION_MARKS);}
{Comma}       {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.PUNCTUATION_MARKS);}
{Semicolon}   {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.SEMICOLON);}
{Colon}       {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.PUNCTUATION_MARKS);}

/* ARITHMETIC OPERATORS */

{Plus}        {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.PLUS);}
{Minus}       {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.MINUS);}
{Multiply}    {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.MULTIPLY);}
{Divide}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.DIVIDE);}
{Modulo}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.ARITHMETIC_OPERATOR);}
{Equal}       {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.EQUALS);}

/* GROUPING SYMBOLS */

{LParen}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.OPENING_PARENTHESES);}
{RParen}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.CLOSING_PARENTHESES);}
{LBracket}    {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.GROUPING_MARKS);}
{RBracket}    {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.GROUPING_MARKS);}
{LBrace}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.GROUPING_MARKS);}
{RBrace}      {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.GROUPING_MARKS);}


/* OTHERS */

{Tab}               {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.TAB);}
"write"             {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.STRING);}
"integer"           {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.NUMBER);}
{Number}            {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.NUMBER);}
{Decimal}           {saveToken(new Word(yytext(), yyline, yycolumn, true), TokenType.DECIMAL);}
{LineTerminator}    {System.out.println("SALTO DE LÍNEA");}
{WhiteSpace}        {/*IGNORE*/}

/* ERRORS */
{NUM_MAL}           {saveError(new Word(yytext(), yyline, yycolumn, true), ErrorType.GRAMMAR_ERROR, yycharat(yycolumn));}
[^]                 {saveError(new Word(yytext(), yyline, yycolumn, true), ErrorType.INVALID_CHARACTER_ERROR, yycharat(yycolumn));}

