public class FloodFill {
    public static void main(String[] args) {
        int image[][] = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int orgColor = image[sr][sc];
        if(orgColor != color){
            floodfill(image, sr, sc, color, orgColor);
        }
        printMatrix(image);
    }
    public static void printMatrix(int image[][]){
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        } 
    }
    public static void floodfill(int image[][], int sr, int sc, int color, int orgColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
            image[sr][sc] != orgColor){
                return;
            }
        image[sr][sc] = color;
        //top
        floodfill(image, sr-1, sc, color, orgColor);
        //bottom
        floodfill(image, sr+1, sc, color,  orgColor);
        //left
        floodfill(image,sr, sc-1, color, orgColor);
        //right
        floodfill(image,  sr, sc+1, color,  orgColor);
    }
}
