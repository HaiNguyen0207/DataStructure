package Array.Lesson1_8;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var t = input.nextInt();
        var count = 1;
        while (t-- > 0) {
            var n = input.nextInt();
            var array = enterDataForArray(n);
            System.out.printf("Exercise1 %d : ", count++);
            generateBinary(array);
        }
    }

    private static void generateBinary(int[] array) {
        boolean isFinal = nextBinaryString(array);
        if (!isFinal) {
            outputArray(array);
        } else { // nếu đây là cấu hình cuối
            System.out.println("UNAVAILABLE");
        }
    }

    private static boolean nextBinaryString(int[] array) {
        var i = array.length - 1;
        while (i >= 0 && array[i] != 0) {
            array[i] = 1;
            i--;
            break;
        }
        if (i >= 0) {
            array[i] = 1;
            return false;
        } else {
            return true;
        }
    }

    private static void outputArray(int[] array) {
        for (var e : array) {
            System.out.printf("%3d", e);

        }
        System.out.println();
    }

    private static int[] enterDataForArray(int n) {
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Scanner(System.in).nextInt();
        }
        return array;
    }
}
