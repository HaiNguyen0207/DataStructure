package Array.Lesson1_1;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        var test = input.nextInt();
        input.nextLine();
        while (test > 0) {
            var str = input.nextLine();
            var array = str.split("\\s+");
            showResult(array);
        }
    }

    private static void showResult(String[] array) {
        Arrays.sort(array);
        for (var item : array) {
            System.out.print(item + " ");
        }
    }
}