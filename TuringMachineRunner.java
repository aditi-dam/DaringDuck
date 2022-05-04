// Group 95: Aditi Dam, Dong Joo Kwon, Tal Ledeniov

public class TuringMachineRunner {
    
    // public static StateMachine machine;
    public static State finalState;
    public static Tape tape = new Tape("S0000000000E"); // Final: 10 0's

    public static void main(String[] args) {
        StateMachine machine = new StateMachine(tape);
        tape.toString();
        // tape.resizeRight();
        // tape.moveRight();
        // System.out.println(tape.getIndex());
        // tape.moveLeft();
        // System.out.println(tape.getIndex());
        // tape.toString();
        
        while (!(machine.currState.equals(machine.haltState))) {
            System.out.println(machine.currState.getName());
            System.out.println(tape.toString());
            
            machine.move(machine.currState);
            
            if (machine.currState.equals(machine.haltState)) {
                break;
            }
        }

        System.out.println("Finished");
        System.out.println(tape.toString());
        System.out.println();

        int oneCount = tape.oneCount();
        System.out.println("Final count of ones: " + oneCount);

        // float finalScore = (oneCount / (7 + 6 + 12));
        // System.out.println("Final score: count of 1's / (7 states + 6 symbols in alphabet + tape input size 12)");
        // System.out.printf("%f", finalScore);
    }
}
