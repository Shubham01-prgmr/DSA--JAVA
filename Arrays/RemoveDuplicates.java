import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args) {
        int nums[] = {1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int [] nums){
        if(nums.length == 0 || nums == null){
            throw new IllegalArgumentException("error");
        }
        int slow = 1;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow-1]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, slow)));
        return slow;
    }
}