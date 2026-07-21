import java.util.*;

class Solution {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0}); // {weight, node}

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int weight = current[0];
            int node = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            mstWeight += weight;

            for (List<Integer> neighbour : adj.get(node)) {

                int nextNode = neighbour.get(0);
                int edgeWeight = neighbour.get(1);

                if (!visited[nextNode]) {
                    pq.offer(new int[]{edgeWeight, nextNode});
                }
            }
        }

        return mstWeight;
    }
}