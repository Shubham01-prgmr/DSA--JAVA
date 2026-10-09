public class NumberOfIslandsDFS {
    public static int numIslands(char[][] grid) {

        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '1' && !vis[row][col]) {
                    dfsUtil(grid, vis, row, col, dr, dc);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfsUtil(char[][] grid,
                               boolean[][] vis,
                               int row,
                               int col, int dr[], int dc[]) {

        // Base Conditions
        if(row < 0 ||
           col < 0 ||
           row >= grid.length ||
           col >= grid[0].length ||
           vis[row][col] ||
           grid[row][col] == '0') {

            return;
        }

        vis[row][col] = true;

        for(int i =0; i < 4; i++){
            int nr = row + dr[i];
            int nc = col + dc[i];

            if(nr >= 0 && nr < grid.length && nc >= 0 && 
                nc < grid[0].length && grid[nr][nc] == '1'){
                    if(!vis[nr][nc]){
                        dfsUtil(grid, vis, nr, nc, dr, dc);
                }
            }
        }
        // // Up
        // dfsUtil(grid, vis, row - 1, col);

        // // Down
        // dfsUtil(grid, vis, row + 1, col);

        // // Left
        // dfsUtil(grid, vis, row, col - 1);

        // // Right
        // dfsUtil(grid, vis, row, col + 1);
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("Number of Islands = " + numIslands(grid));
    }
}
