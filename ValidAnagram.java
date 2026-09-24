import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "race";
        String t = "care";
        System.out.print(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char ch : t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        return map.equals(map2);
        // for(int i = 0; i < t.length(); i++){
        //     char ch = t.charAt(i);
        //     if(map.get(ch) != null){
        //         if(map.get(ch) == 1){
        //             map.remove(ch);
        //         }
        //         else{
        //             map.put(ch, map.get(ch) - 1);
        //         }
        //     }
        //     else{
        //         return false;
        //     }
        // }
        // return map.isEmpty();
    }
}
