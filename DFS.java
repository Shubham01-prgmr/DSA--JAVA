import java.util.ArrayList;

public class DFS {
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
    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr){
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, vis, e.dest);
            }
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 4));

        graph[1].add(new Edge(1, 2, 4));
        graph[1].add(new Edge(1, 3, 5));

        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 6));

        graph[3].add(new Edge(3, 1, 4));
        graph[3].add(new Edge(3, 2, 4));

        // for(int i = 0 ; i < V; i++){
        //     System.out.print(i + "->" );

        //     for(Edge e : graph[i]){
        //         System.out.print(e.src + "," + e.dest + ",");
        //     }
        //     System.out.println();
        // }
        boolean vis[] = new boolean[V];
        dfs(graph, vis, 0);
    }
}
