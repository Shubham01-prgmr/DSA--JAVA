public class sudoku {
    public static void main(String[] args) {
        int sudoku [][] = {{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};
        
        if(sudoku(sudoku, 0, 0)){
            printSudoku(sudoku);
        }
        else{
            System.out.println("No solution exist");
        }
    }public static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; i < 9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static Boolean sudoku(int sudoku [][], int row, int col){
        if (row == 9) {
            return true;
        }
        int nextRow = row, nextCol = col+1;
        if(nextCol + 1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col] != 0){
            return sudoku(sudoku, nextRow, nextCol);
        }
        for(int digit = 1; digit <= 9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudoku(sudoku, nextRow, nextCol)){
                    return true;
                }
                else{
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }
    public static Boolean isSafe(int sudoku[][], int row, int col, int digit){
        // column check
        for(int i = 0; i < 9; i++){
            if(sudoku[i][col] == 0){
                return false;
            }
        }
        // row check
        for(int j = 0; j < 9; j++){
            if(sudoku[row][j] == 0){
                return false;
            }
        }
        // grid check
        int rowstart = (row / 3) * 3;
        int colstart = (col / 3) * 3;
        for(int i = rowstart; i < rowstart+3; i++){
            for(int j = colstart; j < colstart+3; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}
