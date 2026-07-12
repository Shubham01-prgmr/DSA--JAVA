import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = w;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                topSortUtil(graph, vis, s, i);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }
    public static void topSortUtil(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> s, int curr){
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        } 
        graph[2].add(new Edge(2, 3, 4));

        graph[3].add(new Edge(3, 1, 5));

        graph[4].add(new Edge(4, 0, 2));
        graph[4].add(new Edge(4, 1, 2));

        graph[5].add(new Edge(5, 0, 2));
        graph[5].add(new Edge(5, 2, 1));

        topSort(graph);
    }
}
