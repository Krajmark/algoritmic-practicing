package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgbToHexAndTest {
    /*
    https://www.codewars.com/kata/513e08acc600c94f01000001
The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned.
Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

The following are examples of expected output values:

RgbToHex.rgb(255, 255, 255) // returns FFFFFF
RgbToHex.rgb(255, 255, 300) // returns FFFFFF
RgbToHex.rgb(0, 0, 0)       // returns 000000
RgbToHex.rgb(148, 0, 211)   // returns 9400D3*/
    public static String rgb(int r, int g, int b) {
        return null;
    }

    @Test
    public void sampleTests() {
        assertEquals("000000", rgb(0, 0, 0), "For input: (0, 0, 0)");
        assertEquals("010203", rgb(1, 2, 3), "For input: (1, 2, 3)");
        assertEquals("FFFFFF", rgb(255, 255, 255), "For input: (255, 255, 255)");
        assertEquals("FEFDFC", rgb(254, 253, 252), "For input: (254, 253, 252)");
        assertEquals("00FF7D", rgb(-20, 275, 125), "For input: (-20, 275, 125)");
    }
}
