public class KadaneIndex {
    public static void main(String args[]){
        int arr[] = {2, -3, 4, -2, 10, -1, -5};
        bestSubarraySumIndex(arr);
    }
    public static void bestSubarraySumIndex(int arr[]){
        int start = 0;
        int end = 0;
        int temp_start = 0;

        if(arr == null || arr.length <= 0){
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int curr_sum = arr[0];
        int max_sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > curr_sum + arr[i]){
                temp_start = i;
                curr_sum = arr[i];
            }
            else{
                curr_sum = curr_sum + arr[i];
            }

            if(curr_sum > max_sum){
                max_sum = curr_sum;
                start = temp_start;
                end = i;
            }
        }
        System.out.println("max subarray sum is: " + max_sum);
        System.out.println("start index is: " + start);
        System.out.println("end index is: " + end);

    }
}
