/*
Digital root is the recursive sum of all the digits in a number.
Given n, take the sum of the digits of n.
If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
The input will be a non-negative integer.
Examples
    16  -->  1 + 6 = 7
   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
*/
public class Two {
    public static void main(String[] args) {
        System.out.println(recursiveSum(16));
        System.out.println(recursiveSum(942));
        System.out.println(recursiveSum(132189));
        System.out.println(recursiveSum(493193));
        System.out.println(recursiveSum(0));
    }
    public static int recursiveSum(int n) {
        String stringyfied = String.valueOf(n);
        String[] numbers = stringyfied.split("");
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        if (String.valueOf(sum).length() == 1) {
            return sum;
        }
        return recursiveSum(sum);
    }
}
