package graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

    // ---------- Edge ----------
    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // ---------- DSU (Union-Find) ----------
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            // initially, every node is its own parent
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            // already connected → cycle
            if (rootA == rootB) return false;

            // union by rank
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }

    // ---------- Kruskal MST ----------
    public static List<Edge> buildMST(int n, List<Edge> edges) {

        // 1. Sort edges by increasing weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        DSU dsu = new DSU(n);
        List<Edge> mst = new ArrayList<>();

        // 2. Try to add edges one by one
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                mst.add(e);

                // MST has exactly (n - 1) edges
                if (mst.size() == n - 1) break;
            }
        }

        return mst;
    }

    // ---------- Demo ----------
    public static void main(String[] args) {
        int n = 4;
        List<Edge> edges = List.of(
                new Edge(1, 2, 1),
                new Edge(2, 3, 2),
                new Edge(3, 4, 3),
                new Edge(1, 4, 4),
                new Edge(2, 4, 5)
        );

        List<Edge> mst = buildMST(n, new ArrayList<>(edges));

        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e.u + " - " + e.v + " : " + e.weight);
        }
    }
}
