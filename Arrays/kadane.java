// public class kadane {
//     public static void main(String[] args) {
//         int nums[] = {-2,-3,4,-1,-2,1,5,-3};
//         System.out.println("Maximum subarray sum is: " + kadaneMaxSubarray(nums));
//     }
//     public static int kadaneMaxSubarray(int nums[]){
//         int max_sum = Integer.MIN_VALUE;
//         int curr_sum = 0;
//         for(int i = 0; i < nums.length; i++){
//             curr_sum += nums[i];
//             if(curr_sum < 0){
//                 curr_sum = 0;
//             }
//             max_sum = Math.max(max_sum, curr_sum);
//         }
//         return max_sum;
//     }
// }


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


    // public static void main(String args[]){
    //     int arr[] = {2, -3, 4, -2, 10, -1, -5};
    //     bestSubarraySumIndex(arr);
    // }
    // public static void bestSubarraySumIndex(int arr[]){
    //     int start = 0;
    //     int end = 0;
    //     int temp_start = 0;

    //     if(arr == null || arr.length <= 0){
    //         throw new IllegalArgumentException("Array cannot be empty");
    //     }

    //     int curr_sum = arr[0];
    //     int max_sum = arr[0];

    //     for (int i = 1; i < arr.length; i++) {
    //         if(arr[i] > curr_sum + arr[i]){
    //             temp_start = i;
    //             curr_sum = arr[i];
    //         }
    //         else{
    //             curr_sum = curr_sum + arr[i];
    //         }

    //         if(curr_sum > max_sum){
    //             max_sum = curr_sum;
    //             start = temp_start;
    //             end = i;
    //         }
    //     }
    //     System.out.println("max subarray sum is: " + max_sum);
    //     System.out.println("start index is: " + start);
    //     System.out.println("end index is: " + end);

    // }