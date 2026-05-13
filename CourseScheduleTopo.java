import java.util.*;

class CourseScheduleTopo {

    public static void main(String[] args) {

        int numCourses = 4;
        int[][] prerequisites = {
            {1,0},{2,0},{3,1},{3,2}
        };

        int[] result = findOrder(numCourses, prerequisites); // ✅ direct call

        for(int x : result) {
            System.out.print(x + " ");
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph[prereq].add(course);
        }

        boolean[] vis = new boolean[numCourses];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                findOrderUtil(graph, i, vis, s);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        while(!s.isEmpty()){
            result[idx++] = s.pop();
        }

        return result;
    }

    public static void findOrderUtil(ArrayList<Integer>[] graph, int curr,
                                     boolean[] vis, Stack<Integer> s) {

        vis[curr] = true;

        for(int x : graph[curr]){
            if(!vis[x]){
                findOrderUtil(graph, x, vis, s);
            }
        }

        s.push(curr);
    }
}