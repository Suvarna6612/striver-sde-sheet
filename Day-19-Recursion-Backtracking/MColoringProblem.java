import java.util.*;

class Solution {

    boolean graphColoring(int[][] edges, int m, int n) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] color = new int[n];

        return solve(0, graph, color, m, n);
    }

    private boolean solve(int node, List<List<Integer>> graph,
                          int[] color, int m, int n) {

        if (node == n) {
            return true;
        }

        for (int c = 1; c <= m; c++) {

            if (isSafe(node, graph, color, c)) {

                color[node] = c;

                if (solve(node + 1, graph, color, m, n)) {
                    return true;
                }

                color[node] = 0; // Backtrack
            }
        }

        return false;
    }

    private boolean isSafe(int node, List<List<Integer>> graph,
                           int[] color, int currColor) {

        for (int neighbor : graph.get(node)) {

            if (color[neighbor] == currColor) {
                return false;
            }
        }

        return true;
    }
}