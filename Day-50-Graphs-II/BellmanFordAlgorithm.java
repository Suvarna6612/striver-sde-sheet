import java.util.*;

class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges,
                              int S) {

        int[] distance = new int[V];
        Arrays.fill(distance, (int)1e8);

        distance[S] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i <= V - 1; i++) {

            for (ArrayList<Integer> edge : edges) {

                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (distance[u] != (int)1e8 &&
                    distance[u] + weight < distance[v]) {

                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative weight cycle
        for (ArrayList<Integer> edge : edges) {

            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if (distance[u] != (int)1e8 &&
                distance[u] + weight < distance[v]) {

                return new int[] { -1 };
            }
        }

        return distance;
    }
}