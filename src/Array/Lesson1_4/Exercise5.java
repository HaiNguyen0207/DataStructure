package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise5 {
    private static int count = 0;

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        var result = countNumber(n);
        System.out.println(result);
    }

    private static int countNumber(int n) {
        if (n > 0) {
            count++;
            countNumber(n / 10);
        }
        return count;
    }
}
