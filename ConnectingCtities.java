import java.util.*;
public class ConnectingCtities {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int cost;

        public Pair(int n, int cost){
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public static int connectingCities(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                finalCost += curr.cost;

                for(int i = 0; i < graph[curr.n].size(); i++){
                    Edge e = graph[curr.n].get(i);
                    pq.offer(new Pair(e.dest, e.wt));
                }
            }
        }
        return finalCost;
    }
    public static void main(String[] args) {
        int[][] cities = {
        {0, 1, 2, 3},
        {1, 0, 4, 0},
        {2, 4, 0, 5},
        {3, 0, 5, 0}
    };

        int n = cities.length;
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cities[i][j] != 0){
                    graph[i].add(new Edge(i, j, cities[i][j]));
                }
            }
        }
        int result = connectingCities(graph);
        System.out.println(result);
    }
}
