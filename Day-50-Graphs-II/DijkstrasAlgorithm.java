import java.util.*;

class Solution {

    public int[] dijkstra(int V,
                          ArrayList<ArrayList<Integer>> edges,
                          int S) {

        // Build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e9);

        distance[S] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{S, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int dist = current[1];

            if (dist > distance[node]) {
                continue;
            }

            for (int[] neighbour : adj.get(node)) {

                int nextNode = neighbour[0];
                int weight = neighbour[1];

                if (dist + weight < distance[nextNode]) {

                    distance[nextNode] = dist + weight;
                    pq.offer(new int[]{nextNode, distance[nextNode]});
                }
            }
        }

        return distance;
    }
}