import java.util.*;
public class PathWithMinEffort{
    public static int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, 0, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (currEffort > effort[r][c]) {
                continue;
            }

            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }
            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    continue;
                }

                int edgeEffort = Math.abs(heights[r][c] - heights[nr][nc]);

                int newEffort = Math.max(currEffort, edgeEffort);

                if (newEffort < effort[nr][nc]) {

                    effort[nr][nc] = newEffort;

                    pq.offer(new int[]{
                            newEffort,
                            nr,
                            nc
                    });
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println("Minimum Effort = " + minimumEffortPath(heights));
    }
}