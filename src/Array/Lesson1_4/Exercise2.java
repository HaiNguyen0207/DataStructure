package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        System.out.printf("Fibonacci(%d) = %d", n, fibonnaci(n));
    }

    private static int fibonnaci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonnaci(n - 1) + fibonnaci(n - 2);
        }
    }
}
