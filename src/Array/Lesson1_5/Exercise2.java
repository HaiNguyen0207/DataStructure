package Array.Lesson1_5;

import java.util.Scanner;

public class Exercise2 {
    private static final int Max = 90;
    private static final long facto[] = new long[Max];

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        System.out.printf("%d! = %d", n, factorial(n));
    }

    private static long factorial(int n) {
        if (n <= 2) {
            return facto[n] = n;
        } else {
            return facto[n] = n * factorial(n - 1);
        }
    }
}
