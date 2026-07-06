import java.util.*;

public class ZeroOneMatrix {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] updateMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        boolean[][] vis = new boolean[rows][cols];
        int[][] dist = new int[rows][cols];

        // Add all 0's into queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            int row = curr.row;
            int col = curr.col;

            // UP
            if (row - 1 >= 0 && !vis[row - 1][col]) {

                vis[row - 1][col] = true;
                dist[row - 1][col] = dist[row][col] + 1;
                q.offer(new Pair(row - 1, col));
            }

            // DOWN
            if (row + 1 < rows && !vis[row + 1][col]) {

                vis[row + 1][col] = true;
                dist[row + 1][col] = dist[row][col] + 1;
                q.offer(new Pair(row + 1, col));
            }

            // LEFT
            if (col - 1 >= 0 && !vis[row][col - 1]) {

                vis[row][col - 1] = true;
                dist[row][col - 1] = dist[row][col] + 1;
                q.offer(new Pair(row, col - 1));
            }

            // RIGHT
            if (col + 1 < cols && !vis[row][col + 1]) {

                vis[row][col + 1] = true;
                dist[row][col + 1] = dist[row][col] + 1;
                q.offer(new Pair(row, col + 1));
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] ans = updateMatrix(grid);

        System.out.println("Distance Matrix:");

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}