package Array.Lesson1_5;

import java.util.Scanner;

public class Exercise1 {
    private static final int Max = 90;
    private static final long fibo[] = new long[Max];

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        System.out.printf("Số Fibonacci thứ %d = %d ", n, fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n < 2) {
            return fibo[n] = n;
        } else {
            return fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
