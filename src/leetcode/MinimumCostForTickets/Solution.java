package leetcode.MinimumCostForTickets;

import java.util.Arrays;

public class Solution {

    int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        // we can check all possibilities
        // currDay -> starting from day 0 we can increase currDay with 1, 7 or 30 days
        // and add the cost accordingly
        // check for all possible combinations

        dp = new int[373];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0);
    }

    private int solve(int[] days, int[] costs, int currDay) {
        // if we go beyond the travelling days
        if (currDay >= days.length) {
            return 0;
        }

        if (dp[currDay] != -1) {
            return dp[currDay];
        }

        // we choose 1d, 7d or 30d pass
        int ans1 = costs[0] + solve(days, costs, currDay + 1);
        // update new day to the day present in days
        int newDay = days.length;
        for (int i = currDay; i < days.length; ++i) {
            if (days[currDay] + 7 <= days[i]) {
                newDay = i;
                break;
            }
        }
        int ans2 = costs[1] + solve(days, costs, newDay);
        newDay = days.length;
        for (int i = currDay; i < days.length; ++i) {
            if (days[currDay] + 30 <= days[i]) {
                newDay = i;
                break;
            }
        }
        int ans3 = costs[2] + solve(days, costs, newDay);

        return dp[currDay] = Math.min(ans1, Math.min(ans2, ans3));
    }

}
