package leetcode.NoOfWaysToFormATargetStringGivenADictionary;

import java.util.Arrays;

public class Solution {
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int[][] frequency = new int[wordLength][26];
        for (String word : words) {
            for (int j = 0; j < wordLength; j++) {
                frequency[j][word.charAt(j) - 'a']++;
            }
        }

        int[][] dp = new int[words[0].length()][target.length()];
        for (int i = 0; i < words[0].length(); i++) {
            Arrays.fill(dp[i], -1);
        }


        return (int) solve(words, target, 0, 0, dp, frequency);
    }

    private long solve(String[] words, String target, int wordsIndex, int targetIndex, int[][] dp, int[][] frequency) {
        if (targetIndex == target.length()) {
            return 1;
        }

        if (wordsIndex == words[0].length() || words[0].length() - wordsIndex < target.length() - targetIndex) {
            return 0;
        }

        if (dp[wordsIndex][targetIndex] != -1) {
            return dp[wordsIndex][targetIndex];
        }

        long ans = 0;

        // don't match character at wordIndex with target character at targetIndex
        ans += solve(words, target, wordsIndex + 1, targetIndex, dp, frequency);

        // match character at wordIndex with target character at targetIndex
        ans += frequency[wordsIndex][target.charAt(targetIndex) - 'a'] * solve(words, target, wordsIndex + 1, targetIndex + 1, dp, frequency);

        dp[wordsIndex][targetIndex] = (int) (ans % 1000000007);

        return dp[wordsIndex][targetIndex];

    }
}
