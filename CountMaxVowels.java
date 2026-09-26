public class CountMaxVowels{
    public static int maxVowels(String s, int k){
        char arr[] = s.toCharArray();
        int vowelCount = 0;
        int maxVowelCount = 0;

        for(int i = 0; i < k; i++){
            if(isVowel(arr[i])){
                vowelCount++;
            }
        }
        maxVowelCount = vowelCount;

        for(int r = k; r < arr.length; r++){
            if(isVowel(arr[r])){
                vowelCount++;
            }
            if(isVowel(arr[r - k])){
                vowelCount--;
            }
            maxVowelCount = Math.max(vowelCount, maxVowelCount);
        }
        return maxVowelCount;
    }

    public static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u';
    }
    public static void main(String[] args) {
        String s = "abciiidef";
        System.out.print(maxVowels(s, 3));
    }
}