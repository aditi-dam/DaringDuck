import java.util.*;

public class StateMachine {
    // "ε" = epsilon
    // "N" = null
    
    public State currState;
    public State haltState;
    public ArrayList<State> stateList = new ArrayList<>();
    public Tape tape;
    
    public StateMachine(Tape input) {
        tape = input;

        ArrayList<Transition> t0 = new ArrayList<>();
        ArrayList<Transition> t1 = new ArrayList<>();
        ArrayList<Transition> t2 = new ArrayList<>();
        ArrayList<Transition> t3 = new ArrayList<>();
        ArrayList<Transition> t4 = new ArrayList<>();
        ArrayList<Transition> t_check = new ArrayList<>();
        ArrayList<Transition> t_halt = new ArrayList<>();
        
        State s0 = new State("s0", t0, false);
        State s1 = new State("s1", t1, false);
        State s2 = new State("s2", t2, false);
        State s3 = new State("s3", t3, false);
        State s4 = new State("s4", t4, false);
        State check = new State("check", t_check, false);
        State halt = new State("halt", t_halt, true);
        
        t0.add(new Transition(tape, s0, "0", "0", "R"));
        t0.add(new Transition(tape, s0, "1", "1", "R"));
        t0.add(new Transition(tape, s0, "S", "S", "R"));
        t0.add(new Transition(tape, s0, "E", "E", "R"));
        t0.add(new Transition(tape, s1, "N", "1", "L"));
        stateList.add(s0);
        currState = s0;

        t1.add(new Transition(tape, s1, "0", "0", "L"));
        t1.add(new Transition(tape, s1, "1", "1", "L"));
        t1.add(new Transition(tape, s1, "S", "S", "L"));
        t1.add(new Transition(tape, s2, "E", "E", "L"));  
        stateList.add(s1);

        t2.add(new Transition(tape, s0, "0", "1", "R"));
        t2.add(new Transition(tape, check, "1", "1", "L")); 
        stateList.add(s2);

        t_check.add(new Transition(tape, check, "1", "1", "L"));   
        t_check.add(new Transition(tape, s3, "0", "0", "R"));
        t_check.add(new Transition(tape, halt, "S", "S", "R"));
        stateList.add(check);
        
        stateList.add(halt);
        haltState = halt;

        t3.add(new Transition(tape, s3, "0", "0", "R"));
        t3.add(new Transition(tape, s3, "1", "1", "R"));
        t3.add(new Transition(tape, s3, "S", "S", "R"));
        t3.add(new Transition(tape, s4, "E", "E", "L"));
        stateList.add(s3);
    
        t4.add(new Transition(tape, s4, "1", "0", "L"));
        t4.add(new Transition(tape, s0, "0", "1", "R"));
        stateList.add(s4);
    }

    public State getCurrentState() {
        return currState;
    }

    public State getHaltState() {
        return haltState;
    }

    public void move(State initialState) {
        ArrayList<String> ta = tape.getTape();
        int tI = tape.index;
        System.out.println("Current index: " + tI);
        if (tI > tape.getTape().size()) {
            tape.resizeRight();
        }
        String s2 = ta.get(tI);

        for (int i = 0; i < initialState.getTransitions().size(); i++) {
            ArrayList<Transition> tL = initialState.getTransitions();
            Transition t = tL.get(i);
            String s = t.getReadSymbol();
            System.out.println("Transition is looking for symbol: " + s);
            
            System.out.println("Symbol on tape: " + s2);
            System.out.println(s + " equals " + s2 + ": " + (s.equals(s2)));
            if (s.equals(s2)) {
                System.out.println("Correct symbol found. Moving to next space on tape.");
            }

            if (s.equals(s2)) {
                // if (initialState.getTransitions().get(i).getReadSymbol().equals("N")) {
                //     tape.getTape().add(initialState.getTransitions().get(i).getWriteSymbol());
                // }
                // else {
                    System.out.println("Writing " + initialState.getTransitions().get(i).getWriteSymbol() + " to tape.");
                    tape.write(initialState.getTransitions().get(i).getWriteSymbol());
                // }
                
                // Changing the current state
                currState = initialState.getTransitions().get(i).getNextState();

                // Moving the tape
                if (initialState.getTransitions().get(i).getDirection().equals("L")) {
                    System.out.println("Index before moving: " + tape.index);
                    tape.moveLeft();
                    System.out.println("Index after moving: " + tape.index + "\n");
                }
                else {
                    System.out.println("Index before moving: " + tape.index);
                    tape.moveRight();
                    System.out.println("Index after moving: " + tape.index + "\n");
                    
                }

                break;
            }
        }
    }
}
