package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập n = ");
        var n = input.nextInt();
        printNumberReverse(n);
    }

    private static void printNumberReverse(int n) {
        if(n > 0) {
            System.out.print(n%10);
            printNumberReverse(n/10);
        }
    }
}
