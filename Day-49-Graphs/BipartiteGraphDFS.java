import java.util.*;

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node,
                        int currentColor,
                        int[][] graph,
                        int[] color) {

        color[node] = currentColor;

        for (int neighbour : graph[node]) {

            if (color[neighbour] == -1) {

                if (!dfs(neighbour, 1 - currentColor, graph, color)) {
                    return false;
                }

            } else if (color[neighbour] == currentColor) {

                return false;
            }
        }

        return true;
    }
}