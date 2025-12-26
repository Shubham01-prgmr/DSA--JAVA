import java.util.*;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] nums) {
        if (nums.length == 0) return new int[0];

        int slow = 1;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return Arrays.copyOf(nums, slow);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3, 4, 5};

        int[] result = removeDuplicates(nums);
        System.out.println(Arrays.toString(result));
    }
}
