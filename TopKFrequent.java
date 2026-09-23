import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    static class Pair implements Comparable<Pair>{
        int num;
        int freq;

        public Pair(int n, int f){
            this.num = n;
            this.freq = f;
        }

        @Override 
        public int compareTo(Pair p2){
            return this.freq - p2.freq;
        }
    }
    public static int[] topKFrequent(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[k];

        for(int val : map.keySet()){
            pq.offer(new Pair(val, map.get(val)));

            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = 0; i < ans.length; i++){
            Pair p = pq.poll();
            ans[i] = p.num;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,3};
        int ans[] = topKFrequent(arr, 2);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
