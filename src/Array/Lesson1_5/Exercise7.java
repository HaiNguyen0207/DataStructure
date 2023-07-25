package Array.Lesson1_5;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter the number of " +
                "elements of the array : ");
        var n = input.nextInt();
        var array = EnterDataForArray(n);
        showArray(array);
        System.out.println("\nSubstring ascending length : "
                + showResult(array));
    }

    private static int showResult(int[] array) {
        int result = 0;
        int F[] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            F[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    F[i] = Math.max(F[i], F[j] + 1);
                }
            }
            result = Math.max(result, F[i]);
        }
        return result;
    }

    private static void showArray(int[] array) {
        for (var e : array) {
            System.out.printf("%3d", e);
        }
    }

    private static int[] EnterDataForArray(int n) {
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Array[%d] = ", i);
            array[i] = new Scanner(System.in).nextInt();
        }
        return array;
    }
}
