class Solution {
    
    public void solveSudoku(char[][] board) {
        boolean solved = solve(board);
    }

    static boolean solve(char [][] board){
        int n = board.length;

        // find the first empty square
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '.'){

                    // try all combinations
                    for(char c='1'; c<='9'; c++){

                        if(isSafe(i, j, c, board) == true){
                            board[i][j] = c;
                            if(solve(board) == true) return true;
                            else{
                                // back tracking
                                board[i][j] = '.';
                            }
                        }

                    }

                    // if none of the combinations worked, return false
                    return false;
                }
            }
        }

        // if we reached here means 'false' was never returned in btw so all boxes are filled
        return true;        
    }

    static boolean isSafe(int row, int col, char c, char[][]board){
        int n = board.length;

        for(int i=0; i<n; i++){
            
            // check row
            if(board[row][i] == c) return false;

            // check col
            if(board[i][col] == c) return false;

        }

        // check square
        // eg: 3,6 is first block of square in which 5,7 belongs (all 0 based)
        int start_row = (row/3)*3;
        int start_col = (col/3)*3;

        for(int i=start_row; i<(start_row+3); i++){
            for(int j=start_col; j<(start_col+3); j++){
                if(board[i][j] == c) return false;
            }
        }

        // we never found a repeating char
        return true;
    }
}