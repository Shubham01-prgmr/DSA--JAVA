import java.util.*;
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();  
        int curr[] = intervals[0];
        ans.add(curr); 

        for(int i = 1; i < intervals.length; i++){
            int prevEnd = curr[1];
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(prevEnd >= currStart){
                curr[1] = Math.max(currEnd, prevEnd);
            }
            else{
                curr = intervals[i];
                ans.add(curr);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args){
        int intervals[][] = {{1,3},
                            {2,6},
                            {8,10},
                            {15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}