import java.util.PriorityQueue;

public class KthLargestPQ {
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : arr) {
            pq.add(val);          

            if (pq.size() > k) {  
                pq.poll();        
            }
        }

        return pq.peek();         
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int ans = findKthLargest(arr, k);
        System.out.println(ans);
    }
}
