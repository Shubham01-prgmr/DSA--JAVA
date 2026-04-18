
import java.util.HashSet;

public class LongestSequence {
    static int count;
    public static int longestConsecutiveSequence(int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(!set.contains(arr[i] - 1)){
                count = 1;
                int current = arr[i];
                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
            }
        }
        return Math.max(max, count);
    }
    public static void main(String[] args) {
        int arr[] = {100, 4, 200, 2, 3, 1};
        System.out.println(longestConsecutiveSequence(arr));
    }
}
