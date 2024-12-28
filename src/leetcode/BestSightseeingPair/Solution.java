package leetcode.BestSightseeingPair;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        // (values[i] + i) + (values[j]-j) --> we need to maximise this for i < j
        // for each j we keep the max of values[i]+1

        int maxLeft = values[0];

        int ans = 0;

        for (int j = 1; j < values.length; j++) {
            int current = values[j] - j;
            ans = Math.max(ans, maxLeft + current);
            maxLeft = Math.max(maxLeft, values[j] + j);
        }
        return ans;
    }
}