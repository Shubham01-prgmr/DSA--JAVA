public class coinChange {

    public static int coinChange(int[] coins, int W) {
        int n = coins.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= W; j++) {
            dp[0][j] = W + 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = coins[i - 1];

                if (v <= j) {
                    dp[i][j] = Math.min(
                        dp[i][j - v] + 1,
                        dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W] > W ? -1 : dp[n][W];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int W = 11;

        System.out.println(coinChange(coins, W));
    }
}