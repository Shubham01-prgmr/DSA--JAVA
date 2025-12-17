public class majorityElement {
    public static void main(String[] args) {
        int arr[] = {2,2,1,1,1,2,2};
        System.out.println(constant_MajorityElement(arr));
    }
    public static int constant_MajorityElement(int arr[]){
        int candidate = 0;
        int vote = 0;
        for(int i : arr){
            if(vote == 0){
                candidate = i;
                vote = 1;
            }
            else if(i == candidate){
                vote++;
            }
            else{
                vote--;
            }
        }
        return candidate;
    }
}
