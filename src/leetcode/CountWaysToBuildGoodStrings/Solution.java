package leetcode.CountWaysToBuildGoodStrings;

import java.util.Arrays;

public class Solution {

    int mod = 1_000_000_007;
    int[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        // we have two choices
        // either we append 0s or 1s at each step
        int ans = 0;
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        for (int i = low; i <= high; ++i) {
            ans += solve(i, zero, one);
            ans %= mod;
        }
        return ans;
    }

    private int solve(int high, int zero, int one) {
        if (dp[high] != -1)
            return dp[high];

        int ans = 0;

        if (high >= zero)
            ans += solve(high - zero, zero, one);
        if (high >= one)
            ans += solve(high - one, zero, one);
        return dp[high] = ans % mod;
    }
}
