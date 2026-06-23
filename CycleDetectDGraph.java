import java.util.ArrayList;

public class CycleDetectDGraph {
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
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i  = 0; i < graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, stack, i)){
                    return true;
                }
            }
        }
        return false;
    } 
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], boolean stack[], int curr){
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            
            if(stack[e.dest]){
                return true; 
            }
            else if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, stack, e.dest)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        } 
        graph[0].add(new Edge(0, 1, 4));

        graph[1].add(new Edge(1, 2, 5));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 1));
        

        System.out.println(detectCycle(graph));
    }
}
