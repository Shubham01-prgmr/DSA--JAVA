import java.util.*;

public class NextGreaterElement {
    public static void nextGreater(int arr[], int nge[]){
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1; i >= 0; i--){

            while(!s.isEmpty() && arr[i] >= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int j = 0; j < nge.length; j++){
            System.out.print(nge[j] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 25};
        int nge[] = new int[arr.length];
        nextGreater(arr, nge);

    }
}
