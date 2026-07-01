import java.util.*;
public class NumberOfIslandsBFS {
    public static int bfs(int[][] grid, int row, int col){
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1 && !vis[r][c]){
                    bfsUtil(grid, vis, r, c);
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfsUtil(int grid[][], boolean vis[][], int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        vis[r][c] = true;
        while(!q.isEmpty()){
            int curr[] = q.remove();
            int row = curr[0];
            int col = curr[1];

            if(row-1 >= 0 && grid[row-1][col] == 1 && !vis[row-1][col]){
                vis[row-1][col] = true;
                q.add(new int[]{row-1, col});
            }
            if(row+1 < grid.length && grid[row+1][col] == 1 && !vis[row+1][col]){
                vis[row+1][col] = true;
                q.add(new int[]{row+1, col});
            }
            if(col-1 >= 0 && grid[row][col-1] == 1 && !vis[row][col-1]){
                vis[row][col-1] = true;
                q.add(new int[]{row, col-1});
            }
            if(col+1 < grid[0].length && grid[row][col+1] == 1 && !vis[row][col+1]){
                vis[row][col+1] = true;
                q.add(new int[]{row, col+1});
            }
        }
    }
    public static void main(String[] args) {
         int[][] grid = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 1}
        };

        System.out.println(bfs(grid, 0, 0));
    }
}
