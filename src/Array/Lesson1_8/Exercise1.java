package Array.Lesson1_8;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter N = ");
        var n = input.nextInt();
        int array[] = new int[n];
        generateBinary(array);

    }

    private static void generateBinary(int[] array) {
        boolean isFinal = false;
        while (!isFinal) {
            outputBinaryString(array);
            isFinal = nextBinaryStrig(array);
        }
    }

    private static void outputBinaryString(int[] array) {
        for (var e : array) {
            System.out.printf("%3d", e);
        }
        System.out.println();
    }

    private static boolean nextBinaryStrig(int[] array) {
        var i = array.length - 1;
        while (i >= 0 && array[i] != 0) {
            array[i] = 0;
            i--;
        }
        if (i >= 0) {
            array[i] = 1;
            return false;
        } else {
            return true;
        }
    }
}
