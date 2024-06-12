package greenfoxpractice;

import java.util.HashMap;
import java.util.Map;

public class One {
    /*Given an array of integers, find the one that appears an odd number of times.
There will always be only one integer that appears an odd number of times.
Examples
[7] should return 7, because it occurs 1 time (which is odd).
[0] should return 0, because it occurs 1 time (which is odd).
[1,1,2] should return 2, because it occurs 1 time (which is odd).
[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
*/
    public static void main(String[] args) {
        System.out.println(countOccurrences(new int[]{7}));
        System.out.println("Correct: 7");
        System.out.println(countOccurrences(new int[]{0}));
        System.out.println("Correct: 0");
        System.out.println(countOccurrences(new int[]{1,1,2}));
        System.out.println("Correct: 2");
        System.out.println(countOccurrences(new int[]{0,1,0,1,0}));
        System.out.println("Correct: 0");
        System.out.println(countOccurrences(new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1}));
        System.out.println("Correct: 4");
    }

    public static int countOccurrences(int[] input) {
        Map<Integer, Integer> occursCounts = new HashMap<>();
        for (Integer number : input) {
            if (!occursCounts.containsKey(number)) {
                occursCounts.put(number, 1);
                continue;
            }
            occursCounts.put(number, occursCounts.get(number) + 1);
        }
        int oddKey = 0;
        for (Map.Entry<Integer, Integer> entry : occursCounts.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                oddKey = entry.getKey();
            }
        }
        return oddKey;
    }
}
