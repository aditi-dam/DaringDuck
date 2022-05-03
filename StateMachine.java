import java.util.*;

public class StateMachine {
    // ε
    
    public StateMachine() {
        ArrayList<State> stateList = new ArrayList<>();
        Tape tape = new Tape();

        ArrayList<Transition> t0 = new ArrayList<>();
        ArrayList<Transition> t1 = new ArrayList<>();
        ArrayList<Transition> t2 = new ArrayList<>();
        ArrayList<Transition> t3 = new ArrayList<>();
        ArrayList<Transition> t4 = new ArrayList<>();
        ArrayList<Transition> t_check = new ArrayList<>();
        ArrayList<Transition> t_halt = new ArrayList<>();
        
        State s0 = new State(t0, false);
        State s1 = new State(t1, false);
        State s2 = new State(t2, false);
        State s3 = new State(t3, false);
        State s4 = new State(t4, false);
        State check = new State(t_check, false);
        State halt = new State(t_halt, true);

        t0.add(new Transition(tape, s0, "ε", "R"));
        t0.add(new Transition(tape, s1, "1", "L"));
        stateList.add(s0);

        t1.add(new Transition(tape, s1, "ε", "L"));  
        t1.add(new Transition(tape, s2, "E", "L"));  
        stateList.add(s1);

        t2.add(new Transition(tape, check, "1", "L")); 
        t2.add(new Transition(tape, s0, "1", "R"));
        stateList.add(s2);

        t_check.add(new Transition(tape, check, "1", "L"));   
        t_check.add(new Transition(tape, halt, "S", "R"));
        t_check.add(new Transition(tape, s3, "0", "R"));
        stateList.add(check);
        
        stateList.add(halt);

        t3.add(new Transition(tape, s3, "ε", "R"));
        t3.add(new Transition(tape, s4, "E", "L"));
        stateList.add(s3);
    
        t4.add(new Transition(tape, s4, "0", "L"));
        stateList.add(s4);
    }

}
