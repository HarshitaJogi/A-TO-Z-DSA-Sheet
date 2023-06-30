class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char [][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        

        func(0, board, ans);

        return ans;
        
    }

    static void func(int col, char [][] board, List<List<String>> ans){
        int n = board.length;
        if(col == n){
            ans.add(convert_2d_array_to_list(board));
            return;
        }
        
        for(int row=0; row<n; row++){
            if(isSafe(row, col, board) == true){

                // changing r[row][col] to 'Q'
                board[row][col] = 'Q';

                // call the function to place queen at next column
                func(col+1, board, ans);

                // backtracking, so change it back to '.'
                board[row][col] = '.';
            }
        }
    }


    static boolean isSafe(int row, int col, char [][] board){
        int n = board.length;
        int orignal_row = row;
        int orignal_col = col;
        

        // check upper diagonal
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = orignal_row;
        col = orignal_col;
        // check row to left of queen
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = orignal_row;
        col = orignal_col;
        // check lower diagonal
        while(row<n && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }


        return true;

    }


    static List < String > convert_2d_array_to_list(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}