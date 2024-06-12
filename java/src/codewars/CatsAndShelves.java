package codewars;

import java.util.List;

/*
An infinite number of shelves are arranged one above the other in a staggered fashion.
The cat can jump either one or three shelves at a time: from shelf i to shelf i+1 or i+3
(the cat cannot climb on the shelf directly above its head), according to the illustration:

                 ┌────────┐
                 │-6------│
                 └────────┘
┌────────┐
│------5-│
└────────┘  ┌─────► OK!
            │    ┌────────┐
            │    │-4------│
            │    └────────┘
┌────────┐  │
│------3-│  │
BANG!────┘  ├─────► OK!
  ▲  |\_/|  │    ┌────────┐
  │ ("^-^)  │    │-2------│
  │ )   (   │    └────────┘
┌─┴─┴───┴┬──┘
│------1-│
└────────┘
Input
Start and finish shelf numbers (always positive integers, finish no smaller than start)

Task
Find the minimum number of jumps to go from start to finish

Example
Start 1, finish 5, then answer is 2 (1 => 4 => 5 or 1 => 2 => 5)
1 -> 9 : 1 => 4 => 7 => 8 => 9
*/
public class CatsAndShelves {
    public static void main(String[] args) {
        System.out.println(shortestRoute(1,5));
        System.out.println("Correct: 2");
        System.out.println(shortestRoute(1,9));
        System.out.println("Correct: 4");
        System.out.println(shortestRoute(2,4));
        System.out.println("Correct: 2");
    }
    public static int shortestRoute(int start, int finish) {
        int counter = 0;
        while (start != finish) {
            if (finish - start >= 3) {
                counter++;
                start += 3;
                continue;
            }
            counter++;
            start++;
        }
        return counter;
    }
}
