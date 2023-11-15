package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/525f50e3b73515a6db000b83/java
Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.

Example
Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
The returned format must be correct in order to complete this challenge.

Don't forget the space after the closing parentheses!*/

public class CreatePhoneNumberAndTest {

    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length > 10) return null;
        StringBuilder stringBuilder = new StringBuilder("(");
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
            if (i == 2) {
                stringBuilder.append(") ");
            }
            if (i == 5) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }
//    by others https://www.codewars.com/kata/reviews/56d3653a689ad870e300001f/groups/56e6fa6d988e85bfac0012ef
    public static String createPhoneNumber2(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }

    @Test
    public void tests() {
        assertEquals(2,1+1);
        assertEquals("(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

}
