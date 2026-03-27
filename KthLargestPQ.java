import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestPQ {
    static int k;
    static PriorityQueue<Integer> pq;

    public static List<Integer> kthLargest(int stream[], int k){
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int val : stream){
            if(pq.size() < k){
                pq.add(val);
            }
            else{
                if(val > pq.peek()){
                    pq.poll();
                    pq.add(val);
                }
            }
            if(pq.size() == k){
                list.add(pq.peek());
            }
            else{
                list.add(-1);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int stream[] = {1,2,3,4,5,6,7};
        pq = new PriorityQueue<>();
        k = 3;
        List<Integer> result = kthLargest(stream,k);
        for(int ans : result){
            System.out.print(ans + " ");
        }
    }
}
