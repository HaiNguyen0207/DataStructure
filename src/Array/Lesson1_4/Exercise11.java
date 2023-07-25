package Array.Lesson1_4;

import java.util.Scanner;

public class Exercise11 {

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập số hàng ma trận : ");
        var row = input.nextInt();
        System.out.println("Nhập số cột ma trận : ");
        var col = input.nextInt();
        int matrix[][] = new int[row][col];
        var x1 = 0;
        var x2 = col - 1;
        var y1 = 0;
        var y2 = row - 1;
        var value = 1;
        topRight(matrix, x1, x2, y1, y2, value);
        showResult(matrix);
    }

    private static void showResult(int[][] matrix) {
        for (var row : matrix) {
            for (var e : row) {
                System.out.printf("%3d", e);
            }
            System.out.println();
        }
    }

    /**
     * x1           x2
     * a00 a01 a02 a03 y1
     * a10 a11 a12 a13
     * a20 a21 a22 a23
     * a30 a31 a32 a33 y2
     */
    private static void topRight(int[][] matrix, int x1, int x2,
                                 int y1, int y2, int value) {
        for (int i = x1; i <= x2; i++) {
            matrix[y1][i] = value;
            value++;
        }
        for (int i = y1 + 1; i <= y2; i++) {
            matrix[i][x2] = value;
            value++;
        }
        if (x2 - x1 > 0 && y2 - y1 > 0) {
            x2--;
            y1++;
            bottomLeft(matrix, x1, x2, y1, y2, value);
        }
    }

    private static void bottomLeft(int[][] matrix, int x1, int x2,
                                   int y1, int y2, int value) {
        for (int i = x2; i >= x1; i--) {
            matrix[y2][i] = value;
            value++;
        }
        for (int i = y2 - 1; i >= y1; i--) {
            matrix[i][x1] = value;
            value++;
        }
        if (x2 - x1 > 0 && y2 - y1 > 0) {
            y2--;
            x1++;
            topRight(matrix, x1, x2, y1, y2, value);
        }
    }
}
