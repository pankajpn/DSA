package dailypractice;

public class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int count1 = 0; // count of flips needed to make it start with '0'
        int count2 = 0; // count of flips needed to make it start with '1'

        for (int i = 0; i < n; i++) {
            char expectedChar1 = (i % 2 == 0) ? '0' : '1'; // expected char if we want to start with '0'
            char expectedChar2 = (i % 2 == 0) ? '1' : '0'; // expected char if we want to start with '1'

            if (s.charAt(i) != expectedChar1) {
                count1++;
            }
            if (s.charAt(i) != expectedChar2) {
                count2++;
            }
        }

        return Math.min(count1, count2);
    }
    
}
