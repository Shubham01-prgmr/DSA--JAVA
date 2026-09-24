import java.util.*;
public class UniqueCharacter {

    public static String helper(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find first non-repeating character
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return String.valueOf(ch);
            }
        }

        return "";
    }

    public static void main(String[] args) {

        String str = "hhello";

        System.out.println(helper(str));
    }
}
