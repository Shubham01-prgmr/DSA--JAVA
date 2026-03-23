import java.util.PriorityQueue;

public class PriorityQueuePQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(7);
        pq.add(3);
        pq.add(5);
        pq.add(20);

        while(!pq.isEmpty()){
            System.out.println(pq.peek() + " ");
            pq.remove();
        }
    }
}
