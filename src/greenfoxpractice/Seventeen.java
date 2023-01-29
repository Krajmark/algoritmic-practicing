package greenfoxpractice;

import java.util.*;

/*
There is a queue for the self-checkout tills at the supermarket.
Your task is write a function to calculate the total time required for all the customers to check out!
input
customers: an array of positive integers representing the queue.
Each integer represents a customer, and its value is the amount of time they require to check out.
n: a positive integer, the number of checkout tills.
output
The function should return an integer, the total time required.

Important
Please look at the examples and clarifications below, to ensure you understand the task correctly :)

Examples
queueTime([5,3,4], 1)
// should return 12
// because when there is 1 till, the total time is just the sum of the times


queueTime([10,2,3,3], 2)
// should return 10
// because here n=2 and the 2nd, 3rd, and 4th people in the
// queue finish before the 1st person has finished.


queueTime([2,3,10], 2)
// should return 12
Clarifications
There is only ONE queue serving many tills, and
The order of the queue NEVER changes, and
The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
*/
public class Seventeen {
    public static void main(String[] args) {
        System.out.println(queueTime(new int[]{5, 3, 4}, 1));
        System.out.println("Correct: 12");
        System.out.println(queueTime(new int[]{10, 2, 3, 3}, 2));
        System.out.println("Correct: 10");
        System.out.println(queueTime(new int[]{2, 3, 10}, 2));
        System.out.println("Correct: 12");
        System.out.println(queueTime(new int[]{2, 3, 3, 10}, 4));
        System.out.println("Correct: 10");
    }

    private static int queueTime(int[] queue, int n) {
        int timeElapsed = 0;
        List<Integer> customers = new ArrayList<>();
        for (Integer customer : queue) {
            customers.add(customer);
        }
        while (!customers.isEmpty()) {
            timeElapsed++;
            for (int i = 0; i < n; i++) {
                if (customers.size() == i) {
                    break;
                }
                customers.set(i, customers.get(i) - 1);
            }
            customers.removeIf(customer -> customer == 0);
        }
        return timeElapsed;
    }
}
