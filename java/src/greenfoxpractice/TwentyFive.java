package greenfoxpractice;

public class TwentyFive {
    /*
    This is on codewars too...
    Every book has n pages with page numbers 1 to n. The summary is made by adding up the number of digits of all page numbers.

Task: Given the summary, find the number of pages n the book has.

Example
If the input is summary=25, then the output must be n=17: The numbers 1 to 17 have 25 digits in total: 1234567891011121314151617.

Be aware that you'll get enormous books having up to 100.000 pages.

All inputs will be valid.

Here's the opposite kata, which is more complex (Paginating a huge book)*/
    public static void main(String[] args) {
        System.out.println(amountOfPages(5));
        System.out.println("Correct: 5");
        System.out.println(amountOfPages(25));
        System.out.println("Correct: 17");
        System.out.println(amountOfPages(1095));
        System.out.println("Correct: 401");

        System.out.println(amountOfPagesAlternate(5));
        System.out.println("Correct: 5");
        System.out.println(amountOfPagesAlternate(25));
        System.out.println("Correct: 17");
        System.out.println(amountOfPagesAlternate(1095));
        System.out.println("Correct: 401");
    }
    public static int amountOfPages(int summary) {
//        String asd = "12345678910111213141517...100...output"; -> ""
//        summary == asd.length();
        int output = 1;
        while (true) {
            summary -= String.valueOf(output).length();
            if (summary <= 0) break;
            output++ ;
        }
        return output;
    }

    public static int amountOfPagesAlternate(int summary) {
        int output = 1;
        String checkSummary = "";
        while (true) {
            checkSummary = checkSummary.concat(String.valueOf(output));
            if (checkSummary.length() == summary) break;
            output++;
        }
        return output;
    }
}
