package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        System.out.println(sum(n));
    }

    private static long sum(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return n + sum(n - 1);
        }
    }
}
