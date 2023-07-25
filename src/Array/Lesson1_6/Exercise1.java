package Array.Lesson1_6;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Enter N = ");
        var n = input.nextInt();
        int board[][] = new int[n][n];
        var result = solveNQueen(board, 0, n);
        if (result) {
            System.out.println("one of the valid ways :");
            showResult(board);
        } else {
            System.out.println("NO Way!");
        }
    }

    private static void showResult(int[][] board) {
        for (var row : board) {
            for (var e : row) {
                System.out.printf("%5d", e);
            }
            System.out.println();
        }

    }

    private static boolean solveNQueen(int[][] board, int col, int n) {
        if (col >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;
                if (solveNQueen(board, col + 1, n)) {
                    return true;
                } else {
                    board[i][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
