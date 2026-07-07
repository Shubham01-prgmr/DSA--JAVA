import java.util.*;

public class ZeroOneMatrix {
    static class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static int[][] updateMatrix(int grid[][]){
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int dist[][] = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0;  j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                int row = curr.row;
                int col = curr.col;
                //up
                if(row - 1 >= 0 && !vis[row - 1][col]){
                    vis[row-1][col] = true;
                    dist[row-1][col] = dist[row][col] + 1;
                    q.offer(new Pair(row-1, col));
                }
                //down
                if(row + 1 < grid.length && !vis[row + 1][col]){
                    vis[row+1][col] = true;
                    dist[row+1][col] = dist[row][col] + 1;
                    q.offer(new Pair(row+1, col));
                }
                //left
                if(col - 1 >= 0 && !vis[row][col-1]){
                    vis[row][col-1] = true;
                    dist[row][col-1] = dist[row][col] + 1;
                    q.offer(new Pair(row, col-1));
                }
                //right
                if(col + 1 < grid[0].length && !vis[row][col+1]){
                    vis[row][col+1] = true;
                    dist[row][col+1] = dist[row][col] + 1;
                    q.offer(new Pair(row, col+1));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };

        int[][] ans = updateMatrix(grid);
j
        System.out.println("Distance Matrix:");

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}