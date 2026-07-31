import java.util.*;

public class CheapestFlights {

    static class Edge {
        int src;
        int dest;
        int cost;

        Edge(int s, int d, int c) {
            src = s;
            dest = d;
            cost = c;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(ArrayList<Edge>[] graph, int src, int dst, int k) {

        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(src, 0, 0));

        while (!q.isEmpty()) {

            Info curr = q.poll();

            if (curr.stops > k)
                continue;

            for (Edge e : graph[curr.v]) {

                int u = e.src;
                int v = e.dest;
                int wt = e.cost;

                if (curr.cost + wt < dist[v]) {

                    dist[v] = curr.cost + wt;

                    q.offer(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {

        int n = 4;

        ArrayList<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 100));
        graph[1].add(new Edge(1, 2, 100));
        graph[2].add(new Edge(2, 0, 100));
        graph[1].add(new Edge(1, 3, 600));
        graph[2].add(new Edge(2, 3, 200));

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(cheapestFlight(graph, src, dst, k));
    }
}