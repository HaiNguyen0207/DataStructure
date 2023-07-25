package Array.Lesson1_1;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var test = input.nextInt();
        while (test > 0) {
            var n = input.nextInt();
            var array = getArray(n, input);
            showResult(array);
            test--;
        }
    }

    private static void showResult(int[] array) {
        if (isValid(array)) {
            System.out.println("YES");
        } else {
            System.out.println("FALSE");
        }
    }

    private static boolean isValid(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getArray(int n, Scanner input) {
        var array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }
}
