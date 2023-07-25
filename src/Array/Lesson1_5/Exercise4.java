package Array.Lesson1_5;


import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter n = ");
        var n = input.nextInt();
        var matrix = enterDataFromMatrix(new int[n][n], n);
        showMatrix(matrix);
        var matrixResult = enterDataMatrixResult
                ( matrix, n);
        System.out.println("Enter x = ");
        var x = input.nextInt();
        System.out.println("Enter y = ");
        var y = input.nextInt();
        System.out.printf("Path min : (0 0 ) -> (%d %d ) = %d "
                , x, y, matrixResult[x][y]);

    }

    private static int[][] enterDataMatrixResult(int[][] matrix,
                                                  int n) {
        int[][] matrixResult = new int[n][n];
        matrixResult[0][0] = matrix[0][0];
        matrixResult[0][1] = matrix[0][0] + matrix[0][1];
        matrix[1][0] = matrix[0][0] + matrix[1][0];
        for (int i = 2; i < n; i++) {
            matrixResult[i][0] = matrixResult[i - 1][0] + matrix[i][0];
        }
        for (int j = 2; j < n; j++) {
            matrixResult[0][j] = matrixResult[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                matrixResult[i][j] = Math.min(matrixResult[i][j - 1],
                        matrixResult[i - 1][j - 1]);
                if (matrixResult[i][j] > matrixResult[i - 1][j]) {
                    matrixResult[i][j] = matrixResult[i - 1][j];
                }
                matrixResult[i][j] += matrix[i][j];
            }
        }
        return matrixResult;
    }


    private static void showMatrix(int[][] matrix) {
        for (var row : matrix) {
            for (var e : row) {
                System.out.printf("%5d", e);
            }
            System.out.println();
        }
    }

    private static int[][] enterDataFromMatrix(int[][] ints, int n) {
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Matrix[%d][%d] = ", i, j);
                matrix[i][j] = new Scanner(System.in).nextInt();
            }
        }
        return matrix;
    }
}
