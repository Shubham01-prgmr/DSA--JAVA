public class MostWater {
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(pairSum2(height));
    }
    public static int pairSum2(int height[]){
        int start = 0;
        int end = height.length-1;
        int max_water = 0;
        int curr_water = 0;

        while(start !=  end){
            int length = Math.min(height[start], height[end]);
            int breadth = end - start;
            curr_water = length * breadth;
            
            if(height[start] > height[end]){
                end--;
            }
            else{
                start++;
            }

            if(curr_water > max_water){
                max_water = curr_water;
            }
            // Instead of doing this we can create a int water and save length*breadth in that
            //then do math.max(water, max_water) and save it in max_water and return
        }
        return max_water;
    }
}
