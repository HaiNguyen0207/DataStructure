package Array.Lesson1_5;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter the number of " +
                "element of the array : ");
        var n = input.nextInt();
        var array = enterDataForArray(n);
        showArray(array);
        System.out.println("\nEnter sum : ");
        var s = input.nextInt();
        System.out.println(showResult(array, s));
    }

    private static boolean showResult(int[] array, int s) {
        boolean result[] = new boolean[s+1];
        result[0] = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = s; j >= array[i]; j--) {
                if (result[j - array[i]] == true) {
                    result[j] = true;
                }
            }
        }
        return result[s];
    }

    private static void showArray(int[] array) {
        for (var e : array) {
            System.out.printf("%3d", e);
        }
        System.out.printf("");
    }

    private static int[] enterDataForArray(int n) {
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Array[%d] = ", i);
            array[i] = new Scanner(System.in).nextInt();
        }
        return array;
    }
}
