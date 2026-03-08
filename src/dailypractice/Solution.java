package dailypractice;

public class Solution {
    public int minFlips(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        String t = s + s;
        // We'll count mismatches for the two possible alternating patterns.
        int mismatchesA = 0; // expects '0' at even indices (pattern "0101...")
        int mismatchesB = 0; // expects '1' at even indices (pattern "1010...")
        int res = n; // worst-case flips is n

        for (int i = 0; i < 2 * n; i++) {
            char c = t.charAt(i);
            // expected chars at position i for the two patterns
            char expectedA = (i % 2 == 0) ? '0' : '1';
            char expectedB = (i % 2 == 0) ? '1' : '0';

            if (c != expectedA) mismatchesA++;
            if (c != expectedB) mismatchesB++;

            // Once we have a full window of size n, start sliding
            if (i >= n) {
                // remove the effect of the outgoing char
                char out = t.charAt(i - n);
                char outExpectedA = ((i - n) % 2 == 0) ? '0' : '1';
                char outExpectedB = ((i - n) % 2 == 0) ? '1' : '0';
                if (out != outExpectedA) mismatchesA--;
                if (out != outExpectedB) mismatchesB--;
            }

            // When the window size reaches n, consider updating result
            if (i >= n - 1) {
                res = Math.min(res, Math.min(mismatchesA, mismatchesB));
            }
        }

        return res;
    }
    
}
