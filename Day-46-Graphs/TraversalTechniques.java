import java.util.*;

class Solution {

    // DFS Traversal
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(0, graph, visited, dfs);

        return dfs;
    }

    private void dfs(int node, List<List<Integer>> graph,
                     boolean[] visited, List<Integer> dfs) {

        visited[node] = true;
        dfs.add(node);

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, graph, visited, dfs);
            }
        }
    }

    // BFS Traversal
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            bfs.add(node);

            for (int neighbour : graph.get(node)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return bfs;
    }
}