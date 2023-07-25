package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập a = ");
        var a = input.nextInt();
        System.out.println("Nhập b = ");
        var b = input.nextInt();
        System.out.printf("GCD( %d %d ) = %d ", a, b, gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else if (b % a == 0) {
            return a;
        } else {
            if (a > b) {
                return gcd(a % b, b);
            } else {
                return gcd(a, b % a);
            }
        }
    }
}
