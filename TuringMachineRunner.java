// Group 95: Aditi Dam, Dong Joo Kwon, Tal Ledeniov

public class TuringMachineRunner {
    
    // public static StateMachine machine;
    public static State finalState;
    public static Tape tape = new Tape("S0000000000E"); // Final: 10 0's

    public static void main(String[] args) {
        StateMachine machine = new StateMachine(tape);
        
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

        int finalScore = (oneCount / (7 + 6 + 12));
        System.out.println("Final score: " + finalScore);
    }
}
