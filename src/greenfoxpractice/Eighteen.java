package greenfoxpractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Your job is to write a function which increments a string, to create a new string.
If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.
Examples:
foo -> foo1
foobar23 -> foobar24
foo0042 -> foo0043
foo9 -> foo10
foo099 -> foo100
Attention: If the number has leading zeros the amount of digits should be considered
* */
public class Eighteen {
    public static void main(String[] args) {
        System.out.println(numberify("foo"));
        System.out.println(numberify("foobar23"));
        System.out.println(numberify("foo0042"));
        System.out.println(numberify("foo9"));
        System.out.println(numberify("foo099"));
    }

    private static String numberify(String input) {
        String pattern = "([a-z]*)([0-9]*)";
        Pattern regexp = Pattern.compile(pattern);
        Matcher matcher = regexp.matcher(input);
        if (matcher.find()) {
            String newNumberAsString = null;
            try {
                int number = Integer.parseInt(matcher.group(2)) + 1;
                newNumberAsString = "0".repeat(matcher.group(2).length() - String.valueOf(number).length()) + number;
            } catch (Exception e) {
                newNumberAsString = "1";
            }
            return matcher.group(1) + newNumberAsString;
        }
        return "NO MATCH";
    }
}