
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        // List<Integer> nums = List.of(5, 2, 8, 1, 10, 15);
        // nums.forEach(System.out::println); 
        // System.out.println(nums);

        // long count = nums.stream().count();
        // System.out.println(count);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(23);
        list.add(67);
        list.add(768);
        list.forEach(System.out::println);
        System.out.println(list);
    }
}