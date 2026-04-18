import java.util.HashSet;

public class UnionIntersection {
    public static void unionIntersection(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println("union is: " + set);
        set.clear();

        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }

        // int count = 0;
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < arr2.length; i++){
            if(set.contains(arr2[i])){
                // count++;
                set2.add(arr2[i]);
                // set.remove(arr2[i]);
            }
        }
        System.out.println("intersection is: " + set2);
    }
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {2, 3};
        unionIntersection(arr1, arr2);
    }
}
