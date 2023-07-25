package Array.Lesson1_5;

public class Exercise3 {
    public static void main(String[] args) {
        var weightBag = 10; //trọng túilượng của cái túi
        int weightItems[] = {1, 2, 4, 5, 7, 6};
        int valueItems[] = {15, 2, 65, 38, 1,2};
        int n = valueItems.length;
        int result[][] = new int[n + 1][weightBag + 1];
        System.out.println(knapSack(weightBag, weightItems, valueItems, n, result));
        System.out.println();
        showResult(result);
    }

    private static void showResult(int[][] result) {
        for (var row : result) {
            for (var e : row) {
                System.out.printf("%5d", e);
            }
            System.out.println();
        }
    }

    private static int knapSack(int weightBag, int[] weightItems,
                                int[] valueItems, int n, int[][] result) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= weightBag; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                } else if (weightItems[i - 1] <= j) {
                    result[i][j] = Math.max(valueItems[i - 1] + result[i - 1][j - weightItems[i - 1]],
                            result[i - 1][j]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[n][weightBag];
    }
}
