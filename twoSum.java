
import java.util.HashMap;

public class twoSum {
    // public int[] twoSum(int[] nums, int target) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         int comp = target - nums[i];
    //         if (map.containsKey(comp)) {
    //             return new int[]{map.get(comp), i};
    //         }
    //         map.put(nums[i], i);
    //     }
    //     return new int[]{};
    // }
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 14};
        int target = 9;

        int result[] = twoSum2(arr, target);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
    public static int[] twoSum2(int arr[], int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(target - arr[i])){
                return new int[] {map.get(target - arr[i]), i};
            }
            else{
                map.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
