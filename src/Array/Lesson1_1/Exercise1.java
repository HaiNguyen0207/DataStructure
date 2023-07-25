package Array.Lesson1_1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử : ");
        var n = input.nextInt();
        if (n > 0) {
            var array = enterArray(n, input);
            showResult(array);
        } else {
            System.out.println("Số lượng phần tử mảng > 0");
        }
    }

    private static void showResult(int[] array) {
        for (int item : array) {
            if (isPrime(item)) {
                System.out.print(item + " ");
            }
        }
    }

    private static boolean isPrime(int item) {
        if (item < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(item); i++) {
                if (item % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] enterArray(int n, Scanner input) {
        var array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập a[%d] = ", i);
            array[i] = input.nextInt();
        }
        return array;
    }
}
