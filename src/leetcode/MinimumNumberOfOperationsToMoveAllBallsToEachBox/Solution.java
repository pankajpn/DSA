package leetcode.MinimumNumberOfOperationsToMoveAllBallsToEachBox;

import java.util.Arrays;

public class Solution {
    public int[] minOperations(String boxes) {
        // sum(abs(i-j))
        int[] ans = new int[boxes.length()];
        Arrays.fill(ans, 0);

        //brute force
        // for(int i = 0; i<boxes.length(); ++i) {
        //     for(int j = 0; j<boxes.length(); ++j) {
        //         if(boxes.charAt(j) == '1'){
        //             ans[i] += Math.abs(i-j);
        //         }
        //     }
        // }

        // we need to keep track of the ball to left and moves from the left
        // similary from the right side
        int left = 0, leftmoves = 0;
        int right = 0, rightmoves = 0;
        int n = boxes.length();
        for (int i = 0; i < n; ++i) {
            ans[i] += leftmoves;

            left += boxes.charAt(i) == '1' ? 1 : 0;
            leftmoves += left;

            ans[n - 1 - i] += rightmoves;
            right += boxes.charAt(n - 1 - i) == '1' ? 1 : 0;
            rightmoves += right;

        }
        return ans;
    }
}
