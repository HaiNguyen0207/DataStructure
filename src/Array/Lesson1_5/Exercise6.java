package Array.Lesson1_5;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.printf("Enter string 1 : ");
        var string1 = input.nextLine();
        string1 = "0" + string1;
        var str1 = string1.split("");
        System.out.printf("Enter string 2 : ");
        var string2 = input.nextLine();
        string2 = "0" + string2;
        var str2 = string2.split("");
        int result[][] = new int[str1.length][str2.length];
        System.out.printf("Substring of length : %d",
                showResult(result, str1, str2));
        System.out.println();
        showTableSubstring(result);

    }

    private static void showTableSubstring(int[][] result) {
        for (var row : result) {
            for (var e : row) {
                System.out.printf("%5d", e);
            }
            System.out.println();
        }
    }


    private static int showResult(int[][] result,
                                  String[] str1, String[] str2) {
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else {
                    if (str1[i].compareTo(str2[j]) == 0) {
                        result[i][j] = result[i - 1][j - 1] + 1;
                    } else {
                        result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                    }
                }
            }
        }
        return result[str1.length - 1][str2.length - 1];
    }
}
