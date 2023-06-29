package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarraySumAndTest {
    /*https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c
    *
    *
The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}
Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
If the list is made up of only negative numbers, return 0 instead.
Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.*/

    public static int sequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int subArraySize = 1; subArraySize < arr.length; subArraySize++) {
            for (int enteringIndex = 0; enteringIndex < arr.length; enteringIndex++) {
                int temp = 0;
                for (int i = enteringIndex; i < enteringIndex + subArraySize + 1 && i < arr.length; i++) {
                    temp += arr[i];
                }
                if (temp > maxSum) {
                    maxSum = temp;
                }
            }
        }
        return Math.max(maxSum, 0);
    }

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals(0, sequence(new int[]{}), "Empty arrays should have a max of 0");
    }

    @Test
    public void testExampleArray() throws Exception {
        assertEquals(6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), "Example array should have a max of 6");
    }

}
