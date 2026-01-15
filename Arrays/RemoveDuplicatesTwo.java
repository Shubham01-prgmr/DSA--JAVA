import java.util.*;
public class RemoveDuplicatesTwo {
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int arr[]){
        int slow = 2;
        for(int fast = 2; fast < arr.length; fast++){
            if(arr[fast] != arr[slow-2]){
                arr[slow] = arr[fast];
                slow++;
            }
        }
        while(slow <= arr.length){
            arr[slow] = 0;
            slow++;
        }
        System.out.println(Arrays.toString(Arrays.copyOf(arr, slow)));
        System.out.println(Arrays.toString(arr));
        return slow;
    }
}
