package org.nm.lc.medium;

public class IntegerBreak343
{

    public int integerBreak (int n)
    {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if (n == 2) {
            return 1;
        }
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= (i / 2); j++) {

                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
            }
        }
        return dp[n];
    }
}
