import java.util.*;

public class IsBipartite {
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
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];
        for(int i = 0; i < color.length; i++){
            color[i] = -1; //-1 => no color
        }
        for(int i = 0; i < graph.length; i++){
            if(color[i] == -1){
                if(!bfsUtil(graph, color, i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean bfsUtil(ArrayList<Edge> graph[], int color[], int i){
        Queue<Integer> q = new LinkedList<>();
            if(color[i] == -1){
                q.offer(i);
                color[i] = 0; // 0=>red & 1=> blue
            }
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int j = 0; j < graph[curr].size(); j++){
                    Edge e = graph[curr].get(j);
                    if(color[e.dest] == -1){
                        int newColor;
                        if(color[curr] == 0){
                            newColor = 1;
                        }
                        else{
                            newColor = 0;
                        }
                        color[e.dest] = newColor;
                        q.offer(e.dest);
                    }
                    else if(color[e.dest] == color[curr]){
                        return false;
                    }
                }
            }
        return true;
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

        graph[3].add(new Edge(3,0,1));
        graph[0].add(new Edge(0,3,1));

        System.out.println(isBipartite(graph));
    }
}
