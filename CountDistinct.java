
import java.util.ArrayList;
import java.util.List;

public class CountDistinct {
    static void subsetSum(int[] arr, int target, int index,
                          List<Integer> current,
                          List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current)); 
            return;
        }
        if (index == arr.length || target < 0) {
            return;
        }

        current.add(arr[index]);
        subsetSum(arr, target - arr[index], index + 1, current, result);

        current.remove(current.size() - 1);

        subsetSum(arr, target, index + 1, current, result);
    }

    public static void main(String[] args) { 

        int[] S = {1, 2, 5, 6, 8};
        int target = 9;

        ArrayList<List<Integer>> result = new ArrayList<>();

        // Function call
        subsetSum(S, target, 0, new ArrayList<>(), result);

        // Output
        if (!result.isEmpty()) {
            System.out.println("Subsets whose sum is " + target + " :");
            for (List<Integer> subset : result) {
                System.out.println(subset);
            }
        } 
        else {
            System.out.println("No solution exists");
        }
    }
}
