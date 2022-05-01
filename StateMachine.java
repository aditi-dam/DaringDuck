import java.util.*;

public class StateMachine {
    // ε
    

    public StateMachine() {
        ArrayList<State> stateList = new ArrayList<>();
        Tape tape = new Tape();

        ArrayList<Transition> t0 = new ArrayList<>();
        t0.add(new Transition(tape, s0, "ε", "R"));
        t0.add(new Transition(tape, s1, "", "L"));
        State s0 = new State(t0, false);
        stateList.add(s0);
    }

}
