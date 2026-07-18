import java.util.*;
public class CouseSchedule {
    public static void main(String[] args) {

        int numCourses = 4;

        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        // Create Graph
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build Graph
        for (int[] p : prerequisites) {

            int course = p[0];
            int prerequisite = p[1];

            graph[prerequisite].add(course);
        }

        // Calculate Indegree
        int[] indegree = new int[numCourses];

        for (int i = 0; i < graph.length; i++) {

            for (int neighbour : graph[i]) {
                indegree[neighbour]++;
            }
        }

        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {

            int curr = q.remove();
            System.out.println("Processing : " + curr);

            count++;

            for (int neighbour : graph[curr]) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        if (count == numCourses) {
            System.out.println("\nCan finish all courses : true");
        } else {
            System.out.println("\nCan finish all courses : false");
        }
    }
}

