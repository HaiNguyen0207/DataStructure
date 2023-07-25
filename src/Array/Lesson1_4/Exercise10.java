package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        var result = sum(n);
        System.out.println(result);
    }

    private static double sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return  1.0 / n + sum(n - 1);
        }
    }
}
