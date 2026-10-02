public class TargetSumSubset {
    public static boolean subsetSum(int arr[], int T){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][T+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = false;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < T+1; j++){
                int v = arr[i - 1];
                if(v <= j && dp[i - 1][j - v] == true){
                    dp[i][j] = true;
                }
                else if(dp[i - 1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][T];
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int target = 20;
        System.out.println(subsetSum(arr, target));
    }
}
