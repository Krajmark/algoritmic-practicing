import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Trues:");//false
        System.out.println(isValid("()"));//true
        System.out.println(isValid("()[]{}"));//true
        System.out.println(isValid("{()}"));//true
        System.out.println("Falses:");
        System.out.println(isValid("(]"));//false
        System.out.println(isValid(")[]{}"));//false
        System.out.println(isValid("()]{}"));//false
        System.out.println(isValid("()[][{}"));//false
    }
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        String[] strings = s.split("");
        List<String> activeParentheses = new ArrayList<>();
        for (String current : strings) {
            if (current.equals("(")) {
                activeParentheses.add(current);
                continue;
            }
            if (current.equals("[")) {
                activeParentheses.add(current);
                continue;
            }
            if (current.equals("{")) {
                activeParentheses.add(current);
                continue;
            }
            if (activeParentheses.isEmpty()) {
                return false;
            }
            if (current.equals(")")) {
                if(activeParentheses.get(activeParentheses.size() - 1).equals("(")) {
                    activeParentheses.remove(activeParentheses.size() - 1);
                    continue;
                }
            }
            if (current.equals("]")) {
                if(activeParentheses.get(activeParentheses.size() - 1).equals("[")) {
                    activeParentheses.remove(activeParentheses.size() - 1);
                    continue;
                }
            }
            if (current.equals("}")) {
                if(activeParentheses.get(activeParentheses.size() - 1).equals("{")) {
                    activeParentheses.remove(activeParentheses.size() - 1);
                    continue;
                }
            }
            return false;
        }
        return activeParentheses.isEmpty();
    }
}
