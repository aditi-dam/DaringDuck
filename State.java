import java.util.*;

public class State {
    
    // State s1 = ...
    // GENERAL, not defining specific states, just defining A STATE

    public ArrayList<Transition> t;
    public Boolean isTerminal;

    public State(ArrayList<Transition> transitions, Boolean terminal) {
        t = transitions;
        isTerminal = terminal;
    }

    public State createState(ArrayList<Transition> t, Tape tape) {
        State s0 = new State(t, false);
        return s0;
    }

    public ArrayList<Transition> getTransitions() {
        return t;
    }

    public Boolean getIsTerminal() {
        return isTerminal;
    }
    
}
