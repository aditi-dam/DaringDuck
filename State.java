import java.util.*;

public class State {
    
    // State s1 = ...
    // GENERAL, not defining specific states, just defining A STATE

    public State(ArrayList<Transition> transitions, Boolean isTerminal) {
        ArrayList<Transition> t = transitions;
    }

    public State createState(t) {
        t.add(new Transition(tape, s0, "ε", "R"));
        t.add(new Transition(tape, s1, "", "L"));
        State s0 = new State(t, false);
    }
    
}
