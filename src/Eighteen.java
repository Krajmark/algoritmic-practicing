import java.util.ArrayList;
import java.util.List;

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
public class Main {
    public static void main(String[] args) {
        System.out.println(numberify("foo"));
        System.out.println(numberify("foobar23"));
        System.out.println(numberify("foo0042"));
        System.out.println(numberify("foo9"));
        System.out.println(numberify("foo099"));
    }

    private static String numberify(String input) {
        String[] letters = input.split("");
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            Integer digit = null;
            try {
                 digit = Integer.parseInt(letters[i]);
            } catch (NumberFormatException e) {
                continue;
            }
            digits.add(digit);
        }
        String output = input.substring(0, input.length() - digits.size());
        StringBuilder sb = new StringBuilder();
        for (Integer digit : digits) {
            sb.append(digit);
        }
        if (digits.isEmpty()) {
            return output + 1;
        }
        Integer number = null;
        try {
            number = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
        }
        number++;
        output += number;
        return output;
    }
}