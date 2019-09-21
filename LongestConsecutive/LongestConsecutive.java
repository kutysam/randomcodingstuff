import java.util.*;

//https://carousell.slack.com/archives/CKH7G7QBW/p1568910951011400
public class LongestConsecutive {
    public LongestConsecutive() {
        System.out.println(Compute());
    }

    int Compute() {
        int longest = 0;
        int[] intArray = new int[] { 100, 4, 200, 1, 3, 2 };
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < intArray.length; i++) {
            hs.add(intArray[i]);
        }

        for (int i = 0; i < intArray.length; i++) {
            int tmpLongest = 0;
            int currentElement = intArray[i];

            if (hs.remove(currentElement)) {
                tmpLongest = 1;
                int tmpLeft = currentElement - 1;
                int tmpRight = currentElement + 1;
                while (hs.remove(tmpLeft)) {
                    tmpLeft--;
                    tmpLongest++;
                }
                while (hs.remove(tmpRight)) {
                    tmpRight++;
                    tmpLongest++;
                }
            }

            if (tmpLongest > longest) {
                longest = tmpLongest;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
    }
}
