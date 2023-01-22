import java.util.Objects;

/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.*/
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));//true
        System.out.println(isValid("()[]{}"));//true
        System.out.println(isValid("(]"));//false
        System.out.println(isValid("{()}"));//true
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        String[] strings = s.split("");
        for (int i = 0; i + 1 < strings.length; i++) {
            if ((Objects.equals(strings[i], "(")) && (Objects.equals(strings[i + 1], ")"))) {
                i++;
                continue;
            }
            if ((Objects.equals(strings[i], "[")) && (Objects.equals(strings[i + 1], "]"))) {
                i++;
                continue;
            }
            if ((Objects.equals(strings[i], "{")) && (Objects.equals(strings[i + 1], "}"))) {
                i++;
                continue;
            }
            return false;
        }
        return true;
    }
}
