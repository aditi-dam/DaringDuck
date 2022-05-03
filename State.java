import java.util.*;

public class State {
    
    // State s1 = ...
    // GENERAL, not defining specific states, just defining A STATE

    public State(ArrayList<Transition> transitions, Boolean isTerminal) {
        ArrayList<Transition> t = transitions;
    }

    public State createState(ArrayList<Transition> t, Tape tape) {
        State s0 = new State(t, false);
        return s0;
    }
    
}
