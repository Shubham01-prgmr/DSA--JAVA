public class majorityElement {
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,2,1};
        System.out.println(bruteF_MajorityElement(arr));
    }
    public static int bruteF_MajorityElement(int arr[]){
        int n = arr.length;
        int major = n/2;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > major){
                return arr[i];
            }
        }
        return -1;
    }
}
