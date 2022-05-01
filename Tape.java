import java.util.*;

public class Tape {

// ARRAYLIST!

    public String inp = "S0000000000E"; // 10 0's
    ArrayList<String> tape = new ArrayList<>();
    
    public void Tape(){
        // inp = input;
    }

    public void resizeLeft() { // do not double, FIX
        String temp = "yes";
        for (int i = 0; i < tape.size()-1; i++) {
            tape.set(i+1, tape.get(i));
        }
    }

    // resizeRight() not needed because arraylists already resize

    // public void resizeRight() { // do not double, FIX
    //     String temp = "yes";
    //     for (int i = 0; i < tape.size() - 1; i++) {
    //         tape.set(i, tape.get(i+1));
            
    //     }
    //     // tapsize*=2;
    //     // String[] tap2 = new String[tapsize];
    //     // for (int i = 0; i < tapsize/2; i++) {
    //     //     tap2[i] = tap[i];
    //     // }
    //     // tap = tap2;
    // }

    public void write(String newInput) {
        tape.add(newInput);
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