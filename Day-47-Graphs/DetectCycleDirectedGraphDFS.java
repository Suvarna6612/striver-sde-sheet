import java.util.*;

class Solution {

    public boolean isCyclic(int V, List<Integer>[] adj) {

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, adj, visited, pathVisited))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(int node,
                        List<Integer>[] adj,
                        boolean[] visited,
                        boolean[] pathVisited) {

        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbour : adj[node]) {

            if (!visited[neighbour]) {

                if (dfs(neighbour, adj, visited, pathVisited))
                    return true;

            } else if (pathVisited[neighbour]) {

                return true;
            }
        }

        pathVisited[node] = false;

        return false;
    }
}