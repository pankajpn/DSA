package leetcode.UniqueLength3PalindromicSubsequences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int countPalindromicSubsequence(String s) {
        // calculating the first and the last index of a character and finding the unique characters in between them
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < s.length(); ++i) {
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            // unique characters can be found by iterating on string s and putting the characters into a set
            Set<Character> uniqueChars = new HashSet<>();
            for (int k = first[i] + 1; k < last[i]; ++k) {
                uniqueChars.add(s.charAt(k));
            }

            ans += uniqueChars.size();
        }
        return ans;
    }

}
