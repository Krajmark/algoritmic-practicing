package codewars;

import java.util.ArrayList;
import java.util.List;

public class SetReducer {
    /*Intro
These arrays are too long! Let's reduce them!

Description
Write a function that takes in an array of integers from 0-9, and returns a new array:

Numbers with no identical numbers preceding or following it returns a 1: 2, 4, 9  => 1, 1, 1
Sequential groups of identical numbers return their count: 6, 6, 6, 6 => 4
Example

[0, 4, 6, 8, 8, 8, 5, 5, 7] => [1, 1, 1, 3, 2, 1]

Your function should then repeat the process on the resulting array, and on the resulting array of that, until it returns a single integer:

[0, 4, 6, 8, 8, 8, 5, 5, 7] =>  [1, 1, 1, 3, 2, 1] => [3, 1, 1, 1] => [1, 3] => [1, 1] => [2]

When your function has reduced the array to a single integer following these rules, it should return that integer.

[2] => 2

Rules and assertions
All test arrays will be 2+ in length
All integers in the test arrays will be positive numbers from 0 - 9
You should return an integer, not an array with 1 element*/
    public static void main(String[] args) {
        System.out.println(setReducer(new int[] {0, 4, 6, 8, 8, 8, 5, 5, 7}));
        System.out.println("Expected: 2");
        System.out.println(setReducer(new int[]{6, 6, 6}));
        System.out.println("Expected: 3");
        System.out.println(setReducer(new int[] {8, 1, 6, 1, 2, 7, 7, 7, 7, 6, 5, 3, 2, 1, 8}));
        System.out.println("Expected: 3");
    }
    public static int setReducer(int[] input) {
        int[] output = reducerHelper(input);
        if (output.length == 1) return output[0];
        return setReducer(output);
    }
    private static int[] reducerHelper(int[] input) {
        List<Integer> newMembers = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] != input[j]) {
                    break;
                }
                indexes.add(input[j]);
            }
            newMembers.add(indexes.size());
            i += indexes.size() - 1;
            indexes.clear();
        }
        int[] output = new int[newMembers.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = newMembers.get(i);
        }
        return output;
    }
}
