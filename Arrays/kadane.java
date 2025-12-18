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
