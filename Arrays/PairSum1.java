import java.util.ArrayList;
public class PairSum1 {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 10;
        System.out.println(pairSum1(list, target));
    }
    public static Boolean pairSum1(ArrayList <Integer> list, int target){
        int left = 0;
        int right = list.size()-1;

        while(left < right){
            if(list.get(left) + list.get(right) == target){
                return true;
            }
            
            if(list.get(left) + list.get(right) > target){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
}
