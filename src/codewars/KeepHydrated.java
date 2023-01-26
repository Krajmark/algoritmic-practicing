package codewars;

/*
Nathan loves cycling.

Because Nathan knows it is important to stay hydrated, he drinks 0.5 litres of water per hour of cycling.

You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.

For example:

time = 3 ----> litres = 1

time = 6.7---> litres = 3

time = 11.8--> litres = 5
*/
public class KeepHydrated {
    public static void main(String[] args) {
        System.out.println(Liters(2));
        System.out.println("Correct: 1");
        System.out.println(Liters(0.97));
        System.out.println("Correct:0 ");
        System.out.println(Liters(14.64));
        System.out.println("Correct: 7");
        System.out.println(Liters(1600.20));
        System.out.println("Correct: 800");
        System.out.println(Liters(80));
        System.out.println("Correct: 40");
    }
    public static int Liters(double time) {
        return ((int) time) / 2;
    }
}
