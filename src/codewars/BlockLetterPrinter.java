package codewars;

import java.util.HashMap;
import java.util.Map;

/*
Write a function that accepts a string consisting only of ASCII letters and the whitespace and returns that string in block letters of 5 characters width and 7 characters height, with one space between characters.

The block letters should consist of corresponding capital letters.
It's irrelevant whether input consists of lower or upper case letters.
Any leading and/or trailing whitespaces in input should be ignored.
Empty strings or such containing only whitespaces should return an empty string.
The remaining spaces (between letters and/or words) are to be treated as any other character. This means that there will be six spaces in output for a space in input, or a multiple of six, if there were more spaces - plus the one from preceding character!
Trailing spaces should be removed in the resulting string.
The string should be formatted in a way that when passed to Javas' System.out.println() function shows the desired output (see below for example).
BlockLetterPrinter.blockPrint("heLLo WorLD") will result in a string that looks like this when passed to the System.out.println() function:

H   H EEEEE L     L      OOO        W   W  OOO  RRRR  L     DDDD
H   H E     L     L     O   O       W   W O   O R   R L     D   D
H   H E     L     L     O   O       W   W O   O R   R L     D   D
HHHHH EEEEE L     L     O   O       W W W O   O RRRR  L     D   D
H   H E     L     L     O   O       W W W O   O R R   L     D   D
H   H E     L     L     O   O       W W W O   O R  R  L     D   D
H   H EEEEE LLLLL LLLLL  OOO         W W   OOO  R   R LLLLL DDDD
As most of the characters can be printed in many different ways (think of Q, F or W), here is what they're expected to look like:

 AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ
A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM NN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z
A   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M N   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z
AAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M N N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z
A   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M N   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z
A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M N  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z
A   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M N   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ
*/
public class BlockLetterPrinter {

    private static String[] dictionarySelect(String letter) {
        if (letter.equals("f")) return new String[]{
                "FFFFF",
                "F    ",
                "F    ",
                "FFFFF",
                "F    ",
                "F    ",
                "F    "
        };
        if (letter.equals("e")) return new String[]{
                "EEEEE",
                "E    ",
                "E    ",
                "EEEEE",
                "E    ",
                "E    ",
                "EEEEE"
        };
        if (letter.equals("d")) return new String[]{
                "DDDD ",
                "D   D",
                "D   D",
                "D   D",
                "D   D",
                "D   D",
                "DDDD "
        };
        if (letter.equals("c")) return new String[]{
                " CCC ",
                "C   C",
                "C    ",
                "C    ",
                "C    ",
                "C   C",
                " CCC "
        };
        if (letter.equals("b")) return new String[]{
                "BBB ",
                "B   B",
                "B   B",
                "BBB ",
                "B   B",
                "B   B",
                "BBB "
        };
        if (letter.equals("a")) return new String[]{
                " AAA ",
                "A   A",
                "A   A",
                "AAAAA",
                "A   A",
                "A   A",
                "A   A",
        };
        return null;
    }

    public static void main(String[] args) {
        System.out.println(blockPrint("ASD"));
    }

    public static String blockPrint(String string) {
        String[] letters = string.toLowerCase().split("");
        Map<String, String[]> requiredLetters = new HashMap<>();
        for (String letter : letters) {
            if (requiredLetters.containsKey(letter)) {
                continue;
            }
            requiredLetters.put(letter, dictionarySelect(letter));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (String letter : letters) {
                sb.append(requiredLetters.get(letter)[i]).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
