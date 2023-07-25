package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise6 {
    private static int number = 0;

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        System.out.println(findNumberFirst(n));
    }

    private static int findNumberFirst(int n) {
        if (n > 0) {
            number = n % 10;
            findNumberFirst(n / 10);
        }
        return number;
    }
}
