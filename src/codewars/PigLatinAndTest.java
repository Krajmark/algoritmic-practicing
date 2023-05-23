package codewars;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Pattern pattern = Pattern.compile("([A-Za-z]+)(\\W*)");
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                String onlyLetters = matcher.group(1);
                Character firstLetter = onlyLetters.charAt(0);
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < onlyLetters.length(); i++) {
                    sb.append(onlyLetters.charAt(i));
                }
                sb.append(firstLetter).append("ay").append(matcher.group(2));
                sbToOut.append(sb).append(" ");
            } else {
                sbToOut.append(word).append(" ");
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
