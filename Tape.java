import java.util.*;

public class Tape {

// ARRAYLIST!

    public String input; 
    public ArrayList<String> tape = new ArrayList<String>();
    public int index = 0;
    
    public Tape(String inp){
        input = inp;
        for (int i = 0; i < input.length(); i++) {
            tape.add(input.substring(i, i+1));
        }
        // resizeRight();
        // for (int i = 0; i < 10000; i++) {
        //     tape.add("N");
        // }
    }

    public String getInput() {
        return input;
    }

    public ArrayList<String> getTape() {
        return tape;
    }

    public int getIndex() {
        return index;
    }

    public void moveRight(){
        if (index == tape.size()-1) {
            System.out.println("Tape size: " + tape.size());
            resizeRight();
        }
        index++;
    }

    public void moveLeft(){
        index--;
        if (index < 0){
            resizeLeft();
            index = 0;
        }
    }

    public void resizeLeft() { // do not double, FIX
        // String temp = "yes";
        for (int i = 0; i < tape.size()-1; i++) {
            tape.set(i+1, tape.get(i));
        }
    }

    public void resizeRight() {
        tape.add("N");
    }

    public void write(String newInput) {
        // if (index < tape.size()) {
        //     tape.set(index, newInput);
        // }
        // else {
        //     tape.set(tape.size()-1, newInput);
        // }
        tape.set(index, newInput);
    }
    
    // Prints output
    public String toString() {
        String ret = "";
        for (String i : tape) {
            ret += i + "|";
        }
        return ret;
    }

    // Prints how many 1's we have
    public int oneCount() {
        int count = 0;
        for (int i = 0; i < tape.size(); i++) {
            if (tape.get(i).equals("1")) {
                count++;
            }
        }
        return count;
    }

    
}