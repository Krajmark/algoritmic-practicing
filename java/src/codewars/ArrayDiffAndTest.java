package codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
https://www.codewars.com/kata/523f5d21c841566fde000009
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
*/
public class ArrayDiffAndTest {
    public static int[] arrayDiff(int[] a, int[] b) {
        Set<Integer> pool = new HashSet<>(Arrays.stream(b).boxed().toList());
        List<Integer> toReturn = new java.util.ArrayList<>(Arrays.stream(a).boxed().toList());
        toReturn.removeIf(pool::contains);
        return toReturn.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    public void sampleTests() {
        assertArrayEquals(new int[] {2}, arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, arrayDiff(new int [] {}, new int[] {1,2}));
    }
}
