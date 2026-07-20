public class FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {

        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int[] edge : trust) {
            int u = edge[0];
            int v = edge[1];

            outdegree[u]++;
            indegree[v]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 3;

        int[][] trust = {
                {1, 3},
                {2, 3}
        };

        int judge = findJudge(n, trust);

        if (judge == -1) {
            System.out.println("No Town Judge Found");
        } else {
            System.out.println("Town Judge: " + judge);
        }
    }
}