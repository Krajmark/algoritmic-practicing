package codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigLatinAndTest {
    /*
    https://www.codewars.com/kata/520b9d2ad5c005041100000f
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
Examples
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !*/

    public static String pigIt(String str) {
        String[] words = str.trim().split(" +");
        StringBuilder sbToOut = new StringBuilder();
        for (String word : words) {
            char[] letters = word.toCharArray();
            char first = letters[0];
            if (Character.isAlphabetic(first)) {
                StringBuilder sb = new StringBuilder();
                List<Character> nonAlphabeticChars = new ArrayList<>();
                for (int i = 1; i < letters.length; i++) {
                    if (!Character.isAlphabetic(letters[i])) {
                        nonAlphabeticChars.add(letters[i]);
                        continue;
                    }
                    sb.append(letters[i]);
                }
                sb.append(first).append("ay");
                if (!nonAlphabeticChars.isEmpty()) {
                    for (Character character : nonAlphabeticChars) {
                        sb.append(character);
                    }
                }
                sbToOut.append(sb).append(" ");
            } else {
                sbToOut.append(word);
            }
        }
        return sbToOut.deleteCharAt(sbToOut.length() - 1).toString();
    }
    
    @Test
    public void FixedTests() {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
        assertEquals("hisTay siay ymay tringsay, oday tiay ikelay histay!", pigIt("This is my string, do it like this!"));
        assertEquals("hisTay siay ymay tringsay;) oday tiay ikelay histay!!!", pigIt("This is my string;) do it like this!!!"));
//        assertEquals("<...oratay oay oresmay ![]>", pigIt("This is my string;) do it like this!!!"));
    }
}
