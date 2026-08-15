import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Edge{
        int src;
        int dest;
        int wt;
        
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
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
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    public static void prims (ArrayList<Edge> graph[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[graph.length];
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
        System.out.println("final cost is: " + finalCost);
    }
    public static void main(String[] args){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 2));
        graph[0].add(new Edge(0, 3, 3));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 4));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 4));
        graph[2].add(new Edge(2, 3, 5));

        graph[3].add(new Edge(3, 0, 3));
        graph[3].add(new Edge(3, 2, 5));
        prims(graph);
    }
}
