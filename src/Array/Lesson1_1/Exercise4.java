package Array.Lesson1_1;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử : ");
        var n = input.nextInt();
        input.nextLine();
        System.out.println("Nhập vị trì chèn : ");
        var k = input.nextInt();
        System.out.println("Nhập giá trị chèn : ");
        var x = input.nextInt();
        var array = new int[n + 1];
        getArray(array, n, input);
        insert(array, n, k, x);
        showResult(array);
    }

    private static void getArray(int[] array, int n, Scanner input) {
        for (int i = 0; i < n; i++) {
            System.out.printf("Nhập a[%d] = ", i);
            array[i] = input.nextInt();
        }
    }

    private static void insert(int[] array, int n, int k, int x) {
        if (k <= 0) {
            k = 0;
        }
        if (k >= n) {
            k = array.length - 1;
        } else {
            for (int i = array.length - 1; i > k; i--) {
                array[i] = array[i - 1];
            }
        }
        array[k] = x;
    }

    private static void showResult(int[] array) {
        for (var item : array) {
            System.out.print(item + " ");
        }
    }
}
