package leetcode.src.MaximumNumberOfKDivisibleComponents;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public  int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // dfs
        // create adjacencyList for graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int[] ans = new int[]{0};
        dfs(0, visited, adjList, values, k, ans);
        return ans[0];
    }

    private int dfs(final int currentNode,
                    final boolean[] visited,
                    final List<List<Integer>> adjList,
                    final int[] values,
                    final int k,
                    int[] ans) {
        int sum = 0;
        visited[currentNode] = true;
        for(Integer neighborNode: adjList.get(currentNode)) {
            if(!visited[neighborNode]) {
                sum += dfs(neighborNode, visited, adjList, values, k, ans);
                sum %= k;
            }
        }

        sum += values[currentNode];
        sum %= k;

        if(sum == 0) {
            ans[0]++;
        }
        return sum;
    }
}
