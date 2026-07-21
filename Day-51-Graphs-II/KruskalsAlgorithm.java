import java.util.*;

class Solution {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        List<int[]> edges = new ArrayList<>();

        for (int u = 0; u < V; u++) {

            for (List<Integer> neighbour : adj.get(u)) {

                int v = neighbour.get(0);
                int weight = neighbour.get(1);

                if (u < v) {
                    edges.add(new int[]{weight, u, v});
                }
            }
        }

        edges.sort((a, b) -> a[0] - b[0]);

        DisjointSet ds = new DisjointSet(V);

        int mstWeight = 0;

        for (int[] edge : edges) {

            int weight = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (ds.findParent(u) != ds.findParent(v)) {

                mstWeight += weight;
                ds.unionByRank(u, v);
            }
        }

        return mstWeight;
    }
}

class DisjointSet {

    int[] parent;
    int[] rank;

    DisjointSet(int n) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int findParent(int node) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent[node]);
    }

    void unionByRank(int u, int v) {

        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) {
            return;
        }

        if (rank[parentU] < rank[parentV]) {

            parent[parentU] = parentV;

        } else if (rank[parentV] < rank[parentU]) {

            parent[parentV] = parentU;

        } else {

            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }
}