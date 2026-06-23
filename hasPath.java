import java.util.ArrayList;

public class hasPath {
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
    public static boolean dfsUtil(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i  = 0; i < graph.length; i++){
            if(!vis[i]){
                if(hasPath(graph, vis, 0, 2)){
                    return true;
                }
            }
        }
        return false;
    } 
    public static boolean hasPath(ArrayList<Edge> graph[], boolean vis[], int src, int dest){
        if(src == dest){
            return true;
        }
        vis[src] = true;

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest]){
                if(hasPath(graph, vis, e.dest, dest)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        } 
        graph[0].add(new Edge(0,1,1));
        graph[1].add(new Edge(1,0,1));

        // graph[1].add(new Edge(1,2,1));
        // graph[2].add(new Edge(2,1,1));
        
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,2,1));

        System.out.println(dfsUtil(graph));
    }
}
