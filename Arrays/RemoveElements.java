import java.util.Arrays;

public class RemoveElements {
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeValue(nums, val));
    }
    //static int slow = 0;
    public static int removeValue(int nums[], int val){
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, slow)));
        return slow;
    }
}
