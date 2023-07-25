package Array.Lesson1_5;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter the number nth : ");
        var n = input.nextInt();
        System.out.printf("%d ugly number : %d", n, uglyNumber(n));
    }

    private static long uglyNumber(int n) {
        int ugly[] = new int[n];
        int next = 1;
        int two = 0;
        int three = 0;
        int five = 0;
        int nm2 = 2;
        int nm3 = 3;
        int nm5 = 5;
        for (int i = 1; i < n; i++) {
            next = Math.min(nm2, Math.min(nm3, nm5));

            ugly[i] = next;
            if (next == nm2) {
                two = two + 1;
                nm2 = ugly[two] * 2;
            }
            if (next == nm3) {
                three = three + 1;
                nm3 = ugly[three] * 3;
            }
            if (next == nm5) {
                five = five + 1;
                nm5 = ugly[five] * 5;
            }
        }
        return next;
    }
}
