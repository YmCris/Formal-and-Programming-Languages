package ymcris.lexicalanalyzer.backend.simulator;

import java.util.List;
import java.util.ArrayList;
import ymcris.lexicalanalyzer.backend.automata.Automata;
import ymcris.lexicalanalyzer.model.word.tokens.TokenType;

/**
 * Clase Simulation es la clase encargada de
 *
 * @author YmCris
 * @since Oct 2, 2025
 */
public class Simulation {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String input;
    private StringBuilder lexeme;
    private final List<Step> history;
    private final List<Step> finalized;
    private final Automata automata;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int index;
    private int currentState;

    public Simulation(Automata automata) {
        this.index = 0;
        this.input = "";
        this.automata = automata;
        this.lexeme = new StringBuilder();
        this.history = new ArrayList<>();
        this.finalized = new ArrayList<>();
        reset();
    }

    public void setInput(String input) {
        this.input = input == null ? "" : input;
        reset();
    }

    public void reset() {
        index = 0;
        currentState = automata.getInitialState();
        lexeme.setLength(0);
        history.clear();
        finalized.clear();
    }

    public Step stepForward() {
        Step step = new Step();
        if (index >= input.length()) {
            step.setMessage("Fin");
            return step;
        }
        char character = input.charAt(index);
        int type = automata.getCharacterType(character);
        step.setIndex(index);
        step.setReadedCharacter(character);
        step.setPreviousState(currentState);
        step.setLexemeBefore(lexeme.toString());
        if (type == -1) {
            currentState = -1;
            step.setNextState(-1);
            step.setError(true);
            step.setLexemeAfter("");
            step.setMessage("Caracter invalido: '" + character + "'");
            index++;
            history.add(step);
            return step;
        }
        int next = automata.getNextState(currentState, type);
        if (next == -1) {
            if (lexeme.length() > 0) {
                TokenType tt = automata.getTokenType(currentState, lexeme.toString());
                step.setFinalizedToken(true);
                step.setTokenType(tt);
                step.setMessage("Token finalizado: '" + lexeme + "' " + tt);
                finalized.add(step);
                lexeme.setLength(0);
            }
            step.setError(true);
            step.setNextState(-1);
            step.setLexemeAfter("");
            index++;
        } else {
            currentState = next;
            lexeme.append(character);
            index++;

            step.setNextState(currentState);
            step.setLexemeAfter(lexeme.toString());
            step.setAcceptedState(automata.isAcceptingState(currentState));

            if (step.isAcceptedState()) {
                step.setTokenType(automata.getTokenType(currentState, lexeme.toString()));
                step.setMessage("Movimiento valido a estado de aceptación " + step.getTokenType());
            } else {
                step.setMessage("Movimiento válido: " + step.getPreviousState() + " a" + step.getNextState());
            }
        }

        history.add(step);
        return step;
    }

    public Step stepBack() {
        if (history.isEmpty()) {
            return null;
        }
        Step last = history.remove(history.size() - 1);
        this.index = last.getIndex();
        this.currentState = last.getPreviousState();
        lexeme.setLength(0);
        lexeme.append(last.getLexemeBefore());

        if (last.isFinalizedToken() && !finalized.isEmpty()) {
            finalized.remove(finalized.size() - 1);
        }

        return last;
    }

    public List<Step> runUntilTokenEnd() {
        List<Step> steps = new ArrayList<>();
        while (index < input.length()) {
            Step s = stepForward();
            steps.add(s);
            if (s.isFinalizedToken() || s.isError()) {
                break;
            }
        }
        return steps;
    }

    public int getCurrentState() {
        return currentState;
    }

    public String getLexeme() {
        return lexeme.toString();
    }

    public int getIndex() {
        return index;
    }

    public List<Step> getHistory() {
        return history;
    }

    public List<Step> getFinalizedTokens() {
        return finalized;
    }
}
