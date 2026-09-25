import java.util.*;
public class LongestSubstringWithourDup{
    public static void main(String[] args) {
      String s = "abcabcbb";
      System.out.print(longestSubstring(s));  
    }
    public static int longestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}