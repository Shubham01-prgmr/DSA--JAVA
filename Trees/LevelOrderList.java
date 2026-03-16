
public class LevelOrderList {
    static int minDistance(int dist[], boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String args[]) {

        char vertices[] = {'A','B','C','D'};

        int graph[][] = {
            {0,4,2,0},
            {4,0,5,10},
            {2,5,0,3},
            {0,10,3,0}
        };

        int V = 4;

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;

        dist[0] = 0;  
        for(int count=0; count<V-1; count++) {

            int u = minDistance(dist, visited);
            visited[u] = true;

            for(int v=0; v<V; v++) {

                if(!visited[v] && graph[u][v] != 0 &&
                   dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex  Distance from Source");

        for(int i=0;i<V;i++)
            System.out.println(vertices[i] + "      " + dist[i]);
    }

}