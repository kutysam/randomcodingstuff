
//https://github.com/malvee/Booking.com/blob/master/live-test.md
import java.util.*;

public class FirstLast {

    public FirstLast() {
        logic();
    }

    public void logic() {
        List<String> input = new ArrayList<String>(Arrays.asList("rZd", "nZa", "dZl", "lZe", "pZr", "eZn"));
        List<String> output = new ArrayList<String>();
        int noOfChar = input.size();

        boolean left = false;
        boolean right = false;

        for (int i = 0; i < noOfChar; i++) {
            if (output.size() == 0) {
                output.add(input.get(0));
                input.remove(0);
            } else {
                if (left == false) {
                    String current = output.get(0);
                    String currentLeft = current.substring(0, 1);
                    boolean hasFront = false;
                    for (int j = 0; j < input.size(); j++) {
                        String tmp = input.get(j);
                        if (tmp.substring(tmp.length() - 1, tmp.length()).equals(currentLeft)) {
                            output.add(0, tmp);
                            input.remove(j);
                            hasFront = true;
                            break;
                        }
                    }
                    if (hasFront == false) {
                        left = true;
                    }
                }
                if (left == true) {
                    String current = output.get(output.size() - 1);
                    String currentRight = current.substring(current.length() - 1, current.length());

                    for (int j = 0; j < input.size(); j++) {
                        String tmp = input.get(j);
                        if (tmp.substring(0, 1).equals(currentRight)) {
                            output.add(tmp);
                            input.remove(j);
                            break;
                        }
                    }
                }
            }
        }

        // input.add("aa");
        System.out.println(input);
        System.out.println(output);
    }

    public static void main(String[] args) {
        FirstLast fl = new FirstLast();
    }
}
