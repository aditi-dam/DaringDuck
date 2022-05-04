public class Transition {
    
    public Tape inputTape;
    public State nextState;
    public String readSymbol;
    public String writeSymbol;
    public String direction;

    public Transition(Tape input, State next, String read, String write, String dir) {
        inputTape = input;
        nextState = next;
        readSymbol = read;
        writeSymbol = write;
        direction = dir;
    }

    public Tape getInputTape() {
        return inputTape;
    }

    public State getNextState() {
        return nextState;
    }

    public String getReadSymbol() {
        return readSymbol;
    }

    public String getWriteSymbol() {
        return writeSymbol;
    }

    public String getDirection() {
        return direction;
    }
}

