package Array.Lesson1_5;

import java.util.Scanner;

public class Ex1 {
    //tính xem có bao nhiêu cách tạo số n từ tập { 1 3 5}
    private static final int Max = 200;
    private static final long dp[] = new long[Max + 1];

    public static void main(String[] args) {
        var input = new Scanner(System.in);
        System.out.println("Nhập số n = ");
        var n = input.nextInt();
        System.out.println("Có số cách : " + createNewNumber(n));
    }

    private static long createNewNumber(int n) {
        if (n < 0) {
            return dp[0] = 0;
        } else if (n == 0) {
            return dp[1] = 1;
        } else if (dp[n] == 0) {
            dp[n] = createNewNumber(n - 1) + createNewNumber(n - 3)
                    + createNewNumber(n - 5);
        }
        return dp[n];
    }
}
