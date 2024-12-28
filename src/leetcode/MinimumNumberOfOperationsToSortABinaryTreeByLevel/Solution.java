package leetcode.MinimumNumberOfOperationsToSortABinaryTreeByLevel;

import java.util.*;

class Solution {

    /*
    * Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
Output: 3
Explanation:
- Swap 4 and 3. The 2nd level becomes [3,4].
- Swap 7 and 5. The 3rd level becomes [5,6,8,7].
- Swap 8 and 7. The 3rd level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
*/
    public int minimumOperations(TreeNode root) {
        // we are doing level order traversal and for each level we find the swaps required
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level[i] = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans += countSwaps(level);
        }
        return ans;
    }

    private int countSwaps(int[] level) {
        int[] sortedLevel = level.clone();
        Arrays.sort(sortedLevel);
        int swaps = 0;
        Map<Integer, Integer> levelPosition = new HashMap<>();
        for (int i = 0; i < level.length; i++) {
            levelPosition.put(level[i], i);
        }

        for (int i = 0; i < level.length; i++) {
            if (level[i] != sortedLevel[i]) {
                swaps++;
                //we get new position
                int newPos = levelPosition.get(sortedLevel[i]);
                // first we update the new position in map
                levelPosition.put(level[i], newPos);
                // update the level value at newPos
                level[newPos] = level[i];
            }
        }
        return swaps;
    }
}
