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

    public static void main(String[] args) {
        System.out.println(blockPrint("ASD"));
        System.out.println(blockPrint("Hello Word!"));
        System.out.println(blockPrint("Hi! My name is Mark!"));
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
                if (requiredLetters.get(letter) != null) {
                    sb.append(requiredLetters.get(letter)[i]);
                }
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static String[] dictionarySelect(String letter) {
        if (letter.equals("z")) return new String[]{
                "ZZZZZ",
                "    Z",
                "   Z ",
                "  Z  ",
                " Z   ",
                "Z    ",
                "ZZZZZ"
        };
        if (letter.equals("y")) return new String[]{
                "Y   Y",
                "Y   Y",
                " Y Y ",
                "  Y  ",
                "  Y  ",
                "  Y  ",
                "  Y  "
        };
        if (letter.equals("x")) return new String[]{
                "X   X",
                "X   X",
                " X X ",
                "  X  ",
                " X X ",
                "X   X",
                "X   X"
        };
        if (letter.equals("w")) return new String[]{
                "W   W",
                "W   W",
                "W   W",
                "W W W",
                "W W W",
                "W W W",
                " W W "
        };
        if (letter.equals("v")) return new String[]{
                "V   V",
                "V   V",
                "V   V",
                "V   V",
                "V   V",
                " V V ",
                "  V  "
        };
        if (letter.equals("u")) return new String[]{
                "U   U",
                "U   U",
                "U   U",
                "U   U",
                "U   U",
                "U   U",
                " UUU "
        };
        if (letter.equals("t")) return new String[]{
                "TTTTT",
                "  T  ",
                "  T  ",
                "  T  ",
                "  T  ",
                "  T  ",
                "  T  "
        };
        if (letter.equals("s")) return new String[]{
                " SSS ",
                "S   S",
                "S    ",
                " SSS ",
                "    S",
                "S   S",
                " SSS "
        };
        if (letter.equals("r")) return new String[]{
                "RRRR ",
                "R   R",
                "R   R",
                "RRRR ",
                "P R  ",
                "P  R ",
                "P   R"
        };
        if (letter.equals("q")) return new String[]{
                " QQQ ",
                "Q   Q",
                "Q   Q",
                "Q   Q",
                "Q Q Q",
                "Q  QQ",
                " QQQQ"
        };
        if (letter.equals("p")) return new String[]{
                "PPPP ",
                "P   P",
                "P   P",
                "PPPP ",
                "P    ",
                "P    ",
                "P    "
        };
        if (letter.equals("o")) return new String[]{
                " OOO ",
                "O   O",
                "O   O",
                "O   O",
                "O   O",
                "O   O",
                " OOO "
        };
        if (letter.equals("n")) return new String[]{
                "N   N",
                "MM  N",
                "N   N",
                "N N N",
                "N   N",
                "N  NN",
                "N   N"
        };
        if (letter.equals("m")) return new String[]{
                "M   M",
                "MM MM",
                "M M M",
                "M   M",
                "M   M",
                "M   M",
                "M   M"
        };
        if (letter.equals("l")) return new String[]{
                "L    ",
                "L    ",
                "L    ",
                "L    ",
                "L    ",
                "L    ",
                "LLLLL"
        };
        if (letter.equals("k")) return new String[]{
                "K   K",
                "K  K ",
                "K K  ",
                "KK   ",
                "K K  ",
                "K  K ",
                "K   K"
        };
        if (letter.equals("i")) return new String[]{
                "IIIII",
                "  I  ",
                "  I  ",
                "  I  ",
                "  I  ",
                "  I  ",
                "IIIII"
        };
        if (letter.equals("h")) return new String[]{
                "H   H",
                "H   H",
                "H   H",
                "HHHHH",
                "H   H",
                "H   H",
                "H   H"
        };
        if (letter.equals("g")) return new String[]{
                " GGG ",
                "G   G",
                "G    ",
                "G GGG",
                "G   G",
                "G   G",
                " GGG "
        };
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
                "BBBB ",
                "B   B",
                "B   B",
                "BBBB ",
                "B   B",
                "B   B",
                "BBBB "
        };
        if (letter.equals("a")) return new String[]{
                " AAA ",
                "A   A",
                "A   A",
                "AAAAA",
                "A   A",
                "A   A",
                "A   A"
        };
        if (letter.equals(" ")) return new String[]{
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     ",
                "     "
        };
        return null;
    }
}
