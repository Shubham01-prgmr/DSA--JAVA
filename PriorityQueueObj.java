import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueObj {
    static class PQueue implements Comparable<PQueue>{
        int rank;
        String name;
        
        public PQueue(int rank, String name){
            this.rank = rank;
            this.name = name;
        }
        @Override
        public int compareTo(PQueue p2){
            return this.rank - p2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<PQueue> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new PQueue(23, "sbc"));
        pq.add(new PQueue(2, "abc"));
        pq.add(new PQueue(13, "xcv"));
        pq.add(new PQueue(1, "ghj"));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }
    }
}
