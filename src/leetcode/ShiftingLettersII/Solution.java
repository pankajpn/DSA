package leetcode.ShiftingLettersII;

import java.util.Arrays;

public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        // idea is to calculate the number of shifts each character will have with respect to the previous character
        // start, end -> we shift start by 1 and then we make end+1 shift by 1 in opposite which helps to make sure the shift happens from start to end, with cumulative number of shift and for end+1 it will be 0(no shift).
        int n = s.length();
        int[] diff = new int[n];
        Arrays.fill(diff, 0);
        for (int i = 0; i < shifts.length; ++i) {
            if (shifts[i][2] == 1) {
                diff[shifts[i][0]]++;
                if (shifts[i][1] + 1 < n) {
                    diff[shifts[i][1] + 1]--;
                }
            } else {
                diff[shifts[i][0]]--;
                if (shifts[i][1] + 1 < n) {
                    diff[shifts[i][1] + 1]++;
                }
            }
        }
        StringBuilder res = new StringBuilder(s);
        int noOfShifts = 0;
        for (int i = 0; i < n; ++i) {
            noOfShifts = (noOfShifts + diff[i]) % 26;

            if (noOfShifts < 0) noOfShifts += 26;

            char nextChar = (char) ('a' + ((s.charAt(i) - 'a' + noOfShifts) % 26));
            res.setCharAt(i, nextChar);
        }
        return res.toString();
    }
}
