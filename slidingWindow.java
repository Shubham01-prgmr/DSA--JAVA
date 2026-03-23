
public class slidingWindow {
    public static void main(String[] args) {
        String str = "1101100111";
        System.out.println(flipAndReturnIndex(str));
    }

    public static String flipAndReturnIndex(String str) {

    int left = 0;
    int count = 0;   
    int ans = 0;    // best window length

    int bestL = 0;  
    int bestR = 0;  

    for (int right = 0; right < str.length(); right++) {

        if (str.charAt(right) == '0') count++;

        while (count > 1) {
            if (str.charAt(left) == '0') count--;
            left++;
        }

        if (right - left + 1 > ans) {
            ans = right - left + 1;
            bestL = left;
            bestR = right;
        }
    }

    char[] arr = str.toCharArray();
    for (int i = bestL; i <= bestR; i++) {
        if (arr[i] == '0') {
            arr[i] = '1';
            break;
        }
    }
    //System.out.println("Output String: " + new String(arr));
    return new String(arr);
}

}
