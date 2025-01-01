package leetcode.MaximumScoreAfterSplitingAString;

public class Solution {
    public int maxScore(String s) {
        // int score = 0;
        // int zeroes = 0;

        // int[] preSum = new int[s.length()];
        // preSum[0] = s.charAt(0) == '1'?1:0;

        // for(int i = 1; i<s.length();i++) {
        //     if(s.charAt(i) == '1') {
        //         preSum[i] += 1;
        //     }
        //     preSum[i] += preSum[i-1];
        // }

        // for(int i = 0; i<s.length()-1; ++i) {
        //     if(s.charAt(i) == '0') {
        //         zeroes++;
        //     }

        //     score = Math.max(score, zeroes + preSum[s.length()-1] - preSum[i]);
        // }

        // one pass solution
        int ones = 0;
        int zeroes = s.charAt(0) == '0' ? 1 : 0;
        int score = zeroes;

        for (int i = 1; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '0') {
                zeroes++;
            } else {
                ones++;
                zeroes--;
            }
            score = Math.max(score, zeroes);
        }

        if (s.charAt(s.length() - 1) == '1') {
            ones++;
        }

        return ones + score;
    }
}
