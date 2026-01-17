import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;
        mergeSortedArray(nums1, m, nums2, n);
    }
    public static void mergeSortedArray(int[] nums1, int m, int nums2[], int n){
        int slow = m-1;
        int fast = n-1;
        int pos = m + n - 1;
        if(nums1.length == 0 || nums2.length == 0){
            return;
        }
        while(fast >= 0){
            if(nums1[slow] <= nums2[fast]){
                nums1[pos] = nums2[fast];
                pos--;
                fast--;
            }
            else{
                nums1[pos] = nums1[slow];
                slow--;
                pos--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
