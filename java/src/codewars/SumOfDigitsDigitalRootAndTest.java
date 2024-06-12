package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://www.codewars.com/kata/541c8630095125aba6000c00
Digital root(https://en.wikipedia.org/wiki/Digital_root) is the recursive sum of all the digits in a number.

Given n, take the sum of the digits of n. If that value has more than one digit,
continue reducing in this way until a single-digit number is produced.
The input will be a non-negative integer.

Examples
    16  -->  1 + 6 = 7
   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2*/
public class SumOfDigitsDigitalRootAndTest {
    public static int digital_root(int n) {
        int abs = Math.abs(n);
        if (abs < 10) return abs;
        int toReturn = 0;
        String[] numbers = String.valueOf(abs).split("");
        for (String number : numbers) {
            toReturn += Integer.parseInt(number);
        }
        return digital_root(toReturn);
    }
    @Test
    public void Test1() {
        assertEquals(7, SumOfDigitsDigitalRootAndTest.digital_root(16), "Nope!"  );
    }
    @Test
    public void Test2() {
        assertEquals(6, SumOfDigitsDigitalRootAndTest.digital_root(456),  "Nope!" );
    }
    @Test
    public void Test3() {
        assertEquals(6, SumOfDigitsDigitalRootAndTest.digital_root(-456),  "Nope!" );
    }
}
