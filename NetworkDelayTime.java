import java.util.*;

public class NetworkDelayTime {

    static class Edge {
        int dest, wt;

        Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            graph[time[0]].add(new Edge(time[1], time[2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] vis = new boolean[n + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if (vis[curr.node]) continue;
            vis[curr.node] = true;

            for (Edge e : graph[curr.node]) {

                if (dist[curr.node] != Integer.MAX_VALUE &&
                    dist[curr.node] + e.wt < dist[e.dest]) {

                    dist[e.dest] = dist[curr.node] + e.wt;
                    pq.offer(new Pair(e.dest, dist[e.dest]));
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n , k));

    }
}