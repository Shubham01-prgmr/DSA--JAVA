public class MinSizeSubarray {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];

            while (currSum >= target) {
                int len = right - left + 1;
                currSum -= nums[left];
                left++;
                minLen = Math.min(minLen, len);
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinSizeSubarray solver = new MinSizeSubarray();

        // Test Case 1: Standard case
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("Output 1: " + solver.minSubArrayLen(target1, nums1));
    }
}