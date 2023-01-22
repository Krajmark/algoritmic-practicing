public class LongestCommonPrefix {
    /*
    * Write a function to find the longest common prefix string amongst an array of strings.
    * If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
    * */
    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flowering"}));

    }
    public static String longestCommonPrefix(String[] strs) {
        int shortestLength = 200;
        String shortestWord = "";
        for (String word : strs) {
            if (word.length() <= shortestLength) {
                shortestLength = word.length();
                shortestWord = word;
            }
        }
        String matching = "-";
        boolean checkNextChar = true;
        for (int i = 0; i < shortestLength; i++) {
            Character currentChar = shortestWord.charAt(i);
            for (String word : strs) {
                if (currentChar != word.charAt(i)) {
                    checkNextChar = false;
                    break;
                }
            }
            if (checkNextChar) {
                matching += String.valueOf(currentChar);
            } else {
                break;
            }
        }
        return matching;
    }
}
