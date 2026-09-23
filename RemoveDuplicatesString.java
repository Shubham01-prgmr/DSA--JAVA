import java.util.LinkedHashSet;

public class RemoveDuplicatesString{
    public static void main(String[] args) {
        String str = "programming";
        System.out.println(removeDupString(str));
    }
    public static String removeDupString(String str){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        char ans[] = str.toCharArray();

        for(char ch : ans){
            set.add(ch);
        }
        return set.toString();
    }
}