import java.util.ArrayList;

public class CycleDetectUnDGraph {
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
    public static boolean cycleDetection(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(cycleDetectionUtil(graph, vis, i, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean cycleDetectionUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dest]){
                if(cycleDetectionUtil(graph, vis, e.dest, curr)){
                    return true;
                }
            }
            else if(vis[e.dest] && e.dest != par){
                    return true;
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

        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,1,1));
        
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,2,1));
        
        System.out.println(cycleDetection(graph));
    }
}
