import java.util.HashSet;

public class Hashmap_firstNonRepeat {
    // public static int firstNonRepeating(String str){
    //     HashMap<Character, Integer> map = new HashMap<>();

    //     for(int i = 0; i < str.length(); i++){
    //         char ch = str.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     }
        
    //     // for(char ch : str.toCharArray()){
    //     //     map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     // }

    //     for(int i = 0; i< str.length(); i++){
    //         char ch = str.charAt(i);
    //         if(map.get(ch) == 1){
    //             return i;
    //         }
    //     }
    //     return -1;
       
    // }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        // String str = "leotcede";
        // System.out.println(firstNonRepeating(str));
        System.out.println(findDuplicate(arr));
    }
    public static boolean findDuplicate(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }
            else{
                set.add(arr[i]);
            }
        }
        return false;
    }
}
