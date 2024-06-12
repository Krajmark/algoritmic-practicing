package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://www.codewars.com/kata/5264d2b162488dc400000001
Write a function that takes in a string of one or more words, and returns the same string,
but with all five or more letter words reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces.
Spaces will be included only when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"
*/
public class StopGninnipSMysdroWAndTest {
    public String spinWords(String sentence) {
        if (sentence.length() < 5) return sentence;

        String[] words = sentence.trim().split( " +");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() < 5) {
                sb.append(word).append(" ");
                continue;
            }
            StringBuilder sbReverser = new StringBuilder();
            sbReverser.append(word).reverse();
            sb.append(sbReverser).append(" ");
        }
        return sb.toString().trim();
    }
    @Test
    public void test() {
        assertEquals("emocleW", new StopGninnipSMysdroWAndTest().spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", new StopGninnipSMysdroWAndTest().spinWords("Hey fellow warriors"));
        assertEquals("Hey, wollef !sroirraw", new StopGninnipSMysdroWAndTest().spinWords("Hey, fellow warriors!"));
    }
}
