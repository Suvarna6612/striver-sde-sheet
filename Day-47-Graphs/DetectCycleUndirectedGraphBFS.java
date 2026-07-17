import java.util.*;

class Solution {

    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkCycle(i, adj, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean checkCycle(int start, List<Integer>[] adj, boolean[] visited) {

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(start, -1));
        visited[start] = true;

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            int node = current.node;
            int parent = current.parent;

            for (int neighbour : adj[node]) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(new Pair(neighbour, node));
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }
}