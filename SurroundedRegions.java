public class SurroundedRegions {
    public static void surroundedRegions(char grid[][]){
        //up and down
        for(int col = 0; col < grid[0].length; col++){
            if(grid[0][col] == 'O'){
                dfsUtil(grid, 0, col);
            }
            if(grid[grid.length-1][col] == 'O'){
                dfsUtil(grid, grid.length-1, col);
            }
        }
        //left and right
        for(int row = 0; row < grid.length; row++){
            if(grid[row][0] == 'O'){
                dfsUtil(grid, row, 0);
            }
            if(grid[row][grid[0].length-1] == 'O'){
                dfsUtil(grid, row, grid[0].length-1);
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
                else if(grid[i][j] == 'S'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
    public static void dfsUtil(char grid[][], int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
            grid[row][col] != 'O'){
                return;
            }
        grid[row][col] = 'S';

        dfsUtil(grid, row+1, col);
        dfsUtil(grid, row-1, col);
        dfsUtil(grid, row, col+1);
        dfsUtil(grid, row, col-1);
    }
    public static void main(String[] args) {
        char grid[][] = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        surroundedRegions(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
