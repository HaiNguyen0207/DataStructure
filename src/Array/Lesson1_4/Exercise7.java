package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập chuỗi : ");
        var str = input.nextLine();
        printStrReverse(str, str.length()-1);
    }

    private static void printStrReverse(String str, int length) {
        if (length >= 0) {
            System.out.print(str.charAt(length));
            printStrReverse(str, length - 1);
        }
    }
}
