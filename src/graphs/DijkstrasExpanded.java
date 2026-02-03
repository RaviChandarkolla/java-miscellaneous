package graphs;

import java.util.*;

/*
to → destination city
fuel → fuel required to travel this road
*/
class Edge {
    int to;
    int fuel;
    Edge(int to, int fuel) {
        this.to = to;
        this.fuel = fuel;
    }
}

/*

city → where you are
minFuelCost → cheapest fuel price seen so far
totalCost → money spent to reach here

 */
class State {
    int city;
    int minFuelCost;
    long totalCost;

    State(int city, int minFuelCost, long totalCost) {
        this.city = city;
        this.minFuelCost = minFuelCost;
        this.totalCost = totalCost;
    }
}

// Yes. This solution is a combination of Dijkstra’s algorithm + Dynamic Programming (DP).
public class DijkstrasExpanded {

    /*
    n → number of cities
    g_from, g_to, g_weight → edges
    cost → fuel price at each city
    A → start
    B → destination
     */
    static long minCostToTravel(
            int n,
            List<Integer> g_from,
            List<Integer> g_to,
            List<Integer> g_weight,
            List<Integer> cost,
            int A,
            int B) {

        // Build graph
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < g_from.size(); i++) {
            int u = g_from.get(i);
            int v = g_to.get(i);
            int w = g_weight.get(i);

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w)); // remove if directed
        }

        /*
        dist[city][fuelPrice] = minimum money to reach city
                        when cheapest fuel so far is fuelPrice
        */
        long[][] dist = new long[n][n];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>(
                Comparator.comparingLong(s -> s.totalCost)
        );

        pq.offer(new State(A, cost.get(A), 0));
        dist[A][cost.get(A)] = 0;

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            /*
            We are running Dijkstra on states: (city, minFuelCostSoFar)

            in PriorityQueue when a state is popped: This is the globally cheapest unprocessed state among ALL possible states.
             */
            if (cur.city == B) return cur.totalCost;

            if (cur.totalCost > dist[cur.city][cur.minFuelCost]) continue;

            for (Edge e : graph.get(cur.city)) {
                int nextCity = e.to;
                int fuelNeeded = e.fuel;

                long newCost = cur.totalCost + (long) fuelNeeded * cur.minFuelCost;
                int newMinFuel = Math.min(cur.minFuelCost, cost.get(nextCity));

                if (newCost < dist[nextCity][newMinFuel]) {
                    dist[nextCity][newMinFuel] = newCost;
                    pq.offer(new State(nextCity, newMinFuel, newCost));
                }
            }
        }

        return -1; // unreachable
    }
}


