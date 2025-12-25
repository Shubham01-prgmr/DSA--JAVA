import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 12};
        arrangeZeroes(arr);
    }
    public static void arrangeZeroes(int arr[]){
        int end = arr.length-1;
        int slow = 0;
        for(int fast = 0; fast <= end; fast++){
            if(arr[fast] != 0){
                arr[slow] = arr[fast];
                slow++;
            }
        }

        while(slow <= end){
            arr[slow] = 0;
            slow++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
