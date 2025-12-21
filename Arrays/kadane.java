public class kadane {
    public static void main(String[] args) {
        int nums[] = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println("Maximum subarray sum is: " + kadaneMaxSubarray(nums));
    }
    public static int kadaneMaxSubarray(int nums[]){
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        for(int i = 0; i < nums.length; i++){
            curr_sum += nums[i];
            if(curr_sum < 0){
                curr_sum = 0;
            }
            max_sum = Math.max(max_sum, curr_sum);
        }
        return max_sum;
    }
}
// public class KadaneOptimised {
    // public static void main(String[] args) {
    //     int nums[] = {-4, 3, -1, 5};
    //     System.out.println("Maximum subarray sum is: " + maxSubarray(nums));
    // }
    // public static int maxSubarray(int nums[]){
    //     if (nums == null || nums.length == 0) {
    //         throw new IllegalArgumentException("Array must not be empty");
    //     }

    //     int currSum = nums[0];
    //     int maxSum = nums[0];

    //     for (int i = 1; i < nums.length; i++) {
    //         currSum = Math.max(nums[i], currSum + nums[i]);
    //         maxSum = Math.max(maxSum, currSum);
    //     }

    //     return maxSum;
    // }
