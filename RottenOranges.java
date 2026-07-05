import java.util.*;

public class RottenOranges{
    static class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static int rottingOranges(int grid[][]){
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i  = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i, j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return -1;
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                int row = curr.row;
                int col = curr.col;
                //up
                if(row-1 >= 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    fresh--;
                    q.offer(new Pair(row-1, col));
                }
                //down
                if(row+1 < grid.length && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    fresh--;
                    q.offer(new Pair(row+1, col));
                }
                //left
                if(col-1 >= 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    fresh--;
                    q.offer(new Pair(row, col-1));
                }
                //right
                if(col+1 < grid[0].length && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    fresh--;
                    q.offer(new Pair(row, col+1));
                }
            }
            if(!q.isEmpty()){
                time++;
            }
        }
        return time;
    }
    public static void main(String[] args) {
        int grid[][] = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(rottingOranges(grid));
    }
}