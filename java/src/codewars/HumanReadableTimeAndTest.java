package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanReadableTimeAndTest {
    /*
    https://www.codewars.com/kata/52685f7382004e774f0001f7
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)
HH = hours, padded to 2 digits, range: 00 - 99
MM = minutes, padded to 2 digits, range: 00 - 59
SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.*/
    
    public static String makeReadable(int seconds) {
        StringBuilder sb = new StringBuilder();
        String[] secMinHr = new String[3];

        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                secMinHr[i] = String.valueOf(seconds);
                continue;
            }
            secMinHr[i] = String.valueOf(seconds % 60);
            seconds /= 60;
        }

        for (int i = 2; i >= 0; i--) {
            if (secMinHr[i].length() < 2) {
                sb.append("0").append(secMinHr[i]).append(":");
                continue;
            }
            sb.append(secMinHr[i]).append(":");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    @Test
    public void Tests() {
        assertEquals("00:00:00", makeReadable(0),"makeReadable(0)");
        assertEquals("00:00:05", makeReadable(5), "makeReadable(5)");
        assertEquals("00:01:00", makeReadable(60), "makeReadable(60)");
        assertEquals("23:59:59", makeReadable(86399), "makeReadable(86399)");
        assertEquals("99:59:59", makeReadable(359999), "makeReadable(359999)");
    }
}
