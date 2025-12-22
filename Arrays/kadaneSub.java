public class kadaneSub {
    public static void main(String[] args) {
        int [] arr = {2, -3, 4, -2, 10, -1};
        kadaneSubarrayPrint(arr);
    }
    static void kadaneSubarrayPrint(int[] arr){
        int start = 0;
        int end = 0;
        int temp_start = 0;

        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("array can't be empty");
        }
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length ; i++){
            if(arr[i] > arr[i]  +curr_sum){
                curr_sum = arr[i];
                temp_start = i;
            }
            else{
                curr_sum = curr_sum  +arr[i];
            }

            if(max_sum < curr_sum){
                max_sum = curr_sum;
                start = temp_start;
                end = i;
            }
        }
        for(int x = start; x <= end; x++){
                System.out.print(arr[x] + " ");
            }
        System.out.println();
        
        System.out.println("max sum is : " + max_sum);
    }
}
