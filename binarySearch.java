public class binarySearch {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12 };
        int target = 8;

        System.out.println(search(arr, target)); 
    }
}
