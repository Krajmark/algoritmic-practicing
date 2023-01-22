import java.util.Arrays;

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.*/
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1100", "1"));//"100"
        System.out.println(addBinary("11", "1"));//"100"
        System.out.println(addBinary("1010", "1011"));//"10101"
        System.out.println("Expected:");
        System.out.println(addBinary(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
        ));//"110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
        System.out.println("Actual:");
        System.out.println("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000");
        System.out.println("00100000001101000111111101101000011100001100011100010100111111011000010011100011110011010010011000000000");
    }

    public static String addBinary(String a, String b) {
        Integer[] aArray = Arrays.stream(a.split("")).map(Integer::parseInt).toArray(Integer[]::new);
        String[] bArray = b.split("");
        int sum = 0;
        for (int i = a.length() - 1, j = 0; i >= 0; i--, j++) {
            sum += aArray[i] * Math.pow(2, j);
        }
        for (int i = b.length() - 1, j = 0; i >= 0; i--, j++) {
            sum += Integer.parseInt(bArray[i]) * Math.pow(2, j);
        }
        StringBuilder output = new StringBuilder();
        output.append(sum % 2);
        int quotient = sum / 2;
        for (int i = 0; quotient > 0; i++) {
            output.append(quotient % 2);
            quotient = quotient / 2;

        }
        output.reverse();
        return output.toString();
    }
}
