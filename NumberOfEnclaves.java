public class NumberOfEnclaves {
    public static int numberOfEnclaves(int grid[][]){
        int count = 0;
        //up and down
        for(int col = 0; col < grid[0].length; col++){
            if(grid[0][col] == 1){
                dfsUtil(grid, 0, col);
            }
            if(grid[grid.length-1][col] == 1){
                dfsUtil(grid, grid.length-1, col);
            }
        }
        //left and right
        for(int row = 0; row < grid.length; row++){
            if(grid[row][0] == 1){
                dfsUtil(grid, row, 0);
            }
            if(grid[row][grid[0].length-1] == 1){
                dfsUtil(grid, row, grid[0].length-1);
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfsUtil(int grid[][], int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
            grid[row][col] != 1){
                return;
            }

        grid[row][col] = 0;

        dfsUtil(grid, row-1, col);
        dfsUtil(grid, row+1, col);
        dfsUtil(grid, row, col-1);
        dfsUtil(grid, row, col+1);
    }
    public static void main(String[] args){
        int grid[][] = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        System.out.println(numberOfEnclaves(grid));
    }
}
