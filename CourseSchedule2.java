import java.util.*;

public class CourseSchedule2{
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int p[] : prerequisites){
            int course = p[0];
            int prereq = p[1];
            graph[prereq].add(course);
        }
        int ans[] = courseScheduleII(graph, prerequisites, numCourses); 
        System.out.print(Arrays.toString(ans));
    }
    public static int[] courseScheduleII(ArrayList<Integer> graph[], int prerequisites[][],
        int numCourses){
        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[numCourses];
        int count = 0;

        findIndegree(indegree, graph);

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            order.add(curr);
            for(int neighbor : graph[curr]){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        if (count != numCourses) {
            return new int[0];
        }

        int[] ans = new int[order.size()];

        for (int i = 0; i < order.size(); i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }
    public static void findIndegree(int indegree[], ArrayList<Integer> graph[]){
        for(int i = 0; i < graph.length; i++){
            for(int neighbour : graph[i]){
                indegree[neighbour]++;
            }
        }
    }
}