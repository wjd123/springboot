public class CoinChangeDp {

    public static int change(int amount, int[] coins) {
        int len = coins.length;
            if (len == 0) {
                if (amount == 0) {
                    return 1;
                }
                return 0;
            }

        int[][] dp = new int[len][amount + 1];
        // 这个值语义不正确，但是是一个被其它状态参考的值，这样设置是正确的
        dp[0][0] = 1;

        // 填第 1 行
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; j - k * coins[i] >= 0; k++) {
                    dp[i][j] =dp[i][j] + dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(change(1,nums));
    }
}
