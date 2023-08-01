public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nqueens(board, 0));

        
    }
    static int nqueens(boolean[][] board, int r){
        if(r == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        //placing the queen and checking for every row and column
        int count = 0;
        for(int col = 0; col< board.length; col++){
            //place the queen if it is safe
            if(isSafe(board, r, col)){
                board[r][col] = true;
                count += nqueens(board, r+1);
                board[r][col] = false;
            }
        }
        return count;
    }
    private static boolean isSafe(boolean[][] board, int r, int col){
        //check verticle row
        for(int i=0; i<r; i++){
            if(board[i][col]){
                return false;
            }
        }
        //diagonal left
        int maxleft =Math.min(r, col);
        for(int i=1; i<= maxleft; i++){
            if(board[r-i][col-i]){
                return false;
            }
        }
         //diagonal right
         int maxright =Math.min(r, board.length-col-1);
         for(int i=1; i<= maxright; i++){
             if(board[r-i][col+i]){
                 return false;
             }
         }
         return true;

    }
    private static void display(boolean[][] board){
        for(boolean[] r: board){
            for(boolean element : r){
                if(element){
                System.out.print("Q");
            }else{
                System.out.print("X");

            }
        }
        System.out.println();
    }
}
}
