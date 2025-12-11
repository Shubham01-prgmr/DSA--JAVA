public class slidingWindow {
    public static void main(String[] args) {
        int arr [] = {3,2,1,7,4,2,1,1,5};
        int k = 8;
        System.out.println(longestSubarraySum(arr, k));
    }
    public static int longestSubarraySum(int arr[], int k){
        int leftBound = 0;
        int sum = 0;
        int ans = 0;
        for(int rightBound = 0; rightBound < arr.length; rightBound++){
            sum += arr[rightBound];
            
            while(sum > k){
                sum -= arr[leftBound];
                leftBound++;
            }
            ans = Math.max(ans, rightBound - leftBound + 1);
        }
        return ans;
    }
}
