import java.util.*;
public class RemoveDuplicates{
    public static void main(String[] args) {
        int nums[] = {1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
    public static String removeDuplicates(int [] nums){
        // if(nums.length == 0 || nums == null){
        //     throw new IllegalArgumentException("error");
        // }
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        while(slow <= nums.length){
            nums[slow] = 0;
            slow++;
        }
        return Arrays.toString(nums);
        //return slow;
    }
}