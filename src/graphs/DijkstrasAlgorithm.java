package graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;
    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstrasAlgorithm {
    public static int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int distance = curr.distance;

            for (Pair p: adj.get(node)) {
                int adjNode = p.node;
                int wt = p.distance;

                if (distance+wt < dist[adjNode]) {
                    dist[adjNode] = distance+wt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 3;
        int E = 3;
        int src = 2;
        int[][] edges = {{0,1,1}, {1,2,3},{0,2,6}};

        int[] ans = dijkstra(V, edges, src);
        for (int i: ans) {
            System.out.print(i+"||");
        }
        System.out.println();
    }
}
