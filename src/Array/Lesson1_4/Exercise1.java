package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        System.out.printf("%d!= %d", n, factorialN(n));
    }

    private static int factorialN(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorialN(n - 1);
        }
    }
}
