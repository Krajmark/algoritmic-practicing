package greenfoxpractice;

/*Complete the function that accepts a string parameter, and reverses each word in the string. All spaces in the string should be retained.
Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps
*/
public class TwentyOne {
    public static void main(String[] args) {
        System.out.println(reverseMe("This is an example!"));
        System.out.println(reverseMe("double  spaces"));
    }
    public static String reverseMe(String input) {
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            StringBuilder wordBuilder = new StringBuilder();
            wordBuilder.append(word).reverse();
            sb.append(wordBuilder).append(" ");
        }
        return sb.toString();
    }

}
