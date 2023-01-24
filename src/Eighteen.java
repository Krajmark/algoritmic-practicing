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
public class Eighteen {
    public static void main(String[] args) {
        System.out.println(numberify("foo"));
        System.out.println(numberify("foobar23"));
        System.out.println(numberify("foo0042"));
        System.out.println(numberify("foo9"));
        System.out.println(numberify("foo099"));
    }

    private static String numberify(String input) {
        String[] inputLetters = input.split("");
        StringBuilder stringBuilderForNumbers = new StringBuilder();
        StringBuilder stringBuilderForLetters = new StringBuilder();
        boolean numberSwitch = false;
        for (int i = 0; i < input.length(); i++) {
            try {
                if (inputLetters[i].matches("[1-9]")) {
                    numberSwitch = true;
                }
                if (numberSwitch) {
                    stringBuilderForNumbers.append(Integer.parseInt(inputLetters[i]));
                    continue;
                }
                stringBuilderForLetters.append(inputLetters[i]);
            } catch (NumberFormatException e) {
                stringBuilderForLetters.append(inputLetters[i]);
            }
        }
        if (stringBuilderForNumbers.isEmpty()) {
            return stringBuilderForLetters.append(1).toString();
        }
        return stringBuilderForLetters.append(Integer.parseInt(stringBuilderForNumbers.toString()) + 1).toString();
    }
}