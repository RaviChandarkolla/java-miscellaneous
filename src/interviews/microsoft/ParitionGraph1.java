package interviews.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ParitionGraph1 {

    static class Edge {
        int u, v;
        long w;
        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            if (rank[a] < rank[b]) parent[a] = b;
            else if (rank[a] > rank[b]) parent[b] = a;
            else {
                parent[b] = a;
                rank[a]++;
            }
            return true;
        }
    }

    public static int getMinMaxLatency(
            int g_nodes,
            List<Integer> g_from,
            List<Integer> g_to,
            List<Integer> g_weight,
            int k
    ) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < g_from.size(); i++) {
            edges.add(new Edge(
                    g_from.get(i),
                    g_to.get(i),
                    g_weight.get(i)
            ));
        }

        // Sort edges by weight
        edges.sort(Comparator.comparingLong(e -> e.w));

        DSU dsu = new DSU(g_nodes);
        List<Long> mstEdges = new ArrayList<>();

        // Kruskal
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                mstEdges.add(e.w);
            }
        }

        // Already minimal regions
        if (k >= g_nodes) return 0;

        // Remove k-1 largest edges
        mstEdges.sort(Collections.reverseOrder());

        return mstEdges.get(k - 1).intValue();
    }
}
